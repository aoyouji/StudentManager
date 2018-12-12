package com.product.dao;

import java.sql.Types;
import java.util.ArrayList;
import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;

import com.product.bean.Product;
import com.product.mapper.ProductMapper;
import com.student.bean.Student;
import com.student.mapper.StudentMapper;

/**
 * 商品注文
 * @author HTJ
 *
 */

public class ProductDao {
	// @Fields jdbcTemplate
		private JdbcTemplate jdbcTemplate;

		/**
		 * spring提供的类
		 *
		 * @param jdbcTemplate
		 * @param jdbcTemplate
		 *            返回值类型： void
		 */

		public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
			this.jdbcTemplate = jdbcTemplate;
		}

		/**
		 * すべての商品を表示する
		 *
		 * @return List<Product>
		 */

		public List<Product> queryAll() {
		  //SQLから学生情報を貰う
			String sql = "select * from products";
			return jdbcTemplate.query(sql, new ProductMapper());
		}
		/**
		 * 商品検索の方法
		 *
		 * @param id
		 * @return
		 */
		public List<Product> queryById(String id) {
			String sql = "select * from products where id like "+id+" ";
			List<Product> productlist = new ArrayList();
			productlist = jdbcTemplate.query(sql, new ProductMapper());
			return productlist;
		}
		/**
		 * 新規注文
		 *
		 * @param
		 * @return
		 */
		public boolean Addproduct(Product product) {
			String sql = "insert into products(id,productname,supplier,type,indate,price,amount)values(0,?,?,?,?,?,?)";
			boolean s;
			// jdbcTemplate.update(sql,new Object,new int);
			s = jdbcTemplate.update(sql,
					new Object[] { product.getProductname(),product.getSupplier(),product.getType(),product.getIndate(),product.getPrice(),product.getAmount(),
							},
					new int[] { Types.VARCHAR, Types.VARCHAR, Types.VARCHAR, Types.VARCHAR, Types.INTEGER, Types.INTEGER,  }) == 1;
			return s;

		}
		/**
		 * 商品削除の方法
		 *
		 * @param id
		 * @return
		 */
		public boolean Delproduct(Integer id) {
			String sql = "delete from products where id=?";
			return jdbcTemplate.update(sql, id) == 1;
		}
		/**
		 * 更新信息
		 *
		 * @param id
		 * @return 返回值类型： boolean
		 */
		public boolean Editproduct(Product product) {
			String sql = "update products set productname= ? ,supplier= ? ,type= ? ,indate= ? ，price= ? ,amount= ? where id= ?";
			Object productObj[] = new Object[] { product.getProductname(),product.getSupplier(),product.getType(),product.getIndate(),product.getPrice(),product.getAmount(),product.getId()};
			return jdbcTemplate.update(sql, productObj) == 1;
		}

}
