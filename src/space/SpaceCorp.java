package space;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Vector;

import com.ibm.able.Able;
import com.ibm.able.AbleDefaultAgent;
import com.ibm.able.AbleEvent;
import com.ibm.able.AbleException;


public class SpaceCorp extends AbleDefaultAgent{

	private static final long serialVersionUID = 1L;
	
	private Stock stock;
	
	private String name;
	//private Spaceship spaceship;
	private CorpoCEO ceo;
	private Planet location;
	private Vector<Spaceship> fleet;
	private Vector<Planet> planetList;
	
	
	private Stock wood = new Stock("wood", 0);
	private Stock diamonds = new Stock("diamonds", 0);
	private Stock uran = new Stock("uran", 0);
	
	public SpaceCorp(String name) throws AbleException{
		super("SpaceCorp");
		this.name = name;
		inputBuffer = new Object[1];
		fleet = new Vector();
		buyShips();
		ceo = new CorpoCEO("Szef");
		reset();
		init();
	}
	
	
	
	public String getName() {
		return name;
	}



	@Override
	public void init() throws AbleException {
		super.init(); // wazne, init uruchamia watek odpowiedzialny za przetwarzanie timera i eventow
	}
	
	@Override
	public void reset() throws AbleException {
		setDataFlowEnabled(true);
		setSleepTime(2000); // budzenie co dwie sekundy
		setTimerEventProcessingEnabled(true); // przetwarzanie eventow z timera
        setAbleEventProcessingEnabled(Able.ProcessingEnabled_PostingEnabled); // wazne, publikowanie eventow 
	}
	
	@Override
	public void processTimerEvent() throws AbleException {
		process();
	}

	@Override
	public void process() throws AbleException {
		System.out.println("Proces copro");
		OfferMessage ofr = new OfferMessage(wood.getType(), wood.getStockAmount(), this);
		notifyAbleEventListeners(new AbleEvent(this, ofr));
		processBufferConnections();
		Stock order = (Stock)getInputBuffer(0);
		removeAllBufferConnections();
		if (order != null){
			System.out.println("Zamówienie: " + order.getType() + " " + order.getStockAmount());
			stock.setStockAmount(stock.getStockAmount() - order.getStockAmount());
		}
		ceo.setInputBuffer(0, "Typ");
		ceo.setInputBuffer(1, fleet.get(0));
		ceo.setInputBuffer(5, fleet);
		updateCEO();
		ceo.process();

	}
	
	public void updateCEO() throws AbleException{
		ceo.setInputBuffer(2, wood);
		ceo.setInputBuffer(3, diamonds);
		ceo.setInputBuffer(4, uran);
	}
	
	public void buyShips() throws AbleException{
		Spaceship ship1 = new Spaceship("Stateczek", 100, this);
		Spaceship ship2 = new Spaceship("Drugi", 60, this);
		Spaceship ship3 = new Spaceship("Trzeci", 70, this);
		fleet.addElement(ship1);
		fleet.addElement(ship2);
		fleet.addElement(ship3);		
	}
	
	public void setPlanets(Vector<Planet> planets){
		planetList = planets;
		location = planets.get(0);
	}
	
	public void receiveLoading(String loadingType, int amount) throws InterruptedException{
		if (loadingType == "wood"){
			wood.addAmount(amount);
			System.out.println("Nowy stan drewna" + wood.getStockAmount());
		} else if (loadingType == "diamonds"){
			diamonds.addAmount(amount);
		} else if (loadingType == "uran") {
			uran.addAmount(amount);
		}
	}
	
	
	
	
	
	public static class OfferMessage {
		private String type;
		private Integer amount;
		private SpaceCorp corpo;
		
		public OfferMessage(String type, Integer amount, SpaceCorp corpo) {
			super();
			this.type = type;
			this.amount = amount;
			this.corpo = corpo;
		}
		
		public String getText() {
			return type;
		}
		
		public Integer getAmount() {
			return amount;
		}

		public SpaceCorp getCorpo() {
			return corpo;
		}
		
		
	}
}
