package bol.alex;

import javax.swing.*;
import java.awt.*;

public class InformationTab extends JPanel implements InformationTabConstants{

    Object[][] dat = new String[][]{{"0","1","2020"},
            {"1","0","2019"},
            {"2","0","2021"}};

    public InformationTab(){

        this.setLayout(null);
        this.setBackground(Color.white);

        JLabel stateOfInputsLabel = new JLabel(stateOfInputsLabelTitle);
        stateOfInputsLabel.setBounds(stateOfInputsLabelLocationX,stateOfInputsLabelLocationY,stateOfInputsLabelSizeWidth,stateOfInputsLabelSizeHeight);

        JTable stateOfInputsTable = new JTable(dat, columnHeading);
        stateOfInputsTable.getColumn(columnHeading[indexOfFirstColumn]).setMaxWidth(maxWidthOfFirstColumn);
        this.add(stateOfInputsLabel);

        JScrollPane jScrollPane = new JScrollPane(stateOfInputsTable);
        jScrollPane.setBounds(jScrollPaneLocationX,jScrollPaneLocationY,jScrollPaneSizeWidth,jScrollPaneSizeHeight);
        this.add(jScrollPane);

        JLabel serialNumberLabel = new JLabel(serialNumberLabelTitle);
        serialNumberLabel.setBounds(serialNumberLabelLocationX, serialNumberLabelLocationY, serialNumberLabelSizeWidth, serialNumberLabelSizeHeight);

        JLabel versionPOLabel = new JLabel(versionPOLabelTitle);
        versionPOLabel.setBounds(versionPOLabelLocationX, versionPOLabelLocationY, versionPOLabelSizeWidth, versionPOLabelSizeHeight);

        JTextField textFieldSerialNumber = new JTextField();
        textFieldSerialNumber.setBounds(textFieldSerialNumberLocationX, textFieldSerialNumberLocationY, textFieldSerialNumberSizeWidth, textFieldSerialNumberSizeHeight);
        textFieldSerialNumber.setEditable(false);
        textFieldSerialNumber.setBackground(Color.white);

        JTextField textFieldVersionPO = new JTextField();
        textFieldVersionPO.setBounds(textFieldVersionPOLocationX, textFieldVersionPOLocationY, textFieldVersionPOSizeWidth, textFieldVersionPOSizeHeight);
        textFieldVersionPO.setEditable(false);
        textFieldVersionPO.setBackground(Color.white);

        this.add(serialNumberLabel);
        this.add(versionPOLabel);
        this.add(textFieldSerialNumber);
        this.add(textFieldVersionPO);

        JPanel groupboxGSM = new JPanel();
        groupboxGSM.setBorder(BorderFactory.createTitledBorder(groupboxGSMTitle));
        groupboxGSM.setBounds(groupboxGSMLocationX,groupboxGSMLocationY,groupboxGSMSizeWidth,groupboxGSMSizeHeight);
        groupboxGSM.setBackground(Color.white);
        groupboxGSM.setLayout(null);

        JTextField textFieldCondition = new JTextField();
        textFieldCondition.setLocation(gsmTextBoxes[textFieldConditionIndexOfGSMTextBoxesPoint]);
        textFieldCondition.setSize(allTextFieldsInGroupSizeWidth, allTextFieldsInGroupSizeHeight);
        textFieldCondition.setEditable(false);
        textFieldCondition.setBackground(Color.white);

        JTextField textFieldSignalLevel = new JTextField();
        textFieldSignalLevel.setLocation(gsmTextBoxes[textFieldSignalLevelIndexOfGSMTextBoxesPoint]);
        textFieldSignalLevel.setSize(allTextFieldsInGroupSizeWidth, allTextFieldsInGroupSizeHeight);
        textFieldSignalLevel.setEditable(false);
        textFieldSignalLevel.setBackground(Color.white);

        JTextField textFieldGPRSSessionOpen = new JTextField();
        textFieldGPRSSessionOpen.setLocation(gsmTextBoxes[textFieldGPRSSessionOpenIndexOfGSMTextBoxesPoint]);
        textFieldGPRSSessionOpen.setSize(allTextFieldsInGroupSizeWidth, allTextFieldsInGroupSizeHeight);
        textFieldGPRSSessionOpen.setEditable(false);
        textFieldGPRSSessionOpen.setBackground(Color.white);

        JTextField textFieldIPAddressGPRS = new JTextField();
        textFieldIPAddressGPRS.setLocation(gsmTextBoxes[textFieldIPAddressGPRSIndexOfGSMTextBoxesPoint]);
        textFieldIPAddressGPRS.setSize(allTextFieldsInGroupSizeWidth, allTextFieldsInGroupSizeHeight);
        textFieldIPAddressGPRS.setEditable(false);
        textFieldIPAddressGPRS.setBackground(Color.white);

        groupboxGSM.add(textFieldCondition);
        groupboxGSM.add(textFieldSignalLevel);
        groupboxGSM.add(textFieldGPRSSessionOpen);
        groupboxGSM.add(textFieldIPAddressGPRS);
        this.add(groupboxGSM);

        JPanel groupboxEthernet = new JPanel();
        groupboxEthernet.setBorder(BorderFactory.createTitledBorder(groupboxEthernetTitle));
        groupboxEthernet.setBounds(groupboxEthernetLocationX,groupboxEthernetLocationY,groupboxEthernetSizeWidth,groupboxEthernetSizeHeight);
        groupboxEthernet.setBackground(Color.white);
        groupboxEthernet.setLayout(null);

        JTextField textFieldLink = new JTextField();
        textFieldLink.setLocation(ethernetTextBoxes[textFieldLinkIndexOfEthernetTextBoxesPoint]);
        textFieldLink.setSize(allTextFieldsInGroupSizeWidth, allTextFieldsInGroupSizeHeight);
        textFieldLink.setEditable(false);
        textFieldLink.setBackground(Color.white);

        JTextField textFieldMACAddress = new JTextField();
        textFieldMACAddress.setLocation(ethernetTextBoxes[textFieldMACAddressIndexOfEthernetTextBoxesPoint]);
        textFieldMACAddress.setSize(allTextFieldsInGroupSizeWidth, allTextFieldsInGroupSizeHeight);
        textFieldMACAddress.setEditable(false);
        textFieldMACAddress.setBackground(Color.white);

        JTextField textFieldIPAddress = new JTextField();
        textFieldIPAddress.setLocation(ethernetTextBoxes[textFieldIPAddressIndexOfEthernetTextBoxesPoint]);
        textFieldIPAddress.setSize(allTextFieldsInGroupSizeWidth, allTextFieldsInGroupSizeHeight);
        textFieldIPAddress.setEditable(false);
        textFieldIPAddress.setBackground(Color.white);

        JTextField textFieldNetmask = new JTextField();
        textFieldNetmask.setLocation(ethernetTextBoxes[textFieldNetmaskIndexOfEthernetTextBoxesPoint]);
        textFieldNetmask.setSize(allTextFieldsInGroupSizeWidth, allTextFieldsInGroupSizeHeight);
        textFieldNetmask.setEditable(false);
        textFieldNetmask.setBackground(Color.white);

        JTextField textFieldGateway = new JTextField();
        textFieldGateway.setLocation(ethernetTextBoxes[textFieldGatewayIndexOfEthernetTextBoxesPoint]);
        textFieldGateway.setSize(allTextFieldsInGroupSizeWidth, allTextFieldsInGroupSizeHeight);
        textFieldGateway.setEditable(false);
        textFieldGateway.setBackground(Color.white);

        JTextField textFieldDNS1 = new JTextField();
        textFieldDNS1.setLocation(ethernetTextBoxes[textFieldDNS1IndexOfEthernetTextBoxesPoint]);
        textFieldDNS1.setSize(allTextFieldsInGroupSizeWidth, allTextFieldsInGroupSizeHeight);
        textFieldDNS1.setEditable(false);
        textFieldDNS1.setBackground(Color.white);

        JTextField textFieldDNS2 = new JTextField();
        textFieldDNS2.setLocation(ethernetTextBoxes[textFieldDNS2IndexOfEthernetTextBoxesPoint]);
        textFieldDNS2.setSize(allTextFieldsInGroupSizeWidth, allTextFieldsInGroupSizeHeight);
        textFieldDNS2.setEditable(false);
        textFieldDNS2.setBackground(Color.white);

        groupboxEthernet.add(textFieldLink);
        groupboxEthernet.add(textFieldMACAddress);
        groupboxEthernet.add(textFieldIPAddress);
        groupboxEthernet.add(textFieldNetmask);
        groupboxEthernet.add(textFieldGateway);
        groupboxEthernet.add(textFieldDNS1);
        groupboxEthernet.add(textFieldDNS2);

        this.add(groupboxEthernet);

        JButton pollButton = new JButton(pollButtonTitle);
        pollButton.setBounds(pollButtonLocationX, pollButtonLocationY, pollButtonSizeWidth,pollButtonSizeHeight);
        this.add(pollButton);

        LabelCreate(groupboxGSM, gsmNames, gsmNamesLocation);
        LabelCreate(groupboxEthernet, ethernetNames, ethernetNamesLocation);
    }

    public static void LabelCreate(JPanel jPanel, String[] labelNames, Point[] labelsLocation){
        for (int i = 0; i < labelNames.length; i++){
            JLabel label = new JLabel(labelNames[i]);
            label.setLocation(labelsLocation[i]);
            label.setSize(allLabelsInGroupSizeWidth,allLabelsInGroupSizeHeight);
            jPanel.add(label);
        }
    }
}
