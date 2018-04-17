/**
 * 
 */
package com.xatu.SQLFactory;

/**
 * @author Administrator
 *
 */
public interface SQLFactory {
       //插入
	   public String insert();
	   //删除
	   public String delete();
	   //更新
	   public String update();
	   //查看
	   public String select();
}
