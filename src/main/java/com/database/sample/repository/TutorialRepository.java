package com.database.sample.repository;

import com.database.sample.entity.TutorialEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TutorialRepository extends JpaRepository<TutorialEntity, Long> {

    List<TutorialEntity> findByTitleContainingIgnoreCase(String title);


}
