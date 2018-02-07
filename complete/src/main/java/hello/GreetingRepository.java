package hello;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

//operasi (query) dari table asli dilakukan lewat class ini
@Repository
public interface GreetingRepository extends CrudRepository<Greeting, Long> {
    Greeting findById(Long id);
    List<Greeting> findAll();
    List<Greeting> findByContentContaining(String content);
}
