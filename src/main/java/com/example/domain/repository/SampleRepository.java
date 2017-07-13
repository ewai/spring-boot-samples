package com.example.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.domain.model.Sample;

@Repository
public interface SampleRepository extends JpaRepository<Sample, String> {
}
