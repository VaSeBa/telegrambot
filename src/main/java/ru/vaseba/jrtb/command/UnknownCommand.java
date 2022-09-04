package ru.vaseba.jrtb.command;

import org.telegram.telegrambots.meta.api.objects.Update;
import ru.vaseba.jrtb.service.SendBotMessageService;

import static ru.vaseba.jrtb.command.CommandUtils.getChatId;

/**
 * Unknown {@link Command}.
 */
public class UnknownCommand implements Command {

    public static final String UNKNOWN_MESSAGE = "Не понимаю вас \uD83D\uDE1F, напишите /help чтобы узнать что я понимаю.";

    private final SendBotMessageService sendBotMessageService;

    public UnknownCommand(SendBotMessageService sendBotMessageService) {
        this.sendBotMessageService = sendBotMessageService;
    }

    @Override
    public void execute(Update update) {
        sendBotMessageService.sendMessage(getChatId(update), UNKNOWN_MESSAGE);
    }
}
