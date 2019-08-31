package com.mysqlauthentication.service;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;


public interface UserInfoService {

	public UserDetails loadUserByName(String userName);
}
