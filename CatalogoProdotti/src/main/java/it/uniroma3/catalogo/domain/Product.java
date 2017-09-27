package it.uniroma3.catalogo.domain;

import java.io.Serializable;



import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.springframework.web.multipart.MultipartFile;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.validation.constraints.Digits;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

@Entity
@XmlRootElement(name="products")
public class Product implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id
	@Pattern(regexp="P[1-9]+", message="{Pattern.Product.productId.validation}")
	private String productId;
	
	@Size(min=4, max=50, message="{Size.Product.name.validation}")
	private String name;
	
	@Min(value=0, message="{Min.Product.unitPrice.validation}")
	@Digits(integer=8, fraction=2, message="{Digits.Product.unitPrice.validation}")
	@NotNull(message="{NotNull.Product.unitPrice.validation}")
	private BigDecimal unitPrice;
	
	private String description;
	private String manufacturer;
	private String category;
	private Integer unitsInStock;
	private Integer unitsInOrder;
	private boolean discontinued;
	
	@ManyToMany(mappedBy = "products", fetch = FetchType.LAZY)
	private List<Supplier> suppliers;
	
	private MultipartFile productImage;

	public Product() {
	}

	public Product(String productId, String name, String description, String manufacturer, String category, BigDecimal unitPrice, Integer  unitsInStock, Integer unitsInOrder) {
		this.productId = productId;
		this.name = name;
		this.unitPrice = unitPrice;
		this.description=description;
		this.manufacturer = manufacturer;
		this.category = category;
		
		if(unitsInStock==null || unitsInStock<0 ) this.unitsInStock = 0;
		if(unitsInOrder==null || unitsInOrder<0 ) this.unitsInOrder = 0;

		this.suppliers = new ArrayList<>();
	}

	public String getProductId() {
		return productId;
	}

	public void setProductId(String productId) {
		this.productId = productId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public BigDecimal getUnitPrice() {
		return unitPrice;
	}

	public void setUnitPrice(BigDecimal unitPrice) {
		this.unitPrice = unitPrice;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getManufacturer() {
		return manufacturer;
	}

	public void setManufacturer(String manufacturer) {
		this.manufacturer = manufacturer;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public long getUnitsInStock() {
		return unitsInStock;
	}

	public void setUnitsInStock(Integer unitsInStock) {
		this.unitsInStock = unitsInStock;
	}

	public long getUnitsInOrder() {
		return unitsInOrder;
	}

	public void setUnitsInOrder(Integer unitsInOrder) {
		this.unitsInOrder = unitsInOrder;
	}

	public boolean isDiscontinued() {
		return discontinued;
	}

	public void setDiscontinued(boolean discontinued) {
		this.discontinued = discontinued;
	}


//	@Override
//	public boolean equals(Object obj) {
//		if (this == obj)
//			return true;
//		if (obj == null)
//			return false;
//		if (getClass() != obj.getClass())
//			return false;
//		Product other = (Product) obj;
//		if (productId == null) {
//			if (other.productId != null)
//				return false;
//		} else if (!productId.equals(other.productId))
//			return false;
//		return true;
//	}
	
//	@Override
//	public int hashCode() {
//		final int prime = 31;
//		int result = 1;
//		result = prime * result + ((productId == null) ? 0 :productId.hashCode());
//		return result;
//	}

	@XmlTransient
	public MultipartFile getProductImage() {
		return productImage;
	}

	public void setProductImage(MultipartFile productImage) {
		this.productImage = productImage;
	}

}

