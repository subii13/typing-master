package com.subii.typing_trainer.repository;

import com.subii.typing_trainer.model.TypingSession;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface TypingSessionRepository extends JpaRepository<TypingSession, Long> {

    List<TypingSession> findByPassageIdOrderByWpmDesc(Long passageId);
}