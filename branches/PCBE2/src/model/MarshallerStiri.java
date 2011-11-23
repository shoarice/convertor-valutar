package model;

import javax.jms.JMSException;
import javax.jms.Session;
import javax.jms.TextMessage;

public class MarshallerStiri {
	
	private Session session;

	public MarshallerStiri(Session session){
		this.session = session;
	}
	
	public TextMessage marshall(Stire stire) throws JMSException{
		TextMessage txtMsg = session.createTextMessage();
		txtMsg.setText(stire.getStire());
		txtMsg.setStringProperty("autor", stire.getAutor());
		txtMsg.setStringProperty("sursa", stire.getSursa());
		txtMsg.setStringProperty("creat", stire.getDataCreat());
		txtMsg.setStringProperty("modificat", stire.getDataModificat());
		txtMsg.setLongProperty("stireId", stire.getStireId());
		txtMsg.setIntProperty("autorId", stire.getAutorId());
		txtMsg.setStringProperty("titlu", stire.getTitlu());
		return txtMsg;
	}
}
