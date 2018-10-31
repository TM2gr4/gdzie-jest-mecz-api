package server.rest;

import domain.objects.Match;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import server.commands.match.GetMatchesCommand;
import server.requests.EmptyRequest;

import java.util.List;

@RestController
@AllArgsConstructor
public class MatchRestEndpoints {

    private GetMatchesCommand getMatchesCommand;

    @RequestMapping(value = "/matches", method = RequestMethod.GET)
    public List<Match> getMatches(EmptyRequest emptyRequest) {
        return getMatchesCommand.handle(emptyRequest);
    }

}
