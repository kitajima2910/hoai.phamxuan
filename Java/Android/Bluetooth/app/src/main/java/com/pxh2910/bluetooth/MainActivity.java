package com.pxh2910.bluetooth;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

import android.os.Handler;
import android.os.Looper;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "Kitajima-" + MainActivity.class.getSimpleName();

    // Khai báo các request code cho các permission
    private static final int REQUEST_CODE_BLUETOOTH_CONNECT_PERMISSION = 1;
    private static final int REQUEST_CODE_BLUETOOTH_SCAN_PERMISSION = 2;
    private static final int REQUEST_CODE_ACCESS_FINE_LOCATION_PERMISSION = 3;

    // Khai báo các components
    private Button btnOnBluetooth;
    private Button btnOffBluetooth;
    private Button btnOpenScanBluetooth;
    private Button btnScanBluetooth;
    private ListView lvShowDevices;
    private TextView tvStatusScan;


    // Khai báo Bluetooth
    private BluetoothAdapter bluetoothAdapter;
    public ArrayList<BluetoothDevice> bluetoothDevices;
    public DeviceListAdapter deviceListAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Ánh xạ components tới xml
        btnOnBluetooth = findViewById(R.id.btnOnBluetooth);
        btnOffBluetooth = findViewById(R.id.btnOffBluetooth);
        btnOpenScanBluetooth = findViewById(R.id.btnOpenScanBluetooth);
        btnScanBluetooth = findViewById(R.id.btnScanBluetooth);
        lvShowDevices = findViewById(R.id.lvShowDevices);
        tvStatusScan = findViewById(R.id.tvStatusScan);

        // Tạo mảng cho BluetoothDevives
        bluetoothDevices = new ArrayList<>();

        // Lấy dữ liệu cho BluetoothAdapter
        bluetoothAdapter = BluetoothAdapter.getDefaultAdapter();

        // Yêu cầu các quyền
//        checkBTPermissions();
        requestBluetoothConnectPermission();

        // Bật Bluetooth
        onBluetooth();

        // Tắt Bluetooth
        offBluetooth();

        // Mở quét Bluetooth
        btnOpenScanBluetooth.setEnabled(false);
//        openScanBluetooth();

        // Quét Bluetooth
        scanBluetooth();

    }


    // Bật Bluetooth
    private void onBluetooth() {
        btnOnBluetooth.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(bluetoothAdapter == null) {
                    Toast.makeText(MainActivity.this, "Bluetooth không hỗ trợ thiết bị này", Toast.LENGTH_LONG).show();
                }

                if(!bluetoothAdapter.isEnabled()) {
                    Toast.makeText(MainActivity.this, "Bluetooth đang tắt, bạn có muốn bật không", Toast.LENGTH_LONG).show();
                    Log.d(TAG, "onBluetooth: bật Bluetooth");
                    bluetoothAdapter.enable();

                    IntentFilter intentFilter = new IntentFilter(BluetoothAdapter.ACTION_STATE_CHANGED);
                    registerReceiver(broadcastReceiverActionStateChanged, intentFilter);
                }
            }
        });
    }

    // Tắt Bluetooth
    private void offBluetooth() {
        btnOffBluetooth.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(bluetoothAdapter == null) {
                    Toast.makeText(MainActivity.this, "Bluetooth không hỗ trợ thiết bị này", Toast.LENGTH_LONG).show();
                }

                if(bluetoothAdapter.isEnabled()) {
                    Toast.makeText(MainActivity.this, "Bluetooth đang bật, bạn có muốn tắt không", Toast.LENGTH_LONG).show();
                    Log.d(TAG, "offBluetooth: tắt Bluetooth");
                    bluetoothAdapter.disable();

                    IntentFilter intentFilter = new IntentFilter(BluetoothAdapter.ACTION_STATE_CHANGED);
                    registerReceiver(broadcastReceiverActionStateChanged, intentFilter);
                }
            }
        });
    }

    // Mở quét Bluetooth
    private void openScanBluetooth() {
        btnOpenScanBluetooth.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d(TAG, "openScanBluetooth: Làm cho thiết bị có thể được phát hiện trong 300 giây.");

                Intent intent = new Intent(BluetoothAdapter.ACTION_REQUEST_DISCOVERABLE);
                intent.putExtra(BluetoothAdapter.EXTRA_DISCOVERABLE_DURATION, 300);
                startActivity(intent);

                IntentFilter intentFilter = new IntentFilter(BluetoothAdapter.ACTION_SCAN_MODE_CHANGED);
                registerReceiver(broadcastReceiverActionScanModeChanged, intentFilter);
            }
        });
    }

    private void scanBluetooth() {
        btnScanBluetooth.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Quét lại từ đầu
                bluetoothDevices.clear();

                // Mở quét Bluetooth
//                {
//                    Log.d(TAG, "scanBluetooth: Làm cho thiết bị có thể được phát hiện trong 300 giây.");
//
//                    Intent intent = new Intent(BluetoothAdapter.ACTION_REQUEST_DISCOVERABLE);
//                    intent.putExtra(BluetoothAdapter.EXTRA_DISCOVERABLE_DURATION, 300);
//                    startActivity(intent);
//
//                    IntentFilter intentFilter = new IntentFilter(BluetoothAdapter.ACTION_SCAN_MODE_CHANGED);
//                    registerReceiver(broadcastReceiverActionScanModeChanged, intentFilter);
//                }

                Log.d(TAG, "scanBluetooth: đang tìm kiếm các thiết bị xung quanh");
                if(bluetoothAdapter.isDiscovering()) {
                    bluetoothAdapter.cancelDiscovery();
                    Log.d(TAG, "scanBluetooth: huỷ trước khi quét tiếp");

                    // Kiểm tra xem có quyền quét chưa
//                    checkBTPermissions();
//                    requestBluetoothConnectPermission();

                    bluetoothAdapter.startDiscovery();
                    IntentFilter intentFilter = new IntentFilter(BluetoothDevice.ACTION_FOUND);
                    registerReceiver(broadcastReceiverActionFound, intentFilter);
                }

                if(!bluetoothAdapter.isDiscovering()) {

                    // Kiểm tra xem có quyền quét chưa
//                    checkBTPermissions();
//                    requestBluetoothConnectPermission();

                    bluetoothAdapter.startDiscovery();
                    IntentFilter intentFilter = new IntentFilter(BluetoothDevice.ACTION_FOUND);
                    registerReceiver(broadcastReceiverActionFound, intentFilter);
                }
            }
        });
    }

    // Tạo một BroadcastReceiver cho ACTION_STATE_CHANGED
    private final BroadcastReceiver broadcastReceiverActionStateChanged = new BroadcastReceiver() {
        @Override
        public void onReceive(Context context, Intent intent) {
            String action = intent.getAction();

            if(action.equals(BluetoothAdapter.ACTION_STATE_CHANGED)) {
                final int state = intent.getIntExtra(BluetoothAdapter.EXTRA_STATE, BluetoothAdapter.ERROR);

                switch (state) {
                    case BluetoothAdapter.STATE_OFF:
                        Log.d(TAG, "broadcastReceiverActionStateChanged: trạng thái tắt");
                        break;
                    case BluetoothAdapter.STATE_TURNING_OFF:
                        Log.d(TAG, "broadcastReceiverActionStateChanged: trạng thái đang tắt");
                        break;
                    case BluetoothAdapter.STATE_ON:
                        Log.d(TAG, "broadcastReceiverActionStateChanged: trạng thái bật");
                        break;
                    case BluetoothAdapter.STATE_TURNING_ON:
                        Log.d(TAG, "broadcastReceiverActionStateChanged: trạng thái đang bật");
                        break;
                }
            }
        }
    };

    // Tạo một BroadcastReceiver cho ACTION_SCAN_MODE_CHANGED
    private final BroadcastReceiver broadcastReceiverActionScanModeChanged = new BroadcastReceiver() {
        @Override
        public void onReceive(Context context, Intent intent) {
            String action = intent.getAction();

            if(action.equals(BluetoothAdapter.ACTION_SCAN_MODE_CHANGED)) {
                final int mode = intent.getIntExtra(BluetoothAdapter.EXTRA_SCAN_MODE, BluetoothAdapter.ERROR);

                switch (mode) {
                    case BluetoothAdapter.SCAN_MODE_CONNECTABLE_DISCOVERABLE:
                        Log.d(TAG, "broadcastReceiverActionScanModeChanged: chế độ quét có thể kết nối");
                        break;
                    case BluetoothAdapter.SCAN_MODE_CONNECTABLE:
                        Log.d(TAG, "broadcastReceiverActionScanModeChanged: chế độ quét kết nối");
                        break;
                    case BluetoothAdapter.SCAN_MODE_NONE:
                        Log.d(TAG, "broadcastReceiverActionScanModeChanged: chế độ quét không có");
                        break;
                    case BluetoothAdapter.STATE_CONNECTING:
                        Log.d(TAG, "broadcastReceiverActionScanModeChanged: đang kết nối");
                        break;
                    case BluetoothAdapter.STATE_CONNECTED:
                        Log.d(TAG, "broadcastReceiverActionScanModeChanged: đã kết nối");
                        break;
                }
            }
        }
    };

    // Tạo một BroadcastReceiver cho ACTION_FOUND
    private final BroadcastReceiver broadcastReceiverActionFound = new BroadcastReceiver() {
        @Override
        public void onReceive(Context context, Intent intent) {
            final String action = intent.getAction();

            if(action.equals(BluetoothDevice.ACTION_FOUND)) {
                BluetoothDevice device = intent.getParcelableExtra(BluetoothDevice.EXTRA_DEVICE);
                Log.d(TAG, "broadcastReceiverActionFound: " + device.getName() + ":" + device.getAddress());
                if(device.getName() != null) {
                    bluetoothDevices.add(device);
                    deviceListAdapter = new DeviceListAdapter(context, R.layout.device_adapter_view, bluetoothDevices);
                    lvShowDevices.setAdapter(deviceListAdapter);
                }
            }
        }
    };

    @Override
    protected void onDestroy() {
        super.onDestroy();

        Log.d(TAG, "onDestroy: huỷ");
        
        // Huỷ BroadcastReceiver của ACTION_STATE_CHANGED
        unregisterReceiver(broadcastReceiverActionStateChanged);
        // Huỷ BroadcastReceiver của ACTION_SCAN_MODE_CHANGED
        unregisterReceiver(broadcastReceiverActionScanModeChanged);
        // Huỷ BroadcastReceiver của ACTION_FOUND
        unregisterReceiver(broadcastReceiverActionFound);
    }

    // Yêu cầu quyền Bluetooth connect
    private void requestBluetoothConnectPermission() {
        if(ContextCompat.checkSelfPermission(MainActivity.this, android.Manifest.permission.BLUETOOTH_CONNECT) != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(MainActivity.this, new String[]{ android.Manifest.permission.BLUETOOTH_CONNECT }, REQUEST_CODE_BLUETOOTH_CONNECT_PERMISSION);
        }
    }

    // Yêu cầu quyền Bluetooth scan
    private void requestBluetoothScanPermission() {
        if(ContextCompat.checkSelfPermission(MainActivity.this, android.Manifest.permission.BLUETOOTH_SCAN) != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(MainActivity.this, new String[]{ android.Manifest.permission.BLUETOOTH_SCAN }, REQUEST_CODE_BLUETOOTH_SCAN_PERMISSION);
        }
    }

    // Yêu cầu quyền Bluetooth scan permission
    private void requestAccessFineLocationPermission() {
        if(ContextCompat.checkSelfPermission(MainActivity.this, android.Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(MainActivity.this, new String[]{ Manifest.permission.ACCESS_FINE_LOCATION }, REQUEST_CODE_ACCESS_FINE_LOCATION_PERMISSION);
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);

        if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
            switch (requestCode) {
                case REQUEST_CODE_BLUETOOTH_CONNECT_PERMISSION:
                    requestAccessFineLocationPermission();
                    break;
                case REQUEST_CODE_ACCESS_FINE_LOCATION_PERMISSION:
                    requestBluetoothScanPermission();
                    break;
                case REQUEST_CODE_BLUETOOTH_SCAN_PERMISSION:
                    requestBluetoothConnectPermission();
                    break;
            }
        }
    }

    /**
     * This method is required for all devices running API23+
     * Android must programmatically check the permissions for bluetooth. Putting the proper permissions
     * in the manifest is not enough.
     *
     * NOTE: This will only execute on versions > LOLLIPOP because it is not needed otherwise.
     */
    private void checkBTPermissions() {
        if(Build.VERSION.SDK_INT > Build.VERSION_CODES.LOLLIPOP){
            int permissionCheck = this.checkSelfPermission("Manifest.permission.ACCESS_FINE_LOCATION");
            permissionCheck += this.checkSelfPermission("Manifest.permission.ACCESS_COARSE_LOCATION");
            if (permissionCheck != 0) {

                this.requestPermissions(new String[]{Manifest.permission.ACCESS_FINE_LOCATION, Manifest.permission.ACCESS_COARSE_LOCATION}, 1001); //Any number
            }
        }else{
            Log.d(TAG, "checkBTPermissions: Không cần kiểm tra quyền. SDK version < LOLLIPOP.");
        }
    }

}