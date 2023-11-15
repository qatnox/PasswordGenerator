package Main;

public class InitPassGen {
    PassGenGUI gui = new PassGenGUI() ;
    InitPassGen() {
        gui.setButtons();
        gui.setLabels();
        gui.setComboBox();
        gui.setTextFields();
        gui.addComponents();
        gui.initFrame();
    }
}
