package com.subii.typing_trainer.repository;

import com.subii.typing_trainer.model.Passage;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PassageRepository extends JpaRepository<Passage, Long> {
}