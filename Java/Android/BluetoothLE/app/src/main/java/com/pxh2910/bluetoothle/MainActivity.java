package com.pxh2910.bluetoothle;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothGattService;
import android.bluetooth.BluetoothManager;
import android.bluetooth.le.BluetoothLeScanner;
import android.bluetooth.le.ScanCallback;
import android.bluetooth.le.ScanResult;
import android.bluetooth.le.ScanSettings;
import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.widget.Button;
import android.widget.Toast;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "Kitajima-" + MainActivity.class.getSimpleName();

    // Start: request code
    private static final int REQUEST_CODE_BLUETOOTH_CONNECT_PERMISSION = 1;
    private static final int REQUEST_CODE_BLUETOOTH_SCAN_PERMISSION = 2;
    private static final int REQUEST_CODE_ACCESS_FINE_LOCATION_PERMISSION = 3;
    // End: request code

    // Start: Bluetooth
    private BluetoothAdapter bluetoothAdapter = BluetoothAdapter.getDefaultAdapter();;
    private BluetoothLeScanner bluetoothLeScanner;
    private boolean scanning;
    private Handler handler = new Handler();
    // Stops scanning after 10 seconds.
    private static final long SCAN_PERIOD = 10000;
    // End: Bluetooth

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Start: request permissions (request first)
        requestBluetoothConnectPermission();
        // End: request permissions (request first)

        Button btnOnOff = findViewById(R.id.btnOnOff);
        btnOnOff.setOnClickListener(v -> {
            checkBluetoothStatus();
        });

        Button btnScan = findViewById(R.id.btnScan);
        btnScan.setOnClickListener(v -> {
            if(bluetoothAdapter.isEnabled()) {
                bluetoothLeScanner = bluetoothAdapter.getBluetoothLeScanner();
                scanLeDevice();
            } else {
                Toast.makeText(MainActivity.this, "checkBluetoothStatus: Bluetooth chưa bật, yêu cầu bật nó nhé!", Toast.LENGTH_LONG).show();
                if (ActivityCompat.checkSelfPermission(this, Manifest.permission.BLUETOOTH_CONNECT) == PackageManager.PERMISSION_GRANTED) {
                    bluetoothAdapter.enable();
                }
            }
        });

        // Tạo một luồng để kiểm tra xem Bluetooth đang bât hay không
        new Thread(() -> {
            // Liên tục kiểm tra xem Bluetooth đang bât hay không
            while (true) {
                if (bluetoothAdapter.isEnabled()) {
                    // Bluetooth đang bât
                    btnOnOff.setText("Tắt Bluetooth");
                } else {
                    // Bluetooth không bât
                    btnOnOff.setText("Bật Bluetooth");
                }

                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    // Xử lý ngoại lệ
                }
            }
        }).start();

    }

    // Check Bluetooth status
    private void checkBluetoothStatus() {
        if (bluetoothAdapter == null) {
            Toast.makeText(MainActivity.this, "checkBluetoothStatus: Thiết bị không hỗ trợ Bluetooth...", Toast.LENGTH_LONG).show();
        } else if (!bluetoothAdapter.isEnabled()) {
            Toast.makeText(MainActivity.this, "checkBluetoothStatus: Bluetooth chưa bật, yêu cầu bật nó nhé!", Toast.LENGTH_LONG).show();
            if (ActivityCompat.checkSelfPermission(this, Manifest.permission.BLUETOOTH_CONNECT) == PackageManager.PERMISSION_GRANTED) {
                bluetoothAdapter.enable();
            }
        } else {
            Toast.makeText(MainActivity.this, "checkBluetoothStatus: Bluetooth đã được bật, giờ tắt nó nhé!", Toast.LENGTH_LONG).show();
            if (ActivityCompat.checkSelfPermission(this, Manifest.permission.BLUETOOTH_CONNECT) == PackageManager.PERMISSION_GRANTED) {
                bluetoothAdapter.disable();
            }
        }
    }

    // Request Bluetooth connect permission
    private void requestBluetoothConnectPermission() {
        if(ContextCompat.checkSelfPermission(MainActivity.this, Manifest.permission.BLUETOOTH_CONNECT) != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(MainActivity.this, new String[]{ Manifest.permission.BLUETOOTH_CONNECT }, REQUEST_CODE_BLUETOOTH_CONNECT_PERMISSION);
        } else {
            if(bluetoothAdapter != null && !bluetoothAdapter.isEnabled()) {
                checkBluetoothStatus();
            }
        }
    }

    // Request Bluetooth scan permission
    private void requestBluetoothScanPermission() {
        if(ContextCompat.checkSelfPermission(MainActivity.this, Manifest.permission.BLUETOOTH_SCAN) != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(MainActivity.this, new String[]{ Manifest.permission.BLUETOOTH_SCAN }, REQUEST_CODE_BLUETOOTH_SCAN_PERMISSION);
        }
    }

    // Request Bluetooth scan permission
    private void requestAccessFineLocationPermission() {
        if(ContextCompat.checkSelfPermission(MainActivity.this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
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
        } else {
            onRequestPermissionsResult(requestCode, permissions, grantResults);
        }

    }

    // Device scan callback.
    private ScanCallback leScanCallback =
            new ScanCallback() {
                @Override
                public void onScanResult(int callbackType, ScanResult result) {
                    super.onScanResult(callbackType, result);
                    Log.i(TAG, "onScanResult: " + result.getDevice().getName() + ":" + result.getDevice().getAddress());
                }
            };

    private void scanLeDevice() {
        if (!scanning) {
            // Stops scanning after a predefined scan period.
            handler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    scanning = false;
                    bluetoothLeScanner.stopScan(leScanCallback);
                }
            }, SCAN_PERIOD);

            scanning = true;
            bluetoothLeScanner.startScan(leScanCallback);
        } else {
            scanning = false;
            bluetoothLeScanner.stopScan(leScanCallback);
        }
    }

}