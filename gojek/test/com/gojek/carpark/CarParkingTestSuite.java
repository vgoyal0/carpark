package test.com.gojek.carpark;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Suite.class)
@Suite.SuiteClasses({ CarTest.class, MultiLevelCarParkingLotTest.class, CommandFactoryTest.class })
public class CarParkingTestSuite {

}
