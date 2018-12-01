package server.commands.match;

import domain.objects.Event;
import domain.objects.Match;
import domain.objects.views.MatchView;
import domain.objects.views.EventView;
import domain.repos.EventRepository;
import domain.repos.MatchRepository;
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
    private EventRepository eventRepository;
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
            List<Event> eventList = new ArrayList();
            for (Event event : eventRepository.findAll()) {
                if (event.getMatchId() == matchView.getId()) {
                    eventList.add(event);
                }
            }
            matchView.setPubs(eventList.stream().map(event -> EventView.builder()
                    .pub(pubRepository.findById(event.getPubId()).get())
                    .description(event.getDescription())
                    .numberOfAttendees(event.getNumberOfAttendees())
                    .build()).collect(Collectors.toList()));
        });
        return matchViews;
    }
}
