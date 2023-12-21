package com.web_calendar.Controller;

import com.web_calendar.Config.CustomErrorMessage;
import com.web_calendar.Entity.Event;
import com.web_calendar.Service.EventService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class EventController {

    @Autowired
    private EventService eventService;

    @GetMapping("/event")
    public ResponseEntity<?> getAllEvents(@RequestParam(required = false) String start_time,
                                          @RequestParam(required = false) String end_time){
        if(start_time != null && end_time != null){
            return eventService.getEventByDate(start_time,end_time);
        }
        return eventService.getAllEvents();
    }


    @GetMapping("/event/today")
    public ResponseEntity<?> getTodayEvents(){
        return eventService.getTodaysEvent();
    }


    @GetMapping("/event/{id}")
    public ResponseEntity<?> getEventById(@PathVariable Long id){
        return eventService.getEventById(id);
    }

    @DeleteMapping("/event/{id}")
    public ResponseEntity<?> deleteEventById(@PathVariable Long id){
        return eventService.deleteEventById(id);
    }

    @PostMapping("/event")
    public ResponseEntity<?> createEvent(@Valid @RequestBody Event event){
        return eventService.saveEvent(event);
    }



}
