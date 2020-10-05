package org.launchcode.codingevents.models;

import javax.validation.constraints.AssertTrue;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.sql.DataTruncation;
import java.util.Objects;

public class Events {

    private int id;
    private static int nextId = 1;

    @NotBlank(message = "Name required.")
    @Size(min=3, max=50, message = "Name must be between 3 to 50 characters.")
    private String name;

    @Size(max = 500, message = "Description too long.")
    private String description;

    @NotBlank(message = "Email required.")
    @Email(message = "Invalid email, Try again.")
    private String contactEmail;

    @NotBlank(message = "Location cannot be blank.")
    private String location;

    @AssertTrue(message = "Must be true.")
    private boolean registration;

    @Size(min=1, message = "Must be at least one attendee.")
    private int attendees;

    private EventType type;

    public Events(String name, String description, String contactEmail, String location, boolean registration, int attendees, EventType type) {
        this();
        this.name = name;
        this.description = description;
        this.contactEmail = contactEmail;
        this.location=location;
        this.registration=registration;
        this.attendees = attendees;
        this.type = type;
    }

    public Events() {
        this.id=nextId;
        nextId++;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getId() {
        return id;
    }

    public String getContactEmail() {
        return contactEmail;
    }

    public void setContactEmail(String contactEmail) {
        this.contactEmail = contactEmail;
    }

    public EventType getType() {
        return type;
    }

    public void setType(EventType type) {
        this.type = type;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public boolean isRegistration() {
        return registration;
    }

    public void setRegistration(boolean registration) {
        this.registration = registration;
    }

    public int getAttendees() {
        return attendees;
    }

    public void setAttendees(int attendees) {
        this.attendees = attendees;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Events events = (Events) o;
        return id == events.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
