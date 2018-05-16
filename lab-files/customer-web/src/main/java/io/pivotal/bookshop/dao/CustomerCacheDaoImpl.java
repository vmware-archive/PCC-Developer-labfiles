package io.pivotal.bookshop.dao;

import io.pivotal.bookshop.domain.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.gemfire.GemfireTemplate;
import org.springframework.stereotype.Component;

@Component
public class CustomerCacheDaoImpl implements CustomerCacheDao {
    GemfireTemplate customerTemplate;

    @Autowired
    public CustomerCacheDaoImpl(GemfireTemplate gfTemplate) {
        customerTemplate = gfTemplate;
    }

    @Override
    public void save(Customer customer) {
        customerTemplate.put(customer.getCustomerNumber(), customer);
    }

    @Override
    public Customer findById(Integer customerNumber) {
        return customerTemplate.get(customerNumber);
    }
}
