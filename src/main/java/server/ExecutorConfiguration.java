package server;

import domain.repos.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import server.commands.event.*;
import server.commands.match.AddMatchCommand;
import server.commands.match.DeleteMatchWithIdCommand;
import server.commands.match.GetMatchByIdCommand;
import server.commands.match.GetMatchesCommand;
import server.commands.pub.AddPubCommand;
import server.commands.pub.GetPubByIdCommand;
import server.commands.pub.GetPubsCommand;
import server.commands.team.GetTeamsCommand;
import server.commands.user.*;

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
    public AddEventCommand addEvent(EventRepository eventRepository) {
        return new AddEventCommand(eventRepository);
    }

    @Bean
    public DeleteEventWithIdCommand deleteEvent(EventRepository eventRepository) {
        return new DeleteEventWithIdCommand(eventRepository);
    }

    @Bean
    public GetEventsCommand getEvents(EventRepository eventRepository) {
        return new GetEventsCommand(eventRepository);
    }

    @Bean
    public GetEventByIdCommand getEventById(EventRepository eventRepository) {
        return new GetEventByIdCommand(eventRepository);
    }

    @Bean
    public AddMatchCommand addMatch(MatchRepository matchRepository) {
        return new AddMatchCommand(matchRepository);
    }

    @Bean
    public DeleteMatchWithIdCommand deleteMatch(MatchRepository matchRepository) {
        return new DeleteMatchWithIdCommand(matchRepository);
    }

    @Bean
    public GetMatchesCommand getMatches(MatchRepository matchRepository, TeamRepository teamRepository,
                                        EventRepository eventRepository, PubRepository pubRepository) {
        return new GetMatchesCommand(matchRepository, teamRepository, eventRepository, pubRepository);
    }

    @Bean
    public GetMatchByIdCommand getMatchById(MatchRepository matchRepository) {
        return new GetMatchByIdCommand(matchRepository);
    }

    @Bean
    public GetTeamsCommand getTeams(TeamRepository teamRepository) {
        return new GetTeamsCommand(teamRepository);
    }

    @Bean
    public GetAllMatchesInAPubCommand getAllMatchesInAPub(EventRepository eventRepository) {
        return new GetAllMatchesInAPubCommand(eventRepository);
    }

    @Bean
    public GetAllPubsForAMatchCommand getAllPubsForAMatch(EventRepository eventRepository) {
        return new GetAllPubsForAMatchCommand(eventRepository);
    }

    @Bean
    public GetPubsCommand getPubsCommand(PubRepository pubRepository) {
        return new GetPubsCommand(pubRepository);
    }

    @Bean
    public GetPubByIdCommand getPubByIdCommand(PubRepository pubRepository) {
        return new GetPubByIdCommand(pubRepository);
    }

    @Bean
    public AddPubCommand addPubCommand(PubRepository pubRepository) {
        return new AddPubCommand(pubRepository);
    }

    @Bean
    public AddIgnoredMatches addIgnoredMatches(UserRepository userRepository) {
        return new AddIgnoredMatches(userRepository);
    }

    @Bean
    public AddFavouriteMatches addFavouriteMatches(UserRepository userRepository) {
        return new AddFavouriteMatches(userRepository);
    }

    @Bean
    public RemoveFavouriteMatches removeFavouriteMatches(UserRepository userRepository) {
        return new RemoveFavouriteMatches(userRepository);
    }

    @Bean
    public RemoveIgnoredMatches removeIgnoredMatches(UserRepository userRepository) {
        return new RemoveIgnoredMatches(userRepository);
    }

    @Bean
    public GetIgnoredMatches getIgnoredMatches(UserRepository userRepository, GetMatchesCommand getMatchesCommand) {
        return new GetIgnoredMatches(userRepository, getMatchesCommand);
    }

    @Bean
    public GetFavouritesMatches getMatchesCommand(UserRepository userRepository, GetMatchesCommand getMatchesCommand) {
        return new GetFavouritesMatches(userRepository, getMatchesCommand);
    }
}
