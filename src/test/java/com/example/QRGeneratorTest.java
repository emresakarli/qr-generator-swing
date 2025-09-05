package com.example;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.nio.file.*;

public class QRGeneratorTest {
    @Test
    void shouldGenerateQrForValidText() throws Exception {
        QRGenerator gen = new QRGenerator();
        Path out = Paths.get("src/Temp/qr_unit_valid.png");
        Files.createDirectories(out.getParent());
        boolean ok = gen.generateToFile("Hello", 300, out);
        assertTrue(ok);
        assertTrue(Files.exists(out));
    }

    @Test
    void shouldFailForEmptyText() {
        boolean ok = new QRGenerator().generateToFile("   ", 300, Paths.get("src/Temp/qr_unit_empty.png"));
        assertFalse(ok);
    }

    @Test
    void shouldFailForInvalidSize() {
        boolean ok = new QRGenerator().generateToFile("Hello", 0, Paths.get("src/Temp/qr_unit_size.png"));
        assertFalse(ok);
    }
}