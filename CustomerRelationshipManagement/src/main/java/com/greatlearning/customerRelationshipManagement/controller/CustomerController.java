package com.greatlearning.customerRelationshipManagement.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.greatlearning.customerRelationshipManagement.entity.Customer;
import com.greatlearning.customerRelationshipManagement.service.CustomerService;

@Controller
@RequestMapping("/customers")
public class CustomerController {

	@Autowired
	private CustomerService customerService;

	@RequestMapping("/list")
	public String customerList(Model theModel) {

		List<Customer> theCustomers = customerService.findAll();

		theModel.addAttribute("customers", theCustomers);

		return "customer-list";
	}

	@RequestMapping("/showFormForAdd")
	public String addCustomer(Model theModel) {

		Customer theCustomer = new Customer();

		theModel.addAttribute("customer", theCustomer);

		return "customer-form";
	}

	@RequestMapping("/showFormForUpdate")
	public String updateCustomer(@RequestParam("customerId") int theId, Model theModel) {

		// get the customer from the service
		Customer theCustomer = customerService.findById(theId);

		// set customer as a model attribute to pre-populate the form
		theModel.addAttribute("customer", theCustomer);

		return "customer-form";
	}

	@PostMapping("/save")
	public String saveCustomer(@RequestParam("id") int id, @RequestParam("firstName") String firstName, @RequestParam("lastName") String lastName, @RequestParam("email") String email) {

		System.out.println(id);
		Customer theCustomer;
		// update customer
		if(id != 0) {
			theCustomer = customerService.findById(id);
			theCustomer.setFirstName(firstName);
			theCustomer.setLastName(lastName);
			theCustomer.setEmail(email);
		// add customer
		} else {
			theCustomer = new Customer(firstName, lastName, email);
		}

		// save the customer
		customerService.save(theCustomer);

		// use a redirect to prevent duplicate submissions
		return "redirect:/customers/list";
	}

	@RequestMapping("/delete")
	public String deleteCustomer(@RequestParam("customerId") int theId) {

		// delete the customer
		customerService.deleteById(theId);

		// redirect to /customers/list
		return "redirect:/customers/list";
	}
	
}
