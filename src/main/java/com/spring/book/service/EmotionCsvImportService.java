package com.spring.book.service;
import com.spring.book.dto.Emotions;
import com.spring.book.repository.EmotionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

@Service
public class EmotionCsvImportService {

    @Autowired
    private EmotionRepository emotionRepository;

    @Value("${emotion.csv-path}")
    private Resource csvResource;

    public void importFromCsv() {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(
                csvResource.getInputStream(), StandardCharsets.UTF_8))) {

            String line;
            boolean isFirstLine = true;
            List<Emotions> emotions = new ArrayList<>();

            while ((line = reader.readLine()) != null) {
                if (isFirstLine) {
                    isFirstLine = false; // skip header
                    continue;
                }

                String[] parts = line.split(",", 2);
                if (parts.length != 2) continue;

                String emotionName = parts[0].trim();
                int hit = Integer.parseInt(parts[1].trim());

                // 중복 확인
                if (emotionRepository.existsByEmotion(emotionName)) {
                    return;
                }

                emotions.add(new Emotions(emotionName, hit));
            }

            emotionRepository.saveAll(emotions);
            System.out.println("✅ JPA를 통해 감정 사전 삽입 완료!");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
