package server.authorization;

import com.google.api.client.googleapis.auth.oauth2.GoogleIdToken;
import com.google.api.client.json.jackson2.JacksonFactory;
import domain.objects.AccountState;
import domain.objects.User;
import domain.repos.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

public class AuthenticationManagerImpl implements AuthenticationManager {

    @Autowired
    private UserRepository userRepository;

    private static final JacksonFactory jacksonFactory = new JacksonFactory();

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        HashMap<String, String> stringStringHashMap = (HashMap<String, String>) authentication.getDetails();
        String tok = stringStringHashMap.get("authorize_token");

        GoogleIdToken idToken;
        try {
            idToken = GoogleIdToken.parse(jacksonFactory, tok);
        } catch (IOException e) {
            throw new BadCredentialsException(e.toString());
        }
        GoogleIdToken.Payload payload = idToken.getPayload();
        User user = userRepository.findByGoogleID(payload.getSubject());
        if (user == null) {
            System.out.println("SAVE NEW USER");
            user = userRepository.save(User.builder()
                    .googleID(payload.getSubject())
                    .name((String) payload.get("name"))
                    .email(payload.getEmail())
                    .pictureUrl((String) payload.get("picture"))
                    .createDate(new Date())
                    .accountState(AccountState.ACTIVE).build());
        }

        List<GrantedAuthority> roles = new ArrayList<>();
        roles.add(new SimpleGrantedAuthority("USER"));

        return new UsernamePasswordAuthenticationToken(user.getId(), user.getGoogleID(), roles);
    }
}