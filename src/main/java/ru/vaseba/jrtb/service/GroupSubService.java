package ru.vaseba.jrtb.service;

import ru.vaseba.jrtb.javarushclient.dto.GroupDiscussionInfo;
import ru.vaseba.jrtb.repository.entity.GroupSub;

import java.util.List;
import java.util.Optional;

/**
 * Service for manipulating with {@link GroupSub}.
 */
public interface GroupSubService {

    GroupSub save(Long chatId, GroupDiscussionInfo groupDiscussionInfo);
    GroupSub save(GroupSub groupSub);
    Optional<GroupSub> findById(Integer id);
    List<GroupSub> findAll();
}
