package com.sanmartindev.workshopmongo.services;

import com.sanmartindev.workshopmongo.domain.User;
import com.sanmartindev.workshopmongo.dto.UserDTO;
import com.sanmartindev.workshopmongo.repository.UserRepository;
import com.sanmartindev.workshopmongo.services.exception.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository repo;

    public List<User> findAll() {
        return repo.findAll();
    }

    public User findById(String id) {
        return repo.findById(id).orElseThrow(() -> new ObjectNotFoundException("Object not found"));
    }

    public User insert(User user) {
         return repo.insert(user);
    }

    public User fromDTO(UserDTO objDto) {
    	return new User(objDto.getId(), objDto.getName(), objDto.getEmail());
    }
}
