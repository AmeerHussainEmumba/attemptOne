package Pages;

import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class ReadExcelFile
{
    public static final String fileName = "/Users/emumba/Desktop/From old PC/Automation Assignment/attemptOne/qaautomation.xlsx";
    private static Object File= new File(fileName);

    public static void MakeSheet(int i, int row, int column, String name) throws IOException {
        // setup workbook
        try {
            FileInputStream fileIS = new FileInputStream((java.io.File) File);
            XSSFWorkbook workBook = new XSSFWorkbook(fileIS);
            XSSFSheet editingSheet = workBook.getSheetAt(i);
            if (editingSheet.getRow(row)==null)
            {
                editingSheet.createRow(row).createCell(column).setCellValue(name);
                FileOutputStream fileOS = new FileOutputStream((java.io.File) File);
                workBook.write(fileOS);
            }
            else {
                editingSheet.getRow(row).createCell(column).setCellValue(name);
                FileOutputStream fileOS = new FileOutputStream((java.io.File) File);
                workBook.write(fileOS);
            }
        }
        catch (Exception e)
        {
            e.printStackTrace();
            System.out.println("some wing wang wong");
        }
    }
    public static String Retrievedata(int sheetNumb, int RowNumber, int column) throws IOException
    {
        try {
            String scanResult = "";
            FileInputStream fileIs = new FileInputStream((java.io.File) File);
            XSSFWorkbook qaAutomation = new XSSFWorkbook(fileIs);
            DataFormatter dataFormatter = new DataFormatter(); //used for displaying data as formatted in sheet
            Sheet Sheet = qaAutomation.getSheetAt(sheetNumb);
            //int rowCount = Sheet.getLastRowNum() - Sheet.getFirstRowNum(); -> used to see total row count

                Row row = Sheet.getRow(RowNumber);
                if (row.getCell(column).getCellType()== CellType.NUMERIC)
                {   scanResult = dataFormatter.formatCellValue(row.getCell(column));
                    return scanResult;
                }
                else {
                    scanResult = row.getCell(column).getStringCellValue();
                }
            return scanResult;
        } catch (Exception e) {
            e.printStackTrace();
            return "null";
        }
    }
}
