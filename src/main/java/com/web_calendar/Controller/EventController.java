package com.web_calendar.Controller;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class EventController {

    @GetMapping("/event/today")
    public ResponseEntity<?> getTodayEvents(){
        return ResponseEntity
                .ok()
                .header("Content-Type", "application/json")
                .body(List.of());
    }
}
