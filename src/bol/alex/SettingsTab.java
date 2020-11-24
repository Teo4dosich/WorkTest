package bol.alex;

import com.opencsv.CSVWriter;
import javafx.embed.swing.JFXPanel;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.SelectionMode;
import javafx.scene.control.TreeItem;
import javafx.scene.control.TreeTableColumn;
import javafx.scene.control.TreeTableView;
import javafx.scene.control.cell.TextFieldTreeTableCell;
import javafx.scene.control.cell.TreeItemPropertyValueFactory;
import javafx.scene.input.*;
import javafx.scene.layout.StackPane;

import javax.swing.*;
import javax.swing.filechooser.FileFilter;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class SettingsTab extends JPanel implements SettingsTabConstants{

    public static List<String[]> readFromCsvFile(String separator, String fileName){
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(fileName), "Cp1251"))){
            List<String[]> list = new ArrayList<>();
            String line = "";
            while((line = reader.readLine()) != null){
                String[] array = line.split(separator);
                list.add(array);
            }
            return list;
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static ArrayList<SetpointValues> DataGroup (String[] Names){
        ArrayList<SetpointValues> result = new ArrayList<>();
        for (int i = 0; i < Names.length; i++)
            result.add(new SetpointValues(Names[i], Names[i]));
        return result;
    }

    public static ArrayList<SetpointValues> Data (String[] Groups, String[] Names, String[] Values, String[] Description){
        ArrayList<SetpointValues> result = new  ArrayList<>();
        for (int i = 0; i < Names.length; i++){
            String temp = Names[i];
            int groupIndex = 0;
            int descriptionIndex = 0;
            switch (temp){
                case "Phevent": {groupIndex = groupDataCaptureIndex; descriptionIndex = descriptionPheventIndex; break;}
                case "Phdaily":{groupIndex = groupDataCaptureIndex; descriptionIndex = descriptionPhdailyIndex; break;}
                case "Tdaily":{groupIndex = groupDataCaptureIndex; descriptionIndex = descriptionTdailyIndex; break;}
                case "GPRS Host":{groupIndex = groupDataCaptureIndex; descriptionIndex = descriptionGPRSHostIndex; break;}

                case "Phadmin": {groupIndex = groupAccessIndex; descriptionIndex = descriptionPhadminIndex; break;}
                case "Authsecret":{groupIndex = groupAccessIndex; descriptionIndex = descriptionAuthsecretIndex; break;}

                case "ID":{groupIndex = groupOthersIndex; descriptionIndex = descriptionIDIndex; break;}
                case "Ver":{groupIndex = groupOthersIndex; descriptionIndex = descriptionVerIndex; break;}

                case "Tdelaymin":{groupIndex = groupAntidrebezgIndex; descriptionIndex = descriptionTdelayminIndex; break;}
                case "Tdelaymax":{groupIndex = groupAntidrebezgIndex; descriptionIndex = descriptionTdelaymaxIndex; break;}
                case "TdelayIncr":{groupIndex = groupAntidrebezgIndex; descriptionIndex = descriptionTdelayIncrIndex; break;}

                case "TimeZone":{groupIndex = groupTimeIndex; descriptionIndex = descriptionTimeZoneIndex; break;}
                case "TimeSync":{groupIndex = groupTimeIndex; descriptionIndex = descriptionTimeSyncIndex; break;}
                case "TimeSyncPeriod":{groupIndex = groupTimeIndex; descriptionIndex = descriptionTimeSyncPeriodIndex; break;}
                case "NtpServer":{groupIndex = groupTimeIndex; descriptionIndex = descriptionNtpServerIndex; break;}

                case "SmsLimitTime":{groupIndex = groupSMSIndex; descriptionIndex = descriptionSmsLimitTimeIndex; break;}
                case "SmsLimitCnt":{groupIndex = groupSMSIndex; descriptionIndex = descriptionSmsLimitCntIndex; break;}
                case "SmsDelay":{groupIndex = groupSMSIndex; descriptionIndex = descriptionSmsDelayIndex; break;}

                case "InName":{groupIndex = groupTextSubstitutionsForLoginIndex; descriptionIndex = descriptionInNameIndex; break;}
                case "InStZero":{groupIndex = groupTextSubstitutionsForLoginIndex; descriptionIndex = descriptionInStZeroIndex; break;}
                case "InStOne":{groupIndex = groupTextSubstitutionsForLoginIndex; descriptionIndex = descriptionInStOneIndex; break;}

                case "ApnHost":{groupIndex = groupGPRSIndex; descriptionIndex = descriptionApnHostIndex; break;}
                case "ApnUser":{groupIndex = groupGPRSIndex; descriptionIndex = descriptionApnUserIndex; break;}
                case "ApnPass":{groupIndex = groupGPRSIndex; descriptionIndex = descriptionApnPassIndex; break;}
                case "GprsDetach":{groupIndex = groupGPRSIndex; descriptionIndex = descriptionGprsDetachIndex; break;}
                case "GprsPriority":{groupIndex = groupGPRSIndex; descriptionIndex = descriptionGprsPriorityIndex; break;}

                case "485config":{groupIndex = groupRS485Index; descriptionIndex = description485configIndex; break;}
                case "485wait":{groupIndex = groupRS485Index; descriptionIndex = description485waitIndex; break;}

                case "EthIp":{groupIndex = groupEthernetIndex; descriptionIndex = descriptionEthIpIndex; break;}
                case "EthGw":{groupIndex = groupEthernetIndex; descriptionIndex = descriptionEthGwIndex; break;}
                case "EthNet":{groupIndex = groupEthernetIndex; descriptionIndex = descriptionEthNetIndex; break;}
                case "EthDns0":{groupIndex = groupEthernetIndex; descriptionIndex = descriptionEthDns0Index; break;}
                case "EthDns1":{groupIndex = groupEthernetIndex; descriptionIndex = descriptionEthDns1Index; break;}
                case "EthDhcp":{groupIndex = groupEthernetIndex; descriptionIndex = descriptionEthDhcpIndex; break;}
                case "EthTimeout":{groupIndex = groupEthernetIndex; descriptionIndex = descriptionEthTimeoutIndex; break;}
                case "EthStartTimeout":{groupIndex = groupEthernetIndex; descriptionIndex = descriptionEthStartTimeoutIndex; break;}
                case "EthStableTime":{groupIndex = groupEthernetIndex; descriptionIndex = descriptionEthStableTimeIndex; break;}

                default:{groupIndex = groupUnknownIndex; break;}
            }
            if (groupIndex != groupUnknownIndex)
                result.add(new SetpointValues(Groups[groupIndex], Names[i], Values[i], Description[descriptionIndex]));
            else
                result.add(new SetpointValues(Groups[groupIndex], Names[i], Values[i], "Неизвестная уставка"));
        }
        return result;
    }

    public static ArrayList<TreeItem<SetpointValues>> GetItems(ArrayList<SetpointValues> Item){
        ArrayList<TreeItem<SetpointValues>> result = new ArrayList<>();
        for (SetpointValues i : Item) {
            result.add(new TreeItem<SetpointValues>(i));
        }
        return result;
    }

    public static void GroupDivision (ArrayList<TreeItem<SetpointValues>> Group, ArrayList<TreeItem<SetpointValues>> Names){
        for (TreeItem<SetpointValues> item : Names){
            String tmp = item.getValue().getGroup();
            switch (tmp) {
                case "Сбор данных":
                    Group.get(groupDataCaptureIndex).getChildren().add(item);
                    break;
                case "Доступ":
                    Group.get(groupAccessIndex).getChildren().add(item);
                    break;
                case "Прочие":
                    Group.get(groupOthersIndex).getChildren().add(item);
                    break;
                case "Антидребезг":
                    Group.get(groupAntidrebezgIndex).getChildren().add(item);
                    break;
                case "Время":
                    Group.get(groupTimeIndex).getChildren().add(item);
                    break;
                case "SMS":
                    Group.get(groupSMSIndex).getChildren().add(item);
                    break;
                case "Текстовые подставновки для входов":
                    Group.get(groupTextSubstitutionsForLoginIndex).getChildren().add(item);
                    break;
                case "GPRS":
                    Group.get(groupGPRSIndex).getChildren().add(item);
                    break;
                case "RS485":
                    Group.get(groupRS485Index).getChildren().add(item);
                    break;
                case "Ethernet":
                    Group.get(groupEthernetIndex).getChildren().add(item);
                    break;
                default:
                    Group.get(groupUnknownIndex).getChildren().add(item);
                    break;
            }
        }
    }

    String[] values = new String[valuesLength];

    public SettingsTab(){

        this.setLayout(null);
        this.setBackground(Color.white);

        JFXPanel jfxPanel = new JFXPanel();
        jfxPanel.setBounds(jfxPanelLocationX,jfxPanelLocationY,jfxPanelSizeWidth,jfxPanelSizeHeight);

        TreeTableView<SetpointValues> treeTableViewCustom = new TreeTableView<>();
        treeTableViewCustom.setPrefWidth(jfxPanelSizeWidth);
        treeTableViewCustom.setEditable(true);
        treeTableViewCustom.getSelectionModel().setCellSelectionEnabled(true);
        treeTableViewCustom.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);


        TreeTableColumn<SetpointValues, String> settingName = new TreeTableColumn<SetpointValues, String>(settingNameColumnTitle);
        TreeTableColumn<SetpointValues, String> settingValue = new TreeTableColumn<SetpointValues, String>(settingValueColumnTitle);
        TreeTableColumn<SetpointValues, String> settingDescription = new TreeTableColumn<SetpointValues, String>(settingDescriptionColumnTitle);

        settingName.setPrefWidth(settingNameColumnPrefWidth);
        settingValue.setPrefWidth(settingValueColumnPrefWidth);
        settingDescription.setPrefWidth(settingDescriptionColumnPrefWidth);

        settingName.setCellValueFactory(new TreeItemPropertyValueFactory<SetpointValues, String>("name"));
        settingValue.setCellValueFactory(new TreeItemPropertyValueFactory<SetpointValues, String>("value"));
        settingValue.setCellFactory(TextFieldTreeTableCell.forTreeTableColumn());
        settingValue.setOnEditCommit(new EventHandler<TreeTableColumn.CellEditEvent<SetpointValues, String>>() {
            @Override
            public void handle(TreeTableColumn.CellEditEvent<SetpointValues, String> event) {
                event.getTreeTableView().getTreeItem(event.getTreeTablePosition().getRow()).getValue().setValue(event.getNewValue());
            }
        });
        settingDescription.setCellValueFactory(new TreeItemPropertyValueFactory<SetpointValues, String>("description"));

        treeTableViewCustom.getColumns().addAll(settingName, settingValue, settingDescription);

        ArrayList<SetpointValues> datagroupArrayList = DataGroup(groupsName);
        ArrayList<SetpointValues> dataArrayList = Data(groupsName, settingsName, values, descriptionStrings);
        ArrayList<TreeItem<SetpointValues>> groupsArrayList = GetItems(datagroupArrayList);
        ArrayList<TreeItem<SetpointValues>> iDataArrayList = GetItems(dataArrayList);

        GroupDivision(groupsArrayList, iDataArrayList);

        SetpointValues pheadroot = new SetpointValues("Root", "Root");
        TreeItem<SetpointValues> headroot = new TreeItem<SetpointValues>(pheadroot);
        headroot.setExpanded(true);
        headroot.getChildren().addAll(groupsArrayList);

        treeTableViewCustom.setRoot(headroot);
        treeTableViewCustom.setShowRoot(false);

        StackPane root = new StackPane();
        root.getChildren().add(treeTableViewCustom);

        Scene scene = new Scene(root);
        scene.getAccelerators().put(new KeyCodeCombination(KeyCode.C, KeyCombination.CONTROL_ANY), new Runnable() {
            @Override
            public void run() {
                int row = treeTableViewCustom.getSelectionModel().getSelectedIndex();
                SetpointValues tmp = treeTableViewCustom.getTreeItem(row).getValue();
                final Clipboard clipboard = Clipboard.getSystemClipboard();
                final ClipboardContent content = new ClipboardContent();
                if (treeTableViewCustom.getSelectionModel().isSelected(row, settingName)){
                    System.out.println(tmp.getName());
                    content.putString(tmp.getName());
                }
                else
                {
                    System.out.println(tmp.getValue());
                    content.putString(tmp.getValue());
                }
                clipboard.setContent(content);
            }
        });

        jfxPanel.setScene(scene);
        this.add(jfxPanel);

        JButton readFromFileButton = new JButton(readFromFileButtonTitle);
        readFromFileButton.setBounds(readFromFileButtonLocationX, readFromFileButtonLocationY, readFromFileButtonSizeWidth,readFromFileButtonSizeHeight);
        readFromFileButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFileChooser fileChooser = new JFileChooser();
                fileChooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
                fileChooser.setFileFilter(new FileFilter() {
                    @Override
                    public boolean accept(File f) {
                        if (f.getName().endsWith("csv"))
                            return true;
                        else
                            return false;
                    }
                    @Override
                    public String getDescription() {

                        return "Файлы табличных данных .csv";
                    }
                });
                fileChooser.showOpenDialog(null);
                File file = fileChooser.getSelectedFile();
                if (file != null) {
                    List<String[]> read = readFromCsvFile(";", file.getPath());
                    for (String[] row: read) {
                        for (int i = 0; i < settingsName.length; i++){
                            String tmp = row[0].substring(1, row[0].length()-1);
                            try {
                                String utf = new String(settingsName[i].getBytes(), "Cp1251" );
                                if (utf.equals(tmp)){
                                    if (row.length != 1 )
                                        values[i] = row[1].substring(1, row[1].length()-1);
                                    else
                                        values[i] = "";
                                }
                            } catch (UnsupportedEncodingException unsupportedEncodingException) {
                                unsupportedEncodingException.printStackTrace();
                            }
                        }

                        ArrayList<SetpointValues> tmpGroupsNameArrayList = DataGroup(groupsName);
                        ArrayList<SetpointValues> tmpDataArrayList = Data(groupsName, settingsName, values,descriptionStrings );
                        ArrayList<TreeItem<SetpointValues>> tmpGroupsArrayList = GetItems(tmpGroupsNameArrayList);
                        ArrayList<TreeItem<SetpointValues>> tmpIDataArrayList = GetItems(tmpDataArrayList);

                        headroot.getChildren().clear();

                        datagroupArrayList.clear();
                        datagroupArrayList.addAll(tmpGroupsNameArrayList);

                        dataArrayList.clear();
                        dataArrayList.addAll(tmpDataArrayList);

                        groupsArrayList.clear();
                        groupsArrayList.addAll(tmpGroupsArrayList);

                        iDataArrayList.clear();
                        iDataArrayList.addAll(tmpIDataArrayList);

                        GroupDivision(groupsArrayList, iDataArrayList);
                        headroot.getChildren().addAll(groupsArrayList);

                        treeTableViewCustom.setVisible(false);
                        treeTableViewCustom.setRoot(headroot);
                        treeTableViewCustom.refresh();
                        treeTableViewCustom.setVisible(true);
                    }
                }}
        });

        this.add(readFromFileButton);

        JButton writeToFileButton = new JButton(writeToFileButtonTitle);
        writeToFileButton.setBounds(writeToFileButtonLocationX, writeToFileButtonLocationY, writeToFileButtonSizeWidth,writeToFileButtonSizeHeight);
        writeToFileButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFileChooser fileChooser = new JFileChooser();
                fileChooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
                fileChooser.setFileFilter(new FileFilter() {
                    @Override
                    public boolean accept(File f) {
                        if (f.getName().endsWith("csv"))
                            return true;
                        else
                            return false;
                    }

                    @Override
                    public String getDescription() {
                        return "Файлы табличных данных .csv";
                    }
                });
                fileChooser.showSaveDialog(null);
                File file = fileChooser.getSelectedFile();
                if (file != null){
                    try {
                        CSVWriter writer = new CSVWriter(new OutputStreamWriter(new FileOutputStream(file.getPath()), "Cp1251"), ';','"', '@', "\n");
                        for (TreeItem<SetpointValues> wr: iDataArrayList) {
                            String str = new String(wr.getValue().getName()+ ";" + wr.getValue().getValue());
                            String[] record = str.split(";");
                            writer.writeNext(record);
                        }
                        writer.close();
                    } catch (IOException ioException) {
                        ioException.printStackTrace();
                    }
                }
            }
        });
        this.add(writeToFileButton);

        JButton readFromDeviceButton = new JButton(readFromDeviceButtonTitle);
        readFromDeviceButton.setBounds(readFromDeviceButtonLocationX, readFromDeviceButtonLocationY, readFromDeviceButtonSizeWidth,readFromDeviceButtonSizeHeight);
        this.add(readFromDeviceButton);

        JButton writeToDeviceButton = new JButton(writeToDeviceButtonTitle);
        writeToDeviceButton.setBounds(writeToDeviceButtonLocationX, writeToDeviceButtonLocationY, writeToDeviceButtonSizeWidth,writeToDeviceButtonSizeHeight);
        this.add(writeToDeviceButton);
    }
}
