package com.example.demo.Security.utilities;

import org.springframework.data.repository.CrudRepository;
import com.example.demo.Security.models.LoginFields;

public interface SecurityRepository extends CrudRepository<LoginFields, Integer>{

}
