package io.pivotal.bookshop.config;

import io.pivotal.bookshop.dao.CustomerCacheDao;
import io.pivotal.bookshop.dao.CustomerCacheDaoImpl;
import io.pivotal.bookshop.domain.Customer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = "io.pivotal.bookshop")
public class CustomerWebApplication extends SpringBootServletInitializer {
    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {

        return application.sources(CustomerWebApplication.class);
    }

    public static void main(String[] args) {
        Logger logger = LoggerFactory.getLogger("CustomerWebApplication");
        ApplicationContext context = SpringApplication.run(CustomerWebApplication.class, args);
        CustomerCacheDao dao = context.getBean(CustomerCacheDao.class);
        dao.save(new Customer(1001, "Hatty", "Carsberg", "34102"));
        dao.save(new Customer(1002, "Conrado", "Carvill", "76129"));
        dao.save(new Customer(1003, "Jasun", "Barwood", "66606"));

    }
}
