package space;

import com.ibm.able.Able;
import com.ibm.able.AbleBufferConnection;
import com.ibm.able.AbleDefaultAgent;
import com.ibm.able.AbleEvent;
import com.ibm.able.AbleException;


public class Customer extends AbleDefaultAgent{

	private static final long serialVersionUID = 1L;
	
	private Stock need;
	
	public Customer() throws AbleException{
		super("Customer");
		outputBuffer = new Object[1];
		//outputBuffer = new Integer[1];
		need = new Stock("wood", 20);
		reset();
		init();
	}
	
	@Override
	public void init() throws AbleException {
		super.init(); // wazne, init uruchamia watek odpowiedzialny za przetwarzanie timera i eventow
	}
	
	@Override
	public void reset() throws AbleException {
		setDataFlowEnabled(true);
		//setSleepTime(2000);
		setTimerEventProcessingEnabled(true); // przetwarzanie eventow z timera
        setAbleEventProcessingEnabled(Able.ProcessingEnabled_PostingEnabled); // wazne, publikowanie eventow 
	}
	
	@Override
	public void processTimerEvent() throws AbleException {
		process();
		
	}

	@Override
	public void processAbleEvent(AbleEvent evt) throws AbleException {
		SpaceCorp.OfferMessage ofr = (SpaceCorp.OfferMessage) evt.getArgObject();
		SpaceCorp corpo = ofr.getCorpo();
		System.out.println(Thread.currentThread().getId() +": Oferta to:" + ofr.getText() + " " + ofr.getAmount() + " od: " + corpo.getName());
		buy(corpo);
		removeAllBufferConnections();
	}

	
	public void buy(SpaceCorp corpo) throws AbleException{
		new AbleBufferConnection(this, corpo);
		setOutputBuffer(0, need);
	}

}
