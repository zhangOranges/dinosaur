package com.zhang.dinosaur.common;

import java.io.OutputStream;
import java.io.PrintStream;

/**
 * 实现网络打印 继承PrintStream类来做
 */
public class NetPrintStream extends PrintStream {
    public NetPrintStream(OutputStream out) {
        super(out);
    }
}
