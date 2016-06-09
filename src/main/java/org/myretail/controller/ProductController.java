package org.myretail.controller;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.myretail.dto.ResponseDTO;
import org.myretail.entities.Product;
import org.myretail.entities.ProductPrice;
import org.myretail.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/product")
public class ProductController {
	private static final Logger logger = Logger
			.getLogger(ProductController.class);
	@Autowired
	public IProductService productService;

	@RequestMapping(value = "/{productId}", headers = { "Accept=application/json" }, method = RequestMethod.GET, produces = "application/json")
	public @ResponseBody ResponseDTO<Product> getProduct(
			@PathVariable long productId) {

		logger.info("Product Id is :" + productId);
		Product products = productService.read(productId);

		if (products != null) {
			return new ResponseDTO<Product>(true, products);
		}

		return new ResponseDTO<Product>(false);
	}

	@RequestMapping(value = "/{productId}", headers = { "Accept=application/json" }, method = RequestMethod.PUT, produces = "application/json")
	public @ResponseBody ResponseDTO<Product> getProduct(
			@PathVariable long productId, @RequestBody Product productPriceView) {
		Product returnedProduct = productService.savePrice(productId,
				productPriceView);
		if (returnedProduct != null) {
			return new ResponseDTO<Product>(true, returnedProduct);
		}

		return new ResponseDTO<Product>(false);
	}

}
