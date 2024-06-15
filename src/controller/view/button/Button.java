package controller.view.button;

import java.awt.event.ActionListener;
import javax.swing.JButton;

public final class Button extends JButton
{
    public Button(final String stringParameter, final ActionListener actionListenerParameter)
    {
        super(stringParameter);
        this.addActionListener(actionListenerParameter);
    }
}