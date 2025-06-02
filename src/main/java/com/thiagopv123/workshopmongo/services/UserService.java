package com.thiagopv123.workshopmongo.services;

import com.thiagopv123.workshopmongo.domain.User;
import com.thiagopv123.workshopmongo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    @Autowired
    private UserRepository repo;

    public List<User> findAll(){
        return repo.findAll();
    }
}
