package com.example.demo.utilities;

import org.springframework.data.repository.CrudRepository;

import com.example.demo.models.Billionaires;  

public interface BillionairesRepository extends CrudRepository<Billionaires, Integer>  {

}
