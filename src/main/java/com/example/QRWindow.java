package com.example;

import javax.swing.*;
import java.awt.*;
import java.nio.file.Paths;

public class QRWindow {
    private JFrame frame;
    private JTextField input;
    private JLabel preview;
    private JButton createButton;
    private volatile boolean successFlag = false;

    public void start() {
        frame = new JFrame("QR Generator");
        frame.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        frame.setLayout(new BorderLayout());

        input = new JTextField();
        createButton = new JButton("Create");
        preview = new JLabel("Preview area", SwingConstants.CENTER);

        createButton.addActionListener(e -> {
            boolean ok = new QRGenerator().generateToFile(
                input.getText(), 300, Paths.get("src/Temp/qr_out.png"));
            successFlag = ok;
            preview.setText(ok ? "Created: src/Temp/qr_out.png" : "Failed");
        });

        JPanel top = new JPanel(new BorderLayout());
        top.add(new JLabel("Text/URL: "), BorderLayout.WEST);
        top.add(input, BorderLayout.CENTER);
        top.add(createButton, BorderLayout.EAST);

        frame.add(top, BorderLayout.NORTH);
        frame.add(preview, BorderLayout.CENTER);

        frame.setSize(480, 200);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    public JFrame getMainFrame() { return frame; }
    public JTextField getTextField() { return input; }
    public JButton getCreateButton() { return createButton; }
    public JLabel getPreviewLabel() { return preview; }
    public boolean isSuccessFlag() { return successFlag; }
}