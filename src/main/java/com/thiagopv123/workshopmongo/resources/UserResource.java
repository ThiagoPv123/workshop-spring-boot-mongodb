package com.thiagopv123.workshopmongo.resources;

import com.thiagopv123.workshopmongo.domain.User;
import com.thiagopv123.workshopmongo.dto.UserDTO;
import com.thiagopv123.workshopmongo.repository.UserRepository;
import com.thiagopv123.workshopmongo.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping(value = "/users")
public class UserResource {

    @Autowired
    private UserService userService;

    @RequestMapping(method= RequestMethod.GET )
    public ResponseEntity<List<UserDTO>> findAll(){
        List<User> users = userService.findAll();
        List<UserDTO> listDTOs = users.stream().map(UserDTO::new).collect(Collectors.toList());
        return ResponseEntity.ok().body(listDTOs);
    }

    @RequestMapping(value = "/{id}", method= RequestMethod.GET )
    public ResponseEntity<UserDTO> findById(@PathVariable String id){
        User user = userService.findById(id);

        return ResponseEntity.ok().body(new UserDTO(user));
    }
    @RequestMapping(method= RequestMethod.POST )
    public ResponseEntity<Void> insert(@RequestBody UserDTO userDTO){
        User user = userService.fromDTO(userDTO);
        user = userService.insert(user);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(user.getId()).toUri();
        return ResponseEntity.created(uri).build();
    }
}
