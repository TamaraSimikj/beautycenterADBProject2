package com.adb.beautycenter.config;

import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;


@Configuration
@EntityScan("com.adb.beautycenter")
@EnableJpaRepositories("com.adb.beautycenter")
@EnableTransactionManagement
public class DomainConfig {
}
