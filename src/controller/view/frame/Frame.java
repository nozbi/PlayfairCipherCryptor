package controller.view.frame;

import javax.swing.JFrame;

public final class Frame extends JFrame
{
    public Frame()
    {
        super("Playfair Cipher Cryptor");
        this.setSize(1000, 1000);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
    }
}