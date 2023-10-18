package myspring.customer.dao.mapper;

import java.util.List;

import myspring.customer.vo.CustomerVo;

public interface CustomerMapper {

CustomerVo selectCustomerByName(String cname);
List<CustomerVo> selectCustomerList();



}