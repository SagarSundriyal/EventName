package com.example.eventservice;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EventRepository extends JpaRepository<Event, Long> {

	List<Event> findBydateEvent(String dateEvent);

	List<Event> findBylocationVenue(String locationVenue);

	List<Event> findByeventName(String eventName); 
}
