package deapp;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.InputMismatchException;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Set;
import java.util.TreeSet;
import java.util.stream.Stream;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

import junit.framework.Assert;

public class commonexcel extends AdminBaseControl {
	
	
	
	public static String readPropertyFiles(String filePath, String locatorName) throws Exception {
		Properties properties = new Properties();

		try {
			String projectpath = System.getProperty("user.dir");

			FileInputStream fileInputStream = new FileInputStream(projectpath + filePath);
			properties.load(fileInputStream);

		} catch (Exception var4) {
			var4.getStackTrace();
		}
		return properties.getProperty(locatorName);
	}

	public static String getdata(String pathname, String Sheetname, int rn, int cn) throws Exception {
		{

			try {

				// create and read file
				File f = new File(pathname);
				FileInputStream f1 = new FileInputStream(f);

				// create workbook
				XSSFWorkbook wb = new XSSFWorkbook(f1);

				// get sheet
				XSSFSheet sh = wb.getSheet(Sheetname);

				// get row

				XSSFRow r = sh.getRow(rn);

				// get cell

				XSSFCell c = r.getCell(cn);

				// get the data

				String data = c.getStringCellValue().toString();

				return data;
			}

			catch (Exception e) {
				return " ";
			}

		}

	}

	public static int getrowcount(String filepath, String Excelsheetname) throws Exception {
		{

			try {

				// create and read file
				File f = new File(filepath);
				FileInputStream f1 = new FileInputStream(f);

				// create workbook
				XSSFWorkbook wb = new XSSFWorkbook(f1);

				// get sheet
				XSSFSheet sh = wb.getSheet(Excelsheetname);

				// get row

				int rncount = sh.getLastRowNum();

				return rncount;

			}

			catch (Exception e) {
				return 0;
			}

		}
	}

	public static void AsserKeyValue(String filepath, String Excelsheetname, String jsonname, int lan_column_no)
			throws Exception {
		// create and read file
		File f = new File(filepath);
		FileInputStream fis = new FileInputStream(f);

		// create workbook
		XSSFWorkbook wb = new XSSFWorkbook(fis);

		// get sheet
		XSSFSheet sh = wb.getSheet(Excelsheetname);
		int numberrows = commonexcel.getrowcount(filepath, Excelsheetname);

		mainTest.log(Status.INFO,
				MarkupHelper.createLabel("Total Number of Keys in Excel=" + numberrows, ExtentColor.GREEN));

		// get all keys from the excel
		ArrayList<String> a1 = new ArrayList<String>();
		for (int i = 1; i <= numberrows; i++) {
			String data = commonexcel.getdata(filepath, Excelsheetname, i, 0);
			a1.add(data);
		}

		mainTest.log(Status.INFO, MarkupHelper.createLabel("All Keys in Excel=" + a1, ExtentColor.GREEN));

		// get all features from the excel
		ArrayList<String> feature = new ArrayList<String>();
		for (int b = 1; b <= numberrows; b++) {
			String featuredata = commonexcel.getdata(filepath, Excelsheetname, b, 1);
			feature.add(featuredata);
		}
		// TreeSet<String> arraylist=new TreeSet<String>(feature);
		TreeSet<String> arraylist = new TreeSet<String>(feature);

		mainTest.log(Status.INFO, MarkupHelper.createLabel("All Features in Excel=" + feature, ExtentColor.GREEN));

		// get all the values of particular language from excel

		ArrayList<String> execlvalues = new ArrayList<String>();
		for (int i = 1; i <= numberrows; i++) {

			// change language column number to test different language
			String data = commonexcel.getdata(filepath, Excelsheetname, i, lan_column_no);
			execlvalues.add(data);
		}

		mainTest.log(Status.INFO,
				MarkupHelper.createLabel("All Excel Values of Selected Language=" + execlvalues, ExtentColor.GREEN));

		// get value from the json file

		JSONParser jsonparse = new JSONParser();

		// change json path of particular language you want to test
		JSONObject jsonobject = (JSONObject) jsonparse.parse(new FileReader(jsonname));

		// adding all jscon arrayobject of json file to search key values
		ArrayList<String> modules = new ArrayList<String>();
		
		/*
		 * Collections.addAll(modules, "loginPage", "activation", "edition", "account",
		 * "error_messages", "coursecard", "home", "courses", "mycourses", "contactus",
		 * "settings", "serviceshop", "resources", "notifications", "supportSessions",
		 * "accessHistory", "addTrainer", "transferTrainer", "viewRequest", "myteams",
		 * "sideMenu","addEquipment","appHeader","common","configuredSystems",
		 * "equipments","otpConfiguration");
		 */
		modules.addAll(arraylist);
		ArrayList<String> jsonvalues = new ArrayList<String>();
		System.out.println("size"+modules.size());
		mainTest.log(Status.INFO, MarkupHelper.createLabel(
				"-------------------JSON KEY and JSON VALUE Mentioned Below------------------", ExtentColor.BLUE));

		int jsoncounter = 0;

		demo: for (int j = 0; j < a1.size(); j++) {

			for (int i = 0; i < modules.size(); i++) {
				
				JSONObject array = (JSONObject)jsonobject.get(modules.get(i));

				
				
				
				if (modules.get(i).equals(feature.get(j)))

				{
					
					
					boolean check=array.containsKey(a1.get(j));
					
					if (check) {

						String value = (String) array.get(a1.get(j));
						jsonvalues.add(value);

						mainTest.log(Status.INFO,
								MarkupHelper.createLabel(
										"KEY=" + "{" + a1.get(j) + "}" + " and " + "JSON_Value=" + "{" + value + "}",
										ExtentColor.GREEN));

						jsoncounter++;

						continue demo;
					}

					else if (check == false) {

						// if any key is missing in Json stop here and print that key

						mainTest.log(Status.INFO, MarkupHelper.createLabel(
								"KEY=" + "{" + a1.get(j) + "}" + " is Missing in JSON File ", ExtentColor.RED));

						Assert.fail("Above Mentioned Key is mission in JSON File");

					}
				}

			}

		}

		mainTest.log(Status.INFO,
				MarkupHelper.createLabel("Total JSON Key and JSON Values=" + jsoncounter, ExtentColor.GREEN));

		mainTest.log(Status.INFO, MarkupHelper
				.createLabel("--------------------Assertion started From Here--------------------", ExtentColor.BLUE));

		int assertion_counter = 0;

		for (int x = 0; x < a1.size(); x++) {

			if (execlvalues.get(x).equals(jsonvalues.get(x))) {

				mainTest.log(Status.INFO,
						MarkupHelper.createLabel("Excel_Key=" + "{" + a1.get(x) + "}" + " and " + " Excel_Value=" + "{"
								+ execlvalues.get(x) + "}" + " and " + " JSON_Value=" + "{" + jsonvalues.get(x) + "}",
								ExtentColor.GREEN));
			}

			else {
				mainTest.log(Status.INFO,
						MarkupHelper.createLabel("Excel_Key=" + "{" + a1.get(x) + "}" + " and " + " Excel_Value=" + "{"
								+ execlvalues.get(x) + "}" + " and " + " JSON_Value=" + "{" + jsonvalues.get(x) + "}",
								ExtentColor.RED));
			}

			
			
			
			
			Assert.assertEquals("There is Mismatch in Language values ", execlvalues.get(x), jsonvalues.get(x));

			assertion_counter++;
		}

		mainTest.log(Status.INFO,
				MarkupHelper.createLabel(
						"Assertion Ended All Data is Matching , Total Asserted Keys from JSON with Excel is="
								+ assertion_counter,
						ExtentColor.GREEN));

		
		ArrayList<String> a9 = new ArrayList<String>();

		for (String s1 : arraylist)

		{
			JSONObject array = (JSONObject) jsonobject.get(s1);

			a9.addAll(array.keySet());

		}

		Collections.sort(a1);

		Collections.sort(a9);

		for (String a10 : a9) {

			if (!a1.contains(a10)) {
				mainTest.log(Status.INFO,
						MarkupHelper.createLabel("This is an extra  KEY in JSON " + "{" + a10 + "}", ExtentColor.RED));
				Assert.fail("There is one Extra Key Found in JSON file");

			}

		}

	}

	public static void lengthKeyValue(String filepath, String Excelsheetname) throws Exception {

		// create and read file
		File f = new File(filepath);
		FileInputStream fis = new FileInputStream(f);

		// create workbook
		XSSFWorkbook wb = new XSSFWorkbook(fis);

		// get sheet
		XSSFSheet sh = wb.getSheet(Excelsheetname);
		int numberrows = commonexcel.getrowcount(filepath, Excelsheetname);

		mainTest.log(Status.INFO,
				MarkupHelper.createLabel("Total Number of Keys in Excel=" + numberrows, ExtentColor.GREEN));

		// get all keys from the excel
		ArrayList<String> a1 = new ArrayList<String>();
		a1.add(0, null);
		for (int i = 1; i <= numberrows; i++) {
			String data = commonexcel.getdata(filepath, Excelsheetname, i, 0);

			a1.add(data);
		}

		// get all features from the excel
		ArrayList<String> feature = new ArrayList<String>();
		feature.add(0, null);
		for (int b = 1; b <= numberrows; b++) {
			String featuredata = commonexcel.getdata(filepath, Excelsheetname, b, 1);
			feature.add(featuredata);
		}

		mainTest.log(Status.INFO, MarkupHelper.createLabel("All Keys in Excel=" + a1, ExtentColor.GREEN));

		mainTest.log(Status.INFO, MarkupHelper.createLabel("All Keys in Excel=" + feature, ExtentColor.GREEN));

		ArrayList<String> a2 = new ArrayList<String>();
		ArrayList<Integer> a3 = new ArrayList<Integer>();

		ArrayList<String> lan = new ArrayList<String>();

		for (int i = 1; i <= numberrows; i++) {

			// language start col num and end col number
			for (int j = 2; j <= 14; j++)

			{

				// change language column number to test different language
				String data = commonexcel.getdata(filepath, Excelsheetname, i, j);

				a2.add(data);
				a3.add(j);

			}

			String longestString = commonexcel.getLongestString(a2);

			HashMap<String, Integer> hm = new HashMap<>();

			for (int z = 0; z < a2.size(); z++)

			{

				String key = a2.get(z);

				Integer value = a3.get(z);

				hm.put(key, value);
			}

			Integer cellnum = hm.get(longestString);

			String Language = commonexcel.getcolumnname(filepath, Excelsheetname, cellnum);

			lan.add("Language=" + "{" + Language + "}" + " Feature=" + "{" + feature.get(i) + "}" + " key=" + "{"
					+ a1.get(i) + "}" + " value=" + "{" + longestString + "}");

			a2.clear();

			a3.clear();

		}

		Collections.sort(lan);

		for (int x = 0; x < lan.size(); x++) {

			if (lan.get(x).contains("English") | lan.get(x).contains("German")) {

				mainTest.log(Status.INFO, MarkupHelper.createLabel(lan.get(x), ExtentColor.GREEN));

			} else {

				
				// make red 
				mainTest.log(Status.INFO, MarkupHelper.createLabel(lan.get(x), ExtentColor.RED));
			}

		}

	}

	public static String getLongestString(ArrayList<String> a2) {
		int maxLength = 0;
		String longestString = null;
		for (String s : a2) {
			if (s.length() > maxLength) {
				maxLength = s.length();
				longestString = s;
			}
		}
		return longestString;
	}

	public static String getcolumnname(String filepath, String Excelsheetname, int cellnumber) throws IOException {

		// create and read file
		File f = new File(filepath);
		FileInputStream f1 = new FileInputStream(f);

		// create workbook
		XSSFWorkbook wb = new XSSFWorkbook(f1);

		// get sheet
		XSSFSheet sh = wb.getSheet(Excelsheetname);

		// get row

		XSSFRow r = sh.getRow(0);

		// get cell

		XSSFCell c = r.getCell(cellnumber);

		String data = c.getStringCellValue().toString();

		return data;

	}
	
	
	
	
	


}
