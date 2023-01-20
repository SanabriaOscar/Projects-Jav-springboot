package factory.folderFactory;

import factory.buttons.Button;
import factory.buttons.HtmlButton;

public class HtmlDialog  extends Dialog{

    @Override
    public Button createButton() {
        return new HtmlButton();
    }
}
