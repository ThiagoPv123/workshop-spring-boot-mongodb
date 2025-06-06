package com.thiagopv123.workshopmongo.repository;

import com.thiagopv123.workshopmongo.domain.Post;
import com.thiagopv123.workshopmongo.domain.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PostRepository extends MongoRepository<Post, String> {

}
