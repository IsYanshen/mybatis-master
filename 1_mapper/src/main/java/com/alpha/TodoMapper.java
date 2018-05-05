package com.alpha;

import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface TodoMapper {
    Backlog getById(Long id);

    List<Backlog> getAll();

    List<Backlog> getPendings();

    void delete(Long id);

    void update(@Param("backlogId") Long id, @Param("newState") BacklogState newState);

    void insert(Backlog backlog);
}
