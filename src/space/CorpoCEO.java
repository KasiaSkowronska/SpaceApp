package space;

import com.ibm.able.Able;
import com.ibm.able.AbleException;
import com.ibm.able.agents.AbleRuleAgentImpl;

public class CorpoCEO extends AbleRuleAgentImpl{


	private static final long serialVersionUID = 1L;

	public CorpoCEO(String name) throws AbleException {
		super(name);
		this.setBehaviorRuleSetFileName("rules/CEOrules.arl");
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
		setSleepTime(2000);
		setTimerEventProcessingEnabled(true); // przetwarzanie eventow z timera
        setAbleEventProcessingEnabled(Able.ProcessingEnabled_PostingEnabled); // wazne, publikowanie eventow 
	}

}
