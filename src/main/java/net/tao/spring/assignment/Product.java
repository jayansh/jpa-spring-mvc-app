package net.tao.spring.assignment;

import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * 
 * @author jayansh
 *
 */
@Entity
public class Product {
	@Id
	private String productId;
	private String productName;
	private String description;
	private String status;

	protected Product() {

	}

	public Product(String productId, String productName, String description, String status) {
		this.productId = productId;
		this.productName = productName;
		this.description = description;
		this.status = status;
	}

	public String getProductId() {
		return productId;
	}

	public void setProductId(String productId) {
		this.productId = productId;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

}
