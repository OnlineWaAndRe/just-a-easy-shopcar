package entity;
import java.io.Serializable;
public class shop implements Serializable{
	private static final long serialVersionUID = 1L;
	private int shopId;
	private double shopPrice;
	private String shopName;
	private String shopDetial;
	private int shopNum;
	public int getShopNum() {
		return shopNum;
	}
	public void setShopNum(int shopNum) {
		this.shopNum = shopNum;
	}
	public shop(int shopId, String shopName,  double shopPrice, int shopNum) {
		this.shopName = shopName;
		this.shopId = shopId;
		this.shopPrice = shopPrice;
		this.shopNum = shopNum;
	}
	public shop(int shopId,String shopName,  double shopPrice, int shopNum,String shopDetial) {
		this.shopName = shopName;
		this.shopId = shopId;
		this.shopPrice = shopPrice;
		this.shopDetial = shopDetial;
		this.shopNum = shopNum;
	}
	public shop() {}
	public int getShopId() {
		return shopId;
	}
	public void setShopId(int shopId) {
		this.shopId = shopId;
	}
	public double getShopPrice() {
		return shopPrice;
	}
	public void setShopPrice(double shopPrice) {
		this.shopPrice = shopPrice;
	}
	public String getShopName() {
		return shopName;
	}
	public void setShopName(String shopName) {
		this.shopName = shopName;
	}
	public String getShopDetial() {
		return shopDetial;
	}
	public void setShopDetial(String shopDetial) {
		this.shopDetial = shopDetial;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	@Override
	public String toString() {
		String shopDital = getShopDetial();
		if(shopDital == null)
			shopDital = "нч";
		return "shop[shopId"+getShopId()+"][shopName"+getShopName()+"][shopPrice"+getShopPrice()+"][shopDatial"+shopDital+"]";
	}
	
}
