package com.talelife.coder;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.StringWriter;
import java.io.Writer;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Map;

import org.apache.velocity.Template;
import org.apache.velocity.VelocityContext;
import org.apache.velocity.app.VelocityEngine;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.talelife.coder.entity.Config;
import com.talelife.coder.entity.Entity;
import com.talelife.coder.entity.Table;
import com.talelife.coder.service.EntityService;
import com.talelife.coder.service.TableService;
import com.talelife.coder.util.StringUtils;

@Service
public class CoderService {
	@Autowired
	private TableService tableService;
	
	@Autowired
	private EntityService entityService;
	
	@Autowired
	private Config config;
	
	private SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	/**
	 * 生成代码
	 */
	public void generate(){
		//1、取表信息
		List<Table> tables = tableService.getTableInfo();
		
		//2、生成代码
		for(Table table : tables){
			generate(table,tableService.getTableConfig(table.getName()));
		}
	}
	
	/**
	 * 生成代码
	 * @param table
	 * @param tableConfig
	 */
	private void generate(Table table,Map<String,String> tableConfig){
		
		//1、根据原始表获取实体数据
		Entity entity = entityService.getEntityInfo(table,tableConfig);
		
		//2、生成
		VelocityContext context = new VelocityContext();
		context.put("config", config);
		context.put("entity", entity);
		context.put("table", table);
		context.put("dateFormat", dateFormat);
		
		//获取模板文件
		File templateFolder = new File(System.getProperty("user.dir")+File.separator+"template");
		List<File> templateFiles = StringUtils.getFiles(templateFolder);
		if(templateFiles.isEmpty())
			return;
		
		//生成
		generateFiles(templateFiles,context);
	}

	/**
	 * 根据模板生成文件
	 * @param templateFiles
	 * @param context
	 */
	private void generateFiles(List<File> templateFiles, VelocityContext context) {
		VelocityEngine velocityEngine = new VelocityEngine();
		//绝对路径加载模板
		velocityEngine.setProperty(VelocityEngine.FILE_RESOURCE_LOADER_PATH, System.getProperty("user.dir"));
		velocityEngine.setProperty(VelocityEngine.ENCODING_DEFAULT, "UTF-8");
		velocityEngine.setProperty(VelocityEngine.OUTPUT_ENCODING, "UTF-8");
		velocityEngine.init();
		
		for(File templateFile : templateFiles){
			//模板相对路径
			String tempFileName = templateFile.getPath().replace(System.getProperty("user.dir")+File.separator, "");
			
			//获取输出文件名称
			String outputFileName = getOutputFileName(context, velocityEngine, tempFileName);
			
			Template template = velocityEngine.getTemplate(tempFileName,"UTF-8");
			Writer writer = new StringWriter();
			template.merge(context, writer);
			
			try{
				//配置路径（包含包路径）
				String configPath = config.getFileOutputPath()+File.separator+((Entity)context.get("entity")).getPackageName().replace(".", "\\");
				//创建输出文件夹
				String outputFolder = StringUtils.getFilePath(configPath+File.separator+outputFileName);
				File file = new File(outputFolder);
				if(!file.exists()){
					file.mkdirs();
				}
				
				//输出文件
				String outputFilePath = configPath+File.separator+outputFileName;
				BufferedOutputStream out = new BufferedOutputStream(new FileOutputStream(new File(outputFilePath)));
				out.write(writer.toString().getBytes());
				out.flush();
				out.close();
				System.out.println(outputFilePath);
			}catch(Exception e){
				e.printStackTrace();
			}
		}
	}

	/**
	 * 获取输出文件名称
	 * @param context
	 * @param velocityEngine
	 * @param tempFileName
	 * @return
	 */
	private String getOutputFileName(VelocityContext context, VelocityEngine velocityEngine, String tempFileName) {
		Writer fileNameWriter = new StringWriter();
		String outputFileName = tempFileName.replace(File.separator,"@");
		velocityEngine.evaluate(context, fileNameWriter, "", outputFileName);
		outputFileName = fileNameWriter.toString().replace("@", File.separator);
		outputFileName = outputFileName.substring(outputFileName.indexOf(File.separator)+1);
		return outputFileName;
	}
}
