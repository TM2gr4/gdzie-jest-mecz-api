package domain.repos;

import domain.objects.events.PubEvent;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository

public interface PubEventRepository extends CrudRepository<PubEvent, Long>{
    @Override
    List<PubEvent> findAll();

    @Override
    Optional<PubEvent> findById(Long id);
}
