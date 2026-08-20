package com.subii.typing_trainer.repository;

import com.subii.typing_trainer.model.TypingSession;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


public interface TypingSessionRepository extends JpaRepository<TypingSession, Long> {

    List<TypingSession> findByPassageIdAndTimingArrayJsonIsNotNullOrderByWpmDesc(Long passageId);
    List<TypingSession> findTop10ByOrderByWpmDesc();
}