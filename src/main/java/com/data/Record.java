package com.data;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;


public class Record {

	private static List<RecordBean> dataOfCSV = Reader.readDataLineByLine();




	public List<RecordBean> getListOfActiveUsersMostTimeSpent() {
		long start = System.nanoTime();
		List<RecordBean> records = new ArrayList<>();
		Collections.sort(dataOfCSV);
		int count = 0;
		for (RecordBean record: dataOfCSV) {
			if(records.size() <= 100){
				records.add(record);
				count++;
			}else{
				break;
			}
		}
		long end = System.nanoTime();
		long execution = end - start;
		System.out.println("execution time: " + execution);
		return records;
	}

	public List<RecordBean> getListOfTopViewPages() {
		long start = System.nanoTime();
		List<RecordBean> records = new ArrayList<>();
		dataOfCSV.stream().forEach(record -> {
			if ("view".equalsIgnoreCase(record.geteventAction())) {
				records.add(record);
			}
		});
		long end = System.nanoTime();
		long execution = end - start;
		return records;
	}
	public List<RecordBean> getListOfMostTimeSpent() {
		long start = System.nanoTime();
		List<RecordBean> records = new ArrayList<>();
		Comparator<RecordBean> comparator = Comparator.comparing(RecordBean::geteventValue);
		records.add(dataOfCSV.stream().max(comparator).get());
		long end = System.nanoTime();
		long execution = end - start;
		return records;
	}



	public List<RecordBean> getPagesViewedListBasedOnDate(LocalDate fromDate, LocalDate toDate) {
		long start = System.nanoTime();
		List<RecordBean> records = new ArrayList<>();
		dataOfCSV.stream().forEach(record -> {
			if (record.getDate().isAfter(fromDate) && record.getDate().isBefore(toDate)) {
				records.add(record);
			}
		});
		long end = System.nanoTime();
		long execution = end - start;
		System.out.println("execution time: " + execution);
		return records;
	}
}