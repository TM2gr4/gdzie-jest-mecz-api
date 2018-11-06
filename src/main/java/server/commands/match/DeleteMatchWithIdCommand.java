package server.commands.match;

import domain.repos.MatchRepository;
import lombok.AllArgsConstructor;
import server.commands.Command;
import server.requests.ByIdRequest;

@AllArgsConstructor
public class DeleteMatchWithIdCommand implements Command<String, ByIdRequest> {

    private MatchRepository matchRepository;

    @Override
    public String handle(ByIdRequest getMatchByIdRequest) {
        matchRepository.deleteById(getMatchByIdRequest.getId());
        return "Match removed successfully.";
    }
}
