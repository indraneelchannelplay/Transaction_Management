package com.transanction.management.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.transanction.management.entity.User;

@Repository
public interface UserRepository extends JpaRepository<User,Long>{

}
