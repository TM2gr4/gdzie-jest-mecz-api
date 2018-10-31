package server.rest;

import domain.objects.Team;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import server.commands.team.GetTeamsCommand;
import server.requests.EmptyRequest;

import java.util.List;

@AllArgsConstructor
@RestController
public class TeamRestEndpoints {

    private GetTeamsCommand getTeamsCommand;

    @RequestMapping(value = "/teams", method = RequestMethod.GET)
    public List<Team> getTeams(EmptyRequest emptyRequest) {
        return getTeamsCommand.handle(emptyRequest);
    }
}
