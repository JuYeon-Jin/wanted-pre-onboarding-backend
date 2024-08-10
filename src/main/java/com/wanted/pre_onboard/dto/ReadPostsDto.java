package com.wanted.pre_onboard.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class ReadPostsDto {
    private int postId;
    private String companyName;
    private String countryName;
    private String regionName;
    private String position;
    private int compensation;
    private String skillName;

    // 기본 생성자
    public ReadPostsDto() {
    }
}
