package org.myretail.test;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.myretail.entities.ProductPrice;
import org.myretail.repository.mongo.IProductPriceRepository;
import org.myretail.service.IProductPriceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:test-config.xml")
public class ProductPriceServiceTest {

	@Autowired
	IProductPriceService productPriceService;
	ProductPrice productPrice;

	@Before
	public void setUp() {
		productPrice = new ProductPrice();
		productPrice.setId("2");
		productPrice.setPrice(200.0);
		productPriceService.save(productPrice);
	}

	@Test
	public void testFindProductPrice() {

		ProductPrice retrivedProductprice = productPriceService
				.read(productPrice.getId());

		Assert.assertEquals(productPrice.getId(), retrivedProductprice.getId());

	}

	
	@Test
	public void testUpdateProductPrice() {

		productPrice.setPrice(90.0);
		productPriceService.update(productPrice);
		ProductPrice retrivedProductprice = productPriceService.read(productPrice.getId());	
		Assert.assertEquals(productPrice.getId(), retrivedProductprice.getId());

	}

	@After
	public void tearDown() {
		productPriceService.delete(productPrice);
	}

}
