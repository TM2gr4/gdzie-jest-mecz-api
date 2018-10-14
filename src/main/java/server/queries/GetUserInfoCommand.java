package server.queries;

import domain.objects.User;
import domain.repos.UserRepository;
import lombok.AllArgsConstructor;

import java.util.Optional;

@AllArgsConstructor
public class GetUserInfoCommand implements ActionOnDatabase<Optional<User>, UserRepository> {

    private UserRepository userRepository;

    @Override
    public Optional<User> handle(Object... args) {
        return userRepository.findById((Long) args[0]);
    }
}
