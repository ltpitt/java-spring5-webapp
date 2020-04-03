package it.davidenastri.spring5webapp.repositories;

import it.davidenastri.spring5webapp.domain.Publisher;
import org.springframework.data.repository.CrudRepository;

public interface PublisherRepository extends CrudRepository<Publisher, Long> {
}
