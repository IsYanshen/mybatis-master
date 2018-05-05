package com.alpha;

import java.util.List;

public interface BacklogMapper {
    BacklogV2 getBacklogV2ById(Long id);

    Address getAddressByBacklogId(Long id);

    List<Cooperator> getCooperatorsByBacklogId(Long id);

    void deleteBacklogById(Long id);

    void insertBacklog(BacklogV2 backlogV2);

}
