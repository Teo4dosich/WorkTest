package bol.alex;

import java.awt.*;

public interface InformationTabConstants {
    String[] gsmNames = {"Состояние", "Уровень сигнала", "GPRS сессия открыта", "IP-адрес GPRS"};
    Point[] gsmNamesLocation ={ new Point(9,23), new Point(9,61), new Point(9,100), new Point(9,139)};
    Point[] gsmTextBoxes ={ new Point(9,39), new Point(9,77), new Point(9,116), new Point(9,155)};

    String[] ethernetNames = {"Линк", "MAC-адрес", "IP-адрес", "Адрес сети", "Шлюз", "DNS1", "DNS2"};
    Point[] ethernetNamesLocation = { new Point(9,23), new Point(9,62), new Point(9,101),
            new Point(9,140), new Point(9,179),
            new Point(9,218), new Point(9,257)};
    Point[] ethernetTextBoxes ={ new Point(9,39), new Point(9,78), new Point(9,117),
            new Point(9,156), new Point(9,195),
            new Point(9,234), new Point(9,273)};
    Object[] columnHeading = new String[] {"Вход", "Сосотояние", "Дата"};

    int indexOfFirstColumn = 0;
    int maxWidthOfFirstColumn = 40;

    String stateOfInputsLabelTitle = "Состояние входов";
    int stateOfInputsLabelLocationX = 7;
    int stateOfInputsLabelLocationY = 7;
    int stateOfInputsLabelSizeWidth = 120;
    int stateOfInputsLabelSizeHeight = 13;

    int jScrollPaneLocationX = 10;
    int jScrollPaneLocationY = 23;
    int jScrollPaneSizeWidth = 179;
    int jScrollPaneSizeHeight = 344;

    String serialNumberLabelTitle = "Серийный номер";
    int serialNumberLabelLocationX = 222;
    int serialNumberLabelLocationY = 46;
    int serialNumberLabelSizeWidth = 200;
    int serialNumberLabelSizeHeight = 13;

    String versionPOLabelTitle = "Версия ПО";
    int versionPOLabelLocationX = 222;
    int versionPOLabelLocationY = 85;
    int versionPOLabelSizeWidth = 200;
    int versionPOLabelSizeHeight = 13;

    int textFieldSerialNumberLocationX = 222;
    int textFieldSerialNumberLocationY = 62;
    int textFieldSerialNumberSizeWidth = 200;
    int textFieldSerialNumberSizeHeight = 20;

    int textFieldVersionPOLocationX = 222;
    int textFieldVersionPOLocationY = 101;
    int textFieldVersionPOSizeWidth = 200;
    int textFieldVersionPOSizeHeight = 20;

    String groupboxGSMTitle = "GSM";
    int groupboxGSMLocationX = 222;
    int groupboxGSMLocationY = 140;
    int groupboxGSMSizeWidth = 200;
    int groupboxGSMSizeHeight = 186;

    int allTextFieldsInGroupSizeWidth = 175;
    int allTextFieldsInGroupSizeHeight = 20;
    int allLabelsInGroupSizeWidth = 175;
    int allLabelsInGroupSizeHeight = 13;

    int textFieldConditionIndexOfGSMTextBoxesPoint = 0;
    int textFieldSignalLevelIndexOfGSMTextBoxesPoint = 1;
    int textFieldGPRSSessionOpenIndexOfGSMTextBoxesPoint = 2;
    int textFieldIPAddressGPRSIndexOfGSMTextBoxesPoint = 3;

    int textFieldLinkIndexOfEthernetTextBoxesPoint = 0;
    int textFieldMACAddressIndexOfEthernetTextBoxesPoint = 1;
    int textFieldIPAddressIndexOfEthernetTextBoxesPoint = 2;
    int textFieldNetmaskIndexOfEthernetTextBoxesPoint = 3;
    int textFieldGatewayIndexOfEthernetTextBoxesPoint = 4;
    int textFieldDNS1IndexOfEthernetTextBoxesPoint = 5;
    int textFieldDNS2IndexOfEthernetTextBoxesPoint = 6;

    String groupboxEthernetTitle = "Ethernet";
    int groupboxEthernetLocationX = 472;
    int groupboxEthernetLocationY = 23;
    int groupboxEthernetSizeWidth = 200;
    int groupboxEthernetSizeHeight = 303;

    String pollButtonTitle = "Опрос";
    int pollButtonLocationX = 542;
    int pollButtonLocationY = 344;
    int pollButtonSizeWidth = 130;
    int pollButtonSizeHeight = 23;
}
