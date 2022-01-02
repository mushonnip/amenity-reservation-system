package tech.mushonnip.ars;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import tech.mushonnip.ars.model.AmenityType;
import tech.mushonnip.ars.model.Reservation;
import tech.mushonnip.ars.model.User;
import tech.mushonnip.ars.repos.ReservationRepository;
import tech.mushonnip.ars.repos.UserRepository;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.ZoneId;
import java.util.Date;


@SpringBootApplication
public class ArsApplication {

    public static void main(String[] args) {
        SpringApplication.run(ArsApplication.class, args);
    }

    @Bean
    public CommandLineRunner loadData(UserRepository userRepository,
                                      ReservationRepository reservationRepository) {
        return (args) -> {
            User user =
                    userRepository.save(
                            new User("Yigit Kemal Erinc",
                                    "yigitesrinc",
                                    bCryptPasswordEncoder().encode("12345")));
            DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
            Date date = new Date();
            LocalDate localDate = date.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
            Reservation reservation =
                    Reservation.builder()
                            .reservationDate(localDate)
                            .startTime(LocalTime.of(12, 00))
                            .endTime(LocalTime.of(13, 00))
                            .user(user)
                            .amenityType(AmenityType.POOL)
                            .build();

            reservationRepository.save(reservation);
        };
    }

    @Bean
    public BCryptPasswordEncoder bCryptPasswordEncoder() {
        return new BCryptPasswordEncoder();
    }
}
