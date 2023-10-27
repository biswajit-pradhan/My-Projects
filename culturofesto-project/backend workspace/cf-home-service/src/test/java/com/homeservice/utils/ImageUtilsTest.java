package com.homeservice.utils;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.UnsupportedEncodingException;

import org.junit.jupiter.api.Test;

class ImageUtilsTest {
    /**
     * Method under test: {@link ImageUtils#compressImage(byte[])}
     */
    @Test
    void testCompressImage() throws UnsupportedEncodingException {
        assertEquals(12, ImageUtils.compressImage("AXAXAXAX".getBytes("UTF-8")).length);
    }

    /**
     * Method under test: {@link ImageUtils#decompressImage(byte[])}
     */
    @Test
    void testDecompressImage() throws UnsupportedEncodingException {
        assertEquals(0, ImageUtils.decompressImage("AXAXAXAX".getBytes("UTF-8")).length);
    }

    /**
     * Method under test: {@link ImageUtils#encodeImageToBase64(byte[])}
     */
    @Test
    void testEncodeImageToBase64() throws UnsupportedEncodingException {
        assertEquals("QVhBWEFYQVg=", ImageUtils.encodeImageToBase64("AXAXAXAX".getBytes("UTF-8")));
    }
}

