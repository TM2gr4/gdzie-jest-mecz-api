package server.commands.match;

import domain.objects.Match;
import domain.repos.MatchRepository;
import lombok.AllArgsConstructor;
import server.commands.Command;
import server.requests.EmptyRequest;

import java.util.List;

@AllArgsConstructor
public class GetMatchesCommand implements Command<List<Match>, EmptyRequest> {

    private MatchRepository matchRepository;

    @Override
    public List<Match> handle(EmptyRequest emptyRequest) {
        return matchRepository.findAll();
    }
}
