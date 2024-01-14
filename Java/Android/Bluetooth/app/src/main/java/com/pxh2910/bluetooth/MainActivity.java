package com.pxh2910.bluetooth;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothServerSocket;
import android.bluetooth.BluetoothSocket;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.pm.PackageManager;
import android.graphics.Color;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.provider.Settings;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Set;
import java.util.UUID;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "Kitajima-" + MainActivity.class.getSimpleName();

    // Lấy danh sách các quyền cần yêu cầu
    private static final String[] PERMISSIONS = new String[]{
            Manifest.permission.BLUETOOTH_CONNECT,
            Manifest.permission.ACCESS_FINE_LOCATION,
            Manifest.permission.ACCESS_COARSE_LOCATION,
            Manifest.permission.BLUETOOTH_SCAN
    };

    // Tạo request code cho permission
    private static final int REQUEST_CODE_PERMISSION = 1;

    // Khai báo các components
    private Button btnOnBluetooth;
    private Button btnOffBluetooth;
    private Button btnOpenScanBluetooth;
    private Button btnScanBluetooth;
    private Button btnTestOpenScanBluetooth;
    private ListView lvShowDevices;
    private TextView tvStatusScan;
    private TextView tvStatus;
    private EditText etMSG;
    private Button btnSend;
    private TextView tvMSG;


    // Khai báo Bluetooth
    private BluetoothAdapter bluetoothAdapter;
    public ArrayList<BluetoothDevice> bluetoothDevices;
    public DeviceListAdapter deviceListAdapter;


    // Khai báo biến xử lý thêm
    private static String saveDevicegetAddress = "";

    private static final int STATE_LISTENING = 1;
    private static final int STATE_CONNECTING = 2;
    private static final int STATE_CONNECTED = 3;
    private static final int STATE_CONNECTION_FAILED = 4;
    private static final int STATE_MESSAGE_RECEIVED = 5;
    private static final String APP_NAME = "PXHBTChat";
    private static UUID MY_UUID;
    private SendReceive sendReceive;

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
        btnTestOpenScanBluetooth = findViewById(R.id.btnTestOpenScanBluetooth);
        tvStatus = findViewById(R.id.tvStatus);
        etMSG = findViewById(R.id.etMSG);
        btnSend = findViewById(R.id.btnSend);
        tvMSG = findViewById(R.id.tvMSG);

        tvStatus.setTextColor(Color.GREEN);

        // Tạo mảng cho BluetoothDevives
        bluetoothDevices = new ArrayList<>();

        // Lấy dữ liệu cho BluetoothAdapter
        bluetoothAdapter = BluetoothAdapter.getDefaultAdapter();
        // Lấy UUID của devices
        String m_androidId = Settings.Secure.getString(getContentResolver(), Settings.Secure.ANDROID_ID);
        MY_UUID = UUID.nameUUIDFromBytes(m_androidId.getBytes());
        Log.d(TAG, "onCreate MY_UUID: " + MY_UUID);

        // Yêu cầu các quyền
        checkAndrequestPermissions();

        // Mở quét Bluetooth
         openScanBluetooth();

        // Quét Bluetooth
        btnScanBluetooth.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!hasPermission(MainActivity.this, Manifest.permission.BLUETOOTH_SCAN)) {
                    checkAndrequestPermission(Manifest.permission.BLUETOOTH_SCAN);
                    return;
                }

                // Quét lại từ đầu
                bluetoothDevices.clear();

                Log.d(TAG, "scanBluetooth: đang tìm kiếm các thiết bị xung quanh");
                if(bluetoothAdapter.isDiscovering()) {
                    bluetoothAdapter.cancelDiscovery();
                    Log.d(TAG, "scanBluetooth: huỷ trước khi quét tiếp");

                    // Kiểm tra xem có quyền quét chưa
                    checkAndrequestPermissions();

                    bluetoothAdapter.startDiscovery();
                    IntentFilter intentFilter = new IntentFilter(BluetoothDevice.ACTION_FOUND);
                    registerReceiver(broadcastReceiverActionFound, intentFilter);
                }

                if(!bluetoothAdapter.isDiscovering()) {

                    // Kiểm tra xem có quyền quét chưa
                    checkAndrequestPermissions();

                    bluetoothAdapter.startDiscovery();
                    IntentFilter intentFilter = new IntentFilter(BluetoothDevice.ACTION_FOUND);
                    registerReceiver(broadcastReceiverActionFound, intentFilter);
                }
            }
        });

        // Bật Bluetooth
        btnOnBluetooth.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!hasPermission(MainActivity.this, Manifest.permission.BLUETOOTH_CONNECT)) {
                    checkAndrequestPermission(Manifest.permission.BLUETOOTH_CONNECT);
                    return;
                }

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

        // Tắt Bluetooth
        btnOffBluetooth.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!hasPermission(MainActivity.this, Manifest.permission.BLUETOOTH_CONNECT)) {
                    checkAndrequestPermission(Manifest.permission.BLUETOOTH_CONNECT);
                    return;
                }

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

        // Kiểm thử bonded
        btnTestOpenScanBluetooth.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d(TAG, "btnTestOpenScanBluetooth: đã nhấn");

                // Lắng nghe và mở Server Socket khi nhấn scan
                ServerClass serverClass = new ServerClass();
                serverClass.start();

//                Set<BluetoothDevice> devices = bluetoothAdapter.getBondedDevices();
//                String[] strings = new String[devices.size()];
//                ArrayList<BluetoothDevice> deviceArrayList = new ArrayList<>();
//                int index = 0;
//
//                Log.d(TAG, "btnTestOpenScanBluetooth devices: " + devices.size());
//                if(devices.size() > 0) {
//                    for(BluetoothDevice device : devices) {
//                        Log.d(TAG, "btnTestOpenScanBluetooth: " + device.getName());
//                        strings[index] = device.getName();
//                        index++;
//
//                        // Kiểm thử bluetoothAdapter.getBondedDevices()
//                        deviceArrayList.add(device);
//                    }
////                     ArrayAdapter<String> adapter = new ArrayAdapter<>(MainActivity.this, android.R.layout.simple_list_item_1, strings);
////                     lvShowDevices.setAdapter(adapter);
//
////                    deviceListAdapter = new DeviceListAdapter(MainActivity.this, R.layout.device_adapter_view, deviceArrayList);
////                    lvShowDevices.setAdapter(deviceListAdapter);
//                }
            }
        });

        // Chọn thiết bị Bluetooth cần kết nối
        lvShowDevices.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                // Huỷ tất cả các kết nối
                unpairAll();

                // Đăng ký cái BroadcastReceiverActionBondStateChanged
                IntentFilter intentFilter = new IntentFilter(BluetoothDevice.ACTION_BOND_STATE_CHANGED);
                registerReceiver(broadcastReceiverActionBondStateChanged, intentFilter);

                // Dừng quét Bluetooth
                bluetoothAdapter.cancelDiscovery();

                // Xử lý sự kiện click vào dòng ở vị trí "position"
                BluetoothDevice device = bluetoothDevices.get(position);
                ClientClass clientClass = new ClientClass(device);
                clientClass.start();
                tvStatus.setText("Đang kết nối");
                saveDevicegetAddress = device.getAddress();
                Log.d(TAG, "lvShowDevices: " + device.getName() + ":" + device.getAddress());
                Log.d(TAG, "Đang thử ghép với " + device.getName());
                device.createBond();
            }
        });

        // Huỷ kết nối đơn lẻ
        tvStatus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!saveDevicegetAddress.equals("")) {
                    BluetoothDevice device = bluetoothAdapter.getRemoteDevice(saveDevicegetAddress);
                    try {
                        Method method = device.getClass().getMethod("removeBond", (Class[]) null);
                        method.invoke(device, (Object[]) null);
                        saveDevicegetAddress = "";
                    } catch (Exception e) {
                        throw new RuntimeException(e);
                    }
                }
            }
        });

        // Gửi tin nhắn
        btnSend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String msg = String.valueOf(etMSG.getText());
                Log.d(TAG, "btnSend msg: " + msg);
                sendReceive.write(msg.getBytes());
            }
        });



        // Bắt đầu kiểm tra trạng thái Bluetooth
        handlerCheckBluetoothState.postDelayed(checkBluetoothState, 0);
        // Bắt đầu kiểm tra trạng thái quét Bluetooth
        handlerCheckScanBluetooth.postDelayed(checkScanBluetooth, 0);
    }

    // Xử lý các trạng thái lắng nghe
    Handler handler = new Handler(new Handler.Callback() {
        @Override
        public boolean handleMessage(@NonNull Message msg) {

            switch (msg.what) {
                case STATE_LISTENING:
                    tvStatus.setText("Đang lắng nghe");
                    break;
                case STATE_CONNECTING:
                    tvStatus.setText("Đang kết nối");
                    break;
                case STATE_CONNECTED:
                    tvStatus.setText("Đã kết nối");
                    break;
                case STATE_CONNECTION_FAILED:
                    tvStatus.setText("Kết nối lỗi");
                    break;
                case STATE_MESSAGE_RECEIVED:
                    byte[] readBuff = (byte[]) msg.obj;
                    String tempMSG = new String(readBuff, 0, msg.arg1);
                    tvMSG.setText(tempMSG);
                    break;
            }

            return true;
        }
    });
    // Kiểm tra trạng thái liên tục của Bluetooth
    private Handler handlerCheckBluetoothState = new Handler();

    private Runnable checkBluetoothState = new Runnable() {
        @Override
        public void run() {
            if (bluetoothAdapter != null) {
                if (bluetoothAdapter.isEnabled()) {
                    btnOnBluetooth.setEnabled(false);
                    btnOffBluetooth.setEnabled(true);
//                    btnOpenScanBluetooth.setEnabled(false);

                    // Vừa bật vừa quét
                    if(hasPermission(MainActivity.this, Manifest.permission.BLUETOOTH_SCAN)) {
                        if (bluetoothAdapter.isDiscovering()) {
                            btnScanBluetooth.setEnabled(false);
                        } else {
                            btnScanBluetooth.setEnabled(true);
                        }
                    }

                } else {
                    btnOnBluetooth.setEnabled(true);
                    btnOffBluetooth.setEnabled(false);
//                    btnOpenScanBluetooth.setEnabled(false);
                    btnScanBluetooth.setEnabled(false);

                    // Tắt quét Bluetooth
                    bluetoothAdapter.cancelDiscovery();

                }
            }
            handlerCheckBluetoothState.postDelayed(this, 0); // Kiểm tra lại sau 0 giây
        }
    };

    // Kiểm tra trạng thái liên tục quét của Bluetooth
    private Handler handlerCheckScanBluetooth = new Handler();

    private Runnable checkScanBluetooth = new Runnable() {
        @Override
        public void run() {
            if (bluetoothAdapter != null) {
                if(hasPermission(MainActivity.this, Manifest.permission.BLUETOOTH_SCAN)) {
                    if (bluetoothAdapter.isDiscovering()) {
                        btnScanBluetooth.setEnabled(false);
                        tvStatusScan.setText("Quét Bluetooth: Đang");
                    } else {
                        btnScanBluetooth.setEnabled(true);
                        tvStatusScan.setText("Quét Bluetooth: Không");
                    }
                }
            }
            handlerCheckScanBluetooth.postDelayed(this, 0);
        }
    };


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

    // Tạo một BroadcastReceiver cho ACTION_STATE_CHANGED
    private final BroadcastReceiver broadcastReceiverActionStateChanged = new BroadcastReceiver() {
        @Override
        public void onReceive(Context context, Intent intent) {
            Log.d(TAG, "onReceive: ACTION_STATE_CHANGED");
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
            Log.d(TAG, "onReceive: ACTION_SCAN_MODE_CHANGED");
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
            Log.d(TAG, "onReceive: ACTION_FOUND");
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

    // Tạo một BroadcastReceiver cho ACTION_BOND_STATE_CHANGED
    private final BroadcastReceiver broadcastReceiverActionBondStateChanged = new BroadcastReceiver() {
        @Override
        public void onReceive(Context context, Intent intent) {
            Log.d(TAG, "onReceive: ACTION_BOND_STATE_CHANGED");
            final String action = intent.getAction();

            if(action.equals(BluetoothDevice.ACTION_BOND_STATE_CHANGED)) {
                BluetoothDevice device = intent.getParcelableExtra(BluetoothDevice.EXTRA_DEVICE);

                if (device.getBondState() == BluetoothDevice.BOND_BONDED) {
                    Log.d(TAG, "broadcastReceiverActionBondStateChanged: BOND_BONDED");
                    tvStatus.setText("Đã kết nối: " + device.getName());
                    tvStatus.setTextColor(Color.RED);
                }

                if (device.getBondState() == BluetoothDevice.BOND_BONDING) {
                    Log.d(TAG, "broadcastReceiverActionBondStateChanged: BOND_BONDING");
                    tvStatus.setText("Đang kết nối: " + device.getName());
                    tvStatus.setTextColor(Color.YELLOW);
                }

                if (device.getBondState() == BluetoothDevice.BOND_NONE) {
                    Log.d(TAG, "broadcastReceiverActionBondStateChanged: BOND_NONE");
                    tvStatus.setText("Chưa kết nối");
                    tvStatus.setTextColor(Color.GREEN);
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
        // Huỷ BroadcastReceiver ACTION_BOND_STATE_CHANGED
        unregisterReceiver(broadcastReceiverActionBondStateChanged);

        // Huỷ handler checkBluetoothState
        handlerCheckBluetoothState.removeCallbacks(checkBluetoothState);
    }

    // Kiểm tra yêu cầu quyền có chưa
    private boolean hasPermission(Context context, String PERMISSION) {

        if (context != null && PERMISSION != null) {

            if (ActivityCompat.checkSelfPermission(context, PERMISSION) != PackageManager.PERMISSION_GRANTED) {
                return false;
            }
        }

        return true;
    }

    // Yêu cầu quyền
    private void checkAndrequestPermission(String PERMISSION) {
        if (!hasPermission(MainActivity.this, PERMISSION)) {

            ActivityCompat.requestPermissions(MainActivity.this, new String[] { PERMISSION }, REQUEST_CODE_PERMISSION);
        }
    }

    // Kiểm tra yêu cầu các quyền có chưa
    private boolean hasPermissions(Context context, String... PERMISSIONS) {

        if (context != null && PERMISSIONS != null) {

            for (String permission: PERMISSIONS){

                if (ActivityCompat.checkSelfPermission(context, permission) != PackageManager.PERMISSION_GRANTED) {
                    return false;
                }
            }
        }

        return true;
    }

    // Yêu cầu các quyền
    private void checkAndrequestPermissions() {
        if (!hasPermissions(MainActivity.this, PERMISSIONS)) {

            ActivityCompat.requestPermissions(MainActivity.this, PERMISSIONS, REQUEST_CODE_PERMISSION);
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);

        if (requestCode == REQUEST_CODE_PERMISSION) {

            for (int i = 0; i < grantResults.length; ++i) {
                if (grantResults[i] == PackageManager.PERMISSION_GRANTED) {
                    Toast.makeText(MainActivity.this, permissions[i].replaceAll("android.permission.", "") + " đã cho phép", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(MainActivity.this, permissions[i].replaceAll("android.permission.", "") + " không cho phép", Toast.LENGTH_SHORT).show();
                }
            }
        }
    }

    // Huỷ kết nối tất cả
    private void unpairAll() {
        Set<BluetoothDevice> pairedDevices = bluetoothAdapter.getBondedDevices();
        if (pairedDevices.size() > 0) {
            for (BluetoothDevice device : pairedDevices) {
                try {
                    Method method = device.getClass()
                            .getMethod("removeBond", (Class[]) null);
                    method.invoke(device, (Object[]) null);
                } catch (Exception e) {
                    Log.d(TAG, "unpairAll: huỷ kết nối bị lỗi");
                }
            }
        }
    }

    // Huỷ kết nối đơn
    private void unpairDevice(BluetoothDevice device) {
        try {
            Method m = device.getClass()
                    .getMethod("removeBond", (Class[]) null);
            m.invoke(device, (Object[]) null);
        } catch (Exception e) {
            Log.e(TAG, e.getMessage());
        }
    }

    // Server Thread
    private class ServerClass extends Thread {

        private BluetoothServerSocket serverSocket;

        public ServerClass() {
            try {
                serverSocket = bluetoothAdapter.listenUsingRfcommWithServiceRecord(APP_NAME, MY_UUID);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }

        public void run() {
            BluetoothSocket socket = null;

            while (socket == null) {
                try {
                    Message message = Message.obtain();
                    message.what = STATE_CONNECTING;
                    handler.sendMessage(message);

                    socket = serverSocket.accept();
                } catch (IOException e) {
                    e.printStackTrace();

                    Message message = Message.obtain();
                    message.what = STATE_CONNECTION_FAILED;
                    handler.sendMessage(message);
                }

                if (socket != null) {
                    Message message = Message.obtain();
                    message.what = STATE_CONNECTED;
                    handler.sendMessage(message);

                    // Viết vài dòng gửi / nhận tại đây
                    sendReceive = new SendReceive(socket);
                    sendReceive.start();

                    break;
                }
            }
        }

    }

    // Client Thread
    private class ClientClass extends Thread {

        private BluetoothDevice device;
        private BluetoothSocket socket;

        public ClientClass(BluetoothDevice device) {
            this.device = device;

            try {
                socket = this.device.createRfcommSocketToServiceRecord(MY_UUID);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        public void run() {
            try {
                socket.connect();

                sendReceive = new SendReceive(socket);
                sendReceive.start();

                Message message = Message.obtain();
                message.what = STATE_CONNECTED;
                handler.sendMessage(message);
            } catch (IOException e) {
                e.printStackTrace();
                Message message = Message.obtain();
                message.what = STATE_CONNECTION_FAILED;
                handler.sendMessage(message);
            }
        }

    }

    // Gửi nhận data
    private class SendReceive extends Thread {

        private final BluetoothSocket bluetoothSocket;
        private final InputStream inputStream;
        private final OutputStream outputStream;

        public SendReceive(BluetoothSocket bluetoothSocket) {
            this.bluetoothSocket = bluetoothSocket;
            InputStream tempIn = null;
            OutputStream tempOut = null;

            try {
                tempIn = this.bluetoothSocket.getInputStream();
                tempOut = this.bluetoothSocket.getOutputStream();
            } catch (IOException e) {
                e.printStackTrace();
            }

            inputStream = tempIn;
            outputStream = tempOut;

        }

        public void run() {
            byte[] buffer = new byte[1024];
            int bytes;

            while (true) {
                try {
                    bytes = inputStream.read(buffer);
                    handler.obtainMessage(STATE_MESSAGE_RECEIVED, bytes, -1, buffer).sendToTarget();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

        public void write(byte[] bytes) {
            try {
                outputStream.write(bytes);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
