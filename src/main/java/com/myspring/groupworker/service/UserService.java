package com.myspring.groupworker.service;

import com.myspring.groupworker.model.User;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class UserService {

    Map<Integer, User> users;

    {
        users = new HashMap();

        users.put(1, new User("Vlad", 1));
        users.put(2, new User("David", 2));
        users.put(3, new User("Igor", 3));
        users.put(4, new User("Andrey", 3));
    }

    public User findById(Integer id){
        return users.get(id);
    }

    public Map<Integer, User> findByGroupId(Integer groupId){
        Set<Integer> foundUsersKeys = users.entrySet()
                .stream()
                .filter(x -> x.getValue().getGroupId() == groupId)
                .map(Map.Entry::getKey)
                .collect(Collectors.toSet());

        Map<Integer, User> foundUsers = new HashMap<>();
        for(Integer key : foundUsersKeys){
            foundUsers.put(key, users.get(key));
        }

        return foundUsers;
    }

    public Map<Integer, User> findAll(){
        return users;
    }

    public User saveNewUser(User user){
        return users.put(users.size() + 1, user);
    }

    public User saveOldUser(Integer id, User user){
        return users.put(id, user);
    }

    public void deleteById(Integer id){
        users.remove(id);
    }
}
