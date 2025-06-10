package com.thiagopv123.workshopmongo.resources;

import com.thiagopv123.workshopmongo.domain.Post;
import com.thiagopv123.workshopmongo.domain.User;
import com.thiagopv123.workshopmongo.dto.UserDTO;
import com.thiagopv123.workshopmongo.resources.util.URL;
import com.thiagopv123.workshopmongo.services.PostService;
import com.thiagopv123.workshopmongo.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping(value = "/posts")
public class PostResource {

    @Autowired
    private PostService postService;

    @RequestMapping(value = "/{id}", method= RequestMethod.GET )
    public ResponseEntity<Post> findById(@PathVariable String id){
        Post obj = postService.findById(id);

        return ResponseEntity.ok().body(obj);
    }

    @RequestMapping(value = "/titlesearch", method= RequestMethod.GET )
    public ResponseEntity<List<Post>> findByTitle(@RequestParam(value = "text", defaultValue = "") String text){
        text = URL.decodeParam(text);
        List<Post> obj = postService.findByTitle(text);
        return ResponseEntity.ok().body(obj);
    }

    @RequestMapping(value = "/fullsearch", method= RequestMethod.GET )
    public ResponseEntity<List<Post>> fullSearch(
            @RequestParam(value = "text", defaultValue = "") String text,
            @RequestParam(value = "minDate", defaultValue = "") String minDate,
            @RequestParam(value = "maxDate", defaultValue = "") String maxDate){
        text = URL.decodeParam(text);
        Date min = URL.convertDate(minDate, new Date(0L));
        Date max = URL.convertDate(maxDate, new Date());


        List<Post> obj = postService.fullSearch(text, min, max);
        return ResponseEntity.ok().body(obj);
    }

}


