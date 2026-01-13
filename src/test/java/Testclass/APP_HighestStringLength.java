package Testclass;


import org.testng.annotations.Test;

import Generic.*;


public class APP_HighestStringLength extends AdminBaseControl {

	@Test(priority = 1, description = "Verify  which language key is having highest number of characters")
	public void Get_HighestLength_String_of_Particular_LanguageKey() throws Exception {

		AdminBaseControl.createTestName("Testcase TC3500 Verify  APP  with highest number of characters string ",
				"TesterName=brahmendra.jayaraju@gmail.com");
		
// File path and sheet name ,language column number 

		String filepath = JsonPaths.filepath;
		String Excelsheetname = JsonPaths.Excelsheetname ;
		
		WebutilityKeys.lengthKeyValue(filepath, Excelsheetname);

	}

}
