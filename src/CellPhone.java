
import java.util.Scanner;

public class CellPhone {
	
	private long serialNum;
	private String brand;
	private int year;
	private double price;
	
	public CellPhone(long serialNum, String brand, int year, double price) {
		this.serialNum = serialNum;
		this.brand = brand;
		this.year = year;
		this.price = price;
	}
	
	public CellPhone(CellPhone c, long serialNum) {
		this.brand = c.brand;
		this.year = c.year;
		this.price = c.price;
		this.serialNum = serialNum;
	}
	
	protected Object clone(){
        Scanner keyIn = new Scanner(System.in);
        long serialNum;
        System.out.println("Enter the serial number wanted:");
        serialNum = keyIn.nextLong();
        return new CellPhone(this, serialNum);
    }
	
	public long getSerialNum() {
		return serialNum;
	}
	public void setSerialNum(long serialNum) {
		this.serialNum = serialNum;
	}
	public String getBrand() {
		return brand;
	}
	public void setBrand(String brand) {
		this.brand = brand;
	}
	public int getYear() {
		return year;
	}
	public void setYear(int year) {
		this.year = year;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public boolean equals(CellPhone c) {
		return (this.brand.equals(c.brand)&&this.year==c.year&&this.price==price);
	}
	public String toString() {
		return "[" + this.serialNum + ": " + this.brand + " " + this.price + "$ " + this.year + "]";
	}
	
	

}
