package server;

import domain.repos.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.oauth2.provider.token.DefaultTokenServices;
import org.springframework.security.oauth2.provider.token.TokenStore;
import org.springframework.security.oauth2.provider.token.store.InMemoryTokenStore;
import server.authorization.UserDetailsServiceImpl;

@EntityScan(basePackages = {"domain"})
@EnableJpaRepositories(basePackages = {"domain.repos"})
@SpringBootApplication
public class StartApp extends SpringBootServletInitializer {

    public static void main(String[] args) {
        SpringApplication.run(StartApp.class, args);
    }

    //TODO MOCK
    @Bean
    public CommandLineRunner demo(UserRepository repository) {
        return (args) -> {
          /*  repository.save(User.builder()
                    .name("test")
                    .createDate(new Date())
                    .googleID("123sasd231")
                    .email("test@test.com")
                    .accountState(AccountState.ACTIVE).build());
            repository.save(User.builder()
                    .name("QWE")
                    .createDate(new Date())
                    .facebookID("asdsadxzz")
                    .email("face@gmail.com")
                    .accountState(AccountState.INACTIVE).build());*/
        };
    }

    @Bean
    public TokenStore tokenStore(){
        return new InMemoryTokenStore();
    }

    @Bean
    public DefaultTokenServices defaultTokenServices() {
        DefaultTokenServices defaultTokenServices = new DefaultTokenServices();
        defaultTokenServices.setTokenStore(tokenStore());
        return defaultTokenServices;
    }

    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }

    @Bean
    public UserDetailsService userDetailsService(){
        return new UserDetailsServiceImpl();
    }
}