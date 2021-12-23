package tr.gov.*****.*****esspkullanici;

import org.junit.platform.runner.JUnitPlatform;
import org.junit.platform.suite.api.SelectClasses;
import org.junit.runner.RunWith;
import tr.gov.*****.*****esspkullanici.service.SikayetServiceTest;

@RunWith(JUnitPlatform.class)
@SelectClasses({SikayetServiceTest.class})
public class UnitTestSuite {
}
