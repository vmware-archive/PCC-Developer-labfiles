package io.pivotal.bookshop;

import io.pivotal.bookshop.dao.CustomerRepository;
import io.pivotal.bookshop.domain.Customer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class CustomerWebApplication extends SpringBootServletInitializer {
	private final Logger logger = LoggerFactory.getLogger("CustomerWebApplication");

	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {

		return application.sources(CustomerWebApplication.class);
	}

	public static void main(String[] args) {
		SpringApplication.run(CustomerWebApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(CustomerRepository customerRepo) {
		return args -> {
				customerRepo.save(new Customer(1001, "Hatty", "Carsberg", "34102"));
				customerRepo.save(new Customer(1002, "Conrado", "Carvill", "76129"));
				customerRepo.save(new Customer(1003, "Jasun", "Barwood", "66606"));
				logger.info("Total entries: " + customerRepo.count());


		};
	}

}
