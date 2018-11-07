package server.commands.event;

import domain.objects.events.PubEvent;
import domain.repos.PubEventRepository;
import lombok.AllArgsConstructor;
import server.commands.Command;
import server.requests.Event.GetAllMatchesInAPubRequest;

import java.io.IOException;
import java.security.GeneralSecurityException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@AllArgsConstructor
public class GetAllMatchesInAPubCommand implements Command<List<PubEvent>, GetAllMatchesInAPubRequest> {

    private PubEventRepository pubEventRepository;

    @Override
    public List<PubEvent> handle(GetAllMatchesInAPubRequest getAllMatchesInAPubRequest) throws GeneralSecurityException, IOException {

        List<PubEvent> pubEventList = new ArrayList();
        for (PubEvent pubEvent : pubEventRepository.findAll()) {
            if (pubEvent.getPubId() == getAllMatchesInAPubRequest.getPubId()) {
                pubEventList.add(pubEvent);
            }
        }

        return pubEventList;
    }
}
