package org.myretail.service;

import java.util.List;

import org.myretail.entities.Product;
import org.myretail.entities.ProductPrice;

public interface IProductPriceService {
	ProductPrice read(String id);

	ProductPrice save(ProductPrice productPrice);

	ProductPrice update(ProductPrice productPrice);

	ProductPrice delete(ProductPrice productPrice);

}
