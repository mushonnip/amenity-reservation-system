package tech.mushonnip.ars.config;

import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;


@Configuration
@EntityScan("tech.mushonnip.ars.domain")
@EnableJpaRepositories("tech.mushonnip.ars.repos")
@EnableTransactionManagement
public class DomainConfig {
}
