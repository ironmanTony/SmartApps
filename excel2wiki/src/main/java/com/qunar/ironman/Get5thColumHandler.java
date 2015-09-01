package com.qunar.ironman;

import java.io.*;

/**
 * Created by ironman.li on 2015/8/18.
 */
public class Get5thColumHandler extends HandleWithByteStream {

    private int index;

    public Get5thColumHandler(DataInput dataInput, DataOutPut dataOutPut, int index) {
        super(dataInput, dataOutPut);
        this.index = index;
    }

    @Override
    public void handleData(InputStream inputStream, OutputStream outputStream) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream, "utf-8"));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(outputStream, "utf-8"));
        String line;
        String oneResult;
        while ((line = reader.readLine()) != null) {
            String[] coloms = line.split("\\|");
            if(coloms.length > index){
                oneResult = coloms[index];
                writer.write(oneResult, 0, oneResult.length());
                writer.newLine();
            }
        }
        writer.flush();
    }


}
