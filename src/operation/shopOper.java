package operation;

import java.util.List;

import entity.shop;

public interface shopOper {
	public boolean addShop(shop shops);
	public boolean delShop(int shopId);
	public boolean upShop(shop shops);
	public int lookShopNum(int shopId);
	public int lookShopPrice(int shopId);
	public shop aShop(int shopId);
	public boolean close();
	public List<shop> allShop();
}
