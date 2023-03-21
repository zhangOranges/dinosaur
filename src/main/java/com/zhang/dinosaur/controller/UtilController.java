package com.zhang.dinosaur.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.BitSet;

/**
 * utility class
 */
@RestController
@RequestMapping("util")
@Slf4j
public class UtilController {

    /**
     * Sets the bits from the specified {@code fromIndex} (inclusive) to the
     * specified {@code toIndex} (exclusive) to the specified value
     * @param bytes
     * @param fromIndex
     * @param toIndex
     * @param value
     * @return long[]
     */
    @PostMapping("bitSet")
    public long[] bitSet(byte[] bytes,int fromIndex, int toIndex, boolean value){
        BitSet bitSet = BitSet.valueOf(bytes);
        bitSet.set(fromIndex,toIndex,value);
        long[] array = bitSet.toLongArray();
        String s = bitSet.toString();
        log.info("return true bit indexs = {}",s);
        return array;
    }
}
