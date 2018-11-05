package server.requests.Event;

import lombok.*;
import server.requests.Request;

import javax.persistence.Entity;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
public class AddEventRequest implements Request {
    private Long id;

    private Long matchId;
    private Long pubId;
    private Long numberOfAttendees;
    private Double longitude;
    private Double latitude;
    private String description;
}
