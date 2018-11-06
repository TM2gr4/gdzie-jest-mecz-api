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
                    .latitude(51.7519858)
                    .longitude(19.452498)
                    .numberOfAttendees(20L)
                    .description("Real Madryt VS Liverpool pub 1 INDEKS")
                    .build());

            eventRepository.save(Event.builder()
                    .matchId(1L)
                    .pubId(2L)
                    .latitude(51.7465619)
                    .longitude(19.4502251)
                    .numberOfAttendees(20L)
                    .description("Real Madryt VS Liverpool pub 2 COTTON CLUB")
                    .build());

            eventRepository.save(Event.builder()
                    .matchId(1L)
                    .pubId(3L)
                    .latitude(51.768345)
                    .longitude(19.459083)
                    .numberOfAttendees(20L)
                    .description("Real Madryt VS Liverpool pub 3 Z INNEJ BECZKI")
                    .build());

            eventRepository.save(Event.builder()
                    .matchId(1L)
                    .pubId(4L)
                    .latitude(51.7664589)
                    .longitude(19.4575109)
                    .numberOfAttendees(20L)
                    .description("Real Madryt VS Liverpool pub 4 LONG PLAY")
                    .build());


            eventRepository.save(Event.builder()
                    .matchId(1L)
                    .pubId(2L)
                    .latitude(51.7465619)
                    .longitude(19.4502251)
                    .numberOfAttendees(20L)
                    .description("Tottenham VS Schalke pub 2 COTTON CLUB")
                    .build());

            eventRepository.save(Event.builder()
                    .matchId(1L)
                    .pubId(3L)
                    .latitude(51.768345)
                    .longitude(19.459083)
                    .numberOfAttendees(20L)
                    .description("Tottenham VS Schalke pub 3 Z INNEJ BECZKI")
                    .build());

            eventRepository.save(Event.builder()
                    .matchId(1L)
                    .pubId(4L)
                    .latitude(51.7664589)
                    .longitude(19.4575109)
                    .numberOfAttendees(20L)
                    .description("Tottenham VS Schalke pub 4 LONG PLAY")
                    .build());


            eventRepository.save(Event.builder()
                    .matchId(1L)
                    .pubId(1L)
                    .latitude(51.7465619)
                    .longitude(19.4502251)
                    .numberOfAttendees(20L)
                    .description("Liverpool vs RM pub 2 COTTON CLUB")
                    .build());

            eventRepository.save(Event.builder()
                    .matchId(1L)
                    .pubId(4L)
                    .latitude(51.7664589)
                    .longitude(19.4575109)
                    .numberOfAttendees(20L)
                    .description("Liverpool vs RM pub 4 LONG PLAY")
                    .build());


            eventRepository.save(Event.builder()
                    .matchId(1L)
                    .pubId(2L)
                    .latitude(51.7465619)
                    .longitude(19.4502251)
                    .numberOfAttendees(20L)
                    .description("Schalke 04 vs Tottenham pub 2 COTTON CLUB")
                    .build());
        };
    }

    @Bean
    public CommandLineRunner matchMock(MatchRepository matchRepository) {
        return (args) -> {
            matchRepository.save(Match.builder()
                    .date(LocalDate.now().plusDays(9))
                    .awayTeamId(1L)
                    .homeTeamId(2L)
                    .time(LocalTime.now().plusMinutes(4000))
                    .build());

            matchRepository.save(Match.builder()
                    .date(LocalDate.now().plusDays(9))
                    .awayTeamId(3L)
                    .homeTeamId(4L)
                    .time(LocalTime.now().plusMinutes(4000))
                    .build());

            matchRepository.save(Match.builder()
                    .date(LocalDate.now().plusDays(5))
                    .awayTeamId(2L)
                    .homeTeamId(1L)
                    .time(LocalTime.now().plusMinutes(4000))
                    .build());

            matchRepository.save(Match.builder()
                    .date(LocalDate.now().plusDays(5))
                    .awayTeamId(4L)
                    .homeTeamId(3L)
                    .time(LocalTime.now().plusMinutes(4000))
                    .build());

            matchRepository.save(Match.builder()
                    .date(LocalDate.now().plusDays(11))
                    .awayTeamId(4L)
                    .homeTeamId(1L)
                    .time(LocalTime.now().plusMinutes(4000))
                    .build());

            matchRepository.save(Match.builder()
                    .date(LocalDate.now().plusDays(11))
                    .awayTeamId(2L)
                    .homeTeamId(3L)
                    .time(LocalTime.now().plusMinutes(4000))
                    .build());

            matchRepository.save(Match.builder()
                    .date(LocalDate.now().plusDays(11))
                    .awayTeamId(1L)
                    .homeTeamId(4L)
                    .time(LocalTime.now().plusMinutes(4000))
                    .build());

            matchRepository.save(Match.builder()
                    .date(LocalDate.now().plusDays(11))
                    .awayTeamId(3L)
                    .homeTeamId(2L)
                    .time(LocalTime.now().plusMinutes(4000))
                    .build());

            matchRepository.save(Match.builder()
                    .date(LocalDate.now().plusDays(16))
                    .awayTeamId(1L)
                    .homeTeamId(3L)
                    .time(LocalTime.now().plusMinutes(4000))
                    .build());

            matchRepository.save(Match.builder()
                    .date(LocalDate.now().plusDays(16))
                    .awayTeamId(4L)
                    .homeTeamId(2L)
                    .time(LocalTime.now().plusMinutes(4000))
                    .build());

            matchRepository.save(Match.builder()
                    .date(LocalDate.now().plusDays(20))
                    .awayTeamId(3L)
                    .homeTeamId(1L)
                    .time(LocalTime.now().plusMinutes(4000))
                    .build());

            matchRepository.save(Match.builder()
                    .date(LocalDate.now().plusDays(16))
                    .awayTeamId(2L)
                    .homeTeamId(4L)
                    .time(LocalTime.now().plusMinutes(4000))
                    .build());
        };
    }

    @Bean
    public CommandLineRunner teamMock(TeamRepository teamRepository) {
        return (args) -> {
            teamRepository.save(Team.builder()
                    .name("Real Madryt")
                    .imgUrl("https://vignette.wikia.nocookie.net/nonsensopedia/images/7/7e/Real_madrid_logo_copy_by_PiotroV.png/revision/latest?cb=20090724183238")
                    .build());

            teamRepository.save(Team.builder()
                    .name("Liverpool F.C.")
                    .imgUrl("https://upload.wikimedia.org/wikipedia/en/thumb/0/0c/Liverpool_FC.svg/255px-Liverpool_FC.svg.png")
                    .build());

            teamRepository.save(Team.builder()
                    .name("Tottenham Hotspur F.C.")
                    .imgUrl("https://ssl.gstatic.com/onebox/media/sports/logos/k3Q_mKE98Dnohrcea0JFgQ_96x96.png")
                    .build());

            teamRepository.save(Team.builder()
                    .name("FC Schalke 04")
                    .imgUrl("https://ssl.gstatic.com/onebox/media/sports/logos/3CjFxnIvrHJ1-pJq6B5ZQw_96x96.png")
                    .build());

            teamRepository.save(Team.builder()
                    .name("Termalica Bruk-Bet Nieciecza")
                    .imgUrl("http://www.termalica.brukbet.com/nowa/assets/img/herb.png")
                    .build());

            teamRepository.save(Team.builder()
                    .name("SSC Napoli")
                    .imgUrl("https://ssl.gstatic.com/onebox/media/sports/logos/PWRLYBJqlGrAAsKkUN6eng_96x96.png")
                    .build());

            teamRepository.save(Team.builder()
                    .name("Paris Saint-Germain F.C.")
                    .imgUrl("https://ssl.gstatic.com/onebox/media/sports/logos/mcpMspef1hwHwi9qrfp4YQ_96x96.png")
                    .build());

            teamRepository.save(Team.builder()
                    .name("Juventus F.C.")
                    .imgUrl("https://ssl.gstatic.com/onebox/media/sports/logos/Lv6xmBlUIpN3GAFhtf6nqQ_96x96.png")
                    .build());

        };
    }


}
