package jdev.server.core.jpa;

import jdev.server.core.dao.repo.AutoRepository;
import jdev.server.core.dao.repo.PointRepository;
import jdev.server.core.dao.repo.RoleRepository;
import jdev.server.core.dao.repo.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.autoconfigure.liquibase.LiquibaseAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;


@SpringBootApplication
@EnableAutoConfiguration(exclude = {LiquibaseAutoConfiguration.class})
@EnableJpaRepositories("jdev.server.core.dao")
@EntityScan(basePackageClasses = {jdev.server.core.dao.Role.class,
        jdev.server.core.dao.Point.class,
        jdev.server.core.dao.Auto.class,
        jdev.server.core.dao.User.class})
public class JpaApplication implements CommandLineRunner {

    private static final Logger log = LoggerFactory.getLogger(JpaApplication.class);

    public static void main(String[] args) {
        SpringApplication.run(JpaApplication.class, args);
    }

    @Bean
    public static PropertySourcesPlaceholderConfigurer propertyConfigurer() {
        return new PropertySourcesPlaceholderConfigurer();
    }

    @Autowired
    PointRepository pointRepository;

    @Autowired
    AutoRepository autoRepository;

    @Autowired
    RoleRepository roleRepository;

    @Autowired
    UserRepository userRepository;

    @Override
    public void run(String... args) throws Exception {

    }
}
