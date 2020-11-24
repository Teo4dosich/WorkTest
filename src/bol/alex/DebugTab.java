package bol.alex;

import javax.swing.*;
import javax.swing.filechooser.FileFilter;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class DebugTab extends JPanel implements DebugTabConstants{

    public DebugTab(){
        this.setLayout(null);
        this.setBackground(Color.white);

        JLabel outputFromDeviceLabel = new JLabel(outputFromDeviceLabelTitle);
        outputFromDeviceLabel.setBounds(outputFromDeviceLabelLocationX,outputFromDeviceLabelLocationY,outputFromDeviceLabelSizeWidth,outputFromDeviceLabelSizeHeight);
        this.add(outputFromDeviceLabel);

        JLabel inputInDeviceLabel = new JLabel(inputInDeviceLabelTitle);
        inputInDeviceLabel.setBounds(inputInDeviceLabelLocationX,inputInDeviceLabelLocationY,inputInDeviceLabelSizeWidth,inputInDeviceLabelSizeHeight);
        this.add(inputInDeviceLabel);

        JButton saveButton = new JButton(saveButtonTitle);
        saveButton.setBounds(saveButtonLocationX, saveButtonLocationY, saveButtonSizeWidth,saveButtonSizeHeight);
        this.add(saveButton);

        JButton cleanButton = new JButton(cleanButtonTitle);
        cleanButton.setBounds(cleanButtonLocationX, cleanButtonLocationY, cleanButtonSizeWidth,cleanButtonSizeHeight);
        this.add(cleanButton);

        JButton sendButton = new JButton(sendButtonTitle);
        sendButton.setBounds(sendButtonLocationX, sendButtonLocationY, sendButtonSizeWidth,sendButtonSizeHeight);
        this.add(sendButton);

        JTextArea jTextAreaOutputInformation = new JTextArea();
        jTextAreaOutputInformation.setBounds(jTextAreaOutputInformationLocationX,jTextAreaOutputInformationLocationY,jTextAreaOutputInformationSizeWidth,jTextAreaOutputInformationSizeHeight);
        jTextAreaOutputInformation.setEditable(false);
        this.add(jTextAreaOutputInformation);

        JScrollPane jScrollPane = new JScrollPane(jTextAreaOutputInformation);
        jScrollPane.setBounds(jScrollPaneLocationX,jScrollPaneLocationY,jScrollPaneSizeWidth,jScrollPaneSizeHeight);
        this.add(jScrollPane);

        JTextField jTextFieldInputInformation = new JTextField();
        jTextFieldInputInformation.setBounds(jTextFieldInputInformationLocationX,jTextFieldInputInformationLocationY,jTextFieldInputInformationSizeWidth,jTextFieldInputInformationSizeHeight);
        this.add(jTextFieldInputInformation);
        jTextFieldInputInformation.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {

            }

            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                    String str = jTextFieldInputInformation.getText();
                    jTextAreaOutputInformation.append(str + "\r\n");
                    jTextFieldInputInformation.selectAll();
                    jTextFieldInputInformation.replaceSelection("");
                }
            }

            @Override
            public void keyReleased(KeyEvent e) {

            }
        });

        cleanButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                jTextAreaOutputInformation.selectAll();
                jTextAreaOutputInformation.replaceSelection("");
            }
        });
        sendButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String str = jTextFieldInputInformation.getText();
                jTextAreaOutputInformation.append(str + "\r\n");
                jTextFieldInputInformation.selectAll();
                jTextFieldInputInformation.replaceSelection("");
            }
        });
        saveButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFileChooser fileChooser = new JFileChooser();
                fileChooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
                fileChooser.setFileFilter(new FileFilter() {
                    @Override
                    public boolean accept(File f) {
                        if (f.getName().endsWith("txt")) return true;
                        else return false;
                    }

                    @Override
                    public String getDescription() {
                        return "Текстовые файлы";
                    }
                });
                fileChooser.showSaveDialog(null);
                File saveFile = fileChooser.getSelectedFile();
                if (saveFile != null){
                    try {
                        FileWriter fw = new FileWriter(saveFile.getPath());
                        jTextAreaOutputInformation.write(fw);
                    } catch (IOException ioException) {
                        ioException.printStackTrace();
                    }
                }
            }
        });
    }
}
