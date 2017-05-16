package dms.aut.ac.nz.dmsandroid;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    Button buttonForMessage;
    Button buttonForBluetooth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void buttonToGoToMessage(View v){
        buttonForMessage = (Button)findViewById(R.id.buttonForMessage);
        //Intent intent = new Intent()
    }

    public void buttonToGoToBluetooth(View v){
        buttonForBluetooth = (Button)findViewById(R.id.buttonForBluetooth);
    }
}
