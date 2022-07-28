package com.knoldus.trainning.StackOverflowApplication.service;

import com.knoldus.trainning.StackOverflowApplication.entity.Question;
import com.knoldus.trainning.StackOverflowApplication.entity.Tag;
import com.knoldus.trainning.StackOverflowApplication.repository.TagRepository;
import com.knoldus.trainning.StackOverflowApplication.vo.responce.AnswerResponce;
import com.knoldus.trainning.StackOverflowApplication.vo.responce.TagResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class TagService {

    @Autowired
    private TagRepository tagRepository;

    @Autowired
    private QuestionService questionService;

    @Autowired
    private AnswerService answerService;

    List<Tag> tagList = new ArrayList<>();

    public Optional<Tag> getAllTag(Long tagId) {
        return tagRepository.findById(tagId);
    }


    public List<Tag> getAllTagsList() {
        tagList = (List<Tag>) tagRepository.findAll();
        return tagList;
    }


    public Tag save(String tagName) {
        if(tagRepository.findByName(tagName) != null) {
            Optional<Tag> optionalTag = Optional.of(tagRepository.findByName(tagName));
            Tag existingTag = optionalTag.get();
            return existingTag;
        } else {
            Tag tag = new Tag();
            tag.setName(tagName);
            tagRepository.save(tag);
            return tag;
        }
    }

    public void deleteById(Tag tag) {
        Optional<Tag> optionalTag = Optional.of(tagRepository.findByName(tag.getName()));
        Tag existingTag = optionalTag.get();
        tagRepository.deleteById(existingTag.getId());
    }

    public Optional<Tag> getAllTagById(Long id) {
        return tagRepository.findById(id);
    }


    public Tag findByTagName(String name) {
        Optional<Tag> optionalTag = Optional.of(tagRepository.findByName(name));
        Tag tag = optionalTag.get();
        return tag;
    }

    public Tag updateTag(Tag existingTag, String tagName) {
        Optional<Tag> optionalTag = tagRepository.findById(existingTag.getId());
        Tag tag = optionalTag.get();
        tag.setName(tagName);
        tagRepository.save(tag);
        System.out.println(tag);

        return tag;
    }

    public List<TagResponse> findTagIdByName(String string) {
        List<TagResponse> tagResponseList = new ArrayList<>();
        Optional<Tag> optionalTag = Optional.of(tagRepository.findByName(string));
        Tag tag = optionalTag.get();
        Long tagId = tag.getId();
        List<Question> questionList = questionService.findAllQuestionByTagId(tagId);
        for(Question question : questionList) {
            List<String> answerList = new ArrayList<>();
            TagResponse tagResponse = new TagResponse();
            List<AnswerResponce> answerResponceList =
                    answerService.getAllAnswers(question.getId());
            System.out.println("Answer Response"+answerResponceList);
            for(AnswerResponce answer : answerResponceList) {
                answerList.add(answer.getInputAnswer());
            }
            System.out.println("AnswerList"+answerList);
            tagResponse.setQuestionTitle(question.getQuestionTitle());
            tagResponse.setQuestionDescription(question.getQuestionDescription());
            tagResponse.setInputAnswer(answerList);
            tagResponse.setCreatedAt(question.getCreatedAt());
            tagResponse.setUpdatedAt(question.getUpdatedAt());
            tagResponseList.add(tagResponse);

        }
        return tagResponseList;

    }
}
