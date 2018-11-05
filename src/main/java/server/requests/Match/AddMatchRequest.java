package server.requests.Match;

import lombok.*;
import server.requests.Request;

import javax.persistence.Entity;
import java.time.LocalDate;
import java.time.LocalTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
public class AddMatchRequest implements Request {
    private Long id;

    private LocalDate date;
    private LocalTime time;
    private Long homeTeamId;
    private Long awayTeamId;
}
