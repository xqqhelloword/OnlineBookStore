
package dao;

import java.beans.IntrospectionException;
import java.beans.PropertyDescriptor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
 
import db.connDB;
/**
 * 
 * @author Kevin
 *
 */
public class Dao {
 
	// 获取表名
	public <T> String getTableName(Class<? extends GenericityDao<T>> clazz) {
		// 获取 包名.类名
		String className = clazz.getName();
		// 获取 表名
		String tableName = className.substring(className.lastIndexOf(".") + 1,
				className.length());
		return tableName;
	}
 
	// 获得一个有属性值的实体类
	public <T> GenericityDao<T> getJavaBean(
			Class<? extends GenericityDao<T>> clazz, ResultSet rs)
			throws IntrospectionException, IllegalArgumentException,
			IllegalAccessException, InvocationTargetException, SQLException,
			InstantiationException {
		GenericityDao<T> g = clazz.newInstance();
                // 获取所有的成员变量
              Field[] field = clazz.getDeclaredFields();
		int i = 1;
		for (Field f : field) {
			PropertyDescriptor pd = new PropertyDescriptor(f.getName(), clazz);
			Method setMethod = pd.getWriteMethod();
                        // 判断方法的返回值类型
                      if (f.getType() == String.class) {
				setMethod.invoke(g, rs.getString(i));
				i++;
			} else if (f.getType() == Integer.class) {
				setMethod.invoke(g, rs.getInt(i));
				i++;
			}
		}
		return g;
	}
 
	// 增加insert
	@SuppressWarnings("unchecked")
	public <T> void insertInfo(GenericityDao<T> gd) {
		// 获取 class 包名.类名
		Class<? extends GenericityDao<T>> clazz = (Class<? extends GenericityDao<T>>) gd
				.getClass();
		String tableName = getTableName(clazz);
		String sql = "insert into " + tableName + "(";
		Field[] fields = clazz.getDeclaredFields();
		for (Field field : fields) {
			String fieldName = field.getName();
			sql = sql + fieldName + ",";
		}
		// 去除最后sql语句最后的逗号
		sql = sql.substring(0, sql.length() - 1);
		sql += ") values (";
		// 获取属性的数量总数
		int fieldLength = fields.length;
		for (int i = 1; i <= fieldLength; i++) {
			sql += "?,";
		}
		sql = sql.substring(0, sql.length() - 1);
		sql += ");";
		Connection conn = null;
		PreparedStatement ps = null;
		try {
			conn = connDB.getConnection();
			ps = conn.prepareStatement(sql);
			int i = 0;
			// 获取属性(带路径)
			Field[] field = clazz.getDeclaredFields();
			Field.setAccessible(field, true);
			// 遍历属性
			for (Field field1 : field) {
				// i用来匹配多少个'？'
				i += 1;
				PropertyDescriptor pd = new PropertyDescriptor(
						field1.getName(), clazz);
				Method getMethod = pd.getReadMethod();
				Object obj = (Object) getMethod.invoke(gd);
				// 判断属性的类型
				if (field1.getType() == String.class) {
					ps.setString(i, obj.toString());
				} else if (field1.getType() == Integer.class) {
					ps.setInt(i, Integer.parseInt(obj.toString()));
				}
			}
			System.out.println(sql);
			ps.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (IntrospectionException e) {
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		} finally {
			if (ps != null) {
				try {
					ps.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
	}
 
	// 删除delete
	@SuppressWarnings("unchecked")
	public <T> void deleteInfo(GenericityDao<T> gd) {
		Class<? extends GenericityDao<T>> clazz = (Class<? extends GenericityDao<T>>) gd
				.getClass();
		String tableName = getTableName(clazz);
		String sql = "delete from " + tableName + " where ";
		Connection conn = null;
		Statement st = null;
		try {
			conn = connDB.getConnection();
			st = conn.createStatement();
			Field[] field = clazz.getDeclaredFields();
			Field.setAccessible(field, true);
			for (Field field1 : field) {
				PropertyDescriptor pd = new PropertyDescriptor(
						field1.getName(), clazz);
				Method getMethod = pd.getReadMethod();
				Object obj = (Object) getMethod.invoke(gd);
				if (field1.getType() == String.class) {
					sql += field1.getName() + "='" + obj.toString() + "' and ";
				} else if (field1.getType() == Integer.class) {
					sql += field1.getName() + "='"
							+ Integer.parseInt(obj.toString()) + "' and ";
				}
			}
			sql = sql.substring(0, sql.length() - 5) + ";";
			System.out.println(sql);
			st.execute(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (IntrospectionException e) {
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		} finally {
			if (st != null) {
				try {
					st.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
	}
 
	// 修改update
	@SuppressWarnings("unchecked")
	public <T> void updateInfo(GenericityDao<T> gd, GenericityDao<T> gd1) {
		Class<? extends GenericityDao<T>> clazz = (Class<? extends GenericityDao<T>>) gd
				.getClass();
		Class<? extends GenericityDao<T>> clazz1 = (Class<? extends GenericityDao<T>>) gd1
				.getClass();
		String tableName = getTableName(clazz);
		String sql = "update " + tableName + " set ";
		Connection conn = null;
		Statement st = null;
		try {
			conn = connDB.getConnection();
			st = conn.createStatement();
			Field[] field1 = clazz.getDeclaredFields();
			Field.setAccessible(field1, true);
			for (Field f : field1) {
				PropertyDescriptor pd = new PropertyDescriptor(f.getName(),
						clazz1);
				Method getMethod = pd.getReadMethod();
				Object obj = (Object) getMethod.invoke(gd1);
				if (f.getType() == String.class) {
					sql += f.getName() + "='" + obj.toString() + "',";
				} else if (f.getType() == Integer.class) {
					sql += f.getName() + "='"
							+ Integer.parseInt(obj.toString()) + "',";
				}
			}
			sql = sql.substring(0, sql.length() - 1) + " where ";
			Field[] field = clazz1.getDeclaredFields();
			Field.setAccessible(field, true);
			for (Field f : field) {
				PropertyDescriptor pd = new PropertyDescriptor(f.getName(),
						clazz);
				Method getMethod = pd.getReadMethod();
				Object obj = (Object) getMethod.invoke(gd);
				if (f.getType() == String.class) {
					sql += f.getName() + "='" + obj.toString() + "' and ";
				} else if (f.getType() == Integer.class) {
					sql += f.getName() + "='"
							+ Integer.parseInt(obj.toString()) + "' and ";
				}
			}
			sql = sql.substring(0, sql.length() - 5) + ";";
			System.out.println(sql);
			st.execute(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (IntrospectionException e) {
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			 e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		} finally {
			if (st != null) {
				try {
					st.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
	}
 
	// 查询所有
	@SuppressWarnings("unchecked")
	public <T> List<GenericityDao<T>> selectAll(GenericityDao<T> gd) {
		Class<? extends GenericityDao<T>> clazz = (Class<? extends GenericityDao<T>>) gd
				.getClass();
		List<GenericityDao<T>> list = new ArrayList<GenericityDao<T>>();
		String tableName = getTableName(clazz);
		String sql = "select * from " + tableName + ";";
		Connection conn = null;
		Statement st = null;
		ResultSet rs = null;
		try {
			conn = connDB.getConnection();
			st = conn.createStatement();
			rs = st.executeQuery(sql);
			while (rs.next()) {
				GenericityDao<T> g = getJavaBean(clazz, rs);
				list.add(g);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			 e.printStackTrace();
		} catch (IntrospectionException e) {
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		} finally {
			if (rs != null) {
				try {
					rs.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if (st != null) {
				try {
					st.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		return list;
	}
}
