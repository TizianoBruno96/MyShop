package Views.Decoretor;

import javax.swing.*;
import java.util.List;

public abstract class CustomMenuDecoretor extends Menu{
    public Menu menu;

    @Override
    public abstract List<JButton> getPulsanti();

}
