package com.sanmartindev.workshopmongo.resources;

import com.sanmartindev.workshopmongo.domain.User;
import com.sanmartindev.workshopmongo.dto.UserDTO;
import com.sanmartindev.workshopmongo.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/users")

public class UserResource {
	@Autowired
	private UserService service;

	@GetMapping
    public ResponseEntity<List<UserDTO>> findAll() {
        List<User> list = service.findAll();
        List<UserDTO> listDto = list.stream().map(UserDTO::new).toList();
        return ResponseEntity.ok().body(listDto);
    }
}