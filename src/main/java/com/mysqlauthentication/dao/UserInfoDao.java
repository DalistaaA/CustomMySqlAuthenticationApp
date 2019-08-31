package com.mysqlauthentication.dao;

import com.mysqlauthentication.entities.UserInfo;

public interface UserInfoDao {

	public abstract UserInfo getActiveUser(String userName);
}
