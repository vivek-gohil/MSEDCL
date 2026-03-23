package com.msedcl.main.customer;

import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Import;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.msedcl.main.customer.controller.CustomerController;
import com.msedcl.main.customer.dto.CustomerDTO;
import com.msedcl.main.customer.service.CustomerService;

@WebMvcTest(CustomerController.class)
@Import(CustomerControllerTest.MockConfig.class)
class CustomerControllerTest {

	@Autowired
	private MockMvc mockMvc;

	@Autowired
	private CustomerService service;

	@Autowired
	private ObjectMapper objectMapper;

	// ✅ Replace @MockBean
	@TestConfiguration
	static class MockConfig {
		@Bean
		public CustomerService customerService() {
			return Mockito.mock(CustomerService.class);
		}
	}

	// ==========================
	// CREATE
	// ==========================
	@Test
	void testCreate() throws Exception {

		CustomerDTO dto = new CustomerDTO();
		dto.setId(1L);
		dto.setName("Vivek");
		dto.setEmail("vivek@test.com");

		when(service.create(Mockito.any())).thenReturn(dto);

		mockMvc.perform(post("/api/customers").contentType(MediaType.APPLICATION_JSON)
				.content(objectMapper.writeValueAsString(dto))).andExpect(status().isCreated())
				.andExpect(jsonPath("$.name").value("Vivek"));
	}

	// ==========================
	// GET BY ID
	// ==========================
	@Test
	void testGetById() throws Exception {

		CustomerDTO dto = new CustomerDTO();
		dto.setId(1L);
		dto.setName("Amit");

		when(service.getById(1L)).thenReturn(dto);

		mockMvc.perform(get("/api/customers/1")).andExpect(status().isOk()).andExpect(jsonPath("$.name").value("Amit"));
	}

	// ==========================
	// GET ALL
	// ==========================
	@Test
	void testGetAll() throws Exception {

		CustomerDTO c1 = new CustomerDTO();
		c1.setId(1L);
		c1.setName("A");

		CustomerDTO c2 = new CustomerDTO();
		c2.setId(2L);
		c2.setName("B");

		List<CustomerDTO> list = Arrays.asList(c1, c2);

		when(service.getAll()).thenReturn(list);

		mockMvc.perform(get("/api/customers")).andExpect(status().isOk()).andExpect(jsonPath("$.size()").value(2));
	}

	// ==========================
	// UPDATE
	// ==========================
	@Test
	void testUpdate() throws Exception {

		CustomerDTO dto = new CustomerDTO();
		dto.setId(1L);
		dto.setName("Updated");

		when(service.update(Mockito.eq(1L), Mockito.any())).thenReturn(dto);

		mockMvc.perform(put("/api/customers/1").contentType(MediaType.APPLICATION_JSON)
				.content(objectMapper.writeValueAsString(dto))).andExpect(status().isOk())
				.andExpect(jsonPath("$.name").value("Updated"));
	}

	// ==========================
	// DELETE
	// ==========================
	@Test
	void testDelete() throws Exception {

		doNothing().when(service).delete(1L);

		mockMvc.perform(delete("/api/customers/1")).andExpect(status().isNoContent());
	}

	// ==========================
	// VALIDATION (NEGATIVE)
	// ==========================
	@Test
	void testCreateValidationFail() throws Exception {

		CustomerDTO dto = new CustomerDTO(); // empty

		mockMvc.perform(post("/api/customers").contentType(MediaType.APPLICATION_JSON)
				.content(objectMapper.writeValueAsString(dto))).andExpect(status().isBadRequest());
	}
}
