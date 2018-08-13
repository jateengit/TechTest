package com.atos.techtest.customer;

import static org.hamcrest.CoreMatchers.containsString;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.header;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.HashMap;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.skyscreamer.jsonassert.JSONAssert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.atos.techtest.customer.controller.CustomerController;
import com.atos.techtest.customer.entity.Customer;
import com.atos.techtest.customer.service.CustomerService;

@RunWith(SpringRunner.class)
@WebMvcTest(value = CustomerController.class, secure = false)
public class CustomerControllerTest {

	@Autowired
	private MockMvc mockMvc;

	@MockBean
	private CustomerService customerServiceMock;

	HashMap<Integer, Customer> customerMap;
	Customer newCustomer;
	String expectedGetAllCustomersResponse;
	
	@Before
	public void setUp() {
		customerMap = new HashMap<Integer, Customer>() {
			{
				put(1, new Customer(1, "John", "Wick"));
				put(2, new Customer(2, "Michael", "Jackson"));
				put(3, new Customer(3, "Jackie", "Chan"));
			}
		};
		newCustomer = new Customer(4, "Jateen", "Udeshi");
		expectedGetAllCustomersResponse = "[{\"id\":1,\"firstName\":\"John\",\"surName\":\"Wick\"},{\"id\":2,\"firstName\":\"Michael\",\"surName\":\"Jackson\"},{\"id\":3,\"firstName\":\"Jackie\",\"surName\":\"Chan\"}]";
	}

	@Test
	public void testGetAllCustomersReturnValidResponseBody() throws Exception {

		when(customerServiceMock.getAllCustomers()).thenReturn(customerMap.values());
		RequestBuilder requestBuilder = MockMvcRequestBuilders.get("/customers");
		MvcResult result = mockMvc.perform(requestBuilder).andReturn();
		JSONAssert.assertEquals(expectedGetAllCustomersResponse, result.getResponse().getContentAsString(), false);
	}

	@Test
	public void testAddCustomerReturnsValidStatusCode() throws Exception {

		mockMvc.perform(post("/customers").contentType(MediaType.APPLICATION_JSON)
				.content(CustomerTestHelper.asJsonString(newCustomer))).andExpect(status().isCreated())
				.andExpect(header().string("location", containsString("http://localhost/customers/4")));
	}

	@Test
	public void testRemoveCustomerByIdReturnsValidStatusCodeWhenIdExists() throws Exception {
		int id = 1;
		RequestBuilder requestBuilder = MockMvcRequestBuilders.delete("/customers/{id}", id)
				.contentType(MediaType.APPLICATION_JSON_VALUE);
		mockMvc.perform(requestBuilder).andExpect(status().isOk());
	}
	
	@Test
	public void testRemoveCustomerById() throws Exception {
		int id = 1;
		RequestBuilder requestBuilder = MockMvcRequestBuilders.delete("/customers/{id}", id)
				.contentType(MediaType.APPLICATION_JSON_VALUE);
		mockMvc.perform(requestBuilder).andExpect(status().isOk());
	}

}
