package server.commands.event;

import domain.objects.Event;
import domain.repos.EventRepository;
import lombok.AllArgsConstructor;
import server.commands.Command;
import server.requests.Event.GetAllPubsForAMatchRequest;

import java.io.IOException;
import java.security.GeneralSecurityException;
import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
public class GetAllPubsForAMatchCommand implements Command<List<Event>, GetAllPubsForAMatchRequest> {

    private EventRepository eventRepository;

    @Override
    public List<Event> handle(GetAllPubsForAMatchRequest getAllPubsForAMatchRequest) throws GeneralSecurityException, IOException {

        List<Event> eventList = new ArrayList();
        for (Event event : eventRepository.findAll()) {
            if (event.getMatchId() == getAllPubsForAMatchRequest.getMatchId()) {
                eventList.add(event);
            }
        }

        return eventList;
    }
}
