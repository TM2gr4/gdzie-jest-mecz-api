package server;

import domain.repos.EventRepository;
import domain.repos.MatchRepository;
import domain.repos.TeamRepository;
import domain.repos.UserRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import server.commands.match.GetMatchesCommand;
import server.commands.event.GetEventsCommand;
import server.commands.team.GetTeamsCommand;
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

    @Bean
    public GetEventsCommand getEvents(EventRepository eventRepository) {
        return new GetEventsCommand(eventRepository);
    }

    @Bean
    public GetMatchesCommand getMatches(MatchRepository matchRepository) {
        return new GetMatchesCommand(matchRepository);
    }

    @Bean
    public GetTeamsCommand getTeams(TeamRepository teamRepository) {
        return new GetTeamsCommand(teamRepository);
    }
}
