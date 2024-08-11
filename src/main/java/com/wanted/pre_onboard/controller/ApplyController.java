package com.wanted.pre_onboard.controller;

import com.wanted.pre_onboard.dto.ApplyDto;
import com.wanted.pre_onboard.dto.InsertPostDto;
import com.wanted.pre_onboard.dto.UpdatePostDto;
import com.wanted.pre_onboard.service.ApplyService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
public class ApplyController {

    private final ApplyService applyService;

    public ApplyController(ApplyService applyService) {
        this.applyService = applyService;
    }

    /**
     * 채용 공고를 등록하는 메소드입니다.
     *
     * @param dto 등록할 채용 공고의 정보를 담고 있는 InsertPostDto 객체
     * @return ResponseEntity<?> 등록된 채용 공고 정보를 담은 ResponseEntity 객체
     */
    @PostMapping("/posts")
    public ResponseEntity<?> insertPost(@RequestBody InsertPostDto dto) {
        try {
            return ResponseEntity.ok(applyService.insertPost(dto));
        } catch (Exception e) {
            log.error(e.getLocalizedMessage());
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("채용 공고 등록 중 오류가 발생했습니다. 확인 후 다시 시도해 주세요.");
        }
    }

    /**
     * 채용 공고를 수정하는 메소드입니다.
     *
     * @param dto 수정할 채용 공고의 정보를 담고 있는 UpdatePostDto 객체
     * @return ResponseEntity<?> 수정된 채용 공고 정보를 담은 ResponseEntity 객체
     */
    @PutMapping("/posts")
    public ResponseEntity<?> updatePost(@RequestBody UpdatePostDto dto) {
        try {
            return ResponseEntity.ok(applyService.updatePost(dto));
        } catch (Exception e) {
            log.error(e.getLocalizedMessage());
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("채용 공고 수정 중 오류가 발생했습니다. 확인 후 다시 시도해 주세요.");
        }
    }

    /**
     * 채용 공고를 삭제하는 메소드입니다.
     *
     * @param postId 삭제할 채용 공고의 ID
     * @return ResponseEntity<?> 삭제 결과를 담은 ResponseEntity 객체
     */
    @DeleteMapping("/posts/{postId}")
    public ResponseEntity<?> deletePost(@PathVariable int postId) {
        try {
            return ResponseEntity.ok(applyService.deletePost(postId));
        } catch (Exception e) {
            log.error(e.getLocalizedMessage());
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("채용 공고 삭제 중 오류가 발생했습니다. 확인 후 다시 시도해 주세요.");
        }
    }

    /**
     * 채용 공고 목록을 조회하는 메소드입니다. 검색 기능을 지원합니다.
     * 검색 파라미터가 주어지지 않으면 전체 채용 공고 목록을 반환합니다.
     * 검색 파라미터 `search` 를 통해 회사명, 국가, 도시, 사용 기술, 채용 포지션 필드에서 해당 값이 포함된 채용 공고를 조회합니다.
     *
     * @param value 검색어로 사용될 값 (선택 사항). 검색어가 주어지면 해당 검색어가 포함된 채용 공고를 조회합니다.
     * @return ResponseEntity<?> 조회된 채용 공고 목록을 담은 ResponseEntity 객체
     */
    @GetMapping("/posts")
    public ResponseEntity<?> readPosts(@RequestParam(value = "search", required = false) String value) {
        if (value == null) {
            return ResponseEntity.ok(applyService.getAllPosts());
        } else {
            return ResponseEntity.ok(applyService.getSearchPosts(value));
        }
    }

    /**
     * 특정 채용 공고의 상세 정보를 조회하는 메소드입니다.
     *
     * @param postId 조회할 채용 공고의 ID
     * @return ResponseEntity<?> 조회된 채용 공고의 상세 정보를 담은 ResponseEntity 객체
     */
    @GetMapping("/post/{postId}")
    public ResponseEntity<?> readPost(@PathVariable int postId) {
        return ResponseEntity.ok(applyService.getPost(postId));
    }

    /**
     * 사용자가 채용 공고에 지원하는 메소드입니다. 사용자는 한 번만 지원 가능합니다.
     *
     * @param dto 사용자의 지원 정보를 담고 있는 ApplyDto 객체
     * @return ResponseEntity<?> 지원 결과를 담은 ResponseEntity 객체
     */
    @PostMapping("/apply")
    public ResponseEntity<?> apply(@RequestBody ApplyDto dto) {
        try {
            return ResponseEntity.ok(applyService.apply(dto));
        } catch (Exception e) {
            log.error(e.getLocalizedMessage());
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("채용 공고 지원 중 오류가 발생했습니다. 확인 후 다시 시도해 주세요.");
        }
    }

}
