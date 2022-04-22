package com.example.annoyingbot;

import net.dv8tion.jda.api.entities.ChannelType;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import org.springframework.stereotype.Component;

@Component
public class BotListener extends ListenerAdapter {
    private static final Integer MAX_LENGTH = 1500;
    @Override
    public void onMessageReceived(MessageReceivedEvent event) {
        if(event.isFromType(ChannelType.TEXT) && event.getMessage().getContentRaw().length() > MAX_LENGTH) {
            event.getMessage().delete().queue();
        }
    }
}
