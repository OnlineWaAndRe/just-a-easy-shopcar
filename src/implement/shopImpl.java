package implement;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dao.shopDao;
import entity.shop;
import operation.shopOper;

public class shopImpl implements shopOper{

	@Override
	//public shop(int shopId,String shopName,  double shopPrice, int shopNum,String shopDetial)
	public boolean addShop(shop shops) {
		String sql = "insert into shop values(?,?,?,?,?)";
		Object[] parmes = {shops.getShopId(), shops.getShopName(),shops.getShopPrice(),shops.getShopNum(),shops.getShopDetial()};
		return shopDao.isConnection(sql, parmes);
	}

	@Override
	public boolean delShop(int shopId) {
		String sql = "delete from shop where shopId = ?";
		Object[] parmes = {shopId};
		return shopDao.isConnection(sql, parmes);
	}

	@Override
	public List<shop> allShop() {
		String sql = "select *from shop";
		Object[] parmes = {};
		shop shopSingle ;
		List<shop> shops = new ArrayList<shop>();
		ResultSet rs = shopDao.getResultSet(sql, parmes);
		System.out.println("rs -- shop -- allshop -ok");
		try {
			while(rs.next()) {
				int id = rs.getInt("shopId");
				String name = rs.getString("shopName");
				int price = rs.getInt("shopPrice");
				int num = rs.getInt("shopNum");
				String detial = rs.getString("shopDetial");
				shopSingle = new shop(id,name,price,num,detial);
				shops.add(shopSingle);
			}
			return shops;
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}finally {
			close();
		}
	}

	@Override
	public boolean upShop(shop shops) {
		String sql = "update shop set shopNum = ? where shopId = ?";
		Object[] parmes = {shops.getShopId(), shops.getShopName(),shops.getShopPrice(), shops.getShopNum(), shops.getShopDetial()};
		return shopDao.isConnection(sql, parmes);
	}

	@Override
	public boolean close() {
		return shopDao.closeAll();
	}

	@Override
	public int lookShopNum(int shopId) {
		String sql = "select shopNum from shop where shopId = ?";
		Object[] parmes = {shopId};
		ResultSet rs = shopDao.getResultSet(sql, parmes);
		int shopNum;
		try {
			while(rs.next()) {
				shopNum = rs.getInt("shopNum");
				return shopNum;
			}
		} catch (SQLException e) {
			e.printStackTrace();
			return -2;
		}
		return -1;
	}

	@Override
	public int lookShopPrice(int shopId) {
		String sql = "select shopPrice from shop where shopId = ?";
		Object[] parmes = {shopId};
		ResultSet rs = shopDao.getResultSet(sql, parmes);
		int price = 0;
		try {
			while(rs.next()) {
				price = rs.getInt("shopPrice");
				return price;
			}
		} catch (SQLException e) {
			e.printStackTrace();
			return -2;
		}
		return -1;
	}

	@Override
	public shop aShop(int shopId) {
		shop aShop;
		String sql = "select *from shop where shopId = ?";
		Object[] parmes = {shopId};
		ResultSet rs = shopDao.getResultSet(sql, parmes);
		try {
			while(rs.next()) {
				if(rs.getInt("shopId") ==  shopId) {
					int id = rs.getInt("shopId");
					int price = rs.getInt("shopPrice");
					int num = rs.getInt("shopNum");
					String detial = rs.getString("shopDetial");
					String name = rs.getString("shopName");
					aShop = new shop(id,name,price,num,detial);
					return aShop;
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
/*
 *  

	public static void main(String[] args) {
		shop s = new shop(2,"精肉",10,1,"日本千户猪腰子");
		shopImpl si = new shopImpl();
		//si.addShop(s);
		//si.delShop(s.getShopId());
		//System.out.println(si.lookShopPrice(s.getShopId()));
		//System.out.println(si.lookShopNum(s.getShopId()));
		List<shop> list = si.allShop();
		for(shop p : list) {
			System.out.println(p.getShopName());
		}
	}
*/
	
	
	
	
}
