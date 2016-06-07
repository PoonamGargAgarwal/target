package org.myretail.repository.mongo;

import java.util.List;

import org.myretail.entities.ProductPrice;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

public interface IProductPriceRepository extends MongoRepository<ProductPrice, String> {
	@Query("{ ?0 : ?1 }")
	ProductPrice findByAttributes(String key, String value);

	

}
