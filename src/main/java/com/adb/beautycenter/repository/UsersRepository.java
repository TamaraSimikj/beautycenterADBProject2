package com.adb.beautycenter.repository;

import com.adb.beautycenter.model.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.query.Procedure;


public interface UsersRepository extends JpaRepository<Users, Integer> {
    @Procedure(name = "RegisterClient", outputParameterName = "RETURN_VALUE")
    Integer registerClient(String username, String password, String cName, String surname, String phoneNumber, String email);
}
