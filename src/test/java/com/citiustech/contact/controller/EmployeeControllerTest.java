package com.citiustech.contact.controller;

import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.skyscreamer.jsonassert.JSONAssert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import static org.mockito.Mockito.when;   // ...or...
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import com.citiustech.contact.model.Address;
import com.citiustech.contact.model.Employee;
import com.citiustech.contact.repository.AddressRepository;
import com.citiustech.contact.repository.EmployeeRepository;
import com.citiustech.contact.service.EmployeeService;

import ch.qos.logback.core.status.Status;
import net.minidev.json.JSONArray;

@RunWith(SpringRunner.class)
//@WebMvcTest(EmployeeController.class)
@WebMvcTest(EmployeeController.class) 	
@WebAppConfiguration
public class EmployeeControllerTest {
	@Autowired
    private MockMvc mockMvc;
 
    @Mock
    private EmployeeService empService;
    @MockBean
    private EmployeeRepository repository;
    @MockBean
    private AddressRepository adrRepository;
    
    @InjectMocks
    private EmployeeController emc;
    
    @Before
    public void setup()
    {
    	MockitoAnnotations.initMocks(this);
    	mockMvc=MockMvcBuilders.standaloneSetup(emc).build();

    }
    @Test
    public void getAllEmployees() throws Exception
    {
    	Employee emp=new Employee((long) 1,
        		new Address((long) 1,"MH",200100),
        		"gka","SSE","java");
    	
    	when(empService.findAll()).thenReturn((List<Employee>) emp);
    	
    	mockMvc.perform(get("/employees").accept(MediaType.APPLICATION_JSON)).andExpect(status().isOk());
    	
    						
    	
    	
    }
    
    /*
    Employee emp=new Employee((long) 1,
    		new Address((long) 1,"MH",200100),
    		"gka","SSE","java");
    
    */
    
    
  
	/*@SuppressWarnings("unchecked")
	@Test
	public void getAllEmployees() throws Exception{
		
		mockMvc.perform(get("/employees"))
					.andExpect(status().isOK())
		
		
    	Mockito.when(
    			service.findAll()).thenReturn((List<Employee>) emp);

		RequestBuilder requestBuilder = MockMvcRequestBuilders.get(
				"/employees").accept(
				MediaType.APPLICATION_JSON);

		MvcResult result = mockMvc.perform(requestBuilder).andReturn();

		System.out.println(result.getResponse());
		String expected = "{id: 1,name: gka,designation: SSE,expertise: java, adr: { id: 1, state : MH, pincode: 200100},}";
		// {"id":"Course1","name":"Spring","description":"10 Steps, 25 Examples and 10K Students","steps":["Learn Maven","Import Project","First Example","Second Example"]}

		JSONAssert.assertEquals(expected, result.getResponse()
				.getContentAsString(), false);
	}
    
    private RequestBuilder get(String string) {
		// TODO Auto-generated method stub
		return null;
	}

	@Configuration
  
    public static class TestConf {
    	@Bean public DemoController demoController() { return new DemoController(); }
    	
    }*/
}
