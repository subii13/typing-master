package com.subii.typing_trainer.service;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.subii.typing_trainer.model.TypingSession;
import com.subii.typing_trainer.repository.TypingSessionRepository;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class HeatmapService {

    private final TypingSessionRepository sessionRepository;
    private final ObjectMapper mapper = new ObjectMapper();

    public HeatmapService(TypingSessionRepository sessionRepository) {
        this.sessionRepository = sessionRepository;
    }

    public Map<String, Integer> aggregate() {
        Map<String, Integer> totals = new HashMap<>();

        for (TypingSession session : sessionRepository.findAll()) {
            String json = session.getErrorsByCharJson();
            if (json == null) continue;

            try {
                Map<String, Integer> sessionErrors = mapper.readValue(json, new TypeReference<>() {});
                for (Map.Entry<String, Integer> entry : sessionErrors.entrySet()) {
                    totals.merge(entry.getKey(), entry.getValue(), Integer::sum);
                }
            } catch (Exception e) {
                // skip malformed rows
            }
        }

        return totals;
    }
}