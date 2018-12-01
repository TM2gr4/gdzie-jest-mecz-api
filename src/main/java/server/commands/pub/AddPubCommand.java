package server.commands.pub;

import domain.objects.Match;
import domain.objects.Pub;
import domain.repos.MatchRepository;
import domain.repos.PubRepository;
import lombok.AllArgsConstructor;
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

        pubRepository.save(new Pub(addPubRequest.getId(),
                addPubRequest.getLatitude(),
                addPubRequest.getLongitude(),
                addPubRequest.getStreet(),
                addPubRequest.getNumber(),
                addPubRequest.getName()));

        return "Pub added successfully.";
    }
}
