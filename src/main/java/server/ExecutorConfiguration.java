package server;

import domain.repos.UserRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import server.queries.CreateUserCommand;
import server.queries.GetUserInfoCommand;

@Configuration
public class ExecutorConfiguration {

    @Bean
    public GetUserInfoCommand getUserInfo(UserRepository userRepository) {
        return new GetUserInfoCommand(userRepository);
    }

    @Bean
    public CreateUserCommand createUser(UserRepository userRepository) {
        return new CreateUserCommand(userRepository);
    }
}
