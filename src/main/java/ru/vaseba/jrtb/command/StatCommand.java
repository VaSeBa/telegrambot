package ru.vaseba.jrtb.command;

import org.springframework.beans.factory.annotation.Autowired;
import org.telegram.telegrambots.meta.api.objects.Update;
import ru.vaseba.jrtb.service.SendBotMessageService;
import ru.vaseba.jrtb.service.TelegramUserService;

import static ru.vaseba.jrtb.command.CommandUtils.getChatId;

/**
 * Statistics {@link Command}.
 */
public class StatCommand implements Command {

    private final TelegramUserService telegramUserService;
    private final SendBotMessageService sendBotMessageService;

    public final static String STAT_MESSAGE = "Javarush Telegram Bot использует %s человек.";

    @Autowired
    public StatCommand(SendBotMessageService sendBotMessageService, TelegramUserService telegramUserService) {
        this.sendBotMessageService = sendBotMessageService;
        this.telegramUserService = telegramUserService;
    }

    @Override
    public void execute(Update update) {
        int activeUserCount = telegramUserService.retrieveAllActiveUsers().size();
        sendBotMessageService.sendMessage(getChatId(update), String.format(STAT_MESSAGE, activeUserCount));
    }
}
