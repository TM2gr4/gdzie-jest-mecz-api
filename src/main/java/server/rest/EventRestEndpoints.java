package server.rest;

import domain.objects.Event;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import server.commands.event.*;
import server.requests.ByIdRequest;
import server.requests.EmptyRequest;
import server.requests.Event.AddEventRequest;
import server.requests.Event.GetAllMatchesInAPubRequest;
import server.requests.Event.GetAllPubsForAMatchRequest;

import java.io.IOException;
import java.security.GeneralSecurityException;
import java.util.List;
import java.util.Optional;

@AllArgsConstructor
@RestController
public class EventRestEndpoints {

    private GetEventsCommand getEventsCommand;
    private GetEventByIdCommand getEventByIdCommand;
    private AddEventCommand addEventCommand;
    private DeleteEventWithIdCommand deleteEventWithIdCommand;
    private GetAllMatchesInAPubCommand getAllMatchesInAPubCommand;
    private GetAllPubsForAMatchCommand getAllPubsForAMatchCommand;

    @RequestMapping(value = "/events", method = RequestMethod.GET)
    public List<Event> getEvents(EmptyRequest emptyRequest) {
        return getEventsCommand.handle(emptyRequest);
    }

    @RequestMapping(value = "/events/{id}", method = RequestMethod.GET)
    public Optional<Event> getEventById(@PathVariable("id") Long id) {
        return getEventByIdCommand.handle(new ByIdRequest(id));
    }

    @RequestMapping(value = "events/add", method = RequestMethod.POST)
    public String addEvent(@RequestBody AddEventRequest addEventRequest) {
        return addEventCommand.handle(addEventRequest);
    }

    @RequestMapping(value = "/events/delete", method = RequestMethod.POST)
    public String deleteEventWithId(@RequestBody ByIdRequest eventByIdRequest) {
        return deleteEventWithIdCommand.handle(eventByIdRequest);
    }

    @RequestMapping(value = "/events/getAllMatchesForPubId/{id}", method = RequestMethod.GET)
    public List<Event> getAllMatchesInAPub(@PathVariable("id") Long id) throws GeneralSecurityException, IOException {
        return getAllMatchesInAPubCommand.handle(new GetAllMatchesInAPubRequest(id));
    }

    @RequestMapping(value = "/events/GetAllPubsForMatchId/{id}", method = RequestMethod.GET)
    public List<Event> getAllPubsForAMatch(@PathVariable("id") Long id) throws GeneralSecurityException, IOException {
        return getAllPubsForAMatchCommand.handle(new GetAllPubsForAMatchRequest(id));
    }
}
