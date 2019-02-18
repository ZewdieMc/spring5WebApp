package mc.springframework.spring5WebApp.repositories;

import mc.springframework.spring5WebApp.model.Author;
import org.springframework.data.repository.CrudRepository;

public interface AuthorRepository extends CrudRepository<Author, Long> {
}


