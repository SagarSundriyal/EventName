package com.example.eventservice;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
public class EventServiceImpl implements EventService {

	private static EventService instance;
	
    @Autowired
    @Qualifier("eventRepository")
    private EventRepository eventRepository;

    @Override 
    public Event create(Event event) {
        return eventRepository.save(event);
    }

    @Override
    public List<Event> getAll() {
        return eventRepository.findAll();
    }

    @Override
    public Event get(Long id) {
        return eventRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("event with given id not found !!"));
    }

	@Override
	public Event updateEvent(Event event) {
		Event existingEvent = eventRepository.findById(event.getId()).get();
		existingEvent.setEventName(event.getEventName());
		existingEvent.setDateEvent(event.getDateEvent());
		existingEvent.setTimeEvent(event.getTimeEvent());
		existingEvent.setLocationVenue(event.getLocationVenue());
		existingEvent.setEventDescription(event.getEventDescription());
		existingEvent.setMaximumAttendee(event.getMaximumAttendee());
		existingEvent.setUploadImage(event.getUploadImage());
		Event updatedEvent = eventRepository.save(existingEvent);
	        return updatedEvent;
	}

	@Override
	public void deleteEventById(Long userId) {
		// TODO Auto-generated method stub
		eventRepository.deleteById(userId);
	}
     
	@Override
	public List<Event> findBydateEvent(String dateEvent) {
		return eventRepository.findBydateEvent(dateEvent);
	}

	@Override
	public List<Event> findBylocationVenue(String locationVenue) {
		// TODO Auto-generated method stub
		return eventRepository.findBylocationVenue(locationVenue);
	}

	@Override
	public List<Event> findByeventName(String eventName) {
		// TODO Auto-generated method stub
		return eventRepository.findByeventName(eventName);
	}
	


}