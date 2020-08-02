package com.edu.test;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.edu.MySpringBootApplication;
import com.edu.domain.Population;
import com.edu.repository.PopulationDAO;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = MySpringBootApplication.class)
public class ExcelTest {

	private static final String fileName = "C:\\Users\\user\\Downloads\\2020-a.xls";

	@Autowired
	private PopulationDAO populationDAO;

	@Test
	public void readExcel() throws IOException {

		List<Population> list = new ArrayList<Population>();

		try (HSSFWorkbook wb = readFile(fileName)) {
			HSSFSheet sheet = wb.getSheetAt(0);
			// int rows = sheet.getPhysicalNumberOfRows();
			for (int r = 10; r < 200; r++) {// rows 1973
				HSSFRow row = sheet.getRow(r);
				if (row == null) {
					continue;
				}

				String id = row.getCell(7).getStringCellValue();
				String city = row.getCell(8).getStringCellValue();
				String municipalities = row.getCell(9).getStringCellValue();
				System.out.println(id);
				Population p = new Population(Integer.valueOf(id.trim()), city.trim(), municipalities.trim());
				// 把其余的数字统一处理了
				processNumeric(p, row);
				list.add(p);
			}
		}
		populationDAO.saveAll(list);
	}

	private void processNumeric(Population p, HSSFRow row) {
		long[] numbers = new long[20];
		for (int c = 10; c < 30; c++) {// row.getLastCellNum()
			HSSFCell cell = row.getCell(c);
			if (cell != null) {
				switch (cell.getCellType()) {
				case NUMERIC:
					Double d = new Double(cell.getNumericCellValue());
					numbers[c - 10] = d.longValue();
					break;
				default:
					// 表中有些value=... 处理一下
					numbers[c - 10] = -1L;
				}
			}
		}
		p.setNumbers(numbers);
	}

	private static HSSFWorkbook readFile(String filename) throws IOException {
		try (FileInputStream fis = new FileInputStream(filename)) {
			return new HSSFWorkbook(fis); // NOSONAR - should not be closed here
		}
	}

	public static void main(String args[]) throws IOException {

		try (HSSFWorkbook wb = readFile(fileName)) {
			System.out.println("Data dump:\n");
			// 如果有多个表格的话：int k = 0; k < wb.getNumberOfSheets(); k++
			HSSFSheet sheet = wb.getSheetAt(0);
			int rows = sheet.getPhysicalNumberOfRows();
			System.out.println(rows + " row(s).");
			for (int r = 29; r < 30; r++) {// rows
				HSSFRow row = sheet.getRow(r);
				if (row == null) {
					continue;
				}

				System.out.println("\nROW " + row.getRowNum() + " has " + row.getPhysicalNumberOfCells() + " cell(s).");

				for (int c = 7; c < 30; c++) {// row.getLastCellNum()
					HSSFCell cell = row.getCell(c);
					String value;
					if (cell != null) {
						switch (cell.getCellType()) {

						case FORMULA:
							value = "FORMULA value=" + cell.getCellFormula();
							break;

						case NUMERIC:
							value = "NUMERIC value=" + cell.getNumericCellValue();
							break;

						case STRING:
							value = "STRING value=" + cell.getStringCellValue();
							break;

						case BLANK:
							value = "<BLANK>";
							break;

						case BOOLEAN:
							value = "BOOLEAN value-" + cell.getBooleanCellValue();
							break;

						case ERROR:
							value = "ERROR value=" + cell.getErrorCellValue();
							break;

						default:
							value = "UNKNOWN value of type " + cell.getCellType();
						}
						System.out.println("CELL col=" + cell.getColumnIndex() + " VALUE=" + value);
					}
				}
				// 伪代码 参考用
				// Population p = new Population();
				// p.setId(Integer.valueof(row.getCell(7).getStringCellValue()))
				// p.setCity(row.getCell(8).getStringCellValue())
				// ...
				// list.add(p)
				// populationDAO.saveall(list)
			}
		}
	}
}
