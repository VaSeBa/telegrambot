package ru.vaseba.jrtb.command;

import org.telegram.telegrambots.meta.api.objects.Update;
import ru.vaseba.jrtb.repository.TelegramUser;
import ru.vaseba.jrtb.repository.entity.GroupSub;
import ru.vaseba.jrtb.service.SendBotMessageService;
import ru.vaseba.jrtb.service.TelegramUserService;

import javax.ws.rs.NotFoundException;

import java.util.stream.Collectors;

import static ru.vaseba.jrtb.command.CommandUtils.getChatId;

/**
 * {@link Command} for getting list of {@link GroupSub}.
 */
public class ListGroupSubCommand implements Command {

    private final SendBotMessageService sendBotMessageService;
    private final TelegramUserService telegramUserService;

    public ListGroupSubCommand(SendBotMessageService sendBotMessageService, TelegramUserService telegramUserService) {
        this.sendBotMessageService = sendBotMessageService;
        this.telegramUserService = telegramUserService;
    }

    @Override
    public void execute(Update update) {
        //todo add exception handling
        TelegramUser telegramUser = telegramUserService.findByChatId(getChatId(update))
                .orElseThrow(NotFoundException::new);

        String message = "Я нашел все подписки на группы: \n\n";
        String collectedGroups = telegramUser.getGroupSubs().stream()
                .map(it -> "Группа: " + it.getTitle() + " , ID = " + it.getId() + " \n")
                .collect(Collectors.joining());

        sendBotMessageService.sendMessage(telegramUser.getChatId(), message + collectedGroups);
    }
}
