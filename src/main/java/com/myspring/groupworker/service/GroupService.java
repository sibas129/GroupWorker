package com.myspring.groupworker.service;

import com.myspring.groupworker.model.Group;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class GroupService {
    Map<Integer, Group> groups = new HashMap<>();

    {
        groups.put(1, new Group("Разработчики"));
        groups.put(2, new Group("Тестировщики"));
        groups.put(3, new Group("Аналитики"));
    }

    public Group findById(int id){
        return groups.get(id);
    }

    public List<Group> findAll(){
        return new ArrayList<>(groups.values());
    }

    public Group saveNewGroup(Group group){
        return groups.put(groups.size() + 1, group);
    }

    public void deleteById(int id){
        groups.remove(id);
    }
}
