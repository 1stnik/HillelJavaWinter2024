package com.template.service;

import com.template.dto.User;
import java.util.HashMap;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class UserServiceMapImpl implements UserService {
    private HashMap<String, User> userMap;

    public UserServiceMapImpl() {
        userMap = new HashMap<>();
    }

    @Override
    public void addUser(User user) {
        userMap.put(user.getId(), user);
    }

    @Override
    public List<User> getUsers() {
        return userMap.values().stream().toList();
    }

    @Override
    public User getUser(String id) {
        return userMap.get(id);
    }

    @Override
    public User editUser(User forEdit) {
////        try {
//            if (forEdit.getId() == null)
//                throw new UserException("ID cannot be blank");
//
//            User toEdit = userMap.get(forEdit.getId());
//
//            if (toEdit == null)
//                throw new UserException("User not found");
//
//            if (forEdit.getEmail() != null) {
//                toEdit.setEmail(forEdit.getEmail());
//            }
//            if (forEdit.getFirstName() != null) {
//                toEdit.setFirstName(forEdit.getFirstName());
//            }
//            if (forEdit.getLastName() != null) {
//                toEdit.setLastName(forEdit.getLastName());
//            }
//            if (forEdit.getId() != null) {
//                toEdit.setId(forEdit.getId());
//            }
//
//            return toEdit;
//        } catch (Exception ex) {
////            throw new UserException(ex.getMessage());
//        }

        return null;
    }

    @Override
    public void deleteUser(String id) {
        userMap.remove(id);
    }

    @Override
    public boolean userExist(String id) {
        return userMap.containsKey(id);
    }

}
