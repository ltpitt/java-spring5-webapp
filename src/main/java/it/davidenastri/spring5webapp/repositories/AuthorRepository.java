package it.davidenastri.spring5webapp.repositories;

import it.davidenastri.spring5webapp.domain.Author;
import org.springframework.data.repository.CrudRepository;

public interface AuthorRepository extends CrudRepository<Author, Long> {
}
