package com.subii.typing_trainer.repository;

import com.subii.typing_trainer.model.TypingSession;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TypingSessionRepository extends JpaRepository<TypingSession, Long> {
}