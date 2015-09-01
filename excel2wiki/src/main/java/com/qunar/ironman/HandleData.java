package com.qunar.ironman;

import java.io.*;
import java.io.Reader;

/**
 * Created by ironman.li on 2015/8/18.
 */
public interface HandleData <In, Out>{

    public void beforHandle();
    public void handleData(In in, Out out) throws IOException;
    public void afterHandle();
}
