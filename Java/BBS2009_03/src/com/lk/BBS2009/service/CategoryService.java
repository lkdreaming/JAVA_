package com.lk.BBS2009.service;

import java.sql.*;
import java.util.*;
import com.lk.BBS2009.model.Category;
import com.lk.BBS2009.util.*;

public class CategoryService {
	public List<Category> list() {
		String sql = "select * from _category";
		Connection conn = DB.getConn();
		PreparedStatement ps = DB.prepare(conn, sql);
		Category c = null;
		List<Category> categories = new ArrayList<Category>();
		ResultSet rs = null;
		try {
			rs = ps.executeQuery();
			while (rs.next()) {
				c = new Category();
				c.setId(rs.getInt("id"));
				c.setName(rs.getString("name"));
				c.setDescription(rs.getString("description"));
				categories.add(c);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		DB.close(rs);
		DB.close(ps);
		DB.close(conn);
		return categories;
	}

	public void add(Category c) {
		String sql = "insert into _category values (null,?,?)";
		Connection conn = DB.getConn();
		PreparedStatement ps = DB.prepare(conn, sql);
		try {
			ps.setString(1, c.getName());
			ps.setString(2, c.getDescription());
			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		DB.close(ps);
		DB.close(conn);
		
	}

	public void update(Category c) {
		String sql = "update _category set name = ?,description = ? where id = ?";
		Connection conn = DB.getConn();
		PreparedStatement ps = DB.prepare(conn, sql);
		try {
			ps.setString(1, c.getName());
			ps.setString(2, c.getDescription());
			ps.setInt(3, c.getId());
			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		DB.close(ps);
		DB.close(conn);
		
	}

	public void delete(Category c) {
		deleteById(c.getId());
	}
	
	public void deleteById(int id) {
		String sql = "delete from _category where id = ?";
		Connection conn = DB.getConn();
		PreparedStatement ps = DB.prepare(conn, sql);
		try {
			ps.setInt(1, id);
			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		DB.close(ps);
		DB.close(conn);
		
	}
	
	public Category loadById(int id) {
		String sql = "select * from _category where id = ?";
		Connection conn = DB.getConn();
		PreparedStatement ps = DB.prepare(conn, sql);
		Category c = null;
		try {
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				c = new Category();
				c.setId(rs.getInt("id"));
				c.setName(rs.getString("name"));
				c.setDescription(rs.getString("description"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		DB.close(ps);
		DB.close(conn);
		return c;
		
	}
}
