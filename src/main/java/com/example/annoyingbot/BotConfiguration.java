package com.example.annoyingbot;

import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.security.auth.login.LoginException;
import java.util.List;

@Configuration
public class BotConfiguration {

    List<ListenerAdapter> listeners;

    public BotConfiguration(List<ListenerAdapter> listeners) {
        this.listeners = listeners;
    }

    @Bean
    public JDA initializeBot(@Value("${bot.token}") String token) throws LoginException {
        return JDABuilder
                .createDefault(token)
                .addEventListeners(listeners.toArray())
                .build();

    }
}
