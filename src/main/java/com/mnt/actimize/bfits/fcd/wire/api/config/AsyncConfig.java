package com.mnt.actimize.bfits.fcd.wire.api.config;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

@Configuration
public class AsyncConfig {

    @Bean("taskExecutor")
    public ThreadPoolTaskExecutor taskExecutor() {
        ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
        executor.setCorePoolSize(5); // Adjust based on your needs
        executor.setMaxPoolSize(10); // Adjust based on your needs
        executor.setQueueCapacity(500); // Adjust based on your needs
        executor.setThreadNamePrefix("Async-");
        executor.initialize();
        return executor;
    }
}
