package myspring.customer.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import myspring.customer.service.CustomerService;
import myspring.customer.vo.CustomerVo;

@Controller
public class CustomerController {
	@Autowired
	private CustomerService customerService;
	
	//view Model을 한꺼번에 전달하는 방법
	@RequestMapping("/customerList.do")
	public ModelAndView customerList() {
		List<CustomerVo> customerVoList = customerService.selectCustomerList();
		
		return new ModelAndView("customerList", "customerList", customerVoList);
	}
	
	//view model을 분리해서 전달하는 방법
	@RequestMapping("/getCustomer.do")
	public String getCustomer(@RequestParam("cname") String cname, Model model ) {
		CustomerVo customer = customerService.selectCustomerByName(cname);
		model.addAttribute("customer", customer);
		
		return "customerInfo";
		
	}
	

}
