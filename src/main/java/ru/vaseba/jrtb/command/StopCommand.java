package ru.vaseba.jrtb.command;

import org.telegram.telegrambots.meta.api.objects.Update;
import ru.vaseba.jrtb.service.SendBotMessageService;
import ru.vaseba.jrtb.service.TelegramUserService;

import static ru.vaseba.jrtb.command.CommandUtils.getChatId;

/**
 * Stop {@link Command}.
 */
public class StopCommand implements Command {

    private final SendBotMessageService sendBotMessageService;
    private final TelegramUserService telegramUserService;

    public static final String STOP_MESSAGE = "Деактивировал все ваши подписки \uD83D\uDE1F.";

    public StopCommand(SendBotMessageService sendBotMessageService, TelegramUserService telegramUserService) {
        this.sendBotMessageService = sendBotMessageService;
        this.telegramUserService = telegramUserService;
    }

    @Override
    public void execute(Update update) {
        sendBotMessageService.sendMessage(getChatId(update), STOP_MESSAGE);
        telegramUserService.findByChatId(getChatId(update))
                .ifPresent(it -> {
                    it.setActive(false);
                    telegramUserService.save(it);
                });
    }
}
