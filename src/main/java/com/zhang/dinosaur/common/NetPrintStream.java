package com.zhang.dinosaur.common;

import java.io.OutputStream;
import java.io.PrintStream;

/**
 * implements net print extend PrintStream  do it
 */
public class NetPrintStream extends PrintStream {
    public NetPrintStream(OutputStream out) {
        super(out);
    }
}
