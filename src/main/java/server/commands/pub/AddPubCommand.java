package server.commands.pub;

import domain.objects.Event;
import domain.objects.Match;
import domain.objects.Pub;
import domain.repos.MatchRepository;
import domain.repos.PubRepository;
import lombok.AllArgsConstructor;
import lombok.val;
import server.commands.Command;
import server.requests.Match.AddMatchRequest;
import server.requests.Match.AddPubRequest;

import java.io.IOException;
import java.security.GeneralSecurityException;

@AllArgsConstructor
public class AddPubCommand implements Command<String, AddPubRequest> {

    private PubRepository pubRepository;

    @Override
    public String handle(AddPubRequest addPubRequest) throws GeneralSecurityException, IOException {

        val pubs = pubRepository.findAll();
        for (Pub pub : pubs) {
            if (pub.getName().equals(addPubRequest.getName()) ||
                    (pub.getStreet().equals(addPubRequest.getStreet()) &&
                    pub.getNumber().equals(addPubRequest.getNumber()))) {
                throw new RuntimeException("Request cancelled: Trying to add duplicate pub.");
            }
        }

        pubRepository.save(new Pub(addPubRequest.getId(),
                addPubRequest.getLatitude(),
                addPubRequest.getLongitude(),
                addPubRequest.getStreet(),
                addPubRequest.getNumber(),
                addPubRequest.getName()));

        return "Pub added successfully.";
    }
}
