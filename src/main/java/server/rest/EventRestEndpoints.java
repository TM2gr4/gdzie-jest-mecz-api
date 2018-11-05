package server.rest;

import domain.objects.Event;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import server.commands.event.GetEventByIdCommand;
import server.commands.event.GetEventsCommand;
import server.requests.EmptyRequest;
import server.requests.GetEventByIdRequest;

import java.util.List;
import java.util.Optional;

@AllArgsConstructor
@RestController
public class EventRestEndpoints {

    private GetEventsCommand getEventsCommand;
    private GetEventByIdCommand getEventByIdCommand;

    @RequestMapping(value = "/events", method = RequestMethod.GET)
    public List<Event> getEvents(EmptyRequest emptyRequest) {
        return getEventsCommand.handle(emptyRequest);
    }

    @RequestMapping(value = "/events/{id}", method = RequestMethod.GET)
    public Optional<Event> getMatchById(@PathVariable("id") Long id){
        return getEventByIdCommand.handle(new GetEventByIdRequest(id));
    }
}
