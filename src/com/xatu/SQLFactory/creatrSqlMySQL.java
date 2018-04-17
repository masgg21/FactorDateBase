/**
 * 
 */
package com.xatu.SQLFactory;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.List;
import java.util.Vector;

import org.apache.commons.lang3.reflect.FieldUtils;


/**
 * @author Administrator
 *
 */
public class creatrSqlMySQL implements SQLFactory{
	private Object target;

    private String tableName;
    
    private String idName;

    private Object idValue;

	private SqlType currentType;
	
	private List<Field> fields = new Vector<Field>();
	
	private List<Object> param = new Vector<Object>();
	
	private String sqlBuffer;
	

    public String getIdName() {
		return idName;
	}


	public Object getIdValue() {
		return idValue;
	}


	public String getSqlBuffer() {
		return sqlBuffer;
	}
	

	public List<Object> getParam() {
		return param;
	}


	public enum SqlType {
        INSERT, UPDATE, DELETE,SELECT
    }
	public creatrSqlMySQL(String tableName,Object target) {
        this.target = target;
        this.tableName=tableName;
    }


    protected void getFields(Class<?> clazz) {
        if (Object.class.equals(clazz)) {
            return;
        }
        Field[] fieldArray = clazz.getDeclaredFields();
        for (Field file : fieldArray) {
            fields.add(file);
        }
        getFields(clazz.getSuperclass());
    }
    
    protected Object readField(Field field) {
        try {
            return FieldUtils.readField(field, target, true);
        } catch (Exception e) {
            throw new RuntimeException(currentType.name(), e);
        }
    }
	@Override
	public String insert() {
		Class<? extends Object> class2 = target.getClass();
		Class<? extends Object> class1 = class2;
		getFields(class1);
        StringBuffer sqlBuffer = new StringBuffer();
        sqlBuffer.append("INSERT INTO ").append(tableName).append("(");

        for (Field field : fields) {
            if (!Modifier.isStatic(field.getModifiers())) {
                ID id = field.getAnnotation(ID.class);
                if (id == null) {
                    sqlBuffer.append(field.getName()).append(",");
                    param.add(readField(field));
                }
            }
        }
        int length = sqlBuffer.length();
        sqlBuffer.delete(length - 1, length).append(")values(");
        int size = param.size();
        String s[]=new String[size];
        Class in=target.getClass();
        for (int x = 0; x < size; x++) {
            if (x != 0) {
                sqlBuffer.append(",");
            }
            sqlBuffer.append("?");
        }
        sqlBuffer.append(")");
		return sqlBuffer.toString();
	}

	@Override
	public String delete() {

		return null;
	}

	@Override
	public String update() {

		return null;
	}

	@Override
	public String select() {

		return null;
	}
	//创建注解,标识该model的id字段
    @java.lang.annotation.Target(value = { java.lang.annotation.ElementType.FIELD })
    @java.lang.annotation.Retention(value = java.lang.annotation.RetentionPolicy.RUNTIME)
    public @interface ID {
    }
}
