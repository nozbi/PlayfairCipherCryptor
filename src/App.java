import controller.Controller;

public final class App 
{
    public static final void main(final String[] stringsParameter)
    {
        javax.swing.SwingUtilities.invokeLater(new Runnable() 
		{
			public final void run() 
			{
				new Controller();
			}
		});
    }
}
