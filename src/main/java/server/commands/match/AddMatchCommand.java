package server.commands.match;

import domain.objects.Match;
import domain.repos.MatchRepository;
import lombok.AllArgsConstructor;
import server.commands.Command;
import server.requests.Match.AddMatchRequest;

import java.io.IOException;
import java.security.GeneralSecurityException;

@AllArgsConstructor
public class AddMatchCommand implements Command<String, AddMatchRequest> {

    private MatchRepository matchRepository;

    @Override
    public String handle(AddMatchRequest addMatchRequest) throws GeneralSecurityException, IOException {

        matchRepository.save(new Match(addMatchRequest.getId(),
                addMatchRequest.getDate(),
                addMatchRequest.getTime(),
                addMatchRequest.getHomeTeamId(),
                addMatchRequest.getAwayTeamId()));

        return "Match added successfully.";
    }
}
