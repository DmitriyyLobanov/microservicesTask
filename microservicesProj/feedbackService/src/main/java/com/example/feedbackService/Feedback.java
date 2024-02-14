package com.example.feedbackService;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.antlr.v4.runtime.misc.NotNull;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Feedback {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @NotNull
    private String consumerName;
    private String feedbackText;
    private LocalDateTime creationDate;

    public Feedback(String consumerName, String feedbackText, LocalDateTime creationDate) {
        this.consumerName = consumerName;
        this.feedbackText = feedbackText;
        this.creationDate = creationDate;
    }
}
