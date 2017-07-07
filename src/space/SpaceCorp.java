package space;

import com.ibm.able.Able;
import com.ibm.able.AbleDefaultAgent;
import com.ibm.able.AbleEvent;
import com.ibm.able.AbleException;


public class SpaceCorp extends AbleDefaultAgent{

	private static final long serialVersionUID = 1L;
	
	private Stock stock;
	private String name;
	
	
	public SpaceCorp(String name) throws AbleException{
		super("SpaceCorp");
		inputBuffer = new Object[1];
		stock = new Stock("wood", 50);
		this.name = name;
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
		System.out.println(stock.getType());
		OfferMessage ofr = new OfferMessage("wood", 50, this);
		notifyAbleEventListeners(new AbleEvent(this, ofr));
		processBufferConnections();
		Stock order = (Stock)getInputBuffer(0);
		if (order != null){
			System.out.println("Zamówienie: " + order.getType() + " " + order.getStockAmount());
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
