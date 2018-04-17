/**
 * 
 */
package com.xatu.MysqlFactory;

import java.sql.Connection;
import java.sql.Statement;

import com.xatu.Connection.CreateMySqlConnection;
import com.xatu.DBFactor.DBFactory;
import com.xatu.SQLFactory.creatrSqlMySQL.SqlType;
import com.xatu.SQLFactory.sqlMysqlCreate;
import com.xatu.Statement.CreateMySQLStatement;

/**
 * @author Administrator
 *
 */
public class MySQLFactory extends DBFactory{

	@Override
	public Connection getCon() {
		return new CreateMySqlConnection().createConnecton();
	}


	@Override
	public Statement getSts(Connection con) {
		return new CreateMySQLStatement().createStatement(con);
	}


	@Override
	public String getSql(SqlType sqlType, String tableName, Object target) {
		switch (sqlType) {
        case INSERT:
           return sqlMysqlCreate.insert(tableName, target);
        case UPDATE:
            return null;
        case DELETE:
            return null;
          default:return null;
        }
	}

    
}
