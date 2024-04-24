package com.kasun.inspireaiuserprofilingservice.service;

import com.kasun.inspireaiuserprofilingservice.entity.User;
import com.kasun.inspireaiuserprofilingservice.repository.UserRepo;
import com.kasun.inspireaiuserprofilingservice.response.UserResponse;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class UserService { 

	@Autowired
	private UserRepo userRepo;

	@Autowired
	private ModelMapper mapper;

	public UserResponse getUserById(int id) {
		Optional<User> user = userRepo.findById(id);
		UserResponse userResponse = mapper.map(user, UserResponse.class);
		return userResponse;
	}
	
	public List<UserResponse> getAllUsers() {
        List<User> users = userRepo.findAll();
        return users.stream()
                    .map(user -> mapper.map(user, UserResponse.class))
                    .collect(Collectors.toList());
    }
	
	 public UserResponse createUser(User userData) {
	        User user = mapper.map(userData, User.class);
	        user = userRepo.save(user);
	        return mapper.map(user, UserResponse.class);
	 }
	 
	 public UserResponse updateUser(int id, User userData) {
	        User existingUser = userRepo.findById(id)
	                .orElseThrow();
	        mapper.map(userData, existingUser);
	        existingUser = userRepo.save(existingUser);
	        return mapper.map(existingUser, UserResponse.class);
	 }
	 
	 public void deleteUserById(int id) {
	        userRepo.deleteById(id);
	 }

}
