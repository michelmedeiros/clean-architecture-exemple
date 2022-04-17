package br.com.clean.architecture.example.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Recommendation {
    private Student studentSource;
    private Student studentTarget;
    private LocalDateTime dateRecommendation;
}
