package server.rest;

import domain.objects.Event;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import server.commands.event.GetEventsCommand;
import server.requests.EmptyRequest;

import java.util.List;

@AllArgsConstructor
@RestController
public class EventRestEndpoints {

    private GetEventsCommand getEventsCommand;

    @RequestMapping(value = "/events", method = RequestMethod.GET)
    public List<Event> getEvents(EmptyRequest emptyRequest) {
        return getEventsCommand.handle(emptyRequest);
    }
}
