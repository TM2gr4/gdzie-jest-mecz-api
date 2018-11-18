package server.rest;

import domain.objects.Match;
import domain.objects.views.MatchView;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import server.commands.match.AddMatchCommand;
import server.commands.match.DeleteMatchWithIdCommand;
import server.commands.match.GetMatchByIdCommand;
import server.commands.match.GetMatchesCommand;
import server.requests.ByIdRequest;
import server.requests.EmptyRequest;
import server.requests.Match.AddMatchRequest;

import java.io.IOException;
import java.security.GeneralSecurityException;
import java.util.List;
import java.util.Optional;

@RestController
@AllArgsConstructor
public class MatchRestEndpoints {

    private GetMatchesCommand getMatchesCommand;
    private GetMatchByIdCommand getMatchByIdCommand;
    private AddMatchCommand addMatchCommand;
    private DeleteMatchWithIdCommand deleteMatchWithId;

    @RequestMapping(value = "/matches", method = RequestMethod.GET)
    public List<MatchView> getMatches(EmptyRequest emptyRequest) {
        return getMatchesCommand.handle(emptyRequest);
    }

    @RequestMapping(value = "/matches/{id}", method = RequestMethod.GET)
    public Optional<Match> getMatchById(@PathVariable("id") Long id) {
        return getMatchByIdCommand.handle(new ByIdRequest(id));
    }

    @RequestMapping(value = "matches/add", method = RequestMethod.POST)
    public String addEvent(@RequestBody AddMatchRequest addMatchRequest) throws GeneralSecurityException, IOException {
        return addMatchCommand.handle(addMatchRequest);
    }

    @RequestMapping(value = "/matches/delete", method = RequestMethod.POST)
    public String deleteMatchWithId(@RequestBody ByIdRequest matchByIdRequest) {
        return deleteMatchWithId.handle(matchByIdRequest);
    }
}
