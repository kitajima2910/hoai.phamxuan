package com.fpt.gamepadpxh;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.InputDevice;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import org.java_websocket.WebSocket;
import org.java_websocket.handshake.ClientHandshake;
import org.java_websocket.server.WebSocketServer;

import java.net.InetSocketAddress;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Timer;
import java.util.TimerTask;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity";

    private TextView actionView;
    private TextView txtNameWifi;

    private Action action = new Action();
    private Button btnA;
    private Button btnB;
    private Button btnX;
    private Button btnY;
    private Button btnDPadUp;
    private Button btnDPadRight;
    private Button btnDPadDown;
    private Button btnDPadLeft;
    private Button btnL1;
    private Button btnR1;
    private Button btnSelect;
    private Button btnStart;
    private Button btnLT;
    private Button btnRT;

    private WebSocketHost wsServer;

    private RefreshHandler mRedrawHandler = new RefreshHandler();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        actionView = findViewById(R.id.action);
        actionView.setText("Virtual Game-pad Controller");

        txtNameWifi = findViewById(R.id.txtNameWifi);

        btnA = findViewById(R.id.btnA);
        btnB = findViewById(R.id.btnB);
        btnX = findViewById(R.id.btnX);
        btnY = findViewById(R.id.btnY);

        btnDPadUp = findViewById(R.id.btnDPadUp);
        btnDPadRight = findViewById(R.id.btnDPadRight);
        btnDPadDown = findViewById(R.id.btnDPadDown);
        btnDPadLeft = findViewById(R.id.btnDPadLeft);

        btnL1 = findViewById(R.id.btnL1);
        btnR1 = findViewById(R.id.btnR1);

        btnSelect = findViewById(R.id.btnSelect);
        btnStart = findViewById(R.id.btnStart);

        btnLT = findViewById(R.id.btnLT);
        btnRT = findViewById(R.id.btnRT);

        createWebsocket();



        btnDPadUp.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                if(event.getAction() == MotionEvent.ACTION_DOWN) {
                    dispatchKeyEvent(new KeyEvent(KeyEvent.ACTION_DOWN, KeyEvent.KEYCODE_DPAD_UP));
                } else if(event.getAction() == MotionEvent.ACTION_UP) {
                    dispatchKeyEvent(new KeyEvent(KeyEvent.ACTION_UP, KeyEvent.KEYCODE_DPAD_UP));
                }
                return true;
            }
        });

        btnDPadRight.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                if(event.getAction() == MotionEvent.ACTION_DOWN) {
                    dispatchKeyEvent(new KeyEvent(KeyEvent.ACTION_DOWN, KeyEvent.KEYCODE_DPAD_RIGHT));
                } else if(event.getAction() == MotionEvent.ACTION_UP) {
                    dispatchKeyEvent(new KeyEvent(KeyEvent.ACTION_UP, KeyEvent.KEYCODE_DPAD_RIGHT));
                }
                return true;
            }
        });

        btnDPadDown.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                if(event.getAction() == MotionEvent.ACTION_DOWN) {
                    dispatchKeyEvent(new KeyEvent(KeyEvent.ACTION_DOWN, KeyEvent.KEYCODE_DPAD_DOWN));
                } else if(event.getAction() == MotionEvent.ACTION_UP) {
                    dispatchKeyEvent(new KeyEvent(KeyEvent.ACTION_UP, KeyEvent.KEYCODE_DPAD_DOWN));
                }
                return true;
            }
        });

        btnDPadLeft.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                if(event.getAction() == MotionEvent.ACTION_DOWN) {
                    dispatchKeyEvent(new KeyEvent(KeyEvent.ACTION_DOWN, KeyEvent.KEYCODE_DPAD_LEFT));
                } else if(event.getAction() == MotionEvent.ACTION_UP) {
                    dispatchKeyEvent(new KeyEvent(KeyEvent.ACTION_UP, KeyEvent.KEYCODE_DPAD_LEFT));
                }
                return true;
            }
        });

        btnA.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                if(event.getAction() == MotionEvent.ACTION_DOWN) {
                    dispatchKeyEvent(new KeyEvent(KeyEvent.ACTION_DOWN, KeyEvent.KEYCODE_BUTTON_A));
                } else if(event.getAction() == MotionEvent.ACTION_UP) {
                    dispatchKeyEvent(new KeyEvent(KeyEvent.ACTION_UP, KeyEvent.KEYCODE_BUTTON_A));
                }
                return true;
            }
        });

        btnB.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                if(event.getAction() == MotionEvent.ACTION_DOWN) {
                    dispatchKeyEvent(new KeyEvent(KeyEvent.ACTION_DOWN, KeyEvent.KEYCODE_BUTTON_B));
                } else if(event.getAction() == MotionEvent.ACTION_UP) {
                    dispatchKeyEvent(new KeyEvent(KeyEvent.ACTION_UP, KeyEvent.KEYCODE_BUTTON_B));
                }
                return true;
            }
        });

        btnX.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                if(event.getAction() == MotionEvent.ACTION_DOWN) {
                    dispatchKeyEvent(new KeyEvent(KeyEvent.ACTION_DOWN, KeyEvent.KEYCODE_BUTTON_X));
                } else if(event.getAction() == MotionEvent.ACTION_UP) {
                    dispatchKeyEvent(new KeyEvent(KeyEvent.ACTION_UP, KeyEvent.KEYCODE_BUTTON_X));
                }
                return true;
            }
        });

        btnY.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                if(event.getAction() == MotionEvent.ACTION_DOWN) {
                    dispatchKeyEvent(new KeyEvent(KeyEvent.ACTION_DOWN, KeyEvent.KEYCODE_BUTTON_Y));
                } else if(event.getAction() == MotionEvent.ACTION_UP) {
                    dispatchKeyEvent(new KeyEvent(KeyEvent.ACTION_UP, KeyEvent.KEYCODE_BUTTON_Y));
                }
                return true;
            }
        });

        btnL1.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                if(event.getAction() == MotionEvent.ACTION_DOWN) {
                    dispatchKeyEvent(new KeyEvent(KeyEvent.ACTION_DOWN, KeyEvent.KEYCODE_BUTTON_L1));
                } else if(event.getAction() == MotionEvent.ACTION_UP) {
                    dispatchKeyEvent(new KeyEvent(KeyEvent.ACTION_UP, KeyEvent.KEYCODE_BUTTON_L1));
                }
                return true;
            }
        });

        btnR1.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                if(event.getAction() == MotionEvent.ACTION_DOWN) {
                    dispatchKeyEvent(new KeyEvent(KeyEvent.ACTION_DOWN, KeyEvent.KEYCODE_BUTTON_R1));
                } else if(event.getAction() == MotionEvent.ACTION_UP) {
                    dispatchKeyEvent(new KeyEvent(KeyEvent.ACTION_UP, KeyEvent.KEYCODE_BUTTON_R1));
                }
                return true;
            }
        });

        btnSelect.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                if(event.getAction() == MotionEvent.ACTION_DOWN) {
                    dispatchKeyEvent(new KeyEvent(KeyEvent.ACTION_DOWN, KeyEvent.KEYCODE_BUTTON_SELECT));
                } else if(event.getAction() == MotionEvent.ACTION_UP) {
                    dispatchKeyEvent(new KeyEvent(KeyEvent.ACTION_UP, KeyEvent.KEYCODE_BUTTON_SELECT));
                }
                return true;
            }
        });

        btnStart.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                if(event.getAction() == MotionEvent.ACTION_DOWN) {
                    dispatchKeyEvent(new KeyEvent(KeyEvent.ACTION_DOWN, KeyEvent.KEYCODE_BUTTON_START));
                } else if(event.getAction() == MotionEvent.ACTION_UP) {
                    dispatchKeyEvent(new KeyEvent(KeyEvent.ACTION_UP, KeyEvent.KEYCODE_BUTTON_START));
                }
                return true;
            }
        });

        btnLT.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                if(event.getAction() == MotionEvent.ACTION_DOWN) {
                    dispatchKeyEvent(new KeyEvent(KeyEvent.ACTION_DOWN, KeyEvent.KEYCODE_BUTTON_L2));
                } else if(event.getAction() == MotionEvent.ACTION_UP) {
                    dispatchKeyEvent(new KeyEvent(KeyEvent.ACTION_UP, KeyEvent.KEYCODE_BUTTON_L2));
                }
                return true;
            }
        });

        btnRT.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                if(event.getAction() == MotionEvent.ACTION_DOWN) {
                    dispatchKeyEvent(new KeyEvent(KeyEvent.ACTION_DOWN, KeyEvent.KEYCODE_BUTTON_R2));
                } else if(event.getAction() == MotionEvent.ACTION_UP) {
                    dispatchKeyEvent(new KeyEvent(KeyEvent.ACTION_UP, KeyEvent.KEYCODE_BUTTON_R2));
                }
                return true;
            }
        });

        updateUI();
    }

    @Override
    public void onBackPressed() {
//        super.onBackPressed();
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        action.handledABXY(keyCode, event, actionView, "pressed");
        action.handledDPad(keyCode, event, actionView, "pressed");
        action.handledL1R1(keyCode, event, actionView, "pressed");
        action.handledL2R2(keyCode, event, actionView, "pressed");
        action.handledSelectStart(keyCode, event, actionView, "pressed");
        return super.onKeyDown(keyCode, event);
    }

    @Override
    public boolean onKeyUp(int keyCode, KeyEvent event) {
        action.handledABXY(keyCode, event, actionView, "released");
        action.handledDPad(keyCode, event, actionView, "released");
        action.handledL1R1(keyCode, event, actionView, "released");
        action.handledL2R2(keyCode, event, actionView, "released");
        action.handledSelectStart(keyCode, event, actionView, "released");
        return super.onKeyUp(keyCode, event);
    }

    @Override
    public boolean onGenericMotionEvent(MotionEvent event) {

        // Process all historical movement samples in the batch
        final int historySize = event.getHistorySize();

        // Process the movements starting from the
        // earliest historical position in the batch
        for (int i = 0; i < historySize; i++) {
            // Process the event at historical position i
            processJoystickInput(event, i);
        }

        // Process the current movement sample in the batch (position -1)
        processJoystickInput(event, -1);
        return super.onGenericMotionEvent(event);
    }

    private void processJoystickInput(MotionEvent event, int historyPos) {

        InputDevice mInputDevice = event.getDevice();

        // Calculate the horizontal distance to move by
        // using the input value from one of these physical controls:
        // the left control stick, hat axis, or the right control stick.
        float leftJoystickX = getCenteredAxis(event, mInputDevice, MotionEvent.AXIS_X, historyPos);
        float leftJoystickY = getCenteredAxis(event, mInputDevice, MotionEvent.AXIS_Y, historyPos);

        float rightJoystickX = getCenteredAxis(event, mInputDevice, MotionEvent.AXIS_Z, historyPos);
        float rightJoystickY = getCenteredAxis(event, mInputDevice, MotionEvent.AXIS_RZ, historyPos);

        float leftTrigger = getCenteredAxis(event, mInputDevice, MotionEvent.AXIS_LTRIGGER, historyPos);

        float rightTrigger = getCenteredAxis(event, mInputDevice, MotionEvent.AXIS_RTRIGGER, historyPos);

        if(leftJoystickX != 0 && leftJoystickY != 0) {
            actionView.setText("leftJoystickX: " + leftJoystickX + " - leftJoystickY: " + leftJoystickY);
        } else if (rightJoystickX != 0 && rightJoystickY != 0) {
            actionView.setText("rightJoystickX: " + rightJoystickX + " - rightJoystickY: " + rightJoystickY);
        } else if (leftTrigger != 0) {
            actionView.setText("leftTriggerX: " + leftTrigger);
        } else if(rightTrigger != 0) {
            actionView.setText("rightTrigger: " + rightTrigger);
        }

    }

    private static float getCenteredAxis(MotionEvent event, InputDevice device, int axis, int historyPos) {
        final InputDevice.MotionRange range = device.getMotionRange(axis, event.getSource());

        // A joystick at rest does not always report an absolute position of
        // (0,0). Use the getFlat() method to determine the range of values
        // bounding the joystick axis center.
        if (range != null) {
            final float flat = range.getFlat();
            final float value = historyPos < 0 ? event.getAxisValue(axis) : event.getHistoricalAxisValue(axis, historyPos);

            // Ignore axis values that are within the 'flat' region of the
            // joystick axis center.
            if (Math.abs(value) > flat) {
                return value;
            }
        }
        return 0;
    }

    public void sendToClient( String text ) {
        try {
            Collection<WebSocket> con = wsServer.connections();
            synchronized ( con ) {
                for( WebSocket c : con ) {
                    c.send( text );
                }
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    private void createWebsocket() {
        try {
            WifiManager wifiMan = (WifiManager) getApplicationContext().getSystemService(Context.WIFI_SERVICE);
            WifiInfo wifiInf = wifiMan.getConnectionInfo();
            int ipAddress = wifiInf.getIpAddress();
            String ip = String.format("%d.%d.%d.%d", (ipAddress & 0xff),(ipAddress >> 8 & 0xff),(ipAddress >> 16 & 0xff),(ipAddress >> 24 & 0xff));
            InetSocketAddress inetSockAddress = new InetSocketAddress(ip, 2910);
            wsServer = new WebSocketHost(inetSockAddress);
            wsServer.start();
            txtNameWifi.setText(inetSockAddress.toString());
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    class RefreshHandler extends Handler {
        @Override
        public void handleMessage(Message msg) {
            MainActivity.this.updateUI();
        }

        public void sleep(long delayMillis) {
            this.removeMessages(0);
            sendMessageDelayed(obtainMessage(0), delayMillis);
        }
    };

    static int currentInt = 1;
    private void updateUI() {
//        if(currentInt <= 100){
//            mRedrawHandler.sleep(1000);
//            actionView.setText(String.valueOf(wsServer.receivingMessages));
//            currentInt++;
//        }

        mRedrawHandler.sleep(0);
        String msg = wsServer.receivingMessages;
        if(!msg.trim().isEmpty() && msg.contains("released")) {
            dispatchKeyEvent(new KeyEvent(KeyEvent.ACTION_UP, KeyEvent.KEYCODE_BUTTON_X));
        } else if (msg.contains("pressed")) {
            dispatchKeyEvent(new KeyEvent(KeyEvent.ACTION_DOWN, KeyEvent.KEYCODE_BUTTON_X));
        }
//        actionView.setText(String.valueOf(wsServer.receivingMessages.trim().isEmpty() ? actionView.getText() : wsServer.receivingMessages));
    }
}