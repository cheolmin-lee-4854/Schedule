package com.sparta.memo.repository;

import com.sparta.memo.entity.Memo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MemoRepository extends JpaRepository<Memo, Long> {
    // JpaRepository가 기본 CRUD 메서드를 제공하므로 추가적인 메서드는 필요 없습니다.
}
