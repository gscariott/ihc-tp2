package example.com;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.content.Intent;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.widget.TextView;
public class pt1ex3main extends AppCompatActivity implements SensorEventListener{

    private SensorManager mSensorManager;
    private Sensor mAccelerometer;
    TextView coordinate;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        mSensorManager = (SensorManager)getSystemService(SENSOR_SERVICE);
        mAccelerometer = mSensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pt1ex3main);

    }
    @Override
    protected void onResume() {
        super.onResume();
        mSensorManager.registerListener((SensorEventListener) this, mAccelerometer, SensorManager.SENSOR_DELAY_NORMAL);
    }
    @Override
    protected void onPause() {
        super.onPause();
        mSensorManager.unregisterListener((SensorEventListener) this);
    }

    public void onSensorChanged(SensorEvent event) {
        if(event.sensor.getType()== Sensor.TYPE_ACCELEROMETER) {
            float sensorX = event.values[0];
            float sensorY = event.values[1];
            float sensorZ = event.values[2];
            TextView coordinateX = findViewById(R.id.et1);
            TextView coordinateY = findViewById(R.id.et2);
            TextView coordinateZ = findViewById(R.id.et3);
            coordinateX.setText(String.valueOf(sensorX));
            coordinateY.setText(String.valueOf(sensorY));
            coordinateZ.setText(String.valueOf(sensorZ));

            if ((Math.abs(sensorX) > 10 ) || (Math.abs(sensorY) > 10) ) {
                Intent i = new Intent(this, pt1ex3sec.class);
                startActivity(i);
            }
        }
    }

    public void onAccuracyChanged(Sensor sensor, int accuracy)
    {
    }
}
