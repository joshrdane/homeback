package us.jdane.homeback;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import us.jdane.homeback.visitorlog.Entry;
import us.jdane.homeback.visitorlog.EntryRepository;

import java.util.List;

@CrossOrigin("http://localhost:3000/")
@RestController
@RequestMapping("/rest/visitor-log")
public class RestAPI {

    @Autowired
    EntryRepository visitorLogRepository;

    @GetMapping
    public List<Entry> visitor() {
        return visitorLogRepository.findAll(PageRequest.of(0, 10)).toList();
    }
}
