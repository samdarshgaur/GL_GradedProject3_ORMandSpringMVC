package com.greatlearning.customerRelationshipManagement.service;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.greatlearning.customerRelationshipManagement.entity.Customer;

@Repository
public class CustomerServiceImpl implements CustomerService {

	Session session;

	// @Autowired helps to inject all the dependencies needed; all the info is in the spring-mvc-servlet.xml file
	@Autowired
	CustomerServiceImpl(SessionFactory sessionFactory) {
		// if you are firing your first request to the server it will go to the catch block because there will be no session for the first time and hibernate will throw exception that will be handled by catch block. catch block will open the session.
		// for all the further request it will go to the try block
		try {
			session = sessionFactory.getCurrentSession();
		} catch(HibernateException e) {
			session = sessionFactory.openSession();
		}
	}

	@Transactional
	public List<Customer> findAll() {

		Transaction tx = session.beginTransaction();

		List<Customer> customers = session.createQuery("from Customer").list();

		tx.commit();

		return customers;
		
	}

	@Transactional
	public Customer findById(int theId) {

		Customer customer = new Customer();

		Transaction tx = session.beginTransaction();

		customer = session.get(Customer.class, theId);

		tx.commit();

		return customer;
	}

	@Transactional
	public void save(Customer theCustomer) {

		Transaction tx = session.beginTransaction();

		session.saveOrUpdate(theCustomer);

		tx.commit();

	}

	@Transactional
	public void deleteById(int theId) {

		Transaction tx = session.beginTransaction();

		// get transaction
		Customer customer = session.get(Customer.class, theId);

		// delete record
		session.delete(customer);

		tx.commit();

	}
	
}
