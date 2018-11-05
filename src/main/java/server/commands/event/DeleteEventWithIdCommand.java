package server.commands.event;

import domain.repos.EventRepository;
import lombok.AllArgsConstructor;
import server.commands.Command;
import server.requests.ByIdRequest;

@AllArgsConstructor
public class DeleteEventWithIdCommand implements Command<String, ByIdRequest> {

    private EventRepository eventRepository;

    @Override
    public String handle(ByIdRequest eventByIdRequest) {
        eventRepository.deleteById(eventByIdRequest.getId());
        return "Event removed successfully.";
    }
}
