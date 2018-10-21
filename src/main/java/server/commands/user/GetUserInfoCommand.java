package server.commands.user;

import domain.objects.User;
import domain.repos.UserRepository;
import lombok.AllArgsConstructor;
import server.commands.Command;
import server.requests.User.GetUserInfoRequest;

import java.util.Optional;

@AllArgsConstructor
public class GetUserInfoCommand implements Command<Optional<User>, GetUserInfoRequest> {

    private UserRepository userRepository;

    @Override
    public Optional<User> handle(GetUserInfoRequest getUserInfoRequest) {
        return userRepository.findById(getUserInfoRequest.getId());
    }
}
