package server.commands.match;

import domain.objects.Match;
import domain.objects.views.MatchView;
import domain.repos.MatchRepository;
import domain.repos.TeamRepository;
import lombok.AllArgsConstructor;
import server.commands.Command;
import server.requests.EmptyRequest;

import java.util.List;
import java.util.stream.Collectors;

@AllArgsConstructor
public class GetMatchesCommand implements Command<List<MatchView>, EmptyRequest> {

    private MatchRepository matchRepository;
    private TeamRepository teamRepository;

    @Override
    public List<MatchView> handle(EmptyRequest emptyRequest) {
        List<Match> matchList = matchRepository.findAll();
        return matchList.stream().map(match -> MatchView.builder()
                .id(match.getId())
                .time(match.getTime())
                .date(match.getDate())
                .awayTeam(teamRepository.findById(match.getAwayTeamId()).get())
                .homeTeam(teamRepository.findById(match.getHomeTeamId()).get())
                .build())
                .collect(Collectors.toList());
    }
}
