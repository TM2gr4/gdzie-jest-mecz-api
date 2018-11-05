package server.requests;

import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class GetMatchByIdRequest implements Request {
    private Long id;
}
