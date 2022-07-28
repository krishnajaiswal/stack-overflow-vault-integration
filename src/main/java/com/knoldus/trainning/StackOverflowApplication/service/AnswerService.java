package com.knoldus.trainning.StackOverflowApplication.service;

import com.knoldus.trainning.StackOverflowApplication.entity.Answer;
import com.knoldus.trainning.StackOverflowApplication.entity.Question;
import com.knoldus.trainning.StackOverflowApplication.exception.ResourceNotFoundException;
import com.knoldus.trainning.StackOverflowApplication.repository.AnswerRepository;
import com.knoldus.trainning.StackOverflowApplication.vo.request.AnswerViewRequest;
import com.knoldus.trainning.StackOverflowApplication.vo.responce.AnswerResponce;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class AnswerService {

  @Autowired
  private QuestionService questionService;

  @Autowired private AnswerRepository answerRepository;

  public List<AnswerResponce> getAllAnswers(Long questionId) {
    List<AnswerResponce> answerResponceList = new ArrayList<>();
    List<Answer> answerList = answerRepository.findByQuestionId(questionId);
    for(Answer answer : answerList) {
      AnswerResponce answerResponce = new AnswerResponce();
      answerResponce.setInputAnswer(answer.getInputAnswer());
      answerResponce.setQuestionId(questionId);
      answerResponce.setCreatedAt(answer.getCreatedAt());
      answerResponce.setUpdatedAt(answer.getUpdatedAt());
      answerResponceList.add(answerResponce);
    }
    return answerResponceList;
  }

  public Long save(AnswerViewRequest answerViewRequest) {
    System.out.println("Inside save");
    Answer answer = new Answer();
    answer.setInputAnswer(answerViewRequest.getInputAnswer());
    Optional<Question> optionalEntity =
            questionService.getQuestionById(answerViewRequest.getQuestionId());
    Question roomEntity = optionalEntity.get();
    System.out.println(roomEntity);
    answer.setQuestion(roomEntity);
    if(questionService.getQuestionById(answerViewRequest.getQuestionId()) != null) {
      answerRepository.save(answer);
    } else {
      System.out.println("Question does not exist");
    }
    Answer savedAnswer =
            answerRepository.findByInputAnswer(answerViewRequest.getInputAnswer());
    Long answerIds = savedAnswer.getId();
    return answerIds;
  }

  public AnswerResponce updateAnswer(Long id, AnswerViewRequest request) {
    AnswerResponce answerResponce = new AnswerResponce();
    return answerRepository.findById(id).map(answer -> {
      answer.setInputAnswer(request.getInputAnswer());
      Optional<Answer> optionalEntity =  answerRepository.findById(id);
      Answer answer2 = optionalEntity.get();
      answer.setQuestion(answer2.getQuestion());
      answerRepository.save(answer);
      Optional<Answer> optionalEntitys =  answerRepository.findById(id);
      Answer answer1 = optionalEntitys.get();
      answerResponce.setQuestionId(id);
      answerResponce.setInputAnswer(request.getInputAnswer());
      answerResponce.setCreatedAt(answer1.getCreatedAt());
      answerResponce.setUpdatedAt(answer1.getUpdatedAt());
      return answerResponce;
    }).orElseThrow(() -> new ResourceNotFoundException("Question with id : " + id + " not found"));
  }

  public void deleteAnswer(Long id) {
    answerRepository.deleteById(id);
  }

  public Optional<Answer> getAnswersById(Long id) {
    return answerRepository.findById(id);
  }
}
