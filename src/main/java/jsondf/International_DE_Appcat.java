package jsondf;

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
import jsondf.commonexcelcat;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.google.gson.JsonParser;

import junit.framework.Assert;

public class International_DE_Appcat extends AdminBaseControlCat {

	@Test(priority = 1, description = "Verify Excel with JSON English ")
	public void verify_English_Language() throws Exception {

		AdminBaseControlCat.createTestName("Testcase TC3500 Verify DE_APP English_Language_Validation",
				"TesterName=brahmendra.jayaraju@ge.com");
// File path and sheet name ,language column number 
		String filepath = "./Data1/Book11.xlsx";
		String Excelsheetname = "Sheet1";
		int lan_column_no = 2;
		String langobj="en-US";

		commonexcelcat.AsserKeyValue(filepath, Excelsheetname, lan_column_no,langobj);

	}
	

	@Test(priority = 2, description = "Verify Excel with JSON German ")
	public void verify_German_Language() throws Exception {

		AdminBaseControlCat.createTestName("Testcase  Verify Connectivity German_Language_Validation",
				"TesterName=brahmendra.jayaraju@ge.com");
//File path and sheet name ,language column number 
		String filepath = "./Data1/Book11.xlsx";
		String Excelsheetname = "Sheet1";
		int lan_column_no = 7;
		String langobj="de-DE";
		commonexcelcat.AsserKeyValue(filepath, Excelsheetname, lan_column_no,langobj);

	}

	@Test(priority = 2, description = "Verify Excel with JSON Danish ")
	public void verify_Danish_Language() throws Exception {

		AdminBaseControlCat.createTestName("Testcase  Verify Connectivity Danish_Language_Validation",
				"TesterName=brahmendra.jayaraju@ge.com");
		// File path and sheet name ,language column number
		String filepath = "./Data1/Book11.xlsx";
		String Excelsheetname = "Sheet1";
		int lan_column_no = 3;
		
		String langobj="da-DK";
		commonexcelcat.AsserKeyValue(filepath, Excelsheetname, lan_column_no,langobj);
	}

	@Test(priority = 3, description = "Verify Excel with JSON Dutch ")
	public void verify_Dutch_Language() throws Exception {

		AdminBaseControlCat.createTestName("Testcase  Verify Connectivity Dutch_Language_Validation",
				"TesterName=brahmendra.jayaraju@ge.com");
//File path and sheet name ,language column number 
		String filepath = "./Data1/Book11.xlsx";
		String Excelsheetname = "Sheet1";
		int lan_column_no = 4;
		
		String langobj="nl-NL";
		commonexcelcat.AsserKeyValue(filepath, Excelsheetname, lan_column_no,langobj);

	}

	@Test(priority = 4, description = "Verify Excel with JSON Finnish ")
	public void verify_Finnish_Language() throws Exception {

		AdminBaseControlCat.createTestName("Testcase  Verify Connectivity Finnish_Language_Validation",
				"TesterName=brahmendra.jayaraju@ge.com");
		// File path and sheet name,language column number
		String filepath = "./Data1/Book11.xlsx";
		String Excelsheetname = "Sheet1";
		int lan_column_no =5;
	
		String langobj="fi-FI";
		commonexcelcat.AsserKeyValue(filepath, Excelsheetname, lan_column_no,langobj);
	}

	@Test(priority = 5, description = "Verify Excel with JSON French ")
	public void verify_French_Language() throws Exception {

		AdminBaseControlCat.createTestName("Testcase  Verify Connectivity French_Language_Validation",
				"TesterName=brahmendra.jayaraju@ge.com");
		// File path and sheet name ,language column number
		String filepath = "./Data1/Book11.xlsx";
		String Excelsheetname = "Sheet1";
		int lan_column_no = 6;
	
		String langobj="fr-FR";
		commonexcelcat.AsserKeyValue(filepath, Excelsheetname, lan_column_no,langobj);

	}

	@Test(priority = 7, description = "Verify Excel with JSON Italian ")
	public void verify_Italian_Language() throws Exception {

		AdminBaseControlCat.createTestName("Testcase  Verify Connectivity Italian_Language_Validation",
				"TesterName=brahmendra.jayaraju@ge.com");
//File path and sheet name ,language column number 
		String filepath = "./Data1/Book11.xlsx";
		String Excelsheetname = "Sheet1";
		int lan_column_no = 8;
		
		String langobj="it-IT";
		commonexcelcat.AsserKeyValue(filepath, Excelsheetname, lan_column_no,langobj);

	}

	@Test(priority = 8, description = "Verify Excel with JSON Norwegian")
	public void verify_Norwegian_Language() throws Exception {

		AdminBaseControlCat.createTestName("Testcase Verify Connectivity Norwegian_Language_Validation",
				"TesterName=brahmendra.jayaraju@ge.com");
//File path and sheet name ,language column number 
		String filepath = "./Data1/Book11.xlsx";
		String Excelsheetname = "Sheet1";
		int lan_column_no = 9;
	
		String langobj="nb-NO";
		commonexcelcat.AsserKeyValue(filepath, Excelsheetname, lan_column_no,langobj);

	}

	@Test(priority = 9, description = "Verify Excel with JSON Spanish ")
	public void verify_Spanish_Language() throws Exception {

		AdminBaseControlCat.createTestName("Testcase  Verify Connectivity Spanish_Language_Validation",
				"TesterName=brahmendra.jayaraju@ge.com");
		// File path and sheet name,language column number
		String filepath = "./Data/Book11.xlsx";
		String Excelsheetname = "Sheet1";
		int lan_column_no = 10;
		String jsonname = "./Data1/es.json";
		String langobj="es-ES";
		commonexcelcat.AsserKeyValue(filepath, Excelsheetname, lan_column_no,langobj);
	}

	@Test(priority = 10, description = "Verify Excel with JSN swedish ")
	public void verify_swedish_Language() throws Exception {

		AdminBaseControlCat.createTestName("Testcase  Verify Connectivity swedish_Language_Validation",
				"TesterName=brahmendra.jayaraju@ge.com");
		// File path and sheet name,language column number
		String filepath = "./Data1/Book11.xlsx";
		String Excelsheetname = "Sheet1";
		int lan_column_no = 11;
	
		String langobj="sv-SE";
		commonexcelcat.AsserKeyValue(filepath, Excelsheetname, lan_column_no,langobj);
	}

	@Test(priority = 11, description = "Verify Excel with JSON Eurpoean_Portuguese ")
	public void verify_Eurpoean_Portuguese_Language() throws Exception {

		AdminBaseControlCat.createTestName("Testcase  Verify Connectivity Eurpoean_Portuguese_Language_Validation",
				"TesterName=brahmendra.jayaraju@ge.com");
		// File path and sheet name,language column number
		String filepath = "./Data1/Book11.xlsx";
		String Excelsheetname = "Sheet1";
		int lan_column_no = 12;
		
		String langobj="pt-PT";
		commonexcelcat.AsserKeyValue(filepath, Excelsheetname, lan_column_no,langobj);

	}

	@Test(priority = 12, description = "Verify Excel with JSON Polish")
	public void verify_Polish_Language() throws Exception {

		AdminBaseControlCat.createTestName("Testcase  Verify Connectivity Polish_Language_Validation",
				"TesterName=brahmendra.jayaraju@ge.com");
		// File path and sheet name,language column number
		String filepath = "./Data1/Book11.xlsx";
		String Excelsheetname = "Sheet1";
		int lan_column_no = 13;
		
		String langobj="pl-PL";
		commonexcelcat.AsserKeyValue(filepath, Excelsheetname, lan_column_no,langobj);

	}

	@Test(priority = 13, description = "Verify Excel with JSON Brazil")
	public void verify_Portuguese_Brazil_Language() throws Exception {

		AdminBaseControlCat.createTestName("Testcase Verify Connectivity Brazil_Language_Validation",
				"TesterName=brahmendra.jayaraju@ge.com");
		// File path and sheet name,language column number
		String filepath = "./Data1/Book11.xlsx";
		String Excelsheetname = "Sheet1";
		int lan_column_no = 14;
		
		String langobj="pt-BR";
		commonexcelcat.AsserKeyValue(filepath, Excelsheetname, lan_column_no,langobj);
	}

}
