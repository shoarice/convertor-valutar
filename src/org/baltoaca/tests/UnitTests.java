package org.baltoaca.tests;

import org.baltoaca.tests.unit.TestIntervalWithResetToMaxIntegerValue;
import org.baltoaca.tests.unit.TestIntervalntegerValue;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({TestIntervalntegerValue.class, TestIntervalWithResetToMaxIntegerValue.class})
public class UnitTests {

}