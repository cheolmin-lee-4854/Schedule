package com.sparta.memo.dto;

import com.sparta.memo.entity.Memo;
import lombok.Getter;
import java.time.LocalDateTime;

@Getter
public class MemoResponseDto {
    private Long id;
    private String username;
    private String title; // 제목 필드
    private String contents;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    private LocalDateTime planDate; // 계획 날짜 필드

    public MemoResponseDto(Memo memo) {
        this.id = memo.getId();
        this.username = memo.getUsername();
        this.title = memo.getTitle();
        this.contents = memo.getContents();
        this.createdAt = memo.getCreatedAt();
        this.updatedAt = memo.getUpdatedAt();
        this.planDate = memo.getPlanDate();
    }

    public MemoResponseDto(Long id, String username, String title, String contents, LocalDateTime createdAt, LocalDateTime updatedAt, LocalDateTime planDate) {
        this.id = id;
        this.username = username;
        this.title = title;
        this.contents = contents;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
        this.planDate = planDate;
    }
}
