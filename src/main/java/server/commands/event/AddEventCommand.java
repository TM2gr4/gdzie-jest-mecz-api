package server.commands.event;

import domain.objects.Event;
import domain.repos.EventRepository;
import lombok.AllArgsConstructor;
import lombok.val;
import server.commands.Command;
import server.requests.Event.AddEventRequest;

@AllArgsConstructor
public class AddEventCommand implements Command<String, AddEventRequest> {

    private EventRepository eventRepository;

    @Override
    public String handle(AddEventRequest addEventRequest ) {

        val events = eventRepository.findAll();
        for(Event event : events){
            if (event.getPubId() == addEventRequest.getPubId() &&
            event.getMatchId() == addEventRequest.getMatchId()){
                return "Request cancelled: Trying to add duplicate event.";
            }
        }

        eventRepository.save( new Event(addEventRequest.getId(),
                addEventRequest.getMatchId(),
                addEventRequest.getPubId(),
                addEventRequest.getNumberOfAttendees(),
                addEventRequest.getDescription()));

        return "Event added successfully.";
    }
}