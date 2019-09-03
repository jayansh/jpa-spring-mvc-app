package net.tao.spring.assignment;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * 
 * @author jayansh
 *
 */
@Entity
@Table(name = "product")
public class Product {
	@Id
	@Column(name = "product_id")
	private String productId;
	@Column(name = "product_name")
	private String productName;
	@Column(name = "description")
	private String description;
	@Column(name = "status")
	private String status;

	public Product() {

	}

	public Product(String productId, String productName, String description, String status) {
		super();
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
