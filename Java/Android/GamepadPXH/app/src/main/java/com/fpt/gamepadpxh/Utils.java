package com.fpt.gamepadpxh;

import android.view.InputDevice;

import java.util.ArrayList;

public class Utils {

    public static boolean isGAME_PAD(InputDevice event) {
        return (event.getSources() & InputDevice.SOURCE_GAMEPAD) == InputDevice.SOURCE_GAMEPAD;
    }

    public static boolean isJOYSTICK(InputDevice event) {
        return (event.getSources() & InputDevice.SOURCE_JOYSTICK) == InputDevice.SOURCE_JOYSTICK;
    }

    public static boolean isDPAD(InputDevice event) {
        return (event.getSources() & InputDevice.SOURCE_DPAD) == InputDevice.SOURCE_DPAD;
    }

    public static ArrayList<Integer> getGameControllerIds() {
        ArrayList<Integer> gameControllerDeviceIds = new ArrayList<Integer>();
        int[] deviceIds = InputDevice.getDeviceIds();
        for (int deviceId : deviceIds) {
            InputDevice dev = InputDevice.getDevice(deviceId);

            // Verify that the device has game-pad buttons, control sticks, or both.
            if (Utils.isGAME_PAD(dev) || Utils.isJOYSTICK(dev)) {
                // This device is a game controller. Store its device ID.
                if (!gameControllerDeviceIds.contains(deviceId)) {
                    gameControllerDeviceIds.add(deviceId);
                }
            }
        }
        return gameControllerDeviceIds;
    }
}
