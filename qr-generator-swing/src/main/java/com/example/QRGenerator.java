package com.example;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.MultiFormatWriter;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;
import java.nio.file.Path;

public class QRGenerator {
    public boolean generateToFile(String text, int size, Path out) {
        try {
            if (text == null || text.trim().isEmpty()) return false;
            if (size <= 0) return false;
            BitMatrix m = new MultiFormatWriter().encode(text, BarcodeFormat.QR_CODE, size, size);
            MatrixToImageWriter.writeToPath(m, "png", out);
            return true;
        } catch (Exception e) {
            System.err.println("QR generation failed: " + e.getMessage());
            return false;
        }
    }
}