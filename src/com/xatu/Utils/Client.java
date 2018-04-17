package com.xatu.Utils;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.xatu.DBFactor.DBFactory;
import com.xatu.SQLFactory.SQLFactory;
import com.xatu.SQLFactory.creatrSqlMySQL;
import com.xatu.SQLFactory.creatrSqlMySQL.SqlType;
import com.xatu.SQLFactory.sqlMysqlCreate;
import com.xatu.pojo.Student;

/**
 * @author Administrator
 *
 */
public class Client {
     public static void main(String[] args) {
		Object obj = XMLUtil.getBean();
		DBFactory factor=(DBFactory) obj;
		Statement sts = factor.getSts(factor.getCon());
    	Student stu=new Student();
    	String insert = factor.getSql(SqlType.INSERT, "test", stu);
    	System.out.println(insert);
    	try {
			ResultSet executeQuery = sts.executeQuery(insert);
		} catch (SQLException e) {
			e.printStackTrace();
		}
     }
}
