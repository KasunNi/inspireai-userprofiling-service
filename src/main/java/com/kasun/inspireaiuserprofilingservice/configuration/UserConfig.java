package com.kasun.inspireaiuserprofilingservice.configuration;

import com.kasun.inspireaiuserprofilingservice.service.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class UserConfig {

	@Bean
	public UserService userBean() {
		return new UserService();
	}

	@Bean
	public ModelMapper modelMapperBean() {
		return new ModelMapper();
	}

}
