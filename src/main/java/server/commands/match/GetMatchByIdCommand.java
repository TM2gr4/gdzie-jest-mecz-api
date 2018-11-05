package server.commands.match;

import domain.objects.Match;
import domain.repos.MatchRepository;
import lombok.AllArgsConstructor;
import server.commands.Command;
import server.requests.GetMatchByIdRequest;

import java.util.Optional;

@AllArgsConstructor
public class GetMatchByIdCommand implements Command<Optional<Match>, GetMatchByIdRequest> {

    private MatchRepository matchRepository;

    @Override
    public Optional<Match> handle(GetMatchByIdRequest getMatchByIdRequest) {
        return matchRepository.findById(getMatchByIdRequest.getId());}
}
