package space;

public class Stock {
	
	private Integer stockAmount;
	public String type;
	
	

	public Stock(String type, Integer stockAmount) {
		this.stockAmount = stockAmount;
		this.type = type;
	}

	public Integer getStockAmount() {
		return stockAmount;
	}

	public void setStockAmount(Integer stockAmount) {
		this.stockAmount = stockAmount;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}
	
	public void addAmount(int amount){
		stockAmount += amount;
	}
	
	

}
