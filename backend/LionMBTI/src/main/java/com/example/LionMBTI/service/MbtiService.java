package com.example.LionMBTI.service;

import com.example.LionMBTI.dto.MbtiDTO;

import java.util.List;

public interface MbtiService {
    List<MbtiDTO> getAllMbti();

    void addMbti(MbtiDTO mbtiDTO);

    void deleteMbti(int id);

    List<MbtiDTO> getMbtiByMbti(String mbti);
}
