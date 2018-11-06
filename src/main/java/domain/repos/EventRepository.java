package domain.repos;

import domain.objects.Event;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface EventRepository extends JpaRepository<Event, Long> {

    @Override
    List<Event> findAll();

    @Override
    Optional<Event> findById(Long id);
}
