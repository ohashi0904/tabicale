package com.internousdev.tabicale.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.internousdev.tabicale.dto.ProductInfoDTO;
import com.internousdev.tabicale.util.DBConnector;

public class ProductInfoDAO {

	public List<ProductInfoDTO> getProductInfoList(){
		DBConnector dbConnector=new DBConnector();
		Connection connection=dbConnector.getConnection();
		List<ProductInfoDTO> productInfoDtoList=new ArrayList<ProductInfoDTO>();
		String sql="select * from product_info where status=0";

		try{
			PreparedStatement preparedStatement=connection.prepareStatement(sql);
			ResultSet resultSet=preparedStatement.executeQuery();
			while(resultSet.next()){
				ProductInfoDTO productInfoDto=new ProductInfoDTO();
				productInfoDto.setId(resultSet.getInt("id"));
				productInfoDto.setProductId(resultSet.getInt("product_id"));
				productInfoDto.setProductName(resultSet.getString("product_name"));
				productInfoDto.setProductNameKana(resultSet.getString("product_name_kana"));
				productInfoDto.setProductDescription(resultSet.getString("product_description"));
				productInfoDto.setCategoryId(resultSet.getInt("category_id"));
				productInfoDto.setPrice(resultSet.getInt("price"));
				productInfoDto.setImageFilePath(resultSet.getString("image_file_path"));
				productInfoDto.setImageFileName(resultSet.getString("image_file_name"));
				productInfoDto.setImageFileName2(resultSet.getString("image_file_name_2"));
				productInfoDto.setReleaseDate(resultSet.getDate("release_date"));
				productInfoDto.setReleaseCompany(resultSet.getString("release_company"));
				productInfoDto.setStatus(resultSet.getInt("status"));
				productInfoDto.setUpdateDate(resultSet.getDate("regist_date"));
				productInfoDto.setUpdateDate(resultSet.getDate("update_date"));
				productInfoDtoList.add(productInfoDto);
			}
		}catch(SQLException e){
			e.printStackTrace();
		}
		try{
			connection.close();
		}catch(SQLException e){
			e.printStackTrace();
		}
		return productInfoDtoList;
	}

	public ProductInfoDTO getProductInfo(int productId){
		DBConnector dbConnector=new DBConnector();
		Connection connection=dbConnector.getConnection();
		ProductInfoDTO productInfoDTO=new ProductInfoDTO();
		String sql="select * from product_info where product_id=? and status=0";
		try{
			PreparedStatement preparedStatement=connection.prepareStatement(sql);
			preparedStatement.setInt(1,productId);
			ResultSet resultSet=preparedStatement.executeQuery();
			while(resultSet.next()){
				productInfoDTO.setId(resultSet.getInt("id"));
				productInfoDTO.setProductId(resultSet.getInt("product_id"));
				productInfoDTO.setProductName(resultSet.getString("product_name"));
				productInfoDTO.setProductNameKana(resultSet.getString("product_name_kana"));
				productInfoDTO.setProductDescription(resultSet.getString("product_description"));
				productInfoDTO.setCategoryId(resultSet.getInt("category_id"));
				productInfoDTO.setPrice(resultSet.getInt("price"));
				productInfoDTO.setImageFilePath(resultSet.getString("image_file_path"));
				productInfoDTO.setImageFileName(resultSet.getString("image_file_name"));
				productInfoDTO.setImageFileName2(resultSet.getString("image_file_name_2"));
				productInfoDTO.setReleaseDate(resultSet.getDate("release_date"));
				productInfoDTO.setReleaseCompany(resultSet.getString("release_company"));
				productInfoDTO.setStatus(resultSet.getInt("status"));
				productInfoDTO.setUpdateDate(resultSet.getDate("regist_date"));
				productInfoDTO.setUpdateDate(resultSet.getDate("update_date"));
			}
		}catch(SQLException e){
			e.printStackTrace();
		}
		try{
			connection.close();
		}catch(SQLException e){
			e.printStackTrace();
		}
		return productInfoDTO;
	}
	public List<ProductInfoDTO> getProductInfoListByCategoryId(int categoryId,int productId,int limitOffset,int limitRowCount){
		DBConnector dbConnector=new DBConnector();
		Connection connection=dbConnector.getConnection();
		List<ProductInfoDTO> productInfoDtoList=new ArrayList<ProductInfoDTO>();
		String sql="select * from product_info where category_id=? and product_id not in(?) and status=0 order by rand() limit ?,?";
		try{
			PreparedStatement preparedStatement=connection.prepareStatement(sql);
			preparedStatement.setInt(1, categoryId);
			preparedStatement.setInt(2, productId);
			preparedStatement.setInt(3, limitOffset);
			preparedStatement.setInt(4, limitRowCount);
			ResultSet resultSet=preparedStatement.executeQuery();
			while(resultSet.next()){
				ProductInfoDTO productInfoDTO=new ProductInfoDTO();
				productInfoDTO.setId(resultSet.getInt("id"));
				productInfoDTO.setProductId(resultSet.getInt("product_id"));
				productInfoDTO.setProductName(resultSet.getString("product_name"));
				productInfoDTO.setProductNameKana(resultSet.getString("product_name_kana"));
				productInfoDTO.setProductDescription(resultSet.getString("product_description"));
				productInfoDTO.setCategoryId(resultSet.getInt("category_id"));
				productInfoDTO.setPrice(resultSet.getInt("price"));
				productInfoDTO.setImageFilePath(resultSet.getString("image_file_path"));
				productInfoDTO.setImageFileName(resultSet.getString("image_file_name"));
				productInfoDTO.setReleaseDate(resultSet.getDate("release_date"));
				productInfoDTO.setReleaseCompany(resultSet.getString("release_company"));
				productInfoDTO.setStatus(resultSet.getInt("status"));
				productInfoDTO.setUpdateDate(resultSet.getDate("regist_date"));
				productInfoDTO.setUpdateDate(resultSet.getDate("update_date"));
				productInfoDtoList.add(productInfoDTO);
			}
		}catch(SQLException e){
			e.printStackTrace();
		}
		try{
			connection.close();
		}catch(SQLException e){
			e.printStackTrace();
		}
		return productInfoDtoList;
	}

	public List<ProductInfoDTO> getProductInfoListAll(String[] keywordsList){
		DBConnector dbConnector=new DBConnector();
		Connection connection=dbConnector.getConnection();
		List<ProductInfoDTO> productInfoDtoList=new ArrayList<ProductInfoDTO>();
		String sql="select * from product_info where ";
		boolean initializeFlag=true;
		for(String keyword: keywordsList){
			if(initializeFlag){
				sql +="(product_name like '%" + keyword + "%' or product_name_kana like '%" + keyword + "%')";
				initializeFlag=false;
			}else{
				sql += " or (product_name like'%" + keyword + "%' or product_name_kana like '%" + keyword + "%')";
			}
			sql += " and status=0";
		}
		try {
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			ResultSet resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				ProductInfoDTO productInfoDTO = new ProductInfoDTO();
				productInfoDTO.setId(resultSet.getInt("id"));
				productInfoDTO.setProductId(resultSet.getInt("product_id"));
				productInfoDTO.setProductName(resultSet.getString("product_name"));
				productInfoDTO.setProductNameKana(resultSet.getString("product_name_kana"));
				productInfoDTO.setProductDescription(resultSet.getString("product_description"));
				productInfoDTO.setCategoryId(resultSet.getInt("category_id"));
				productInfoDTO.setPrice(resultSet.getInt("price"));
				productInfoDTO.setImageFilePath(resultSet.getString("image_file_path"));
				productInfoDTO.setImageFileName(resultSet.getString("image_file_name"));
				productInfoDTO.setReleaseDate(resultSet.getDate("release_date"));
				productInfoDTO.setReleaseCompany(resultSet.getString("release_company"));
				productInfoDTO.setStatus(resultSet.getInt("status"));
				productInfoDTO.setUpdateDate(resultSet.getDate("regist_date"));
				productInfoDTO.setUpdateDate(resultSet.getDate("update_date"));
				productInfoDtoList.add(productInfoDTO);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		try {
			connection.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return productInfoDtoList;
	}

	public List<ProductInfoDTO> getProductInfoListByKeywords(String[] keywordsList, String categoryId) {
		DBConnector dbConnector = new DBConnector();
		Connection connection = dbConnector.getConnection();
		List<ProductInfoDTO> productInfoDtoList = new ArrayList<ProductInfoDTO>();
		String sql = "select * from product_info where category_id =" + categoryId;
		boolean initializeFlag = true;
		for (String keyword : keywordsList) {
			if (initializeFlag) {
				sql += " and ( product_name like '%" + keyword + "%' or product_name_kana like '%" + keyword + "%' ";
				initializeFlag = false;
			} else {
				sql += " or product_name like '%" + keyword + "%' or product_name_kana like '%" + keyword + "%' ";
			}
		}
		if(keywordsList.length>0){
			sql += ")";
		}
		sql += " and status=0";

		try{
			PreparedStatement preparedStatement=connection.prepareStatement(sql);
			ResultSet resultSet=preparedStatement.executeQuery();
			while(resultSet.next()){
				ProductInfoDTO productInfoDTO=new ProductInfoDTO();
				productInfoDTO.setId(resultSet.getInt("id"));
				productInfoDTO.setProductId(resultSet.getInt("product_id"));
				productInfoDTO.setProductName(resultSet.getString("product_name"));
				productInfoDTO.setProductNameKana(resultSet.getString("product_name_kana"));
				productInfoDTO.setProductDescription(resultSet.getString("product_description"));
				productInfoDTO.setCategoryId(resultSet.getInt("category_id"));
				productInfoDTO.setPrice(resultSet.getInt("price"));
				productInfoDTO.setImageFilePath(resultSet.getString("image_file_path"));
				productInfoDTO.setImageFileName(resultSet.getString("image_file_name"));
				productInfoDTO.setReleaseDate(resultSet.getDate("release_date"));
				productInfoDTO.setReleaseCompany(resultSet.getString("release_company"));
				productInfoDTO.setStatus(resultSet.getInt("status"));
				productInfoDTO.setUpdateDate(resultSet.getDate("regist_date"));
				productInfoDTO.setUpdateDate(resultSet.getDate("update_date"));
				productInfoDtoList.add(productInfoDTO);
			}
		}catch(SQLException e){
			e.printStackTrace();
		}
		try{
			connection.close();
		}catch(SQLException e){
			e.printStackTrace();
		}
		return productInfoDtoList;
	}

	public int createProduct(int productId,String productName, String productNameKana,
			String productDescription,int categoryId, int price, String imageFilePath,
			String imageFileName,String imageFileName2,String releaseDate, String releaseCompany){
		DBConnector dbConnector = new DBConnector();
		Connection connection = dbConnector.getConnection();
		int count = 0;
		String sql = "INSERT INTO product_info(product_id,product_name,product_name_kana,product_description,category_id,price,image_file_path,image_file_name,image_file_name_2,release_date,release_company,regist_date,update_date) VALUES (?,?,?,?,?,?,?,?,?,?,?,now(),now())";

		try{
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setInt(1, productId);
			preparedStatement.setString(2, productName);
			preparedStatement.setString(3, productNameKana);
			preparedStatement.setString(4, productDescription);
			preparedStatement.setInt(5, categoryId);
			preparedStatement.setInt(6, price);
			preparedStatement.setString(7, imageFilePath);
			preparedStatement.setString(8, imageFileName);
			preparedStatement.setString(9, imageFileName2);
			preparedStatement.setString(10, releaseDate);
			preparedStatement.setString(11, releaseCompany);

			count = preparedStatement.executeUpdate();
		}catch(SQLException e){
			e.printStackTrace();
		}
		try{
			connection.close();
		}catch(SQLException e){
			e.printStackTrace();
		}
		return count;
	}

	//管理者画面・商品削除
		public int delete(int productId){
			DBConnector dbConnector = new DBConnector();
			Connection connection = dbConnector.getConnection();
			int count =0;
			String sql = "update product_info set status=1 where product_id=?";

			try{
				PreparedStatement preparedStatement = connection.prepareStatement(sql);
				preparedStatement.setInt(1, productId);
				count = preparedStatement.executeUpdate();
			}catch(SQLException e){
				e.printStackTrace();
			}
			try{
				connection.close();
			}catch(SQLException e){
				e.printStackTrace();
			}
			return count;
		}

		//登録されているproduct_idの内、最大値を取り出しプラス１する
		public int maxIdPlusOne(){
			DBConnector dbConnector = new DBConnector();
			Connection connection = dbConnector.getConnection();
			int count =0;
			String sql = "SELECT max(id) as maxid FROM product_info";

			try{
				PreparedStatement preparedStatement = connection.prepareStatement(sql);
				ResultSet rs = preparedStatement.executeQuery();
				if(rs.next()){
					count = rs.getInt("maxid");
				}
			}catch(SQLException e){
				e.printStackTrace();
			}
			try{
				connection.close();
			}catch(SQLException e){
				e.printStackTrace();
			}
			return count+1;
		}

		//同じ商品名が存在してるか検索
		public int identicalProductName(String productName){
			DBConnector dbConnector = new DBConnector();
			Connection connection = dbConnector.getConnection();
			int count =0;
			String sql = "select count(*) as count from product_info where product_name=?";

			try{
				PreparedStatement preparedStatement = connection.prepareStatement(sql);
				preparedStatement.setString(1, productName);
				ResultSet rs = preparedStatement.executeQuery();
				if(rs.next()){
					count = rs.getInt("count");
				}
			}catch(SQLException e){
				e.printStackTrace();
			}
			try{
				connection.close();
			}catch(SQLException e){
				e.printStackTrace();
			}
			return count;
		}

		//同じ商品名かなが存在してるか検索
		public int identicalProductNameKana(String productNameKana){
			DBConnector dbConnector = new DBConnector();
			Connection connection = dbConnector.getConnection();
			int count =0;
			String sql = "select count(*) as count from product_info where product_name_kana=?";

			try{
				PreparedStatement preparedStatement = connection.prepareStatement(sql);
				preparedStatement.setString(1, productNameKana);
				ResultSet rs = preparedStatement.executeQuery();
				if(rs.next()){
					count = rs.getInt("count");
				}
			}catch(SQLException e){
				e.printStackTrace();
			}
			try{
				connection.close();
			}catch(SQLException e){
				e.printStackTrace();
			}
			return count;
		}

		//商品情報を全て取り出します(status関係なし)
		public List<ProductInfoDTO> getProductInfoListAll(){
			DBConnector dbConnector=new DBConnector();
			Connection connection=dbConnector.getConnection();
			List<ProductInfoDTO> productInfoDtoList=new ArrayList<ProductInfoDTO>();
			String sql="select * from product_info";

			try{
				PreparedStatement preparedStatement=connection.prepareStatement(sql);
				ResultSet resultSet=preparedStatement.executeQuery();
				while(resultSet.next()){
					ProductInfoDTO productInfoDto=new ProductInfoDTO();
					productInfoDto.setId(resultSet.getInt("id"));
					productInfoDto.setProductId(resultSet.getInt("product_id"));
					productInfoDto.setProductName(resultSet.getString("product_name"));
					productInfoDto.setProductNameKana(resultSet.getString("product_name_kana"));
					productInfoDto.setProductDescription(resultSet.getString("product_description"));
					productInfoDto.setCategoryId(resultSet.getInt("category_id"));
					productInfoDto.setPrice(resultSet.getInt("price"));
					productInfoDto.setImageFilePath(resultSet.getString("image_file_path"));
					productInfoDto.setImageFileName(resultSet.getString("image_file_name"));
					productInfoDto.setImageFileName2(resultSet.getString("image_file_name_2"));
					productInfoDto.setReleaseDate(resultSet.getDate("release_date"));
					productInfoDto.setReleaseCompany(resultSet.getString("release_company"));
					productInfoDto.setStatus(resultSet.getInt("status"));
					productInfoDto.setUpdateDate(resultSet.getDate("regist_date"));
					productInfoDto.setUpdateDate(resultSet.getDate("update_date"));
					productInfoDtoList.add(productInfoDto);
				}
			}catch(SQLException e){
				e.printStackTrace();
			}
			try{
				connection.close();
			}catch(SQLException e){
				e.printStackTrace();
			}
			return productInfoDtoList;
		}
}
