package jsondf;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.TreeSet;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import jsondf.commonexcelcat;
import junit.framework.Assert;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

public class commonexcelcat extends AdminBaseControlCat {

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

	public static void AsserKeyValue(String filepath, String Excelsheetname, int lan_column_no, String langobj)
			throws Exception {

		// create and read file
		File f = new File(filepath);
		FileInputStream fis = new FileInputStream(f);

		// create workbook
		XSSFWorkbook wb = new XSSFWorkbook(fis);

		// get sheet
		XSSFSheet sh = wb.getSheet(Excelsheetname);
		int numberrows = commonexcelcat.getrowcount(filepath, Excelsheetname);

		mainTest.log(Status.INFO,
				MarkupHelper.createLabel("Total Number of values  in Excel=" + numberrows, ExtentColor.GREEN));

		// get all jsonnames from the excel
		ArrayList<String> a1 = new ArrayList<String>();
		for (int i = 2; i <= numberrows; i++) {
			String data = commonexcelcat.getdata(filepath, Excelsheetname, i, 0);
			a1.add(data);
		}

		mainTest.log(Status.INFO, MarkupHelper.createLabel("All jsonnames in Excel=" + a1, ExtentColor.GREEN));

		// get all languages object from the excel
		ArrayList<String> feature = new ArrayList<String>();
		for (int b = 2; b <= 14; b++) {
			String featuredata = commonexcelcat.getdata(filepath, Excelsheetname, 1, b);
			feature.add(featuredata);
		}

		// TreeSet<String> arraylist=new TreeSet<String>(feature);
		TreeSet<String> arraylist = new TreeSet<String>(feature);

		mainTest.log(Status.INFO,
				MarkupHelper.createLabel("All languages object in Excel=" + feature, ExtentColor.GREEN));

		// get all the values of particular language from excel

		ArrayList<String> execlvalues = new ArrayList<String>();
		for (int i = 2; i <= numberrows; i++) {

			// change language column number to test different language
			String data = commonexcelcat.getdata(filepath, Excelsheetname, i, lan_column_no);
			execlvalues.add(data);
		}

		mainTest.log(Status.INFO,
				MarkupHelper.createLabel("All Excel Values of Selected Language=" + execlvalues, ExtentColor.GREEN));

		mainTest.log(Status.INFO,
				MarkupHelper.createLabel(
						"-------------------JSON  language  and JSON VALUE Mentioned Below------------------",
						ExtentColor.BLUE));

		
		String arrayName = langobj;

		demo: for (int j = 0; j < a1.size(); j++) {

			String jsonFilePath = "./Data/" + a1.get(j);

			//System.out.println(jsonFilePath);

			try {
			
				ObjectMapper objectMapper = new ObjectMapper();
				JsonNode rootNode = objectMapper.readTree(new File(jsonFilePath));

			
				if (rootNode.has(arrayName) && rootNode.get(arrayName).isArray()) {
					
					JsonNode arrayNode = rootNode.get(arrayName);
					for (JsonNode element : arrayNode) {
						if (element.isTextual() && element.asText().equals(execlvalues.get(j))) {
							mainTest.log(Status.INFO,
									MarkupHelper.createLabel(
											"Excelvalue=" + "{" + execlvalues.get(j) + "}" + "LanguageArray=" + "{"
													+ langobj + "}" + "JSONFile=" + "{" + a1.get(j) + "}",
											ExtentColor.GREEN));
							continue demo;
						}
					}
					mainTest.log(Status.INFO, MarkupHelper.createLabel(
							"Excelvalue=" + "{" + execlvalues.get(j) + "}" + "LanguageArray=" + "{" + langobj + "}"
									+ "JSONFile=" + "{" + a1.get(j) + "}" + " Excel value not found in array",
							ExtentColor.RED));
					//Assert.fail("Excel value not found in array");
				}

				else {
					mainTest.log(Status.INFO, MarkupHelper.createLabel(
							"Excelvalue=" + "{" + execlvalues.get(j) + "}" + "LanguageArray=" + "{" + langobj + "}"
									+ "JSONFile=" + "{" + a1.get(j) + "}" + "Array  not found in the JSON file.",
							ExtentColor.RED));
					//Assert.fail("Array  not found in the JSON file.");
				}
			} catch (IOException e) {
				mainTest.log(Status.INFO,
						MarkupHelper.createLabel(
								"Excelvalue=" + "{" + execlvalues.get(j) + "}" + "LanguageArray=" + "{" + langobj + "}"
										+ "JSONFile=" + "{" + a1.get(j) + "}" + "Error reading JSON file:",
								ExtentColor.RED));
				
				
				//Assert.fail("Error reading JSON file:");
			}
		}
	}
}