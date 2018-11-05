package server.commands.event;

import domain.objects.Event;
import domain.repos.EventRepository;
import lombok.AllArgsConstructor;
import server.commands.Command;
import server.requests.ByIdRequest;

import java.util.Optional;

@AllArgsConstructor
public class GetEventByIdCommand implements Command<Optional<Event>, ByIdRequest> {

    private EventRepository eventRepository;

    @Override
    public Optional<Event> handle(ByIdRequest getEventByIdRequest) {
        return eventRepository.findById(getEventByIdRequest.getId());
    }
}
