package com.example.LionMBTI.repository;

import com.example.LionMBTI.entity.Mbti;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MbtiRepository extends JpaRepository<Mbti, Integer> {
    List<Mbti> findByMbti(String mbti);
}
