package dms.aut.ac.nz.dmsandroid;

import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Set;

public class BluetoothActivity extends AppCompatActivity {
    private BluetoothAdapter bluetoothAdapter;
    private ListView pairedDevicesList;
    final int REQUEST_ENABLE_BT = 1;
    final int REQUEST_DISCOVERABLE_BT = 2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bluetooth);

        pairedDevicesList = (ListView)findViewById(R.id.pairedDevicesList);
    }

    public void checkBluetoothSupport(View v)
    {
        bluetoothAdapter = BluetoothAdapter.getDefaultAdapter();
        if(bluetoothAdapter == null)
        {
            Toast.makeText(this, "No Bluetooth Support", Toast.LENGTH_SHORT).show();
        }else{
            Toast.makeText(this, "Bluetooth Adapter is obtained", Toast.LENGTH_SHORT).show();
        }
    }

    public void enableBluetoothSupport(View v){
        if(!bluetoothAdapter.isEnabled()){
            Intent enableBTIntent = new Intent(BluetoothAdapter.ACTION_REQUEST_ENABLE);
            startActivityForResult(enableBTIntent, REQUEST_ENABLE_BT);
        }else{
            Toast.makeText(this, "Bluetooth is already enabled", Toast.LENGTH_SHORT).show();
        }
    }

    protected void onActivityResult(int requestCode, int resultCode, Intent data){
        switch (requestCode){
            case REQUEST_ENABLE_BT:
                if(resultCode == RESULT_OK){
                    Toast.makeText(this, "Bluetooth is now enable", Toast.LENGTH_SHORT).show();
                }else{
                    Toast.makeText(this, "Bluetooth is not enabled", Toast.LENGTH_SHORT).show();
                }
                break;
            case REQUEST_DISCOVERABLE_BT:
                if(resultCode == 300){
                    Toast.makeText(this, "Bluetooth Device is now discoverable for " + resultCode,
                            Toast.LENGTH_SHORT).show();
                }else{
                    Toast.makeText(this, "Bluetooth Device is not discoverable", Toast.LENGTH_SHORT).show();
                }
                break;
        }
    }

    public void queryPairedDevices(View v){
        ArrayList<String> deviceList = new ArrayList<String>();
        if(bluetoothAdapter != null){
            Set<BluetoothDevice> pairedDevices = bluetoothAdapter.getBondedDevices();
            if(pairedDevices.size() > 0){
                for(BluetoothDevice device : pairedDevices){
                    String deviceName = device.getName();
                    String deviceAddress = device.getAddress();
                    deviceList.add(deviceName + ", " + deviceAddress);
                }
                ArrayAdapter deviceAdapter = new ArrayAdapter<String>(
                        this, R.layout.simplerow, deviceList);
                pairedDevicesList.setAdapter(deviceAdapter);
            }
        }else{
            Toast.makeText(this, "No Bluetooth Support", Toast.LENGTH_LONG).show();
        }
    }

    public void makeDeviceDiscoverable(View v){
        Intent discoverableIntent = new Intent(BluetoothAdapter.ACTION_REQUEST_DISCOVERABLE);
        discoverableIntent.putExtra(BluetoothAdapter.EXTRA_DISCOVERABLE_DURATION, 300);
        startActivityForResult(discoverableIntent, REQUEST_DISCOVERABLE_BT);
    }
}
