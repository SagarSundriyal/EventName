package com.example.eventservice;

import java.util.ArrayList;
import org.springframework.http.HttpMethod;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/app/v1")
public class EventController {
	
	@Autowired
    private EventService eventService;  ///create  getall  get
	
	@Autowired
	EventserviceApplication sendingEmailApplication;

	@Autowired
	SendEmailService sendEmailService;
	
	@Autowired
    private EventRepository eventRepository;
	
	@Autowired//(required=false)
	private RestTemplate restTemplate;

    @PostMapping
    public ResponseEntity<Event> create(@RequestBody Event event) {
        return ResponseEntity.status(HttpStatus.CREATED).body(eventService.create(event));
    }

    @GetMapping("{id}")
    public ResponseEntity<Event> getAll(@PathVariable("id") Long eventId) {
     return ResponseEntity.status(HttpStatus.OK).body(eventService.get(eventId));
    }
   
    @GetMapping
    public ResponseEntity<List<Event>> getAll(){
        return ResponseEntity.ok(eventService.getAll());
    }
    
    @PutMapping("{id}")
    public ResponseEntity<Event> updateUser(@PathVariable("id") Long eventId,
                                           @RequestBody Event event){
    	event.setId(eventId);
    	Event updatedevent= eventService.updateEvent(event);
        return new ResponseEntity<>(updatedevent, HttpStatus.OK);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteCategory(@PathVariable("id") Long eventId){
    	eventService.deleteEventById(eventId);
        return new ResponseEntity<>("Data successfully deleted!", HttpStatus.OK);
    }
    
    @GetMapping("/dateEvent")
    public ResponseEntity<List<Event>> findBydateEvent(
    @RequestParam(value="dateEvent",required=true) String dateEvent) {
    	 System.out.println(" dateEvent line 58 "+dateEvent);
         System.out.println(" dateEvent line 59 "+ResponseEntity.status(HttpStatus.OK).body(eventService.findBydateEvent(dateEvent)));
      	
     return ResponseEntity.ok(eventService.findBydateEvent(dateEvent));
    }
    
    @GetMapping("/locationVenue")
    public ResponseEntity<List<Event>> findBylocationVenue(
    @RequestParam(value="locationVenue",required=true) String locationVenue) {
    	 System.out.println(" locationVenue line 67 "+locationVenue);
         System.out.println(" locationVenue line 68 "+ResponseEntity.status(HttpStatus.OK).body(eventService.findBylocationVenue(locationVenue)));
      	
     return ResponseEntity.ok(eventService.findBylocationVenue(locationVenue));
    }
    
    @GetMapping("/eventName")
    public ResponseEntity<List<Event>> findByeventName(
    @RequestParam(value="eventName",required=true) String eventName) {
    	 System.out.println(" eventName line 76 "+eventName);
         System.out.println(" eventName line 77 "+ResponseEntity.status(HttpStatus.OK).body(eventService.findByeventName(eventName)));
      	
     return ResponseEntity.ok(eventService.findByeventName(eventName));
    }
    

    private final List<BookingRequest> bookings = new ArrayList<>();
    
  /*  @PostMapping("/{id}/bookSeats")
    public ResponseEntity<String> updateEventAndTriggerMail(@PathVariable Long id, @RequestBody BookingRequest bookingRequest
    		,@RequestBody(required = false) Person logged) {
    Optional<Event> optionalEvent = eventRepository.findById(id);
    System.out.println(" optionalEvent "+optionalEvent);
   // if (optionalEvent.isPresent()) {
    Event event = optionalEvent.get();
    System.out.println(" event "+event);
    String eventName = event.getEventName();
    System.out.println(" eventName "+eventName);
    
  //  String mailid = this.restTemplate.postForObject("http://localhost:8096/reset-pass-demo/logged-email",
  //  		logged.getEmail(), String.class);
    //System.out.println(" mail--- line 117 "+mailid); 	
     String mailid = bookingRequest.getMailId(); // working one
    System.out.println(" mailId line 115 "+mailid);      
     int numSeats = bookingRequest.getNumSeats();
     System.out.println(" numSeats "+numSeats);   
   triggerMail(eventName, mailid, numSeats);
    return ResponseEntity.ok("Email triggered for event: " + eventName);
   }*/

	private void triggerMail(String eventName, String mailid, int numSeats) {
 String subject = "Booking Confirmation";
 System.out.println(" line 118 ---");
 String body = String.format("Thank you for booking!\nEvent Name:"
 		+ " %s\nNumber of Seats: %d", eventName, numSeats );

 System.out.println(" body ---"+body);
  sendEmailService.sendEmail(mailid, subject, body);
    System.out.println(" email send");
    }
    
   // private final List<BookingRequest> bookings = new ArrayList<>();
    @GetMapping("/bookedEvents")
    public List<BookingRequest> getBookedEvents() {
    	System.out.println(" bookings "+bookings);
        return bookings;
    }
    
    
    // working code
     @PostMapping("/{id}/bookSeats")
    public ResponseEntity<String> updateEventAndTriggerMail(@PathVariable Long id, 
    		@RequestBody BookingRequest bookingRequest) {
        Optional<Event> optionalEvent = eventRepository.findById(id);
        if (optionalEvent.isPresent()) {
            Event event = optionalEvent.get();
            String eventName = event.getEventName();
        
 // String mailId = restTemplate.getForObject("http://localhost:8096/reset-pass-demo/forgetPswrd", String.class);
            //  		logged.getEmail(), String.class);
           String mailId = bookingRequest.getMailId();
            int numSeats = bookingRequest.getNumSeats();

            BookingRequest bookingDetails = new BookingRequest();
            bookingDetails.setEventName(eventName);
            bookingDetails.setMailId(mailId);
            bookingDetails.setNumSeats(numSeats);
            bookings.add(bookingDetails);

            triggerMail(eventName, mailId, numSeats);
            return ResponseEntity.ok("Email triggered for event: " + eventName);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
