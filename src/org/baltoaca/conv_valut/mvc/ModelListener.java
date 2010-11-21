package org.baltoaca.conv_valut.mvc;

/**
 * Any class that implements this interface needs to override
 * <code>hashCode()</code> and <code>equals()</code>
 * 
 * @author VlaD
 * 
 */
public interface ModelListener {

	public void update(Model m, Object obj);

}
