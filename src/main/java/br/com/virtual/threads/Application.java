package br.com.virtual.threads;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.annotation.Id;

@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

}

sealed interface Loan permits SecuredLoan, UnsecuredLoan {}

record SecuredLoan(int value) implements Loan {}

record UnsecuredLoan() implements Loan {}

class Message {
	String messageForLoan(Loan loan) {
		return switch (loan) {
			case UnsecuredLoan unsecuredLoan -> "";
			case SecuredLoan (var value) -> "" + value;
		};
	}
}

record Customer (@Id Integer id, String name) {}