package com.appium.hefanlive;

import java.io.File;
import java.io.IOException;

import jxl.Cell;
import jxl.CellType;
import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;
import jxl.write.Label;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;

public class Xlsfile {
	File classpathRoot = new File(System.getProperty("user.dir"));
	File appDir = new File(classpathRoot, "testcase");
	File f=new File(appDir, "testcase.xls");
	public static String readxls(String sheetname,int x,int y){
		//File f=new File("E:"+File.separator+"ldtest.xls");
		File classpathRoot = new File(System.getProperty("user.dir"));
		File appDir = new File(classpathRoot, "testcase");
		File f=new File(appDir, "testcase.xls");
		String cellname=null;
			try {
				Workbook book=Workbook.getWorkbook(f);
				Sheet sheet=book.getSheet(sheetname);   
				Cell cell=sheet.getCell(x, y);
				cellname=cell.getContents().toString();
				//System.out.print(cell.getContents()+" "); 

			} catch (BiffException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return cellname;
	}
	
	public static boolean isempty(String sheetname,int x,int y){
		//File f=new File("E:"+File.separator+"ldtest.xls");
		File classpathRoot = new File(System.getProperty("user.dir"));
		File appDir = new File(classpathRoot, "testcase");
		File f=new File(appDir, "testcase.xls");
		//测试用例存放目录
		boolean result=true;
			try {
				Workbook book=Workbook.getWorkbook(f);//
				Sheet sheet=book.getSheet(sheetname);   
				Cell cell=sheet.getCell(x, y);
				result=cell.getType()==CellType.EMPTY;
				//System.out.print(cell.getContents()+" "); 
				
			} catch (BiffException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return result;
	}
	
	public static int search(String keyword){
		int i=1;
		try{
			
			//File f=new File("E:"+File.separator+"ldtest.xls");
			File classpathRoot = new File(System.getProperty("user.dir"));
			File appDir = new File(classpathRoot, "testcase");
			File f=new File(appDir, "testcase.xls");
			
			for(;i>0;i++)
			{
				Workbook book=Workbook.getWorkbook(f);//
				Sheet sheet=book.getSheet("hefanlive_object"); 	
				Cell cell=sheet.getCell(1, i);
				if(cell.getType()==CellType.EMPTY)
				{i=0;break;}
				if(keyword.equals(cell.getContents().toString()))
				{break;}
				
			}


		}
		catch(Exception e){
			System.out.println(e);
	}
		return i;//���عؼ�����������
	}
	
	public static void writexls(String sheetname,int x,int y,String value){
		try{
			File classpathRoot = new File(System.getProperty("user.dir"));
			File appDir = new File(classpathRoot, "testcase");
			File f=new File(appDir, "testcase.xls");

			Workbook wb=Workbook.getWorkbook(f);
			WritableWorkbook book=Workbook.createWorkbook(f,wb);
			WritableSheet sheet=book.getSheet(sheetname);
			sheet.addCell(new Label(x,y,value));
			book.write();
			book.close();
		}
		catch(Exception e){
			System.out.println(e);
	}
	}
	


}
