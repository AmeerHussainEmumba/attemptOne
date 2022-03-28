package Utility;

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

public class excelFileManipulation
{

    public static final String fileName = "src/main/java/externalResources/qaautomation.xlsx";
    private static Object File= new File(fileName);


    /*
    In this code the file saved as an object previously is used to create a new file input stream, which creates a Workbook, that then opens
    the specified sheet of the workbook, then total number of rows of that sheet that have information in them can be extracted.
    */
    public int rowCount(int sheetNo)
    { int rowCount=0;
        try{ FileInputStream fileIS = new FileInputStream((java.io.File) File);
            XSSFWorkbook workBook = new XSSFWorkbook(fileIS);
            XSSFSheet dataSheet = workBook.getSheetAt(sheetNo);
            rowCount= dataSheet.getPhysicalNumberOfRows();
        }
        catch (Exception e)
        {
            System.out.println("error is row count "+e.getCause());
            e.printStackTrace();
        }
        return rowCount;
    }
     /*
     This code allows us to open the sheet specified as before and get the number of columns in the sheet
     */
    public int columnCount(int sheetNo)
    { int columnCount=0;
        try{ FileInputStream fileIS = new FileInputStream((java.io.File) File);
            XSSFWorkbook workBook = new XSSFWorkbook(fileIS);
            XSSFSheet dataSheet = workBook.getSheetAt(sheetNo);
            columnCount= dataSheet.getRow(0).getPhysicalNumberOfCells();
        }
        catch (Exception e)
        {
            System.out.println("error is row count "+e.getCause());
            e.printStackTrace();
        }
        return columnCount;
    }
     /*
     This code allows us to get the sheet required as above and then append data into it. It uses the 'i' variable to get the sheet number, the
     'row' variable to get the row where we want to add data. It checks if the row already has data or not, if yes then it appends to the data,
     if not then it "creates" the row there
     */
    public void makeSheet(int i, int row, int column, String name) throws IOException {

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

     /*
     This code allows us to get the sheet required as above and then get data from it. It uses the 'SheetNo' variable to get the specific sheet
     the 'row' and 'column' variable to get the cell from where we want to get the data from. It returns "null" if there is no data in that cell
     */
    public String retrieveData(int sheetNo, int RowNumber, int column) throws IOException
    {
        try {
            String scanResult = "";
            FileInputStream fileIs = new FileInputStream((java.io.File) File);
            XSSFWorkbook qaAutomation = new XSSFWorkbook(fileIs);
            DataFormatter dataFormatter = new DataFormatter(); //used for displaying data as formatted in sheet
            Sheet Sheet = qaAutomation.getSheetAt(sheetNo);
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
