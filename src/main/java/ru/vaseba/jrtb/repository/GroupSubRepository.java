package ru.vaseba.jrtb.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.vaseba.jrtb.repository.entity.GroupSub;

/**
 * {@link Repository} for {@link GroupSub} entity.
 */

@Repository
public interface GroupSubRepository extends JpaRepository<GroupSub, Integer> {
}
