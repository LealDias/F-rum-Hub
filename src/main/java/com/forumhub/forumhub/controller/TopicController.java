package com.forumhub.forumhub.controller;

import com.forumhub.forumhub.dto.TopicDTO;
import com.forumhub.forumhub.model.Topic;
import com.forumhub.forumhub.service.TopicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
@RestController
@RequestMapping("/topicos")
public class TopicController {

    @Autowired
    private TopicService topicService;

    @PostMapping
    public ResponseEntity<Topic> createTopic(@RequestBody @Validated TopicDTO topicDTO) {
        Optional<Topic> existingTopic = topicService.findByTitleAndMessage(topicDTO.getTitle(), topicDTO.getMessage());
        if (existingTopic.isPresent()) {
            return ResponseEntity.badRequest().build();
        }
        Topic topic = topicService.save(topicDTO);
        return ResponseEntity.ok(topic);
    }

    @GetMapping
    public ResponseEntity<List<Topic>> listTopics() {
        List<Topic> topics = topicService.findAll();
        return ResponseEntity.ok(topics);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Topic> getTopic(@PathVariable Long id) {
        Optional<Topic> topic = topicService.findById(id);
        return topic.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PutMapping("/{id}")
    public ResponseEntity<Topic> updateTopic(@PathVariable Long id, @RequestBody @Validated TopicDTO topicDTO) {
        Optional<Topic> existingTopic = topicService.findById(id);
        if (existingTopic.isPresent()) {
            Topic updatedTopic = topicService.update(existingTopic.get(), topicDTO);
            return ResponseEntity.ok(updatedTopic);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTopic(@PathVariable Long id) {
        Optional<Topic> topic = topicService.findById(id);
        if (topic.isPresent()) {
            topicService.delete(id);
            return ResponseEntity.ok().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
