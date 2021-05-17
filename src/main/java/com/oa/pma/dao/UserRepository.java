package com.oa.pma.dao;

import com.oa.pma.entity.UserAccount;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<UserAccount, Long> {
	
}
