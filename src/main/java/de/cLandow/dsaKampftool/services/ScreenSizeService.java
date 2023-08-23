package de.cLandow.dsaKampftool.services;

import java.awt.*;

public class ScreenSizeService {

    public ScreenSizeService(){

    }

    public void PrintScreenSize(){
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        System.out.println(screenSize);
    }
}
