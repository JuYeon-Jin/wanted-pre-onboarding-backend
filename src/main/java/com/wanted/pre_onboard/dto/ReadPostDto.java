package com.wanted.pre_onboard.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
public class ReadPostDto {
    private int postId;
    private int companyId;
    private String companyName;
    private String countryName;
    private String regionName;
    private String position;
    private int compensation;
    private String skillName;
    private String description;
    private List<CompanyPostsDto> postIdList;

    // 기본 생성자
    public ReadPostDto() {
    }
}
