package controller.view.spinner;

import javax.swing.JSpinner;
import javax.swing.JTextField;
import javax.swing.SpinnerNumberModel;

public final class Spinner extends JSpinner
{
    public Spinner(final SpinnerNumberModel spinnerNumberModelParameter)
    {
        super(spinnerNumberModelParameter);
        ((JSpinner.DefaultEditor)this.getEditor()).getTextField().setHorizontalAlignment(JTextField.CENTER);
    }
}