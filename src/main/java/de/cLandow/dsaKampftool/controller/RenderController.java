package de.cLandow.dsaKampftool.controller;

import javafx.scene.Parent;

public interface RenderController {
    void init();

    void stop();

    Parent render();
}
