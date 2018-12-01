package domain.repos;

import domain.objects.Pub;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface PubRepository extends CrudRepository<Pub, Long> {

    @Override
    List<Pub> findAll();

    @Override
    Optional<Pub> findById(Long id);
}
