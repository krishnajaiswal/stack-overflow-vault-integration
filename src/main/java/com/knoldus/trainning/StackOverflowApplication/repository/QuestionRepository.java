package com.knoldus.trainning.StackOverflowApplication.repository;

import com.knoldus.trainning.StackOverflowApplication.entity.Question;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface QuestionRepository extends JpaRepository<Question, Long> {

    Question findByQuestionTitle(String questionTitle);

    List<Question> findByTagId(Long id);

}
