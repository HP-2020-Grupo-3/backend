package com.hp2020g3.venidemary.repository;

import com.hp2020g3.venidemary.model.Role;
import java.util.Optional;
import org.springframework.data.repository.CrudRepository;

public interface RoleRepository extends CrudRepository<Role, Integer>{
	
	Optional<Role> findByName(String name);

}
