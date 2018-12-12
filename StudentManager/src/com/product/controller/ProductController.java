package com.product.controller;

import java.util.ArrayList;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.product.bean.Product;
import com.product.dao.ProductDao;
import com.student.bean.Student;
import com.student.dao.StudentDao;

/**
 * 商品注文
 * 
 * @author HTJ
 *
 */
@Controller
public class ProductController {
	private JdbcTemplate jdbcTemplate;

	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {

		this.jdbcTemplate = jdbcTemplate;
	}

	/**
	 * @param model
	 * @return 返回值类型： String
	 */

	@RequestMapping(value = "/product")
	public String queryAll(Model model) {
		// フィルダー情報の配置
		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		// 从ioc容器中获取dao
		ProductDao prodao = (ProductDao) context.getBean("prodao");
		// 新商品リストを生成する
		ArrayList<Product> productList = new ArrayList<Product>();
		// prodaoから貰ったqueryAll方法で商品情報をprolistへ戻す
		productList = (ArrayList<Product>) prodao.queryAll();
		// web(product)へ注文情報を戻す
		model.addAttribute("products", productList);
		return "product";
	}

	/**
	 * 通过id查找商品，将结果返回给product.jsp
	 *
	 * @param id
	 * @param model
	 * @return 返回值类型：int
	 */
	@RequestMapping(value = "/queryByIdproduct")
	public String queryById(String id, Model model) {
		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		ProductDao prodao = (ProductDao) context.getBean("prodao");
		// web(product)へ捜査結果を戻す
		model.addAttribute("products", prodao.queryById(id));
		return "product";

	}

	/**
	 * 新規注文の追加
	 */
	@RequestMapping(value = "/addproduct")
	public String Addproduct(String productname, String supplier, String type, String indate, String price,
			String amount, Model model) {
		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		ProductDao prodao = (ProductDao) context.getBean("prodao");
		// 新注文情報を生成する
		Product product = new Product();
		// 新注文情報をセットする
		product.setProductname(productname);
		product.setSupplier(supplier);
		product.setType(type);
		product.setIndate(indate);
		product.setPrice(Integer.valueOf(price));
		product.setAmount(Integer.valueOf(amount));
		// prodaoからAddproductの方法を取り、使用する
		boolean result = prodao.Addproduct(product);

		// 成功・失敗するかを判断
		if (result) {
			model.addAttribute("msg", "<script>alert('添付成功！')</script>");
		} else {
			model.addAttribute("msg", "<script>alert('添付失敗')</script>");

		}
		// web(product)へ情報を戻す
		model.addAttribute("products", prodao.queryAll());
		return "product";
	}

	/**
	 * 通过id削除商品，将结果返回给product.jsp
	 *
	 * @param id
	 * @param model
	 * @return 返回值类型：int
	 */
	@RequestMapping(value = "/delproduct")
	public String Delproduct(String id, Model model) {
		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		ProductDao prodao = (ProductDao) context.getBean("prodao");
		boolean result = prodao.Delproduct(Integer.parseInt(id));
		// 成功・失敗するかを判断
		if (result) {
			model.addAttribute("msg", "<script>alert('削除成功！')</script>");
		} else {
			model.addAttribute("msg", "<script>alert('削除失敗')</script>");
		}
		model.addAttribute("products", prodao.queryAll());
		return "product";
	}

	/**
	 * 注文情報の更新
	 */
	@RequestMapping(value = "/editproduct")
	public String editproduct(String productname, String supplier, String type, String indate, String price,
			String amount, Model model) {
		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		ProductDao prodao = (ProductDao) context.getBean("prodao");
		Product product = new Product();
		product.setProductname(productname);
		product.setSupplier(supplier);
		product.setType(type);
		product.setIndate(indate);
		product.setPrice(Integer.valueOf(price));
		product.setAmount(Integer.valueOf(amount));
		boolean result = prodao.Editproduct(product);
		model.addAttribute("products", prodao.queryAll());
		return "product";
	}

}
