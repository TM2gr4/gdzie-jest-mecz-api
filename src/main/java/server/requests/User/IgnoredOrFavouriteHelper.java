package server.requests.User;

import lombok.*;
import server.requests.Request;

import java.security.Principal;

@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class IgnoredOrFavouriteHelper implements Request {
    private Principal principal;
    private IgnoredOrFavouriteMatchesRequest ignoredOrFavouriteMatchesRequest;
}
