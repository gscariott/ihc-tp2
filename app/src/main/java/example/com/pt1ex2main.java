package example.com;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class pt1ex2main extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
    }

    public void send(View view) {
        EditText et_1 = findViewById(R.id.editText3);
        Intent i = new Intent(this, pt1ex2sec.class);
        i.putExtra("data", et_1.getText().toString());
        startActivity(i);
    }
}