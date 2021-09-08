package example.com;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;
import android.widget.EditText;
import android.widget.TextView;
import android.view.View;



public class pt1ex1 extends AppCompatActivity {

    private EditText et1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //et1 = (EditText) findViewById(R.id.editText1); // ID from component
        //Toast.makeText(this, "Value: " + et1.getText().toString(), Toast.LENGTH_SHORT).show();
        // The activity is created
    }
    @Override
    protected void onStart() {
        super.onStart();
        //Toast.makeText(this, "OnStart", Toast.LENGTH_SHORT).show();
        // The activity is about to become visible.
    }
    @Override
    protected void onResume() {
        super.onResume();
        //Toast.makeText(this, "OnResume", Toast.LENGTH_SHORT).show();
        //The activity has become visible (now it "resumes").
    }
    @Override
    protected void onPause() {
        super.onPause();
        //Toast.makeText(this, "OnPause", Toast.LENGTH_SHORT).show();
        // Focus on another activity (this activity is about to be "stopped").
    }
    @Override
    protected void onStop() {
        super.onStop();
        //Toast.makeText(this, "OnStop", Toast.LENGTH_SHORT).show();
        // The activity is no longer visible (now it is "stopped")
    }
    @Override
    protected void onDestroy() {
        super.onDestroy();
        //Toast.makeText(this, "OnDestroy", Toast.LENGTH_SHORT).show();
        // The activity is about to be destroyed.
    }

    public void sum(View view)
    {
        EditText et_1 = (EditText) findViewById(R.id.editText1);
        EditText et_2 = (EditText) findViewById(R.id.editText2);
        Float num_1 = Float.parseFloat(et_1.getText().toString());
        Float num_2 = Float.parseFloat(et_2.getText().toString());
        TextView result = (TextView) findViewById(R.id.tv_result);

        if(num_1 != null && num_2 != null) {
            result.setText(String.valueOf(num_1 + num_2));
        }


    }
}