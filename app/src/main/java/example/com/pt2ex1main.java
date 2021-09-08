package example.com;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import android.Manifest;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.location.Location;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class pt2ex1main extends AppCompatActivity implements SensorEventListener {
    private SensorManager sensorManager;
    private Sensor light;
    private Sensor pressure;
    TextView lightValue;
    TextView pressureValue;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pt2ex1main);
        lightValue = (TextView)findViewById(R.id.light);
        pressureValue = (TextView)findViewById(R.id.pressure);
        sensorManager = (SensorManager) getSystemService(SENSOR_SERVICE);
        light = sensorManager.getDefaultSensor(Sensor.TYPE_LIGHT);
        pressure = sensorManager.getDefaultSensor(Sensor.TYPE_PRESSURE);
        if(light != null)
        {
            sensorManager.registerListener(this, light,
                    SensorManager.SENSOR_DELAY_NORMAL);
        }else
        {
            lightValue.setText("Light sensor not supported");
        }
        if(light != null)
        {
            sensorManager.registerListener(this, pressure,
                    SensorManager.SENSOR_DELAY_NORMAL);
        }else
        {
            pressureValue.setText("Pressure sensor not supported");
        }



        Button getGPSBtn = findViewById(R.id.getGPSBtn);
        ActivityCompat.requestPermissions(this, new
                String[]{Manifest.permission.ACCESS_FINE_LOCATION}, 123);
        getGPSBtn.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                GPSTracker g = new GPSTracker(getApplicationContext());
                Location l = g.getLocation();
                if(l!=null)
                {
                    double lat = l.getLatitude();
                    double longi = l.getLongitude();
                    Toast.makeText(getApplicationContext(), "LAT: "+lat + "LONG: " +
                            longi, Toast.LENGTH_LONG).show();
                }
            }
        });
    }
    public void onAccuracyChanged(Sensor sensor, int accuracy) {
    }
    public void onSensorChanged(SensorEvent event) {
        Sensor sensor = event.sensor;
        if(sensor.getType() == Sensor.TYPE_LIGHT)
        {
            lightValue.setText("Light Intensity: " + event.values[0]);
        }
        else if(sensor.getType() == Sensor.TYPE_PRESSURE)
        {
            pressureValue.setText("Pressure: " + event.values[0]);
        }
    }

}