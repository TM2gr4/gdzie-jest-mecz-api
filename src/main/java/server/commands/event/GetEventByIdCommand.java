package server.commands.event;

import domain.objects.Event;
import domain.repos.EventRepository;
import lombok.AllArgsConstructor;
import server.commands.Command;
import server.requests.GetEventByIdRequest;

import java.util.Optional;

@AllArgsConstructor
public class GetEventByIdCommand implements Command<Optional<Event>, GetEventByIdRequest> {

    private EventRepository eventRepository;

    @Override
    public Optional<Event> handle(GetEventByIdRequest getEventByIdRequest) {
        return eventRepository.findById(getEventByIdRequest.getId());
    }
}
