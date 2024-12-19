package com.transanction.management.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.transanction.management.entity.Wallet;

public interface WalletRepository extends JpaRepository<Wallet, Long> {
}