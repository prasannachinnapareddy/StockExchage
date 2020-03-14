package com.cts.training.stockpriceservice;

import java.io.IOException;
import java.io.InputStream;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.ZoneId;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import ch.qos.logback.core.rolling.helper.PeriodicityType;
@Service
public class StockPriceServiceImp implements StockPriceService
{
	@Autowired
	StockPriceDAO stockPriceDAO;
	@Autowired
	StockPriceService stockPriceService;

	@Override
	public StockPrice insert(StockPrice stockPrice) 
	{
		stockPriceDAO.save(stockPrice);
		return stockPrice;
	}

	@Override
	public void delete(int id) 
	{
		stockPriceDAO.deleteById(id);
	}

	@Override
	public StockPrice updateStockPrice(StockPrice stockPrice)
	{
		stockPriceDAO.save(stockPrice);
		return stockPrice;
	}

	@Override
	public List<StockPrice> getAllStockPrices() 
	{
		return stockPriceDAO.findAll();
	}

	@Override
	public StockPrice getStockPriceById(int id) {
		Optional<StockPrice> stockPrice=stockPriceDAO.findById(id);
		return stockPrice.orElse(null);
	}

	@Override
	public ImportSummary addStockPriceformExcelSheet(MultipartFile file) throws IOException, Exception 
	{
			InputStream in = file.getInputStream();
			int currentRowNum = 1;
			int currentCellNum = 0;
			LocalDate startDate = LocalDate.MAX;
			LocalDate endDate = LocalDate.MIN;
			List<String> duplicates = new ArrayList<String>();
			List<StockPrice> stockPrices = new ArrayList<StockPrice>();
			Set<String> companyCodes = new HashSet<String>();
			Set<String> stockExchanges = new HashSet<String>();
			if (file.getOriginalFilename().endsWith(".xls")) {
				try (HSSFWorkbook workbook = new HSSFWorkbook(in)) {
					HSSFSheet stockPricesSheet = workbook.getSheetAt(0);
					HSSFRow row = stockPricesSheet.getRow(currentRowNum);
					while (row != null && row.getCell(0) != null) {
						String companyCode = row.getCell(currentCellNum++).getStringCellValue().trim();
						String stockExchangeName = row.getCell(currentCellNum++).getStringCellValue().trim();
						double currentPrice = (double) row.getCell(currentCellNum++).getNumericCellValue();
						companyCodes.add(companyCode);
						stockExchanges.add(stockExchangeName);
						LocalDate date = row.getCell(currentCellNum++).getDateCellValue().toInstant()
								.atZone(ZoneId.of("+05:30")).toLocalDate();
						startDate = date.isBefore(startDate) ? date : startDate;
						endDate = date.isAfter(endDate) ? date : endDate;
						LocalTime time = row.getCell(currentCellNum++).getDateCellValue().toInstant()
								.atZone(ZoneId.of("+05:30")).toLocalTime();
						if (!stockPriceDAO.getIfAlreadyExists(companyCode, stockExchangeName,date, time).isPresent()) {
							StockPrice stockPrice1 = new StockPrice(0,companyCode, stockExchangeName,
									currentPrice, date, time);
							stockPrices.add(stockPrice1);
						} else {
							duplicates.add("The record at row " + (currentRowNum + 1) + " is duplicate.");
						}
						row = stockPricesSheet.getRow(++currentRowNum);
						currentCellNum = 0;
					}
				} catch (NullPointerException e) {
					throw new Exception("The file has some missing value at " + (currentRowNum + 1) + ":" + (currentCellNum)
							+ " (row:column). ");
				} catch (IllegalStateException e) {
					throw new Exception("The file has some wrong value at " + (currentRowNum + 1) + ":" + (currentCellNum)
							+ " (row:column). ");
				} catch (DateTimeParseException e) {
					throw new Exception("The file has wrong date/time format value at " + (currentRowNum + 1) + ":"
							+ (currentCellNum) + " (row:column). ");
				}
			} else if (file.getOriginalFilename().endsWith(".xlsx")) {
				try (XSSFWorkbook workbook = new XSSFWorkbook(in)) {
					XSSFSheet stockPricesSheet = workbook.getSheetAt(0);
					System.out.println(stockPricesSheet.getLastRowNum());
					XSSFRow row = stockPricesSheet.getRow(currentRowNum);
					while (row != null && row.getCell(0) != null) {
						String companyCode = row.getCell(currentCellNum++).getStringCellValue().trim();
						companyCode = companyCode.trim();
						String stockExchangeName = row.getCell(currentCellNum++).getStringCellValue().trim();
						double currentPrice = (double) row.getCell(currentCellNum++).getNumericCellValue();
						companyCodes.add(companyCode);
						stockExchanges.add(stockExchangeName);
						LocalDate date = row.getCell(currentCellNum++).getDateCellValue().toInstant()
								.atZone(ZoneId.of("+05:30")).toLocalDate();
						startDate = date.isBefore(startDate) ? date : startDate;
						endDate = date.isAfter(endDate) ? date : endDate;
						LocalTime time = row.getCell(currentCellNum++).getDateCellValue().toInstant()
								.atZone(ZoneId.of("+05:30")).toLocalTime();
						if (!stockPriceDAO.getIfAlreadyExists(companyCode, stockExchangeName, date, time).isPresent()) {
							StockPrice stockPrice1 = new StockPrice(0,companyCode,stockExchangeName,currentPrice,date, time);
							stockPrices.add(stockPrice1);
						} else {
							duplicates.add("The record at row " + (currentRowNum + 1) + " is duplicate.");
						}
						row = stockPricesSheet.getRow(++currentRowNum);
						currentCellNum = 0;
					}
				} catch (NullPointerException e) {
					throw new Exception("The file has some missing value at " + (currentRowNum + 1) + ":" + (currentCellNum)
							+ " (row:column). ");
				} catch (IllegalStateException e) {
					throw new Exception("The file has some wrong value at " + (currentRowNum + 1) + ":" + (currentCellNum)
							+ " (row:column). ");
				} catch (DateTimeParseException e) {
					throw new Exception("The file has wrong date/time format value at " + (currentRowNum + 1) + ":"
							+ (currentCellNum) + " (row:column). ");
				}
			}
			stockPriceDAO.saveAll(stockPrices);
			return new ImportSummary(stockPrices.size(), startDate, endDate, companyCodes, stockExchanges,
					duplicates);
	}
	
	@Override
	public List<Charts> getCompanyStockPriceBetween(String companyCode,String stockExchangeName,LocalDate startDate,LocalDate endDate)
	{
		
		return stockPriceDAO.getStockPriceBetweenDates(companyCode, stockExchangeName, startDate, endDate);
		
	}

}