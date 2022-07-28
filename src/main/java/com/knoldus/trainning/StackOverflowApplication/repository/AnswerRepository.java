package com.knoldus.trainning.StackOverflowApplication.repository;

import com.knoldus.trainning.StackOverflowApplication.entity.Answer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AnswerRepository extends JpaRepository<Answer, Long> {
  List<Answer> findByQuestionId(Long questionId);

  Answer findByInputAnswer(String inputAnswer);
}
