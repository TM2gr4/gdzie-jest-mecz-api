package server;

import domain.repos.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import server.commands.event.*;
import server.commands.match.AddMatchCommand;
import server.commands.match.DeleteMatchWithIdCommand;
import server.commands.match.GetMatchByIdCommand;
import server.commands.match.GetMatchesCommand;
import server.commands.pub.GetPubByIdCommand;
import server.commands.pub.GetPubsCommand;
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
    public GetMatchesCommand getMatches(MatchRepository matchRepository, TeamRepository teamRepository) {
        return new GetMatchesCommand(matchRepository, teamRepository);
    }
    @Bean
    public GetMatchByIdCommand getMatchById(MatchRepository matchRepository){
        return new GetMatchByIdCommand(matchRepository);
    }

    @Bean
    public GetTeamsCommand getTeams(TeamRepository teamRepository) {
        return new GetTeamsCommand(teamRepository);
    }

    @Bean
    public GetAllMatchesInAPubCommand getAllMatchesInAPub(PubEventRepository pubEventRepository){
        return new GetAllMatchesInAPubCommand(pubEventRepository);
    }

    @Bean
    public GetAllPubsForAMatchCommand getAllPubsForAMatch(PubEventRepository pubEventRepository){
        return new GetAllPubsForAMatchCommand(pubEventRepository);
    }

    @Bean
    public GetPubsCommand getPubsCommand(PubRepository pubRepository) {
        return new GetPubsCommand(pubRepository);
    }

    @Bean
    public GetPubByIdCommand getPubByIdCommand(PubRepository pubRepository) {
        return new GetPubByIdCommand(pubRepository);
    }
}
