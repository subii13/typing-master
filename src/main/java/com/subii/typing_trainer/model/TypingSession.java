package com.subii.typing_trainer.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class TypingSession {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long passageId;
    private double wpm;
    private double accuracy;

    public TypingSession() {}

    public TypingSession(Long passageId, double wpm, double accuracy) {
        this.passageId = passageId;
        this.wpm = wpm;
        this.accuracy = accuracy;
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public Long getPassageId() { return passageId; }
    public void setPassageId(Long passageId) { this.passageId = passageId; }

    public double getWpm() { return wpm; }
    public void setWpm(double wpm) { this.wpm = wpm; }

    public double getAccuracy() { return accuracy; }
    public void setAccuracy(double accuracy) { this.accuracy = accuracy; }
}