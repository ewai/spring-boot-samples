package com.example.samples.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.samples.domain.Sample;
import com.example.samples.domain.SampleRepository;

@Service
public class SampleService {

    @Autowired
    SampleRepository sampleRepository;

    public List<Sample> findAll() {
      return sampleRepository.findAll();
    }
}
