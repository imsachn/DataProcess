package com.data;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;


public class Reader {

  private static final String CSV_FILENAME = "events.tsv";
  private static final String timeFormat = "yyyy-MM-dd HH:mm:ss";

  public static List<RecordBean> readDataLineByLine() {
    List<RecordBean> RecordBeans = new ArrayList<>();
    String line = "";
    String cvsSplitBy = "\t";
    FileReader fileReader = null;
    BufferedReader br = null;
    try {
      fileReader = new FileReader(CSV_FILENAME);
      br = new BufferedReader(fileReader);
      int count = 0;
      line = br.readLine();
      while ((line = br.readLine()) != null && count < 5000) {
        String[] csvReader = line.split(cvsSplitBy);
        RecordBean recordBean = new RecordBean(csvReader[0],
                LocalDateTime.parse(csvReader[1], DateTimeFormatter.ofPattern(timeFormat)),
                csvReader[2], LocalDate.parse(csvReader[3], DateTimeFormatter.ofPattern("yyyy-MM-dd")),
                csvReader[4], csvReader[5], csvReader[6], csvReader[7], Integer.parseInt(csvReader[8]),
                LocalDateTime.parse(csvReader[9], DateTimeFormatter.ofPattern(timeFormat)),
                LocalDateTime.parse(csvReader[10], DateTimeFormatter.ofPattern(timeFormat)),
                csvReader[11], Integer.parseInt(csvReader[12]));
        RecordBeans.add(recordBean);
        count++;
      }

    } catch (FileNotFoundException e) {
      System.err.println("file not found: " + e.getMessage());
      System.exit(0);
    } catch (IOException e) {
      System.err.println("file not a valid csv file: " + e.getMessage());
    } catch (Exception e) {
      System.err.println("Invalid Data: " + e.getMessage());
    } finally {
      if (null != fileReader) {
        try {
          fileReader.close();
        } catch (IOException e) {
          System.err.println("file not close: " + e.getMessage());
        }
      }
      if (null != br) {
        try {
          br.close();
        } catch (IOException e) {
          System.err.println("file not close: " + e.getMessage());
        }
      }
    }
    return RecordBeans;
  }
}