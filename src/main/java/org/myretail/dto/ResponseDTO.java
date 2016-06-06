package org.myretail.dto;

import java.util.ArrayList;
import java.util.List;

public class ResponseDTO <T extends Object> {

	protected Boolean success;
	protected List<T> productList;
	
	public ResponseDTO(Boolean success) {
		super();
		this.success = success;
	}
	
	public ResponseDTO(Boolean success, List<T> productList) {
		super();
		this.success = success;
		this.productList = productList;
	}
	public ResponseDTO(Boolean success, T product) {
		super();
		this.success = success;
		List<T> productList = new ArrayList<T>();
		productList.add(product);
		this.productList = productList;
	}
	
	public Boolean getSuccess() {
		return success;
	}
	public void setSuccess(Boolean success) {
		this.success = success;
	}

	public List<T> getProductList() {
		return productList;
	}

	public void setProductList(List<T> productList) {
		this.productList = productList;
	}
	
	
}