package server.commands.event;

import domain.objects.Event;
import domain.repos.EventRepository;
import lombok.AllArgsConstructor;
import server.commands.Command;
import server.requests.EmptyRequest;

import java.util.List;

@AllArgsConstructor
public class GetEventsCommand implements Command<List<Event>, EmptyRequest> {

    private EventRepository eventRepository;

    @Override
    public List<Event> handle(EmptyRequest emptyRequest) {
        return eventRepository.findAll();
    }
}
