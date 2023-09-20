package Main;

import java.io.IOException;

public class InitPassGen {
    PassGenGUI gui = new PassGenGUI() ;
    InitPassGen() {
        gui.setButtons();
        gui.setLabels();
        gui.setCheckBox();
        gui.setTextFields();
        gui.addComponents();
        gui.initFrame();
    }
}
