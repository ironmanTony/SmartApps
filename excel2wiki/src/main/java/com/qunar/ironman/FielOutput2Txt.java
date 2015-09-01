package com.qunar.ironman;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.Writer;

/**
 * Created by ironman.li on 2015/8/18.
 */
public class FielOutput2Txt implements DataOutPut {
    String fileName;

    public FielOutput2Txt(String fileName) {
        this.fileName = fileName;
    }

    @Override
    public OutputStream getOutPutStream() throws IOException {
        if (fileName == null || fileName.length() < 1) {
            return null;
        }
        File file = new File(fileName);
        if (!file.exists()) {
            file.createNewFile();
        }
        return new FileOutputStream(file);
    }
}
