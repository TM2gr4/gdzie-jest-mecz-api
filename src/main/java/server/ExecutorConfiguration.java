package server;

import domain.repos.EventRepository;
import domain.repos.MatchRepository;
import domain.repos.TeamRepository;
import domain.repos.UserRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import server.commands.event.AddEventCommand;
import server.commands.event.DeleteEventWithIdCommand;
import server.commands.event.GetEventByIdCommand;
import server.commands.event.GetEventsCommand;
import server.commands.match.AddMatchCommand;
import server.commands.match.DeleteMatchWithIdCommand;
import server.commands.match.GetMatchByIdCommand;
import server.commands.match.GetMatchesCommand;
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
    public AddEventCommand addEvent(EventRepository eventRepository){
        return new AddEventCommand(eventRepository);
    }

    @Bean
    public DeleteEventWithIdCommand deleteEvent(EventRepository eventRepository){
        return new DeleteEventWithIdCommand(eventRepository);
    }

    @Bean
    public GetEventsCommand getEvents(EventRepository eventRepository) {
        return new GetEventsCommand(eventRepository);
    }

    @Bean
    public GetEventByIdCommand getEventById(EventRepository eventRepository){
        return new GetEventByIdCommand(eventRepository);
    }

    @Bean
    public AddMatchCommand addMatch(MatchRepository matchRepository){
        return new AddMatchCommand(matchRepository);
    }

    @Bean
    public DeleteMatchWithIdCommand deleteMatch(MatchRepository matchRepository){
        return new DeleteMatchWithIdCommand(matchRepository);
    }

    @Bean
    public GetMatchesCommand getMatches(MatchRepository matchRepository) {
        return new GetMatchesCommand(matchRepository);
    }
    @Bean
    public GetMatchByIdCommand getMatchById(MatchRepository matchRepository){
        return new GetMatchByIdCommand(matchRepository);
    }

    @Bean
    public GetTeamsCommand getTeams(TeamRepository teamRepository) {
        return new GetTeamsCommand(teamRepository);
    }
}
