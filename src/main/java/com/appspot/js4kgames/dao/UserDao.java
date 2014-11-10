package com.appspot.js4kgames.dao;

import org.springframework.stereotype.Repository;
import com.appspot.js4kgames.model.User;
import static com.googlecode.objectify.ObjectifyService.ofy;

/**
 * DAO for the User entity.
 * 
 * @author js4kgames
 */
@Repository
public class UserDao {

    public void save(User user) {
        
    }
    
    public User find(String id) {
        User user = ofy().load().type(User.class).id(id).now();
        return user;
    }
}
