package mc.springframework.spring5WebApp.repositories;

import mc.springframework.spring5WebApp.model.Publisher;
import org.springframework.data.repository.CrudRepository;

public interface PublisherRepository extends CrudRepository<Publisher,String> {
}
