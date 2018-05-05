package com.alpha;

import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface BacklogMapper {
    BacklogV2 getBacklogV2ById(Long id);

    Address getAddressByBacklogId(Long id);

    List<Cooperator> getCooperatorsByBacklogId(Long id);


    void deleteBacklogById(Long id);

    void insertBacklog(BacklogV2 backlogV2);

    void updateBacklog1(@Param("backlogId") Long id, @Param("newState") BacklogState newState);

    void updateBacklog2(@Param("backlogId") Long id, @Param("names") String[] columns, @Param("newValues") Object[] values);

    void updateBacklog2Plus(@Param("backlogId") Long id, @Param("names") String[] columns, @Param("newValues") Object[] values);

    void updateBacklog3(@Param("backlogId") Long id, @Param("newBacklogV2") BacklogV2 newBacklogV2);

    void updateBacklog4(BacklogV2 newBacklogV2);

}
