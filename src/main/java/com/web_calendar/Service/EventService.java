package com.web_calendar.Service;


import com.web_calendar.Config.ResponseHandler;
import com.web_calendar.Entity.Event;
import com.web_calendar.Repository.EventRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class EventService {
    @Autowired
    private EventRepository repository;

    public ResponseEntity<?> getAllEvents(){
        List<Event> events = repository.findAll();
        if(events.isEmpty()){
            return ResponseEntity
                    .status(HttpStatus.NO_CONTENT)
                    .build();
        }
        return ResponseEntity
                .status(HttpStatus.OK)
                .header("Content-Type", "application/json")
                .body(events);
    }

    public ResponseEntity<?> getEventById(Long id){
        Event event = repository.findById(id).orElse(null);
        if(event == null){
            throw new RuntimeException("The event doesn't exist!");
        }
        return ResponseEntity
                .status(HttpStatus.OK)
                .header("Content-Type", "application/json")
                .body(event);
    }
    
    public ResponseEntity<?> getTodaysEvent(){
        LocalDate date = LocalDate.now();
        List<Event> events = repository.getTodayEvents(date);
        return ResponseEntity
                .status(HttpStatus.OK)
                .header("Content-Type", "application/json")
                .body(events);
    }


    public ResponseEntity<?> saveEvent(Event event) {
        repository.save(event);
        return ResponseEntity
                .status(HttpStatus.OK)
                .header("Content-Type", "application/json")
                .body(new ResponseHandler("The event has been added!", event.getEvent(), event.getDate().toString()));
    }

    public ResponseEntity<?> deleteEventById(Long id) {
        Event event = repository.findById(id).orElse(null);
        if(event == null){
            throw new RuntimeException("The event doesn't exist!");
        }
        repository.deleteById(id);
        return ResponseEntity
                .status(HttpStatus.OK)
                .header("Content-Type", "application/json")
                .body(event);
    }

    public ResponseEntity<?> getEventByDate(String startDate, String endDate) {
        LocalDate start = LocalDate.parse(startDate);
        LocalDate end = LocalDate.parse(endDate);
        List<Event> events = repository.getEventByDate(start, end);
        if(events.isEmpty()){
            return ResponseEntity
                    .status(HttpStatus.NO_CONTENT)
                    .build();
        }
        return ResponseEntity
                .status(HttpStatus.OK)
                .header("Content-Type", "application/json")
                .body(events);
    }
}
