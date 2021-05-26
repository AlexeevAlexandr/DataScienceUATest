package com.DataScienceUATest.repository;

import com.DataScienceUATest.model.Fio;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FioRepository  extends JpaRepository<Fio, Integer> {
}
