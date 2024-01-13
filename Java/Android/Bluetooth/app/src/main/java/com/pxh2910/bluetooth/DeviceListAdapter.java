package com.pxh2910.bluetooth;

import android.bluetooth.BluetoothDevice;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;

public class DeviceListAdapter extends ArrayAdapter<BluetoothDevice> {

    private LayoutInflater layoutInflater;
    private ArrayList<BluetoothDevice> bluetoothDevices;
    private int viewResource;

    public DeviceListAdapter(@NonNull Context context, int resource, @NonNull ArrayList<BluetoothDevice> objects) {
        super(context, resource, objects);

        bluetoothDevices = objects;
        layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        viewResource = resource;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        convertView = layoutInflater.inflate(viewResource, null);

        BluetoothDevice device = bluetoothDevices.get(position);

        if (device != null) {
            TextView deviceName = (TextView) convertView.findViewById(R.id.tvDeviceName);
            TextView deviceAddress = (TextView) convertView.findViewById(R.id.tvDeviceAddress);

            if (deviceName != null) {
                deviceName.setText(device.getName());
            }
            if (deviceAddress != null) {
                deviceAddress.setText(device.getAddress());
            }
        }

        return convertView;
    }
}
