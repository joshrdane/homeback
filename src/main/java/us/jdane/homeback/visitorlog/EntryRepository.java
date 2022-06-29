package us.jdane.homeback.visitorlog;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Component;

@Component
public interface EntryRepository extends PagingAndSortingRepository<Entry, Long> {

}
