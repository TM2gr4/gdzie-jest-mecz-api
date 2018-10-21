package server.requests.User;

import lombok.*;
import server.requests.Request;

@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class AuthenticateUserRequest implements Request {
    private String tokenID;
}
