package com.knoldus.trainning.StackOverflowApplication.controller;

import com.knoldus.trainning.StackOverflowApplication.entity.Question;
import com.knoldus.trainning.StackOverflowApplication.service.QuestionService;
import com.knoldus.trainning.StackOverflowApplication.service.TagService;
import com.knoldus.trainning.StackOverflowApplication.vo.request.QuestionViewRequest;
import com.knoldus.trainning.StackOverflowApplication.vo.responce.QuestionResponce;
import com.knoldus.trainning.StackOverflowApplication.vo.responce.QuestionResponeWithView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/user/question")
public class QuestionController {

  @Autowired
  private TagService tagService;

  @Autowired
  private QuestionService questionService;

  static Long totalNumberOfViews = 0l;

  @PostMapping("/add")
  public Long addNewQuestion(@RequestBody QuestionViewRequest questionViewRequest) {
    return questionService.save(questionViewRequest);
  }

  @GetMapping("/get/{id}")
  public QuestionResponeWithView getQuestionByIds(@PathVariable Long id) {
    totalNumberOfViews++;
    QuestionResponeWithView questionResponce = new QuestionResponeWithView();
    Optional<Question> optionalEntity =  questionService.getQuestionById(id);
    Question question = optionalEntity.get();
    questionResponce.setTagName(question.getTag().getName());
    questionResponce.setId(question.getId());
    questionResponce.setTotalNumberOfViews(totalNumberOfViews);
    questionResponce.setQuestionTitle(question.getQuestionTitle());
    questionResponce.setQuestionDescription(question.getQuestionDescription());
    questionResponce.setCreatedAt(question.getCreatedAt());
    questionResponce.setUpdatedAt(question.getUpdatedAt());
    return questionResponce;
  }

  @DeleteMapping("/delete/{id}")
  public void deleteQuestionById(@PathVariable Long id) {
    questionService.deleteById(id);
  }

  @PutMapping("/update/{id}")
  public QuestionResponce updateQuestionById(@PathVariable(value = "id") Long id,
                                 @RequestBody QuestionViewRequest questionViewRequest) {
    return questionService.updateQuestion(id, questionViewRequest);
  }

  @GetMapping("/getAll")
  public List<QuestionResponce> getAllQuestions() {
    return questionService.getAllQuestions();
  }

}
