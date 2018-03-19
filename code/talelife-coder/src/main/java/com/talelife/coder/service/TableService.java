package com.talelife.coder.service;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.talelife.coder.entity.Column;
import com.talelife.coder.entity.Config;
import com.talelife.coder.entity.Table;

/**
 * 
 * @author watye
 *
 */
@Service
public class TableService {
	@Autowired
	private Config config;
	
	@Autowired
	private DataSource dataSource;
	
	/**
	 * 获取表信息
	 * @return
	 */
	public List<Table> getTableInfo(){
		List<Map<String, String>> tableConfigs = config.getTableConfig();
		List<Table> tables = new ArrayList<Table>();
		for(Map<String, String> tableConfig : tableConfigs){
			tables.add(getTableInfo(tableConfig.get("tableName")));
		}
		return tables;
	}
	
	/**
	 * 根据表名获取表信息
	 * @param tableName
	 * @return
	 */
	private Table getTableInfo(String tableName){
		Table table = new Table();
		List<Column> columns = new ArrayList<Column>();
		List<Column> primaryKeys = new ArrayList<Column>();
		table.setName(tableName);
		table.setColumns(columns);
		table.setPrimaryKeys(primaryKeys);
		List<String> pkNames = new ArrayList<String>();
		try{
			Connection conn = dataSource.getConnection();
			DatabaseMetaData dmd = conn.getMetaData();
			
			//主键
			ResultSet rsPk = dmd.getPrimaryKeys(null, null, table.getName());
			while(rsPk.next()){
				pkNames.add(rsPk.getString("COLUMN_NAME"));
			}
			
			//列
			ResultSet rsCol = dmd.getColumns(null, "%", table.getName(), "%");
			
			//
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(String.format("SELECT * FROM %s WHERE 1<>1", table.getName()));
			ResultSetMetaData rsmd = rs.getMetaData();
			while(rsCol.next()){
				Column column = new Column();
				column.setName(rsCol.getString("COLUMN_NAME"));
				column.setPropertyName(com.talelife.coder.util.StringUtils.enCamel(column.getName()));
				column.setComment(rsCol.getString("REMARKS"));
				int i = rsCol.getRow();
				column.setType(rsmd.getColumnClassName(i));
				column.setIsNull(rsmd.isNullable(i)==0);
				column.setIsPk(pkNames.contains(column.getName()));
				column.setLength(rsmd.getColumnDisplaySize(i));
				columns.add(column);
			}
		}catch(SQLException e){
			throw new IllegalArgumentException(e);
		}
		
		//主键
		for(Column column : columns){
			if(pkNames.contains(column.getName())){
				primaryKeys.add(column);
			}
		}
		
		return table;
	}
	
	/**
	 * 取表配置
	 * @param tableName
	 * @return
	 */
	public Map<String,String> getTableConfig(String tableName){
		List<Map<String, String>> tableConfigs = config.getTableConfig();
		for(Map<String, String> tableConfig : tableConfigs){
			if(tableName.equals(tableConfig.get("tableName")))
				return tableConfig;
		}
		return null;
	}
}
