package space;

import com.ibm.able.Able;
import com.ibm.able.AbleDefaultAgent;
import com.ibm.able.AbleException;

public class Spaceship extends AbleDefaultAgent {
	
	public Boolean isEmpty;
	public int capacity;
	public String name;
	
	private String loadingType;
	

	public Spaceship(String name, int capacity) throws AbleException{
		super("Spaceship");
		this.name = name;
		this.capacity = capacity;
		isEmpty = true;
		reset();
		init();
	}

	@Override
	public void init() throws AbleException {
		super.init(); // wazne, init uruchamia watek odpowiedzialny za przetwarzanie timera
	}

	@Override
	public void reset() throws AbleException {
		//setDataFlowEnabled(true); //wskazuje, ze chcemy przetwarzac dane w buforach
		setSleepTime(5000); //budzenmie co dwie sekundy
		setTimerEventProcessingEnabled(true); // przetwarzanie eventow z timera
        setAbleEventProcessingEnabled(Able.ProcessingEnabled_PostingEnabled); // wazne, publikowanie eventow 
	}
	
	@Override
	public void processTimerEvent() throws AbleException {
		process();
	}

	@Override
	public void process() throws AbleException {
		//System.out.println("Hi, I'm spaceship " + name);
	}
	
	public void launch(String stock){
		System.out.println("Wysłano po towar: " + stock + "statek: " + name);
		isEmpty = false;
	}
	
	public void unload() throws InterruptedException{
		isEmpty = true;
		System.out.println("Wyładowano "+ capacity + " ze statku " + name);
	}
	
	

}


