package com.example.annoyingbot;

import net.dv8tion.jda.api.JDA;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class BotRunner implements CommandLineRunner {
    private JDA botInstance;
    private static Logger logger = LoggerFactory.getLogger(BotRunner.class);

    public BotRunner(JDA botInstance) {
        this.botInstance = botInstance;
    }

    @Override
    public void run(String... args) throws Exception {
        botInstance.awaitReady();
        logger.info("Bot started");
        botInstance.getGuilds().forEach(System.out::println);
    }
}
