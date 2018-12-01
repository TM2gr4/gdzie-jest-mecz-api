package domain.repos;

import domain.objects.Event;
import domain.objects.Match;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface EventRepository extends CrudRepository<Event, Long> {
    @Override
    List<Event> findAll();

    @Override
    Optional<Event> findById(Long id);
}
