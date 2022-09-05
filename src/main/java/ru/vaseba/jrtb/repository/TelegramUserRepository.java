package ru.vaseba.jrtb.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.vaseba.jrtb.repository.entity.TelegramUser;

import java.util.List;

/**
 * {@link Repository} for handling with {@link TelegramUser} entity.
 */

@Repository
public interface TelegramUserRepository extends JpaRepository<TelegramUser, Long> {
    List<TelegramUser> findAllByActiveTrue();
}
