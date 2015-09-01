package com.qunar.ironman;

import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Iterator;

/**
 * Created by ironman.li on 2015/7/20.
 */
@Deprecated
public class Reader {

    private StringBuilder sb = new StringBuilder();
    private File outPut;
    private FileWriter fileWriter;

    public Reader(String fileName) {
        try {
            this.fileWriter = new FileWriter(fileName);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void reade(String fileName){
        FileInputStream file = null;
        HSSFWorkbook workbook = null;
        try {
            file = new FileInputStream(new File(fileName));
//Get the workbook instance for XLS file
            workbook = new HSSFWorkbook(file);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e){
            e.printStackTrace();
        }


//Get first sheet from the workbook
        if(workbook!=null){
            HSSFSheet sheet = workbook.getSheetAt(0);
            Iterator<Row> rowIterator = sheet.iterator();
            Row row;
            while(rowIterator.hasNext()){
                row = rowIterator.next();
                sb.delete(0, sb.length());
                sb.append("|");
                for(int  i = 0; i < row.getLastCellNum() ; i++){
                    Cell cell = row.getCell(i);
                    if(cell == null){
                        sb.append(" ");
                    }else{
                        int type = cell.getCellType();
                        if(type == Cell.CELL_TYPE_STRING){
                            String str = cell.getStringCellValue();
                            sb.append(str);
                        }else if(type == Cell.CELL_TYPE_NUMERIC){
                            sb.append((int)cell.getNumericCellValue());
                        }else{
                            sb.append(" ");
                        }
                    }
                    sb.append("|");
                }
                /*Iterator<Cell> cellIterator = row.iterator();
                while(cellIterator.hasNext()){
                    Cell cell = cellIterator.next();
                    int type = cell.getCellType();
                    if(type == Cell.CELL_TYPE_STRING){
                        String str = cell.getStringCellValue();
                        sb.append(str);
                    }else if(type == Cell.CELL_TYPE_NUMERIC){
                        sb.append((int)cell.getNumericCellValue());
                    }else{
                        sb.append(" ");
                    }
                    sb.append("|");
                }*/
                sb.append("\n");
                write2Text(sb.toString());
            }
            try {
                workbook.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }

    private void write2Text(String s) {
        if(fileWriter!=null){
            try {
                fileWriter.write(s);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }

    public void close(){
        if(fileWriter!=null){
            try {
                fileWriter.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }


}
