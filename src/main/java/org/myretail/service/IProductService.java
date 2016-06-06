package org.myretail.service;

import java.util.List;

import org.myretail.entities.Product;

public interface IProductService {
	public Product read(Long id);
	public Product savePrice(Long id,Product product);

	public List<Product> readAll();
	

}
