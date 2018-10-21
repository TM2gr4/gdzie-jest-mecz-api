package server;

import domain.repos.UserRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import server.commands.user.AuthenticateUserCommand;
import server.commands.user.GetUserInfoCommand;

@Configuration
public class ExecutorConfiguration {

    @Bean
    public GetUserInfoCommand getUserInfo(UserRepository userRepository) {
        return new GetUserInfoCommand(userRepository);
    }

    @Bean
    public AuthenticateUserCommand createUser(UserRepository userRepository) {
        return new AuthenticateUserCommand(userRepository);
    }
}
