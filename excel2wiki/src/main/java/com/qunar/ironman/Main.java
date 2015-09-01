package com.qunar.ironman;

import java.io.File;
import java.io.IOException;

public class Main {

    public static void main(String[] args) {
//        Reader reader =  new Reader("test1.txt");
//        reader.reade("C:\\Users\\ironman.li\\Desktop\\QOnclickListener&UELog_new\\UELog.xls");
//        reader.close();
        handle5();
    }

    public static void  handle5(){
        String file = "C:\\Users\\ironman.li\\Desktop\\uelog.txt";
        String file_click = "C:\\Users\\ironman.li\\Desktop\\click.txt";
        String out = "C:\\Users\\ironman.li\\Desktop\\uelog_out.txt";
        String out_click = "C:\\Users\\ironman.li\\Desktop\\click_out.txt";
        DataInput input = new FielInputFromTxt(file);
//        DataInput inputClick = new FielInputFromTxt(file_click);
        DataOutPut output = new FielOutput2Txt(out);
//        DataOutPut outputClick = new FielOutput2Txt(out_click);
        HandleWithByteStream handler = new Get5thColumHandler(input, output, 11);
//        HandleData handlerClick = new Get5thColumHandler(inputClick, outputClick, 7);

        try {
            handler.execute();
//            handlerClick.execute();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
