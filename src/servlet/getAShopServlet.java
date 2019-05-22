package servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mysql.cj.Session;

import entity.shop;
import service.shopService;

@WebServlet("/shopServlet")
public class getAShopServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public getAShopServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		String shopId = request.getParameter("shopId");
		int realShopId = Integer.parseInt(shopId);
		shop ashop = new shop();
		ashop.setShopId(realShopId);
		shopService ss = new shopService();
		ashop = ss.getAShop(ashop.getShopId());
		request.setAttribute("ashop", ashop);
		request.getRequestDispatcher("ashop.jsp");
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
