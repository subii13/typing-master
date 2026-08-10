package com.subii.typing_trainer;

import com.subii.typing_trainer.model.TypingSession;
import com.subii.typing_trainer.repository.TypingSessionRepository;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;
import java.util.List;

@RestController
public class SessionController {

    private final TypingSessionRepository sessionRepository;

    public SessionController(TypingSessionRepository sessionRepository) {
        this.sessionRepository = sessionRepository;
    }

    @PostMapping("/api/sessions")
    public TypingSession submit(@RequestBody TypingSession session) {
        return sessionRepository.save(session);
    }
    @GetMapping("/api/sessions")
public List<TypingSession> all() {
    return sessionRepository.findAll();
}
}