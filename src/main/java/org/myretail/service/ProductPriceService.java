package org.myretail.service;

import java.util.List;

import org.apache.log4j.Logger;
import org.myretail.entities.ProductPrice;
import org.myretail.repository.mongo.IProductPriceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
@Service
@Transactional
public class ProductPriceService implements IProductPriceService{
	private static final Logger logger = Logger.getLogger(ProductPriceService.class);
	@Autowired
	public IProductPriceRepository productPricerepository;
	@Autowired 
	
    protected MongoOperations mongoOps;

	@Override
	public ProductPrice read(String id) {
		return productPricerepository.findByAttributes("id", id.toString());
		
	}



	@Override
	public ProductPrice save(ProductPrice productPrice) {
		
		
		productPricerepository.save(productPrice);
		
		return read(productPrice.getId());
	}
	
	@Override
	public ProductPrice update(ProductPrice productPrice) {
	
		Query query = new Query();		
		query.addCriteria(Criteria.where("id").is(productPrice.getId()));
		Update update = new Update();
		update.set("price", productPrice.getPrice());		
		mongoOps.updateMulti(query, update, ProductPrice.class);
	
		
		return read(productPrice.getId());
	}
	@Override
	public ProductPrice delete(ProductPrice productPrice) {
	
		productPricerepository.delete(productPrice.getId());	
		
		return productPrice;
	}
}
