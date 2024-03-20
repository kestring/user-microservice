package com.ms.usermicroservice.repositories;

import com.ms.usermicroservice.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface UserRepository extends JpaRepository<User, UUID> {

}
