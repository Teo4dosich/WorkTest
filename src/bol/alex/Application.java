package bol.alex;

import javax.swing.*;

public class Application extends JFrame implements ApplicationConstants{

    public Application(){
        super(applicationTitle);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocation(applicationLocationX, applicationLocationY);
        this.setSize(applicationSizeWidth,applicationSizeHeight);

        PanelTabbedPane panel = new PanelTabbedPane();
        this.add(panel);
    }
}
