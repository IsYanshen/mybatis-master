package com.alpha;

import org.apache.ibatis.annotations.Param;

public interface TodoMapper {

    void delete(Long id);

    void update(@Param("backlogId") Long id, @Param("newState") BacklogState newState);

    void insert(Backlog backlog);
}
