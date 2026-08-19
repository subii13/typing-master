package com.subii.typing_trainer;

import com.subii.typing_trainer.model.Passage;
import com.subii.typing_trainer.repository.PassageRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class PassageController {

    private final PassageRepository passageRepository;

    // Spring sees this constructor and automatically passes in
    // the PassageRepository it created for you — you never call "new" yourself.
    public PassageController(PassageRepository passageRepository) {
        this.passageRepository = passageRepository;
    }

    @GetMapping("/api/passages/random")
    public Passage randomPassage() {
        List<Passage> all = passageRepository.findAll();
        int index = (int) (Math.random() * all.size());
        return all.get(index);
    }
    @PostMapping("/api/passages")
    public Passage create(@RequestBody Passage passage) {
        return passageRepository.save(passage);
    }
}