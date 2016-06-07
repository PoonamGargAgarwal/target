package org.myretail.service;

import java.util.List;

import org.apache.log4j.Logger;
import org.myretail.controller.ProductController;
import org.myretail.entities.Product;
import org.myretail.entities.ProductPrice;
import org.myretail.repository.jpa.IProductRepository;
import org.myretail.repository.mongo.IProductPriceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
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
	@Cacheable(value="productFindCache", key="#id")
	public Product read(Long id) {
		slowQuery(2000L);
		Product product = productRepository.findOne(id);
		slowQuery(2000L);
		ProductPrice productPrice = productPriceService.read(id.toString());
		if ((productPrice != null) && (product !=null)) {
			product.setPrice(productPrice.getPrice());
		}
		return product;
	}
	@Override
	public Product saveProduct(Product productItem) {
		Product product = productRepository.save(productItem);		
		ProductPrice productPriceView = new ProductPrice();
		productPriceView.setId(product.getpId().toString());
		productPriceView.setPrice(productItem.getPrice());
		ProductPrice productPrice = productPriceService
				.save(productPriceView);
		return product;
	}

	@Override
	public Product delete(Long id) {
		Product product = productRepository.findOne(id);
		productRepository.delete(id);
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
					.update(productPriceView);
			product.setPrice(productPrice.getPrice());
		}
		return product;
	}
	private void slowQuery(long seconds){
	    try {
                Thread.sleep(seconds);
            } catch (InterruptedException e) {
                throw new IllegalStateException(e);
            }
	}

}
