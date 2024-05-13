package com.exchanger.repository;

import com.exchanger.model.User;
import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    List<User> findAllByEmailOrPhone(String email, String phone);

    Optional<User> findByPhone(String phone);

}
