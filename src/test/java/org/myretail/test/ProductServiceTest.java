package org.myretail.test;

import org.junit.Assert;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.myretail.entities.Product;
import org.myretail.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:test-config.xml")
public class ProductServiceTest {

	
	@Autowired
	IProductService productService;

	@Test
	public void testFindProduct() {

		Product retrievedProduct = productService.read(1L);
		Assert.assertNotNull(retrievedProduct);

	}

}
