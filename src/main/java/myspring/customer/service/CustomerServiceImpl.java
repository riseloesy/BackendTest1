package myspring.customer.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import myspring.customer.dao.CustomerDao;
import myspring.customer.vo.CustomerVo;

@Service("customerService")
public class CustomerServiceImpl implements CustomerService{

	@Autowired
	CustomerDao customerDao;
	
	@Override
	public CustomerVo selectCustomerByName(String cname) {
		return customerDao.read(cname);
	}

	@Override
	public List<CustomerVo> selectCustomerList() {
		return customerDao.readAll();
	}

}
