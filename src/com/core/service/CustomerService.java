package com.core.service;

import org.springframework.stereotype.Repository;

import com.core.pojo.Customer;
import com.core.utils.Page;



public interface CustomerService {
	
	/*
	 * ȫ���ͻ�
	 */
	public Page<Customer> CustomerList(Integer page, Integer rows, 
			String custName ,String custSource, 
			String custlndustry,String custLevel);
	
	 /*
     * ��ɾ���
     * */
    public void updateCustomerById(Customer customer);
    public void deleteCustomerById(Integer id);
    public void insertCustomer(Customer customer);

	public Customer selectCustomerById(Integer id);

}
