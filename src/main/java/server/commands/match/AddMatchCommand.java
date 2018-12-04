package server.commands.match;

import domain.objects.Match;
import domain.repos.MatchRepository;
import lombok.AllArgsConstructor;
import lombok.val;
import server.commands.Command;
import server.requests.Match.AddMatchRequest;

import java.io.IOException;
import java.security.GeneralSecurityException;

@AllArgsConstructor
public class AddMatchCommand implements Command<String, AddMatchRequest> {

    private MatchRepository matchRepository;

    @Override
    public String handle(AddMatchRequest addMatchRequest) throws GeneralSecurityException, IOException {

        val matches = matchRepository.findAll();
        for (Match match : matches) {
            if (match.getAwayTeamId().equals(addMatchRequest.getAwayTeamId()) &&
                    match.getHomeTeamId().equals(addMatchRequest.getHomeTeamId()) &&
                    match.getDate() == addMatchRequest.getDate()) {
                return "Request cancelled: Trying to add duplicate match.";
            }
        }

        matchRepository.save(new Match(addMatchRequest.getId(),
                addMatchRequest.getDate(),
                addMatchRequest.getTime(),
                addMatchRequest.getHomeTeamId(),
                addMatchRequest.getAwayTeamId()));

        return "Match added successfully.";
    }
}
