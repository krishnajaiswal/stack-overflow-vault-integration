package com.knoldus.trainning.StackOverflowApplication.controller;

import com.knoldus.trainning.StackOverflowApplication.entity.Tag;
import com.knoldus.trainning.StackOverflowApplication.service.TagService;
import com.knoldus.trainning.StackOverflowApplication.vo.responce.TagResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user/tags")
public class TagController {
    @Autowired
    private TagService tagService;

    @GetMapping()
    public List<Tag> getAllTagsList() {
        return tagService.getAllTagsList();
    }

    @GetMapping("/get/questions")
    public List<TagResponse> getQuestionsByTag(String string) {
        List<TagResponse> tagResponseList = tagService.findTagIdByName(string);
        return tagResponseList;
    }

    @PostMapping("/add/{name}")
    public void AddTag(@PathVariable (value = "name") String tag) {
        tagService.save(tag);
    }
}
