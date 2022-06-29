package us.jdane.homeback.visitorlog;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/rest/visitor-log")
@CrossOrigin("http://localhost:3000/")
public class VisitorLog {

    final EntryRepository visitorLogRepository;

    public VisitorLog(EntryRepository visitorLogRepository) {
        this.visitorLogRepository = visitorLogRepository;
    }

    @GetMapping
    public Page<Entry> getEntry(
            @RequestParam Optional<Integer> page,
            @RequestParam Optional<Integer> size
    ) {
        return visitorLogRepository.findAll(PageRequest.of(page.orElse(0), size.orElse(10)));
    }

    @PostMapping
    public void createEntry(@RequestBody Entry entry) {
        visitorLogRepository.save(entry);
    }
}
