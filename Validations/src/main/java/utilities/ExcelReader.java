package utilities;


import java.io.File;
import java.io.FileInputStream;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelReader 
{
	private static XSSFSheet ExcelWSheet;

	private static XSSFWorkbook ExcelWBook;

	private static XSSFCell Cell;

	
	public static int return_total_rows_fromExcel(String Path,String SheetName) throws Exception {

		try {

			File file =    new File(Path);

			FileInputStream ExcelFile = new FileInputStream(file);

			

			ExcelWBook = new XSSFWorkbook(ExcelFile);

			ExcelWSheet = ExcelWBook.getSheet(SheetName);
			int num = ExcelWSheet.getLastRowNum()-ExcelWSheet.getFirstRowNum();
			return num;


		} catch (Exception e){

			throw (e);

		}

	}

	
	
	public static String getCellData(int RowNum, int ColNum) throws Exception{

		try{

			Cell = ExcelWSheet.getRow(RowNum).getCell(ColNum);

			String CellData = Cell.getStringCellValue();

			return CellData;

		}catch (Exception e){

			return"";

		}

	}


}