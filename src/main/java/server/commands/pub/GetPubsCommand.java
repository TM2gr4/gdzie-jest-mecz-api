package server.commands.pub;

import domain.objects.Pub;
import domain.repos.PubRepository;
import lombok.AllArgsConstructor;
import server.commands.Command;
import server.requests.EmptyRequest;

import java.util.List;

@AllArgsConstructor
public class GetPubsCommand implements Command<List<Pub>, EmptyRequest> {

    private PubRepository pubRepository;

    @Override
    public List<Pub> handle(EmptyRequest emptyRequest) {
        return pubRepository.findAll();
    }
}
