package com.sparta.memo.service;

import com.sparta.memo.dto.MemoRequestDto;
import com.sparta.memo.dto.MemoResponseDto;
import com.sparta.memo.entity.Memo;
import com.sparta.memo.repository.MemoRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class MemoService {

    private final MemoRepository memoRepository;

    public MemoService(MemoRepository memoRepository) {
        this.memoRepository = memoRepository;
    }

    public MemoResponseDto createMemo(MemoRequestDto requestDto) {
        Memo memo = new Memo(requestDto);
        memo.setCreatedAt(LocalDateTime.now()); // Set createdAt to the current time
        memo.setUpdatedAt(LocalDateTime.now()); // Set updatedAt to the current time
        Memo savedMemo = memoRepository.save(memo);
        return new MemoResponseDto(savedMemo);
    }

    public List<MemoResponseDto> getMemos() {
        return memoRepository.findAll().stream()
                .map(MemoResponseDto::new)
                .collect(Collectors.toList());
    }

    public MemoResponseDto getMemoById(Long id) {
        Memo memo = memoRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("선택한 메모는 존재하지 않습니다."));
        return new MemoResponseDto(memo);
    }

    public Long updateMemo(Long id, MemoRequestDto requestDto) {
        Memo memo = memoRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("선택한 메모는 존재하지 않습니다."));
        memo.update(requestDto);
        memo.setUpdatedAt(LocalDateTime.now()); // Update updatedAt to the current time
        memoRepository.save(memo);
        return id;
    }

    public Long deleteMemo(Long id) {
        Memo memo = memoRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("선택한 메모는 존재하지 않습니다."));
        memoRepository.delete(memo);
        return id;
    }
}
