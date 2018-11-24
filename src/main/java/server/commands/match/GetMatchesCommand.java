package server.commands.match;

import domain.objects.Match;
import domain.objects.events.PubEvent;
import domain.objects.views.MatchView;
import domain.objects.views.PubEventView;
import domain.repos.MatchRepository;
import domain.repos.PubEventRepository;
import domain.repos.PubRepository;
import domain.repos.TeamRepository;
import lombok.AllArgsConstructor;
import server.commands.Command;
import server.requests.EmptyRequest;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@AllArgsConstructor
public class GetMatchesCommand implements Command<List<MatchView>, EmptyRequest> {

    private MatchRepository matchRepository;
    private TeamRepository teamRepository;
    private PubEventRepository pubEventRepository;
    private PubRepository pubRepository;

    @Override
    public List<MatchView> handle(EmptyRequest emptyRequest) {
        List<Match> matchList = matchRepository.findAll();
        List<MatchView> matchViews = matchList.stream().map(match -> MatchView.builder()
                .id(match.getId())
                .time(match.getTime())
                .date(match.getDate())
                .awayTeam(teamRepository.findById(match.getAwayTeamId()).get())
                .homeTeam(teamRepository.findById(match.getHomeTeamId()).get())
                .build())
                .collect(Collectors.toList());
        matchViews.forEach(matchView -> {
            List<PubEvent> pubEventList = new ArrayList();
            for (PubEvent pubEvent : pubEventRepository.findAll()) {
                if (pubEvent.getMatchId() == matchView.getId()) {
                    pubEventList.add(pubEvent);
                }
            }
            matchView.setPubs(pubEventList.stream().map(pubEvent -> PubEventView.builder()
                    .pub(pubRepository.findById(pubEvent.getPubId()).get())
                    .description(pubEvent.getDescription())
                    .numberOfAttendees(pubEvent.getNumberOfAttendees())
                    .build()).collect(Collectors.toList()));
        });
        return matchViews;
    }
}
