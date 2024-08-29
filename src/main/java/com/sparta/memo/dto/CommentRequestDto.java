package com.sparta.memo.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CommentRequestDto {

    private Long id;
    private String username;
    private String comments;

}
