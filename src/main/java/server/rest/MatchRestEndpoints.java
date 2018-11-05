package server.rest;

import domain.objects.Match;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import server.commands.match.GetMatchByIdCommand;
import server.commands.match.GetMatchesCommand;
import server.requests.EmptyRequest;
import server.requests.GetMatchByIdRequest;

import java.util.List;
import java.util.Optional;

@RestController
@AllArgsConstructor
public class MatchRestEndpoints {

    private GetMatchesCommand getMatchesCommand;
    private GetMatchByIdCommand getMatchByIdCommand;

    @RequestMapping(value = "/matches", method = RequestMethod.GET)
    public List<Match> getMatches(EmptyRequest emptyRequest) {
        return getMatchesCommand.handle(emptyRequest);
    }

    @RequestMapping(value = "/matches/{id}", method = RequestMethod.GET)
    public Optional<Match> getMatchById(@PathVariable("id") Long id){
        return getMatchByIdCommand.handle(new GetMatchByIdRequest(id));
    }

}
