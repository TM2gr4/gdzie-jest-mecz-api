package domain.objects.views;

import domain.objects.Pub;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class EventView {
    private Pub pub;
    private Long numberOfAttendees;
    private String description;
}
