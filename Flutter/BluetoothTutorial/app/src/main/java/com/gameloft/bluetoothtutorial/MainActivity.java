package com.gameloft.bluetoothtutorial;

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
import android.widget.Button;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = MainActivity.class.getSimpleName();

    private static final int REQUEST_ACCESS_FINE_LOCATION_PERMISSION = 1;
    private static final int REQUEST_BLUETOOTH_CONNECT_PERMISSION = 2;
    private static final int REQUEST_BLUETOOTH_SCAN_PERMISSION = 3;

    private static boolean flagDiscovering = false;


    BluetoothAdapter bluetoothAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Yêu cầu quyền BLUETOOTH_CONNECT
        requestBluetoothConnectPermission();

        bluetoothAdapter = BluetoothAdapter.getDefaultAdapter();

        Button btnONOFF = findViewById(R.id.btnONOFF);
        btnONOFF.setOnClickListener(v -> {
            checkBluetoothStatus();
        });

        IntentFilter filter = new IntentFilter(BluetoothDevice.ACTION_FOUND);
        registerReceiver(receiver, filter);

        Button btnDiscovery = findViewById(R.id.btnDiscovery);
        btnDiscovery.setOnClickListener(v -> {
            Log.d("PXH", "btnDiscovery: đã nhấn");
            if (ActivityCompat.checkSelfPermission(this, Manifest.permission.BLUETOOTH_SCAN) == PackageManager.PERMISSION_GRANTED) {
                if (flagDiscovering) {
                    Log.d("PXH", "btnDiscovery: kết thúc chạy");
                    flagDiscovering = false;
                    bluetoothAdapter.cancelDiscovery();
                } else {
                    Log.d("PXH", "btnDiscovery: đang chạy");
                    flagDiscovering = true;
                    bluetoothAdapter.startDiscovery();
                }
            }
        });

    }

    @Override
    public void onRequestPermissionsResult(int requestCode,
                                           @NonNull String[] permissions,
                                           @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);

        if (requestCode == REQUEST_BLUETOOTH_CONNECT_PERMISSION) {
            if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                // Quyền ACCESS_FINE_LOCATION được cấp
                // Yêu cầu quyền ACCESS_FINE_LOCATION
                requestAccessFineLocationPermission();
            } else {
                // Quyền BLUETOOTH bị từ chối
                // Xử lý trường hợp này
                Toast.makeText(this, "Ứng dụng cần quyền truy cập Bluetooth để có thể kết nối", Toast.LENGTH_SHORT).show();
                requestBluetoothConnectPermission();
            }
        } else if (requestCode == REQUEST_ACCESS_FINE_LOCATION_PERMISSION) {
            if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                // Quyền ACCESS_FINE_LOCATION được cấp
                // Thực hiện tác vụ cần quyền ACCESS_FINE_LOCATION
                requestBluetoothScanPermission();
            } else {
                // Quyền ACCESS_FINE_LOCATION bị từ chối
                // Xử lý trường hợp này
                Toast.makeText(this, "Ứng dụng cần quyền truy cập vị trí để tìm thiết bị Bluetooth", Toast.LENGTH_SHORT).show();
                requestAccessFineLocationPermission();
            }
        } else if (requestCode == REQUEST_BLUETOOTH_SCAN_PERMISSION) {
            if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                // Quyền BLUETOOTH_SCAN được cấp
                // Thực hiện tác vụ cần quyền BLUETOOTH_SCAN
            } else {
                // Quyền BLUETOOTH_SCAN bị từ chối
                // Xử lý trường hợp này
                requestBluetoothConnectPermission();
                requestAccessFineLocationPermission();
            }
        }
    }

    private void checkBluetoothStatus() {
        if (bluetoothAdapter == null) {
            Toast.makeText(this, "Thiết bị không hỗ trợ Bluetooth...", Toast.LENGTH_LONG).show();
        } else if (!bluetoothAdapter.isEnabled()) {
            Toast.makeText(this, "Bluetooth chưa bật, yêu cầu bật nó nhé!", Toast.LENGTH_LONG).show();
            if (ActivityCompat.checkSelfPermission(this, Manifest.permission.BLUETOOTH_CONNECT) == PackageManager.PERMISSION_GRANTED) {
                bluetoothAdapter.enable();
            }
        } else {
            Toast.makeText(this, "Bluetooth đã được bật, giờ tắt nó nhé!", Toast.LENGTH_LONG).show();
            if (ActivityCompat.checkSelfPermission(this, Manifest.permission.BLUETOOTH_CONNECT) == PackageManager.PERMISSION_GRANTED) {
                bluetoothAdapter.disable();
            }
        }
    }

    private void requestAccessFineLocationPermission() {
        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION)
                != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(this,
                    new String[]{Manifest.permission.ACCESS_FINE_LOCATION},
                    REQUEST_ACCESS_FINE_LOCATION_PERMISSION);
        }
    }

    private void requestBluetoothConnectPermission() {
        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.BLUETOOTH_CONNECT)
                != PackageManager.PERMISSION_GRANTED) {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.S) {
                ActivityCompat.requestPermissions(this,
                        new String[]{Manifest.permission.BLUETOOTH_CONNECT},
                        REQUEST_BLUETOOTH_CONNECT_PERMISSION);
            }
        }
    }

    private void requestBluetoothScanPermission() {
        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.BLUETOOTH_SCAN)
                != PackageManager.PERMISSION_GRANTED) {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.S) {
                ActivityCompat.requestPermissions(this,
                        new String[]{Manifest.permission.BLUETOOTH_SCAN},
                        REQUEST_BLUETOOTH_SCAN_PERMISSION);
            }
        }
    }

    BroadcastReceiver receiver = new BroadcastReceiver() {
        @Override
        public void onReceive(Context context, Intent intent) {
            String action = intent.getAction();
            if (BluetoothDevice.ACTION_FOUND.equals(action)) {
                BluetoothDevice device = intent.getParcelableExtra(BluetoothDevice.EXTRA_DEVICE);
                // Xử lý thiết bị tìm thấy ở đây
                String deviceName = device.getName();
                String deviceHardwareAddress = device.getAddress(); // MAC address
                Log.d("PXH", deviceName + " - " + deviceHardwareAddress);
            }
        }
    };

}