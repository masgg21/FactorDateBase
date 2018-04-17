/**
 * 
 */
package com.xatu.DBFactor;

import java.sql.Connection;
import java.sql.Statement;

import com.xatu.SQLFactory.creatrSqlMySQL.SqlType;

/**
 * @author Administrator
 *
 */
public abstract class DBFactory {
      //获取数据库的链接
	  public abstract Connection getCon();
	  //获取声明
	  public abstract Statement  getSts(Connection con);
	  //获取sql
	  public abstract String getSql(SqlType sqlType,String tableName,Object target);
}
