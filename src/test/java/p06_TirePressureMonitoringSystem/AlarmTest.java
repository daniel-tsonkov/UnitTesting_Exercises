package p06_TirePressureMonitoringSystem;

import org.junit.Assert;
import org.junit.Test;

public class AlarmTest {
    //presure is between 17 and 21
    @Test
    public void testPresureBetwen17And21() {
        Sensor sensor = new Sensor();
        Alarm alarm = new Alarm(sensor);

        alarm.check();

        Assert.assertFalse(alarm.getAlarmOn());
    }
}
