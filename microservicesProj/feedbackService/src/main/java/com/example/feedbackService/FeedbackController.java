package com.example.feedbackService;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequiredArgsConstructor
@RequestMapping("/feedbacks")
public class FeedbackController {
    private final FeedbackService feedbackServiceService;
    @GetMapping
    public List<Feedback> findAll(){
        return feedbackServiceService.findAll();
    }
    @GetMapping("/{id}")
    public ResponseEntity<Feedback> findById(@PathVariable Long id){
        Optional<Feedback> feedback = feedbackServiceService.findById(id);
        return feedback.map(ResponseEntity::ok).orElseGet(()-> ResponseEntity.notFound().build());
    }

    @PostMapping
    public Feedback save(@RequestBody Feedback feedback){
        return feedbackServiceService.save(feedback);
    }
    @PutMapping("/{id}")
    public Feedback update(@RequestBody Feedback feedback, @PathVariable Long id){
        feedback.setId(id);
        return feedbackServiceService.save(feedback);
    }
    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable Long id){
        feedbackServiceService.deleteById(id);
    }
}
