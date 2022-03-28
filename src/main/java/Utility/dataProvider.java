package Utility;


import org.testng.annotations.DataProvider;

import java.io.IOException;

public class dataProvider {
    protected TestNgData dataSet;
    @DataProvider(name="LoginTestData")
    public Object[][]loginTest() throws IOException {
        /*
        This code gets the data ready to be used as a dataProvider, by getting information from the sheet, no.1.
        */
        Object data[][] =dataSet.dataSet(1);
        return data;
    }
}
