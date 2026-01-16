package at.ac.tuwien.podmen.animaltracker.tracker;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.time.LocalDateTime;


@Controller
public class HtmlController {

    private static final Logger log = LoggerFactory.getLogger(HtmlController.class);
    private final LogEntryRepository repository;

    public HtmlController(LogEntryRepository repository) {
        this.repository = repository;
    }

    @GetMapping("/")
    public String tracker(Model model) {
        model.addAttribute("logEntry", new LogEntry());
        model.addAttribute("entries", repository.findAll());
        return "tracker";
    }

    @PostMapping("/")
    public String trackerPost(@ModelAttribute LogEntry logEntry) {
        logEntry.setTimestamp(LocalDateTime.now());
        repository.save(logEntry);

        return "redirect:/";
    }
}
