package com.wanted.pre_onboard.dao;

import com.wanted.pre_onboard.dto.CompanyPostsDto;
import com.wanted.pre_onboard.dto.ReadPostDto;
import com.wanted.pre_onboard.dto.ReadPostsDto;
import org.apache.ibatis.annotations.*;

import java.util.List;

public interface ApplyDao {

    /**
     * 모든 채용 공고 목록을 조회합니다.
     *
     * @return List<ReadPostsDto> 조회된 모든 채용 공고의 목록
     */
    @Select("SELECT p.post_id AS postId, c.company_name AS companyName, co.country_name AS countryName, r.region_name AS regionName, p.position AS position, p.compensation AS compensation, s.skill_name AS skillName" +
            " FROM posts p" +
            " JOIN companies c ON p.company_id = c.company_id" +
            " JOIN countries co ON c.country_id = co.country_id" +
            " JOIN regions r ON c.region_id = r.region_id" +
            " JOIN skills s ON p.skill_id = s.skill_id")
    List<ReadPostsDto> getAllPosts();



    /**
     * 검색 조건에 맞는 채용 공고 목록을 조회합니다.
     *
     * @param value 검색어 (회사명, 국가명, 도시명, 포지션, 기술명 에서 검색)
     * @return List<ReadPostsDto> 검색 조건에 맞는 채용 공고 목록
     */
    @Select("SELECT p.post_id AS postId, c.company_name AS companyName, co.country_name AS countryName, r.region_name AS regionName, p.position AS position, p.compensation AS compensation, s.skill_name AS skillName" +
            " FROM posts p" +
            " JOIN companies c ON p.company_id = c.company_id" +
            " JOIN countries co ON c.country_id = co.country_id" +
            " JOIN regions r ON c.region_id = r.region_id" +
            " JOIN skills s ON p.skill_id = s.skill_id" +
            " WHERE c.company_name LIKE CONCAT('%', #{value}, '%')" +
            " OR co.country_name LIKE CONCAT('%', #{value}, '%')" +
            " OR r.region_name LIKE CONCAT('%', #{value}, '%')" +
            " OR p.position LIKE CONCAT('%', #{value}, '%')" +
            " OR s.skill_name LIKE CONCAT('%', #{value}, '%')")
    List<ReadPostsDto> getSearchPosts(@Param("value") String value);



    /**
     * 지정된 ID에 해당하는 채용 공고의 상세 정보를 조회합니다.
     *
     * @param postId 조회할 채용 공고의 ID
     * @return ReadPostDto 조회된 채용 공고의 상세 정보
     */
    @Select("SELECT p.post_id AS postId, p.company_id AS companyId, c.company_name AS companyName, co.country_name AS countryName, r.region_name AS regionName, p.position AS position, p.compensation AS compensation, s.skill_name AS skillName, p.description AS description" +
            " FROM posts p" +
            " JOIN companies c ON p.company_id = c.company_id" +
            " JOIN countries co ON c.country_id = co.country_id" +
            " JOIN regions r ON c.region_id = r.region_id" +
            " JOIN skills s ON p.skill_id = s.skill_id" +
            " WHERE p.post_id = #{postId}")
    ReadPostDto getPostDetails(@Param("postId") int postId);



    /**
     * 지정된 회사 ID에 해당하는 모든 채용 공고 ID 목록을 조회합니다.
     *
     * @param companyId 조회할 회사의 ID
     * @return List<Integer> 해당 회사의 모든 채용 공고 ID 목록
     */
    @Select("SELECT post_id FROM posts WHERE company_id = #{companyId}")
    List<CompanyPostsDto> getPostIdList(@Param("companyId") int companyId);




    /**
     * 새로운 채용 공고를 데이터베이스에 추가합니다.
     *
     * @param companyId   회사 ID
     * @param skillId     기술 ID
     * @param position    채용 포지션
     * @param compensation 보상 금액
     * @param description 채용 공고 설명
     * @return int 추가된 레코드 수 (성공 시 1, 실패 시 0)
     */
    @Insert("INSERT INTO posts (company_id, skill_id, position, compensation, description) VALUES" +
            " (#{companyId}, #{skillId}, #{position}, #{compensation}, #{description})")
    int addNewPost(@Param("companyId") int companyId,
                   @Param("skillId") int skillId,
                   @Param("position") String position,
                   @Param("compensation") int compensation,
                   @Param("description") String description);



    /**
     * 지정된 게시물 번호에 해당하는 기존 채용 공고를 수정합니다.
     *
     * @param postId      수정할 채용 공고의 ID
     * @param skillId     새로운 기술 ID
     * @param position    새로운 채용 포지션
     * @param compensation 새로운 보상 금액
     * @param description 새로운 채용 공고 설명
     * @return int 수정된 레코드 수 (성공 시 1, 실패 시 0)
     */
    @Update("UPDATE posts SET skill_id = #{skillId}, position = #{position}, compensation = #{compensation}, description = #{description} WHERE post_id = #{postId}")
    int updatePost(@Param("postId") int postId,
                   @Param("skillId") int skillId,
                   @Param("position") String position,
                   @Param("compensation") int compensation,
                   @Param("description") String description);



    /**
     * 지정된 게시물 번호에 해당하는 채용 공고를 삭제합니다.
     *
     * @param postId 삭제할 채용 공고의 ID
     * @return int 삭제된 레코드 수 (성공 시 1, 실패 시 0)
     */
    @Delete("DELETE FROM posts WHERE post_id = #{postId}")
    int deletePost(@Param("postId") int postId);



    /**
     * 사용자가 특정 채용 공고에 지원한 정보를 데이터베이스에 추가합니다.
     *
     * @param postId 지원할 채용 공고의 ID
     * @param userId 지원하는 사용자의 ID
     * @return int 추가된 레코드 수 (성공 시 1, 실패 시 0)
     */
    @Insert("INSERT INTO apply (post_id, user_id) VALUES (#{postId}, #{userId})")
    int apply(@Param("postId") int postId, @Param("userId") int userId);

}
