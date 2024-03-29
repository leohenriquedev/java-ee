package model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.sql.ResultSet;
import java.util.ArrayList;

import model.bean.User;


public class UserDAO {
	
	private Connection conn;
	private PreparedStatement stmt;
	private Statement st;
	private ResultSet rs;
	private ArrayList<User> list = new ArrayList<>();
	
	public UserDAO() {
		conn = new ConnectionFactory().getConnection();
	}
	
	public void insert(User user) {
		
		String sql = "INSERT INTO users(name, age) VALUES(?,?)";
		
		try {
			stmt = conn.prepareStatement(sql);
			stmt.setString(1, user.getName());
			stmt.setInt(2, user.getAge());
			stmt.execute();
			stmt.close();
			
		} catch(Exception error) {
			throw new RuntimeException("Error: " + error);
		}
	}
	
	public ArrayList<User> read() {
		String sql = "SELECT * FROM users";
		
		try (Statement st = conn.createStatement()) {
			rs = st.executeQuery(sql);
			
			while(rs.next()) {
				User user = new User();
				user.setId(rs.getInt("id"));
				user.setName(rs.getString("name"));
				user.setAge(rs.getInt("age"));
				list.add(user);
			}
			
			
		} catch(Exception error) {
			throw new RuntimeException("Error: " + error);
		}
		
		return list;
	}
	
	public ArrayList<User> readBy(int id) {
		String sql = "SELECT * FROM users WHERE id = " + id;
		
		try (Statement st = conn.createStatement()) {
			rs = st.executeQuery(sql);
			
			if(rs.next()) {
				User user = new User();
				user.setId(rs.getInt("id"));
				user.setName(rs.getString("name"));
				user.setAge(rs.getInt("age"));
				list.add(user);
			}
			
			
		} catch(Exception error) {
			throw new RuntimeException("Error: " + error);
		}
		
		return list;
	}
	
	public void update(User user) {
		String sql = "UPDATE users SET name = ?, age = ? WHERE id = ?";
		try {
			stmt = conn.prepareStatement(sql);
			stmt.setString(1, user.getName());
			stmt.setInt(2, user.getAge());
			stmt.setInt(3, user.getId());
			stmt.execute();
			stmt.close();
			
		} catch(Exception error) {
			throw new RuntimeException("Error: " + error);
		}
	}
	
	public void delete (int id) {
		String sql = "DELETE FROM users WHERE id = " + id;
		try {
			st = conn.createStatement();
			st.execute(sql);
			st.close();
			
		} catch(Exception error) {
			throw new RuntimeException("Error: " + error);
		}
	}
	


}
