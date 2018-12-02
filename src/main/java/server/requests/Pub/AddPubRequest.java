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
public class AddPubRequest implements Request {
    private Long id;

    private Double latitude;
    private Double longitude;
    private String street;
    private String number;
    private String name;

}
