package server.rest;

import domain.objects.views.MatchView;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import server.commands.user.*;
import server.requests.User.IgnoredOrFavouriteMatchesRequest;
import server.requests.User.IgnoredOrFavouriteHelper;

import java.security.Principal;
import java.util.List;

@AllArgsConstructor
@RestController
public class UserRestEndpoints {

    private AddIgnoredMatches addIgnoredMatches;
    private RemoveIgnoredMatches removeIgnoredMatches;
    private AddFavouriteMatches addFavouriteMatches;
    private RemoveFavouriteMatches removeFavouriteMatches;
    private GetFavouritesMatches getFavouritesMatches;
    private GetIgnoredMatches getIgnoredMatches;

    @RequestMapping(value = "/ignoredMatches", method = RequestMethod.POST)
    public void addMatchToIgnored(Principal principal, @RequestBody IgnoredOrFavouriteMatchesRequest request) {
        addIgnoredMatches.handle(IgnoredOrFavouriteHelper.builder()
                .principal(principal)
                .ignoredOrFavouriteMatchesRequest(request)
                .build());
    }

    @RequestMapping(value = "/ignoredMatches", method = RequestMethod.DELETE)
    public void removeMatchFromIgnored(Principal principal, @RequestBody IgnoredOrFavouriteMatchesRequest request) {
        removeIgnoredMatches.handle(IgnoredOrFavouriteHelper.builder()
                .principal(principal)
                .ignoredOrFavouriteMatchesRequest(request)
                .build());
    }

    @RequestMapping(value = "/favouriteMatches", method = RequestMethod.POST)
    public void addMatchToFavourite(Principal principal, @RequestBody IgnoredOrFavouriteMatchesRequest request) {
        addFavouriteMatches.handle(IgnoredOrFavouriteHelper.builder()
                .principal(principal)
                .ignoredOrFavouriteMatchesRequest(request)
                .build());
    }

    @RequestMapping(value = "/favouriteMatches", method = RequestMethod.DELETE)
    public void removeMatchFromFavourite(Principal principal, @RequestBody IgnoredOrFavouriteMatchesRequest request) {
        removeFavouriteMatches.handle(IgnoredOrFavouriteHelper.builder()
                .principal(principal)
                .ignoredOrFavouriteMatchesRequest(request)
                .build());
    }

    @RequestMapping(value = "/ignoredMatches", method = RequestMethod.GET)
    public List<MatchView> getIgnoredMatches(Principal principal) {
        return getIgnoredMatches.handle(IgnoredOrFavouriteHelper.builder()
                .principal(principal)
                .build());
    }

    @RequestMapping(value = "/favouriteMatches", method = RequestMethod.GET)
    public List<MatchView> getFavouriteMatches(Principal principal) {
        return getFavouritesMatches.handle(IgnoredOrFavouriteHelper.builder()
                .principal(principal)
                .build());
    }
}
