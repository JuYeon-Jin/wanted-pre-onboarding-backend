package com.wanted.pre_onboard.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class UpdatePostDto {
    private int postId;
    private int skillId;
    private String position;
    private int compensation;
    private String description;

    public UpdatePostDto() {
    }
}
