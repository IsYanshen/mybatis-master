package com.alpha;

import java.util.List;
import java.util.Map;

public interface TodoMapper {
    Backlog getById1(Long id);

    Backlog getById2(Long id);

    Map<String, String> getTitleAndDescriptionById(Long id);

    List<Map<String, String>> getTitleAndDescription();

}
