package GUI;

import javax.swing.*;
import java.util.List;

public interface MainCanvasInterface {

    public JFrame getFrame();

    public List<Number> getList();

    public void setListSorted(boolean listsorted);

    public boolean isListSorted();

    public int getDataSize();
}
