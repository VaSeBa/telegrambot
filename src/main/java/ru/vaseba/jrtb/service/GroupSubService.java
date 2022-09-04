package ru.vaseba.jrtb.service;

import ru.vaseba.jrtb.javarushclient.dto.GroupDiscussionInfo;
import ru.vaseba.jrtb.repository.entity.GroupSub;

/**
 * Service for manipulating with {@link GroupSub}.
 */
public interface GroupSubService {

    GroupSub save(String chatId, GroupDiscussionInfo groupDiscussionInfo);
}
