package com.example.eventservice;

import java.util.List;

public interface EventService {

	Event create(Event event);

    List<Event> getAll();

    Event get(Long id);
    
    Event updateEvent(Event event);

    void deleteEventById(Long eventId);

    List<Event> findBydateEvent(String dateEvent);

    List<Event> findBylocationVenue(String locationVenue);
    
	List<Event> findByeventName(String eventName);

	
}
