package deapp;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.apache.xmlbeans.impl.xb.xsdschema.Public;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.testng.Reporter;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import deapp.AdminBaseControl;
import deapp.commonexcel;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.google.gson.JsonParser;

import junit.framework.Assert;

public class International_DE_App extends AdminBaseControl {
	
	@Test(priority = 1, description = "Verify Excel with JSON English ")
	public void verify_English_Language() throws Exception {

		AdminBaseControl.createTestName("Testcase TC3500 Verify DE_APP English_Language_Validation",
				"TesterName=brahmendra.jayaraju@ge.com");
// File path and sheet name ,language column number 
		String filepath = "./Data/FINAL1.xlsx";
		String Excelsheetname = "Sheet1";
		int lan_column_no = 2;
		String jsonname = "./Data/en.json";

		commonexcel.AsserKeyValue(filepath, Excelsheetname, jsonname, lan_column_no);

	}

	@Test(priority = 2, description = "Verify Excel with JSON German ")
	public void verify_German_Language() throws Exception {

		AdminBaseControl.createTestName("Testcase  Verify DE_APP German_Language_Validation",
				"TesterName=brahmendra.jayaraju@ge.com");
//File path and sheet name ,language column number 
		String filepath ="./Data/FINAL1.xlsx";
		String Excelsheetname = "Sheet1";
		int lan_column_no = 7;
		String jsonname = "./Data/de.json";
		commonexcel.AsserKeyValue(filepath, Excelsheetname, jsonname, lan_column_no);

	}
	
	
	@Test(priority = 2, description = "Verify Excel with JSON Danish ")
	public void verify_Danish_Language() throws Exception {

		AdminBaseControl.createTestName("Testcase  Verify DE_APP Danish_Language_Validation",
				"TesterName=brahmendra.jayaraju@ge.com");
		// File path and sheet name ,language column number
		String filepath = "./Data/FINAL1.xlsx";
		String Excelsheetname = "Sheet1";
		int lan_column_no = 13;
		String jsonname = "./Data/da.json";

		commonexcel.AsserKeyValue(filepath, Excelsheetname, jsonname, lan_column_no);
	}
	
	@Test(priority = 3, description = "Verify Excel with JSON Dutch ")
	public void verify_Dutch_Language() throws Exception {

		AdminBaseControl.createTestName("Testcase  Verify DE_APP Dutch_Language_Validation",
				"TesterName=brahmendra.jayaraju@ge.com");
//File path and sheet name ,language column number 
		String filepath = "./Data/FINAL1.xlsx";
		String Excelsheetname = "Sheet1";
		int lan_column_no = 6;
		String jsonname = "./Data/nl.json";

		commonexcel.AsserKeyValue(filepath, Excelsheetname, jsonname, lan_column_no);

	}

	@Test(priority = 4, description = "Verify Excel with JSON Finnish ")
	public void verify_Finnish_Language() throws Exception {

		AdminBaseControl.createTestName("Testcase  Verify DE_APP Finnish_Language_Validation",
				"TesterName=brahmendra.jayaraju@ge.com");
		// File path and sheet name,language column number
		String filepath = "./Data/FINAL1.xlsx";
		String Excelsheetname = "Sheet1";
		int lan_column_no =14;
		String jsonname = "./Data/fi.json";

		commonexcel.AsserKeyValue(filepath, Excelsheetname, jsonname, lan_column_no);
	}

	@Test(priority = 5, description = "Verify Excel with JSON French ")
	public void verify_French_Language() throws Exception {

		AdminBaseControl.createTestName("Testcase  Verify DE_APP French_Language_Validation",
				"TesterName=brahmendra.jayaraju@ge.com");
		// File path and sheet name ,language column number
		String filepath = "./Data/FINAL1.xlsx";
		String Excelsheetname = "Sheet1";
		int lan_column_no = 3;
		String jsonname = "./Data/fr.json";

		commonexcel.AsserKeyValue(filepath, Excelsheetname, jsonname, lan_column_no);

	}

	@Test(priority = 7, description = "Verify Excel with JSON Italian ")
	public void verify_Italian_Language() throws Exception {

		AdminBaseControl.createTestName("Testcase  Verify DE_APP Italian_Language_Validation",
				"TesterName=brahmendra.jayaraju@ge.com");
//File path and sheet name ,language column number 
		String filepath = "./Data/FINAL1.xlsx";
		String Excelsheetname = "Sheet1";
		int lan_column_no = 8;
		String jsonname = "./Data/it.json";

		commonexcel.AsserKeyValue(filepath, Excelsheetname, jsonname, lan_column_no);

	}

	@Test(priority = 8, description = "Verify Excel with JSON Norwegian")
	public void verify_Norwegian_Language() throws Exception {

		AdminBaseControl.createTestName("Testcase Verify DE_APP Norwegian_Language_Validation",
				"TesterName=brahmendra.jayaraju@ge.com");
//File path and sheet name ,language column number 
		String filepath = "./Data/FINAL1.xlsx";
		String Excelsheetname = "Sheet1";
		int lan_column_no = 9;
		String jsonname = "./Data/no.json";

		commonexcel.AsserKeyValue(filepath, Excelsheetname, jsonname, lan_column_no);

	}

	@Test(priority = 9, description = "Verify Excel with JSON Spanish ")
	public void verify_Spanish_Language() throws Exception {

		AdminBaseControl.createTestName("Testcase  Verify DE_APP Spanish_Language_Validation",
				"TesterName=brahmendra.jayaraju@ge.com");
		// File path and sheet name,language column number
		String filepath = "./Data/FINAL1.xlsx";
		String Excelsheetname = "Sheet1";
		int lan_column_no = 4;
		String jsonname = "./Data/es.json";

		commonexcel.AsserKeyValue(filepath, Excelsheetname, jsonname, lan_column_no);
	}

	@Test(priority = 10, description = "Verify Excel with JSN swedish ")
	public void verify_swedish_Language() throws Exception {

		AdminBaseControl.createTestName("Testcase  Verify DE_APP swedish_Language_Validation",
				"TesterName=brahmendra.jayaraju@ge.com");
		// File path and sheet name,language column number
		String filepath = "./Data/FINAL1.xlsx";
		String Excelsheetname = "Sheet1";
		int lan_column_no = 10;
		String jsonname = "./Data/sv.json";

		commonexcel.AsserKeyValue(filepath, Excelsheetname, jsonname, lan_column_no);
	}

	@Test(priority = 11, description = "Verify Excel with JSON Eurpoean_Portuguese ")
	public void verify_Eurpoean_Portuguese_Language() throws Exception {

		AdminBaseControl.createTestName("Testcase  Verify DE_APP Eurpoean_Portuguese_Language_Validation",
				"TesterName=brahmendra.jayaraju@ge.com");
		// File path and sheet name,language column number
		String filepath = "./Data/FINAL1.xlsx";
		String Excelsheetname = "Sheet1";
		int lan_column_no = 11;
		String jsonname = "./Data/pt.json";

		commonexcel.AsserKeyValue(filepath, Excelsheetname, jsonname, lan_column_no);

	}

	@Test(priority = 12, description = "Verify Excel with JSON Polish")
	public void verify_Polish_Language() throws Exception {

		AdminBaseControl.createTestName("Testcase  Verify DE_APP Polish_Language_Validation",
				"TesterName=brahmendra.jayaraju@ge.com");
		// File path and sheet name,language column number
		String filepath = "./Data/FINAL1.xlsx";
		String Excelsheetname = "Sheet1";
		int lan_column_no = 12;
		String jsonname = "./Data/pl.json";

		commonexcel.AsserKeyValue(filepath, Excelsheetname, jsonname, lan_column_no);

	}

	@Test(priority = 13, description = "Verify Excel with JSON Brazil")
	public void verify_Portuguese_Brazil_Language() throws Exception {

		AdminBaseControl.createTestName("Testcase Verify DE_APP Brazil_Language_Validation",
				"TesterName=brahmendra.jayaraju@ge.com");
		// File path and sheet name,language column number
		String filepath = "./Data/FINAL1.xlsx";
		String Excelsheetname = "Sheet1";
		int lan_column_no = 5;
		String jsonname = "./Data/Pt_br.json";

		commonexcel.AsserKeyValue(filepath, Excelsheetname, jsonname, lan_column_no);

	}

}
