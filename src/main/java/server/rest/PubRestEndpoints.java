package server.rest;

import domain.objects.Pub;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import server.commands.pub.GetPubByIdCommand;
import server.commands.pub.GetPubsCommand;
import server.requests.ByIdRequest;
import server.requests.EmptyRequest;

import java.util.List;
import java.util.Optional;

@AllArgsConstructor
@RestController
public class PubRestEndpoints {

    private GetPubsCommand getPubsCommand;
    private GetPubByIdCommand getPubByIdCommand;

    @RequestMapping(value = "/pubs", method = RequestMethod.GET)
    public List<Pub> getPubs(EmptyRequest emptyRequest) {
        return getPubsCommand.handle(emptyRequest);
    }

    @RequestMapping(value = "/pubs/{id}", method = RequestMethod.GET)
    public Optional<Pub> getPubById(@PathVariable("id") Long id) {
        return getPubByIdCommand.handle(new ByIdRequest(id));
    }
}
