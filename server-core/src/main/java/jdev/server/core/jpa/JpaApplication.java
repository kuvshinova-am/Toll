package jdev.server.core.jpa;

import jdev.server.core.dao.Auto;
import jdev.server.core.dao.Point;
import jdev.server.core.dao.Role;
import jdev.server.core.dao.User;
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

import java.util.HashSet;
import java.util.List;
import java.util.Set;


@SpringBootApplication
@EnableAutoConfiguration(exclude = {LiquibaseAutoConfiguration.class})
@EnableJpaRepositories("jdev.server.core.dao")
@EntityScan(basePackageClasses = {jdev.server.core.dao.Role.class,
        jdev.server.core.dao.Point.class,
        jdev.server.core.dao.Auto.class,
        jdev.server.core.dao.User.class})
public class JpaApplication implements CommandLineRunner {

    private static final Logger log = LoggerFactory.getLogger(JpaApplication.class);
    private List<Auto> allAuto;
    private List<Role> allRole;
    private List<User> allUser;
    private List<Point> allPoint;

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
        Auto auto1 = new Auto(1,"е005кх70", "Scania", "Griffin");

        Set<Auto> autos = new HashSet<>();
        Set<User> users = new HashSet<>();
        autos.add(auto1);

        readRole();
        readUser();
        readAuto();
        readPoint();

        Role client = create("client1");
        Role manager = create("manager1");
        Role root = create("root1");
        log.info("=========== after create");
        readRole();

        User prokofyev = create(1,"Прокофье", "Арсений", "Тимурович",
                "24/04/1982", 7390630166L, new Role(1,"client"), autos);
        User frolov = create(2,"Фроло", "Альберт", "Эдуардович",
                "23/05/1971", 2632213343L, new Role(2,"manager"), autos);
        User roshchina = create(3, "Рощин", "Ангелина", "Петровна",
                "4/09/1964", 1893258211L, new Role(3, "root"), autos);
        readUser();

        users.add(prokofyev);
        Auto е005кх70 = create(1,"е005кх70", "Scania", "Griffin", users);
        Auto е108кх70 = create(2, "е108кх70", "MAN", "TGA", users);
        Auto т858тт70 = create(3, "т858тт70", "MERCEDES-BENZ", "6X2", users);
        readAuto();

        Point point1 = create(135.64707900, 44.14411900, new Auto( 1, "е035кх70", "Scania", "Griffin"),1502511617361L,
                30.0, 60.0);
        Point point2 = create(135.64701800, 44.14414700, new Auto(1, "е035кх70", "Scania", "Griffin"),1502511635127L,
                35.0, 56.0);
        Point point3 = create(135.64718700, 44.14444000, new Auto(1, "е035кх70", "Scania", "Griffin"),1502511655168L,
                40.0, 63.0);
        readPoint();


        update(client, "client");
        update(manager, "manager");
        update(root, "root");
        log.info("=========== after update");
        readRole();

        update(prokofyev, "Прокофьев", "Арсений", "Тимурович",
                "24/04/1982", 7390630166L, new Role(1,"client"));
        update(frolov, "Фролов", "Альберт", "Эдуардович",
                "23/05/1971", 2632213343L, new Role(2,"manager"));
        update(roshchina, "Рощина", "Ангелина", "Петровна",
                "4/09/1964", 1893258211L, new Role(3,"root"));
        log.info("=========== after update");
        readUser();

        update(е005кх70, "е035кх70", "Scania", "Griffin");
        update(е108кх70, "е158кх70", "MAN", "TGA");
        update(т858тт70, "т854тт70", "MERCEDES-BENZ", "6X2");

        log.info("=========== after update");
        readAuto();

        update(point1, 135.64707900, 44.14411900, new Auto(1,"е035кх70", "Scania", "Griffin"),1502511617361L,
                30.0, 63.0);
        update(point2, 135.64701800, 44.14414700, new Auto(1,"е035кх70", "Scania", "Griffin"),1502511635127L,
                35.0, 55.0);
        update(point3, 135.64718700, 44.14444000, new Auto(1,"е035кх70", "Scania", "Griffin"),1502511655168L,
                40.0, 65.0);
        log.info("=========== after update");
        readPoint();


        delete(client);
        log.info("=========== after delete 1");
        readRole();

        delete(root);
        log.info("=========== after delete 2");
        readRole();

        delete(root);
        log.info("=========== after delete 3");
        readRole();

        delete(prokofyev);
        log.info("=========== after delete 1");
        readUser();

        delete(frolov);
        log.info("=========== after delete 2");
        readUser();

        delete(roshchina);
        log.info("=========== after delete 3");
        readUser();

        delete(roshchina);
        log.info("=========== after delete 4");
        readUser();

        delete(е005кх70);
        log.info("=========== after delete 1");
        readAuto();

        delete(е108кх70);
        log.info("=========== after delete 2");
        readAuto();

        delete(т858тт70);
        log.info("=========== after delete 3");
        readAuto();

        delete(т858тт70);
        log.info("=========== after delete 4");
        readAuto();

        delete(prokofyev);
        log.info("=========== after delete 1");
        readUser();

        delete(frolov);
        log.info("=========== after delete 2");
        readUser();

        delete(roshchina);
        log.info("=========== after delete 3");
        readUser();

        delete(roshchina);
        log.info("=========== after delete 4");
        readUser();
    }

    private void delete(Auto auto) {
        autoRepository.delete(auto);
    }

    private void update(Auto auto, String idAuto, String brand, String model) {
        auto.setIdAuto(idAuto);
        auto.setBrand(brand);
        auto.setModel(model);
        autoRepository.save(auto);
    }

    private void readAuto() {
        allAuto = (List<Auto>) autoRepository.findAll();

        if (allAuto.size() == 0) {
            log.info("NO RECORDS AUTO");
        } else {
            allAuto.stream().forEach(auto -> log.info(auto.toString()));
        }
    }

    private Auto create(Integer id, String idAuto, String brand, String model, Set<User> users) {
        Auto auto = new Auto();
        auto.setId(id);
        auto.setIdAuto(idAuto);
        auto.setBrand(brand);
        auto.setModel(model);

        if(users != null && users.size() > 0) {
            auto.setUsers(users);
        }

        return autoRepository.save(auto);
    }

    private void delete(Role role) {
        roleRepository.delete(role);
    }

    private void update(Role role,  String name) {
        role.setName(name);
        roleRepository.save(role);
    }

    private void readRole() {
        allRole = (List<Role>) roleRepository.findAll();

        if (allRole.size() == 0) {
            log.info("NO RECORDS ROLE");
        } else {
            allRole.stream().forEach(role -> log.info(role.toString()));
        }
    }

    private Role create(String name) {
        Role role = new Role();
        role.setName(name);
        return roleRepository.save(role);
    }

    private void delete(Point point) {
        pointRepository.delete(point);
    }

    private void update(Point point, Double lat, Double lon, Auto auto, Long time, Double azimuth, Double speed) {
        point.setLat(lat);
        point.setLon(lon);
        point.setAuto(auto);
        point.setTime(time);
        point.setAzimuth(azimuth);
        point.setSpeed(speed);
        pointRepository.save(point);
    }

    private void readPoint() {
        allPoint = (List<Point>) pointRepository.findAll();

        if (allPoint.size() == 0) {
            log.info("NO RECORDS POINT");
        } else {
            allPoint.stream().forEach(point -> log.info(point.toString()));
        }
    }

    private Point create(Double lat, Double lon, Auto auto, Long time, Double azimuth, Double speed) {
        Point point = new Point();
        point.setLat(lat);
        point.setLon(lon);
        point.setAuto(auto);
        point.setTime(time);
        point.setAzimuth(azimuth);
        point.setSpeed(speed);
        return pointRepository.save(point);
    }


    private void delete(User user) {
        userRepository.delete(user);
    }

    private void update(User user, String firstName, String lastName, String patronymic, String dateOfBirth,
                        Long driversLicense, Role role) {
        user.setFirstName(firstName);
        user.setLastName(lastName);
        user.setPatronymic(patronymic);
        user.setDateOfBirth(dateOfBirth);
        user.setDriversLicense(driversLicense);
        user.setRole(role);
        userRepository.save(user);
    }

    private void readUser() {
        allUser = (List<User>) userRepository.findAll();

        if (allUser.size() == 0) {
            log.info("NO RECORDS USER");
        } else {
            allUser.stream().forEach(user -> log.info(user.toString()));
        }
    }

    private User create(Integer id, String firstName, String lastName, String patronymic, String dateOfBirth,
                        Long driversLicense, Role role, Set<Auto> autos) {
        User user = new User();
        user.setId(id);
        user.setFirstName(firstName);
        user.setLastName(lastName);
        user.setPatronymic(patronymic);
        user.setDateOfBirth(dateOfBirth);
        user.setDriversLicense(driversLicense);
        user.setRole(role);
        user.setAutos(autos);

        return userRepository.save(user);
    }
}
