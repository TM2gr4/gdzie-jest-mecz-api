package server;

import domain.objects.User;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import server.queries.ApplicationInfoCommand;
import server.queries.CreateUserCommand;
import server.queries.GetUserInfoCommand;
import server.queries.objects.ApplicationInfo;

import java.util.Optional;

@AllArgsConstructor
@RestController
public class SampleRestEndpoint {

    private GetUserInfoCommand getUserInfoCommand;
    private CreateUserCommand createUserCommand;

    @RequestMapping("/init")
    public ResponseEntity appInit(@RequestBody ApplicationInfo applicationInfo)
    {
        if(applicationInfo.getVersion().equals("0.0.1"))
            return new ResponseEntity(HttpStatus.OK);
        else
            return new ResponseEntity(HttpStatus.FORBIDDEN);
    }

    @RequestMapping("/sample/{id}")
    public Optional<User> getUserInfo(@PathVariable("id") int id){
        return getUserInfoCommand.handle(Long.valueOf(id));
    }

    @RequestMapping("/sample")
    public String createUser(@RequestBody User user){
        return createUserCommand.handle(user).getUserID().toString();
    }
}
