package com.sanmartindev.workshopmongo.services;

import com.sanmartindev.workshopmongo.domain.Post;
import com.sanmartindev.workshopmongo.repository.PostRepository;
import com.sanmartindev.workshopmongo.services.exception.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class PostService {

    @Autowired
    private PostRepository repo;

    public Post findById(String id) {
        return repo.findById(id).orElseThrow(() -> new ObjectNotFoundException("Object not found"));
    }

    public List<Post> findByTitle(String text) {
        return repo.findByTitle(text);
    }

    public List<Post> fullSearch(String text, Date minDate, Date maxDate) {
        maxDate = new Date(maxDate.getTime() + 24 * 60 * 60 * 1000); // Add 24 hours to maxDate to include the whole day
        return repo.fullSearch(text, minDate, maxDate);
    }
}
