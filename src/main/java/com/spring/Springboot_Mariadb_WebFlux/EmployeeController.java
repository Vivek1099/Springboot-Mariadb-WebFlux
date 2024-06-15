package com.spring.Springboot_Mariadb_WebFlux;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
public class EmployeeController 
{
	@Autowired 
	EmployeeRepository erepo;

	@RequestMapping("/test")
	public String test()
	{
		return "This is a webflux test";
	}
	
	@RequestMapping("/save")
	public Mono<Employee> savedata(@RequestBody Employee employee)
	{
//		erepo.save(employee);
		return erepo.save(employee);
	}
	
	@RequestMapping("/show")
	public Flux<Employee> showall()
	{
		return erepo.findAll();
	}
	
	@RequestMapping("/id/{id}")
	public Mono<Employee> byId(@PathVariable int id)
	{
		return erepo.findById(id);
	}
	
	@RequestMapping("/delid/{id}")
	public Mono<Void> DelById(@PathVariable int id)
	{
		return erepo.deleteById(id);
	}
	
	@RequestMapping("/bycity/{city}")
	public Flux<Employee> findByCity(@PathVariable String city)
	{
		return erepo.findByCity(city);
	}
	
	@RequestMapping("/byname/{name}")
	public Flux<Employee> ByName(@PathVariable String name)
	{
		return erepo.findByName(name);
	}
	
	@RequestMapping("/bynameorcity/{name}/{city}")
	public Flux<Employee> ByNameorCity(@PathVariable String name,@PathVariable String city)
	{
		return erepo.findByNameOrCity(name,city);
	}
	
	@RequestMapping("/bynameandcity/{name}/{city}")
	public Flux<Employee> ByNameAndCity(@PathVariable String name,@PathVariable String city)
	{
		return erepo.findByNameAndCity(name, city);
	}
	
//	@RequestMapping("/update")
//	public Mono<Employee> update(@RequestBody Employee employee, @PathVariable int id) throws Exception
//	{
//		Employee employeeupdate=erepo.findById(id).block();
//		
//		// .orElseThrow(() -> new ResourceNotFoundException("Employee not exist with id: " + id));
//		  if (employeeupdate != null) 
//		  {
//		   employeeupdate.setName(employee.getName());
//		   employeeupdate.setCity(employee.getCity());
//		   return erepo.save(employeeupdate);
//		  } 
//		  else 
//		  {
//		   throw new Exception("Employee not exist with id :" + id);
//		  }

//	}

}

