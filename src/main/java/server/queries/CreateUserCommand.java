package server.queries;

import domain.objects.AccountState;
import domain.objects.User;
import domain.repos.UserRepository;
import lombok.AllArgsConstructor;

import java.util.Date;

@AllArgsConstructor
public class CreateUserCommand implements ActionOnDatabase<User, UserRepository> {

    private UserRepository userRepository;

    @Override
    public User handle(Object... args) {
        User user = (User)args[0];
        user.setUserID(null); //userID zostanie przypisane przez repo
        user.setCreateDate(new Date());
        user.setAccountState(AccountState.ACTIVE);
        return userRepository.save((User)args[0]);
    }
}
