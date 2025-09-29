package br.com.lordsabino.api.config;

import java.time.Instant;
import java.util.Arrays;

import br.com.lordsabino.api.Entities.Category;
import br.com.lordsabino.api.Entities.enums.OrderStatus;
import br.com.lordsabino.api.repositories.CategoryRepository;
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

    private CategoryRepository categoryRepository;

    public TestConfig(UserRepository userRepository, OrderRepository orderRepository, CategoryRepository categoryRepository) {
        this.userRepository = userRepository;
        this.orderRepository = orderRepository;
        this.categoryRepository = categoryRepository;
    }

    @Override
    public void run(String... args) throws Exception {

        Category cat1 = new Category(null, "Electronics");
        Category cat2 = new Category(null, "Books");
        Category cat3 = new Category(null, "Computers");

        categoryRepository.saveAll(Arrays.asList(cat1, cat2, cat3));

        User frodo = new User(null, "Frodo Bolseiro", "frodo@email.com", "15151515", "bolseiro");
        User bilbo = new User(null, "Bilbo Bolseiro", "bilbo@email.com", "16161616", "bolseiro");

        Order o1 = new Order(null, Instant.parse("2025-06-20T19:53:07Z"), OrderStatus.PAID, frodo);
        Order o2 = new Order(null, Instant.parse("2025-07-21T03:42:10Z"), OrderStatus.WAITING_PAYMENT, bilbo);
        Order o3 = new Order(null, Instant.parse("2025-07-22T15:21:22Z"), OrderStatus.WAITING_PAYMENT, frodo);

        userRepository.saveAll(Arrays.asList(frodo, bilbo));
        orderRepository.saveAll(Arrays.asList(o1, o2, o3));
    }


}
