package org.myretail.service;

import java.util.List;

import org.myretail.entities.ProductPrice;
import org.myretail.repository.mongo.IProductPriceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
@Service
@Transactional
public class ProductPriceService implements IProductPriceService{
	@Autowired
	public IProductPriceRepository productPricerepository;

	@Override
	public ProductPrice read(String id) {
		return productPricerepository.findByAttributes("id", id.toString());
		
	}

	@Override
	public List<ProductPrice> readAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ProductPrice save(ProductPrice productPrice) {
		// TODO Auto-generated method stub
		productPricerepository.save(productPrice);
		
		return read(productPrice.getId());
	}
}
