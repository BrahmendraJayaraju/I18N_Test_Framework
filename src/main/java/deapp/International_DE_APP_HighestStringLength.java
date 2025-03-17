package deapp;

import org.testng.annotations.Test;

public class International_DE_APP_HighestStringLength extends AdminBaseControl {

	@Test(priority = 1, description = "Verify  which language key is having highest number of characters")
	public void Get_HighestLength_String_of_Particular_LanguageKey() throws Exception {

		AdminBaseControl.createTestName("Testcase TC3500 Verify DE_APP  with highest number of characters string ",
				"TesterName=brahmendra.jayaraju@ge.com");
// File path and sheet name ,language column number 
		String filepath = "./Data/FINAL1.xlsx";
		String Excelsheetname = "Sheet1";

		commonexcel.lengthKeyValue(filepath, Excelsheetname);

	}

}
