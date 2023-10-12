package com.sanmartindev.workshopmongo.services;

import com.sanmartindev.workshopmongo.domain.Post;
import com.sanmartindev.workshopmongo.repository.PostRepository;
import com.sanmartindev.workshopmongo.services.exception.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PostService {

    @Autowired
    private PostRepository repo;

    public Post findById(String id) {
        return repo.findById(id).orElseThrow(() -> new ObjectNotFoundException("Object not found"));
    }

}
