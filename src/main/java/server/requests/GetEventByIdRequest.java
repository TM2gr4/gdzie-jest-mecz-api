package server.requests;

import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class GetEventByIdRequest implements Request {
    private Long id;
}

