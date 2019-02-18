package mc.springframework.spring5WebApp.repositories;

import mc.springframework.spring5WebApp.model.Book;
import org.springframework.data.repository.CrudRepository;

public interface BookRepository extends CrudRepository<Book, Long> {
}
