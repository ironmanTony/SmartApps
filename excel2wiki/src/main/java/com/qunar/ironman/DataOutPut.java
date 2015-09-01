package com.qunar.ironman;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.OutputStream;
import java.io.Writer;

/**
 * Created by ironman.li on 2015/8/18.
 */
public interface DataOutPut {
    public OutputStream getOutPutStream() throws IOException;
}
