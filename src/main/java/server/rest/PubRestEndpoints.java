package server.rest;

import domain.objects.Pub;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import server.commands.pub.AddPubCommand;
import server.commands.pub.GetPubByIdCommand;
import server.commands.pub.GetPubsCommand;
import server.requests.ByIdRequest;
import server.requests.EmptyRequest;
import server.requests.Match.AddMatchRequest;
import server.requests.Match.AddPubRequest;

import java.io.IOException;
import java.security.GeneralSecurityException;
import java.util.List;
import java.util.Optional;

@AllArgsConstructor
@RestController
public class PubRestEndpoints {

    private GetPubsCommand getPubsCommand;
    private GetPubByIdCommand getPubByIdCommand;
    private AddPubCommand addPubCommand;

    @RequestMapping(value = "/pubs", method = RequestMethod.GET)
    public List<Pub> getPubs(EmptyRequest emptyRequest) {
        return getPubsCommand.handle(emptyRequest);
    }

    @RequestMapping(value = "/pubs/{id}", method = RequestMethod.GET)
    public Optional<Pub> getPubById(@PathVariable("id") Long id) {
        return getPubByIdCommand.handle(new ByIdRequest(id));
    }

    @RequestMapping(value = "pubs/add", method = RequestMethod.POST)
    public String addEvent(@RequestBody AddPubRequest addPubRequest) throws GeneralSecurityException, IOException {
        return addPubCommand.handle(addPubRequest);
    }
}
