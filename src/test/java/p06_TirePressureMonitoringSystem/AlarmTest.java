package p06_TirePressureMonitoringSystem;

import org.junit.Assert;
import org.junit.Test;
import org.mockito.Mockito;

public class AlarmTest {
    //presure is between 17 and 21
    @Test
    public void testPresureBetwen17And21() {
        //for random generated value
        //Sensor sensor = new Sensor();

        //when we pick the value
        Sensor sensor = Mockito.mock(Sensor.class);
        Mockito.when(sensor.popNextPressurePsiValue()).thenReturn(20.1);
        Alarm alarm = new Alarm(sensor);

        alarm.check();

        //System.out.println(sensor.readPressureSample());
        Assert.assertFalse(alarm.getAlarmOn());
    }

    //presure is < 17
    @Test
    public void testPresureIsLessThan17() {
        //for random generated value
        //Sensor sensor = new Sensor();

        //when we pick the value
        Sensor sensor = Mockito.mock(Sensor.class);
        Mockito.when(sensor.popNextPressurePsiValue()).thenReturn(16.1);
        Alarm alarm = new Alarm(sensor);

        alarm.check();

        //System.out.println(sensor.readPressureSample());
        Assert.assertTrue(alarm.getAlarmOn());
    }

    //presure is > 21
    @Test
    public void testPresureIsMoreThan21() {
        //for random generated value
        //Sensor sensor = new Sensor();

        //when we pick the value
        Sensor sensor = Mockito.mock(Sensor.class);
        Mockito.when(sensor.popNextPressurePsiValue()).thenReturn(21.1);
        Alarm alarm = new Alarm(sensor);

        alarm.check();

        //System.out.println(sensor.readPressureSample());
        Assert.assertTrue(alarm.getAlarmOn());
    }
}
