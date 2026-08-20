package com.subii.typing_trainer;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.subii.typing_trainer.model.TypingSession;
import com.subii.typing_trainer.repository.TypingSessionRepository;
import org.springframework.web.bind.annotation.*;
import com.subii.typing_trainer.service.HeatmapService;

import java.util.List;
import java.util.Map;

@RestController
public class SessionController {

    private final TypingSessionRepository sessionRepository;
    private final ObjectMapper mapper = new ObjectMapper();
    private final HeatmapService heatmapService;

    public SessionController(TypingSessionRepository sessionRepository,
        HeatmapService heatmapService) {
        this.sessionRepository = sessionRepository;
        this.heatmapService=heatmapService;
    }

    @PostMapping("/api/sessions")
    public TypingSession submit(@RequestBody Map<String, Object> body) throws Exception {
        TypingSession session = new TypingSession();
        session.setPassageId(Long.valueOf(body.get("passageId").toString()));
        session.setWpm(Double.parseDouble(body.get("wpm").toString()));
        session.setAccuracy(Double.parseDouble(body.get("accuracy").toString()));

        Object errors = body.get("errorsByChar");
        session.setErrorsByCharJson(mapper.writeValueAsString(errors));
        Object timings = body.get("charTimings");
        session.setTimingArrayJson(mapper.writeValueAsString(timings));

return sessionRepository.save(session);
    }

    @GetMapping("/api/sessions")
    public List<TypingSession> all() {
        return sessionRepository.findAll();
    }
    @GetMapping("/api/sessions/heatmap")
    public Map<String, Integer> heatmap() {
    return heatmapService.aggregate();
    }
    @GetMapping("/api/sessions/leaderboard")
public List<TypingSession> leaderboard() {
    return sessionRepository.findTop10ByOrderByWpmDesc();
}

   @GetMapping("/api/sessions/ghost/{passageId}")
    public TypingSession ghost(@PathVariable Long passageId) {
    List<TypingSession> sessions = sessionRepository.findByPassageIdAndTimingArrayJsonIsNotNullOrderByWpmDesc(passageId);
    return sessions.isEmpty() ? null : sessions.get(0);
}
}