package server.rest;

import domain.objects.User;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import server.commands.user.AuthenticateUserCommand;
import server.commands.user.GetUserInfoCommand;
import server.requests.ApplicationInfoRequest;
import server.requests.User.AuthenticateUserRequest;
import server.requests.User.GetUserInfoRequest;

import java.io.IOException;
import java.util.Optional;

@AllArgsConstructor
@RestController
public class SampleRestEndpoint {

    private GetUserInfoCommand getUserInfoCommand;
    private AuthenticateUserCommand authenticateUserCommand;

    @RequestMapping(value = "/init", method = RequestMethod.POST)
    public ResponseEntity appInit(@RequestBody ApplicationInfoRequest applicationInfoRequest)
    {
        if(applicationInfoRequest.getVersion().equals("0.0.1"))
            return new ResponseEntity(HttpStatus.OK);
        else
            return new ResponseEntity(HttpStatus.FORBIDDEN);
    }

    @RequestMapping(value = "/user/{id}", method = RequestMethod.GET)
    public Optional<User> getUserInfo(@PathVariable("id") Long id){
        return getUserInfoCommand.handle(new GetUserInfoRequest(id));
    }

    @RequestMapping(value = "/authorize", method = RequestMethod.POST)
    public String authenticateUser(@RequestBody AuthenticateUserRequest authenticateUserRequest) throws IOException {
        return authenticateUserCommand.handle(authenticateUserRequest);
    }
}
