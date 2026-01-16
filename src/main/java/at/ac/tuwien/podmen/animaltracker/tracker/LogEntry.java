package at.ac.tuwien.podmen.animaltracker.tracker;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

import java.time.LocalDateTime;

@Entity
public class LogEntry {
    @Id
    @GeneratedValue
    private Long id;

    private String animal;
    private String stream;

    private LocalDateTime timestamp;

    // Constructors
    public LogEntry() {
    }

    public LogEntry(String animal, String stream, LocalDateTime timestamp) {
        this();
        this.animal = animal;
        this.stream = stream;
        this.timestamp = timestamp;
    }

    // Getters and setters
    public Long getId() {
        return id;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(LocalDateTime timestamp) {
        this.timestamp = timestamp;
    }

    public String getAnimal() {
        return animal;
    }

    public void setAnimal(String animal) {
        this.animal = animal;
    }

    public String getStream() {
        return stream;
    }

    public void setStream(String stream) {
        this.stream = stream;
    }

    @Override
    public String toString() {
        return "LogEntry{" +
                "id=" + id +
                ", animal='" + animal + '\'' +
                ", stream='" + stream + '\'' +
                ", timestamp=" + timestamp +
                '}';
    }
}
