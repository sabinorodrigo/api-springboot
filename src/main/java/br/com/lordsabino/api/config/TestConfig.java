package br.com.lordsabino.api.config;

import java.math.BigDecimal;
import java.time.Instant;
import java.util.Arrays;

import br.com.lordsabino.api.Entities.Category;
import br.com.lordsabino.api.Entities.Product;
import br.com.lordsabino.api.Entities.enums.OrderStatus;
import br.com.lordsabino.api.repositories.CategoryRepository;
import br.com.lordsabino.api.repositories.ProductRepository;
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

    private ProductRepository productRepository;

    public TestConfig(
            UserRepository userRepository,
            OrderRepository orderRepository,
            CategoryRepository categoryRepository,
            ProductRepository productRepository) {
        this.userRepository = userRepository;
        this.orderRepository = orderRepository;
        this.categoryRepository = categoryRepository;
        this.productRepository = productRepository;
    }

    @Override
    public void run(String... args) throws Exception {

        Category cat1 = new Category(null, "Electronics");
        Category cat2 = new Category(null, "Books");
        Category cat3 = new Category(null, "Computers");

        Product p1 = new Product(null, "The Lord of the Rings", "Lorem ipsum dolor sit amet, consectetur.", new BigDecimal(90.5), "");
        Product p2 = new Product(null, "Smart TV", "Nulla eu imperdiet purus. Maecenas ante.", new BigDecimal(2190.0), "");
        Product p3 = new Product(null, "Macbook Pro", "Nam eleifend maximus tortor, at mollis.", new BigDecimal(1250.0), "");
        Product p4 = new Product(null, "PC Gamer", "Donec aliquet odio ac rhoncus cursus.", new BigDecimal(1200.0), "");
        Product p5 = new Product(null, "Rails for Dummies", "Cras fringilla convallis sem vel faucibus.", new BigDecimal(100.99), "");

        categoryRepository.saveAll(Arrays.asList(cat1, cat2, cat3));
        productRepository.saveAll(Arrays.asList(p1, p2, p3, p4, p5));

        p1.getCategories().add(cat2);
        p2.getCategories().add(cat1);
        p2.getCategories().add(cat3);
        p3.getCategories().add(cat3);
        p4.getCategories().add(cat3);
        p5.getCategories().add(cat2);

        productRepository.saveAll(Arrays.asList(p1, p2, p3, p4, p5));

        User frodo = new User(null, "Frodo Bolseiro", "frodo@email.com", "15151515", "bolseiro");
        User bilbo = new User(null, "Bilbo Bolseiro", "bilbo@email.com", "16161616", "bolseiro");

        Order o1 = new Order(null, Instant.parse("2025-06-20T19:53:07Z"), OrderStatus.PAID, frodo);
        Order o2 = new Order(null, Instant.parse("2025-07-21T03:42:10Z"), OrderStatus.WAITING_PAYMENT, bilbo);
        Order o3 = new Order(null, Instant.parse("2025-07-22T15:21:22Z"), OrderStatus.WAITING_PAYMENT, frodo);

        userRepository.saveAll(Arrays.asList(frodo, bilbo));
        orderRepository.saveAll(Arrays.asList(o1, o2, o3));
    }


}
