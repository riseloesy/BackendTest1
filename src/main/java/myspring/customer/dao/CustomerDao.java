package myspring.customer.dao;

import java.util.List;

import myspring.customer.vo.CustomerVo;

public interface CustomerDao {
	public List<CustomerVo> readAll();

	public CustomerVo read(String cname);

}
