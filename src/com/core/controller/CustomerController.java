package com.core.controller;

import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.core.pojo.BaseDict;
import com.core.pojo.Customer;
import com.core.service.BaseDictService;
import com.core.service.CustomerService;
import com.core.utils.Page;


@Controller
public class CustomerController {

	@Autowired
	private CustomerService customerService;
	
	@Autowired
	private BaseDictService baseDictService;
	
	/*
	 * resource�����ļ���ı�����ע�ڳ�Ա������
	 */
	@Value("${customer.from.type}")
	private String fromTypeCode;
	
	@Value("${customer.industry.type}")
	private String industryType_code;
	
	@Value("${customer.level.type}")
	private String levelType_code;
	
	
	/*
	 * ��ѯ��ʾ�ͻ��б���Ϣ
	 */
	@RequestMapping("/list")
	public String list(@RequestParam(defaultValue = "1") Integer page,
 			           @RequestParam(defaultValue = "5") Integer rows,
 			           String custName, String custSource ,String custIndustry, 
 			           String custLevel, Model model)
	{
		//System.out.println("������customercontroller");
		Page<Customer> customers = customerService.CustomerList(page, rows, custName, custSource, custIndustry, custLevel);		
		
		/*
		 * ��:����page�����õ�page��ͻ�����model��page��Ϊpages
		 * */
		model.addAttribute("pages",customers);
		
//		List<Customer> list = customers.getRows();
//		for(Customer c:list) {
//			System.out.println(c.getCust_level());
//		}
		
		/*
		 * List<Customer> list = customers.getRows(); for (Customer c:list ) {
		 * System.out.println(c.getCust_id()); }
		 */
		
		List<BaseDict> fromType = baseDictService.findBaseDictByTypeCode(fromTypeCode);
		List<BaseDict> industryType = baseDictService.findBaseDictByTypeCode(industryType_code);
		List<BaseDict> levelType = baseDictService.findBaseDictByTypeCode(levelType_code);
		
		
		model.addAttribute("fromType",fromType);
		model.addAttribute("industryType",industryType);
		model.addAttribute("levelType",levelType);
		model.addAttribute("page", page);
		model.addAttribute("custName", custName);
		model.addAttribute("custSource", custSource);
		model.addAttribute("custIndustry", custIndustry);
		model.addAttribute("custLevel", custLevel);
		
	
		
		return "/WEB-INF/jsp/index";		
	}
	/*
	 * ɾ���ͻ���Ϣ
	 */
	@RequestMapping("/deleted")
	@ResponseBody
	public String delete(Integer id)
	{
		
		customerService.deleteCustomerById(id);
		return "OK";
	}
	
	@RequestMapping("/update")
	@ResponseBody
	public String update(Customer customer)
	{
		
		customerService.updateCustomerById(customer);
		return "OK";		
	}
	@RequestMapping("/insert")
	@ResponseBody
	public String insert(Customer customer)
	{
		
		customerService.insertCustomer(customer);;
		return "OK";		
	}
	   /*
	    * ͨ��id���ҿͻ�
	    */
	@RequestMapping(value = "/customer/edit.action")
	public @ResponseBody
	Customer edit(Integer id){
			return customerService.selectCustomerById(id);
		}
	
	@RequestMapping("/batch")
	@ResponseBody
	public String batchDelete(String list)
	{
		String[] item  = list.split(",");		
		for(String i:item)
		{
			customerService.deleteCustomerById(Integer.parseInt(i));
		}
		return "OK";
	}
	
}
