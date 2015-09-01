package com.qunar.ironman;

import java.io.*;

/**
 * Created by ironman.li on 2015/8/18.
 */
public class FielInputFromTxt implements DataInput {

    private String fileName;

    public FielInputFromTxt(String fileName) {
        this.fileName = fileName;
    }

    @Override
    public InputStream getInputStream() throws FileNotFoundException {
        if (fileName != null && fileName.length() > 0) {
            File file = new File(fileName);
            if (!file.exists()) {
                throw new FileNotFoundException(fileName);
            }
            return new FileInputStream(file);
        }
        return null;
    }

}
