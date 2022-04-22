package se.iths.springloppis;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import se.iths.springloppis.entity.RoleEntity;
import se.iths.springloppis.repository.RoleRepository;

@SpringBootApplication
public class SpringLoppisApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringLoppisApplication.class, args);
    }


    // Generate data at start up
    @Bean
    public CommandLineRunner setUpRoles(RoleRepository roleRepository) {
        return (args) -> {
            roleRepository.save(new RoleEntity("ROLE_ADMIN"));
            roleRepository.save(new RoleEntity("ROLE_USER"));
        };
    }


}
