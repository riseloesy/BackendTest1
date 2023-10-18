package myspring.customer.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import myspring.customer.dao.mapper.CustomerMapper;
import myspring.customer.vo.CustomerVo;

@Repository("customerDao")
public class CustomerDaoImplMapper implements CustomerDao {
	@Autowired
	private CustomerMapper customerMapper;	
	
	@Override
	public CustomerVo read(String cname) {
		CustomerVo customer  = customerMapper.selectCustomerByName(cname);
		return customer;
	}
	
	public List<CustomerVo> readAll() {
		List<CustomerVo> customerList = customerMapper.selectCustomerList();
		return customerList;
	}

	
}










