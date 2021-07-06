package de.lulunpengpeng.configclientdb;

import lombok.extern.log4j.Log4j2;
import org.hibernate.dialect.PostgreSQL10Dialect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


import java.util.stream.Stream;

@SpringBootApplication
@Log4j2
public class ConfigClientDbApplication implements CommandLineRunner {

    @Autowired
    private UserRepository userRepository;

    public static void main(String[] args) {
        SpringApplication.run(ConfigClientDbApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        Stream.of("Alex", "Nicole", "Rene", "Philipp", "Sören", "Eric")
                .map(User::from)
                .forEach(userRepository::save);

        userRepository.findAll().forEach(log::info);
    }
}
