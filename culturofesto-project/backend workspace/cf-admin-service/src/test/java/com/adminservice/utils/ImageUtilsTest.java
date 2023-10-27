package com.adminservice.utils;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.UnsupportedEncodingException;

import org.junit.jupiter.api.Test;

class ImageUtilsTest {

    @Test
    void testCompressImage() throws UnsupportedEncodingException {
        assertEquals(12, ImageUtils.compressImage("AXAXAXAX".getBytes("UTF-8")).length);
    }

    @Test
    void testDecompressImage() throws UnsupportedEncodingException {
        assertEquals(0, ImageUtils.decompressImage("AXAXAXAX".getBytes("UTF-8")).length);
    }

    @Test
    void testEncodeImageToBase64() throws UnsupportedEncodingException {
        assertEquals("QVhBWEFYQVg=", ImageUtils.encodeImageToBase64("AXAXAXAX".getBytes("UTF-8")));
    }
}

