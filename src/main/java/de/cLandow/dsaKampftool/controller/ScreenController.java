package de.cLandow.dsaKampftool.controller;

import javafx.scene.Parent;

public interface ScreenController {
    void init();

    void stop();

    Parent render();
}
