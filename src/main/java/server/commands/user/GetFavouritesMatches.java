package server.commands.user;

import domain.objects.User;
import domain.objects.views.MatchView;
import domain.repos.UserRepository;
import lombok.AllArgsConstructor;
import server.commands.Command;
import server.commands.match.GetMatchesCommand;
import server.requests.EmptyRequest;
import server.requests.User.IgnoredOrFavouriteHelper;

import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

@AllArgsConstructor
public class GetFavouritesMatches implements Command<List<MatchView>, IgnoredOrFavouriteHelper> {

    private UserRepository userRepository;
    private GetMatchesCommand getMatchesCommand;

    @Override
    public List<MatchView> handle(IgnoredOrFavouriteHelper ignoredOrFavouriteHelper) {
        Optional<User> user = userRepository.findById(Long.valueOf(ignoredOrFavouriteHelper.getPrincipal().getName()));
        Set<Long> list = user.get().getFavouriteMatchIds();
        List<MatchView> matchViews = getMatchesCommand.handle(new EmptyRequest());
        return matchViews.stream().filter(item -> list.contains(item.getId())).collect(Collectors.toList());
    }
}
