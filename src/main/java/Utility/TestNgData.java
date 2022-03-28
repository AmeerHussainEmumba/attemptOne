package Utility;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;


import java.io.File;
import java.io.FileInputStream;

import java.io.IOException;

public class TestNgData {

    public static final String fileName = "src/main/java/externalResources/testData.xlsx";
    private static Object File= new File(fileName);

    public static Object[][] dataSet(int sheetNo) throws IOException {
        FileInputStream fileIS = new FileInputStream((java.io.File) File);
            XSSFWorkbook workBook = new XSSFWorkbook(fileIS);
            XSSFSheet dataSheet = workBook.getSheetAt(sheetNo);

            /*
            This line of code prepares the dataProvider, by gathering data in a 2-D object array. It uses the same functionality, used in the
            previous class, i.e. excelFileManipulation, to get the required data, only that it saves the entire row and associated column data
            in the form similar to coordinates of a map in the aforementioned 2-D array. The entire object is then returned
            */
            Object [][] Data = new Object[dataSheet.getLastRowNum()][dataSheet.getRow(0).getLastCellNum()];
        try{
            for (int i=0; i<dataSheet.getLastRowNum(); i++)
                { for (int k=0; k<dataSheet.getRow(0).getLastCellNum(); k++)
                    {
                        Data[i][k]=(dataSheet.getRow(i+1).getCell(k)).toString();
                        System.out.println(Data[i][k]);
                     }
                }
            }
        catch (Exception e)
            {
            System.out.println("error in logic "+e.getCause());
            e.printStackTrace();
            }
        return Data;
    }
}
