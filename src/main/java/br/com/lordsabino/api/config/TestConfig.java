package br.com.lordsabino.api.config;

import java.time.Instant;
import java.util.Arrays;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import br.com.lordsabino.api.Entities.Order;
import br.com.lordsabino.api.Entities.User;
import br.com.lordsabino.api.repositories.OrderRepository;
import br.com.lordsabino.api.repositories.UserRepository;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner {

    private UserRepository userRepository;

    private OrderRepository orderRepository;

    public TestConfig(UserRepository userRepository, OrderRepository orderRepository) {
        this.userRepository = userRepository;
        this.orderRepository = orderRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        
        User frodo = new User(null, "Frodo Bolseiro", "frodo@email.com", "15151515", "bolseiro");
        User bilbo = new User(null, "Bilbo Bolseiro", "bilbo@email.com", "16161616", "bolseiro");

        Order o1 = new Order(null, Instant.parse("2025-06-20T19:53:07Z"), frodo);
        Order o2 = new Order(null, Instant.parse("2025-07-21T03:42:10Z"), bilbo);
        Order o3 = new Order(null, Instant.parse("2025-07-22T15:21:22Z"), frodo);

        userRepository.saveAll(Arrays.asList(frodo, bilbo));
        orderRepository.saveAll(Arrays.asList(o1, o2, o3));
    }


}
