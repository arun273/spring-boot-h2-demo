package com.database.sample.service;

import com.database.sample.entity.TutorialEntity;
import com.database.sample.model.Tutorial;
import com.database.sample.repository.TutorialRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TutorialService {

    @Autowired
    private TutorialRepository tutorialRepository;

    public Tutorial createTutorial(Tutorial tutorial) {
        TutorialEntity tutorialEntity = tutorialRepository.save(new TutorialEntity(tutorial.getTitle(), tutorial.getDescription(), false));
        return new Tutorial(tutorialEntity.getId(), tutorialEntity.getTitle(), tutorialEntity.getDescription(), tutorialEntity.isPublished());
    }

    public List<Tutorial> getAllTutorials(String title) {
        List<TutorialEntity> tutorialEntities = new ArrayList<>();
        if (title == null) tutorialEntities.addAll(tutorialRepository.findAll());
        else tutorialEntities.addAll(tutorialRepository.findByTitleContainingIgnoreCase(title));
        return mapEntityToModel(tutorialEntities);
    }

    private List<Tutorial> mapEntityToModel(List<TutorialEntity> tutorialEntities) {
        List<Tutorial> tutorials = tutorialEntities.stream().map(tutorialEntity -> new Tutorial(tutorialEntity.getId(), tutorialEntity.getTitle(), tutorialEntity.getDescription(), tutorialEntity.isPublished())).toList();
        return tutorials;
    }

   /* public ResponseEntity<Tutorial> getTutorialById(@PathVariable("id") long id) {
        Optional<Tutorial> tutorialData = tutorialRepository.findById(id);

        if (tutorialData.isPresent()) {
            return new ResponseEntity<>(tutorialData.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }



    @PutMapping("/tutorials/{id}")
    public ResponseEntity<Tutorial> updateTutorial(@PathVariable("id") long id, @RequestBody Tutorial tutorial) {
        Optional<Tutorial> tutorialData = tutorialRepository.findById(id);

        if (tutorialData.isPresent()) {
            Tutorial _tutorial = tutorialData.get();
            _tutorial.setTitle(tutorial.getTitle());
            _tutorial.setDescription(tutorial.getDescription());
            _tutorial.setPublished(tutorial.isPublished());
            return new ResponseEntity<>(tutorialRepository.save(_tutorial), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/tutorials/{id}")
    public ResponseEntity<HttpStatus> deleteTutorial(@PathVariable("id") long id) {
        try {
            tutorialRepository.deleteById(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/tutorials")
    public ResponseEntity<HttpStatus> deleteAllTutorials() {
        try {
            tutorialRepository.deleteAll();
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }

    @GetMapping("/tutorials/published")
    public ResponseEntity<List<Tutorial>> findByPublished() {
        try {
            List<Tutorial> tutorials = tutorialRepository.findByPublished(true);

            if (tutorials.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
            return new ResponseEntity<>(tutorials, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }*/
}
