package com.forumhub.forumhub.service;

import com.forumhub.forumhub.dto.TopicDTO;
import com.forumhub.forumhub.model.Topic;
import com.forumhub.forumhub.repository.TopicRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
@Service
public class TopicService {

    @Autowired
    private TopicRepository topicRepository;

    public Topic save(TopicDTO topicDTO) {
        Topic topic = new Topic();
        topic.setTitle(topicDTO.getTitle());
        topic.setMessage(topicDTO.getMessage());
        topic.setAuthor(topicDTO.getAuthor());
        topic.setCourse(topicDTO.getCourse());
        topic.setCreationDate(LocalDateTime.now());
        topic.setStatus("ACTIVE");
        return topicRepository.save(topic);
    }

    public List<Topic> findAll() {
        return topicRepository.findAll();
    }

    public Optional<Topic> findById(Long id) {
        return topicRepository.findById(id);
    }

    public Optional<Topic> findByTitleAndMessage(String title, String message) {
        return topicRepository.findByTitleAndMessage(title, message);
    }

    public Topic update(Topic existingTopic, TopicDTO topicDTO) {
        existingTopic.setTitle(topicDTO.getTitle());
        existingTopic.setMessage(topicDTO.getMessage());
        existingTopic.setAuthor(topicDTO.getAuthor());
        existingTopic.setCourse(topicDTO.getCourse());
        return topicRepository.save(existingTopic);
    }

    public void delete(Long id) {
        topicRepository.deleteById(id);
    }
}

