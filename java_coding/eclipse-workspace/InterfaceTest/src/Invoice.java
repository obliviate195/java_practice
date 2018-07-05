
public class Invoice implements Payable{
	private String partNumber;
	private String partDescription;
	private int quantity;
	private double pricePerItem;
	
	public Invoice(String part, String description, int count,
			double price)
	{
		partNumber=part;
		partDescription=description;
		setQuantity(count);
		setPricePerItem(price);
	}
	
	public void setQuantity(int count)
	{
		quantity=count;
	}
	
	public void setPricePerItem(double price)
	{
		pricePerItem=price;
	}
	
	public String getPartNumber()
	{
		return partNumber;
	}
	
	public String getPartDescription()
	{
		return partDescription;
	}
	
	public int getQuantity()
	{
		return quantity;
	}
	
	public double getPricePerItem()
	{
		return pricePerItem;
	}
	
	@Override
	public String toString()
	{
		return String.format("%s: \n%s: %s (%s) \n%s: %d \n%s: $%,.2f",
				"invoice", "part number", getPartNumber(), getPartDescription(),
				"quantity", getQuantity(), "price per item", getPricePerItem());
	}
	
	@Override
	public double getPaymentAmount()
	{
		return getQuantity()*getPricePerItem();
	}
	
}
