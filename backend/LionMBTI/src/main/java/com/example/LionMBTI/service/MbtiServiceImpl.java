package com.example.LionMBTI.service;

import com.example.LionMBTI.dto.MbtiDTO;
import com.example.LionMBTI.entity.Mbti;
import com.example.LionMBTI.repository.MbtiRepository;
import com.example.LionMBTI.exception.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class MbtiServiceImpl implements MbtiService {
    private final MbtiRepository mbtiRepository;

    @Autowired
    public MbtiServiceImpl(MbtiRepository mbtiRepository) {
        this.mbtiRepository = mbtiRepository;
    }

    @Override
    public List<MbtiDTO> getAllMbti() {
        List<Mbti> mbtiList = mbtiRepository.findAll();
        return mbtiList.stream().map(this::convertToDto).collect(Collectors.toList());
    }

    @Override
    public void addMbti(MbtiDTO mbtiDTO) {
        Mbti mbti = convertToEntity(mbtiDTO);
        mbtiRepository.save(mbti);
    }

    @Override
    public void deleteMbti(int id) {
        mbtiRepository.deleteById(id);
    }

    @Override
    public List<MbtiDTO> getMbtiByMbti(String mbti) {
        List<Mbti> mbtiList = mbtiRepository.findByMbti(mbti);
        if (mbtiList.isEmpty()) {
            throw new NotFoundException("MBTI가 잘못되었거나 해당 MBTI 정보가 없습니다.");
        }

        return mbtiList.stream().map(this::convertToDto).collect(Collectors.toList());
    }


    private MbtiDTO convertToDto(Mbti mbti) {
        MbtiDTO dto = new MbtiDTO();
        dto.setId(mbti.getId());
        dto.setMbti(mbti.getMbti());
        dto.setInfo(mbti.getInfo());
        return dto;
    }

    private Mbti convertToEntity(MbtiDTO mbtiDTO) {
        Mbti mbti = new Mbti();
        mbti.setMbti(mbtiDTO.getMbti().toUpperCase());
        mbti.setInfo(mbtiDTO.getInfo());
        return mbti;
    }
}
