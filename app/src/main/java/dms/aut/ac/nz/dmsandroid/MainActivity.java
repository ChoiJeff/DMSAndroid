package dms.aut.ac.nz.dmsandroid;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //test
    }

    public void buttonToGoToMessage(View v){
        Toast.makeText(this, "Made by Nishan", Toast.LENGTH_SHORT).show();

    }

    public void buttonToGoToBluetooth(View v){
        Intent intent = new Intent(this, BluetoothActivity.class);
        startActivity(intent);
    }
}
