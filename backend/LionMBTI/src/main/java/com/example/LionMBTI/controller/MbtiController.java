package com.example.LionMBTI.controller;

import com.example.LionMBTI.dto.MbtiDTO;
import com.example.LionMBTI.service.MbtiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Random;

@RestController
@RequestMapping("/mbti")
public class MbtiController {
    private final MbtiService mbtiService;

    @Autowired
    public MbtiController(MbtiService mbtiService) {
        this.mbtiService = mbtiService;
    }

    @GetMapping
    public ResponseEntity<List<MbtiDTO>> getAllMbti() {
        List<MbtiDTO> mbtiList = mbtiService.getAllMbti();
        return new ResponseEntity<>(mbtiList, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<String> addMbti(@RequestBody MbtiDTO mbtiDTO) {
        mbtiService.addMbti(mbtiDTO);
        return new ResponseEntity<>("MBTI 특징이 추가되었습니다.", HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Integer> deleteMbti(@PathVariable("id") int id) {
        mbtiService.deleteMbti(id);
        return new ResponseEntity<>(id, HttpStatus.OK);
    }

    @GetMapping("/{mbti}")
    public ResponseEntity<MbtiDTO> getMbtiInfo(@PathVariable("mbti") String mbti) {
        List<MbtiDTO> mbtiList = mbtiService.getMbtiByMbti(mbti);
        if (mbtiList.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        MbtiDTO mbtiDTO = getRandomMbti(mbtiList);
        return new ResponseEntity<>(mbtiDTO, HttpStatus.OK);
    }
    
    private MbtiDTO getRandomMbti(List<MbtiDTO> mbtiList) {
        Random random = new Random();
        int index = random.nextInt(mbtiList.size());
        return mbtiList.get(index);
    }
}
