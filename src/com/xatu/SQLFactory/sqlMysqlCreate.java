/**
 * 
 */
package com.xatu.SQLFactory;

/**
 * @author Administrator
 *
 */
public class sqlMysqlCreate {
     public static String insert(String tableName,Object target) {
    	 return new creatrSqlMySQL(tableName, target).insert();
     }
}
