package example.com;

import androidx.appcompat.app.AppCompatActivity;
import android.widget.TextView;
import android.os.Bundle;

public class pt1ex2sec extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);
        TextView ed1 = findViewById(R.id.textView4);
        String dato = getIntent().getStringExtra("data");
        ed1.setText(dato);
    }
}