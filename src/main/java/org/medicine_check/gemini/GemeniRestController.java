package org.medicine_check.gemini;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/gemini")
public class GemeniRestController {

    @Autowired
    private GeminiService geminiService;

    @PostMapping("/generate")
    public ResponseEntity<String> generateCalendarFormat(@RequestBody Map<String,String> payload) {
        String question = payload.get("question");
        String answer = geminiService.askGemini(question);
        return ResponseEntity.ok(answer);
    }

}
