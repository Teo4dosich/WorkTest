package bol.alex;

import com.opencsv.CSVWriter;
import com.opencsv.bean.ColumnPositionMappingStrategy;
import javafx.beans.binding.Binding;
import javafx.beans.binding.Bindings;
import javafx.beans.binding.BooleanBinding;
import javafx.collections.ObservableList;
import javafx.embed.swing.JFXPanel;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.Label;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.scene.control.cell.TextFieldTreeTableCell;
import javafx.scene.control.cell.TreeItemPropertyValueFactory;
import javafx.scene.input.*;
import javafx.scene.layout.Region;
import javafx.scene.layout.StackPane;
import javafx.stage.FileChooser;
import javafx.util.Callback;
import sun.reflect.generics.tree.Tree;

import javax.swing.*;
import javax.swing.filechooser.FileFilter;
import java.awt.*;
import java.awt.datatransfer.StringSelection;
import java.awt.event.*;
import java.awt.event.KeyEvent;
import java.io.*;
import java.util.ArrayList;
import java.util.stream.Collectors;
import java.util.List;


import static javafx.scene.control.cell.TextFieldTableCell.*;

public class Main {
	static JTabbedPane tabc = new JTabbedPane();

    public static void main(String[] args) {

        JFrame app = new JFrame(){};
    	app.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    	app.setLocation(200, 200);
    	app.setSize(723, 494);
    	app.setTitle("Конфигуратор индикатора напряжения");

    	JPanel jpa = new JPanel();
    	app.add(jpa);
    	jpa.setLayout(null);

    	String[] TabControlTitles = {"Информация", "Настройка", "Отладка"};
    		TabbedInf(TabControlTitles[0]);
    		TabbedCustom(TabControlTitles[1]);
    		TabbedDebug(TabControlTitles[2]);
    	tabc.setBounds(12,42, 688, 401);
    	jpa.add(tabc);

    	JLabel COMport = new JLabel("Последовательный порт");
    	COMport.setBounds(48, 9, 162, 13);
    	jpa.add(COMport);

    	JComboBox ComboBoxCOMPort = new JComboBox();
    	ComboBoxCOMPort.setBounds(226,6,285,21);
    	ComboBoxCOMPort.setBackground(Color.white);
    	ComboBoxCOMPort.setEditable(true);
    	jpa.add(ComboBoxCOMPort);

        JButton ButtonCOMPort = new JButton("Подключить");
        ButtonCOMPort.setBounds(517,4,130,23);
        ButtonCOMPort.setBackground(Color.lightGray);
        jpa.add(ButtonCOMPort);

        app.setVisible(true);
        }

		public static void LabelCreate(JPanel pan, String[] names, Point[] location){
		for (int i = 0; i < names.length; i++){
			JLabel label = new JLabel(names[i]);
			label.setLocation(location[i]);
			label.setSize(175,13);
			pan.add(label);
		}
	}

		public static void TabbedInf (String name){

			String[] GSMNames = {"Состояние", "Уровень сигнала", "GPRS сессия открыта", "IP-адрес GPRS"};
			Point[] GSMNamesLocation ={ new Point(9,23), new Point(9,61), new Point(9,100), new Point(9,139)};
			Point[] GSMTextBoxes ={ new Point(9,39), new Point(9,77), new Point(9,116), new Point(9,155)};

			String[] EthernetNames = {"Линк", "MAC-адрес", "IP-адрес", "Адрес сети", "Шлюз", "DNS1", "DNS2"};
			Point[] EthernetNamesLocation = { new Point(9,23), new Point(9,62), new Point(9,101),
					new Point(9,140), new Point(9,179),
					new Point(9,218), new Point(9,257)};
			Point[] EthernetTextBoxes ={ new Point(9,39), new Point(9,78), new Point(9,117),
					new Point(9,156), new Point(9,195),
					new Point(9,234), new Point(9,273)};

			Object[][] dat = new String[][]{{"0","1","2020"},
					{"1","0","2019"},
					{"2","0","2021"}};
			Object[] colHead = new String[] {"Вход", "Сосотояние", "Дата"};

			JPanel panel = new JPanel();
			panel.setLayout(null);
			panel.setBackground(Color.white);

			JLabel StateOfInputs = new JLabel("Состояние входов");
			StateOfInputs.setBounds(7,7,120,13);
			JTable StateOfInputsTable = new JTable(dat, colHead);
			StateOfInputsTable.getColumn("Вход").setMaxWidth(40);
			panel.add(StateOfInputs);

			JScrollPane jScrollPane = new JScrollPane(StateOfInputsTable);
			jScrollPane.setBounds(10,23,200,344);
			panel.add(jScrollPane);

			JLabel SerialNumber = new JLabel("Серийный номер");
			SerialNumber.setBounds(222, 46, 200, 13);

			JLabel VersionPO = new JLabel("Версия ПО");
			VersionPO.setBounds(222, 85, 200, 13);

			JTextField textFieldSerialNumber = new JTextField();
			textFieldSerialNumber.setBounds(222, 62, 200, 20);
			textFieldSerialNumber.setEditable(false);
			textFieldSerialNumber.setBackground(Color.white);

			JTextField textFieldVersionPO = new JTextField();
			textFieldVersionPO.setBounds(222, 101, 200, 20);
			textFieldVersionPO.setEditable(false);
			textFieldVersionPO.setBackground(Color.white);

			panel.add(SerialNumber);
			panel.add(VersionPO);
			panel.add(textFieldSerialNumber);
			panel.add(textFieldVersionPO);

			JPanel GroupboxGSM = new JPanel();
			GroupboxGSM.setBorder(BorderFactory.createTitledBorder("GSM"));
			GroupboxGSM.setBounds(222,140,200,186);
			GroupboxGSM.setBackground(Color.white);
			GroupboxGSM.setLayout(null);

			LabelCreate(GroupboxGSM, GSMNames, GSMNamesLocation);

            JTextField textFieldCondition = new JTextField();
            textFieldCondition.setLocation(GSMTextBoxes[0]);
            textFieldCondition.setSize(175, 20);
            textFieldCondition.setEditable(false);
            textFieldCondition.setBackground(Color.white);

            JTextField textFieldSignalLevel = new JTextField();
            textFieldSignalLevel.setLocation(GSMTextBoxes[1]);
            textFieldSignalLevel.setSize(175, 20);
            textFieldSignalLevel.setEditable(false);
            textFieldSignalLevel.setBackground(Color.white);

            JTextField textFieldGPRSSessionOpen = new JTextField();
            textFieldGPRSSessionOpen.setLocation(GSMTextBoxes[2]);
            textFieldGPRSSessionOpen.setSize(175, 20);
            textFieldGPRSSessionOpen.setEditable(false);
            textFieldGPRSSessionOpen.setBackground(Color.white);

            JTextField textFieldIPAdressGPRS = new JTextField();
            textFieldIPAdressGPRS.setLocation(GSMTextBoxes[3]);
            textFieldIPAdressGPRS.setSize(175, 20);
            textFieldIPAdressGPRS.setEditable(false);
            textFieldIPAdressGPRS.setBackground(Color.white);

            GroupboxGSM.add(textFieldCondition);
            GroupboxGSM.add(textFieldSignalLevel);
            GroupboxGSM.add(textFieldGPRSSessionOpen);
            GroupboxGSM.add(textFieldIPAdressGPRS);
            panel.add(GroupboxGSM);

			JPanel GroupboxEthernet = new JPanel();

			GroupboxEthernet.setBorder(BorderFactory.createTitledBorder("GSM"));
			GroupboxEthernet.setBounds(472,23,200,303);
			GroupboxEthernet.setBackground(Color.white);
			GroupboxEthernet.setLayout(null);

            LabelCreate(GroupboxEthernet, EthernetNames, EthernetNamesLocation);

            JTextField textFieldLink = new JTextField();
            textFieldLink.setLocation(EthernetTextBoxes[0]);
            textFieldLink.setSize(175, 20);
            textFieldLink.setEditable(false);
            textFieldLink.setBackground(Color.white);

            JTextField textFieldMACAdress = new JTextField();
            textFieldMACAdress.setLocation(EthernetTextBoxes[1]);
            textFieldMACAdress.setSize(175, 20);
            textFieldMACAdress.setEditable(false);
            textFieldMACAdress.setBackground(Color.white);

            JTextField textFieldIPAdress = new JTextField();
            textFieldIPAdress.setLocation(EthernetTextBoxes[2]);
            textFieldIPAdress.setSize(175, 20);
            textFieldIPAdress.setEditable(false);
            textFieldIPAdress.setBackground(Color.white);

            JTextField textFieldNetmask = new JTextField();
            textFieldNetmask.setLocation(EthernetTextBoxes[3]);
            textFieldNetmask.setSize(175, 20);
            textFieldNetmask.setEditable(false);
            textFieldNetmask.setBackground(Color.white);

            JTextField textFieldGateway = new JTextField();
            textFieldGateway.setLocation(EthernetTextBoxes[4]);
            textFieldGateway.setSize(175, 20);
            textFieldGateway.setEditable(false);
            textFieldGateway.setBackground(Color.white);

            JTextField textFieldDNS1 = new JTextField();
            textFieldDNS1.setLocation(EthernetTextBoxes[5]);
            textFieldDNS1.setSize(175, 20);
            textFieldDNS1.setEditable(false);
            textFieldDNS1.setBackground(Color.white);

            JTextField textFieldDNS2 = new JTextField();
            textFieldDNS2.setLocation(EthernetTextBoxes[6]);
            textFieldDNS2.setSize(175, 20);
            textFieldDNS2.setEditable(false);
            textFieldDNS2.setBackground(Color.white);

            GroupboxEthernet.add(textFieldLink);
            GroupboxEthernet.add(textFieldMACAdress);
            GroupboxEthernet.add(textFieldIPAdress);
            GroupboxEthernet.add(textFieldNetmask);
            GroupboxEthernet.add(textFieldGateway);
            GroupboxEthernet.add(textFieldDNS1);
            GroupboxEthernet.add(textFieldDNS2);

			panel.add(GroupboxEthernet);

			JButton Opros = new JButton("Опрос");
			Opros.setBounds(542, 344, 130,23);
			panel.add(Opros);

			tabc.addTab(name, panel);
		}

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
                int k=0;
                int j=0;
                switch (temp){
                    case "Phevent": {k = 0; j = 0; break;}
                    case "Phdaily":{k = 0; j = 1; break;}
                    case "Tdaily":{k = 0; j = 2; break;}
                    case "GPRS Host":{k = 0; j = 3; break;}

                    case "Phadmin": {k = 1; j = 4; break;}
                    case "Authsecret":{k = 1; j = 5; break;}

                    case "ID":{k = 2; j = 6; break;}
                    case "Ver":{k = 2; j = 7; break;}

                    case "Tdelaymin":{k = 3; j = 8; break;}
                    case "Tdelaymax":{k = 3; j = 9; break;}
                    case "TdelayIncr":{k = 3; j = 10; break;}

                    case "TimeZone":{k = 4; j = 11; break;}
                    case "TimeSync":{k = 4; j = 12; break;}
                    case "TimeSyncPeriod":{k = 4; j = 13; break;}
                    case "NtpServer":{k = 4; j = 14; break;}

                    case "SmsLimitTime":{k = 5; j = 15; break;}
                    case "SmsLimitCnt":{k = 5; j = 16; break;}
                    case "SmsDelay":{k = 5; j = 17; break;}

                    case "InName":{k = 6; j = 18; break;}
                    case "InStZero":{k = 6; j = 19; break;}
                    case "InStOne":{k = 6; j = 20; break;}

                    case "ApnHost":{k = 7; j = 21; break;}
                    case "ApnUser":{k = 7; j = 22; break;}
                    case "ApnPass":{k = 7; j = 23; break;}
                    case "GprsDetach":{k = 7; j = 24; break;}
                    case "GprsPriority":{k = 7; j = 25; break;}

                    case "485config":{k = 8; j = 26; break;}
                    case "485wait":{k = 8; j = 27; break;}

                    case "EthIp":{k = 9; j = 28; break;}
                    case "EthGw":{k = 9; j = 29; break;}
                    case "EthNet":{k = 9; j = 30; break;}
                    case "EthDns0":{k = 9; j = 31; break;}
                    case "EthDns1":{k = 9; j = 32; break;}
                    case "EthDhcp":{k = 9; j = 33; break;}
                    case "EthTimeout":{k = 9; j = 34; break;}
                    case "EthStartTimeout":{k = 9; j = 35; break;}
                    case "EthStableTime":{k = 9; j = 36; break;}

                    default:{k = 10; break;}
                }
                if (k != 10)
                    result.add(new SetpointValues(Groups[k], Names[i], Values[i], Description[j]));
                else
                    result.add(new SetpointValues(Groups[k], Names[i], Values[i], "Неизвестная уставка"));
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
                        Group.get(0).getChildren().add(item);
                        break;
                    case "Доступ":
                        Group.get(1).getChildren().add(item);
                        break;
                    case "Прочие":
                        Group.get(2).getChildren().add(item);
                        break;
                    case "Антидребезг":
                        Group.get(3).getChildren().add(item);
                        break;
                    case "Время":
                        Group.get(4).getChildren().add(item);
                        break;
                    case "SMS":
                        Group.get(5).getChildren().add(item);
                        break;
                    case "Текстовые подставновки для входов":
                        Group.get(6).getChildren().add(item);
                        break;
                    case "GPRS":
                        Group.get(7).getChildren().add(item);
                        break;
                    case "RS485":
                        Group.get(8).getChildren().add(item);
                        break;
                    case "Ethernet":
                        Group.get(9).getChildren().add(item);
                        break;
                    default:
                        Group.get(10).getChildren().add(item);
                        break;
                }
            }
        }

		public static void TabbedCustom (String name){

    		JPanel panel = new JPanel();
			panel.setLayout(null);
			panel.setBackground(Color.white);

			JFXPanel tableFX = new JFXPanel();
			tableFX.setBounds(3,3,671,338);

			TreeTableView<SetpointValues> CustomTable = new TreeTableView<>();
			CustomTable.setPrefWidth(671);
			CustomTable.setEditable(true);
			CustomTable.getSelectionModel().setCellSelectionEnabled(true);
			CustomTable.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);


			TreeTableColumn<SetpointValues, String> Ustavka = new TreeTableColumn<SetpointValues, String>("Уставка");
			TreeTableColumn<SetpointValues, String> Znachenie = new TreeTableColumn<SetpointValues, String>("Значение");
			TreeTableColumn<SetpointValues, String> Opisanie = new TreeTableColumn<SetpointValues, String>("Описание");

			Ustavka.setPrefWidth(175);
			Znachenie.setPrefWidth(125);
			Opisanie.setPrefWidth(371);

			Ustavka.setCellValueFactory(new TreeItemPropertyValueFactory<SetpointValues, String>("name"));
			Znachenie.setCellValueFactory(new TreeItemPropertyValueFactory<SetpointValues, String>("value"));
			Znachenie.setCellFactory(TextFieldTreeTableCell.forTreeTableColumn());
			Znachenie.setOnEditCommit(new EventHandler<TreeTableColumn.CellEditEvent<SetpointValues, String>>() {
				@Override
				public void handle(TreeTableColumn.CellEditEvent<SetpointValues, String> event) {
					event.getTreeTableView().getTreeItem(event.getTreeTablePosition().getRow()).getValue().setValue(event.getNewValue());
				}
			});
			Opisanie.setCellValueFactory(new TreeItemPropertyValueFactory<SetpointValues, String>("description"));

			CustomTable.getColumns().addAll(Ustavka, Znachenie, Opisanie);

			String[] groupsname = {"Сбор данных", "Доступ", "Прочие",
					"Антидребезг", "Время", "SMS",
					"Текстовые подставновки для входов", "GPRS", "RS485",
					"Ethernet", "Неизвесные"};

			String[] ustavki = {"Phevent", "Phdaily","Tdaily","GPRS Host","Phadmin","Authsecret","ID", "Ver", "Tdelaymin", "Tdelaymax", "SmsDelay"
					, "TimeZone", "TimeSync", "TimeSyncPeriod", "NtpServer", "SmsLimitTime", "SmsLimitCnt", "TdelayIncr","InName", "InStZero", "InStOne",
					"ApnHost", "ApnUser", "ApnPass", "GprsDetach", "GprsPriority", "485config",	"485wait", "EthIp", "EthGw", "EthNet", "EthDns0", "EthDns1",
					"EthDhcp", "EthTimeout", "EthStartTimeout", "EthStableTime"};

			String[] discr = {"Номер телефона для отправки событий", "Номер телефона для отправки переодических уведомлений",
					"Период отправки сообщения ALIVE (0 - отключить отправку)", "Список серверов сбора данных, к которым устойство будет подключаться",
					"Номер телефона, с которого принимаются команды", "Секрет, используемый для генерации токена.", "Идентификатор устройства",
					"Версия устройства/программы (только для чтения)", "Минимальная задержка антидребезга", "Максимальная задержка антидребезга",
					"Инкремент задержки антидребезга при изменении состояния входа", "Временнáя зона устройства. Например, 180 минут - UTC+3.",
					"Тип синхронизации времени: +", "Период синхронизации времени", "NTP сервер для синхронизации времени",
					"Ограничить количество отправленных SMS за указанное время", "Ограничить количество отправленных SMS указанным числом",
					"Задержка перед отправкой SMS с событиями", "Позволяет изменить состояние сигнала 0 входа в сообщении ST на пользовательское",
					"Название входа, присылаемое в сообщении ST", "Позволяет изменить состояние сигнала 1 входа в сообщении ST на пользовательское",
					"Хост GPRS APN", "Имя пользователя GPRS APN", "Пароль GPRS APN", "Автоматически отключать GPRS-сессию если она не используется. Если значение = 0 - не отключать.",
					"Приоритет работы с серверами сбора данных: +", "Только для устройств с RS485 - настройка режима работы порта для прозрачного режима",
					"Время ожидания после окончания приёма пакета по RS485 перед передачей его в Ethernet", "IP-адрес устройства в сети Ethernet", "Шлюз в сети Ethernet",
					"Маска подсети Ethenet", "DNS-сервер №1 в сети Ethernet", "DNS-сервер №2 в сети Ethernet", "Использовать DHCP для получения сетевых параметров",
					"Время отсутствия связи по Ethernet, после которого выполняется переключение на GPRS", "Время ожидания линка Ethernet при старте устройства, после которого выполняется переключение на GPRS",
					"Время непрерывного наличия связи по Ethernet, после которого выполняется переключение с GPRS на Ethernet"};

			String[] values = new String[50];

			ArrayList<SetpointValues> datagroup = DataGroup(groupsname);
			ArrayList<SetpointValues> data = Data(groupsname, ustavki, values, discr);
			ArrayList<TreeItem<SetpointValues>> groups = GetItems(datagroup);
			ArrayList<TreeItem<SetpointValues>> idata = GetItems(data);

			GroupDivision(groups, idata);

			SetpointValues pheadroot = new SetpointValues("Root", "Root");
			TreeItem<SetpointValues> headroot = new TreeItem<SetpointValues>(pheadroot);
			headroot.setExpanded(true);
			headroot.getChildren().addAll(groups);

			CustomTable.setRoot(headroot);
			CustomTable.setShowRoot(false);

			StackPane root = new StackPane();
			root.getChildren().add(CustomTable);

			Scene scene = new Scene(root);
			scene.getAccelerators().put(new KeyCodeCombination(KeyCode.C, KeyCombination.CONTROL_ANY), new Runnable() {
                @Override
                public void run() {
                    int row = CustomTable.getSelectionModel().getSelectedIndex();
                    SetpointValues tmp = CustomTable.getTreeItem(row).getValue();
                    final Clipboard clipboard = Clipboard.getSystemClipboard();
                    final ClipboardContent content = new ClipboardContent();
                    if (CustomTable.getSelectionModel().isSelected(row, Ustavka)){
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

			tableFX.setScene(scene);
			panel.add(tableFX);

			JButton ReadFromFile = new JButton("Прочитать из файла");
			ReadFromFile.setBounds(3, 347, 155,23);
			ReadFromFile.addActionListener(new ActionListener() {
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

                    List<String[]>  read = readFromCsvFile(";", file.getPath());
                    for (String[] row: read) {
                        for (int i = 0; i < ustavki.length; i++){
                            String tmp = row[0].substring(1, row[0].length()-1);
                            try {
                                String utf = new String(ustavki[i].getBytes(), "Cp1251" );
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

                        ArrayList<SetpointValues> alg = DataGroup(groupsname);
                        ArrayList<SetpointValues> ald = Data(groupsname, ustavki, values,discr );
                        ArrayList<TreeItem<SetpointValues>> gr = GetItems(alg);
                        ArrayList<TreeItem<SetpointValues>> da = GetItems(ald);

                        headroot.getChildren().clear();

						datagroup.clear();
                        datagroup.addAll(alg);

                        data.clear();
                        data.addAll(ald);

                        groups.clear();
                        groups.addAll(gr);

                        idata.clear();
                        idata.addAll(da);

                        GroupDivision(groups, idata);
                        headroot.getChildren().addAll(groups);

                        CustomTable.setVisible(false);
                        CustomTable.setRoot(headroot);
                        CustomTable.refresh();
                        CustomTable.setVisible(true);
                    }
                }
            });

			panel.add(ReadFromFile);

			JButton WriteToFile = new JButton("Записать в файл");
			WriteToFile.setBounds(162, 347, 140,23);
            WriteToFile.addActionListener(new ActionListener() {
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
					try {
						CSVWriter writer = new CSVWriter(new OutputStreamWriter(new FileOutputStream(file.getPath()), "Cp1251"), ';','"', '@', "\n");
						for (TreeItem<SetpointValues> wr: idata) {
							String str = new String(wr.getValue().getName()+ ";" + wr.getValue().getValue());
							String[] record = str.split(";");
							writer.writeNext(record);
						}
						writer.close();
					} catch (IOException ioException) {
						ioException.printStackTrace();
					}
				}
            });
			panel.add(WriteToFile);

			JButton ReadFromDevice = new JButton("Прочитать с устройства");
			ReadFromDevice.setBounds(308, 347, 180,23);
			panel.add(ReadFromDevice);

			JButton WriteToDevice = new JButton("Записать в устройство");
			WriteToDevice.setBounds(494, 347, 180,23);
			panel.add(WriteToDevice);

			tabc.addTab(name, panel);
		}

		public static void TabbedDebug (String name){

    		JPanel panel = new JPanel();
			panel.setLayout(null);
			panel.setBackground(Color.white);

			JLabel OutputFromDevice = new JLabel("Вывод с устройства");
			OutputFromDevice.setBounds(6,11,150,13);
			panel.add(OutputFromDevice);

			JLabel InputInDevice = new JLabel("Ввод в устройство");
			InputInDevice.setBounds(6,329,150,13);
			panel.add(InputInDevice);

			JButton Save = new JButton("Сохранить");
			Save.setBounds(468, 6, 100,23);
			panel.add(Save);

			JButton Clean = new JButton("Очистить");
			Clean.setBounds(574, 6, 100,23);
			panel.add(Clean);

			JButton Send = new JButton("Отправить");
			Send.setBounds(574, 343, 100,23);
			panel.add(Send);

			JTextArea OutputInformation = new JTextArea();
			OutputInformation.setBounds(6,35,668,291);
			OutputInformation.setEditable(false);
			panel.add(OutputInformation);

			JScrollPane jScrollPane = new JScrollPane(OutputInformation);
			jScrollPane.setBounds(6,35,668,291);
			panel.add(jScrollPane);

			JTextField InputInformation = new JTextField();
			InputInformation.setBounds(6,345,562,20);
			panel.add(InputInformation);
			InputInformation.addKeyListener(new KeyListener() {
                @Override
                public void keyTyped(KeyEvent e) {

                }

                @Override
                public void keyPressed(KeyEvent e) {
                    if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                        String str = InputInformation.getText();
                        OutputInformation.append(str + "\r\n");
                        InputInformation.selectAll();
                        InputInformation.replaceSelection("");
                    }
                }

                @Override
                public void keyReleased(KeyEvent e) {

                }
            });

			Clean.addActionListener(new ActionListener() {
			    @Override
                public void actionPerformed(ActionEvent e) {
			        OutputInformation.selectAll();
			        OutputInformation.replaceSelection("");
			    }
			});
			Send.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    String str = InputInformation.getText();
                    OutputInformation.append(str + "\r\n");
                    InputInformation.selectAll();
                    InputInformation.replaceSelection("");
                }
            });
			Save.addActionListener(new ActionListener() {
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
                    File savefile = fileChooser.getSelectedFile();
                    try {
                        FileWriter fw = new FileWriter(savefile.getPath());
                        OutputInformation.write(fw);
                    } catch (IOException ioException) {
                        ioException.printStackTrace();
                    }
                }
            });
			tabc.addTab(name, panel);
		}
}

