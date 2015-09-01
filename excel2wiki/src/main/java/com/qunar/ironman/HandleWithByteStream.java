package com.qunar.ironman;

import java.io.*;

/**
 * Created by ironman.li on 2015/8/19.
 */
public abstract class HandleWithByteStream implements HandleData<InputStream, OutputStream> , Executor{

    private DataInput dataInput;
    private DataOutPut dataOutPut;

    public HandleWithByteStream(DataInput dataInput, DataOutPut dataOutPut) {
        this.dataInput = dataInput;
        this.dataOutPut = dataOutPut;
    }

    @Override
    public void beforHandle() {

    }

    @Override
    public abstract void handleData(InputStream inputStream, OutputStream outputStream) throws IOException ;

    @Override
    public void afterHandle() {

    }

    @Override
    public void execute() throws IOException {
        beforHandle();
        if (dataInput != null && dataOutPut != null) {
            handleData(dataInput.getInputStream(), dataOutPut.getOutPutStream());
        }else {
            throw new NullPointerException("dataInput or dataOutput is null");
        }
        afterHandle();
    }
}
