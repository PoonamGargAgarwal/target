package org.myretail.test;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.myretail.controller.ProductController;
import org.myretail.entities.Product;
import org.myretail.service.IProductService;

import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:test-config.xml")
@WebAppConfiguration
public class ProductControllerTest {
	

    MockMvc mockMvc;
	@InjectMocks	
	ProductController productController;
	@Mock	
	IProductService mockProductService;
	private Product product;

	@Before
	public void setUp() throws Exception {

		MockitoAnnotations.initMocks(this);
		this.mockMvc = MockMvcBuilders.standaloneSetup(productController).build();	
		product = new Product();
		product.setpId(2L);
		product.setProductName("testProduct");
		product.setPrice(200.0);
		mockProductService.saveProduct(product);	
		

	}
	  @Test
	    public void testFindProduct() throws Exception {		
	        when(mockProductService.read(product.getpId())).thenReturn(product);
	        this.mockMvc.perform(get("/product/2"))
	                .andExpect(status().isOk())
	                .andExpect(model().attribute("id", product.getpId()));
	               
	    }
	

	
}
