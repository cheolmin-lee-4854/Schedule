package com.sparta.memo.dto;

import lombok.Getter;
import lombok.Setter;
import java.time.LocalDateTime;

@Getter
@Setter
public class MemoRequestDto {
    private String username;
    private String contents;
    private String title;  // 제목 필드
    private LocalDateTime planDate; // 계획 날짜 필드
}
