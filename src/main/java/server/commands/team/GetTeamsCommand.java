package server.commands.team;

import domain.objects.Team;
import domain.repos.TeamRepository;
import lombok.AllArgsConstructor;
import server.commands.Command;
import server.requests.EmptyRequest;

import java.util.List;

@AllArgsConstructor
public class GetTeamsCommand implements Command<List<Team>, EmptyRequest> {

    private TeamRepository teamRepository;

    @Override
    public List<Team> handle(EmptyRequest emptyRequest) {
        return teamRepository.findAll();
    }
}
