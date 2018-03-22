package com.bank.mts.repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceContextType;
import javax.persistence.PersistenceUnit;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.bank.mts.model.Account;

//@Component("jpaAccountRepository")
@Repository("jpaAccountRepository")
public class JpaAccountRepository implements AccountRepository {

	@PersistenceContext
	private EntityManager entityManager;

	public Account loadAccount(String num) {
		return entityManager.find(Account.class, num);
	}

	public boolean updateAcount(Account account) {
		entityManager.merge(account);
		return true;
	}

}
