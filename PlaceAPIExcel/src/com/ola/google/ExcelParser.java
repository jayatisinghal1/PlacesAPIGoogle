package com.ola.google;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

// Reference: https://gist.github.com/madan712/3912272

public class ExcelParser {
	
	public static void writeXLSXFile(List<String> placeIds, Map<String, String> placeformattedAddress, Map<String, String> geoCodeformattedAddress) throws IOException {
		
		String excelFileName = "/Users/jayati.singhal/Downloads/test/out/PlaceAPI4.xlsx";//name of excel file

		String sheetName = "Response";//name of sheet

		XSSFWorkbook wb = new XSSFWorkbook();
		XSSFSheet sheet = wb.createSheet(sheetName) ;
	  
	  for (int i = 0; i < placeIds.size(); i++) {
		  String placeId = placeIds.get(i);
		  XSSFRow row = sheet.createRow(i);
		  XSSFCell cell0 = row.createCell(0);
		  XSSFCell cell1 = row.createCell(1);
		  XSSFCell cell2 = row.createCell(2);
		  XSSFCell cell3 = row.createCell(3);
		  XSSFCell cell4 = row.createCell(4);
		  cell0.setCellValue(placeId);
		  String[] responsePlaceArr = placeformattedAddress.get(placeId).split("###");
		  String[] responseGeoCodeArr = geoCodeformattedAddress.get(placeId).split("###");
		  cell1.setCellValue(responsePlaceArr[0]);
		  cell2.setCellValue(responseGeoCodeArr[0]);
		  cell3.setCellValue(responsePlaceArr[1]);
		  cell4.setCellValue(responseGeoCodeArr[1]);
		  if(!responsePlaceArr[1].equalsIgnoreCase(responseGeoCodeArr[1])){
			  XSSFCell cell5 = row.createCell(5);
			  cell5.setCellValue("Lat/Long not same");
		  }
	}

		FileOutputStream fileOut = new FileOutputStream(excelFileName);
		wb.write(fileOut);
		fileOut.flush();
		fileOut.close();
	}

}