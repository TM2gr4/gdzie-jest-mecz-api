package server.commands.user;

import com.google.api.client.googleapis.auth.oauth2.GoogleIdToken;
import com.google.api.client.json.jackson2.JacksonFactory;
import domain.objects.AccountState;
import domain.objects.User;
import domain.repos.UserRepository;
import lombok.AllArgsConstructor;
import server.commands.Command;
import server.requests.User.AuthenticateUserRequest;

import java.io.IOException;
import java.util.Date;

@AllArgsConstructor
public class AuthenticateUserCommand implements Command<String, AuthenticateUserRequest> {

    private UserRepository userRepository;
    private static final JacksonFactory jacksonFactory = new JacksonFactory();

    @Override
    public String handle(AuthenticateUserRequest authenticateUserRequest) throws IOException {
        GoogleIdToken idToken = GoogleIdToken.parse(jacksonFactory, authenticateUserRequest.getTokenID());
        GoogleIdToken.Payload payload = idToken.getPayload();

        userRepository.save(User.builder()
                .googleID(payload.getSubject())
                .name((String) payload.get("name"))
                .email(payload.getEmail())
                .pictureUrl((String) payload.get("picture"))
                .createDate(new Date())
                .accountState(AccountState.ACTIVE).build());

        return "OK";

    }
}
