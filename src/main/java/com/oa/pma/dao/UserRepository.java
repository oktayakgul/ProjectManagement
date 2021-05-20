package com.oa.pma.dao;

import com.oa.pma.entity.UserAccount;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface UserRepository extends PagingAndSortingRepository<UserAccount, Long> {
	
}
