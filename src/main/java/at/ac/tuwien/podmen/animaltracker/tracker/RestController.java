package at.ac.tuwien.podmen.animaltracker.tracker;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.time.LocalDateTime;

@org.springframework.web.bind.annotation.RestController
public class RestController {


    private final LogEntryRepository repository;

    public RestController(LogEntryRepository repository) {
        this.repository = repository;
    }

    @GetMapping("/entries")
    public String entries() {
        return repository.findAll().stream().toList().toString();
    }

    @PostMapping("/entry")
    public LogEntry createLog(@RequestBody LogRequest request) {
        System.out.println("/ENTRY");
        LogEntry logEntry = new LogEntry(request.animal(), request.stream(), LocalDateTime.now());
        return repository.save(logEntry);
    }
}
