package space;

import com.ibm.able.Able;
import com.ibm.able.AbleDefaultAgent;
import com.ibm.able.AbleException;

public class Spaceship extends AbleDefaultAgent {
	
	private Boolean isEmpty;
	private String name;

	public Spaceship(String name) throws AbleException{
		super("Spaceship");
		this.name = name;
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
		System.out.println("Hi, I'm spaceship " + name);
	}

}


