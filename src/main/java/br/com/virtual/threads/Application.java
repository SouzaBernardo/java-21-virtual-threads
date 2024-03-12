package br.com.virtual.threads;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.annotation.Id;
import org.springframework.data.repository.ListCrudRepository;
import org.springframework.data.repository.Repository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;
import java.util.List;

@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

}

@RestController
@ResponseBody
class CustomerController {

	private final CustomerRepository customerRespository;

	public CustomerController(CustomerRepository customerRespository) {
		this.customerRespository = customerRespository;
	}

	@GetMapping("/customers")
	Collection<Customer> getCustomers() {
		return customerRespository.findAll();
	}
}

interface CustomerRepository extends ListCrudRepository<Customer, Integer> {}

record Customer (@Id Integer id, String name) {}