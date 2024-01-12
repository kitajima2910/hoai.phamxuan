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
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = MainActivity.class.getSimpleName();

    private static final int REQUEST_ACCESS_FINE_LOCATION_PERMISSION = 1;
    private static final int REQUEST_BLUETOOTH_CONNECT_PERMISSION = 2;
    private static final int REQUEST_BLUETOOTH_SCAN_PERMISSION = 3;

    private static boolean flagDiscovering = false;
    private ListView lvShowDevice;
    private ArrayList<String> listDevices;


    BluetoothAdapter bluetoothAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Ánh xạ tới layout xml
        lvShowDevice = findViewById(R.id.lvShowDevice);

        // Khởi tạo danh sách chứa tên bluetooth scan được
        listDevices = new ArrayList<>();

        // Yêu cầu quyền BLUETOOTH_CONNECT
        requestBluetoothConnectPermission();

        bluetoothAdapter = BluetoothAdapter.getDefaultAdapter();

        Button btnONOFF = findViewById(R.id.btnONOFF);
        btnONOFF.setOnClickListener(v -> {
            checkBluetoothStatus();
        });

        // Đăng ký bộ thu phát hiện thiết bị
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

                    // Clear list trước khi thêm lại thông tin bluetooth scan
                    listDevices.clear();
                    updateListView(this, listDevices, lvShowDevice);

                    bluetoothAdapter.startDiscovery();
                }
            }
        });


        TextView txtBluetoothOnOff = findViewById(R.id.txtBluetoothOnOff);
        // Tạo một luồng để kiểm tra xem Bluetooth đang bât hay không
        new Thread(() -> {
            // Liên tục kiểm tra xem Bluetooth đang bât hay không
            while (true) {
                if (bluetoothAdapter.isEnabled()) {
                    // Bluetooth đang bât
                    txtBluetoothOnOff.setText("Bluetooth đang bật: có");
                } else {
                    // Bluetooth không bât
                    txtBluetoothOnOff.setText("Bluetooth đang bật: không");
                }

                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    // Xử lý ngoại lệ
                }
            }
        }).start();

        TextView txtScanOnOff = findViewById(R.id.txtScanOnOff);
        // Tạo một luồng để kiểm tra xem Bluetooth đang bât hay không
        new Thread(() -> {
            // Liên tục kiểm tra xem Bluetooth đang bât hay không
            while (true) {
                if (bluetoothAdapter.isDiscovering()) {
                    // Bluetooth đang bât
                    txtScanOnOff.setText("Bluetooth đang quét: có");
                } else {
                    // Bluetooth không bât
                    txtScanOnOff.setText("Bluetooth đang quét: không");
                }

                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    // Xử lý ngoại lệ
                }
            }
        }).start();

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
                if(device.getName() != null) {
                    listDevices.add(device.getName() + "\n" + device.getAddress());
                }
                Log.d("PXH", deviceName + " - " + deviceHardwareAddress);
                // Thêm vào ListView
                updateListView(context, listDevices, lvShowDevice);
            }
        }
    };

    private void updateListView(Context context, List<String> listDevices, ListView lvShowDevice) {
        lvShowDevice.setAdapter(new ArrayAdapter<>(context, android.R.layout.simple_list_item_1, listDevices));
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        unregisterReceiver(receiver);
    }

}