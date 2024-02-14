package com.example.feedbackService;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class FeedbackService {
    private final FeedbackRepository feedbackRepository;
    public List<Feedback> findAll(){
        return  feedbackRepository.findAll();
    }
    public Optional<Feedback> findById(Long id){
        return feedbackRepository.findById(id);
    }
    public Feedback save(Feedback task){
        return feedbackRepository.save(task);
    }
    public void deleteById(Long id){
        feedbackRepository.deleteById(id);
    }
}
