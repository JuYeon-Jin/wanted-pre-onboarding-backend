package com.wanted.pre_onboard.service;

import com.wanted.pre_onboard.dao.ApplyDao;
import com.wanted.pre_onboard.dto.*;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ApplyService {

    private final ApplyDao applyDao;

    public ApplyService(ApplyDao applyDao) {
        this.applyDao = applyDao;
    }

    /**
     * 새로운 채용 공고를 등록합니다.
     *
     * @param dto 등록할 채용 공고의 정보를 담고 있는 InsertPostDto 객체
     * @return boolean 등록 성공 여부를 반환
     */
    public boolean insertPost(InsertPostDto dto) {
        int companyId = dto.getCompanyId();
        int skillId = dto.getSkillId();
        String position = dto.getPosition();
        int compensation = dto.getCompensation();
        String description = dto.getDescription();

        return applyDao.addNewPost(companyId, skillId, position, compensation, description) > 0;
    }

    /**
     * 지정된 ID의 채용 공고를 수정합니다.
     *
     * @param dto 수정할 채용 공고의 정보를 담고 있는 UpdatePostDto 객체
     * @return boolean 수정 성공 여부를 반환
     */
    public boolean updatePost(UpdatePostDto dto) {
        int postId = dto.getPostId();
        int skillId = dto.getSkillId();
        String position = dto.getPosition();
        int compensation = dto.getCompensation();
        String description = dto.getDescription();

        return applyDao.updatePost(postId, skillId, position, compensation, description) > 0;
    }

    /**
     * 지정된 ID의 채용 공고를 삭제합니다.
     *
     * @param postId 삭제할 채용 공고의 ID
     * @return boolean 삭제 성공 여부를 반환
     */
    public boolean deletePost(int postId) {
        return applyDao.deletePost(postId) > 0;
    }

    /**
     * 모든 채용 공고 목록을 조회합니다.
     *
     * @return List<ReadPostsDto> 조회된 채용 공고 목록을 반환
     */
    public List<ReadPostsDto> getAllPosts() {
        return applyDao.getAllPosts();
    }

    /**
     * 검색어를 기준으로 채용 공고 목록을 조회합니다.
     * 회사명, 국가, 도시, 사용 기술, 채용 포지션 등의 필드에서 검색어가 포함된 공고를 반환합니다.
     *
     * @param value 검색어로 사용할 문자열
     * @return List<ReadPostsDto> 검색된 채용 공고 목록을 반환
     */
    public List<ReadPostsDto> getSearchPosts(String value) {
        return applyDao.getSearchPosts(value);
    }

    /**
     * 지정된 ID의 채용 공고에 대한 상세 정보를 조회합니다.
     * 해당 회사의 다른 채용 공고 목록도 함께 반환됩니다.
     *
     * @param postId 조회할 채용 공고의 ID
     * @return ReadPostDto 조회된 채용 공고의 상세 정보를 반환
     */
    public ReadPostDto getPost(int postId) {
        ReadPostDto dto = applyDao.getPostDetails(postId);
        dto.setPostIdList(applyDao.getPostIdList(dto.getCompanyId()));
        return dto;
    }

    /**
     * 사용자가 채용 공고에 지원합니다. 사용자는 각 공고에 한 번만 지원할 수 있습니다.
     *
     * @param dto 사용자의 지원 정보를 담고 있는 ApplyDto 객체
     * @return boolean 지원 성공 여부를 반환
     */
    public boolean apply(ApplyDto dto) {
        return applyDao.apply(dto.getPostId(), dto.getUserId()) > 0;
    }
}
