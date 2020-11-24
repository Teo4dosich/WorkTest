package bol.alex;

import javax.swing.*;
import java.awt.*;

public class PanelTabbedPane extends JPanel implements PanelTabbedPaneConstants{

    public PanelTabbedPane(){

        this.setLayout(null);

        TabControl tabControl = new TabControl();
        this.add(tabControl);

        JLabel comPortLabel = new JLabel(comPortLabelValue);
        comPortLabel.setBounds(comPortLabelLocationX, comPortLabelLocationY, comPortLabelSizeWidth, comPortLabelSizeHeight);
        this.add(comPortLabel);

        JComboBox comboBoxCOMPort = new JComboBox();
        comboBoxCOMPort.setBounds(comboBoxCOMPortLocationX,comboBoxCOMPortLocationY,comboBoxCOMPortSizeWidth,comboBoxCOMPortSizeHeight);
        comboBoxCOMPort.setBackground(Color.white);
        comboBoxCOMPort.setEditable(true);
        this.add(comboBoxCOMPort);

        JButton buttonCOMPort = new JButton(buttonCOMPortValue);
        buttonCOMPort.setBounds(buttonCOMPortLocationX,buttonCOMPortLocationY,buttonCOMPortSizeWidth,buttonCOMPortSizeHeight);
        buttonCOMPort.setBackground(Color.lightGray);
        this.add(buttonCOMPort);


    }
}
