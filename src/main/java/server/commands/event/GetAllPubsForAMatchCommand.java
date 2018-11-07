package server.commands.event;

import domain.objects.events.PubEvent;
import domain.repos.PubEventRepository;
import lombok.AllArgsConstructor;
import server.commands.Command;
import server.requests.Event.GetAllMatchesInAPubRequest;
import server.requests.Event.GetAllPubsForAMatchRequest;

import java.io.IOException;
import java.security.GeneralSecurityException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@AllArgsConstructor
public class GetAllPubsForAMatchCommand implements Command<List<PubEvent>, GetAllPubsForAMatchRequest> {

    private PubEventRepository pubEventRepository;

    @Override
    public List<PubEvent> handle(GetAllPubsForAMatchRequest getAllPubsForAMatchRequest) throws GeneralSecurityException, IOException {

        List<PubEvent> pubEventList = new ArrayList();
        for (PubEvent pubEvent : pubEventRepository.findAll()) {
            if (pubEvent.getMatchId() == getAllPubsForAMatchRequest.getMatchId()) {
                pubEventList.add(pubEvent);
            }
        }

        return pubEventList;
    }
}
