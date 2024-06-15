package com.spring.Springboot_Mariadb_WebFlux;

import org.springframework.data.repository.reactive.ReactiveCrudRepository;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface EmployeeRepository extends ReactiveCrudRepository<Employee,Integer>
{
	Flux<Employee> findByName (String name);	
    Flux<Employee> findByCity(String city);
    Flux<Employee> findByNameOrCity (String emp_name, String city);
	Flux<Employee> findByNameAndCity (String emp_name, String city);
//	Mono<Employee> UpdateById(Employee employee,int id);
}
