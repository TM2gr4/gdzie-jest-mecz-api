package server.commands.pub;

import domain.objects.Pub;
import domain.repos.PubRepository;
import lombok.AllArgsConstructor;
import server.commands.Command;
import server.requests.ByIdRequest;

import java.util.Optional;

@AllArgsConstructor
public class GetPubByIdCommand implements Command<Optional<Pub>, ByIdRequest> {

    private PubRepository pubRepository;

    @Override
    public Optional<Pub> handle(ByIdRequest byIdRequest) {
        return pubRepository.findById(byIdRequest.getId());
    }
}
