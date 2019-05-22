package entity;

public class shopCar {
	private shop shops;
	private int num;
	
	public shopCar() {}
	public shopCar(shop shops, int num) {
		this.shops = shops;
		this.num = num;
	}
	public shop getShops() {
		return shops;
	}
	public void setShops(shop shops) {
		this.shops = shops;
	}
	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
	}
	
}
