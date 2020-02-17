//View.java
//(C) Joseph Mack 2011, jmack (at) wm7d (dot) net, released under GPL v3 (or any later version)

//inspired by Joseph Bergin's MVC gui at http://csis.pace.edu/~bergin/mvc/mvcgui.html

//View is an Observer

import java.awt.Button;
import java.awt.Panel;
import java.awt.Frame;
import java.awt.TextField;
import java.awt.Label;
import java.awt.event.WindowEvent;	//for CloseListener()
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.awt.event.WindowAdapter;	//for CloseListener()
import java.lang.Integer;		//int from Model is passed as an Integer
import java.util.Observable;		//for update();
import java.awt.event.ActionListener;	//for addController()


class View implements PropertyChangeListener {

	//attributes as must be visible within class
	private TextField myTextField;
	private Button button; 

	//private Model model;		//Joe: Model is hardwired in, 
					//needed only if view initialises model (which we aren't doing)
	
	View() {
		System.out.println("View()");	
		
		//frame in constructor and not an attribute as doesn't need to be visible to whole class
		Frame frame 		= new Frame("simple MVC");
		frame.add("North", new Label("counter"));

		myTextField 		= new TextField();
		frame.add("Center", myTextField);

		//panel in constructor and not an attribute as doesn't need to be visible to whole class
		Panel panel 		= new Panel();
		button	 		= new Button("PressMe");
		panel.add(button);
		frame.add("South", panel);		

		frame.addWindowListener(new CloseListener());	
		frame.setSize(400,200);
		frame.setLocation(100,100);
		frame.setVisible(true);

	} //View()

	
	public void addController(ActionListener controller){
		System.out.println("View      : adding controller");
		button.addActionListener(controller);	//need instance of controller before can add it as a listener 
	} //addController()

	//to initialise TextField
	public void setValue(int v){
    		myTextField.setText("" + v);
	} //setValue()
    	
	//uncomment to allow controller to use view to initialise model	
	//public void addModel(Model m){
	//	System.out.println("View      : adding model");
	//	this.model = m;
	//} //addModel()
	
	public static class CloseListener extends WindowAdapter {
		public void windowClosing(WindowEvent e) {
			e.getWindow().setVisible(false);
			System.exit(0);
		} //windowClosing()
	} //CloseListener

	@Override
	public void propertyChange(PropertyChangeEvent evt) {
		
		this.setValue((int) evt.getNewValue());
		
	}

} //View
