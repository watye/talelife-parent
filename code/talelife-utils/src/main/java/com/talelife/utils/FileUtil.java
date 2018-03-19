package com.talelife.utils;

import java.io.IOException;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.springframework.web.multipart.MultipartFile;

import com.talelife.utils.bean.excel.Cell;
import com.talelife.utils.bean.excel.Excel;

abstract public class FileUtil {
	
	/**
	 * 获取excel数据
	 * @param excelFile
	 * @return
	 * @throws InvalidFormatException
	 * @throws IOException
	 */
	public static Excel getExcelData(MultipartFile excelFile) throws InvalidFormatException, IOException{
		return getExcelData(excelFile,true);
	}
	
	/**
	 * 获取excel数据
	 * @param excelFile
	 * @param hasTitle
	 * @return
	 * @throws IOException
	 * @throws InvalidFormatException
	 */
	public static Excel getExcelData(MultipartFile excelFile,boolean hasTitle) throws IOException, InvalidFormatException {
         Excel excel = new Excel();
         excel.setName(excelFile.getOriginalFilename());
         Workbook workbook = WorkbookFactory.create(excelFile.getInputStream());
         //sheet
         for(int i=0;i<workbook.getNumberOfSheets();i++){
        	 Sheet poiSheet = workbook.getSheetAt(i);
        	 com.talelife.utils.bean.excel.Sheet sheet = new com.talelife.utils.bean.excel.Sheet();
        	 sheet.setName(poiSheet.getSheetName());
        	 com.talelife.utils.bean.excel.Row title = new com.talelife.utils.bean.excel.Row();
        	 sheet.setTitle(title);
        	 //row
        	 for(int j=0;j<=poiSheet.getLastRowNum();j++){
        		 com.talelife.utils.bean.excel.Row row = new com.talelife.utils.bean.excel.Row();
        		 Row poiRow = poiSheet.getRow(j); 
        		 //cell
        		 for(int k=0;k<poiRow.getLastCellNum();k++){
        			 Cell cell = new Cell();
        			 cell.setValue(poiRow.getCell(k).getStringCellValue());
            		 if(hasTitle && j==0){
            			 title.addCell(cell);
            		 }else{
            			 row.addCell(cell);
            		 }
        		 }
        		 if(!hasTitle || (hasTitle && j>0)){
        			 sheet.addRow(row);
        		 }
        	 }
        	 excel.addSheet(sheet);
         }
         return excel;
	}
}
