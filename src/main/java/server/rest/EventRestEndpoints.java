package server.rest;

import domain.objects.Event;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import server.commands.event.AddEventCommand;
import server.commands.event.DeleteEventWithIdCommand;
import server.commands.event.GetEventByIdCommand;
import server.commands.event.GetEventsCommand;
import server.requests.ByIdRequest;
import server.requests.EmptyRequest;
import server.requests.Event.AddEventRequest;

import java.util.List;
import java.util.Optional;

@AllArgsConstructor
@RestController
public class EventRestEndpoints {

    private GetEventsCommand getEventsCommand;
    private GetEventByIdCommand getEventByIdCommand;
    private AddEventCommand addEventCommand;
    private DeleteEventWithIdCommand deleteEventWithIdCommand;

    @RequestMapping(value = "/events", method = RequestMethod.GET)
    public List<Event> getEvents(EmptyRequest emptyRequest) {
        return getEventsCommand.handle(emptyRequest);
    }

    @RequestMapping(value = "/events/{id}", method = RequestMethod.GET)
    public Optional<Event> getMatchById(@PathVariable("id") Long id) {
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
}
