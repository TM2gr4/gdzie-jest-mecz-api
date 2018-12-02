package domain.objects.views;

import domain.objects.Team;
import lombok.*;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class MatchView {
    private Long id;
    private LocalDate date;
    private LocalTime time;
    private Team homeTeam;
    private Team awayTeam;
    private List<EventView> pubs;
}
