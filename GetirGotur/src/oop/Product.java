package oop;

public class Product {
	private String category;
	private String name;
	private Double price;
	private String imageLink;
	
	Product(String category,String name,Double price,String imageLink){
		this.category=category;
		this.name=name;
		this.price=price;
		this.imageLink=imageLink;
	}

	public String getCategory() {
		return category;
	}


	public String getName() {
		return name;
	}


	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public String getImageLink() {
		return imageLink;
	}

	
	
}
