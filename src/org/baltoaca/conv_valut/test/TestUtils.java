package org.baltoaca.conv_valut.test;

import static org.junit.Assert.fail;

public class TestUtils {

	protected static void failBecauseOfUnexpectedExeption(Exception e) {
		fail("Unexpected "+e);
	}

}
