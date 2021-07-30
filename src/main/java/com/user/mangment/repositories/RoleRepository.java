package com.user.mangment.repositories;

import com.user.mangment.entities.Role;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RoleRepository extends JpaRepository<Role,Integer> {

    List<Role> findByRoleNameIn(List<String> roles);
}
