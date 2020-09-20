package testingexample.com.demote.servicejava;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
@Component
@Service
public class ServiceMain {

	public int sum (int a, int b) {
		return a+b;
	}
	
}
