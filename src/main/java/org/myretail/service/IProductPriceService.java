package org.myretail.service;

import java.util.List;

import org.myretail.entities.Product;
import org.myretail.entities.ProductPrice;

public interface IProductPriceService {
	public ProductPrice read(String id);
	public ProductPrice save(ProductPrice productPrice);

	public List<ProductPrice> readAll();

}
