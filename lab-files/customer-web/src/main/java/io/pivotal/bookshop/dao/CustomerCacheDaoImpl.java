package io.pivotal.bookshop.dao;

import io.pivotal.bookshop.domain.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.gemfire.GemfireTemplate;
import org.springframework.stereotype.Component;

@Component
public class CustomerCacheDaoImpl {
    GemfireTemplate customerTemplate;

}
