package com.wanted.pre_onboard.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class ApplyDto {
    private int postId;
    private int userId;

    public ApplyDto() {
    }
}
