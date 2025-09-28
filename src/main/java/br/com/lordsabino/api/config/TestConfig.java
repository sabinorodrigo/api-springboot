package br.com.lordsabino.api.config;

import java.util.Arrays;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import br.com.lordsabino.api.Entities.User;
import br.com.lordsabino.api.repositories.UserRepository;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner {

    private UserRepository userRepository;

    public TestConfig(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        
        User frodo = new User(null, "Frodo Bolseiro", "frodo@email.com", "15151515", "bolseiro");
        User bilbo = new User(null, "Bilbo Bolseiro", "bilbo@email.com", "16161616", "bolseiro");

        userRepository.saveAll(Arrays.asList(frodo, bilbo));

    }


}
