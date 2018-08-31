package com.internousdev.tabicale.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.internousdev.tabicale.dto.DestinationInfoDTO;
import com.internousdev.tabicale.util.DBConnector;

public class DestinationInfoDAO {

	//DBへ宛先登録情報をinsertします。
	public int insert(String userId, String familyName, String firstName, String familyNameKana, String firstNameKana, String email, String telNumber, String userAddress) {
		DBConnector dbConnector = new DBConnector();
		Connection connection = dbConnector.getConnection();
		int count = 0;
		String sql = "insert into destination_info(user_id, family_name, first_name, family_name_kana, first_name_kana, email, tel_number, user_address, regist_date, update_date) values (?, ?, ?, ?, ?, ?, ?, ?,now(),now())";

		try {
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, userId);
			preparedStatement.setString(2, familyName);
			preparedStatement.setString(3, firstName);
			preparedStatement.setString(4, familyNameKana);
			preparedStatement.setString(5, firstNameKana);
			preparedStatement.setString(6, email);
			preparedStatement.setString(7, telNumber);
			preparedStatement.setString(8, userAddress);
			count = preparedStatement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		try {
			connection.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return count;
	}

	//DBから登録した情報を取得して、DestinationInfoDTOへ登録させます。
	public List<DestinationInfoDTO> getDestinationInfo(String loginId) throws SQLException {
		DBConnector dbConnector = new DBConnector();
		Connection connection = dbConnector.getConnection();
		List<DestinationInfoDTO> destinationInfoDtoList = new ArrayList<DestinationInfoDTO>();

		String sql = "SELECT id, family_name, first_name, family_name_kana, first_name_kana, user_address, tel_number, email FROM destination_info WHERE user_id = ?";

		 try {
			 connection  = dbConnector.getConnection();
			 PreparedStatement ps = connection.prepareStatement(sql);
			 ps.setString(1, loginId);
			 ResultSet rs = ps.executeQuery();

			while(rs.next()) {
				DestinationInfoDTO destinationInfoDTO = new DestinationInfoDTO();
				destinationInfoDTO.setId(rs.getInt("id"));
				destinationInfoDTO.setFamilyName(rs.getString("family_name"));
				destinationInfoDTO.setFirstName(rs.getString("first_name"));
				destinationInfoDTO.setFamilyNameKana(rs.getString("family_name_kana"));
				destinationInfoDTO.setFirstNameKana(rs.getString("first_name_kana"));
				destinationInfoDTO.setUserAddress(rs.getString("user_address"));
				destinationInfoDTO.setEmail(rs.getString("email"));
				destinationInfoDTO.setTelNumber(rs.getString("tel_number"));
				destinationInfoDtoList.add(destinationInfoDTO);

			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			connection.close();
		}
		return destinationInfoDtoList;
	}

	//管理者用に全ての宛先情報を取得します
	public List<DestinationInfoDTO> getDestinationInfoDtoListByAdmin(){
		DBConnector dbConnector = new DBConnector();
		Connection connection = dbConnector.getConnection();
		List<DestinationInfoDTO> destinationInfoDtoList = new ArrayList<DestinationInfoDTO>();
		String sql = "select * from destination_info";

		try {
			PreparedStatement ps = connection.prepareStatement(sql);
			ResultSet resultSet = ps.executeQuery();
			while(resultSet.next()){
				DestinationInfoDTO dto = new DestinationInfoDTO();
				dto.setId(resultSet.getInt("id"));
				dto.setFamilyName(resultSet.getString("family_name"));
				dto.setFirstName(resultSet.getString("first_name"));
				dto.setFamilyNameKana(resultSet.getString("family_name_kana"));
				dto.setFirstNameKana(resultSet.getString("first_name_kana"));
				dto.setUserAddress(resultSet.getString("user_address"));
				dto.setEmail(resultSet.getString("email"));
				dto.setTelNumber(resultSet.getString("tel_number"));
				dto.setRegistDate(resultSet.getDate("regist_date"));
				dto.setUpdateDate(resultSet.getDate("update_date"));
				destinationInfoDtoList.add(dto);
			}
		}catch(SQLException e){
			e.printStackTrace();
		}
		try{
			connection.close();
		}catch(SQLException e){
			e.printStackTrace();
		}
		return destinationInfoDtoList;
	}

}
