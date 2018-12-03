package server.requests.User;

import lombok.*;

@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class IgnoredOrFavouriteMatchesRequest {
    private Long matchID;
}