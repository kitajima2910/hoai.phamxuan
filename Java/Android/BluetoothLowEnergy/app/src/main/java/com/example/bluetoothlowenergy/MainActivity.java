package com.example.bluetoothlowenergy;

import android.Manifest;
import android.annotation.TargetApi;
import android.app.Activity;
import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothGatt;
import android.bluetooth.BluetoothGattCallback;
import android.bluetooth.BluetoothGattCharacteristic;
import android.bluetooth.BluetoothGattService;
import android.bluetooth.BluetoothManager;
import android.bluetooth.BluetoothProfile;
import android.bluetooth.le.BluetoothLeScanner;
import android.bluetooth.le.ScanCallback;
import android.bluetooth.le.ScanFilter;
import android.bluetooth.le.ScanResult;
import android.bluetooth.le.ScanSettings;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import java.util.ArrayList;
import java.util.List;

@TargetApi(21)
public class MainActivity extends AppCompatActivity {

    private static final String TAG = "PXH-" + MainActivity.class.getSimpleName();

    // Bắt đầu: Khai bao các thành phần
    private Button btnStartScan;
    // Kết thúc: Khai bao các thành phần

    private BluetoothAdapter bluetoothAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Ánh xạ vào .xml
        btnStartScan = findViewById(R.id.btnStartScan);

        bluetoothAdapter = BluetoothAdapter.getDefaultAdapter();

        // Bắt đầu: Tìm các thiết bị
        btnStartScan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                bluetoothAdapter.startLeScan(leScanCallback);
            }
        });
        // Kết thúc: Tìm các thiết bị
    }

    private BluetoothAdapter.LeScanCallback leScanCallback = new BluetoothAdapter.LeScanCallback() {
        @Override
        public void onLeScan(final BluetoothDevice device, final int rssi, final byte[] scanRecord) {
            // Handle discovered devices here
            Log.d(TAG, "leScanCallback: " + device.getName() + " : " + device.getAddress() + " : " + rssi + " : " + scanRecord.toString());
        }
    };
}