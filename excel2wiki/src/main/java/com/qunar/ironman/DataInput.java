package com.qunar.ironman;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.InputStream;

/**
 * Created by ironman.li on 2015/8/18.
 */
public interface DataInput {
    public InputStream getInputStream() throws FileNotFoundException;
}
