package Views.Decorator;

import javax.swing.*;
import java.util.List;

public abstract class CustomMenuDecorator extends Menu{
    protected Menu menu;


    @Override
    public abstract List<JButton> getPulsanti();

}
