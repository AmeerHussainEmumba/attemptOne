package Utility;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;


import java.io.File;
import java.io.FileInputStream;

import java.io.IOException;

public class TestNgData {

    public static final String fileName = "/Users/emumba/Desktop/From old PC/Automation Assignment/attemptOne/src/main/java/testData/testData.xlsx";
    private static Object File= new File(fileName);

    public static Object[][] dataSet(int Sheetno) throws IOException {
        FileInputStream fileIS = new FileInputStream((java.io.File) File);
            XSSFWorkbook workBook = new XSSFWorkbook(fileIS);
            XSSFSheet dataSheet = workBook.getSheetAt(Sheetno);
            Object [][] Data = new Object[dataSheet.getLastRowNum()][dataSheet.getRow(0).getLastCellNum()];
        try{
            for (int i=0; i<dataSheet.getLastRowNum(); i++)
            { for (int k=0; k<dataSheet.getRow(0).getLastCellNum(); k++)
            {
                Data[i][k]=(dataSheet.getRow(i+1).getCell(k)).toString();
                System.out.println(Data[i][k]);
            }
            }
            System.out.println("The data being returend is " + Data);
            }
        catch (Exception e)
            {
            System.out.println("error in logic "+e.getCause());
            e.printStackTrace();
            }
        return Data;
    }
}
