package server.commands.event;

import domain.objects.Event;
import domain.repos.EventRepository;
import lombok.AllArgsConstructor;
import server.commands.Command;
import server.requests.Event.GetAllMatchesInAPubRequest;

import java.io.IOException;
import java.security.GeneralSecurityException;
import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
public class GetAllMatchesInAPubCommand implements Command<List<Event>, GetAllMatchesInAPubRequest> {

    private EventRepository eventRepository;

    @Override
    public List<Event> handle(GetAllMatchesInAPubRequest getAllMatchesInAPubRequest) throws GeneralSecurityException, IOException {

        List<Event> eventList = new ArrayList();
        for (Event event : eventRepository.findAll()) {
            if (event.getPubId() == getAllMatchesInAPubRequest.getPubId()) {
                eventList.add(event);
            }
        }

        return eventList;
    }
}
