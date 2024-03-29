package com.example.eventservice;

import jakarta.persistence.*;

@Entity
@Table(name = "event")
public class Event {

	@Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
     private Long id;
	 public String eventName;
	 private String dateEvent;
	 private String timeEvent;
	 private String locationVenue;
	 private String eventDescription;
	 private String maximumAttendee;
	 private String uploadImage;
	 
		//private int numSeats;
	//	private String mailId;
	// @Transient
	 // @JsonIgnoreProperties(ignoreUnknown = true)
	
		
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getEventName() {
		return eventName;
	}

	public void setEventName(String eventName) {
		this.eventName = eventName;
	}

	public String getDateEvent() {
		return dateEvent;
	}

	public void setDateEvent(String dateEvent) {
		this.dateEvent = dateEvent;
	}
	public String getTimeEvent() {
		return timeEvent;
	}

	public void setTimeEvent(String timeEvent) {
		this.timeEvent = timeEvent;
	}

	public String getLocationVenue() {
		return locationVenue;
	}

	public void setLocationVenue(String locationVenue) {
		this.locationVenue = locationVenue;
	}

	public String getEventDescription() {
		return eventDescription;
	}

	public void setEventDescription(String eventDescription) {
		this.eventDescription = eventDescription;
	}

	public String getMaximumAttendee() {
		return maximumAttendee;
	}

	public void setMaximumAttendee(String maximumAttendee) {
		this.maximumAttendee = maximumAttendee;
	}	

	public String getUploadImage() {
		return uploadImage;
	}

	public void setUploadImage(String uploadImage) {
		this.uploadImage = uploadImage;
	}

	/*public int getNumSeats() {
		return numSeats;
	}

	public void setNumSeats(int numSeats) {
		this.numSeats = numSeats;
	}

	public String getMailId() {
		return mailId;
	}

	public void setMailId(String mailId) {
		this.mailId = mailId;
	}
*/
	
	public Event(Long id, String eventName, String dateEvent, String timeEvent, String locationVenue,
			String eventDescription, String maximumAttendee, String uploadImage
		) {
		super();
		this.id = id;
		this.eventName = eventName;
		this.dateEvent = dateEvent;
		this.timeEvent = timeEvent;
		this.locationVenue = locationVenue;
		this.eventDescription = eventDescription;
		this.maximumAttendee = maximumAttendee;
		this.uploadImage = uploadImage;
	}

	@Override
	public String toString() {
		return "Event [id=" + id + ", eventName=" + eventName + ", dateEvent=" + dateEvent + ", timeEvent=" + timeEvent
				+ ", locationVenue=" + locationVenue + ", eventDescription=" + eventDescription + ", maximumAttendee="
				+ maximumAttendee + ", uploadImage=" + uploadImage + "]";
	}

	public Event() {
		super();
	}
}