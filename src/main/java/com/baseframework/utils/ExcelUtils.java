package com.baseframework.utils;

import java.io.File;
import java.io.FileInputStream;
import java.lang.reflect.Field;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

import com.baseframework.example.pojo.Student;

public class ExcelUtils {

	private static final String EXCEL_XLS = "xls";
	private static final String EXCEL_XLSX = "xlsx";

	/**
	 * 获取Workbook对象
	 * 
	 * @param filePath
	 * @return
	 * @throws Exception
	 */
	public static Workbook getWorkbok(String filePath) throws Exception {
		File file = new File(filePath);
		if (!file.exists()) {
			throw new Exception("文件不存在");
		}
		if (!(file.isFile() && (file.getName().endsWith(EXCEL_XLS) || file.getName().endsWith(EXCEL_XLSX)))) {
			throw new Exception("文件不是Excel");
		}
		Workbook wb = WorkbookFactory.create(new FileInputStream(filePath));
		/*
		 * if (file.getName().endsWith(EXCEL_XLS)) { // Excel 2003 wb = new
		 * HSSFWorkbook(new FileInputStream(filePath)); } else if
		 * (file.getName().endsWith(EXCEL_XLSX)) { // Excel 2007/2010 wb = new
		 * XSSFWorkbook(new FileInputStream(filePath)); }
		 */
		return wb;
	}
	/**
	 * 将Workbook文档转化为实体对象List
	 * @param Workbook对象
	 * @param 需要转换的实体对象
	 * @return 实例对象list
	 * @throws Exception
	 */
	public static <E> List<E> read1(Workbook workbook,Class<E> c) throws Exception {
		List<E> list = new ArrayList<E>();
		Sheet sheet = workbook.getSheetAt(0);
		int totalRows = sheet.getPhysicalNumberOfRows();
		Field[] field = c.getDeclaredFields();
		DecimalFormat df = new DecimalFormat("0");
		for (int i = 1; i <= totalRows; i++) {
			// 取得该行
			Row row = sheet.getRow(i);
			// 注释的代码，是为了防止excel文件有空行
			if (row == null) {
				continue;
			}
			E obj = c.newInstance();
			for (int j = 0; j < field.length; j++) {
				
				/*使用反射获取方法对属性赋值
				 * String name = field[j].getName();
		           name = name.substring(0, 1).toUpperCase() + name.substring(1);
		        Method m = obj.getClass().getMethod("set"+name,String.class);
				m.invoke(obj, df.format(row.getCell(j).getNumericCellValue()));*/
				//使用反射直接对属性赋值
				field[j].setAccessible(true);
				field[j].set(obj,df.format(row.getCell(j).getNumericCellValue()));
			}
			list.add(obj);
		}
		return list;
	}
	
	/**
	 * 默认excel第一行为标题
	 * 
	 * @param workbook
	 * @param c
	 * @return
	 * @throws Exception
	 */
	public static <E> List<E> read(Workbook workbook, Class<E> c)
			throws Exception {
		Iterator<Row> iterator = workbook.getSheetAt(0).rowIterator();
		// 记录标题与单元格索引关系
		Map<String, Integer> titleIndex = new HashMap<>();

		if (!iterator.hasNext()) {
			return null;
		}

		Row row = iterator.next();

		int cellNumber = row.getPhysicalNumberOfCells();

		for (int i = 0; i < cellNumber; i++) {
			Cell cell = row.getCell(i);
			titleIndex.put(cell.getStringCellValue(), i);
		}

		return read(iterator, titleIndex, c);
	}

	/**
	 * excel中无标题，需要传入参数
	 * 
	 * @param title
	 * @param workbook
	 * @param c
	 * @return
	 * @throws Exception
	 */
	public static <E> List<E> read(String[] title, Workbook workbook, Class<E> c)
			throws Exception {
		// 传入的title长度超过excel宽度会出错

		Iterator<Row> iterator = workbook.getSheetAt(0).rowIterator();
		// 记录标题与单元格索引关系
		Map<String, Integer> titleIndex = new HashMap<>();
		for (int i = 0; i < title.length; i++) {
			titleIndex.put(title[i], i);
		}
		return read(iterator, titleIndex, c);
	}

	private static <E> List<E> read(Iterator<Row> iterator,
			Map<String, Integer> titleIndex, Class<E> c) throws Exception {
		List<E> result = new ArrayList<>();
		Field[] fields = c.getDeclaredFields();
		while (iterator.hasNext()) {
			E obj = c.newInstance();
			Row row = iterator.next();
			for (int j = 0; j < fields.length; j++) {
				Field field = fields[j];
				Integer fieldIndex = titleIndex.get(field.getName());
				if (fieldIndex == null) {
					continue;
				}
				field.setAccessible(true);
				field.set(obj, row.getCell(fieldIndex).getStringCellValue());
			}
			result.add(obj);
		}
		return result;
	}
	
	
	/**
	 * 将Workbook文档转化为实体对象List
	 * @param Workbook对象
	 * @param 需要转换的实体对象
	 * @throws Exception
	 */
	public static <E> void write(List<E> list,Class<E> c,String path) throws Exception {
		
		//WorkbookFactory.
		
		
		Field[] a = c.getDeclaredFields();
		for (int i = 0; i < list.size()+1; i++) {
			if(i==0){
				for (Field field : a) {
					
				}
			}else{
				for (E e : list) {
					
				}
				
				
			}
		}
		
		
	}

	public static void main(String[] args) throws Exception {			
		Workbook wb = ExcelUtils.getWorkbok("d:/test.xlsx");
		List<Student> list = ExcelUtils.read(wb,Student.class);
		System.out.println(list);
		
//		Field[] f =Student.class.getDeclaredFields();
//		
//		Student.class.newInstance();
		
		
		
//		
//		for (Field field : f) {
//			System.out.println(field.getName());
//		}
	}
}
