package com.smartbank.smartbankmanager.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.smartbank.smartbankmanager.entities.Customer;
import com.smartbank.smartbankmanager.services.CustomerService;

import helper.Message;


@Controller
public class CustomerController {
	
	@Autowired
	CustomerService cs;
	
	@GetMapping("/home")
	public String gethome(Model model){
		model.addAttribute("title", "Home - Smart Bank Manager");
		return "home";		
	}
	
	@GetMapping("/login")
	public String login(Model model){
		model.addAttribute("title", "Login - Smart Bank Manager");
		return "login";		
	}

	@GetMapping("/signup")
	public String signUp(Model model){
		model.addAttribute("title", "Sign Up - Smart Bank Manager");
		return "SignUp";		
	}
	@GetMapping("/dashboard")
	public String dashboard(){
		return "dashboard";		
	}
	@GetMapping("/transaction")
	public String transaction(){
		return "transaction";		
	}
	@RequestMapping(value="/do_register", method= RequestMethod.POST)
	public String registerUser(@ModelAttribute("Customer") Customer customer,@RequestParam(value="agreement",defaultValue= "false")boolean agreement , Model model,HttpSession session)
	{
		try {
			if(!agreement) {
			throw new Exception("You have not agreed terms and conditions.");
			}
			customer.setSavingaccbalance(500);
			Customer result=cs.addCustomer(customer);
			model.addAttribute("customer", new Customer());
			session.setAttribute("message", new Message("Succesfully Registered ","alert-success"));
			return "Signup";
		}
		catch(Exception ex) {
			ex.printStackTrace();
			model.addAttribute("customer", customer);
			session.setAttribute("message", new Message("Something went wrong !! " + ex.getMessage(),"alert-error"));
			return "Signup";
		}	
	}
	@RequestMapping(value="/do_signin", method= RequestMethod.POST)
	public String signin(@ModelAttribute("Customer") Customer customer, Model model,HttpSession session)
	{
		try {
		
			Customer result=cs.getCustomerByEmail(customer.getEmail());
			if(result!=null) {
			model.addAttribute("customer", result);
			return "dashboard";
			}
			else
			{
				model.addAttribute("customer", customer);
				session.setAttribute("message", new Message("Invalid Credentials ","alert-error"));
				return "login";
			}
		}
		catch(Exception ex) {
			ex.printStackTrace();
			model.addAttribute("customer", customer);
			session.setAttribute("message", new Message("Something went wrong !! " + ex.getMessage(),"alert-error"));
			return "login";
		}	
	}
	
	@RequestMapping(value="/do_transaction/{cid}", method= RequestMethod.POST)
	public String transact(@PathVariable("cid") Integer cid, Model model)
	{
		Customer customer=  cs.getById(cid);
		model.addAttribute("customer", customer);
		return "transaction";
			
	}
	@RequestMapping(value="/do_sendmoney/{cid}", method= RequestMethod.POST)
	public String sendmoney(@PathVariable("cid") Integer cid, Model model,
			@RequestParam(value="name",defaultValue= "false")String name ,
			@RequestParam(value="amount",defaultValue= "false")String  amount ,
			@RequestParam(value="password",defaultValue= "false")String password,HttpSession session)
	{
		try {
			System.out.println(name + amount + password);
			Customer customer=  cs.getById(cid);
			Customer reciver= cs.getCustomerByEmail(name);
			int total= customer.getCurrentaccbalance()-Integer.valueOf(amount);
			if(reciver.getId()==customer.getId() && customer.getSavingaccbalance()> Integer.valueOf(amount)) {
				customer.setCurrentaccbalance(customer.getCurrentaccbalance() +Integer.valueOf(amount) );
				customer.setSavingaccbalance(customer.getSavingaccbalance() -Integer.valueOf(amount) );
				cs.updateCustomer(customer);
				model.addAttribute("customer", customer);
				System.out.println(customer);
				session.setAttribute("message", new Message("Successfully Sent","alert-success"));
				return "transaction";
			}
			if(total<0)
			{
					model.addAttribute("customer", customer);
					session.setAttribute("message", new Message("Amounnt is not correct","alert-error"));
					return "transaction";
					
			}
			if(reciver==null) {
				model.addAttribute("customer", customer);
				session.setAttribute("message", new Message("Invalid Credentials","alert-error"));
				return "transaction";
			}
			
			customer.setCurrentaccbalance(total);
			reciver.setCurrentaccbalance(reciver.getCurrentaccbalance()+ Integer.valueOf(amount));
			cs.updateCustomer(customer);
			cs.updateCustomer(reciver);
			model.addAttribute("customer", customer);
			session.setAttribute("message", new Message("Successfully Sent","alert-success"));
			System.out.println(customer);
			return "transaction";
				
		}
		catch(Exception ex) {
			ex.printStackTrace();
			Customer customer= new Customer();
			customer.setId(cid);
			
			model.addAttribute("customer", customer);
			session.setAttribute("message", new Message("Something went wrong !! " + ex.getMessage(),"alert-error"));

			return "transaction";
		}
		
	}
}
	