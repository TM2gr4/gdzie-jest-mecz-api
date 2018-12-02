package domain.repos;

import domain.objects.Match;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface MatchRepository extends JpaRepository<Match, Long> {
    @Override
    List<Match> findAll();

    @Override
    Optional<Match> findById(Long id);
}
