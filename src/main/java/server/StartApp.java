package server;

import domain.objects.AccountState;
import domain.objects.User;
import domain.repos.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import java.util.Date;

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
            repository.save(User.builder()
                    .nickname("test")
                    .createDate(new Date())
                    .googleID("123sasd231")
                    .email("test@test.com")
                    .accountState(AccountState.ACTIVE).build());
            repository.save(User.builder()
                    .nickname("QWE")
                    .createDate(new Date())
                    .facebookID("asdsadxzz")
                    .email("face@gmail.com")
                    .accountState(AccountState.INACTIVE).build());
        };
    }
}