package myspring.customer.service;

import java.util.List;

import myspring.customer.vo.CustomerVo;

public interface CustomerService {
	
	CustomerVo selectCustomerByName(String cname);
	List<CustomerVo> selectCustomerList();

}
