package server;

import domain.objects.User;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
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

    @RequestMapping("/init")
    public ResponseEntity appInit(@RequestBody ApplicationInfoRequest applicationInfoRequest)
    {
        if(applicationInfoRequest.getVersion().equals("0.0.1"))
            return new ResponseEntity(HttpStatus.OK);
        else
            return new ResponseEntity(HttpStatus.FORBIDDEN);
    }

    @RequestMapping("/user/{id}")
    public Optional<User> getUserInfo(@PathVariable("id") Long id){
        return getUserInfoCommand.handle(new GetUserInfoRequest(id));
    }

    @RequestMapping("/authorize")
    public String authenticateUser(@RequestBody AuthenticateUserRequest authenticateUserRequest) throws IOException {
        return authenticateUserCommand.handle(authenticateUserRequest);
    }
}
