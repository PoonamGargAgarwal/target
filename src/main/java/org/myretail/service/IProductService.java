package org.myretail.service;

import java.util.List;

import org.myretail.entities.Product;

public interface IProductService {
	public Product read(Long id);
	public Product savePrice(Long id,Product product);
	public Product delete(Long id);
	public Product saveProduct(Product product);
	
	

}
