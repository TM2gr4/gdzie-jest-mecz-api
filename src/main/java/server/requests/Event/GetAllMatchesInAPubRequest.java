
package server.requests.Event;

import domain.objects.Match;
import domain.objects.Pub;
import domain.objects.events.PubEvent;
import lombok.*;
import server.requests.Request;

import javax.persistence.Entity;
import java.util.List;
import java.util.Optional;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity

public class GetAllMatchesInAPubRequest implements Request {
    private Long pubId;
}
