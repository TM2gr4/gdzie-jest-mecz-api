
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

public class GetAllPubsForAMatchRequest implements Request {
    private Long matchId;
}
