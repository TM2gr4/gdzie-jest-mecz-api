package server;

import domain.objects.Event;
import domain.objects.Match;
import domain.objects.Team;
import domain.repos.EventRepository;
import domain.repos.MatchRepository;
import domain.repos.TeamRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.time.LocalTime;

@Configuration
public class MockInjector {
    @Bean
    public CommandLineRunner eventMock(EventRepository eventRepository) {
        return (args) -> {
            eventRepository.save(Event.builder()
                    .matchId(1L)
                    .pubId(1L)
                    .latitude(23.22)
                    .longitude(44.22)
                    .numberOfAttendees(20L)
                    .description("dużo piwa")
                    .build());

            eventRepository.save(Event.builder()
                    .matchId(2L)
                    .pubId(2L)
                    .latitude(55.21)
                    .longitude(77.22)
                    .numberOfAttendees(48L)
                    .description("free koks")
                    .build());

            eventRepository.save(Event.builder()
                    .matchId(1L)
                    .pubId(3L)
                    .latitude(22.21)
                    .longitude(17.22)
                    .numberOfAttendees(10L)
                    .description("pizzza day")
                    .build());
        };
    }

    @Bean
    public CommandLineRunner matchMock(MatchRepository matchRepository) {
        return (args) -> {
            matchRepository.save(Match.builder()
                    .date(LocalDate.now().plusDays(20))
                    .awayTeamId(1L)
                    .homeTeamId(2L)
                    .time(LocalTime.now().plusMinutes(4000))
                    .build());

            matchRepository.save(Match.builder()
                    .date(LocalDate.now().plusDays(25))
                    .awayTeamId(2L)
                    .homeTeamId(3L)
                    .time(LocalTime.now().plusMinutes(2400))
                    .build());
        };
    }

    @Bean
    public CommandLineRunner teamMock(TeamRepository teamRepository) {
        return (args) -> {
            teamRepository.save(Team.builder()
                    .name("Raków Częstochowa")
                    .imgUrl("https://e.kiwip.pl/rakow.png")
                    .build());

            teamRepository.save(Team.builder()
                    .name("Lech Poznań")
                    .imgUrl("https://upload.wikimedia.org/wikipedia/ro/thumb/0/0e/Lech_Pozna%C5%84.svg/194px-Lech_Pozna%C5%84.svg.png")
                    .build());

            teamRepository.save(Team.builder()
                    .name("Real Madryt")
                    .imgUrl("https://vignette.wikia.nocookie.net/nonsensopedia/images/7/7e/Real_madrid_logo_copy_by_PiotroV.png/revision/latest?cb=20090724183238")
                    .build());
        };
    }


}
