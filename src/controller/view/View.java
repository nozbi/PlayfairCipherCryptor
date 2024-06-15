package controller.view;

import java.awt.event.ActionListener;
import javax.swing.SpinnerNumberModel;
import controller.view.editabletextarea.EditableTextArea;
import controller.view.frame.Frame;
import controller.view.horizontalpanel.HorizontalPanel;
import controller.view.menubar.MenuBar;
import controller.view.scrollpanel.ScrollPanel;
import controller.view.spinner.Spinner;
import controller.view.textfield.TextField;
import controller.view.uneditabletextarea.UneditableTextArea;
import controller.view.label.Label;
import controller.view.button.Button;

public final class View 
{
    private final TextField keyTextField;
    private final Spinner keyLengthSpinner;
    private final EditableTextArea inputEditableTextArea;
    private final UneditableTextArea outputUneditableTextArea;

    public View(final ActionListener onEncryptButtonClickedActionListenerParameter, final ActionListener onDecryptButtonClickedActionListenerParameter, final ActionListener onBruteForceAttackButtonClickedActionListenerParameter)
    {
        final Frame frame = new Frame();

            final MenuBar menuBar = new MenuBar();

                menuBar.add(new Label("Key:"));

                this.keyTextField = new TextField();
                menuBar.add(this.keyTextField);

                menuBar.add(new Button("Encrypt", onEncryptButtonClickedActionListenerParameter));

                menuBar.add(new Button("Decrypt", onDecryptButtonClickedActionListenerParameter));

                menuBar.add(new Label("Key length:"));

                this.keyLengthSpinner = new Spinner(new SpinnerNumberModel(0, 0, 25, 1));
                menuBar.add(this.keyLengthSpinner);

                menuBar.add(new Button("Brute force", onBruteForceAttackButtonClickedActionListenerParameter));

            frame.setJMenuBar(menuBar);

            final HorizontalPanel panel = new HorizontalPanel();

                final ScrollPanel inputScrollPanel = new ScrollPanel();

                    this.inputEditableTextArea = new EditableTextArea();
                    inputScrollPanel.getViewport().add(this.inputEditableTextArea);

                panel.add(inputScrollPanel);

                final ScrollPanel outputScrollPanel = new ScrollPanel();

                    this.outputUneditableTextArea = new UneditableTextArea();
                    outputScrollPanel.getViewport().add(this.outputUneditableTextArea);

                panel.add(outputScrollPanel); 

            frame.add(panel);

        frame.setVisible(true); 

        this.inputEditableTextArea.requestFocus();
    }

    public final String getKey()
    {
        return this.keyTextField.getText();
    }

    public final String getInput()
    {
        return this.inputEditableTextArea.getText();
    }

    public final int getKeyLength()
    {
        return (int)this.keyLengthSpinner.getValue();
    }

    public final void setOutput(final String stringParameter)
    {
        this.outputUneditableTextArea.setText(stringParameter);
    }
}
