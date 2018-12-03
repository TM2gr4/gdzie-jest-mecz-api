package server.commands.user;

import domain.objects.User;
import domain.repos.UserRepository;
import lombok.AllArgsConstructor;
import server.commands.Command;
import server.requests.User.IgnoredOrFavouriteHelper;

import java.util.List;
import java.util.Optional;
import java.util.Set;

@AllArgsConstructor
public class RemoveFavouriteMatches implements Command<String, IgnoredOrFavouriteHelper> {

    private UserRepository userRepository;

    @Override
    public String handle(IgnoredOrFavouriteHelper ignoredOrFavouriteHelper) {

        Optional<User> user = userRepository.findById(Long.valueOf(ignoredOrFavouriteHelper.getPrincipal().getName()));
        Set<Long> list = user.get().getFavouriteMatchIds();
        list.remove(ignoredOrFavouriteHelper.getIgnoredOrFavouriteMatchesRequest().getMatchID());
        user.get().setFavouriteMatchIds(list);
        userRepository.save(user.get());
        return "OK";
    }
}
