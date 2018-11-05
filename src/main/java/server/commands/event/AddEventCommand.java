package server.commands.event;

import domain.objects.Event;
import domain.repos.EventRepository;
import lombok.AllArgsConstructor;
import server.commands.Command;
import server.requests.Event.AddEventRequest;

@AllArgsConstructor
public class AddEventCommand implements Command<String, AddEventRequest> {

    private EventRepository eventRepository;

    @Override
    public String handle(AddEventRequest addEventRequest ) {

        eventRepository.save( new Event(addEventRequest.getId(),
                addEventRequest.getMatchId(),
                addEventRequest.getPubId(),
                addEventRequest.getNumberOfAttendees(),
                addEventRequest.getLongitude(),
                addEventRequest.getLatitude(),
                addEventRequest.getDescription()));

        return "Event added successfully.";
    }
}