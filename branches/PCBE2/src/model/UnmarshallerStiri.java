package model;

import javax.jms.JMSException;
import javax.jms.TextMessage;

public class UnmarshallerStiri {

	public Stire unmarshall(TextMessage txtMsg) throws JMSException{
		
		Stire stire = new Stire();
		stire.setStire(txtMsg.getText());
		stire.setAutor(txtMsg.getStringProperty("autor"));
		stire.setSursa(txtMsg.getStringProperty("sursa"));
		stire.setDataCreat(txtMsg.getStringProperty("creat"));
		stire.setDataModificat(txtMsg.getStringProperty("modificat"));
		stire.setAutorId(txtMsg.getIntProperty("autorId"));
		stire.setStireId(txtMsg.getIntProperty("stireId"));
		return stire;
	}
}
