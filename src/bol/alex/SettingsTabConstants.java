package bol.alex;

public interface SettingsTabConstants {

    String[] groupsName = {"Сбор данных",
            "Доступ",
            "Прочие",
            "Антидребезг",
            "Время",
            "SMS",
            "Текстовые подставновки для входов",
            "GPRS",
            "RS485",
            "Ethernet",
            "Неизвесные"};

    String[] settingsName = {"Phevent",
            "Phdaily",
            "Tdaily",
            "GPRS Host",
            "Phadmin",
            "Authsecret",
            "ID",
            "Ver",
            "Tdelaymin",
            "Tdelaymax",
            "SmsDelay",
            "TimeZone",
            "TimeSync",
            "TimeSyncPeriod",
            "NtpServer",
            "SmsLimitTime",
            "SmsLimitCnt",
            "TdelayIncr",
            "InName",
            "InStZero",
            "InStOne",
            "ApnHost",
            "ApnUser",
            "ApnPass",
            "GprsDetach",
            "GprsPriority",
            "485config",
            "485wait",
            "EthIp",
            "EthGw",
            "EthNet",
            "EthDns0",
            "EthDns1",
            "EthDhcp",
            "EthTimeout",
            "EthStartTimeout",
            "EthStableTime"};

    String[] descriptionStrings = {"Номер телефона для отправки событий",
            "Номер телефона для отправки переодических уведомлений",
            "Период отправки сообщения ALIVE (0 - отключить отправку)",
            "Список серверов сбора данных, к которым устойство будет подключаться",
            "Номер телефона, с которого принимаются команды",
            "Секрет, используемый для генерации токена.",
            "Идентификатор устройства",
            "Версия устройства/программы (только для чтения)",
            "Минимальная задержка антидребезга", "Максимальная задержка антидребезга",
            "Инкремент задержки антидребезга при изменении состояния входа",
            "Временнáя зона устройства. Например, 180 минут - UTC+3.",
            "Тип синхронизации времени: +",
            "Период синхронизации времени",
            "NTP сервер для синхронизации времени",
            "Ограничить количество отправленных SMS за указанное время",
            "Ограничить количество отправленных SMS указанным числом",
            "Задержка перед отправкой SMS с событиями",
            "Позволяет изменить состояние сигнала 0 входа в сообщении ST на пользовательское",
            "Название входа, присылаемое в сообщении ST",
            "Позволяет изменить состояние сигнала 1 входа в сообщении ST на пользовательское",
            "Хост GPRS APN",
            "Имя пользователя GPRS APN",
            "Пароль GPRS APN",
            "Автоматически отключать GPRS-сессию если она не используется. Если значение = 0 - не отключать.",
            "Приоритет работы с серверами сбора данных: +",
            "Только для устройств с RS485 - настройка режима работы порта для прозрачного режима",
            "Время ожидания после окончания приёма пакета по RS485 перед передачей его в Ethernet",
            "IP-адрес устройства в сети Ethernet",
            "Шлюз в сети Ethernet",
            "Маска подсети Ethenet",
            "DNS-сервер №1 в сети Ethernet",
            "DNS-сервер №2 в сети Ethernet",
            "Использовать DHCP для получения сетевых параметров",
            "Время отсутствия связи по Ethernet, после которого выполняется переключение на GPRS",
            "Время ожидания линка Ethernet при старте устройства, после которого выполняется переключение на GPRS",
            "Время непрерывного наличия связи по Ethernet, после которого выполняется переключение с GPRS на Ethernet"};

    int valuesLength = 100;

    int jfxPanelLocationX = 3;
    int jfxPanelLocationY = 3;
    int jfxPanelSizeWidth = 671;
    int jfxPanelSizeHeight = 338;

    String settingNameColumnTitle = "Уставка";
    String settingValueColumnTitle = "Значение";
    String settingDescriptionColumnTitle = "Описание";

    int settingNameColumnPrefWidth = 175;
    int settingValueColumnPrefWidth = 125;
    int settingDescriptionColumnPrefWidth = 371;

    String readFromFileButtonTitle = "Прочитать из файла";
    int readFromFileButtonLocationX = 3;
    int readFromFileButtonLocationY = 347;
    int readFromFileButtonSizeWidth = 155;
    int readFromFileButtonSizeHeight = 23;

    String writeToFileButtonTitle = "Записать в файл";
    int writeToFileButtonLocationX = 162;
    int writeToFileButtonLocationY = 347;
    int writeToFileButtonSizeWidth = 140;
    int writeToFileButtonSizeHeight = 23;

    String readFromDeviceButtonTitle = "Прочитать с устройства";
    int readFromDeviceButtonLocationX = 308;
    int readFromDeviceButtonLocationY = 347;
    int readFromDeviceButtonSizeWidth = 180;
    int readFromDeviceButtonSizeHeight = 23;

    String writeToDeviceButtonTitle = "Записать в устройство";
    int writeToDeviceButtonLocationX = 494;
    int writeToDeviceButtonLocationY = 347;
    int writeToDeviceButtonSizeWidth = 180;
    int writeToDeviceButtonSizeHeight = 23;

    int groupDataCaptureIndex = 0;
    int groupAccessIndex = 1;
    int groupOthersIndex = 2;
    int groupAntidrebezgIndex = 3;
    int groupTimeIndex = 4;
    int groupSMSIndex = 5;
    int groupTextSubstitutionsForLoginIndex = 6;
    int groupGPRSIndex = 7;
    int groupRS485Index = 8;
    int groupEthernetIndex = 9;
    int groupUnknownIndex = 10;

    int descriptionPheventIndex = 0;
    int descriptionPhdailyIndex = 1;
    int descriptionTdailyIndex = 2;
    int descriptionGPRSHostIndex = 3;
    int descriptionPhadminIndex = 4;
    int descriptionAuthsecretIndex = 5;
    int descriptionIDIndex = 6;
    int descriptionVerIndex = 7;
    int descriptionTdelayminIndex = 8;
    int descriptionTdelaymaxIndex = 9;
    int descriptionTdelayIncrIndex = 10;
    int descriptionTimeZoneIndex = 11;
    int descriptionTimeSyncIndex = 12;
    int descriptionTimeSyncPeriodIndex = 13;
    int descriptionNtpServerIndex = 14;
    int descriptionSmsLimitTimeIndex = 15;
    int descriptionSmsLimitCntIndex = 16;
    int descriptionSmsDelayIndex = 17;
    int descriptionInNameIndex = 18;
    int descriptionInStZeroIndex = 19;
    int descriptionInStOneIndex = 20;
    int descriptionApnHostIndex = 21;
    int descriptionApnUserIndex = 22;
    int descriptionApnPassIndex = 23;
    int descriptionGprsDetachIndex = 24;
    int descriptionGprsPriorityIndex = 25;
    int description485configIndex = 26;
    int description485waitIndex = 27;
    int descriptionEthIpIndex = 28;
    int descriptionEthGwIndex = 29;
    int descriptionEthNetIndex = 30;
    int descriptionEthDns0Index = 31;
    int descriptionEthDns1Index = 32;
    int descriptionEthDhcpIndex = 33;
    int descriptionEthTimeoutIndex = 34;
    int descriptionEthStartTimeoutIndex = 35;
    int descriptionEthStableTimeIndex = 36;



}
