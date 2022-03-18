package Utility;

import Utility.TestNgData;
import org.testng.annotations.DataProvider;

import java.io.IOException;

public class dataProvider {
    protected TestNgData dataSet;
    @DataProvider(name="LoginTestData")
    public Object[][]loginTest() throws IOException {
        Object data[][] =dataSet.dataSet(1);
        return data;
    }
}
