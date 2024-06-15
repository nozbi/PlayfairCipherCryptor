package controller.view.uneditabletextarea;

import javax.swing.JTextArea;

public final class UneditableTextArea extends JTextArea
{
    public UneditableTextArea()
    {
        super();
        this.setLineWrap(true);
        this.setEditable(false);
        this.setOpaque(false);
    }
}
