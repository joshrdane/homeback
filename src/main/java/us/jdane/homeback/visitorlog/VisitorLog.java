package us.jdane.homeback.visitorlog;

import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/rest/visitor-log")
@CrossOrigin("http://localhost:3000/")
public class VisitorLog {

    final EntryRepository visitorLogRepository;

    public VisitorLog(EntryRepository visitorLogRepository) {
        this.visitorLogRepository = visitorLogRepository;
    }

    @GetMapping
    public List<Entry> getEntry() {
        return visitorLogRepository.findAll(PageRequest.of(0, 10)).toList();
    }

    @PostMapping
    public void createEntry(@RequestBody Entry entry) {
        visitorLogRepository.save(entry);
    }
}
