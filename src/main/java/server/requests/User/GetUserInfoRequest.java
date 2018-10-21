package server.requests.User;

import lombok.*;
import server.requests.Request;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class GetUserInfoRequest implements Request {
    private Long id;
}
