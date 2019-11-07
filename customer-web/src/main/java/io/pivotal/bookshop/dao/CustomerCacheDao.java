package io.pivotal.bookshop.dao;

import io.pivotal.bookshop.domain.Customer;
import org.apache.geode.cache.query.SelectResults;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.gemfire.GemfireTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Implementation designed to utilize the GemfireTemplate to perform operations
 *
 */
@Repository("customerCacheDao")
public class CustomerCacheDao implements CustomerDao {
    GemfireTemplate customerTemplate;

    /**
     * Inject in the GemfireTemplate. This comes from the configured components that are auto-configured
     * during startup. This also utilizes the automatic dependency injection mechanism, which implicitly
     * autowires in the dependency 'by-type'.
     *
     * @param template
     */
    @Autowired
    public CustomerCacheDao(  GemfireTemplate template) {
        customerTemplate = template;
    }

    @Override
    public int save(Customer customer) {
        customerTemplate.put(customer.getCustomerNumber(), customer);
        return 1;
    }

    @Override
    public void delete(Integer customerNumber) {
        customerTemplate.remove(customerNumber);
    }

    @Override
    public List<Customer> listCustomers(int maxResults) {
        SelectResults<Customer> results = customerTemplate.find("select * from /Customer limit $1", maxResults);
        return results.asList();
    }

    @Override
    public Customer findById(Integer customerNumber) {
        return customerTemplate.get(customerNumber);
    }

    @Override
    public Integer countCustomers() {
        return customerTemplate.execute( (region) -> region.sizeOnServer());

        /* This is the long form using annonymous inner class
        return customerTemplate.execute(new GemfireCallback<Integer>() {
            @Override
            public Integer doInGemfire(Region<?, ?> region) throws GemFireCheckedException, GemFireException {
                return region.sizeOnServer();
            }
        });
        */
    }

    @Override
    public boolean customerExists(Customer customer) {
        return customerTemplate.containsKeyOnServer(customer.getCustomerNumber());
    }
}
