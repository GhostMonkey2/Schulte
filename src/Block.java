import javax.swing.*;

/**
 * Created by Andrew on 2016/1/19.
 */
public class Block extends JButton {

    public int order;
    public boolean isChecked = false;

    public Block() {
    }

    public Block(Icon icon) {
        super(icon);
    }

    public void setOrder(int num) {
        order = num;
    }

    public int getOrder() {
        return order;
    }

    public void setChecked(boolean checked) {
        isChecked = checked;
    }

    public boolean getChecked() {
        return isChecked;
    }
}
