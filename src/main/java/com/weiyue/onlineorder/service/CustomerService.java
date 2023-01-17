package com.weiyue.onlineorder.service;

import com.weiyue.onlineorder.entity.Customer;
import com.weiyue.onlineorder.entity.Cart;
import com.weiyue.onlineorder.dao.CustomerDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CustomerService {
    private CustomerDao customerDao;

    @Autowired
    public CustomerService(CustomerDao customerDao){
        this.customerDao = customerDao;
    }

    public void signUp(Customer customer){
        Cart cart = new Cart();
        customer.setCart(cart);

        customer.setEnabled(true);
        customerDao.signUp(customer);
    }

    public Customer getCustomer(String email){
        return customerDao.getCustomer(email);
    }
}
