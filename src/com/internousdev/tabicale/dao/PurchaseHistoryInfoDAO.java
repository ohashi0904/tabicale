package com.internousdev.tabicale.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.internousdev.tabicale.dto.PurchaseHistoryInfoDTO;
import com.internousdev.tabicale.util.DBConnector;

public class PurchaseHistoryInfoDAO {
	public List<PurchaseHistoryInfoDTO> getPurchaseHistoryList(String loginId) {
		DBConnector dbCon = new DBConnector();
		Connection con = dbCon.getConnection();
		List<PurchaseHistoryInfoDTO> dtoList = new ArrayList<PurchaseHistoryInfoDTO>();
		String sql = "SELECT"
				+ " phi.id as id,"
				+ " phi.user_id as user_id,"
				+ " phi.product_count as product_count,"
				+ " pi.product_id as product_id,"
				+ " pi.product_name as product_name,"
				+ " pi.product_name_kana as product_name_kana,"
				+ " pi.product_description as product_description,"
				+ " pi.category_id as category_id,"
				+ " pi.price,"
				+ " pi.image_file_name as image_file_name,"
				+ " pi.image_file_path as image_file_path,"
				+ " pi.release_company,"
				+ " pi.release_date,"
				+ " phi.price as price,"
				+ " phi.regist_date as regist_date,"
				+ " phi.update_date as update_date,"
				+ " di.family_name as family_name,"
				+ " di.first_name as first_name,"
				+ " di.family_name_kana as family_name_kana,"
				+ " di.first_name_kana as first_name_kana,"
				+ " di.email as email,"
				+ " di.tel_number as tel_number,"
				+ " di.user_address as user_address"
				+ " FROM purchase_history_info as phi"
				+ " LEFT JOIN product_info as pi"
				+ " ON phi.product_id = pi.product_id"
				+ " LEFT JOIN destination_info as di"
				+ " ON phi.destination_id = di.id"
				+ " WHERE phi.user_id = ?"
				+ " ORDER BY regist_date DESC";

		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, loginId);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				PurchaseHistoryInfoDTO dto = new PurchaseHistoryInfoDTO();
				dto.setId(rs.getInt("id"));
				dto.setUserId(rs.getString("user_id"));
				dto.setProductId(rs.getInt("product_id"));
				dto.setProductCount(rs.getInt("product_count"));
				dto.setPrice(rs.getInt("price"));
				dto.setRegistDate(rs.getDate("regist_date"));
				dto.setUpdateDate(rs.getDate("update_date"));
				dto.setProductName(rs.getString("product_name"));
				dto.setProductNameKana(rs.getString("product_name_kana"));
				dto.setProductDescription(rs.getString("product_description"));
				dto.setCategoryId(rs.getInt("category_id"));
				dto.setImageFileName(rs.getString("image_file_name"));
				dto.setImageFilePath(rs.getString("image_file_path"));
				dto.setReleaseCompany(rs.getString("release_company"));
				dto.setReleaseDate(rs.getDate("release_date"));
				dto.setFamilyName(rs.getString("family_name"));
				dto.setFirstName(rs.getString("first_name"));
				dto.setFamilyNameKana(rs.getString("family_name_kana"));
				dto.setFirstNameKana(rs.getString("first_name_kana"));
				dto.setEmail(rs.getString("email"));
				dto.setTelNumber(rs.getString("tel_number"));
				dto.setUserAddress(rs.getString("user_address"));
				dtoList.add(dto);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		try {
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return dtoList;
	}

	public int regist(String loginId, int productId, int productCount, int destinationId, int price) {
		DBConnector dbCon = new DBConnector();
		Connection con = dbCon.getConnection();
		String sql = "INSERT INTO purchase_history_info(user_id, product_id, product_count, price, destination_id, regist_date, update_date) VALUES (?, ?, ?, ?, ?, now(), now())";
		int count = 0;
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, loginId);
			ps.setInt(2, productId);
			ps.setInt(3, productCount);
			ps.setInt(4, price);
			ps.setInt(5, destinationId);
			count = ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		try {
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return count;
	}

	public int deleteAll(String loginId) {
		DBConnector dbCon = new DBConnector();
		Connection con = dbCon.getConnection();
		String sql = "DELETE FROM purchase_history_info where user_id=?";
		int count = 0;
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, loginId);
			count = ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		try {
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return count;
	}

	//管理者用の購入履歴情報を取得します
	public List<PurchaseHistoryInfoDTO> getPurchaseHistoryInfoDtoListByAdmin(){
		DBConnector dbCon = new DBConnector();
		Connection con = dbCon.getConnection();
		List<PurchaseHistoryInfoDTO> purchaseHistoryInfoDtoList = new ArrayList<PurchaseHistoryInfoDTO>();
		String sql = "select * from purchase_history_info";

		try{
			PreparedStatement ps = con.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while(rs.next()){
				PurchaseHistoryInfoDTO dto = new PurchaseHistoryInfoDTO();
				dto.setId(rs.getInt("id"));
				dto.setUserId(rs.getString("user_id"));
				dto.setProductId(rs.getInt("product_id"));
				dto.setProductCount(rs.getInt("product_count"));
				dto.setPrice(rs.getInt("price"));
				dto.setDestinationId(rs.getInt("destination_id"));
				dto.setRegistDate(rs.getDate("regist_date"));
				dto.setUpdateDate(rs.getDate("update_date"));
				purchaseHistoryInfoDtoList.add(dto);
			}
		}catch(SQLException e){
			e.printStackTrace();
		}

		try{
			con.close();
		}catch(SQLException e){
			e.printStackTrace();
		}
		return purchaseHistoryInfoDtoList;
	}
}
