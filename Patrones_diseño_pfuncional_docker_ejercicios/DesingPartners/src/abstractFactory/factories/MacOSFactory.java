package abstractFactory.factories;

import abstractFactory.buttons.Button;
import abstractFactory.buttons.MacOSButton;
import abstractFactory.checkboxes.Checkbox;
import abstractFactory.checkboxes.MacOSCheckbox;


public class MacOSFactory implements GUIFactory {

    @Override
    public Button createButton() {
        return (Button) new MacOSButton();
    }

    @Override
    public Checkbox createCheckbox() {
        return new MacOSCheckbox();
    }
}
