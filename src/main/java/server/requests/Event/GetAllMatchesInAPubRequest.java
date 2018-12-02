
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

public class GetAllMatchesInAPubRequest implements Request {
    private Long pubId;
}
