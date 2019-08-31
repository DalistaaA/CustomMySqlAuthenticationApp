package com.mysqlauthentication.daoImpl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Service;

import com.mysqlauthentication.dao.UserInfoDao;
import com.mysqlauthentication.entities.UserInfo;

@Service
public class UserInfoDaoImpl implements UserInfoDao {

	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public UserInfo getActiveUser(String userName) {
		UserInfo userInfo = new UserInfo();
		int ENABLED = 1;
		List<?> list = entityManager.createQuery("SELECT u FROM UserInfo u WHERE userName =? and enabled =?")
				.setParameter(1, userName).setParameter(2, ENABLED).getResultList();
		if(!list.isEmpty()) {
			userInfo = (UserInfo) list.get(0);
		}

		return userInfo;
	}

}
