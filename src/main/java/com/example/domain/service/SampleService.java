package com.example.domain.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.domain.model.Sample;
import com.example.domain.repository.SampleRepository;

@Service
public class SampleService {

    @Autowired
    SampleRepository sampleRepository;

    public List<Sample> findAll() {
      return sampleRepository.findAll();
    }
}
