package com.thiagopv123.workshopmongo.services;

import com.thiagopv123.workshopmongo.domain.Post;
import com.thiagopv123.workshopmongo.domain.User;
import com.thiagopv123.workshopmongo.dto.UserDTO;
import com.thiagopv123.workshopmongo.repository.PostRepository;
import com.thiagopv123.workshopmongo.repository.UserRepository;
import com.thiagopv123.workshopmongo.services.exception.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PostService {
    @Autowired
    private PostRepository repo;

    public Post findById(String id){
        Optional<Post> user = repo.findById(id);
        return user.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado"));
    }


}
