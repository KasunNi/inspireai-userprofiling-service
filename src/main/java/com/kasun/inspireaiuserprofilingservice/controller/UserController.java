package com.kasun.inspireaiuserprofilingservice.controller;

import com.kasun.inspireaiuserprofilingservice.entity.User;
import com.kasun.inspireaiuserprofilingservice.response.UserResponse;
import com.kasun.inspireaiuserprofilingservice.service.UserService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

	@Autowired
	private UserService userService;

	@CrossOrigin(origins = "*", allowedHeaders = "*", methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE})
	@GetMapping("/users/{id}")
	private ResponseEntity<UserResponse> getUserDetails(@PathVariable("id") int id) {
		UserResponse user = userService.getUserById(id);
		if (user != null) {
            //return ResponseEntity.ok(user); // 200 OK
            return ResponseEntity.status(HttpStatus.OK).body(user);
        } else {
            return ResponseEntity.notFound().build(); // 404 Not Found
        }
	}
	
	@CrossOrigin(origins = "*", allowedHeaders = "*", methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE})
	@GetMapping("/users")
    public ResponseEntity<List<UserResponse>> getAllUsers() {
        List<UserResponse> users = userService.getAllUsers();
        if (!users.isEmpty()) {
            return ResponseEntity.status(HttpStatus.OK).body(users); // 200 OK
        } else {
            return ResponseEntity.notFound().build(); // 404 Not Found if no users found
        }
    }
	
	@CrossOrigin(origins = "*", allowedHeaders = "*", methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE})
	@PostMapping("/users")
    public ResponseEntity<UserResponse> createUser(@RequestBody User newUser) {
        UserResponse createdUser = userService.createUser(newUser);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdUser); // 201 Created
    }
	
	@CrossOrigin(origins = "*", allowedHeaders = "*", methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE})
	@PutMapping("/users/{id}")
    public ResponseEntity<UserResponse> updateUser(@PathVariable("id") int id,
                                                   @RequestBody User modifiedUser) {
        UserResponse updatedUser = userService.updateUser(id, modifiedUser);
        return ResponseEntity.status(HttpStatus.OK).body(updatedUser); // 200 OK
    }
	
	@CrossOrigin(origins = "*", allowedHeaders = "*", methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE})
	@DeleteMapping("/users/{id}")
    public ResponseEntity<Void> deleteUser(@PathVariable("id") int id) {
        userService.deleteUserById(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build(); // 204 No Content
    }

}
