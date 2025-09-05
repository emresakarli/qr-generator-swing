package com.example;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class QRWindowTest {
    @Test
    void startShouldOpenGuiWithoutException() {
        assertDoesNotThrow(() -> {
            QRWindow w = new QRWindow();
            w.start();
            w.getMainFrame().dispose();
        });
    }

    @Test
    void gettersShouldNotReturnNullAfterStart() {
        QRWindow w = new QRWindow();
        w.start();
        assertNotNull(w.getMainFrame());
        assertNotNull(w.getTextField());
        assertNotNull(w.getCreateButton());
        assertNotNull(w.getPreviewLabel());
        w.getMainFrame().dispose();
    }
}