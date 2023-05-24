package com.user.registration.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.user.registration.entity.UserWalletEntity;

@Repository
public interface UserWalletRepository extends JpaRepository<UserWalletEntity, Integer>{

}
