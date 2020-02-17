//RunMVC.java
//(C) Joseph Mack 2011, jmack (at) wm7d (dot) net, released under GPL v3 (or any later version)

public class RunMVC {
	// a order de instanciacao dos objetos abaixo vai ser importante para alguns pares de comandos
	// isso nao foi explorado em nenhum detalhe, mas a ordem abaixo funciona

	private int start_value = 10;	//para incializar o modelo

	public RunMVC() {

		//cria o Modelo e a Visao
		Model myModel 	= new Model();
		View myView 	= new View();

		//avisa o modelo que a visao existe 
		//myModel.addObserver(myView);
		myModel.addPropertyChangeListener(myView);
		/*	
			init model after view is instantiated and can show the status of the model
			(I later decided that only the controller should talk to the model
			and moved initialisation to the controller (see below).)
		*/
		//uncomment to directly initialise Model
		//myModel.setValue(start_value);	

		//create Controller. tell it about Model and View, initialise model
		Controller myController = new Controller();
		myController.addModel(myModel);
		myController.addView(myView);
		myController.initModel(start_value);

		//tell View about Controller 
		myView.addController(myController);
		//and Model, 
		//this was only needed when the view inits the model
		//myView.addModel(myModel);

	} //RunMVC()

} //RunMVC
