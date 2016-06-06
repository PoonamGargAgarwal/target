package org.myretail.service;

import java.util.List;

import org.apache.log4j.Logger;
import org.myretail.controller.ProductController;
import org.myretail.entities.Product;
import org.myretail.entities.ProductPrice;
import org.myretail.repository.jpa.IProductRepository;
import org.myretail.repository.mongo.IProductPriceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class ProductService implements IProductService {

	private static final Logger logger = Logger.getLogger(ProductService.class);
	@Autowired
	public IProductRepository productRepository;
	@Autowired
	public IProductPriceService productPriceService;

	public Product read(Long id) {
		Product product = productRepository.findOne(id);
		ProductPrice productPricelist = productPriceService.read(id.toString());
		product.setPrice(productPricelist.getPrice());
		return product;
	}

	@Override
	public Product savePrice(Long id, Product productView) {

		Product product = productRepository.findOne(id);
		if (product != null) {
			ProductPrice productPriceView = new ProductPrice();
			productPriceView.setId(product.getpId().toString());
			productPriceView.setPrice(productView.getPrice());
			ProductPrice productPrice = productPriceService
					.save(productPriceView);
			product.setPrice(productPrice.getPrice());
		}
		return product;
	}

}
