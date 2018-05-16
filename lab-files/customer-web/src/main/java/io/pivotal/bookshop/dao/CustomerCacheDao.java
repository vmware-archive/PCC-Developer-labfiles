package io.pivotal.bookshop.dao;

import io.pivotal.bookshop.domain.Customer;

public interface CustomerCacheDao {
    void save(Customer customer);

    Customer findById(Integer customerNumber);
}
