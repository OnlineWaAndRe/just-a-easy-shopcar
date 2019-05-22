package service;

import java.util.List;

import entity.shop;
import implement.shopImpl;

public class shopService {
	private shopImpl si = new shopImpl();
	public int getShopPrice(int shopId) {
		return si.lookShopPrice(shopId);
	}
	public int getShopNum(int shopId) {
		return si.lookShopNum(shopId);
	}
	public shop getAShop(int shopId) {
		return si.aShop(shopId);
	}
	public boolean delShop(int shopId) {
		return si.delShop(shopId);
	}
	public boolean reduceShopNum(int shopId, int num) {
		int cntShop = si.lookShopNum(shopId);
		shop aShop = si.aShop(shopId);
		aShop.setShopNum(cntShop-num);
		return si.upShop(aShop);
	}
	public List<shop> getAllShop() {
		return si.allShop();
	}

/*
	public static void main(String[] args) {
		shopService ss = new shopService();
//		List<shop> list = ss.getAllShop();
//		for(shop s:list) {
//			System.out.println(s.getShopName());
//		}
//		shop s = ss.getAShop(2);
//		System.out.println(s.getShopName());
	}
*/
}
