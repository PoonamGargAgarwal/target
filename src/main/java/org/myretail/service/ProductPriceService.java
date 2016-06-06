package org.myretail.service;

import java.util.List;

import org.apache.log4j.Logger;
import org.myretail.entities.ProductPrice;
import org.myretail.repository.mongo.IProductPriceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
@Service
@Transactional
public class ProductPriceService implements IProductPriceService{
	private static final Logger logger = Logger.getLogger(ProductPriceService.class);
	@Autowired
	public IProductPriceRepository productPricerepository;

	@Override
	public ProductPrice read(String id) {
		return productPricerepository.findByAttributes("id", id.toString());
		
	}



	@Override
	public ProductPrice save(ProductPrice productPrice) {
		// TODO Auto-generated method stub
		productPricerepository.save(productPrice);
		
		return read(productPrice.getId());
	}
}
