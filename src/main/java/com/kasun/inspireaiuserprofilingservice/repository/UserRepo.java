package com.kasun.inspireaiuserprofilingservice.repository;

import com.kasun.inspireaiuserprofilingservice.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepo extends JpaRepository<User, Integer> {

}
