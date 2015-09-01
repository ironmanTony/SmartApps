package com.qunar.ironman;

import java.io.*;
import java.io.Reader;

/**
 * Created by ironman.li on 2015/8/19.
 */
public abstract class HandleWithCharacterStream implements HandleData<java.io.Reader, Writer> ,Executor{

    private DataInputReader dataReader;
    private DataOutputWriter outputWriter;

    public HandleWithCharacterStream(DataInputReader dataReader, DataOutputWriter outputWriter) {
        this.dataReader = dataReader;
        this.outputWriter = outputWriter;
    }

    @Override
    public void beforHandle() {

    }

    @Override
    public abstract void handleData(Reader reader, Writer writer) throws IOException ;
    @Override
    public void afterHandle() {

    }

    @Override
    public void execute() throws IOException {
        beforHandle();
        if (dataReader != null && outputWriter != null) {
            handleData(dataReader.getReader(), outputWriter.getWriter());
        }else {
            throw new NullPointerException("dataReader or outputWriter is null");
        }
        afterHandle();
    }
}
