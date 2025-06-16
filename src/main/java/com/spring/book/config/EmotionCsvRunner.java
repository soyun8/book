package com.spring.book.config;
import com.spring.book.service.EmotionCsvImportService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class EmotionCsvRunner implements CommandLineRunner {
    private final EmotionCsvImportService importService;

    public EmotionCsvRunner(EmotionCsvImportService importService) {
        this.importService = importService;
    }

    @Override
    public void run(String... args) {
        importService.importFromCsv();
    }
}
