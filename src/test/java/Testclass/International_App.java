package Testclass;



import org.testng.annotations.Test;

import Generic.*;



public class International_App extends AdminBaseControl {
	
	@Test(priority = 1, description = "Verify Excel with JSON English ")
	public void verify_English_Language() throws Exception {

		AdminBaseControl.createTestName("Testcase TC3500 Verify APPlication English_Language_Validation",
				"TesterName=brahmendra.jayaraju@gmail.com");
// File path and sheet name ,language column number 
		String filepath = JsonPaths.filepath;
		String Excelsheetname = JsonPaths.Excelsheetname ;
		int lan_column_no = 2;
		String jsonname = JsonPaths.english;

		WebutilityKeys.AsserKeyValue(filepath, Excelsheetname, jsonname, lan_column_no);

	}

	
	
	@Test(priority = 2, description = "Verify Excel with JSON German ")
	public void verify_German_Language() throws Exception {

		AdminBaseControl.createTestName("Testcase  Verify APPlication German_Language_Validation",
				"TesterName=brahmendra.jayaraju@gmail.com");
//File path and sheet name ,language column number 
		String filepath = JsonPaths.filepath;
		String Excelsheetname = JsonPaths.Excelsheetname ;
		int lan_column_no = 7;
		String jsonname = JsonPaths.german;
		WebutilityKeys.AsserKeyValue(filepath, Excelsheetname, jsonname, lan_column_no);

	}
	
	
	@Test(priority = 2, description = "Verify Excel with JSON Danish ")
	public void verify_Danish_Language() throws Exception {

		AdminBaseControl.createTestName("Testcase  Verify APPlication Danish_Language_Validation",
				"TesterName=brahmendra.jayaraju@gmail.com");
		// File path and sheet name ,language column number
		String filepath = JsonPaths.filepath;
		String Excelsheetname = JsonPaths.Excelsheetname ;
		int lan_column_no = 13;
		String jsonname =JsonPaths. danish;

		WebutilityKeys.AsserKeyValue(filepath, Excelsheetname, jsonname, lan_column_no);
	}
	
	@Test(priority = 3, description = "Verify Excel with JSON Dutch ")
	public void verify_Dutch_Language() throws Exception {

		AdminBaseControl.createTestName("Testcase  Verify APPlication Dutch_Language_Validation",
				"TesterName=brahmendra.jayaraju@gmail.com");
//File path and sheet name ,language column number 
		String filepath = JsonPaths.filepath;
		String Excelsheetname = JsonPaths.Excelsheetname ;
		int lan_column_no = 6;
		String jsonname = JsonPaths.dutch;

		WebutilityKeys.AsserKeyValue(filepath, Excelsheetname, jsonname, lan_column_no);

	}

	@Test(priority = 4, description = "Verify Excel with JSON Finnish ")
	public void verify_Finnish_Language() throws Exception {

		AdminBaseControl.createTestName("Testcase  Verify APPlication Finnish_Language_Validation",
				"TesterName=brahmendra.jayaraju@gmail.com");
		// File path and sheet name,language column number
		String filepath = JsonPaths.filepath;
		String Excelsheetname = JsonPaths.Excelsheetname ;
		int lan_column_no =14;
		String jsonname = JsonPaths.finnish;

		WebutilityKeys.AsserKeyValue(filepath, Excelsheetname, jsonname, lan_column_no);
	}

	@Test(priority = 5, description = "Verify Excel with JSON French ")
	public void verify_French_Language() throws Exception {

		AdminBaseControl.createTestName("Testcase  Verify APPlication French_Language_Validation",
				"TesterName=brahmendra.jayaraju@gmail.com");
		// File path and sheet name ,language column number
		String filepath = JsonPaths.filepath;
		String Excelsheetname = JsonPaths.Excelsheetname ;
		int lan_column_no = 3;
		String jsonname = JsonPaths.french;

		WebutilityKeys.AsserKeyValue(filepath, Excelsheetname, jsonname, lan_column_no);

	}

	@Test(priority = 7, description = "Verify Excel with JSON Italian ")
	public void verify_Italian_Language() throws Exception {

		AdminBaseControl.createTestName("Testcase  Verify APPlication Italian_Language_Validation",
				"TesterName=brahmendra.jayaraju@gmail.com");
//File path and sheet name ,language column number 
		String filepath = JsonPaths.filepath;
		String Excelsheetname = JsonPaths.Excelsheetname ;
		int lan_column_no = 8;
		String jsonname =JsonPaths.italian;

		WebutilityKeys.AsserKeyValue(filepath, Excelsheetname, jsonname, lan_column_no);

	}

	@Test(priority = 8, description = "Verify Excel with JSON Norwegian")
	public void verify_Norwegian_Language() throws Exception {

		AdminBaseControl.createTestName("Testcase Verify APPlication Norwegian_Language_Validation",
				"TesterName=brahmendra.jayaraju@gmail.com");
//File path and sheet name ,language column number 
		String filepath = JsonPaths.filepath;
		String Excelsheetname = JsonPaths.Excelsheetname ;
		int lan_column_no = 9;
		String jsonname = JsonPaths.norweign;

		WebutilityKeys.AsserKeyValue(filepath, Excelsheetname, jsonname, lan_column_no);

	}

	@Test(priority = 9, description = "Verify Excel with JSON Spanish ")
	public void verify_Spanish_Language() throws Exception {

		AdminBaseControl.createTestName("Testcase  Verify APPlication Spanish_Language_Validation",
				"TesterName=brahmendra.jayaraju@gmail.com");
		// File path and sheet name,language column number
		String filepath = JsonPaths.filepath;
		String Excelsheetname = JsonPaths.Excelsheetname ;
		int lan_column_no = 4;
		String jsonname = JsonPaths.spanish;

		WebutilityKeys.AsserKeyValue(filepath, Excelsheetname, jsonname, lan_column_no);
	}

	@Test(priority = 10, description = "Verify Excel with JSN swedish ")
	public void verify_swedish_Language() throws Exception {

		AdminBaseControl.createTestName("Testcase  Verify APPlication swedish_Language_Validation",
				"TesterName=brahmendra.jayaraju@gmail.com");
		// File path and sheet name,language column number
		String filepath = JsonPaths.filepath;
		String Excelsheetname = JsonPaths.Excelsheetname ;
		int lan_column_no = 10;
		String jsonname = JsonPaths.swedish;

		WebutilityKeys.AsserKeyValue(filepath, Excelsheetname, jsonname, lan_column_no);
	}

	@Test(priority = 11, description = "Verify Excel with JSON Eurpoean_Portuguese ")
	public void verify_Eurpoean_Portuguese_Language() throws Exception {

		AdminBaseControl.createTestName("Testcase  Verify APPlication Eurpoean_Portuguese_Language_Validation",
				"TesterName=brahmendra.jayaraju@gmail.com");
		// File path and sheet name,language column number
		String filepath = JsonPaths.filepath;
		String Excelsheetname = JsonPaths.Excelsheetname ;
		int lan_column_no = 11;
		String jsonname = JsonPaths.portugal;

		WebutilityKeys.AsserKeyValue(filepath, Excelsheetname, jsonname, lan_column_no);

	}

	@Test(priority = 12, description = "Verify Excel with JSON Polish")
	public void verify_Polish_Language() throws Exception {

		AdminBaseControl.createTestName("Testcase  Verify APPlication Polish_Language_Validation",
				"TesterName=brahmendra.jayaraju@gmail.com");
		// File path and sheet name,language column number
		String filepath = JsonPaths.filepath;
		String Excelsheetname = JsonPaths.Excelsheetname ;
		int lan_column_no = 12;
		String jsonname = JsonPaths.polish;

		WebutilityKeys.AsserKeyValue(filepath, Excelsheetname, jsonname, lan_column_no);

	}

	@Test(priority = 13, description = "Verify Excel with JSON Brazil")
	public void verify_Portuguese_Brazil_Language() throws Exception {

		AdminBaseControl.createTestName("Testcase Verify APPlication Brazil_Language_Validation",
				"TesterName=brahmendra.jayaraju@gmail.com");
		// File path and sheet name,language column number
		String filepath = JsonPaths.filepath;
		String Excelsheetname = JsonPaths.Excelsheetname ;
		int lan_column_no = 5;
		String jsonname = JsonPaths.brazil;

		WebutilityKeys.AsserKeyValue(filepath, Excelsheetname, jsonname, lan_column_no);

	}

}
