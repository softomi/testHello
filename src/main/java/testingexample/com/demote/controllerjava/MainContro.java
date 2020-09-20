package testingexample.com.demote.controllerjava;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import testingexample.com.demote.entityjava.Employee;
import testingexample.com.demote.servicejava.ServiceMain;

@RestController
@RequestMapping("/")
public class MainContro {

	@Autowired
	ServiceMain service;
	@GetMapping("hello")
	public String helloWorld() {
		return ("hello world");
	}
	
	@GetMapping("calcu")
	public int caluclator(int a, int b) {
		return (a+b);
	}
	
	
	@GetMapping("entity")
	public Employee getData() {
		return new Employee(2L, "ana", "ana@gmail.com");
	}
	
}
