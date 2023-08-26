package com.fpt.gamepadpxh;

import android.view.KeyEvent;
import android.widget.TextView;

public class Action {

    public void handledSelectStart(int keyCode, KeyEvent event, TextView actionView, String action) {
        if(action.trim().isEmpty()) {
            action = "pressed";
        }
        if(keyCode == event.KEYCODE_BUTTON_SELECT) {
            actionView.setText("Select is " + action + ": " + event.KEYCODE_BUTTON_SELECT);
        } else if (keyCode == event.KEYCODE_BUTTON_START) {
            actionView.setText("Start is " + action + ": " + event.KEYCODE_BUTTON_START);
        }
    }

    public void handledL1R1(int keyCode, KeyEvent event, TextView actionView, String action) {
        if(action.trim().isEmpty()) {
            action = "pressed";
        }
        if(keyCode == event.KEYCODE_BUTTON_L1) {
            actionView.setText("L1 is " + action + ": " + event.KEYCODE_BUTTON_L1);
        } else if (keyCode == event.KEYCODE_BUTTON_R1) {
            actionView.setText("R1 is " + action + ": " + event.KEYCODE_BUTTON_R1);
        }
    }

    public void handledL2R2(int keyCode, KeyEvent event, TextView actionView, String action) {
        if(action.trim().isEmpty()) {
            action = "pressed";
        }
        if(keyCode == event.KEYCODE_BUTTON_L2) {
            actionView.setText("L2 is " + action + ": " + event.KEYCODE_BUTTON_L2);
        } else if (keyCode == event.KEYCODE_BUTTON_R2) {
            actionView.setText("R2 is " + action + ": " + event.KEYCODE_BUTTON_R2);
        }
    }

    public void handledABXY(int keyCode, KeyEvent event, TextView actionView, String action) {
        if(action.trim().isEmpty()) {
            action = "pressed";
        }
        if(keyCode == event.KEYCODE_BUTTON_A) {
            actionView.setText("A is " + action + ": " + event.KEYCODE_BUTTON_A);
        } else if (keyCode == event.KEYCODE_BUTTON_B) {
            actionView.setText("B is " + action + ": " + event.KEYCODE_BUTTON_B);
        } else if (keyCode == event.KEYCODE_BUTTON_X) {
            actionView.setText("X is " + action + ": " + event.KEYCODE_BUTTON_X);
        } else if (keyCode == event.KEYCODE_BUTTON_Y) {
            actionView.setText("Y is " + action + ": " + event.KEYCODE_BUTTON_Y);
        }
    }

    public void handledDPad(int keyCode, KeyEvent event, TextView actionView, String action) {
        if(action.trim().isEmpty()) {
            action = "pressed";
        }
        if(keyCode == event.KEYCODE_DPAD_UP) {
            actionView.setText("DPad up is " + action + ": " + event.KEYCODE_DPAD_UP);
        } else if (keyCode == event.KEYCODE_DPAD_RIGHT) {
            actionView.setText("DPad right is " + action + ": " + event.KEYCODE_DPAD_RIGHT);
        } else if (keyCode == event.KEYCODE_DPAD_DOWN) {
            actionView.setText("DPad down is " + action + ": " + event.KEYCODE_DPAD_DOWN);
        } else if (keyCode == event.KEYCODE_DPAD_LEFT) {
            actionView.setText("DPad left is " + action + ": " + event.KEYCODE_DPAD_LEFT);
        }
    }

}
