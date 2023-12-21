package com.web_calendar.Repository;

import com.web_calendar.Entity.Event;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface EventRepository extends JpaRepository<Event,Long> {
    @Query("SELECT e FROM Event e WHERE e.date = ?1")
    List<Event> getTodayEvents(LocalDate date);

    @Query("SELECT e FROM Event e WHERE e.date BETWEEN ?1 AND ?2 order by e.date asc")
    List<Event> getEventByDate(LocalDate startDate, LocalDate endDate);
}
