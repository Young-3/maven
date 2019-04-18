package org.young.converter;

import org.apache.ibatis.type.BaseTypeHandler;
import org.apache.ibatis.type.JdbcType;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * @author Young
 * @version1.0
 */

//Set java->db <T>->java类型
public class BooleanAndIntConverter extends BaseTypeHandler<Boolean> {
/*
* preparedStatement操作对象
* preparedStatement操作对象的操作位置
* aBoolean java值
* jbdcType jdbc操作数据库类型
*
* */

	@Override
	public void setNonNullParameter(PreparedStatement preparedStatement, int i, Boolean aBoolean, JdbcType jdbcType) throws SQLException {
		if (aBoolean){
			preparedStatement.setInt(i,1);
		}else {
			preparedStatement.setInt(i,0);
		}
	}

	//get db->java
	@Override
	public Boolean getNullableResult(ResultSet resultSet, String s) throws SQLException {
		int sexNom = resultSet.getInt(s);
	/*	if (sexNom==1){
			return true;
		}else {
			return false;
		}*/
		return sexNom==1?true:false;
	}

	@Override
	public Boolean getNullableResult(ResultSet resultSet, int i) throws SQLException {
		int sexNom = resultSet.getInt(i);

		return sexNom==1?true:false;

	}

	@Override
	public Boolean getNullableResult(CallableStatement callableStatement, int i) throws SQLException {
		int sexNom = callableStatement.getInt(i);

		return sexNom==1?true:false;
	}
}
