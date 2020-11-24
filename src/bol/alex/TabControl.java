package bol.alex;

import javax.swing.*;

public class TabControl extends JTabbedPane implements TabControlConstants{

    public TabControl(){
        this.setBounds(tabControlLocationX,tabControlLocationY, tabControlSizeWidth, tabControlSizeHeight);
        this.add(informationTabTitle, new InformationTab());
        this.add(settingsTabTitle, new SettingsTab());
        this.add(debugTabTitle, new DebugTab());
    }
}
