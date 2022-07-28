package com.knoldus.trainning.StackOverflowApplication.service;

import com.knoldus.trainning.StackOverflowApplication.entity.Question;
import com.knoldus.trainning.StackOverflowApplication.entity.Tag;
import com.knoldus.trainning.StackOverflowApplication.exception.ResourceNotFoundException;
import com.knoldus.trainning.StackOverflowApplication.repository.QuestionRepository;
import com.knoldus.trainning.StackOverflowApplication.vo.request.QuestionViewRequest;
import com.knoldus.trainning.StackOverflowApplication.vo.responce.QuestionResponce;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class QuestionService {

  @Autowired
  private AnswerService answerService;

  @Autowired
  private TagService tagService;

    @Autowired
    private QuestionRepository questionRepository;

    List<Question> questionsList = new ArrayList<>();

    public Long save(QuestionViewRequest questionViewRequest) {

      Question question = new Question();
      Tag tag1 = tagService.save(questionViewRequest.getTagName());
      question.setQuestionTitle(questionViewRequest.getQuestionTitle());
      question.setQuestionDescription(questionViewRequest.getQuestionDescription());
      question.setTag(tag1);
      questionRepository.save(question);
      Question savedQuestion =
              questionRepository.findByQuestionTitle(questionViewRequest.getQuestionTitle());
      Long questionId = savedQuestion.getId();
      return questionId;
    }

    public List<QuestionResponce> getAllQuestions() {
      List<QuestionResponce> questionResponceList = new ArrayList<>();
      List<Question> questionList = questionRepository.findAll();
      for(Question question : questionList) {
        QuestionResponce questionResponce = new QuestionResponce();
        Tag tag = question.getTag();
        questionResponce.setId(question.getId());
        questionResponce.setQuestionTitle(question.getQuestionTitle());
        questionResponce.setQuestionDescription(question.getQuestionDescription());
        questionResponce.setTagName(tag.getName());
        questionResponce.setCreatedAt(question.getCreatedAt());
        questionResponce.setUpdatedAt(question.getUpdatedAt());
        questionResponceList.add(questionResponce);
      }
      return questionResponceList;
    }

    public Optional<Question> getQuestionById(Long id) {
      return questionRepository.findById(id);
    }

    public void deleteById(Long id) {
      questionRepository.deleteById(id);
    }

    public QuestionResponce updateQuestion(Long id, QuestionViewRequest request) {
      Optional<Question> optionalEntity =  questionRepository.findById(id);
      Question question1 = optionalEntity.get();
      QuestionResponce questionResponce = new QuestionResponce();
      return questionRepository.findById(id).map(question -> {
        question.setQuestionTitle(request.getQuestionTitle());
        question.setQuestionDescription(request.getQuestionDescription());
        Tag tag = tagService.updateTag(question1.getTag(), request.getTagName());
        question.setTag(tag);
        questionRepository.save(question);
        questionResponce.setId(question1.getId());
        questionResponce.setQuestionTitle(request.getQuestionTitle());
        questionResponce.setQuestionDescription(request.getQuestionDescription());
        questionResponce.setCreatedAt(question1.getCreatedAt());
        questionResponce.setUpdatedAt(question1.getUpdatedAt());
        return questionResponce;
      }).orElseThrow(() -> new ResourceNotFoundException("Question with id : " + id + " not found"));
    }

  public List<Question> findAllQuestionByTagId(Long tagId) {
      List<Question> questionList = questionRepository.findByTagId(tagId);
      return questionList;
  }
}
