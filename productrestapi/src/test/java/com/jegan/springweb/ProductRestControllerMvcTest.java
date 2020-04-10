package com.jegan.springweb;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.jegan.springweb.entities.Product;
import com.jegan.springweb.repos.ProductRepository;

@RunWith(SpringRunner.class)
@WebMvcTest
class ProductRestControllerMvcTest {

	private static final String PRODUCT_URL = "/productapi/products/";
	private static final String CONTEXT_URL = "/productapi";
	private static final int PRODUCT_PRICE = 1000;
	private static final String PRODUCT_DESC = "good";
	private static final String PRODUCT_NAME = "Samsung";
	private static final int PRODUCT_ID = 1;
	@Autowired
	private MockMvc mockMvc;
	@MockBean
	private ProductRepository repository;
	@Test
	void testFindAll() throws Exception {
		Product product = buildProduct();
		List<Product> products = Arrays.asList(product);
		when(repository.findAll()).thenReturn(products);
		ObjectWriter objectWriter = new ObjectMapper().writer().withDefaultPrettyPrinter();
		
		mockMvc.perform(get(PRODUCT_URL).contextPath(CONTEXT_URL))
			.andExpect(status().isOk())
			.andExpect(content().json(objectWriter.writeValueAsString(products)));
	}
	
	@Test
	void testCreateProduct() throws JsonProcessingException, Exception {
		Product product = buildProduct();
		when(repository.save(any())).thenReturn(product);
		ObjectWriter objectWriter = new ObjectMapper().writer().withDefaultPrettyPrinter();
		mockMvc.perform(post(PRODUCT_URL)
				.contextPath(CONTEXT_URL)
				.contentType(MediaType.APPLICATION_JSON)
				.content(objectWriter.writeValueAsString(product)))
		.andExpect(status().isOk())
		.andExpect(content().json(objectWriter.writeValueAsString(product)));
	}
	
	@Test
	void testUpdateProduct() throws JsonProcessingException, Exception {
		Product product = buildProduct();
		product.setPrice(1200);
		when(repository.save(any())).thenReturn(product);
		ObjectWriter objectWriter = new ObjectMapper().writer().withDefaultPrettyPrinter();
		mockMvc.perform(put(PRODUCT_URL)
				.contextPath(CONTEXT_URL)
				.contentType(MediaType.APPLICATION_JSON)
				.content(objectWriter.writeValueAsString(product)))
		.andExpect(status().isOk())
		.andExpect(content().json(objectWriter.writeValueAsString(product)));
	}
	
	
	@Test
	void deleteProduct() throws Exception {
		doNothing().when(repository).deleteById(PRODUCT_ID);
		mockMvc.perform(delete(PRODUCT_URL +  PRODUCT_ID).contextPath(CONTEXT_URL)).andExpect(status().isOk());
	}
	
	private Product buildProduct() {
		Product product = new Product();
		product.setId(PRODUCT_ID);
		product.setName(PRODUCT_NAME);
		product.setDescription(PRODUCT_DESC);
		product.setPrice(PRODUCT_PRICE);
		return product;
	}

}
