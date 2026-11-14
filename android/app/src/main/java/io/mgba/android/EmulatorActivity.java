/* This Source Code Form is subject to the terms of the Mozilla Public
 * License, v. 2.0. If a copy of the MPL was not distributed with this
 * file, You can obtain one at http://mozilla.org/MPL/2.0/. */
package io.mgba.android;

import android.Manifest;
import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.ContentValues;
import android.content.Intent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.IntentFilter;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager;
import android.content.res.Configuration;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.graphics.RectF;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.media.AudioAttributes;
import android.media.AudioFormat;
import android.media.AudioManager;
import android.media.AudioTrack;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.os.Handler;
import android.os.Looper;
import android.os.VibrationEffect;
import android.os.Vibrator;
import android.provider.DocumentsContract;
import android.provider.MediaStore;
import android.provider.OpenableColumns;
import android.provider.Settings;
import android.content.SharedPreferences;
import android.text.InputType;
import android.text.format.DateFormat;
import android.util.Log;
import android.util.Patterns;
import android.view.Gravity;
import android.view.GestureDetector;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.PixelCopy;
import android.view.SurfaceHolder;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.HorizontalScrollView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.ScrollView;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Inet4Address;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Collections;
import java.util.Comparator;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Random;
import java.util.Set;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

public class EmulatorActivity extends AppCompatActivity {
    private static final String TAG = "mGBA-App";
    /** 局域网多人（3/4 人）的默认 TCP 端口，与 adb 广播里的 --ei tcp 默认值一致。 */
    private static final int BUS_TCP_PORT = 19876;
    private static final int REQ_ROM = 1;
    private static final int REQ_BIOS = 2;
    private static final int REQ_STORAGE = 3;
    private static final int REQ_SAVDIR = 4;
    private static final int REQ_SHADER = 9;
    private static final int REQ_ROMDIR = 10;
    private static final int CMD_SAVE = 1;
    private static final int CMD_LOAD = 2;
    private static final int CMD_RESET = 3;
    private static final int CMD_AUTOSAVE = 4;
    private static final int CMD_REWIND = 5;
    private static final int TURBO_ARM_MS = 200;
    /** Slot reserved for the automatic save-on-exit / load-on-start pair. */
    private static final int AUTO_SLOT = 0;
    /** Speed presets on the tier bar; anything else goes through 自定义. */
    private static final float[] SPEED_TIERS = {0.25f, 0.5f, 1f, 2f, 4f, 8f, 16f};
    private static final int TURBO_PULSE_MS = 40;
    /** Frames requested from the resampler per read; also the size of the read buffer. */
    private static final int AUDIO_READ_FRAMES = 8192;
    /** Emulated frames run per audio pump while fast-forwarding. */
    private static final int AUDIO_STEP_FRAMES = 4;
    /** Local backlog of resampled frames the playback buffer had no room for. */
    private static final int AUDIO_CARRY_FRAMES = 2560;
    /** How full the playback buffer is kept while playing. */
    private static final float AUDIO_TARGET_FILL = 0.65f;
    /** Most ROMs offered at once by the scan. */
    private static final int ROM_SCAN_LIMIT = 200;
    /** How deep a custom ROM folder is searched (games often sit in sub-folders). */
    private static final int ROM_DIR_DEPTH = 3;
    /** How long the menu stays open after it was last used. */
    private static final int MENU_HIDE_MS = 4000;

    private MgbaCore core;
    private GameView gameView;

    /** Lets `adb shell am broadcast -a io.mgba.android.action.SCREENSHOT` grab the
     *  current GBA frame as a PNG, bypassing the headless GL surface capture. */
    private final BroadcastReceiver screenshotReceiver = new BroadcastReceiver() {
        @Override
        public void onReceive(Context context, Intent intent) {
            Log.i(TAG, "screenshot broadcast received");
            saveDebugShot();
        }
    };
    /** Lets `adb shell am broadcast -a io.mgba.android.action.KEYS --ei mask N` set the
     *  held hardware key mask directly. adb's `input keyevent` only produces a momentary
     *  down/up pair, which can never satisfy a game that polls JOY_HELD(x); automuting a
     *  link test needs a key that stays down, so drive it from here instead. */
    private final BroadcastReceiver keysReceiver = new BroadcastReceiver() {
        @Override
        public void onReceive(Context context, Intent intent) {
            int mask = intent.getIntExtra("mask", 0);
            int prev = hwKeys;
            hwKeys = mask;
            Log.i(TAG, "keys broadcast mask=" + mask + " prev=" + prev);
            // noteUserKeys() publishes the merged mask itself.
            noteUserKeys(touchKeys, prev);
        }
    };
    /** Opt back into the GBoy/My Boy "one person drives both consoles" mode.
     *  Off by default; see gboyRemoteKeysEnabled for why. */
    private final BroadcastReceiver remoteKeysReceiver = new BroadcastReceiver() {
        @Override
        public void onReceive(Context context, Intent intent) {
            gboyRemoteKeysEnabled = intent.getBooleanExtra("on", false);
            Log.i(TAG, "remote keys " + (gboyRemoteKeysEnabled ? "enabled" : "disabled"));
            publishRemoteKeys();
        }
    };
    /** Headless entry for the official local TCP link:
     *  {@code am broadcast -a io.mgba.android.action.GBOY_LOCAL_LINK
     *  --ez host true --ei tcp 19876 --ei sio 18781 --es rom /sdcard/rom.gba},
     *  or {@code --ez host false --es peer 10.0.2.2 ...} to join.
     *  {@code --ez ncore true --ez use_lockstep true --ei players 4} switches
     *  the 3/4-player in-process consoles to the official lockstep SIO room
     *  (use_lockstep implies ncore). {@code --ez stop true} tears the link down. */
    private final BroadcastReceiver localLinkReceiver = new BroadcastReceiver() {
        @Override
        public void onReceive(Context context, Intent intent) {
            if (intent.getBooleanExtra("stop", false)) {
                stopGBoyLink();
                Log.i(TAG, "local link stopped by broadcast");
                return;
            }
            // 无头验证用：菜单栏那句「联机」按钮在模拟器里点不到（SurfaceView
            // 会盖住菜单，而且菜单会自动收起），这里给对话框开一个广播入口，
            // 和 ROM / KEYS / STATE 那几个 headless 钩子同一套路。对话框本身
            // 不依赖 ROM 是否已加载，所以放在 ROM 检查之前。
            if (intent.getBooleanExtra("dialog", false)) {
                Log.i(TAG, "link dialog opened by broadcast");
                showLinkDialog();
                return;
            }
            /* 调试倒档：把隐藏镜像核存成 slotN.ss，PC 版 mGBA 载入就能看见
             * 镜像核此刻停在哪一幕（镜像核没有画面输出，只能这么看）。 */
            if (intent.getBooleanExtra("dump", false)) {
                int stateSlot = intent.getIntExtra("state_slot", 1);
                Log.i(TAG, "mirror dump slot=" + stateSlot + " -> "
                        + (consoleSet == null ? "no console set"
                                              : consoleSet.dumpMirrorStates(stateSlot)));
                return;
            }
            /* 调试看画面：把隐藏镜像核的当前画面搬到可见核——注意这条路
             * 会崩（跨线程 saveStateToMemory 在核被 park 时取存档不安全，
             * 实测 tombstone 落在 showMirrorOnVisible）。看镜像核请用
             * dump 落盘再到 PC 上载入，别在设备上搬。 */
            if (intent.getBooleanExtra("peek_mirror", false)) {
                Log.w(TAG, "peek_mirror is unsafe (cross-thread savestate); use dump instead");
                return;
            }
            if (core == null || !core.isLoaded()) {
                Log.i(TAG, "local link broadcast ignored: no rom loaded");
                return;
            }
            boolean asHost = intent.getBooleanExtra("host", true);
            int tcpPort = intent.getIntExtra("tcp", 19876);
            int sioPort = intent.getIntExtra("sio", 18781);
            String peer = intent.getStringExtra("peer");
            String romPath = intent.getStringExtra("rom");
            if (romPath == null || romPath.isEmpty()) {
                romPath = getPreferences(MODE_PRIVATE).getString("lastRom", null);
            }
            if (romPath == null || romPath.isEmpty()) {
                Log.w(TAG, "local link broadcast: no rom path");
                return;
            }
            File save = defaultSaveDir != null ? defaultSaveDir : getFilesDir();
            File stateDir = defaultStateDir != null
                    ? defaultStateDir : new File(getFilesDir(), "state");
            int players = intent.getIntExtra("players", 2);
            // 每台设备必须占用不同的槽位，3/4 人时按键帧才会带上目标槽位。
            // 不传时保持 1，与已验证的两人直连行为一致。
            int slot = intent.getIntExtra("slot", 1);
            // headless 开关：3/4 人改走「本机 N 核 + 本机环回星型总线」，
            // 网络只传按键，避开跨设备每轮 1.5 RTT 的锁步。默认 false，
            // 保持已验证的单核跨设备总线路径不变。
            boolean ncore = intent.getBooleanExtra("ncore", false);
            // --ez use_lockstep true：N 核路径改用进程内锁步 SIO 房间。
            useLockstep = intent.getBooleanExtra("use_lockstep", false);
            // 锁步只在本机 N 核路径有意义，自动把 ncore 打开，避免只传
            // use_lockstep 时仍落到单核跨设备总线、开关看似无效。
            if (useLockstep) {
                ncore = true;
            }
            boolean ok;
            if (players > 2 && !ncore) {
                // 3/4 人：每台设备只跑自己的核，走 native 星型总线（主机汇聚
                // 每一轮的字再广播），不再起本机镜像核。
                ok = startBusLink(players, tcpPort, peer, asHost);
            } else {
                ok = startGBoyLocalLink(new File(romPath), save, stateDir,
                        sioPort, tcpPort, peer, asHost, players, slot);
            }
        Log.i(TAG, "local link host=" + asHost + " tcp=" + tcpPort
                + " sio=" + sioPort + " players=" + players + " slot=" + slot
                + " ncore=" + ncore + " lockstep=" + useLockstep
                + " started=" + ok + " err=" + gboyLinkFailure());
        if (ok && intent.getBooleanExtra("busgame", false)) {
            int menuAt = intent.getIntExtra("menu_at", 1500);
            int modeDowns = intent.getIntExtra("mode_downs", 2);
            if (consoleSet != null) {
                consoleSet.setBusGame(true, menuAt, modeDowns);   // 镜像核立刻武装（各自复位帧起跑）
            }
            // 可见核也复位到与镜像同一起点：投给模拟线程重载（loadRom 复位会
            // 卸掉锁步驱动，模拟线程武装可见核后立即按原槽位重挂回房间——
            // native 侧 Host/Join 入口会先清残留槽位）。
            pendingBusGameMenuAt = menuAt;
            pendingBusGameModeDowns = modeDowns;
            suppressAutoState = true;
            pendingPath.set(romPath);
            Log.i(TAG, "busgame mirrors armed, reload+rearm queued menuAt="
                    + menuAt + " modeDowns=" + modeDowns);
        }
        }
    };
    /** busgame 调试脚本桥：PC busgame-lockstep 判据脚本的设备端入口。
     *  {@code am broadcast -a io.mgba.android.action.GBOY_BUSGAME --ez enable true
     *  --ei menu_at 1500 --ei mode_downs 2}。可见核走 beginFrameKeys 接管
     *  （帧精确），镜像核由 GBoyConsoleSet 镜像线程逐帧调 native tick。
     *  关闭用 --ez enable false。 */
    private final BroadcastReceiver busGameReceiver = new BroadcastReceiver() {
        @Override
        public void onReceive(Context context, Intent intent) {
            if (core == null || !core.isLoaded()) {
                Log.i(TAG, "busgame broadcast ignored: no rom loaded");
                return;
            }
            boolean enable = intent.getBooleanExtra("enable", true);
            int menuAt = intent.getIntExtra("menu_at", 1500);
            int modeDowns = intent.getIntExtra("mode_downs", 2);
            GBoyConsoleSet set = consoleSet;
            if (enable) {
                core.busGameStart(0, menuAt, modeDowns);   // 可见核 = 脚本序号 0（主机）
                if (set != null) {
                    set.setBusGame(true, menuAt, modeDowns);
                }
                Log.i(TAG, "busgame enabled menuAt=" + menuAt
                        + " modeDowns=" + modeDowns + " mirrors=" + (set != null));
            } else {
                core.busGameStop();
                if (set != null) {
                    set.setBusGame(false, menuAt, modeDowns);
                }
                Log.i(TAG, "busgame disabled");
            }
        }
    };
    /** Lets `adb shell am broadcast -a io.mgba.android.action.CLOUD --es user U
     *  --es pass P --es room R` start the gboy.top cloud link without touching the
     *  menu bar (its buttons sit under the game SurfaceView in some emulators, so
     *  headless tests cannot tap 联机). Room may use the DBG:host:port shortcut.
     *  Optional `--es ws host:port` / `--es api url` redirect the signalling for
     *  mock-lobby tests; leave them out for the real gboy.top. */
    private final BroadcastReceiver cloudReceiver = new BroadcastReceiver() {
        @Override
        public void onReceive(Context context, Intent intent) {
            if (core == null || !core.isLoaded()) {
                Log.i(TAG, "cloud broadcast ignored: no rom loaded");
                return;
            }
            String user = intent.getStringExtra("user");
            String pass = intent.getStringExtra("pass");
            String room = intent.getStringExtra("room");
            String ws = intent.getStringExtra("ws");
            String api = intent.getStringExtra("api");
            if (ws != null && ws.indexOf(':') > 0) {
                int colon = ws.lastIndexOf(':');
                try {
                    GbCloud.overrideEndpoints(api, ws.substring(0, colon),
                            Integer.parseInt(ws.substring(colon + 1).trim()));
                    Log.i(TAG, "cloud signalling redirected to " + ws);
                } catch (NumberFormatException e) {
                    Log.i(TAG, "bad ws override " + ws);
                }
            }
            Log.i(TAG, "cloud broadcast user=" + user + " room=" + room);
            ensureCloud().start(user == null ? "" : user, pass == null ? "" : pass,
                    room == null ? "" : room);
        }
    };
    /** Lets `adb shell am broadcast -a io.mgba.android.action.SIGNAL --es mode host|join
     *  --es user U --es pass P --es room R --es probes a,b,c` drive the gboy.top room
     *  signalling directly and log every server reply, so the room protocol can be
     *  mapped (which action hands the joiner the relay node) without guessing. */
    private final BroadcastReceiver signalReceiver = new BroadcastReceiver() {
        @Override
        public void onReceive(Context context, Intent intent) {
            String mode = intent.getStringExtra("mode");
            String user = intent.getStringExtra("user");
            String pass = intent.getStringExtra("pass");
            String room = intent.getStringExtra("room");
            String probes = intent.getStringExtra("probes");
            Log.i(TAG, "signal probe mode=" + mode + " user=" + user + " room=" + room);
            ensureCloud().probe(mode == null ? "join" : mode,
                    user == null ? "" : user, pass == null ? "" : pass,
                    room == null ? "" : room, probes == null ? "" : probes);
        }
    };
    /** Lets `adb shell am broadcast -a io.mgba.android.action.STATE --es cmd save|load
     *  [--ei slot N]` snapshot/restore a savestate without the toolbar buttons, so a
     *  known club state can be cloned from one emulator to the other for a
     *  deterministic link-battle harness. Mirrors quickState() but headless-safe. */
    private final BroadcastReceiver stateReceiver = new BroadcastReceiver() {
        @Override
        public void onReceive(Context context, Intent intent) {
            if (core == null || !core.isLoaded()) {
                Log.i(TAG, "state broadcast ignored: no rom loaded");
                return;
            }
            String cmd = intent.getStringExtra("cmd");
            int s = intent.getIntExtra("slot", slot);
            if ("save".equalsIgnoreCase(cmd)) {
                slot = s;
                command.set(CMD_SAVE);
                Log.i(TAG, "state broadcast save slot=" + s);
            } else if ("load".equalsIgnoreCase(cmd)) {
                slot = s;
                command.set(CMD_LOAD);
                Log.i(TAG, "state broadcast load slot=" + s);
            } else {
                Log.i(TAG, "state broadcast ignored: bad cmd " + cmd);
            }
        }
    };
    /** Lets `adb shell am broadcast -a io.mgba.android.action.ROM --es path <file>` load a
     *  ROM from the command line / headless harness without tapping the file picker. */
    private final BroadcastReceiver romReceiver = new BroadcastReceiver() {
        @Override
        public void onReceive(Context context, Intent intent) {
            String path = intent.getStringExtra("path");
            if (path == null || path.trim().isEmpty()) {
                Log.i(TAG, "rom broadcast ignored: no path");
                return;
            }
            File f = new File(path);
            if (!f.isFile()) {
                Log.i(TAG, "rom broadcast ignored: missing " + path);
                return;
            }
            Log.i(TAG, "rom broadcast load " + path);
            pendingPath.set(path);
        }
    };
    private ControlsView controls;
    private TextView hint;
    private TextView fpsView;
    private Button pauseButton;
    private Button fastButton;
    private Button slotButton;
    private View menuBar;
    private TextView menuButton;
    private ScreenArea screenArea;
    private final Runnable hideMenu = this::hideMenuNow;
    private LinearLayout speedBar;
    private final Button[] speedButtons = new Button[SPEED_TIERS.length];
    private Button speedCustom;

    private final AtomicReference<String> pendingPath = new AtomicReference<>();
    /** busgame 调试脚本：>=0 表示重载完成后由模拟线程以该 menuAt 武装可见核。 */
    private volatile int pendingBusGameMenuAt = -1;
    /** 云端连上后排队的一次重载：重载完把可见核按原槽位重挂回锁步房间。 */
    private volatile boolean pendingCloudRearm;
    /** 云端建锁步房间期间的闸门：可见核必须停在第 0 帧上，和镜像核一起入房。
     *  让一个已经跑了几万帧的核中途挂进房间，会让协调器在一场 SIO 回合里
     *  永远等不齐这个核（它停在自己的回合号上），核被 park、模拟线程停摆、
     *  画面整块白掉（实测）。所以建核期间锁住帧循环，重载复位到第 0 帧后
     *  再放开。 */
    private volatile boolean linkArmHold;
    private int pendingBusGameModeDowns;
    /** busgame 期间禁用 auto_load_state：镜像核从电池存档冷启动，可见核若读旧
     * 即时存档，游戏上下文会与镜像错位（实测可见核 var8004=0 卡 lt=1133）。 */
    private boolean suppressAutoState;
    /** True while a picked/opened ROM is being imported, so startEmulator() does not arm the old one. */
    private volatile boolean importingRom;
    /** Last "open with" URI already handled, so config changes do not load it twice. */
    private String handledRomUri;
    private final AtomicInteger command = new AtomicInteger();
    private volatile boolean running;
    private volatile boolean paused;
    private volatile boolean surfaceReady;
    private volatile float speed = 1f;
    private volatile boolean fastHold;
    private volatile int touchKeys;
    private volatile int hwKeys;
    private final Handler inputHandler = new Handler(Looper.getMainLooper());
    private boolean turboB;
    private boolean turboDown;
    private volatile int slot = 1;
    private Thread emuThread;
    private Vibrator vibrator;
    private long lastRumbleAt;
    /** Draggable GIF recording ball floating over the game (悠GBA port). */
    private GifBall gifBall;
    /** Device light sensor driving the Boktai solar level (悠GBA port). */
    private boolean solarListening;
    /** The "hide vkeypad?" offer has been shown for this session. */
    private boolean hwKeyPromptShown;
    /** GIF recording state; the queue hands frames to the encoder thread. */
    private volatile boolean gifRecording;
    private Button gifButton;
    private volatile java.util.concurrent.ArrayBlockingQueue<Bitmap> gifQueue;
    private Thread gifThread;
    private long lastGifAt;
    private int gifFrames;
    private volatile int gifWidth;
    private volatile int gifHeight;
    /** Lets only one PixelCopy be in flight for the GIF capture. */
    private final AtomicBoolean gifCopyBusy = new AtomicBoolean();
    /** GIF capture pacing and length cap (GIF_MAX_FRAMES at ~20 fps). */
    private static final int GIF_FRAME_MS = 50;
    private static final int GIF_MAX_FRAMES = 900;

    private AudioTrack audio;
    private boolean audioMuted;
    private volatile boolean audioStarted;
    private double appliedSpeed = -1;
    /** Game speed (mult) the audio pipeline was last configured for; a change
     *  re-locks the resampler even when the requested audio speed is unchanged
     *  (e.g. 不变速 mode always plays at 1x regardless of the fast-forward factor). */
    private double appliedGameSpeed = -1;
    /** Whether the native constant-pitch park buffer is currently switched on. */
    private boolean constantPitchOn;
    /** Multiplier the native stretcher was last told about (avoids re-arming it). */
    private double constantPitchStretch;
    /** Mode the native fast-forward audio pipeline was last told about, -1 when unknown. */
    private int constantPitchMode = -1;
    /** Software volume, 0-150 percent, applied when frames reach the track. */
    private int volumePercent = 100;
    private long nextFastPresent;
    private int outputRate;
    private int sourceRate;
    /** Fractional speeds (slow motion) accumulate whole frames in this debt. */
    private float frameDebt;
    /**
     * Wall-clock target for one emulation slice. This is one frame of the
     * emulated console (about 16.74 ms, i.e. 59.73 fps, for GBA and GB), not a
     * rounded 60: pacing at 60 would play games and their audio about 0.46%
     * fast, which sounds slightly sharp.
     */
    private long sliceNanos = 1_000_000_000L / 60L;
    /** Slice rate the device last sustained while fast-forwarding (slices per
     * second; eased toward the measured capability once per feedback window)
     * and the slice schedule derived from it; re-measured per speed. 0 =
     * free-run while measuring. */
    private float fastPace;
    private long fastSliceNanos;
    /** Schedule resyncs since the last feedback window. */
    private int fastResyncs;
    private final short[] audioRead = new short[AUDIO_READ_FRAMES * 2];
    private final short[] audioCarry = new short[AUDIO_CARRY_FRAMES * 2];
    private int carryFrames;
    private long framesWritten;
    private int trackFrames;
    private int targetFrames;
    private AudioRateControl rateControl;
    /**
     * Whether the core's resampler rate can be trusted at the applied speed.
     * True until a speed change finds no locked estimate and no throughput
     * memory (the first fast-forward on a device); the pump then holds
     * playback until the first feedback window lands, so the queue fills at
     * the right rate instead of draining into gaps at the nominal one.
     */
    private boolean paceSeeded = true;
    private Bitmap frame;
    private final AtomicBoolean presentQueued = new AtomicBoolean();
    /** 上一次 post 的呈现时刻：post 的 Runnable 万一没被执行（View 被 detach、
     *  surface 重建），闸门会永久为 true，之后所有帧被静默丢弃——外观就是
     *  核心仍跑 60fps、画面却整块白/黑、怎么切前后台都不恢复。超时自愈。 */
    private volatile long presentQueuedAt;
    private final AtomicReference<Bitmap> pendingPreview = new AtomicReference<>();
    private boolean emulatorStarted;
    private boolean awaitingStorage;
    private boolean leftForStorage;
    private TextView savePathView;
    private KeyLayout keyLayout = new KeyLayout();
    private boolean layoutEditing;
    private String selectedKey;
    private TextView scaleLabel;
    private SeekBar scaleBar;
    private TextView linkStatusView;
    /** GBoy/My Boy Wi-Fi link session and the key mask it delivers. */
    /** gboy.top cloud room session (KCP relay), same key mask delivery. */
    private GBoyCloudLink cloudLink;
    private volatile int gboyRemoteKeys;
    /**
     * GBoy/My Boy lobbies mirror the peer's held keys into our core (one
     * person drives both consoles). In a real two-player match that is fatal:
     * the peer's KEY frame is one RTT late, so after our own key is released
     * its delayed "pressed" frame raises a second press edge locally. The two
     * consoles then advance their menus by different amounts and pick
     * different link modes ("连接的伙伴似乎做出了别的选择").
     * Default false = 分开控制; toggle with action.REMOTE_KEYS --ez on true.
     */
    private volatile boolean gboyRemoteKeysEnabled = false;
    /** Tilt cartridge input: device posture fed to the core when enabled. */
    private SensorManager sensorManager;
    private boolean tiltListening;
    /** Auto frameskip state on the emulation thread. */
    private volatile boolean skipAuto;
    private int autoSkipLevel;
    private int lateStreak;
    // == Features ported from Pizza Boy ==
    private HorizontalScrollView rewindBar;
    private volatile boolean rewindHold;
    private volatile int rewindSeconds;
    private long lastRewindAt;
    /** Fallback folders used when the ROM has no saves beside it. */
    private File defaultSaveDir;
    private File defaultStateDir;
    /** Hidden mirror core; null until the ported GBoy link is started. */
    private volatile GBoyConsoleSet consoleSet;
    /** 3/4 人本机多核时改用进程内锁步 SIO（默认关，走共享内存总线）。 */
    private boolean useLockstep = false;
    /** Official local TCP link, used when no cloud room is involved. */
    private volatile GBoySocketLink localLink;
    /** 3/4 人总线会话：每台设备只跑自己的核，互连由 native 链路汇聚。 */
    private volatile boolean busLinkActive;
    /** Monotonic frame number feeding the official 12 Hz key cadence. */
    private long netFrameNo;
    /** State folder in effect for the loaded ROM, read by the UI slot helpers. */
    private volatile File activeStateDir;
    private volatile String currentRomPath;
    private RomSettingsDb romDb;
    /** CRC32 of the loaded ROM, the per-game settings key. */
    private long romCrc = -1;
    private final Map<String, Long> crcCache = new HashMap<>();
    /** Per-game overrides; -1/null keeps the global preference. */
    private int perRomFilter = -1;
    private Float perRomSpeed;
    private Integer perRomSaveType;
    private Integer perRomPalette;
    private boolean ffOn;
    private boolean muted;
    private GestureDetector doubleTapShot;
    private java.util.concurrent.ScheduledExecutorService timedSavePool;
    // == Stickers / full skin / AI translate ==
    private StickerOverlay stickerOverlay;
    private AiOverlayView aiOverlay;
    private SkinStore skinStore;
    private String activeSkinName;
    private Bitmap aiFrame;
    private String stickerPrefix;

    /**
     * GB DMG palettes, light to dark, expanded to the twelve gb.pal entries
     * (the same four colors for BG, OBJ0 and OBJ1).
     */
    private static final int[][] GB_PALETTES = {
            {0xFFFFFF, 0xA8B8A8, 0x285050, 0x000000},
            {0xFFFFFF, 0xA9A9A9, 0x545454, 0x000000},
            {0xFFFFFF, 0xAAAAAA, 0x555555, 0x000000},
            {0xF8E0C0, 0xD89058, 0xA85038, 0x381808},
            {0xF8F8D8, 0xD8B098, 0xA06848, 0x583020},
            {0xFFF8FF, 0xF8B8B8, 0xC85050, 0x680808},
            {0xFFFBE7, 0xC8D8A0, 0x789868, 0x183018},
            {0xF8FFD8, 0xB8F8B8, 0x70C078, 0x184818},
            {0xE0F8FF, 0xA0B8F8, 0x5078D8, 0x001888},
            {0xF8E8F8, 0xB8A0F0, 0x7858E8, 0x180090},
            {0xFFF0E0, 0xF8B888, 0xC07038, 0x602010},
            {0xFFF8D8, 0xF8D888, 0xC0A040, 0x604000},
            {0xFFF8F8, 0xE8C0C8, 0xC88898, 0x704858},
            {0x000000, 0x285050, 0xA8B8A8, 0xFFFFFF},
    };

    private static final String[] GB_PALETTE_KEYS = {
            "gbpal_default", "gbpal_original", "gbpal_gray", "gbpal_brown", "gbpal_dark_brown",
            "gbpal_red", "gbpal_green", "gbpal_dark_green", "gbpal_blue", "gbpal_dark_blue",
            "gbpal_orange", "gbpal_yellow", "gbpal_pastel", "gbpal_inverted",
    };

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        applyOrientation();
        // busgame 调试脚本可经启动 intent 直接启用（--ez busgame true），让
        // 可见核武装发生在启动加载完成的第一帧（f=0 = 复位帧）。
        Intent launchIntent = getIntent();
        if (launchIntent != null && launchIntent.getBooleanExtra("busgame", false)) {
            pendingBusGameMenuAt = launchIntent.getIntExtra("menu_at", 1500);
            pendingBusGameModeDowns = launchIntent.getIntExtra("mode_downs", 2);
            suppressAutoState = true;
            Log.i(TAG, "busgame armed at launch menuAt=" + pendingBusGameMenuAt
                    + " modeDowns=" + pendingBusGameModeDowns);
        }
        setContentView(R.layout.activity_emulator);
        gameView = findViewById(R.id.game);
        // Exported so `adb shell am broadcast` can drive headless test runs;
        // Android 13+ requires the flag to be spelled out.
        IntentFilter screenshotFilter = new IntentFilter("io.mgba.android.action.SCREENSHOT");
        if (Build.VERSION.SDK_INT >= 33) {
            registerReceiver(screenshotReceiver, screenshotFilter, Context.RECEIVER_EXPORTED);
        } else {
            registerReceiver(screenshotReceiver, screenshotFilter);
        }
        IntentFilter keysFilter = new IntentFilter("io.mgba.android.action.KEYS");
        if (Build.VERSION.SDK_INT >= 33) {
            registerReceiver(keysReceiver, keysFilter, Context.RECEIVER_EXPORTED);
        } else {
            registerReceiver(keysReceiver, keysFilter);
        }
        IntentFilter remoteKeysFilter = new IntentFilter("io.mgba.android.action.REMOTE_KEYS");
        if (Build.VERSION.SDK_INT >= 33) {
            registerReceiver(remoteKeysReceiver, remoteKeysFilter, Context.RECEIVER_EXPORTED);
        } else {
            registerReceiver(remoteKeysReceiver, remoteKeysFilter);
        }
        IntentFilter localLinkFilter = new IntentFilter("io.mgba.android.action.GBOY_LOCAL_LINK");
        if (Build.VERSION.SDK_INT >= 33) {
            registerReceiver(localLinkReceiver, localLinkFilter, Context.RECEIVER_EXPORTED);
        } else {
            registerReceiver(localLinkReceiver, localLinkFilter);
        }
        IntentFilter busGameFilter = new IntentFilter("io.mgba.android.action.GBOY_BUSGAME");
        if (Build.VERSION.SDK_INT >= 33) {
            registerReceiver(busGameReceiver, busGameFilter, Context.RECEIVER_EXPORTED);
        } else {
            registerReceiver(busGameReceiver, busGameFilter);
        }
        IntentFilter cloudFilter = new IntentFilter("io.mgba.android.action.CLOUD");
        if (Build.VERSION.SDK_INT >= 33) {
            registerReceiver(cloudReceiver, cloudFilter, Context.RECEIVER_EXPORTED);
        } else {
            registerReceiver(cloudReceiver, cloudFilter);
        }
        IntentFilter signalFilter = new IntentFilter("io.mgba.android.action.SIGNAL");
        if (Build.VERSION.SDK_INT >= 33) {
            registerReceiver(signalReceiver, signalFilter, Context.RECEIVER_EXPORTED);
        } else {
            registerReceiver(signalReceiver, signalFilter);
        }
        IntentFilter stateFilter = new IntentFilter("io.mgba.android.action.STATE");
        if (Build.VERSION.SDK_INT >= 33) {
            registerReceiver(stateReceiver, stateFilter, Context.RECEIVER_EXPORTED);
        } else {
            registerReceiver(stateReceiver, stateFilter);
        }
        IntentFilter romFilter = new IntentFilter("io.mgba.android.action.ROM");
        if (Build.VERSION.SDK_INT >= 33) {
            registerReceiver(romReceiver, romFilter, Context.RECEIVER_EXPORTED);
        } else {
            registerReceiver(romReceiver, romFilter);
        }
        hint = findViewById(R.id.hint);
        // When launched with --ez shot true, grab the GBA frame after the ROM
        // has had time to load and start rendering, bypassing headless capture.
        if (getIntent() != null && getIntent().getBooleanExtra("shot", false)) {
            gameView.postDelayed(this::saveDebugShot, 12000);
        }
        screenArea = findViewById(R.id.screen_area);
        fpsView = findViewById(R.id.fps);
        pauseButton = findViewById(R.id.btn_pause);
        fastButton = findViewById(R.id.btn_fast);
        slotButton = findViewById(R.id.btn_slot);

        controls = findViewById(R.id.controls);
        controls.setListener(new ControlsView.Listener() {
            @Override
            public void onKeysChanged(int mask) {
                int prev = touchKeys;
                touchKeys = mask;
                noteUserKeys(prev, hwKeys);
                if ((mask & ~prev) != 0) {
                    wakeInput();
                    vibrateOnKey((mask & ~prev));
                }
            }

            @Override
            public void onAction(int action) {
                if (action == ControlsView.ACTION_SAVE) {
                    quickState(true);
                } else if (action == ControlsView.ACTION_LOAD) {
                    quickState(false);
                } else if (action == ControlsView.ACTION_SHOT) {
                    takeScreenshot();
                } else if (action == ControlsView.ACTION_FF_TOGGLE) {
                    toggleFastForward();
                } else if (action == ControlsView.ACTION_MENU) {
                    if (menuBar.getVisibility() == View.VISIBLE) {
                        hideMenuNow();
                    } else {
                        showMenu();
                    }
                } else if (action == ControlsView.ACTION_MUTE) {
                    toggleMute();
                } else if (action == ControlsView.ACTION_REWIND) {
                    if (rewindBar != null) {
                        rewindBar.setVisibility(
                                rewindBar.getVisibility() == View.VISIBLE ? View.GONE : View.VISIBLE);
                        showMenu();
                    }
                } else if (action == ControlsView.ACTION_REWIND_QUICK) {
                    quickRewind();
                }
            }

            @Override
            public void onFastHold(boolean down) {
                fastHold = down;
                if (down) {
                    wakeInput();
                }
            }

            @Override
            public void onControlsLayout() {
                positionMenuButton();
            }
        });
        vibrator = (Vibrator) getSystemService(VIBRATOR_SERVICE);
        applyInputSettings();
        bindLayoutEditor();

        findViewById(R.id.btn_open).setOnClickListener(v -> openDocument(REQ_ROM));
        findViewById(R.id.btn_open).setOnLongClickListener(v -> {
            showRomScan();
            return true;
        });
        findViewById(R.id.btn_bios).setOnClickListener(v -> openDocument(REQ_BIOS));
        pauseButton.setOnClickListener(v -> setPaused(!paused));
        // Every launch starts at 1x. Fast-forward is a temporary choice: a
        // remembered speed would auto-resume the game, and its tape-style
        // raised audio pitch, before the player asks for it.
        buildSpeedBar();
        fastButton.setOnClickListener(v -> speedBar.setVisibility(speedBar.getVisibility() == View.VISIBLE ? View.GONE : View.VISIBLE));
        slotButton.setOnClickListener(v -> {
            slot = slot % 9 + 1;
            refreshSlotButton();
        });
        findViewById(R.id.btn_save).setOnClickListener(v -> chooseSlot(true));
        findViewById(R.id.btn_load).setOnClickListener(v -> chooseSlot(false));
        findViewById(R.id.btn_reset).setOnClickListener(v -> confirmReset());
        findViewById(R.id.btn_video).setOnClickListener(v -> showVideoDialog());
        findViewById(R.id.btn_link).setOnClickListener(v -> showLinkDialog());
        findViewById(R.id.btn_layout).setOnClickListener(v -> setLayoutEditing(!layoutEditing));
        findViewById(R.id.btn_settings).setOnClickListener(v -> showSettingsDialog());
        View cheatsButton = findViewById(R.id.btn_cheats);
        if (cheatsButton != null) {
            cheatsButton.setOnClickListener(v -> showCheatsDialog());
        }
        View debugButton = findViewById(R.id.btn_debug);
        if (debugButton != null) {
            debugButton.setOnClickListener(v -> DebugViewers.showHub(this, core));
        }
        View shotButton = findViewById(R.id.btn_shot);
        if (shotButton != null) {
            shotButton.setOnClickListener(v -> takeScreenshot());
        }
        gifButton = findViewById(R.id.btn_gif);
        if (gifButton != null) {
            gifButton.setOnClickListener(v -> {
                if (gifRecording) {
                    stopGif();
                } else {
                    startGif();
                }
            });
        }
        savePathView = findViewById(R.id.save_path);
        savePathView.setOnClickListener(v -> copySavePath());

        // == Pizza Boy feature wiring ==
        romDb = new RomSettingsDb(this);
        buildRewindBar();
        View libButton = findViewById(R.id.btn_library);
        if (libButton != null) {
            libButton.setOnClickListener(v -> showRomLibrary());
        }
        View rewindButton = findViewById(R.id.btn_rewind);
        if (rewindButton != null) {
            rewindButton.setOnClickListener(v -> {
                if (rewindBar != null) {
                    rewindBar.setVisibility(
                            rewindBar.getVisibility() == View.VISIBLE ? View.GONE : View.VISIBLE);
                    showMenu();
                }
            });
        }
        View skinButton = findViewById(R.id.btn_skin);
        if (skinButton != null) {
            skinButton.setOnClickListener(v -> showSkinDialog());
        }
        View perRomButton = findViewById(R.id.btn_perrom);
        if (perRomButton != null) {
            perRomButton.setOnClickListener(v -> showPerRomDialog());
        }
        View backupButton = findViewById(R.id.btn_backup);
        if (backupButton != null) {
            backupButton.setOnClickListener(v -> showBackupDialog());
        }
        muted = getPreferences(MODE_PRIVATE).getBoolean("muted", false);
        controls.setMuted(muted);
        doubleTapShot = new GestureDetector(this, new GestureDetector.SimpleOnGestureListener() {
            @Override
            public boolean onDown(MotionEvent e) {
                // Returning true keeps the stream alive; without it the
                // double-tap detector never fires on some devices.
                return true;
            }

            @Override
            public boolean onDoubleTap(MotionEvent e) {
                if (getPreferences(MODE_PRIVATE).getBoolean("double_click_shot", false)) {
                    takeScreenshot();
                    return true;
                }
                return false;
            }
        });
        // Consume the stream (return true) even though the detector itself
        // reports false for plain taps: a false DOWN stops later events of
        // the same gesture from reaching the detector, so the double tap
        // would never complete.
        gameView.setOnTouchListener((v, event) -> {
            doubleTapShot.onTouchEvent(event);
            return true;
        });
        stickerOverlay = findViewById(R.id.sticker_overlay);
        aiOverlay = findViewById(R.id.ai_overlay);
        skinStore = new SkinStore(this);
        bindStickerOverlay();
        View translateButton = findViewById(R.id.btn_translate);
        if (translateButton != null) {
            translateButton.setOnClickListener(v -> showTranslateDialog());
        }
        applySkin();
        // External GLSL shader must be re-adapted from disk before the video
        // settings select it as the active filter.
        loadInstalledShader();
        applyVideo();
        gameView.post(this::applyVideoScene);
        setupGifBall();

        menuBar = findViewById(R.id.menu_bar);
        menuButton = findViewById(R.id.btn_menu);
        menuButton.setOnClickListener(v -> {
            if (menuBar.getVisibility() == View.VISIBLE) {
                hideMenuNow();
            } else {
                showMenu();
            }
        });
        watchMenuTouches(menuBar);
        positionMenuButton();
        // The first placement runs before the handle is measured; redo it once
        // its real height is known so it lines up with the START key.
        menuButton.addOnLayoutChangeListener((v, l, t, r, b, ol, ot, or, ob) -> positionMenuButton());
        applyScreenMode();

        gameView.getHolder().addCallback(new SurfaceHolder.Callback() {
            @Override
            public void surfaceCreated(SurfaceHolder holder) {
                surfaceReady = true;
            }

            @Override
            public void surfaceChanged(SurfaceHolder holder, int format, int width, int height) {
                surfaceReady = true;
            }

            @Override
            public void surfaceDestroyed(SurfaceHolder holder) {
                surfaceReady = false;
            }
        });

        handleViewIntent(getIntent());
        ensureSaveAccess();
        hideSystemUi();
    }

    private void ensureSaveAccess() {
        if (SaveLocation.hasAccess(this) || getPreferences(MODE_PRIVATE).getBoolean("save_access_declined", false)) {
            startEmulator();
            return;
        }
        int message = Build.VERSION.SDK_INT >= 30 ? R.string.save_access_message : R.string.save_access_message_legacy;
        String folder = SaveLocation.visibleFolder(this);
        new AlertDialog.Builder(this)
                .setTitle(R.string.save_access_title)
                .setMessage(getString(message, folder))
                .setPositiveButton(R.string.save_access_allow, (d, w) -> requestSaveAccess())
                .setNegativeButton(R.string.save_access_later, (d, w) -> {
                    getPreferences(MODE_PRIVATE).edit().putBoolean("save_access_declined", true).apply();
                    startEmulator();
                })
                .setCancelable(false)
                .show();
    }

    private void requestSaveAccess() {
        awaitingStorage = true;
        leftForStorage = false;
        if (Build.VERSION.SDK_INT >= 30) {
            try {
                Intent intent = new Intent(Settings.ACTION_MANAGE_APP_ALL_FILES_ACCESS_PERMISSION);
                intent.setData(Uri.parse("package:" + getPackageName()));
                startActivityForResult(intent, REQ_STORAGE);
                return;
            } catch (Exception ignored) {
            }
            try {
                startActivityForResult(new Intent(Settings.ACTION_MANAGE_ALL_FILES_ACCESS_PERMISSION), REQ_STORAGE);
                return;
            } catch (Exception ignored) {
            }
            awaitingStorage = false;
            startEmulator();
            return;
        }
        requestPermissions(new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE}, REQ_STORAGE);
    }

    private void startEmulator() {
        if (emulatorStarted || isFinishing()) {
            return;
        }
        emulatorStarted = true;
        awaitingStorage = false;
        leftForStorage = false;
        if (SaveLocation.hasAccess(this)) {
            getPreferences(MODE_PRIVATE).edit().putBoolean("save_access_declined", false).apply();
        }
        defaultSaveDir = SaveLocation.prepare(this);
        defaultStateDir = new File(getFilesDir(), "states");
        activeStateDir = defaultStateDir;
        core = new MgbaCore(defaultSaveDir, defaultStateDir);
        core.setRewind(true);
        applyCoreOptions();
        applyVideo();
        if (pendingPath.get() == null && !importingRom) {
            String last = getPreferences(MODE_PRIVATE).getString("lastRom", null);
            if (last != null && new File(last).isFile()) {
                pendingPath.set(last);
            }
        }
        running = true;
        emuThread = new Thread(this::emulationLoop, "mGBA");
        emuThread.start();
    }

    private void publishKeys() {
        if (core == null) {
            return;
        }
        int mask = touchKeys | hwKeys;
        if (gboyRemoteKeysEnabled) {
            mask |= gboyRemoteKeys;
        }
        if (turboB) {
            mask &= ~ControlsView.B;
        }
        core.setKeys(mask);
    }

    /**
     * Drops every locally held key after the touch stream or window focus was
     * lost. Without this the matching UP/CANCEL can go to another window, and
     * a latched A (or fast-forward hold) makes the next press look dead.
     */
    private void releaseInput() {
        int held = touchKeys | hwKeys;
        touchKeys = 0;
        hwKeys = 0;
        fastHold = false;
        if (controls != null) {
            controls.releaseAllKeys();
        }
        inputHandler.removeCallbacks(armTurbo);
        stopTurbo();
        if (held != 0) {
            publishKeys();
            wakeInput();
        }
    }

    /**
     * Keys applied this frame: local input plus the GBoy peer's mask, exactly
     * like the GBoy/My Boy lobby (远程按键模式).
     */
    private int userKeys() {
        return touchKeys | hwKeys | (gboyRemoteKeysEnabled ? gboyRemoteKeys : 0);
    }

    private void noteUserKeys(int prevTouch, int prevHw) {
        boolean wasB = ((prevTouch | prevHw) & ControlsView.B) != 0;
        boolean nowB = ((touchKeys | hwKeys) & ControlsView.B) != 0;
        if (nowB && !wasB) {
            inputHandler.removeCallbacks(armTurbo);
            // Holding B only auto-turboes in the classic mode; the dedicated
            // 连发 keys have their own pulsing in ControlsView and must not
            // also arm this auto-turbo, or B is driven from two sources at
            // once and gets pinned on (跑步卡死).
            if (turboModePref() == 0 && (controls == null || !controls.turboBPressed())) {
                inputHandler.postDelayed(armTurbo, TURBO_ARM_MS);
            }
        } else if (!nowB && wasB) {
            inputHandler.removeCallbacks(armTurbo);
            stopTurbo();
        }
        publishKeys();
    }

    private final Runnable pulseTurbo = new Runnable() {
        @Override
        public void run() {
            if (!turboB || ((touchKeys | hwKeys) & ControlsView.B) == 0) {
                stopTurbo();
                return;
            }
            turboDown = !turboDown;
            if (controls != null) {
                controls.setBTurbo(true, turboDown);
            }
            inputHandler.postDelayed(this, TURBO_PULSE_MS);
        }
    };

    private final Runnable armTurbo = () -> {
        if (((touchKeys | hwKeys) & ControlsView.B) == 0 || turboB) {
            return;
        }
        turboB = true;
        turboDown = false;
        publishKeys();
        if (core != null) {
            core.setTurbo(ControlsView.B);
        }
        if (controls != null) {
            controls.setBTurbo(true, false);
        }
        inputHandler.postDelayed(pulseTurbo, TURBO_PULSE_MS);
    };

    private void stopTurbo() {
        boolean was = turboB;
        turboB = false;
        turboDown = false;
        inputHandler.removeCallbacks(pulseTurbo);
        if (core != null) {
            core.setTurbo(0);
        }
        if (controls != null) {
            controls.setBTurbo(false, false);
        }
        if (was && core != null) {
            core.setKeys(touchKeys | hwKeys);
        }
    }

    /**
     * Pushes the peer's key mask into the core.
     *
     * The native side only latches what setKeys() handed it and re-applies it
     * every frame, so the merged mask has to be published whenever it changes.
     * Without this the peer's key press never reaches the game: the local
     * side holds no key of its own, so no local input event ever fires and
     * publishKeys() is never called - the remote mask sat in gboyRemoteKeys
     * while the core kept seeing "nothing pressed".
     */
    private void publishRemoteKeys() {
        publishKeys();
        wakeInput();
    }

    private void wakeInput() {
        if (emuThread != null) {
            emuThread.interrupt();
        }
    }

    private void openDocument(int request) {
        Intent intent = new Intent(Intent.ACTION_OPEN_DOCUMENT);
        intent.addCategory(Intent.CATEGORY_OPENABLE);
        intent.setType("*/*");
        launchPicker(intent, request);
    }

    /**
     * Launches the system picker only when one exists. On stripped devices
     * with no documents UI, launching would strand the player away from the
     * controls, so the folder-based import paths are the fallback.
     */
    private boolean launchPicker(Intent intent, int request) {
        try {
            if (intent.resolveActivity(getPackageManager()) == null) {
                toast(getString(R.string.picker_missing));
                return false;
            }
            startActivityForResult(intent, request);
            return true;
        } catch (Exception e) {
            toast(getString(R.string.picker_missing));
            return false;
        }
    }

    /** Images the player dropped into /sdcard/mGBAx/stickers, no picker needed. */
    private void showFolderStickerPicker() {
        List<File> images = new ArrayList<>();
        File[] roots = {
                new File(Environment.getExternalStorageDirectory(), "mGBAx/stickers"),
                getExternalFilesDir("stickers"),
        };
        for (File root : roots) {
            File[] files = root == null ? null : root.listFiles();
            if (files == null) {
                continue;
            }
            for (File file : files) {
                String lower = file.getName().toLowerCase(Locale.ROOT);
                if (file.isFile() && (lower.endsWith(".png") || lower.endsWith(".jpg")
                        || lower.endsWith(".jpeg") || lower.endsWith(".webp") || lower.endsWith(".gif"))) {
                    images.add(file);
                }
            }
        }
        if (images.isEmpty()) {
            toast(getString(R.string.sticker_folder_empty));
            return;
        }
        String[] names = new String[images.size()];
        for (int i = 0; i < images.size(); i++) {
            names[i] = images.get(i).getName();
        }
        new AlertDialog.Builder(this)
                .setTitle(R.string.sticker_from_folder)
                .setItems(names, (dialog, which) -> {
                    File source = images.get(which);
                    File dir = new File(getFilesDir(), "stickers");
                    dir.mkdirs();
                    File dest = new File(dir, "sticker-" + System.currentTimeMillis() + "-"
                            + source.getName());
                    String copied = copyFile(source, dest);
                    if (copied == null || !stickerOverlay.addSticker(copied)) {
                        toast(getString(R.string.sticker_load_failed));
                        return;
                    }
                    stickerOverlay.setEditing(true);
                    toast(getString(R.string.sticker_added));
                })
                .setNegativeButton(android.R.string.cancel, null)
                .show();
    }

    /** Imports every new folder under /sdcard/mGBAx/skins as a skin pack. */
    private void scanSkinsFromFolder(AlertDialog[] holder) {
        File root = new File(Environment.getExternalStorageDirectory(), "mGBAx/skins");
        File[] dirs = root.isDirectory() ? root.listFiles() : null;
        int imported = 0;
        if (dirs != null) {
            for (File dir : dirs) {
                if (!dir.isDirectory() || skinStore.list().contains(dir.getName())) {
                    continue;
                }
                if (skinStore.importDir(dir.getName(), dir) != null) {
                    imported++;
                }
            }
        }
        if (imported == 0) {
            toast(getString(R.string.full_skin_scan_empty));
            return;
        }
        toast(getString(R.string.full_skin_scan_done, imported));
        applyFullSkin();
        // Rebuild the pack list: close the stale dialog and reopen it.
        if (holder[0] != null) {
            holder[0].dismiss();
        }
        showSkinDialog();
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        if (requestCode == REQ_STORAGE) {
            startEmulator();
            return;
        }
        if (requestCode == REQ_ROMDIR) {
            if (resultCode == RESULT_OK && data != null && data.getData() != null) {
                addRomDirFromTree(data.getData());
            }
            return;
        }
        if (requestCode == REQ_SAVDIR) {
            if (resultCode == RESULT_OK && data != null && data.getData() != null) {
                importMyBoySaves(data.getData());
            }
            return;
        }
        if (requestCode == REQ_SKIN_IMPORT) {
            if (resultCode == RESULT_OK && data != null && data.getData() != null) {
                Uri source = data.getData();
                String name = displayName(source);
                if (name != null && name.toLowerCase(Locale.ROOT).endsWith(".zip")) {
                    name = name.substring(0, name.length() - 4);
                }
                final String skinName = name;
                new Thread(() -> {
                    final String imported = skinStore.importZip(this, source, skinName);
                    runOnUiThread(() -> {
                        if (imported == null) {
                            toast(getString(R.string.full_skin_bad));
                        } else {
                            getPreferences(MODE_PRIVATE).edit().putString("full_skin", imported).apply();
                            applyFullSkin();
                            toast(getString(R.string.full_skin_imported, imported));
                        }
                    });
                }, "skin-import").start();
            }
            return;
        }
        if (requestCode == REQ_STICKER) {
            if (resultCode == RESULT_OK && data != null && data.getData() != null) {
                // Copy the picked image into the app's private storage so the
                // sticker survives the source being moved or deleted.
                Uri source = data.getData();
                File dir = new File(getFilesDir(), "stickers");
                String copied = copyTo(source, dir, "sticker-" + DateFormat.format("yyyyMMdd-HHmmss", System.currentTimeMillis()) + ".png");
                if (copied == null || !stickerOverlay.addSticker(copied)) {
                    toast(getString(R.string.sticker_load_failed));
                } else {
                    stickerOverlay.setEditing(true);
                    toast(getString(R.string.sticker_added));
                }
            }
            return;
        }
        if (requestCode == REQ_BACKUP_EXPORT) {
            if (resultCode == RESULT_OK && data != null && data.getData() != null) {
                Uri target = data.getData();
                new Thread(() -> {
                    try {
                        String note = BackupTask.export(this, target);
                        runOnUiThread(() -> toast(getString(R.string.backup_done, note == null ? "完成" : note)));
                    } catch (Exception e) {
                        runOnUiThread(() -> toast(getString(R.string.backup_failed, e.getMessage())));
                    }
                }, "backup-export").start();
            }
            return;
        }
        if (requestCode == REQ_BACKUP_IMPORT) {
            if (resultCode == RESULT_OK && data != null && data.getData() != null) {
                Uri source = data.getData();
                new Thread(() -> {
                    try {
                        String note = BackupTask.restore(this, source);
                        runOnUiThread(() -> {
                            toast(getString(R.string.backup_restored, note));
                            applyInputSettings();
                            applyVideo();
                            applyCoreOptions();
                            applySkin();
                        });
                    } catch (Exception e) {
                        runOnUiThread(() -> toast(getString(R.string.backup_failed, e.getMessage())));
                    }
                }, "backup-restore").start();
            }
            return;
        }
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode != RESULT_OK || data == null || data.getData() == null) {
            return;
        }
        Uri uri = data.getData();
        if (requestCode == REQ_ROM) {
            importRom(uri);
        } else if (requestCode == REQ_BIOS) {
            new Thread(() -> importBios(uri), "bios-copy").start();
        } else if (requestCode == REQ_SHADER) {
            installShaderFrom(uri);
        }
    }

    @Override
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        setIntent(intent);
        if (intent != null && intent.getBooleanExtra("shot", false)) {
            takeScreenshot();
        }
        handleViewIntent(intent);
    }

    /** Handles a ROM the user opened from a file manager ("open with"). */
    private void handleViewIntent(@Nullable Intent intent) {
        if (intent == null || !Intent.ACTION_VIEW.equals(intent.getAction())) {
            return;
        }
        Uri uri = intent.getData();
        if (uri == null) {
            return;
        }
        String key = uri.toString();
        if (key.equals(handledRomUri)) {
            return;
        }
        handledRomUri = key;
        importRom(uri);
    }

    private void importRom(Uri uri) {
        importingRom = true;
        hint.setText(R.string.loading);
        hint.setVisibility(View.VISIBLE);
        new Thread(() -> {
            String path = resolveRom(uri);
            importingRom = false;
            if (path == null) {
                toast(getString(R.string.load_failed));
                return;
            }
            getPreferences(MODE_PRIVATE).edit().putString("lastRom", path).apply();
            pendingPath.set(path);
        }, "rom-import").start();
    }

    /**
     * Returns a path the loader can open. Files on shared storage are used in
     * place: copying a 32 MB ROM into the app directory doubles the space it
     * needs and fails outright when the device is nearly full.
     */
    @Nullable
    private String resolveRom(Uri uri) {
        String local = localPath(uri);
        if (local != null && new File(local).canRead()) {
            if (local.toLowerCase(Locale.ROOT).endsWith(".zip")) {
                String extracted = extractRomZip(new File(local));
                return extracted != null ? extracted : local;
            }
            return local;
        }
        String copied = copyTo(uri, new File(getFilesDir(), "roms"), null);
        if (copied != null && copied.toLowerCase(Locale.ROOT).endsWith(".zip")) {
            String extracted = extractRomZip(new File(copied));
            return extracted != null ? extracted : copied;
        }
        return copied;
    }

    /** Maps a document Uri to a real file path when its provider exposes one. */
    @Nullable
    private String localPath(@Nullable Uri uri) {
        if (uri == null) {
            return null;
        }
        String scheme = uri.getScheme();
        if (scheme == null || "file".equals(scheme)) {
            return uri.getPath();
        }
        if (!"content".equals(scheme) || !DocumentsContract.isDocumentUri(this, uri)) {
            return null;
        }
        String id;
        try {
            id = DocumentsContract.getDocumentId(uri);
        } catch (Exception e) {
            return null;
        }
        if (id == null) {
            return null;
        }
        String authority = uri.getAuthority();
        if ("com.android.externalstorage.documents".equals(authority)) {
            int colon = id.indexOf(':');
            if (colon <= 0 || colon + 1 >= id.length()) {
                return null;
            }
            String volume = id.substring(0, colon);
            String rest = id.substring(colon + 1);
            File base = "primary".equalsIgnoreCase(volume)
                    ? Environment.getExternalStorageDirectory()
                    : new File("/storage", volume);
            return new File(base, rest).getAbsolutePath();
        }
        if ("com.android.providers.downloads.documents".equals(authority) && id.startsWith("raw:")) {
            return id.substring(4);
        }
        return null;
    }

    private void importBios(Uri uri) {
        String name = displayName(uri);
        File temp = new File(getCacheDir(), "bios-import.bin");
        String copied = copyTo(uri, getCacheDir(), "bios-import.bin");
        if (copied == null) {
            toast(getString(R.string.bios_failed));
            return;
        }
        long size = temp.length();
        String lower = name == null ? "" : name.toLowerCase();
        String destName;
        if (lower.contains("gba") || size == 16384) {
            destName = "gba_bios.bin";
        } else if (lower.contains("gbc") || lower.contains("cgb") || size == 2304) {
            destName = "gbc_bios.bin";
        } else if (lower.contains("sgb")) {
            destName = "sgb_bios.bin";
        } else {
            destName = "gb_bios.bin";
        }
        File destDir = new File(new File(getFilesDir(), "config"), "mgba");
        destDir.mkdirs();
        File dest = new File(destDir, destName);
        if (!temp.renameTo(dest)) {
            String again = copyFile(temp, dest);
            temp.delete();
            if (again == null) {
                toast(getString(R.string.bios_failed));
                return;
            }
        }
        toast(getString(R.string.bios_imported, destName));
        String last = getPreferences(MODE_PRIVATE).getString("lastRom", null);
        if (last != null) {
            pendingPath.set(last);
        }
    }

    private String copyTo(Uri uri, File dir, @Nullable String forcedName) {
        dir.mkdirs();
        String name = forcedName != null ? forcedName : sanitize(displayName(uri));
        File out = new File(dir, name);
        try (InputStream in = getContentResolver().openInputStream(uri);
             OutputStream output = new FileOutputStream(out)) {
            if (in == null) {
                return null;
            }
            byte[] buffer = new byte[65536];
            int n;
            while ((n = in.read(buffer)) > 0) {
                output.write(buffer, 0, n);
            }
            output.flush();
            return out.getAbsolutePath();
        } catch (Exception e) {
            out.delete();
            return null;
        }
    }

    private static String copyFile(File src, File dest) {
        try (InputStream in = new java.io.FileInputStream(src);
             OutputStream output = new FileOutputStream(dest)) {
            byte[] buffer = new byte[65536];
            int n;
            while ((n = in.read(buffer)) > 0) {
                output.write(buffer, 0, n);
            }
            return dest.getAbsolutePath();
        } catch (Exception e) {
            return null;
        }
    }

    private String displayName(Uri uri) {
        try (Cursor cursor = getContentResolver().query(uri, new String[]{OpenableColumns.DISPLAY_NAME}, null, null, null)) {
            if (cursor != null && cursor.moveToFirst()) {
                return cursor.getString(0);
            }
        } catch (Exception ignored) {
        }
        return "game.gba";
    }

    private static String sanitize(String name) {
        if (name == null || name.trim().isEmpty()) {
            return "game.gba";
        }
        String clean = name.replaceAll("[\\\\/:*?\"<>|]", "_").trim();
        if (clean.length() > 120) {
            clean = clean.substring(clean.length() - 120);
        }
        return clean;
    }

    // == Custom ROM folders ==

    /** Absolute paths the player added; one per line in the preferences. */
    private static final String PREF_ROM_DIRS = "rom_dirs";

    private List<String> romDirs() {
        List<String> out = new ArrayList<>();
        String csv;
        try {
            csv = getPreferences(MODE_PRIVATE).getString(PREF_ROM_DIRS, "");
        } catch (ClassCastException e) {
            csv = "";
        }
        if (csv != null && !csv.isEmpty()) {
            for (String line : csv.split("\n")) {
                String path = line.trim();
                if (!path.isEmpty() && !out.contains(path)) {
                    out.add(path);
                }
            }
        }
        return out;
    }

    private void saveRomDirs(List<String> dirs) {
        StringBuilder csv = new StringBuilder();
        for (String dir : dirs) {
            if (csv.length() > 0) {
                csv.append('\n');
            }
            csv.append(dir);
        }
        getPreferences(MODE_PRIVATE).edit().putString(PREF_ROM_DIRS, csv.toString()).apply();
    }

    private boolean addRomDir(String path) {
        if (path == null || path.trim().isEmpty()) {
            return false;
        }
        File dir = new File(path.trim());
        String absolute = dir.getAbsolutePath();
        if (!dir.isDirectory() || !dir.canRead()) {
            toast(getString(R.string.rom_dirs_bad, absolute));
            return false;
        }
        List<String> dirs = romDirs();
        if (dirs.contains(absolute)) {
            toast(getString(R.string.rom_dirs_exists));
            return false;
        }
        dirs.add(absolute);
        saveRomDirs(dirs);
        toast(getString(R.string.rom_dirs_added, absolute));
        return true;
    }

    private void addRomDirFromTree(Uri tree) {
        try {
            getContentResolver().takePersistableUriPermission(tree,
                    Intent.FLAG_GRANT_READ_URI_PERMISSION | Intent.FLAG_GRANT_WRITE_URI_PERMISSION);
        } catch (Exception ignored) {
            // Some providers hand out a one-shot grant; the real path still works.
        }
        String path = treeToPath(tree);
        if (path == null) {
            toast(getString(R.string.rom_dirs_tree_bad));
            return;
        }
        if (addRomDir(path)) {
            showRomDirsDialog();
        }
    }

    /** Turns a document-tree Uri into a real path when the provider exposes one. */
    @Nullable
    private String treeToPath(@Nullable Uri tree) {
        if (tree == null) {
            return null;
        }
        String id;
        try {
            id = DocumentsContract.getTreeDocumentId(tree);
        } catch (Exception e) {
            return null;
        }
        if (id == null) {
            return null;
        }
        String authority = tree.getAuthority();
        if ("com.android.externalstorage.documents".equals(authority)) {
            int colon = id.indexOf(':');
            if (colon > 0 && colon + 1 <= id.length()) {
                String volume = id.substring(0, colon);
                String rest = id.substring(colon + 1);
                File base = "primary".equalsIgnoreCase(volume)
                        ? Environment.getExternalStorageDirectory()
                        : new File("/storage", volume);
                return new File(base, rest).getAbsolutePath();
            }
        }
        if ("com.android.providers.downloads.documents".equals(authority) && id.startsWith("raw:")) {
            return id.substring(4);
        }
        return null;
    }

    /** Manage the folders the ROM scan looks in first. */
    private void showRomDirsDialog() {
        final AlertDialog[] holder = new AlertDialog[1];
        ScrollView scroll = new ScrollView(this);
        LinearLayout box = new LinearLayout(this);
        box.setOrientation(LinearLayout.VERTICAL);
        int pad = dp(16);
        box.setPadding(pad, pad, pad, pad);
        scroll.addView(box);
        TextView hint = new TextView(this);
        hint.setText(R.string.rom_dirs_hint);
        hint.setTextColor(0xFF222222);
        hint.setTextSize(13);
        hint.setPadding(0, 0, 0, pad);
        box.addView(hint);

        List<String> dirs = romDirs();
        if (dirs.isEmpty()) {
            TextView empty = new TextView(this);
            empty.setText(R.string.rom_dirs_empty);
            empty.setTextColor(0xFF888888);
            box.addView(empty);
        }
        for (String dir : dirs) {
            LinearLayout row = new LinearLayout(this);
            row.setOrientation(LinearLayout.HORIZONTAL);
            row.setGravity(Gravity.CENTER_VERTICAL);
            TextView label = new TextView(this);
            label.setText(dir);
            label.setTextColor(0xFF222222);
            label.setTextSize(13);
            label.setSingleLine(true);
            row.addView(label, new LinearLayout.LayoutParams(0, LinearLayout.LayoutParams.WRAP_CONTENT, 1f));
            Button remove = new Button(this);
            remove.setAllCaps(false);
            remove.setText(R.string.rom_dirs_remove);
            final String target = dir;
            remove.setOnClickListener(v -> {
                List<String> next = romDirs();
                next.remove(target);
                saveRomDirs(next);
                toast(getString(R.string.rom_dirs_removed, target));
                if (holder[0] != null) {
                    holder[0].dismiss();
                }
                showRomDirsDialog();
            });
            row.addView(remove);
            box.addView(row);
        }
        Button pick = new Button(this);
        pick.setAllCaps(false);
        pick.setText(R.string.rom_dirs_pick);
        pick.setOnClickListener(v -> {
            if (holder[0] != null) {
                holder[0].dismiss();
            }
            Intent intent = new Intent(Intent.ACTION_OPEN_DOCUMENT_TREE);
            intent.addFlags(Intent.FLAG_GRANT_PERSISTABLE_URI_PERMISSION
                    | Intent.FLAG_GRANT_READ_URI_PERMISSION | Intent.FLAG_GRANT_WRITE_URI_PERMISSION);
            launchPicker(intent, REQ_ROMDIR);
        });
        box.addView(pick);
        Button manual = new Button(this);
        manual.setAllCaps(false);
        manual.setText(R.string.rom_dirs_manual);
        manual.setOnClickListener(v -> {
            final EditText input = new EditText(this);
            input.setHint(R.string.rom_dirs_manual_hint);
            input.setSingleLine(true);
            input.setText(Environment.getExternalStorageDirectory().getAbsolutePath() + "/");
            input.setSelection(input.getText().length());
            new AlertDialog.Builder(this)
                    .setTitle(R.string.rom_dirs_manual_title)
                    .setView(input)
                    .setPositiveButton(android.R.string.ok, (d, w) -> {
                        if (addRomDir(input.getText().toString())) {
                            if (holder[0] != null) {
                                holder[0].dismiss();
                            }
                            showRomDirsDialog();
                        }
                    })
                    .setNegativeButton(android.R.string.cancel, null)
                    .show();
        });
        box.addView(manual);
        AlertDialog dialog = new AlertDialog.Builder(this)
                .setTitle(R.string.rom_dirs_title)
                .setView(scroll)
                .setPositiveButton(android.R.string.ok, null)
                .setNeutralButton(R.string.scan_button, (d, w) -> showRomScan())
                .create();
        holder[0] = dialog;
        dialog.show();
    }

    /**
     * Looks for ROMs in the places they usually land: the download folder,
     * the app's own import folder, and the host-share folders that Windows
     * Android emulators (BlueStacks, MuMu, LDPlayer) mount on shared storage.
     * Those shares are how a file like {@code D:\gen8\rom.gba} becomes
     * reachable from inside the emulator.
     */
    private void showRomScan() {
        toast(getString(R.string.scan_scanning));
        new Thread(() -> {
            List<File> found = scanRoms();
            runOnUiThread(() -> showRomList(found));
        }, "rom-scan").start();
    }

    private void showRomList(List<File> found) {
        if (isFinishing()) {
            return;
        }
        if (found.isEmpty()) {
            new AlertDialog.Builder(this)
                    .setTitle(R.string.scan_title)
                    .setMessage(R.string.scan_empty)
                    .setPositiveButton(android.R.string.ok, null)
                    .show();
            return;
        }
        String root = Environment.getExternalStorageDirectory().getAbsolutePath();
        String[] labels = new String[found.size()];
        for (int i = 0; i < found.size(); i++) {
            File file = found.get(i);
            String path = file.getAbsolutePath();
            if (path.startsWith(root + File.separator)) {
                path = path.substring(root.length() + 1);
            }
            long bytes = file.length();
            String size = bytes >= (1 << 20)
                    ? String.format(Locale.ROOT, "%.1fMB", bytes / 1048576.0)
                    : Math.max(1, (bytes + 1023) / 1024) + "KB";
            labels[i] = getString(R.string.scan_entry, file.getName(), path, size)
                    + (hasBesideSaves(file) ? getString(R.string.scan_has_save) : "");
        }
        new AlertDialog.Builder(this)
                .setTitle(R.string.scan_title)
                .setItems(labels, (dialog, which) -> openFoundRom(found.get(which)))
                .show();
    }

    private void openFoundRom(File file) {
        if (!file.canRead()) {
            toast(getString(R.string.load_failed));
            return;
        }
        getPreferences(MODE_PRIVATE).edit().putString("lastRom", file.getAbsolutePath()).apply();
        hint.setText(R.string.loading);
        hint.setVisibility(View.VISIBLE);
        pendingPath.set(file.getAbsolutePath());
    }

    private List<File> scanRoms() {
        List<File> dirs = new ArrayList<>();
        final List<String> custom = romDirs();
        // Player-added folders come first: their games always top the list.
        for (String path : custom) {
            dirs.add(new File(path));
        }
        File external = Environment.getExternalStorageDirectory();
        File[] roots = {
                new File(external, "Download"),
                new File(external, "Downloads"),
                new File(external, "roms"),
                new File(external, "ROMs"),
                new File(external, "games"),
                new File(external, "mGBA"),
                // Host-share folders of Windows Android emulators.
                new File(external, "windows/BstSharedFolder"),
                new File(external, "MuMuSharedFolder"),
                new File(external, "BlueStacks"),
                new File("/mnt/shared"),
                new File(getFilesDir(), "roms"),
        };
        Collections.addAll(dirs, roots);
        String last = getPreferences(MODE_PRIVATE).getString("lastRom", null);
        if (last != null) {
            File parent = new File(last).getParentFile();
            if (parent != null) {
                dirs.add(parent);
            }
        }
        List<File> found = new ArrayList<>();
        Set<String> seen = new HashSet<>();
        for (File dir : dirs) {
            if (dir.isDirectory() && dir.canRead()) {
                collectRoms(dir, 0, found, seen);
            }
            if (found.size() >= ROM_SCAN_LIMIT) {
                break;
            }
        }
        // Games from the player's own folders stay at the top of the list.
        Collections.sort(found, (a, b) -> {
            boolean ca = inRomDir(a, custom);
            boolean cb = inRomDir(b, custom);
            if (ca != cb) {
                return ca ? -1 : 1;
            }
            return Long.compare(b.lastModified(), a.lastModified());
        });
        return found.size() > ROM_SCAN_LIMIT ? new ArrayList<>(found.subList(0, ROM_SCAN_LIMIT)) : found;
    }

    private static boolean inRomDir(File rom, List<String> dirs) {
        String path = rom.getAbsolutePath();
        for (String dir : dirs) {
            String prefix = dir.endsWith(File.separator) ? dir : dir + File.separator;
            if (path.startsWith(prefix)) {
                return true;
            }
        }
        return false;
    }

    private static void collectRoms(File dir, int depth, List<File> out, Set<String> seen) {
        if (depth > ROM_DIR_DEPTH || out.size() >= ROM_SCAN_LIMIT) {
            return;
        }
        File[] entries = dir.listFiles();
        if (entries == null) {
            return;
        }
        Arrays.sort(entries, Comparator.comparing(File::getName, String.CASE_INSENSITIVE_ORDER));
        for (File entry : entries) {
            if (out.size() >= ROM_SCAN_LIMIT) {
                return;
            }
            String path = entry.getAbsolutePath();
            if (!seen.add(path)) {
                continue;
            }
            if (entry.isDirectory()) {
                if (!entry.getName().startsWith(".")) {
                    collectRoms(entry, depth + 1, out, seen);
                }
            } else if (entry.isFile() && entry.length() > 0 && isRomFile(entry.getName())) {
                out.add(entry);
            }
        }
    }

    private static boolean isRomFile(String name) {
        String lower = name.toLowerCase(Locale.ROOT);
        return lower.endsWith(".gba") || lower.endsWith(".gbc") || lower.endsWith(".gb") || lower.endsWith(".sgb");
    }

    /** Pops the menu open and arms the auto-hide timer. */
    private void showMenu() {
        menuBar.setVisibility(View.VISIBLE);
        autoHideMenu();
    }

    private void hideMenuNow() {
        inputHandler.removeCallbacks(hideMenu);
        menuBar.setVisibility(View.GONE);
    }

    /** Hides the menu again after a moment without use; only while a game runs. */
    private void autoHideMenu() {
        inputHandler.removeCallbacks(hideMenu);
        if (core == null || !core.isLoaded() || layoutEditing) {
            return;
        }
        inputHandler.postDelayed(hideMenu, MENU_HIDE_MS);
    }

    /** Touching the menu at all keeps it open. */
    private void watchMenuTouches(View view) {
        view.setOnTouchListener((v, event) -> {
            if (event.getActionMasked() == MotionEvent.ACTION_DOWN) {
                autoHideMenu();
            }
            return false;
        });
        if (view instanceof ViewGroup) {
            ViewGroup group = (ViewGroup) view;
            for (int i = 0; i < group.getChildCount(); i++) {
                watchMenuTouches(group.getChildAt(i));
            }
        }
    }

    /**
     * Keeps the menu handle out of the keys' way: next to the on-screen START
     * key in landscape, on the top edge of the lower screen in portrait.
     */
    private void positionMenuButton() {
        if (menuButton == null || controls == null) {
            return;
        }
        // The portrait shell has its own toolbar with a menu icon; the loose
        // handle would only overlap it.
        if (skinStylePref() == ControlsView.STYLE_HANDHELD
                && getResources().getConfiguration().orientation == Configuration.ORIENTATION_PORTRAIT) {
            menuButton.setVisibility(View.GONE);
            return;
        }
        menuButton.setVisibility(View.VISIBLE);
        ViewGroup.LayoutParams params = menuButton.getLayoutParams();
        if (!(params instanceof FrameLayout.LayoutParams)) {
            return;
        }
        FrameLayout.LayoutParams lp = (FrameLayout.LayoutParams) params;
        int height = menuButton.getHeight() > 0 ? menuButton.getHeight() : dp(24);
        int left;
        int top;
        if (screenArea != null && screenArea.isPortraitMode()) {
            // Portrait: the lower screen belongs to the keys, so the handle
            // moves to its top edge instead of crowding START and A. The stage
            // centres it horizontally; only the offset below the split is set.
            left = 0;
            top = dp(8);
        } else {
            RectF start = new RectF();
            controls.getStartRect(start);
            if (start.width() <= 0f) {
                return;
            }
            left = (int) start.right + dp(4);
            top = (int) start.centerY() - height / 2;
        }
        if (lp.gravity == (Gravity.TOP | Gravity.START) && lp.leftMargin == left && lp.topMargin == top) {
            return;
        }
        lp.gravity = Gravity.TOP | Gravity.START;
        lp.leftMargin = left;
        lp.topMargin = top;
        menuButton.setLayoutParams(lp);
    }

    /**
     * Starts the ported GBoy link: the visible core plus a hidden mirror core
     * joined over loopback SIO, with key masks supplied by the cloud session's
     * slot 2 at the official five-frame cadence. Inert until called.
     */
    public boolean startGBoyLink(File rom, File saveDir, File stateDir, int port) {
        stopGBoyLink();
        if (core == null || !core.isLoaded()) {
            return false;
        }
        // In the official layout the mirror console consumes remote keys; the
        // "separate control" debug switch would inject them into P1 as well.
        gboyRemoteKeysEnabled = false;
        gboyRemoteKeys = 0;
        GBoyLinkSession session = cloudLink == null ? null : cloudLink.linkSession();
        Log.i(TAG, "cloud link session=" + (session == null ? "NULL" : "ok")
                + " cloud=" + (cloudLink == null ? "null" : "set"));
        /* 云端官方镜像模式保持 netLink 环回（4 参构造）。
         *
         * 曾改试进程内锁步房间（7 参构造 useLockstep=true），房间确实建起来了
         * （LOCKSTEP host/join slot 0/1），但游戏还在标题画面、没有 SIO 轮次
         * 可供协调器会合时，模拟线程从房间建立那一刻起完全停止输出 FRM，
         * 画面冻结、按键无效。本机锁步的 59.7fps 实测是 GBOY_LOCAL_LINK +
         * busgame 帧脚本驱动的组合，云端路径缺这套帧驱动，不能直接套用。 */
        /* 4 核验证：大竞技场多人对战要求 4 名玩家，2 核时游戏把角色锁在
         * 球场、停在 overworld 主循环（cb2=08170A81）不进对战。每台设备跑
         * 1 可见核 + 3 镜像核，网络仍只传按键。 */
        GBoyConsoleSet set = new GBoyConsoleSet(rom, saveDir, stateDir, port, 4, 1, true);
        boolean ok = set.start(core, session);
        if (!ok) {
            /* 锁步房间起不来就退回旧的环回 TCP 布局，至少还能单核+镜像跑起来。 */
            Log.w(TAG, "cloud lockstep start failed (" + set.failure() + "), falling back to loopback");
            set = new GBoyConsoleSet(rom, saveDir, stateDir, port);
            ok = set.start(core, session);
        }
        consoleSet = set;
        return ok;
    }

    /**
     * Official local TCP link: two devices on the same network or hotspot talk
     * directly, with no cloud room. {@code asHost=true} listens on tcpPort;
     * otherwise peer is the host address. sioPort is the separate loopback port
     * used by the two local consoles. The official handshake (type 1 / int 6)
     * runs on the TCP link while key masks feed the hidden mirror console.
     */
    /** 联机对话框里「开房 / 加入（3/4 人）」的入口：校验输入后开会话。
     * 勾选「本机多核锁步」时改走 N 核 + 进程内锁步路径，否则保持单核星型总线。 */
    private void busStart(boolean asHost, EditText peerBox, EditText playersBox,
                          CheckBox lockstepBox, TextView status) {
        int players;
        try {
            players = Integer.parseInt(playersBox.getText().toString().trim());
        } catch (NumberFormatException e) {
            players = 0;
        }
        if (players < 3 || players > 4) {
            status.setText("人数只能填 3 或 4");
            return;
        }
        String peer = peerBox.getText().toString().trim();
        if (!asHost && peer.isEmpty()) {
            status.setText("加入时请填房主 IP");
            return;
        }
        boolean lockstep = lockstepBox != null && lockstepBox.isChecked();
        // 记住输入，免得每次重连都要重打。
        getPreferences(MODE_PRIVATE).edit()
                .putInt("bus_players", players)
                .putString("bus_peer", peer)
                .putBoolean("bus_lockstep", lockstep)
                .apply();
        useLockstep = lockstep;   // startGBoyLocalLink 的 7 参 GBoyConsoleSet 会读它
        boolean ok;
        if (lockstep) {
            String romPath = currentRomPath != null ? currentRomPath
                    : getPreferences(MODE_PRIVATE).getString("lastRom", null);
            if (romPath == null || romPath.isEmpty()) {
                status.setText("启动失败：请先加载 ROM");
                return;
            }
            File save = defaultSaveDir != null ? defaultSaveDir : getFilesDir();
            File stateDir = defaultStateDir != null ? defaultStateDir
                    : new File(getFilesDir(), "state");
            ok = startGBoyLocalLink(new File(romPath), save, stateDir, 18781,
                    BUS_TCP_PORT, peer, asHost, players, 1);
        } else {
            ok = startBusLink(players, BUS_TCP_PORT, peer, asHost);
        }
        status.setText(ok
                ? (lockstep
                    ? (asHost ? "已开房（" + players + " 人，本机多核锁步）"
                              : "已加入房间（本机多核锁步）")
                    : (asHost ? "已开房（" + players + " 人，端口 " + BUS_TCP_PORT + "），等待其他玩家加入"
                              : "已加入房间（" + players + " 人）"))
                : "启动失败：请确认 ROM 已加载、端口未被占用");
    }

    /**
     * 3/4 人联机：每台设备只跑自己的那个核，四台设备之间由 native 星型总线
     * 互连 —— 主机 accept 最多 players-1 个从机，每轮收齐所有从机的字后连同
     * 自己的字一次广播，于是每台的 SIOMULTI0..3 都能填满。
     *
     * 两人不走这里：两人有本机镜像核那条已经验证过的路径（见
     * {@link #startGBoyLocalLink}），行为和帧率都别动。
     */
    public boolean startBusLink(int players, int tcpPort, String peer, boolean asHost) {
        stopGBoyLink();
        if (core == null || !core.isLoaded()) {
            return false;
        }
        if (players < 3 || players > 4) {
            toast("多人联机人数只支持 3 或 4");
            return false;
        }
        if (!asHost && (peer == null || peer.isEmpty())) {
            toast("多人联机缺少主机地址");
            return false;
        }
        boolean ok = asHost ? core.linkHost(tcpPort, players)
                            : core.linkJoin(peer, tcpPort, players);
        if (!ok) {
            toast("多人联机连接失败");
            return false;
        }
        busLinkActive = true;
        Log.i(TAG, "bus link host=" + asHost + " players=" + players + " tcp=" + tcpPort);
        toast(asHost ? "多人联机：已开房，等待 " + (players - 1) + " 名玩家加入"
                     : "多人联机：已加入房间");
        return true;
    }

    /** Two-player entry kept for callers that do not specify a console count. */
    public boolean startGBoyLocalLink(File rom, File saveDir, File stateDir,
                                      int sioPort, int tcpPort, String peer,
                                      boolean asHost) {
        return startGBoyLocalLink(rom, saveDir, stateDir, sioPort, tcpPort, peer, asHost, 2, 1);
    }

    /** Keeps the console visible on slot 1 for callers without a slot. */
    public boolean startGBoyLocalLink(File rom, File saveDir, File stateDir,
                                      int sioPort, int tcpPort, String peer,
                                      boolean asHost, int players) {
        return startGBoyLocalLink(rom, saveDir, stateDir, sioPort, tcpPort, peer,
                                  asHost, players, 1);
    }

    /**
     * @param players 2..4 consoles in this process. 3/4 join a local star bus;
     *                the network link still carries only key masks.
     * @param localSlot slot of the console owned by this device (1..players).
     *                  Devices in a 3/4-player session must use distinct slots
     *                  so key frames reach the right mirror console. The native
     *                  link still pins the visible core to link slot 1; making
     *                  the visible core occupy an arbitrary global slot needs a
     *                  matching change in GBoyConsoleSet and link_net.c.
     */
    public boolean startGBoyLocalLink(File rom, File saveDir, File stateDir,
                                      int sioPort, int tcpPort, String peer,
                                      boolean asHost, int players, int localSlot) {
        stopGBoyLink();
        final int consoleCount = Math.max(2, Math.min(players, GBoyLinkSession.MAX_CONSOLES));
        final int slot = Math.max(1, Math.min(localSlot, consoleCount));
        if (core == null || !core.isLoaded() || (!asHost && (peer == null || peer.isEmpty()))) {
            return false;
        }
        // The official client synchronises save state only after the session is
        // ready. Sending it from start() raced the peer's mirror console, so
        // the snapshot is now sent once, from onReady().
        final AtomicBoolean initialStateSent = new AtomicBoolean();
        GBoyLinkSession.Events events = new GBoyLinkSession.Events() {
            @Override
            public void onReset() {
                runOnUiThread(() -> {
                    if (core != null && core.isLoaded()) {
                        core.reset();
                        core.clearAudio();
                    }
                });
            }

            @Override
            public void onState(byte[] state) {
                Log.i(TAG, "local link TYPE_STATE " + state.length + " bytes");
                GBoyConsoleSet set = consoleSet;
                if (set == null || !set.applyRemoteState(state)) {
                    Log.w(TAG, "local link TYPE_STATE not applied");
                }
            }

            @Override
            public void onReady() {
                Log.i(TAG, "local link handshake complete");
                // saveStateToMemory() touches the running core, so hop back to
                // the UI thread before taking the snapshot.
                if (asHost && initialStateSent.compareAndSet(false, true)) {
                    runOnUiThread(() -> {
                        GBoyConsoleSet set = consoleSet;
                        GBoySocketLink link = localLink;
                        if (set == null || link == null) {
                            Log.w(TAG, "local link initial state skipped: consoles not ready");
                            return;
                        }
                        byte[] snapshot = set.snapshotState();
                        if (snapshot == null || snapshot.length == 0) {
                            Log.w(TAG, "local link initial state skipped: empty snapshot");
                            return;
                        }
                        link.session().sendState(snapshot);
                        Log.i(TAG, "local link initial state sent " + snapshot.length + " bytes");
                    });
                }
                runOnUiThread(() -> toast("本地联机已就绪"));
            }

            @Override
            public void onStatus(String text) {
                Log.i(TAG, "local link " + text);
            }
        };
        try {
            GBoySocketLink link = new GBoySocketLink(slot, consoleCount, events);
            if (asHost) {
                link.startHost(tcpPort);
            } else {
                link.startJoin(peer, tcpPort);
            }
            localLink = link;
            gboyRemoteKeysEnabled = false;
            gboyRemoteKeys = 0;
            GBoyConsoleSet set = new GBoyConsoleSet(rom, saveDir, stateDir, sioPort,
                    consoleCount, slot, useLockstep);
            boolean ok = set.start(core, link.session());
            consoleSet = set;
            Log.i(TAG, "local link ncore=" + consoleCount + " slot=" + slot
                    + " useLockstep=" + useLockstep + " started=" + ok
                    + " err=" + gboyLinkFailure());
            return ok;
        } catch (java.io.IOException e) {
            GBoySocketLink link = localLink;
            if (link != null) {
                link.close();
                localLink = null;
            }
            toast("本地联机连接失败：" + e.getMessage());
            return false;
        }
    }

    /** Stops the mirror core and closes the loopback and TCP links. */
    public void stopGBoyLink() {
        GBoyConsoleSet set = consoleSet;
        consoleSet = null;
        if (set != null) {
            set.stop();
        }
        GBoySocketLink link = localLink;
        localLink = null;
        if (link != null) {
            link.close();
        }
        if (busLinkActive) {
            busLinkActive = false;
            MgbaCore c = core;
            if (c != null) {
                c.linkClose();
            }
        }
    }

    /**
     * Feeds the frame number and local key mask to every active GBoy session.
     * The local TCP link owns its own session and has no cloud link behind it,
     * so without this call it would never broadcast keys at the official
     * five-frame (12 Hz) cadence.
     */
    private void driveLinkSessions(long frame, int keys) {
        if (cloudLink != null) {
            cloudLink.onLocalFrame(frame, keys);
        }
        GBoySocketLink socket = localLink;
        if (socket != null) {
            socket.session().onLocalFrame(frame, keys);
        }
    }

    /** Empty on success, otherwise the setup error of the last start. */
    public String gboyLinkFailure() {
        GBoyConsoleSet set = consoleSet;
        return set == null ? "" : set.failure();
    }

    private void emulationLoop() {
        android.os.Process.setThreadPriority(android.os.Process.THREAD_PRIORITY_URGENT_DISPLAY);
        long frames = 0;
        long slices = 0;
        long fpsStamp = System.nanoTime();
        // Wall-clock start of the next emulation slice. Slices are scheduled
        // against this absolute target (instead of sleeping for the rest of
        // each slice), so a sleep that oversleeps cannot accumulate and slow
        // the loop - and with it the audio's pitch - down.
        long nextSlice = fpsStamp;
        while (running) {
            try {
                if (core != null) {
                    core.pumpLink();
                }
                String path = pendingPath.getAndSet(null);
                if (path != null) {
                    Log.i(TAG, "emu loop reloading " + path);
                    loadRom(path);
                    // Loading blocks for a while; start the pacing schedule
                    // and the feedback window fresh so the stall is not
                    // measured as this front end being slow.
                    nextSlice = System.nanoTime();
                    slices = 0;
                    fpsStamp = nextSlice;
                    // busgame 调试脚本：重载后立刻武装可见核（f=0 = 复位帧），
                    // 必须在模拟线程做——广播线程直接换核会踩已释放的旧核。
                    // loadRom 的复位会卸掉可见核的锁步驱动，武装后按原槽位
                    // 重挂回房间（native 入口已会清残留槽位）。
                    if (pendingBusGameMenuAt >= 0) {
                        core.busGameStart(consoleSet != null ? consoleSet.visibleSlotIdx() : 0,
                                pendingBusGameMenuAt, pendingBusGameModeDowns);
                        GBoyConsoleSet set = consoleSet;
                        if (set != null) {
                            set.rearmLockstepVisible();
                        }
                        Log.i(TAG, "busgame visible core armed menuAt="
                                + pendingBusGameMenuAt + " modeDowns=" + pendingBusGameModeDowns);
                        pendingBusGameMenuAt = -1;
                    } else if (pendingCloudRearm) {
                        pendingCloudRearm = false;
                        /* 重建整个 2 核房间，而不是 rearmLockstepVisible()。
                         * rearm 走的是 join，协调器的 runner 是 attachedPlayers[0]，
                         * 可见核 detach 再 join 之后它会排到镜像核后面 —— runner
                         * 变成镜像核，而镜像核一旦被 park 就再没人推进回合，
                         * 两核同时停摆（实测：镜像核 32 秒只跑 1 帧、之后整块
                         * 不推进）。重建时可见核重新当 host（先 attach），两核
                         * 又都在第 0 帧，起点一致。 */
                        GBoyConsoleSet old = consoleSet;
                        if (old != null) {
                            old.stop();
                        }
                        consoleSet = null;
                        File save = defaultSaveDir != null ? defaultSaveDir : getFilesDir();
                        File state = defaultStateDir != null
                                ? defaultStateDir : new File(getFilesDir(), "state");
                        GBoyLinkSession session = cloudLink == null ? null : cloudLink.linkSession();
                        GBoyConsoleSet rebuilt = new GBoyConsoleSet(
                                new File(currentRomPath), save, state, 18781, 4, 1, true);
                        if (rebuilt.start(core, session)) {
                            consoleSet = rebuilt;
                            Log.i(TAG, "cloud arm: 2-core room rebuilt, visible slot="
                                    + rebuilt.visibleSlotIdx());
                        } else {
                            Log.e(TAG, "cloud arm: rebuild failed: " + rebuilt.failure());
                        }
                        /* 可见核已被复位到第 0 帧，和镜像核起点一致；放开帧闸门，
                         * 两核从现在开始同步起跑。 */
                        suppressAutoState = false;
                        linkArmHold = false;
                        Log.i(TAG, "cloud arm released: frames unlocked");
                    }
                }
                int cmd = command.getAndSet(0);
                if (cmd != 0) {
                    runCommand(cmd);
                    nextSlice = System.nanoTime();
                    slices = 0;
                    fpsStamp = nextSlice;
                }
                if (!surfaceReady || paused || linkArmHold || !core.isLoaded()) {
                    // Do not carry stale pacing across a paused stretch: a
                    // resumed game would otherwise be reported as a slow front
                    // end for one window.
                    slices = 0;
                    fpsStamp = System.nanoTime();
                    Thread.sleep(16);
                    continue;
                }
                // Continuous rewind: steps one second of history at a time
                // while the button stays held.
                if (rewindHold) {
                    long nowRewind = System.nanoTime();
                    if (nowRewind - lastRewindAt >= 400_000_000L) {
                        lastRewindAt = nowRewind;
                        if (core.rewind(1)) {
                            core.clearAudio();
                            presentFrame();
                        } else {
                            rewindHold = false;
                            toast(getString(R.string.rewind_empty));
                        }
                    }
                    slices = 0;
                    fpsStamp = System.nanoTime();
                    Thread.sleep(16);
                    continue;
                }
                float factor = fastHold || ffOn ? Math.max(speed, fastHoldSpeed()) : speed;
                if (syncFastAudio(factor)) {
                    // Fresh feedback windows for the new speed, same as after a
                    // stall: the stall of switching must not be measured as
                    // this front end's pacing rate. The sustainable rate also
                    // differs per speed, so re-learn it.
                    slices = 0;
                    frames = 0;
                    fpsStamp = System.nanoTime();
                    fastPace = 0f;
                    fastSliceNanos = 0L;
                    fastResyncs = 0;
                }
                // Fractional speeds (slow motion) accumulate whole frames in a
                // small debt; integer speeds drain it every slice.
                frameDebt += factor;
                if (frameDebt > 48f) {
                    frameDebt = 48f;
                }
                int framesToRun = (int) frameDebt;
                if (framesToRun > 0) {
                    frameDebt -= framesToRun;
                    // Run in a few steps, pumping audio in between: a
                    // fast-forward burst produces several frames of audio at
                    // once and the core's audio buffer only holds a little
                    // more than that, so leaving it undrained drops samples
                    // and makes fast-forward sound garbled.
                    int steps = (framesToRun + AUDIO_STEP_FRAMES - 1) / AUDIO_STEP_FRAMES;
                    int step = (framesToRun + steps - 1) / steps;
                    for (int done = 0; done < framesToRun; ) {
                        int n = Math.min(step, framesToRun - done);
                        GBoyConsoleSet consoles = consoleSet;
                        boolean multi = consoles != null
                                && consoles.state() == GBoyConsoleSet.State.READY;
                        if (multi) {
                            // Lock-step: one frame on each console, so every
                            // loopback MULTI round stays paired.
                            for (int f = 0; f < n; ++f) {
                                int frameKeys = userKeys();
                                driveLinkSessions(netFrameNo, frameKeys);
                                consoles.beginFrame(netFrameNo);
                                core.runFrames(frameKeys, 1);
                                consoles.endFrame(netFrameNo);
                                ++netFrameNo;
                            }
                        } else {
                            // Single core still feeds the official 12 Hz key
                            // cadence; the legacy 50 ms timer takes over only
                            // if the frame loop is not wired up.
                            for (int f = 0; f < n; ++f) {
                                driveLinkSessions(netFrameNo, userKeys());
                                ++netFrameNo;
                            }
                            core.runFrames(userKeys(), n);
                        }
                        // 倍速也有声音：重采样器按倍速变速输出（磁带式）。
                        // The resampler follows the console's true frame time;
                        // the measured pace is reported to the core once a
                        // second.
                        pumpAudio();
                        done += n;
                    }
                    pollRumble();
                } else {
                    pumpAudio();
                }
                if (factor <= 1.5f) {
                    presentFrame();
                } else {
                    long now = System.nanoTime();
                    if (now >= nextFastPresent) {
                        presentFrame();
                        nextFastPresent = now + 80_000_000L;
                    }
                }
                frames += framesToRun;
                slices++;
                // Schedule slices against an absolute next start. A sleep that
                // oversleeps then cannot accumulate into a loop that runs (and
                // pitches the music) slightly slow; a stall that leaves the
                // loop more than two slices behind starts a fresh schedule
                // instead of replaying a catching-up burst.
                //
                // While fast-forwarding the device usually cannot hold the
                // requested speed, and pure free-running (rescheduling from
                // "now" every slice) lets every scheduling hiccup straight
                // into the game speed - and with tape-style audio, into the
                // pitch. The schedule therefore eases toward the rate the
                // device actually sustains, measured once per feedback window:
                // the first window free-runs and locks that rate; while the
                // schedule holds with slack it climbs gently (additive), and
                // whenever slices had to resync it follows the delivered rate
                // back down (multiplicative). A delivered-rate schedule alone
                // would ratchet - one noisy low window would slow the pace for
                // good, since a paced loop can never deliver more than its own
                // schedule - and a work-time measure is polluted by the
                // every-80ms presentation cost, which made the schedule
                // thrash. Additive-increase/multiplicative-decrease avoids
                // both.
                boolean fastPacing = factor > 1.5f && fastSliceNanos > 0;
                long paceNanos = fastPacing ? fastSliceNanos : sliceNanos;
                nextSlice += paceNanos;
                if (System.nanoTime() - nextSlice > 2 * paceNanos) {
                    nextSlice = System.nanoTime();
                    if (factor > 1.5f) {
                        fastResyncs++;
                    }
                } else {
                    long remain = nextSlice - System.nanoTime();
                    if (remain > 1_000_000L) {
                        Thread.sleep(remain / 1_000_000L, (int) (remain % 1_000_000L));
                    }
                }
                // 自动跳帧：the loop keeps score of how consistently it lands
                // late, and eases one or two skip levels in or out so slow
                // devices hold speed without stuttering every frame.
                if (skipAuto) {
                    long late = System.nanoTime() - nextSlice;
                    lateStreak = late > 0 ? Math.min(lateStreak + 1, 90) : Math.max(lateStreak - 3, 0);
                    int want = lateStreak > 60 ? 2 : lateStreak > 30 ? 1 : 0;
                    if (want != autoSkipLevel) {
                        autoSkipLevel = want;
                        core.setFrameskip(want);
                    }
                }
                long now = System.nanoTime();
                if (now - fpsStamp >= 1000000000L) {
                    long shown = frames;
                    long cycles = slices;
                    long elapsed = now - fpsStamp;
                    frames = 0;
                    slices = 0;
                    fpsStamp = now;
                    // How many pacing cycles the loop really completed this
                    // window: the audio resampler follows this rate so heavy
                    // games that cannot hold the console's frame time do not
                    // starve it.
                    if (elapsed > 0) {
                        float achieved = cycles * 1_000_000_000f / elapsed;
                        core.setAudioPaceFps(achieved);
                        // The window's reading locked the pace (or refreshed the
                        // seed): playback may start.
                        paceSeeded = true;
                        if (factor > 1.5f) {
                            // Ease the fast-forward schedule toward the rate the
                            // device actually sustains: lock on the first window
                            // (it free-ran, so the reading is raw capability),
                            // follow the delivered rate down after any resync,
                            // and climb gently while the schedule held with
                            // slack - capped at the requested pacing rate.
                            if (fastPace <= 0f) {
                                fastPace = achieved;
                            } else if (fastResyncs > 0) {
                                fastPace += (achieved - fastPace) * 0.4f;
                            } else {
                                fastPace = Math.min(fastPace * 1.03f, 1_000_000_000f / sliceNanos);
                            }
                            fastSliceNanos = (long) (1_000_000_000f / fastPace);
                        }
                    } else {
                        core.setAudioPaceFps(0f);
                    }
                    fastResyncs = 0;
                    // Rounded so the console's own 59.73 fps still shows as the
                    // 60 the counter has always displayed.
                    long shownFps = elapsed > 0 ? Math.round(shown * 1_000_000_000.0 / elapsed) : 0;
                    float shownSpeedF = fastHold || ffOn ? Math.max(speed, fastHoldSpeed()) : speed;
                    String speedText = shownSpeedF == (long) shownSpeedF
                            ? String.valueOf((long) shownSpeedF)
                            : String.format(Locale.US, "%.2f", shownSpeedF);
                    runOnUiThread(() -> fpsView.setText(speedText + "倍 " + shownFps + "fps"));
                }
            } catch (InterruptedException e) {
                if (!running) {
                    break;
                }
            } catch (Exception e) {
                Log.i(TAG, "emu loop exception", e);
                toast(e.getMessage() == null ? getString(R.string.load_failed) : e.getMessage());
                try {
                    Thread.sleep(200);
                } catch (InterruptedException ignored) {
                    // wakeInput() interrupts this thread on every key press, so
                    // rapid tapping lands interrupts almost anywhere. Losing the
                    // throttle sleep must never end emulation - that silently
                    // froze the game until restart. Only running == false exits.
                }
            }
        }
    }

    // == ROMs and saves in the same folder ==

    /** Name of a ROM without its extension; saves and states share it. */
    private static String romBaseName(File rom) {
        String name = rom.getName();
        int dot = name.lastIndexOf('.');
        return dot > 0 ? name.substring(0, dot) : name;
    }

    /** Whether a battery save or save state already sits beside this ROM. */
    private boolean hasBesideSaves(File rom) {
        if (rom == null || !rom.isFile()) {
            return false;
        }
        File parent = rom.getAbsoluteFile().getParentFile();
        if (parent == null) {
            return false;
        }
        String base = romBaseName(rom);
        String[] battery = {".sav", ".srm", ".sa1", ".sa2", ".sa3", ".sa4"};
        for (String suffix : battery) {
            File file = new File(parent, base + suffix);
            if (file.isFile() && file.length() > 0) {
                return true;
            }
        }
        for (int slot = 0; slot <= 9; slot++) {
            File file = new File(parent, base + ".ss" + slot);
            if (file.isFile() && file.length() > 0) {
                return true;
            }
        }
        return false;
    }

    /**
     * Saves live beside the ROM when the player already keeps them there (or
     * explicitly asks for it); otherwise the shared folders stay in use so
     * existing saves are never orphaned.
     */
    private void applyRomSaveLocation(String romPath) {
        File rom = new File(romPath).getAbsoluteFile();
        File parent = rom.getParentFile();
        boolean beside = parent != null && parent.canWrite()
                && (hasBesideSaves(rom)
                    || getPreferences(MODE_PRIVATE).getBoolean("saves_beside_rom", false));
        File saveDir = beside ? parent : defaultSaveDir;
        File stateDir = beside ? parent : defaultStateDir;
        if (saveDir == null) {
            saveDir = SaveLocation.prepare(this);
        }
        if (stateDir == null) {
            stateDir = new File(getFilesDir(), "states");
        }
        activeStateDir = stateDir;
        if (core != null) {
            core.setSaveDirs(saveDir.getAbsolutePath(), stateDir.getAbsolutePath());
        }
    }

    private void loadRom(String path) {
        releaseAudio();
        currentRomPath = path;
        applyRomSaveLocation(path);
        romCrc = romCrc32(path);
        boolean ok = core.load(path);
        if (!ok) {
            runOnUiThread(() -> {
                hint.setText(R.string.load_failed);
                hint.setVisibility(View.VISIBLE);
                setTitle(R.string.app_name);
                showMenu();
            });
            toast(getString(R.string.load_failed));
            return;
        }
        applyPerRomSettings();
        long frameNanos = core.frameNanos();
        sliceNanos = frameNanos > 0 ? frameNanos : 1_000_000_000L / 60L;
        frameDebt = 0f;
        nextFastPresent = 0L;
        setupAudio();
        paused = false;
        boolean autoState = getPreferences(MODE_PRIVATE).getBoolean("auto_load_state", false)
                && !suppressAutoState;
        if (autoState
                && core.loadState(AUTO_SLOT)) {
            core.clearAudio();
            core.runFrames(userKeys(), 1);
        }
        String title = core.title();
        runOnUiThread(() -> {
            hint.setVisibility(View.GONE);
            pauseButton.setText(R.string.pause);
            showSaveLocation();
            setTitle(title == null || title.trim().isEmpty() ? getString(R.string.app_name) : title.trim());
            autoHideMenu();
            refreshGifBall();
            startNoticeIfWanted(title == null || title.trim().isEmpty()
                    ? getString(R.string.app_name) : title.trim());
        });
        autoSyncOnLoad();
        startTimedSave();
    }

    /** CRC32 of a ROM file, cached; the per-game settings key. */
    private long romCrc32(String path) {
        Long cached = crcCache.get(path);
        if (cached != null) {
            return cached;
        }
        java.util.zip.CRC32 crc = new java.util.zip.CRC32();
        try (InputStream in = new java.io.FileInputStream(path)) {
            byte[] buffer = new byte[65536];
            int n;
            while ((n = in.read(buffer)) > 0) {
                crc.update(buffer, 0, n);
            }
        } catch (Exception e) {
            return -1;
        }
        long value = crc.getValue();
        crcCache.put(path, value);
        return value;
    }

    /** Re-reads the per-game overrides and pushes them on top of the globals. */
    private void applyPerRomSettings() {
        perRomFilter = -1;
        perRomSpeed = null;
        perRomSaveType = null;
        perRomPalette = null;
        if (romDb == null || romCrc < 0) {
            return;
        }
        String filter = romDb.get(romCrc, "filter", RomSettingsDb.DEFAULT);
        if (!RomSettingsDb.DEFAULT.equals(filter)) {
            try {
                perRomFilter = Integer.parseInt(filter);
            } catch (NumberFormatException ignored) {
            }
        }
        String speed = romDb.get(romCrc, "speed", RomSettingsDb.DEFAULT);
        if (!RomSettingsDb.DEFAULT.equals(speed)) {
            try {
                perRomSpeed = Float.parseFloat(speed);
            } catch (NumberFormatException ignored) {
            }
        }
        String saveType = romDb.get(romCrc, "save_type", RomSettingsDb.DEFAULT);
        if (!RomSettingsDb.DEFAULT.equals(saveType)) {
            try {
                perRomSaveType = Integer.parseInt(saveType);
            } catch (NumberFormatException ignored) {
            }
        }
        String paletteValue = romDb.get(romCrc, "gb_palette", RomSettingsDb.DEFAULT);
        if (!RomSettingsDb.DEFAULT.equals(paletteValue)) {
            try {
                perRomPalette = Integer.parseInt(paletteValue);
            } catch (NumberFormatException ignored) {
            }
        }
        // Overlay the per-game values on the global settings, view first.
        runOnUiThread(() -> {
            if (perRomFilter >= 0 && perRomFilter < Shaders.FILTER_COUNT) {
                gameView.setFilter(perRomFilter);
            } else {
                gameView.setFilter(getPreferences(MODE_PRIVATE).getInt("vf_filter", Shaders.FILTER_NONE));
            }
        });
        if (perRomSaveType != null) {
            core.setSaveType(perRomSaveType);
        } else {
            core.setSaveType(saveTypePref());
        }
        int[] palette = gbPaletteColors();
        if (perRomPalette != null && perRomPalette >= 0 && perRomPalette < GB_PALETTES.length) {
            palette = new int[12];
            int[] base = GB_PALETTES[perRomPalette];
            for (int i = 0; i < 12; i++) {
                palette[i] = base[i % 4];
            }
        }
        core.setGbPalette(palette);
        if (perRomSpeed != null) {
            setSpeed(perRomSpeed);
        }
        String summary = perRomSummary();
        if (!summary.isEmpty()) {
            toast(getString(R.string.per_rom_applied, summary));
        }
    }

    private String perRomSummary() {
        StringBuilder out = new StringBuilder();
        if (perRomFilter >= 0) {
            out.append(filterName(perRomFilter)).append(' ');
        }
        if (perRomSpeed != null) {
            out.append(speedLabel(perRomSpeed)).append("× ");
        }
        if (perRomSaveType != null) {
            out.append(saveTypeName(perRomSaveType)).append(' ');
        }
        if (perRomPalette != null) {
            out.append(paletteName(perRomPalette));
        }
        return out.toString().trim();
    }

    private void runCommand(int cmd) {
        if (!core.isLoaded()) {
            toast(getString(R.string.no_rom));
            return;
        }
        int current = slot;
        if (cmd == CMD_SAVE) {
            boolean ok = core.saveState(current);
            if (ok) {
                writeStatePreview(current);
            } else {
                recyclePendingPreview();
            }
            toast(ok ? getString(R.string.state_saved, current) : getString(R.string.state_failed));
            runOnUiThread(this::refreshSlotButton);
        } else if (cmd == CMD_LOAD) {
            boolean ok = core.loadState(current);
            core.clearAudio();
            if (ok) {
                core.runFrames(userKeys(), 1);
                presentFrame();
            }
            toast(ok ? getString(R.string.state_loaded, current) : getString(R.string.state_missing, current));
            runOnUiThread(this::refreshSlotButton);
        } else if (cmd == CMD_RESET) {
            core.reset();
            core.clearAudio();
            if (cloudLink != null) {
                cloudLink.sendReset();
            }
            toast(getString(R.string.reset_done));
        } else if (cmd == CMD_AUTOSAVE) {
            // Silent save into the reserved slot on the way to the background.
            if (core.saveState(AUTO_SLOT)) {
                writeStatePreview(AUTO_SLOT);
            }
        } else if (cmd == CMD_REWIND) {
            boolean ok = core.rewind(rewindSeconds);
            core.clearAudio();
            if (ok) {
                core.runFrames(userKeys(), 1);
                presentFrame();
                toast(rewindLabel(rewindSeconds));
            } else {
                toast(getString(R.string.rewind_empty));
            }
        }
    }

    private void presentFrame() {
        int w = core.width();
        int h = core.height();
        if (w <= 0 || h <= 0) {
            return;
        }
        if (frame == null || frame.getWidth() != w || frame.getHeight() != h) {
            if (frame != null) {
                frame.recycle();
            }
            frame = Bitmap.createBitmap(w, h, Bitmap.Config.ARGB_8888);
        }
        if (!core.copyVideo(frame)) {
            return;
        }
        captureGifFrame();
        if (presentQueued.get()
                && System.currentTimeMillis() - presentQueuedAt > 300L) {
            /* post 的 Runnable 没回来：别让这一帧把后续所有帧都堵死。 */
            presentQueued.set(false);
            Log.w(TAG, "present gate stuck, released");
        }
        if (!presentQueued.compareAndSet(false, true)) {
            return;
        }
        presentQueuedAt = System.currentTimeMillis();
        Bitmap shown = frame.copy(Bitmap.Config.ARGB_8888, false);
        gameView.post(() -> {
            try {
                gameView.present(shown);
            } finally {
                presentQueued.set(false);
            }
        });
    }

    private void setupAudio() {
        sourceRate = core.sampleRate();
        if (sourceRate <= 0) {
            sourceRate = 32768;
        }
        appliedSpeed = -1;
        appliedGameSpeed = -1;
        constantPitchOn = false;
        constantPitchMode = -1;
        if (core != null) {
            core.setAudioConstantPitch(false, 1.0);
        }
        audioMuted = false;
        // Prefer the rate the device's audio hardware actually runs at so the
        // system does not have to resample our output; the core's own rate is
        // the fallback when that cannot be opened.
        if (!buildAudioTrack(deviceOutputRate())) {
            buildAudioTrack(sourceRate);
        }
    }

    /** Sample rate Android's audio output runs at, defaulting to the usual 48 kHz. */
    private int deviceOutputRate() {
        try {
            AudioManager manager = (AudioManager) getSystemService(AUDIO_SERVICE);
            if (manager != null) {
                String rate = manager.getProperty(AudioManager.PROPERTY_OUTPUT_SAMPLE_RATE);
                if (rate != null) {
                    int parsed = Integer.parseInt(rate.trim());
                    if (parsed >= 8000 && parsed <= 192000) {
                        return parsed;
                    }
                }
            }
        } catch (Exception ignored) {
        }
        return 48000;
    }

    /**
     * Builds a playback track at the given rate and points the core's resampler at it.
     * The track stays paused here; {@link #pumpAudio()} fills it and starts playback.
     */
    private boolean buildAudioTrack(int rate) {
        releaseAudio();
        int minBytes = AudioTrack.getMinBufferSize(rate, AudioFormat.CHANNEL_OUT_STEREO, AudioFormat.ENCODING_PCM_16BIT);
        if (minBytes <= 0) {
            return false;
        }
        AudioTrack track = null;
        try {
            int minFrames = minBytes / 4;
            int wantFrames = Math.min(Math.max(minFrames * 2, 3072), 6144);
            AudioTrack.Builder builder = new AudioTrack.Builder()
                    .setAudioAttributes(new AudioAttributes.Builder()
                            .setUsage(AudioAttributes.USAGE_GAME)
                            .setContentType(AudioAttributes.CONTENT_TYPE_MUSIC)
                            .build())
                    .setAudioFormat(new AudioFormat.Builder()
                            .setSampleRate(rate)
                            .setEncoding(AudioFormat.ENCODING_PCM_16BIT)
                            .setChannelMask(AudioFormat.CHANNEL_OUT_STEREO)
                            .build())
                    .setTransferMode(AudioTrack.MODE_STREAM)
                    .setBufferSizeInBytes(wantFrames * 4);
            if (Build.VERSION.SDK_INT >= 26 && getPreferences(MODE_PRIVATE).getBoolean("low_latency", false)) {
                builder.setPerformanceMode(AudioTrack.PERFORMANCE_MODE_LOW_LATENCY);
            }
            track = builder.build();
            if (track.getState() != AudioTrack.STATE_INITIALIZED) {
                track.release();
                return false;
            }
            boolean resampled = core.setAudioOutput(rate);
            if (!resampled && rate != sourceRate) {
                // The core cannot be converted to this rate; the caller retries
                // with the core's own rate, where no conversion is needed.
                track.release();
                return false;
            }
            int frames = track.getBufferSizeInFrames();
            if (frames <= 0) {
                frames = wantFrames;
            }
            outputRate = rate;
            trackFrames = frames;
            targetFrames = Math.max(1, (int) (frames * AUDIO_TARGET_FILL));
            rateControl = new AudioRateControl(frames, targetFrames);
            framesWritten = 0;
            carryFrames = 0;
            audio = track;
            return true;
        } catch (Exception e) {
            if (track != null) {
                track.release();
            }
            return false;
        }
    }

    /**
     * Applies a speed or sound setting change. Fast-forward sound is produced by
     * resampling at that speed (tape style, matching the iOS varispeed unit), so
     * a change only needs the audio pipeline restarted. Returns true when the
     * audio pipeline was reset, so the caller restarts its measurement windows:
     * a pace window straddling the change blends the two rates (half a second of
     * 1x plus half of 16x reports a meaningless middle value) and the resampler
     * would lock onto it.
     *
     * While fast-forwarding (mult > 1) the music can be:
     *   - 倍速声音 off            -> muted (no audio at all)
     *   - 倍速声音 on, 不变速 off  -> varispeed: audio follows the game and pitches up (tape style)
     *   - 倍速声音 on, 不变速 on   -> constant pitch: the music keeps its normal speed and the
     *                                surplus samples the fast game produces are dropped by the resampler
     * At 1x and during slow motion the audio always tracks the game speed.
     */
    private boolean syncFastAudio(double mult) {
        boolean changed = false;
        SharedPreferences prefs = getPreferences(MODE_PRIVATE);
        boolean soundOn = prefs.getBoolean("fast_audio", true);
        // 音乐原速 复选框写入的是 fast_audio_native；这里必须读同一个键，否则勾选
        // 框形同虚设，而真正的开关却一直读着一个没人写过的旧键（fast_audio_const），
        // 设备上残留的旧值会让整条路径在倍速下完全不生效（"完全没效果"）。
        boolean musicNative = prefs.getBoolean("fast_audio_native", true);
        boolean mute = !soundOn && mult > 1.01;
        double audioSpeed;
        boolean holdSurplus;
        if (mult <= 1.01) {
            // Normal speed and slow motion: audio always tracks the game.
            audioSpeed = mult;
            holdSurplus = false;
        } else if (soundOn && musicNative) {
            // 不变速: the music keeps its own speed and pitch. The fast game
            // produces several times more audio than the device can play at
            // that speed, so the surplus is parked and replayed instead of
            // being shredded by the core's ring - without that the music
            // comes out as scraps, right pitch but unrecognisable.
            audioSpeed = 1.0;
            holdSurplus = true;
        } else {
            // Varspeed (tape style): audio follows the game and pitches up.
            audioSpeed = mult;
            holdSurplus = false;
        }
        if (mult > 1.01) {
            android.util.Log.i("mGBA", "syncFast mult=" + mult + " soundOn=" + soundOn
                    + " native=" + musicNative + " hold=" + holdSurplus + " speed=" + audioSpeed
                    + " coreNull=" + (core == null));
        }
        if (core != null) {
            if (holdSurplus) {
                // Keep the stretch in sync with the current multiplier. This runs
                // on every emulated slice, so only publish changes: re-arming the
                // staging buffers throws away what is already parked.
                if (!constantPitchOn || Math.abs(mult - constantPitchStretch) > 0.01) {
                    core.setAudioConstantPitch(true, mult);
                    constantPitchStretch = mult;
                }
                int mode = musicNative ? MgbaCore.HOLD_MODE_NATIVE : MgbaCore.HOLD_MODE_PITCH;
                if (mode != constantPitchMode) {
                    core.setAudioHoldMode(mode);
                    constantPitchMode = mode;
                }
            } else if (constantPitchOn) {
                core.setAudioConstantPitch(false, 1.0);
                constantPitchMode = -1;
            }
            constantPitchOn = holdSurplus;
        }
        if (mute != audioMuted) {
            audioMuted = mute;
            resetAudio();
            changed = true;
        }
        if (audioMuted) {
            core.clearAudio();
            return changed;
        }
        if (audioSpeed != appliedSpeed || mult != appliedGameSpeed) {
            appliedSpeed = audioSpeed;
            appliedGameSpeed = mult;
            core.clearAudio();
            resetAudio();
            changed = true;
        }
        return changed;
    }

    /** Effective emulation speed right now, including the held fast-forward key. */
    private float currentGameSpeed() {
        return fastHold || ffOn ? Math.max(speed, fastHoldSpeed()) : speed;
    }

    /** Discards queued audio and pauses the track; the pump refills and resumes it. */
    private void resetAudio() {
        if (audio != null) {
            try {
                audio.pause();
                audio.flush();
            } catch (Exception ignored) {
            }
        }
        audioStarted = false;
        framesWritten = 0;
        carryFrames = 0;
        // Drop the rate-control and pace estimates so the resampler re-locks from a
        // clean state after a speed change instead of chasing a stale reading, which
        // made fast-forward audio stutter for a window.
        if (rateControl != null) {
            rateControl.reset();
        }
        if (core != null) {
            core.resetAudioPace();
            // The device-throughput memory survives the reset; only when there
            // is nothing to seed from must playback wait for the first window.
            paceSeeded = core.isAudioPaceSeeded();
        }
    }

    private void pumpAudio() {
        if (core == null) {
            return;
        }
        if (audio == null || audioMuted || paused || audio.getState() != AudioTrack.STATE_INITIALIZED) {
            core.clearAudio();
            return;
        }
        if (!paceSeeded) {
            // First fast-forward on this device: no locked pace and no
            // throughput memory to seed from. Converting now would fill the
            // track with wrong-pitch audio that then drains into gaps; hold
            // silent until the first feedback window lands, then fill and
            // start at the locked rate.
            core.clearAudio();
            return;
        }
        boolean playing = audioStarted;
        float drift = rateControl.drift(bufferedFrames() + carryFrames, playing);
        double rate = appliedSpeed > 0.05 ? appliedSpeed : 1.0;
        // Fast-forward produces several frames worth of audio per pump; keep
        // draining so the core's buffer never backs up.
        for (int round = 0; round < 8; round++) {
            int frames = core.readAudioOut(audioRead, rate, drift);
            if (frames <= 0) {
                break;
            }
            if (!audioStarted) {
                // Before playback starts, stop filling exactly at the target:
                // writing until the track overflows pins the queue above it and
                // the drift control then holds a corrective offset (audible as
                // a sharp pitch) for seconds while it drains back down.
                int room = targetFrames - bufferedFrames() - carryFrames;
                if (room <= 0) {
                    break;
                }
                if (frames > room) {
                    frames = room;
                }
            }
            pushAudio(frames);
            if (frames < AUDIO_READ_FRAMES) {
                break;
            }
        }
        if (!audioStarted && bufferedFrames() + carryFrames >= targetFrames) {
            // Start playback only once there is enough queued to survive the
            // device's mixer period; from then on the level control keeps it fed.
            try {
                audio.play();
                audioStarted = true;
            } catch (Exception ignored) {
            }
        }
    }

    /** Frames queued inside the playback buffer. */
    private int bufferedFrames() {
        if (audio == null) {
            return 0;
        }
        long head = audio.getPlaybackHeadPosition() & 0xFFFFFFFFL;
        long fill = (framesWritten - head) & 0xFFFFFFFFL;
        if (fill > 0x7FFFFFFFL) {
            return 0;
        }
        return (int) fill;
    }

    /**
     * Hands frames to the playback buffer. Whatever does not fit is kept in a
     * small backlog and written on the next pump, so audio is never cut in the
     * middle of a sample; only a runaway backlog sheds its oldest frames.
     */
    private void pushAudio(int frames) {
        if (carryFrames > 0) {
            int written = writeAudio(audioCarry, carryFrames);
            if (written > 0) {
                carryFrames -= written;
                if (carryFrames > 0) {
                    System.arraycopy(audioCarry, written * 2, audioCarry, 0, carryFrames * 2);
                }
            }
            if (carryFrames > 0) {
                int room = AUDIO_CARRY_FRAMES - carryFrames;
                int keep = Math.min(room, frames);
                System.arraycopy(audioRead, (frames - keep) * 2, audioCarry, carryFrames * 2, keep * 2);
                carryFrames += keep;
                return;
            }
        }
        int written = writeAudio(audioRead, frames);
        int left = frames - written;
        if (left > 0) {
            int keep = Math.min(left, AUDIO_CARRY_FRAMES);
            System.arraycopy(audioRead, (frames - keep) * 2, audioCarry, 0, keep * 2);
            carryFrames = keep;
        }
    }

    private int writeAudio(short[] data, int frames) {
        try {
            float gain = muted ? 0f : volumePercent / 100f;
            if (gain != 1f) {
                int count = frames * 2;
                for (int i = 0; i < count; i++) {
                    int scaled = (int) (data[i] * gain);
                    data[i] = (short) Math.max(Short.MIN_VALUE, Math.min(Short.MAX_VALUE, scaled));
                }
            }
            int written = audio.write(data, 0, frames * 2, AudioTrack.WRITE_NON_BLOCKING);
            if (written <= 0) {
                return 0;
            }
            int count = written / 2;
            // Track how much audio the device holds: the playback head counts
            // everything that has been played since the last flush, so written
            // minus head is what is still queued.
            framesWritten += count;
            return count;
        } catch (Exception e) {
            return 0;
        }
    }

    private void releaseAudio() {
        if (audio != null) {
            try {
                audio.pause();
                audio.flush();
                audio.release();
            } catch (Exception ignored) {
            }
            audio = null;
        }
        audioStarted = false;
        carryFrames = 0;
        framesWritten = 0;
    }

    private File stateFile(int index) {
        String path = currentRomPath;
        if (path == null) {
            path = getPreferences(MODE_PRIVATE).getString("lastRom", null);
        }
        String name = path == null ? "game" : new File(path).getName();
        int dot = name.lastIndexOf('.');
        if (dot > 0) {
            name = name.substring(0, dot);
        }
        File dir = activeStateDir != null ? activeStateDir : new File(getFilesDir(), "states");
        return new File(dir, name + ".ss" + index);
    }

    private void refreshSlotButton() {
        File file = stateFile(slot);
        boolean filled = file.isFile() && file.length() > 0;
        slotButton.setText(getString(filled ? R.string.slot_filled : R.string.slot, slot));
    }

    private void chooseSlot(boolean save) {
        if (!core.isLoaded()) {
            toast(getString(R.string.no_rom));
            return;
        }
        ArrayList<Bitmap> owned = new ArrayList<>();
        ScrollView scroll = new ScrollView(this);
        LinearLayout list = new LinearLayout(this);
        list.setOrientation(LinearLayout.VERTICAL);
        int pad = dp(8);
        list.setPadding(pad, pad, pad, pad);
        scroll.addView(list);
        if (save) {
            Bitmap now = gameView.copyLast();
            if (now != null) {
                owned.add(now);
                list.addView(slotRow(getString(R.string.state_now), now));
            }
        }
        for (int i = 1; i <= 9; i++) {
            File file = stateFile(i);
            boolean filled = file.isFile() && file.length() > 0;
            String when = filled
                    ? DateFormat.format("M月d日 HH:mm", file.lastModified()).toString()
                    : getString(R.string.slot_empty);
            Bitmap preview = filled ? decodePreview(i) : null;
            if (preview != null) {
                owned.add(preview);
            }
            String label = getString(R.string.slot_entry, i, when);
            if (filled && preview == null) {
                label = label + "　" + getString(R.string.state_no_preview);
            }
            View row = slotRow(label, preview);
            row.setTag(i);
            list.addView(row);
        }
        AlertDialog dialog = new AlertDialog.Builder(this)
                .setTitle(save ? R.string.state_pick_save : R.string.state_pick_load)
                .setView(scroll)
                .setNegativeButton(android.R.string.cancel, null)
                .create();
        for (int i = 0; i < list.getChildCount(); i++) {
            View child = list.getChildAt(i);
            if (!(child.getTag() instanceof Integer)) {
                continue;
            }
            child.setOnClickListener(v -> {
                int picked = (Integer) v.getTag();
                if (!save && !(stateFile(picked).isFile() && stateFile(picked).length() > 0)) {
                    toast(getString(R.string.state_missing, picked));
                    return;
                }
                slot = picked;
                refreshSlotButton();
                if (save) {
                    recyclePendingPreview();
                    pendingPreview.set(gameView.copyLast());
                }
                command.set(save ? CMD_SAVE : CMD_LOAD);
                dialog.dismiss();
            });
        }
        dialog.setOnDismissListener(d -> {
            for (int i = 0; i < list.getChildCount(); i++) {
                View child = list.getChildAt(i);
                if (child instanceof LinearLayout) {
                    View image = ((LinearLayout) child).getChildAt(0);
                    if (image instanceof ImageView) {
                        ((ImageView) image).setImageDrawable(null);
                    }
                }
            }
            for (Bitmap bitmap : owned) {
                if (bitmap != null && !bitmap.isRecycled()) {
                    bitmap.recycle();
                }
            }
        });
        dialog.show();
    }

    private View slotRow(String label, Bitmap preview) {
        LinearLayout row = new LinearLayout(this);
        row.setOrientation(LinearLayout.HORIZONTAL);
        row.setGravity(Gravity.CENTER_VERTICAL);
        int pad = dp(6);
        row.setPadding(pad, pad, pad, pad);
        ImageView image = new ImageView(this);
        LinearLayout.LayoutParams lp = new LinearLayout.LayoutParams(dp(120), dp(80));
        lp.setMarginEnd(dp(10));
        image.setLayoutParams(lp);
        image.setScaleType(ImageView.ScaleType.FIT_CENTER);
        image.setBackgroundColor(0xFF1A1A1A);
        if (preview != null) {
            image.setImageBitmap(preview);
        }
        TextView text = new TextView(this);
        text.setText(label);
        text.setTextColor(0xFF222222);
        text.setTextSize(15);
        row.addView(image);
        row.addView(text);
        return row;
    }

    private File statePreviewFile(int index) {
        return new File(stateFile(index).getAbsolutePath() + ".png");
    }

    private Bitmap decodePreview(int index) {
        File preview = statePreviewFile(index);
        Bitmap bitmap = null;
        if (preview.isFile()) {
            bitmap = BitmapFactory.decodeFile(preview.getAbsolutePath());
        }
        if (bitmap == null) {
            File state = stateFile(index);
            if (state.isFile()) {
                bitmap = BitmapFactory.decodeFile(state.getAbsolutePath());
            }
        }
        return bitmap;
    }

    private void recyclePendingPreview() {
        Bitmap leftover = pendingPreview.getAndSet(null);
        if (leftover != null && !leftover.isRecycled()) {
            leftover.recycle();
        }
    }

    private void writeStatePreview(int index) {
        Bitmap shown = pendingPreview.getAndSet(null);
        if (shown != null) {
            try (FileOutputStream out = new FileOutputStream(statePreviewFile(index))) {
                if (!shown.isRecycled()) {
                    shown.compress(Bitmap.CompressFormat.PNG, 100, out);
                }
            } catch (Exception ignored) {
            } finally {
                if (!shown.isRecycled()) {
                    shown.recycle();
                }
            }
            return;
        }
        int w = core.width();
        int h = core.height();
        if (w <= 0 || h <= 0) {
            return;
        }
        Bitmap bmp = Bitmap.createBitmap(w, h, Bitmap.Config.ARGB_8888);
        try {
            if (!core.copyVideo(bmp)) {
                return;
            }
            try (FileOutputStream out = new FileOutputStream(statePreviewFile(index))) {
                bmp.compress(Bitmap.CompressFormat.PNG, 100, out);
            }
        } catch (Exception ignored) {
        } finally {
            bmp.recycle();
        }
    }

    private void showSaveLocation() {
        String path = SaveLocation.displayPath(this, core.saveFile());
        if (path == null || path.isEmpty()) {
            savePathView.setVisibility(View.GONE);
            return;
        }
        savePathView.setTag(path);
        savePathView.setText(getString(R.string.save_location, path));
        savePathView.setVisibility(View.VISIBLE);
        toast(getString(R.string.save_location, path));
    }

    private void copySavePath() {
        Object tag = savePathView.getTag();
        if (!(tag instanceof String) || ((String) tag).isEmpty()) {
            return;
        }
        ClipboardManager clipboard = (ClipboardManager) getSystemService(CLIPBOARD_SERVICE);
        if (clipboard == null) {
            return;
        }
        clipboard.setPrimaryClip(ClipData.newPlainText("sav", (String) tag));
        toast(getString(R.string.save_location_copied));
    }

    private void bindLayoutEditor() {
        layoutProfile = activeProfile();
        keyLayout = KeyLayout.decode(profileLayout(layoutProfile));
        controls.setCenters(keyLayout.resolved());
        controls.setScales(keyLayout.resolvedScales());        selectedKey = null;
        scaleLabel = findViewById(R.id.layout_selected);
        scaleBar = findViewById(R.id.layout_scale);
        TextView scaleValue = findViewById(R.id.layout_scale_value);
        if (scaleBar != null) {
            scaleBar.setMax(260);
            scaleBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
                @Override
                public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                    int percent = progress + 40;
                    if (scaleValue != null) {
                        scaleValue.setText(percent + "%");
                    }
                    if (!fromUser || selectedKey == null) {
                        return;
                    }
                    float scale = percent / 100f;
                    keyLayout.setScale(selectedKey, scale);
                    controls.setKeyScale(selectedKey, scale);
                    persistLayout();
                }

                @Override
                public void onStartTrackingTouch(SeekBar seekBar) {
                }

                @Override
                public void onStopTrackingTouch(SeekBar seekBar) {
                }
            });
        }
        controls.setEditListener(new ControlsView.EditListener() {
            @Override
            public void onCursorMoved(String key, float nx, float ny) {
                keyLayout.place(key, nx, ny);
                controls.setCenters(keyLayout.resolved());
                selectKey(key);
            }

            @Override
            public void onCursorStopped(String key, float nx, float ny) {
                keyLayout.place(key, nx, ny);
                controls.setCenters(keyLayout.resolved());
                persistLayout();
                selectKey(key);
            }

            @Override
            public void onScaleChanged(String key, float scale) {
                keyLayout.setScale(key, scale);
                persistLayout();
                selectKey(key);
                refreshScaleBar();
            }

            @Override
            public void onSelected(String key) {
                selectKey(key);
                refreshScaleBar();
            }
        });
        findViewById(R.id.layout_reset).setOnClickListener(v -> resetLayout());
        findViewById(R.id.layout_done).setOnClickListener(v -> setLayoutEditing(false));
        View profilesButton = findViewById(R.id.layout_profiles);
        if (profilesButton != null) {
            profilesButton.setOnClickListener(v -> showLayoutProfiles());
        }
        View minus = findViewById(R.id.layout_minus);
        if (minus != null) {
            minus.setOnClickListener(v -> nudgeScale(-0.05f));
        }
        View plus = findViewById(R.id.layout_plus);
        if (plus != null) {
            plus.setOnClickListener(v -> nudgeScale(0.05f));
        }
        refreshScaleBar();
    }

    private void selectKey(String key) {
        selectedKey = key;
        runOnUiThread(this::refreshScaleBar);
    }

    private void refreshScaleBar() {
        if (scaleLabel == null || scaleBar == null) {
            return;
        }
        if (selectedKey == null) {
            scaleLabel.setText(getString(R.string.layout_selected_none));
            return;
        }
        float scale = keyLayout.scaleFor(selectedKey);
        int percent = Math.round(scale * 100);
        scaleLabel.setText(getString(R.string.layout_selected, selectedKey.toUpperCase(), percent));
        scaleBar.setProgress(percent - 40);
        TextView value = findViewById(R.id.layout_scale_value);
        if (value != null) {
            value.setText(percent + "%");
        }
    }

    private void nudgeScale(float delta) {
        if (selectedKey == null) {
            toast(getString(R.string.layout_tap_first));
            return;
        }
        float next = keyLayout.scaleFor(selectedKey) + delta;
        keyLayout.setScale(selectedKey, next);
        controls.setKeyScale(selectedKey, keyLayout.scaleFor(selectedKey));
        persistLayout();
        refreshScaleBar();
    }

    private void persistLayout() {
        boolean portrait = getResources().getConfiguration().orientation
                == Configuration.ORIENTATION_PORTRAIT;
        getPreferences(MODE_PRIVATE).edit()
                .putString(PROFILE_PREFIX + layoutProfile + (portrait ? "" : LAND_SUFFIX),
                        keyLayout.encode())
                .apply();
    }

    private void setLayoutEditing(boolean on) {
        layoutEditing = on;
        findViewById(R.id.layout_editor).setVisibility(on ? View.VISIBLE : View.GONE);
        controls.setEditing(on);
        menuButton.setVisibility(on ? View.GONE : View.VISIBLE);
        if (on) {
            // The menu bar floats over the stage now. Hide it while editing so
            // it cannot cover the bottom row of keys (START/SELECT) that is
            // being dragged; the editor has its own Done button.
            hideMenuNow();
            refreshScaleBar();
        } else {
            autoHideMenu();
        }
    }

    private void resetLayout() {
        keyLayout.resetAll();
        selectedKey = null;
        persistLayout();
        controls.setCenters(keyLayout.resolved());
        controls.setScales(keyLayout.resolvedScales());
        refreshScaleBar();
        toast(getString(R.string.layout_reset_done));
    }

    // == Key layout profiles ==

    /** Multiple key layouts: each is stored under its own prefs key and can
     * be switched, duplicated and deleted from the layout editor. */
    private String layoutProfile;
    private static final String PROFILE_PREFIX = "layout_p_";
    /** Landscape layouts carry this suffix; portrait keeps the unsuffixed key. */
    private static final String LAND_SUFFIX = "#L";
    private static final String DEFAULT_PROFILE = "默认";

    private ArrayList<String> profileNames() {
        ArrayList<String> names = new ArrayList<>();
        String csv = getPreferences(MODE_PRIVATE).getString("layout_profiles", null);
        if (csv != null) {
            for (String name : csv.split("\n")) {
                String trim = name.trim();
                if (!trim.isEmpty() && !names.contains(trim)) {
                    names.add(trim);
                }
            }
        }
        if (names.isEmpty()) {
            // First run of the profile system: carry the single stored layout
            // over as the default profile so nothing is lost.
            names.add(DEFAULT_PROFILE);
            String legacy = getPreferences(MODE_PRIVATE).getString("key_layout", "");
            getPreferences(MODE_PRIVATE).edit()
                    .putString(PROFILE_PREFIX + DEFAULT_PROFILE, legacy == null ? "" : legacy)
                    .apply();
            saveProfileNames(names);
        }
        return names;
    }

    private void saveProfileNames(List<String> names) {
        StringBuilder csv = new StringBuilder();
        for (String name : names) {
            if (csv.length() > 0) {
                csv.append('\n');
            }
            csv.append(name);
        }
        getPreferences(MODE_PRIVATE).edit().putString("layout_profiles", csv.toString()).apply();
    }

    private String activeProfile() {
        String active = getPreferences(MODE_PRIVATE).getString("layout_active", null);
        if (active != null && !active.isEmpty() && profileNames().contains(active)) {
            return active;
        }
        return DEFAULT_PROFILE;
    }

    private String profileLayout(String name) {
        boolean portrait = getResources().getConfiguration().orientation
                == Configuration.ORIENTATION_PORTRAIT;
        String key = PROFILE_PREFIX + name + (portrait ? "" : LAND_SUFFIX);
        String data = getPreferences(MODE_PRIVATE).getString(key, null);
        if (data != null) {
            return data;
        }
        if (!portrait) {
            // No landscape layout yet: fall back to the shared one so an
            // existing portrait arrangement is not thrown away.
            String shared = getPreferences(MODE_PRIVATE).getString(PROFILE_PREFIX + name, null);
            if (shared != null) {
                return shared;
            }
        }
        if (DEFAULT_PROFILE.equals(name)) {
            String legacy = getPreferences(MODE_PRIVATE).getString("key_layout", "");
            getPreferences(MODE_PRIVATE).edit()
                    .putString(key, legacy == null ? "" : legacy)
                    .apply();
            return legacy == null ? "" : legacy;
        }
        return "";
    }

    private void switchProfile(String name) {
        layoutProfile = name;
        getPreferences(MODE_PRIVATE).edit().putString("layout_active", name).apply();
        keyLayout = KeyLayout.decode(profileLayout(name));
        selectedKey = null;
        controls.setCenters(keyLayout.resolved());
        controls.setScales(keyLayout.resolvedScales());
        refreshScaleBar();
    }

    private void createProfile(String name, boolean copyCurrent) {
        ArrayList<String> names = profileNames();
        if (names.contains(name)) {
            toast(getString(R.string.profile_exists));
            return;
        }
        names.add(name);
        saveProfileNames(names);
        getPreferences(MODE_PRIVATE).edit()
                .putString(PROFILE_PREFIX + name, copyCurrent ? keyLayout.encode() : "")
                .apply();
        switchProfile(name);
        toast(getString(R.string.profile_switched, name));
    }

    private void deleteProfile(String name) {
        ArrayList<String> names = profileNames();
        if (names.size() <= 1) {
            toast(getString(R.string.profile_last));
            return;
        }
        names.remove(name);
        saveProfileNames(names);
        getPreferences(MODE_PRIVATE).edit().remove(PROFILE_PREFIX + name).apply();
        if (name.equals(layoutProfile)) {
            switchProfile(names.get(0));
        }
    }

    private interface NameCallback {
        void onName(String name);
    }

    private void promptProfileName(@Nullable String prefill, int title, NameCallback onOk) {
        EditText input = new EditText(this);
        input.setHint(R.string.profile_name_hint);
        input.setSingleLine(true);
        if (prefill != null) {
            input.setText(prefill);
            input.setSelection(prefill.length());
        }
        LinearLayout box = new LinearLayout(this);
        box.setOrientation(LinearLayout.VERTICAL);
        int pad = dp(16);
        box.setPadding(pad, pad, pad, 0);
        box.addView(input);
        new AlertDialog.Builder(this)
                .setTitle(title)
                .setView(box)
                .setPositiveButton(android.R.string.ok, (d, w) -> {
                    String name = input.getText().toString().trim();
                    if (name.isEmpty()) {
                        return;
                    }
                    if (profileNames().contains(name)) {
                        toast(getString(R.string.profile_exists));
                        return;
                    }
                    onOk.onName(name);
                })
                .setNegativeButton(android.R.string.cancel, null)
                .show();
    }

    /** Profile picker shown from the layout editor: tap to switch, buttons to
     * create a blank or a copy of the current one, per-row delete. */
    private void showLayoutProfiles() {
        ArrayList<String> names = profileNames();
        LinearLayout list = new LinearLayout(this);
        list.setOrientation(LinearLayout.VERTICAL);
        int pad = dp(8);
        list.setPadding(pad, pad, pad, pad);
        AlertDialog[] holder = new AlertDialog[1];
        for (String name : names) {
            list.addView(profileRow(holder, names, name));
        }
        TextView hint = new TextView(this);
        hint.setText(R.string.profiles_hint);
        hint.setTextColor(0xFF888888);
        hint.setTextSize(12);
        list.addView(hint);
        ScrollView scroll = new ScrollView(this);
        scroll.addView(list);
        AlertDialog dialog = new AlertDialog.Builder(this)
                .setTitle(R.string.profiles_title)
                .setView(scroll)
                .setPositiveButton(R.string.profile_new, (d, w) -> promptProfileName(null, R.string.profile_new, name -> {
                    createProfile(name, false);
                    showLayoutProfiles();
                }))
                .setNegativeButton(R.string.profile_copy, (d, w) -> promptProfileName(layoutProfile + "-2", R.string.profile_copy, name -> {
                    createProfile(name, true);
                    showLayoutProfiles();
                }))
                .setNeutralButton(android.R.string.cancel, null)
                .create();
        holder[0] = dialog;
        dialog.show();
    }

    private View profileRow(AlertDialog[] holder, List<String> names, String name) {
        LinearLayout row = new LinearLayout(this);
        row.setOrientation(LinearLayout.HORIZONTAL);
        row.setGravity(Gravity.CENTER_VERTICAL);
        int pad = dp(6);
        row.setPadding(pad, pad, pad, pad);
        TextView label = new TextView(this);
        boolean active = name.equals(layoutProfile);
        label.setText((active ? "▸ " : "○ ") + name);
        label.setTextColor(active ? 0xFF1B5E20 : 0xFF222222);
        label.setTextSize(15);
        label.setOnClickListener(v -> {
            holder[0].dismiss();
            switchProfile(name);
            toast(getString(R.string.profile_switched, name));
        });
        row.addView(label, new LinearLayout.LayoutParams(0, LinearLayout.LayoutParams.WRAP_CONTENT, 1f));
        if (names.size() > 1) {
            Button del = new Button(this);
            del.setText(R.string.profile_delete);
            del.setAllCaps(false);
            del.setTextSize(12);
            del.setMinHeight(dp(36));
            del.setMinimumHeight(dp(36));
            del.setOnClickListener(v -> new AlertDialog.Builder(this)
                    .setMessage(getString(R.string.profile_delete_confirm, name))
                    .setPositiveButton(android.R.string.ok, (d, w) -> {
                        holder[0].dismiss();
                        deleteProfile(name);
                        toast(getString(R.string.profile_deleted, name));
                        showLayoutProfiles();
                    })
                    .setNegativeButton(android.R.string.cancel, null)
                    .show());
            row.addView(del);
        }
        return row;
    }

    private void applyVideo() {
        boolean blend = getPreferences(MODE_PRIVATE).getBoolean("vf_blend", false);
        boolean linear = getPreferences(MODE_PRIVATE).getBoolean("vf_linear", true);
        boolean aspect = getPreferences(MODE_PRIVATE).getBoolean("vf_aspect", true);
        boolean integer = getPreferences(MODE_PRIVATE).getBoolean("vf_integer", false);
        boolean scan = getPreferences(MODE_PRIVATE).getBoolean("vf_scan", false);
        boolean autoSkip = getPreferences(MODE_PRIVATE).getBoolean("vf_skip_auto", false);
        int skip = autoSkip ? 0 : getPreferences(MODE_PRIVATE).getInt("vf_skip", 0);
        int bright = getPreferences(MODE_PRIVATE).getInt("vf_bright", 100);
        skipAuto = autoSkip;
        autoSkipLevel = 0;
        lateStreak = 0;
        gameView.setBilinear(linear);
        gameView.setLockAspect(aspect);
        gameView.setIntegerScale(integer);
        gameView.setScanlines(scan);
        gameView.setBrightness(bright);
        gameView.setContrast(getPreferences(MODE_PRIVATE).getInt("vf_contrast", 100));
        gameView.setFilter(getPreferences(MODE_PRIVATE).getInt("vf_filter", Shaders.FILTER_NONE));
        if (core == null) {
            return;
        }
        core.setInterframe(blend);
        core.setFrameskip(skip);
    }

    private void showVideoDialog() {
        ScrollView scroll = new ScrollView(this);
        LinearLayout box = new LinearLayout(this);
        box.setOrientation(LinearLayout.VERTICAL);
        int pad = dp(16);
        box.setPadding(pad, pad, pad, pad);
        scroll.addView(box);
        CheckBox blend = check(R.string.video_blend, getPreferences(MODE_PRIVATE).getBoolean("vf_blend", false));
        CheckBox linear = check(R.string.video_bilinear, getPreferences(MODE_PRIVATE).getBoolean("vf_linear", true));
        CheckBox aspect = check(R.string.video_aspect, getPreferences(MODE_PRIVATE).getBoolean("vf_aspect", true));
        CheckBox integer = check(R.string.video_integer, getPreferences(MODE_PRIVATE).getBoolean("vf_integer", false));
        CheckBox scan = check(R.string.video_scan, getPreferences(MODE_PRIVATE).getBoolean("vf_scan", false));
        int skipNow = getPreferences(MODE_PRIVATE).getInt("vf_skip", 0);
        int brightNow = getPreferences(MODE_PRIVATE).getInt("vf_bright", 100);
        int contrastNow = getPreferences(MODE_PRIVATE).getInt("vf_contrast", 100);
        final Button filter = new Button(this);
        filter.setAllCaps(false);
        filter.setText(getString(R.string.video_filter_value, filterName(filterPref())));
        filter.setOnClickListener(v -> new AlertDialog.Builder(this)
                .setTitle(R.string.video_filter)
                .setSingleChoiceItems(filterNames(), filterPref(), (dialog, which) -> {
                    pickFilter(which);
                    filter.setText(getString(R.string.video_filter_value, filterName(filterPref())));
                    dialog.dismiss();
                })
                .show());
        final Button shaderManager = new Button(this);
        shaderManager.setAllCaps(false);
        shaderManager.setText(getString(R.string.shader_external_value,
                getPreferences(MODE_PRIVATE).getString("ext_shader", "").isEmpty()
                        ? getString(R.string.shader_external_none)
                        : getPreferences(MODE_PRIVATE).getString("ext_shader", "")));
        shaderManager.setOnClickListener(v -> showShaderDialog());
        final Button scene = new Button(this);
        scene.setAllCaps(false);
        scene.setText(R.string.video_scene);
        scene.setOnClickListener(v -> showSceneDialog());
        CheckBox skipAuto = check(R.string.video_skip_auto, getPreferences(MODE_PRIVATE).getBoolean("vf_skip_auto", false));
        TextView skipLabel = new TextView(this);
        skipLabel.setText(getString(R.string.video_skip, skipNow));
        skipLabel.setTextColor(0xFF222222);
        SeekBar skipBar = new SeekBar(this);
        skipBar.setMax(5);
        skipBar.setProgress(skipNow);
        skipBar.setEnabled(!skipAuto.isChecked());
        skipLabel.setEnabled(!skipAuto.isChecked());
        skipAuto.setOnCheckedChangeListener((v, checked) -> {
            getPreferences(MODE_PRIVATE).edit().putBoolean("vf_skip_auto", checked).apply();
            skipBar.setEnabled(!checked);
            skipLabel.setEnabled(!checked);
            applyVideo();
        });
        TextView brightLabel = new TextView(this);
        brightLabel.setText(getString(R.string.video_bright, brightNow));
        brightLabel.setTextColor(0xFF222222);
        SeekBar brightBar = new SeekBar(this);
        brightBar.setMax(100);
        brightBar.setProgress(brightNow - 50);
        TextView contrastLabel = new TextView(this);
        contrastLabel.setText(getString(R.string.contrast, contrastNow));
        contrastLabel.setTextColor(0xFF222222);
        SeekBar contrastBar = new SeekBar(this);
        contrastBar.setMax(100);
        contrastBar.setProgress(contrastNow - 50);
        box.addView(blend);
        box.addView(linear);
        box.addView(aspect);
        box.addView(integer);
        box.addView(scan);
        box.addView(filter);
        box.addView(shaderManager);
        box.addView(scene);
        box.addView(skipAuto);
        box.addView(skipLabel);
        box.addView(skipBar);
        box.addView(brightLabel);
        box.addView(brightBar);
        box.addView(contrastLabel);
        box.addView(contrastBar);
        Runnable persist = () -> {
            getPreferences(MODE_PRIVATE).edit()
                    .putBoolean("vf_blend", blend.isChecked())
                    .putBoolean("vf_linear", linear.isChecked())
                    .putBoolean("vf_aspect", aspect.isChecked())
                    .putBoolean("vf_integer", integer.isChecked())
                    .putBoolean("vf_scan", scan.isChecked())
                    .putInt("vf_skip", skipBar.getProgress())
                    .putInt("vf_bright", brightBar.getProgress() + 50)
                    .putInt("vf_contrast", contrastBar.getProgress() + 50)
                    .apply();
            applyVideo();
        };
        View.OnClickListener toggle = v -> persist.run();
        blend.setOnClickListener(toggle);
        linear.setOnClickListener(toggle);
        aspect.setOnClickListener(toggle);
        integer.setOnClickListener(toggle);
        scan.setOnClickListener(toggle);
        skipBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                skipLabel.setText(getString(R.string.video_skip, progress));
                if (fromUser) {
                    persist.run();
                }
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
            }
        });
        brightBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                brightLabel.setText(getString(R.string.video_bright, progress + 50));
                if (fromUser) {
                    persist.run();
                }
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
            }
        });
        contrastBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                contrastLabel.setText(getString(R.string.contrast, progress + 50));
                if (fromUser) {
                    persist.run();
                }
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
            }
        });
        new AlertDialog.Builder(this)
                .setTitle(R.string.video_title)
                .setView(scroll)
                .setPositiveButton(android.R.string.ok, null)
                .show();
    }

    private int filterPref() {
        int id = getPreferences(MODE_PRIVATE).getInt("vf_filter", Shaders.FILTER_NONE);
        return id >= 0 && id < Shaders.FILTER_COUNT ? id : Shaders.FILTER_NONE;
    }

    private String filterName(int id) {
        int res;
        switch (id) {
            case Shaders.FILTER_GBA_COLOR: return getString(R.string.filter_gba_color);
            case Shaders.FILTER_GRAYSCALE: return getString(R.string.filter_grayscale);
            case Shaders.FILTER_HQ2X: return "HQ2x";
            case Shaders.FILTER_HQ4X: return "HQ4x";
            case Shaders.FILTER_2XBR: return "2xBR";
            case Shaders.FILTER_4XBR: return "4xBR";
            case Shaders.FILTER_MOTION_BLUR: return getString(R.string.filter_motion_blur);
            case Shaders.FILTER_DOT: return getString(R.string.filter_dot);
            case Shaders.FILTER_LCD3X: return "LCD3x";
            case Shaders.FILTER_SCANLINES: return getString(R.string.filter_scanlines);
            case Shaders.FILTER_QUILEZ: return getString(R.string.filter_quilez);
            case Shaders.FILTER_EXTERNAL: return externalShaderLabel();
            default: return getString(R.string.filter_none);
        }
    }

    private String externalShaderLabel() {
        String name = getPreferences(MODE_PRIVATE).getString("ext_shader", "");
        return getString(R.string.shader_external_value, name.isEmpty()
                ? getString(R.string.shader_external_none) : name);
    }

    /** Selecting 外部渲染器 with nothing installed jumps straight to the installer. */
    private void pickFilter(int which) {
        if (which == Shaders.FILTER_EXTERNAL && Shaders.externalSource() == null) {
            showShaderDialog();
            return;
        }
        getPreferences(MODE_PRIVATE).edit().putInt("vf_filter", which).apply();
        applyVideo();
    }

    private CharSequence[] filterNames() {
        CharSequence[] names = new CharSequence[Shaders.FILTER_COUNT];
        for (int i = 0; i < Shaders.FILTER_COUNT; i++) {
            names[i] = filterName(i);
        }
        return names;
    }

    // == External GLSL shaders (悠GBA 安装渲染器 port) =====================

    private File shaderDir() {
        File dir = new File(getFilesDir(), "shaders");
        dir.mkdirs();
        return dir;
    }

    /** Re-adapts the installed shader from disk at startup. */
    private void loadInstalledShader() {
        String name = getPreferences(MODE_PRIVATE).getString("ext_shader", "");
        if (name.isEmpty()) {
            return;
        }
        File file = new File(shaderDir(), name);
        if (!file.isFile()) {
            getPreferences(MODE_PRIVATE).edit().putString("ext_shader", "").apply();
            Shaders.setExternalSource(null);
            return;
        }
        try {
            String source = readTextFile(file);
            String adapted = Shaders.adaptExternal(source);
            Shaders.setExternalSource(adapted);
            if (adapted == null) {
                getPreferences(MODE_PRIVATE).edit().putString("ext_shader", "").apply();
            }
        } catch (Exception e) {
            Shaders.setExternalSource(null);
        }
    }

    private String readTextFile(File file) throws java.io.IOException {
        StringBuilder out = new StringBuilder();
        try (InputStream in = new java.io.FileInputStream(file)) {
            byte[] buffer = new byte[8192];
            int n;
            while ((n = in.read(buffer)) > 0) {
                out.append(new String(buffer, 0, n, java.nio.charset.StandardCharsets.UTF_8));
            }
        }
        return out.toString();
    }

    private void installShaderFrom(Uri uri) {
        String name = sanitize(displayName(uri)).toLowerCase(Locale.ROOT);
        if (name.endsWith(".zip")) {
            toast(getString(R.string.shader_bad));
            return;
        }
        if (!name.endsWith(".glsl")) {
            name += ".glsl";
        }
        final String fileName = name;
        final Uri source = uri;
        new Thread(() -> {
            String copied = copyTo(source, shaderDir(), fileName);
            String adapted = null;
            if (copied != null) {
                try {
                    adapted = Shaders.adaptExternal(readTextFile(new File(copied)));
                } catch (Exception ignored) {
                }
            }
            final String result = adapted;
            runOnUiThread(() -> {
                if (result == null) {
                    toast(getString(R.string.shader_bad));
                    return;
                }
                Shaders.setExternalSource(result);
                getPreferences(MODE_PRIVATE).edit()
                        .putString("ext_shader", fileName)
                        .putInt("vf_filter", Shaders.FILTER_EXTERNAL)
                        .apply();
                applyVideo();
                toast(getString(R.string.shader_installed, fileName));
            });
        }, "shader-install").start();
    }

    /** 安装渲染器 dialog: pick installed, install new, clear, help. */
    private void showShaderDialog() {
        LinearLayout box = new LinearLayout(this);
        box.setOrientation(LinearLayout.VERTICAL);
        int pad = dp(16);
        box.setPadding(pad, pad, pad, pad);
        TextView help = new TextView(this);
        help.setText(R.string.shader_help);
        help.setTextSize(12);
        help.setTextColor(0xFF666666);
        box.addView(help);
        Button install = new Button(this);
        install.setAllCaps(false);
        install.setText(R.string.shader_install);
        install.setOnClickListener(v -> openDocument(REQ_SHADER));
        box.addView(install);
        Button pick = new Button(this);
        pick.setAllCaps(false);
        pick.setText(R.string.shader_pick);
        pick.setOnClickListener(v -> {
            File[] shaderFiles = shaderDir().listFiles((dir, n) -> n.toLowerCase(Locale.ROOT).endsWith(".glsl"));
            List<String> shaderNames = new ArrayList<>();
            if (shaderFiles != null) {
                for (File file : shaderFiles) {
                    shaderNames.add(file.getName());
                }
            }
            if (shaderNames.isEmpty()) {
                toast(getString(R.string.shader_external_none));
                return;
            }
            String active = getPreferences(MODE_PRIVATE).getString("ext_shader", "");
            int checked = shaderNames.indexOf(active);
            String[] items = shaderNames.toArray(new String[0]);
            new AlertDialog.Builder(this)
                    .setTitle(R.string.shader_pick)
                    .setSingleChoiceItems(items, checked, (dialog, which) -> {
                        String picked = items[which];
                        try {
                            Shaders.setExternalSource(Shaders.adaptExternal(readTextFile(new File(shaderDir(), picked))));
                            getPreferences(MODE_PRIVATE).edit()
                                    .putString("ext_shader", picked)
                                    .putInt("vf_filter", Shaders.FILTER_EXTERNAL)
                                    .apply();
                            applyVideo();
                            toast(getString(R.string.shader_installed, picked));
                        } catch (Exception e) {
                            toast(getString(R.string.shader_bad));
                        }
                        dialog.dismiss();
                    })
                    .show();
        });
        box.addView(pick);
        Button clear = new Button(this);
        clear.setAllCaps(false);
        clear.setText(R.string.shader_removed);
        clear.setOnClickListener(v -> {
            getPreferences(MODE_PRIVATE).edit().putString("ext_shader", "").apply();
            Shaders.setExternalSource(null);
            if (filterPref() == Shaders.FILTER_EXTERNAL) {
                getPreferences(MODE_PRIVATE).edit().putInt("vf_filter", Shaders.FILTER_NONE).apply();
            }
            applyVideo();
            toast(getString(R.string.shader_removed));
        });
        box.addView(clear);
        new AlertDialog.Builder(this)
                .setTitle(R.string.shader_external)
                .setView(box)
                .setPositiveButton(android.R.string.ok, null)
                .show();
    }

    // == Video scene editor (悠GBA 画面场景 port) ==========================

    private void showSceneDialog() {
        int xNow = getPreferences(MODE_PRIVATE).getInt("scene_x", 0);
        int yNow = getPreferences(MODE_PRIVATE).getInt("scene_y", 0);
        int scaleNow = getPreferences(MODE_PRIVATE).getInt("scene_scale", 100);
        LinearLayout box = new LinearLayout(this);
        box.setOrientation(LinearLayout.VERTICAL);
        int pad = dp(16);
        box.setPadding(pad, pad, pad, pad);
        TextView xLabel = new TextView(this);
        xLabel.setText(getString(R.string.scene_x, xNow));
        xLabel.setTextColor(0xFF222222);
        SeekBar xBar = new SeekBar(this);
        xBar.setMax(200);
        xBar.setProgress(xNow + 100);
        TextView yLabel = new TextView(this);
        yLabel.setText(getString(R.string.scene_y, yNow));
        yLabel.setTextColor(0xFF222222);
        SeekBar yBar = new SeekBar(this);
        yBar.setMax(200);
        yBar.setProgress(yNow + 100);
        TextView sLabel = new TextView(this);
        sLabel.setText(getString(R.string.scene_scale, scaleNow));
        sLabel.setTextColor(0xFF222222);
        SeekBar sBar = new SeekBar(this);
        sBar.setMax(375);
        sBar.setProgress(scaleNow - 25);
        Button reset = new Button(this);
        reset.setAllCaps(false);
        reset.setText(R.string.scene_reset);
        reset.setOnClickListener(v -> {
            xBar.setProgress(100);
            yBar.setProgress(100);
            sBar.setProgress(75);
        });
        SeekBar.OnSeekBarChangeListener listener = new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                int x = xBar.getProgress() - 100;
                int y = yBar.getProgress() - 100;
                int scale = sBar.getProgress() + 25;
                xLabel.setText(getString(R.string.scene_x, x));
                yLabel.setText(getString(R.string.scene_y, y));
                sLabel.setText(getString(R.string.scene_scale, scale));
                if (fromUser) {
                    getPreferences(MODE_PRIVATE).edit()
                            .putInt("scene_x", x)
                            .putInt("scene_y", y)
                            .putInt("scene_scale", scale)
                            .apply();
                    applyVideoScene();
                }
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
            }
        };
        xBar.setOnSeekBarChangeListener(listener);
        yBar.setOnSeekBarChangeListener(listener);
        sBar.setOnSeekBarChangeListener(listener);
        box.addView(xLabel);
        box.addView(xBar);
        box.addView(yLabel);
        box.addView(yBar);
        box.addView(sLabel);
        box.addView(sBar);
        box.addView(reset);
        new AlertDialog.Builder(this)
                .setTitle(R.string.video_scene)
                .setView(box)
                .setPositiveButton(android.R.string.ok, null)
                .show();
    }

    /**
     * Freely moves and scales the game picture over its stage. Offsets are
     * percentages of the view's own size (which is the aspect-locked picture
     * rect), so the same value works in both orientations.
     */
    private void applyVideoScene() {
        if (gameView == null) {
            return;
        }
        int x = getPreferences(MODE_PRIVATE).getInt("scene_x", 0);
        int y = getPreferences(MODE_PRIVATE).getInt("scene_y", 0);
        int scale = getPreferences(MODE_PRIVATE).getInt("scene_scale", 100);
        gameView.setPivotX(gameView.getWidth() / 2f);
        gameView.setPivotY(gameView.getHeight() / 2f);
        gameView.setTranslationX(gameView.getWidth() * x / 100f);
        gameView.setTranslationY(gameView.getHeight() * y / 100f);
        gameView.setScaleX(scale / 100f);
        gameView.setScaleY(scale / 100f);
    }

    // == WebDAV save sync (悠GBA 坚果云同步 port) ==========================

    private void showSyncDialog() {
        ScrollView scroll = new ScrollView(this);
        LinearLayout box = new LinearLayout(this);
        box.setOrientation(LinearLayout.VERTICAL);
        int pad = dp(16);
        box.setPadding(pad, pad, pad, pad);
        scroll.addView(box);
        TextView help = new TextView(this);
        help.setText(R.string.sync_help);
        help.setTextSize(12);
        help.setTextColor(0xFF666666);
        box.addView(help);
        CheckBox enable = check(R.string.sync_enable, getPreferences(MODE_PRIVATE).getBoolean("sync_enable", false));
        EditText url = input(this, R.string.sync_url, getPreferences(MODE_PRIVATE).getString("sync_url", WebDavSync.DEFAULT_URL));
        EditText user = input(this, R.string.sync_account, getPreferences(MODE_PRIVATE).getString("sync_user", ""));
        EditText pass = input(this, R.string.sync_password, getPreferences(MODE_PRIVATE).getString("sync_pass", ""));
        EditText dir = input(this, R.string.sync_dir, getPreferences(MODE_PRIVATE).getString("sync_dir", WebDavSync.DEFAULT_DIR));
        CheckBox auto = check(R.string.sync_auto, getPreferences(MODE_PRIVATE).getBoolean("sync_auto", true));
        box.addView(enable);
        box.addView(url);
        box.addView(user);
        box.addView(pass);
        box.addView(dir);
        box.addView(auto);
        Button save = new Button(this);
        save.setAllCaps(false);
        save.setText(android.R.string.ok);
        save.setOnClickListener(v -> {
            getPreferences(MODE_PRIVATE).edit()
                    .putString("sync_url", url.getText().toString().trim())
                    .putString("sync_user", user.getText().toString().trim())
                    .putString("sync_pass", pass.getText().toString().trim())
                    .putString("sync_dir", dir.getText().toString().trim())
                    .putBoolean("sync_auto", auto.isChecked())
                    .putBoolean("sync_enable", enable.isChecked())
                    .apply();
            toast(getString(R.string.sync_config_saved));
        });
        box.addView(save);
        Button syncNow = new Button(this);
        syncNow.setAllCaps(false);
        syncNow.setText(R.string.sync_now);
        syncNow.setOnClickListener(v -> runSyncNow());
        box.addView(syncNow);
        new AlertDialog.Builder(this)
                .setTitle(R.string.sync_title)
                .setView(scroll)
                .setPositiveButton(android.R.string.ok, null)
                .show();
    }

    private EditText input(Context context, int hintRes, String value) {
        EditText view = new EditText(context);
        view.setHint(hintRes);
        view.setText(value);
        view.setSingleLine();
        return view;
    }

    /** Manual 立即同步: runs one pass and reports the outcome. */
    private void runSyncNow() {
        if (!WebDavSync.configured(getPreferences(MODE_PRIVATE))) {
            toast(getString(R.string.sync_need_config));
            return;
        }
        toast(getString(R.string.sync_running));
        new Thread(() -> {
            try {
                WebDavSync.Result result = WebDavSync.run(this, getPreferences(MODE_PRIVATE));
                runOnUiThread(() -> {
                    if (!result.errors.isEmpty()) {
                        toast(getString(R.string.sync_failed, result.errors.get(0)));
                    } else {
                        toast(getString(R.string.sync_done, result.uploaded, result.downloaded));
                    }
                });
            } catch (Exception e) {
                runOnUiThread(() -> toast(getString(R.string.sync_failed, WebDavSync.describe(e))));
            }
        }, "webdav-sync").start();
    }

    /** Auto sync on entering a game: pull remote saves that are newer. */
    private void autoSyncOnLoad() {
        if (!getPreferences(MODE_PRIVATE).getBoolean("sync_enable", false)
                || !getPreferences(MODE_PRIVATE).getBoolean("sync_auto", true)
                || !WebDavSync.configured(getPreferences(MODE_PRIVATE))) {
            return;
        }
        new Thread(() -> {
            try {
                WebDavSync.run(this, getPreferences(MODE_PRIVATE));
            } catch (Exception ignored) {
                // A failed background sync never blocks play.
            }
        }, "webdav-sync-auto").start();
    }

    // == GIF float ball (悠GBA 录制浮球 port) ==============================

    private void setupGifBall() {
        if (!getPreferences(MODE_PRIVATE).getBoolean("gif_ball", false) || gifBall != null) {
            return;
        }
        GifBall ball = new GifBall(this, () -> {
            if (gifRecording) {
                stopGif();
            } else {
                startGif();
            }
        });
        gifBall = ball;
        FrameLayout root = (FrameLayout) findViewById(R.id.root);
        root.addView(ball, new FrameLayout.LayoutParams(
                ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT));
        int[] pos = getPreferences(MODE_PRIVATE).getString("gif_ball_pos", "80,120") == null
                ? new int[]{80, 120} : parseBallPos();
        ball.restore(pos[0], pos[1]);
        ball.setVisibility(View.GONE);
        ball.setOnTouchListener((v, event) -> {
            if (event.getActionMasked() == MotionEvent.ACTION_UP) {
                int[] after = ball.position();
                getPreferences(MODE_PRIVATE).edit()
                        .putString("gif_ball_pos", after[0] + "," + after[1]).apply();
            }
            return false;
        });
    }

    private int[] parseBallPos() {
        String raw = getPreferences(MODE_PRIVATE).getString("gif_ball_pos", "80,120");
        int[] out = {80, 120};
        if (raw != null) {
            String[] parts = raw.split(",");
            try {
                if (parts.length == 2) {
                    out[0] = Integer.parseInt(parts[0].trim());
                    out[1] = Integer.parseInt(parts[1].trim());
                }
            } catch (NumberFormatException ignored) {
            }
        }
        return out;
    }

    private void refreshGifBall() {
        if (gifBall == null) {
            return;
        }
        boolean show = getPreferences(MODE_PRIVATE).getBoolean("gif_ball", false)
                && core != null && core.isLoaded();
        gifBall.setVisibility(show ? View.VISIBLE : View.GONE);
        gifBall.setRecording(gifRecording);
    }

    // == Solar via light sensor (悠GBA 设备感光器 port) ====================

    private final SensorEventListener solarListener = new SensorEventListener() {
        @Override
        public void onSensorChanged(SensorEvent event) {
            float lux = event.values[0];
            int level = luxToSolar(lux);
            if (core != null && core.isLoaded()) {
                core.setSolar(level);
            }
        }

        @Override
        public void onAccuracyChanged(Sensor sensor, int accuracy) {
        }
    };

    /** Maps ambient lux onto the console's 0-10 sunlight scale. */
    private static int luxToSolar(float lux) {
        float[] thresholds = {10f, 30f, 60f, 100f, 200f, 400f, 800f, 1500f, 3000f, 8000f};
        int level = 0;
        for (float threshold : thresholds) {
            if (lux >= threshold) {
                level++;
            }
        }
        return level;
    }

    /** Registers or releases the light sensor per the 阳光来源 preference. */
    private void updateSolarSource() {
        boolean wanted = getPreferences(MODE_PRIVATE).getBoolean("solar_on", false)
                && "sensor".equals(getPreferences(MODE_PRIVATE).getString("solar_source", "keys"));
        if (wanted && !solarListening) {
            if (sensorManager == null) {
                sensorManager = (SensorManager) getSystemService(SENSOR_SERVICE);
            }
            Sensor light = sensorManager == null ? null : sensorManager.getDefaultSensor(Sensor.TYPE_LIGHT);
            if (light != null) {
                sensorManager.registerListener(solarListener, light, SensorManager.SENSOR_DELAY_NORMAL);
                solarListening = true;
            }
        } else if (!wanted && solarListening) {
            sensorManager.unregisterListener(solarListener);
            solarListening = false;
        }
    }

    // == Keep-alive notice (悠GBA 游戏运行通知 port) =======================

    private void startNoticeIfWanted(String title) {
        if (getPreferences(MODE_PRIVATE).getBoolean("keep_notice", true)) {
            NoticeService.start(this, title);
        }
    }

    /** One-time offer to hide the vkeypad after hardware keys appear. */
    private void maybeOfferKeypadHide() {
        if (hwKeyPromptShown
                || !getPreferences(MODE_PRIVATE).getBoolean("keypad_detect", false)
                || controls == null || !controls.isShown()) {
            return;
        }
        hwKeyPromptShown = true;
        new AlertDialog.Builder(this)
                .setMessage(R.string.keypad_hide_ask)
                .setPositiveButton(R.string.keypad_hide, (d, w) -> {
                    getPreferences(MODE_PRIVATE).edit().putBoolean("vkeypad_hidden", true).apply();
                    applyInputSettings();
                })
                .setNegativeButton(R.string.keypad_keep, null)
                .show();
    }

    private String solarSourceName() {
        return "sensor".equals(getPreferences(MODE_PRIVATE).getString("solar_source", "keys"))
                ? getString(R.string.solar_source_sensor) : getString(R.string.solar_source_keys);
    }

    private int palettePref() {
        int id = getPreferences(MODE_PRIVATE).getInt("gb_palette", 0);
        return id >= 0 && id < GB_PALETTES.length ? id : 0;
    }

    private String paletteName(int id) {
        return getString(getResources().getIdentifier(GB_PALETTE_KEYS[id], "string", getPackageName()));
    }

    /**
     * Twelve gb.pal entries for the chosen palette. Index 0 is the core's own
     * stock colors, sent explicitly so a previous palette is fully cleared.
     */
    private int[] gbPaletteColors() {
        int[] base = GB_PALETTES[palettePref()];
        int[] colors = new int[12];
        for (int i = 0; i < 12; i++) {
            colors[i] = base[i % 4];
        }
        return colors;
    }

    private CheckBox check(int label, boolean checked) {
        CheckBox box = new CheckBox(this);
        box.setText(label);
        box.setTextColor(0xFF222222);
        box.setChecked(checked);
        return box;
    }

    private void showLinkDialog() {
        Log.d("GBOYLINK", "showLinkDialog INVOKED");
        LinearLayout box = new LinearLayout(this);
        box.setOrientation(LinearLayout.VERTICAL);
        int pad = dp(16);
        box.setPadding(pad, pad, pad, pad);
        TextView status = new TextView(this);
        status.setTextColor(0xFF1B5E20);
        status.setPadding(0, pad, 0, 0);
        linkStatusView = status;
        // ---- gboy.top 云端房间：邮箱 + 验证码，与官方客户端同一套账号体系 ----
        TextView cloudHelp = new TextView(this);
        cloudHelp.setText(R.string.link_cloud_help);
        cloudHelp.setTextColor(0xFF222222);
        cloudHelp.setPadding(0, pad, 0, 0);
        box.addView(cloudHelp);
        EditText cloudEmail = new EditText(this);
        cloudEmail.setHint(R.string.link_cloud_email_hint);
        cloudEmail.setSingleLine(true);
        cloudEmail.setText(getPreferences(MODE_PRIVATE).getString("cloud_email", ""));
        box.addView(cloudEmail);
        EditText cloudCode = new EditText(this);
        cloudCode.setHint(R.string.link_cloud_code_hint);
        cloudCode.setSingleLine(true);
        Button getCode = linkButton(getString(R.string.link_cloud_get_code), v ->
                sendCloudCode(cloudEmail, (Button) v, status));
        box.addView(buttonRow(getCode, cloudCode));
        EditText cloudPass = new EditText(this);
        cloudPass.setHint(R.string.link_cloud_pass_hint);
        cloudPass.setSingleLine(true);
        cloudPass.setInputType(InputType.TYPE_CLASS_TEXT | InputType.TYPE_TEXT_VARIATION_PASSWORD);
        EditText cloudRoom = new EditText(this);
        cloudRoom.setHint(R.string.link_cloud_room_hint);
        cloudRoom.setSingleLine(true);
        cloudRoom.setText(getPreferences(MODE_PRIVATE).getString("cloud_room", ""));
        box.addView(cloudPass);
        box.addView(cloudRoom);
        box.addView(buttonRow(
                linkButton(getString(R.string.link_cloud_create), v ->
                        cloudEnter(true, cloudEmail, cloudCode, cloudPass, cloudRoom, status)),
                linkButton(getString(R.string.link_cloud_join), v ->
                        cloudEnter(false, cloudEmail, cloudCode, cloudPass, cloudRoom, status))));
        box.addView(linkButton(getString(R.string.link_cloud_reconnect), v -> {
            if (cloudLink == null) {
                status.setText(R.string.link_cloud_reconnect_need_room);
                return;
            }
            // 不重建房间，直接重新解析中继节点并重连
            ensureCloud().reconnectRelay();
        }));
        box.addView(linkButton(getString(R.string.link_close), v -> {
            if (cloudLink != null) {
                cloudLink.close();
            }
            gboyRemoteKeys = 0;
            publishKeys();
            status.setText(R.string.link_close);
        }));
        box.addView(linkButton(getString(R.string.link_self_test), v -> {
            String e = cloudEmail.getText().toString().trim();
            String p = cloudPass.getText().toString().trim();
            if (e.isEmpty() || p.isEmpty()) {
                status.setText(R.string.link_self_test_fill);
                return;
            }
            ensureCloud().selfTest(e, p);
        }));
        // ---- 局域网 3/4 人：每台设备只跑自己的核，互连走 native 星型总线 ----
        TextView busHelp = new TextView(this);
        busHelp.setText("局域网多人（3/4 人）：每台设备只跑自己的核，四台设备由总线互连。"
                + "开房的一方填人数，其他人填房主的 IP；两边人数必须一致。"
                + "勾选「本机多核锁步」后改为本机跑全套核、SIO 走进程内锁步，网络只传按键。");
        busHelp.setTextColor(0xFF222222);
        busHelp.setPadding(0, pad, 0, 0);
        box.addView(busHelp);
        final EditText busPeer = new EditText(this);
        busPeer.setHint("房主 IP（加入时填，例如 192.168.1.10）");
        busPeer.setSingleLine(true);
        busPeer.setText(getPreferences(MODE_PRIVATE).getString("bus_peer", ""));
        box.addView(busPeer);
        final EditText busPlayers = new EditText(this);
        busPlayers.setHint("人数：3 或 4");
        busPlayers.setSingleLine(true);
        busPlayers.setInputType(InputType.TYPE_CLASS_NUMBER);
        busPlayers.setText(String.valueOf(getPreferences(MODE_PRIVATE).getInt("bus_players", 4)));
        box.addView(busPlayers);
        final CheckBox busLockstep = new CheckBox(this);
        busLockstep.setText("本机多核锁步（3/4 人，实验性）：本机跑全套核，SIO 不跨网络");
        busLockstep.setChecked(getPreferences(MODE_PRIVATE).getBoolean("bus_lockstep", false));
        box.addView(busLockstep);
        box.addView(buttonRow(
                linkButton("开房（3/4 人）", v -> busStart(true, busPeer, busPlayers, busLockstep, status)),
                linkButton("加入（3/4 人）", v -> busStart(false, busPeer, busPlayers, busLockstep, status))));
        box.addView(status);
        ScrollView scroll = new ScrollView(this);
        scroll.addView(box);
        AlertDialog linkDialog = new AlertDialog.Builder(this)
                .setTitle(R.string.link_title)
                .setView(scroll)
                .setNegativeButton(android.R.string.cancel, null)
                .create();
        linkDialog.setOnDismissListener(d -> {
            if (gameView != null) {
                gameView.setVisibility(View.VISIBLE);
            }
        });
        // 某些 ROM/模拟器里 SurfaceView 的表面会盖在对话框窗口之上，导致对话框
        // 按钮收不到 input tap。打开对话框时把 gameView 藏起来，触摸就能落到对话框。
        if (gameView != null) {
            gameView.setVisibility(View.INVISIBLE);
        }
        linkDialog.show();
    }


    private GBoyCloudLink ensureCloud() {
        if (cloudLink == null) {
            cloudLink = new GBoyCloudLink(new GBoyCloudLink.Hooks() {
                @Override
                public String romPath() {
                    return getPreferences(MODE_PRIVATE).getString("lastRom", null);
                }

                @Override
                public MgbaCore core() {
                    return core;
                }

                @Override
                public int localKeys() {
                    return touchKeys | hwKeys;
                }

                @Override
                public void onRemoteKeys(final int keys) {
                    // KEYS arrives ~12x/s; only the transitions matter.
                    if (keys != gboyRemoteKeys) {
                        Log.i(TAG, "remote keys mask=0x" + Integer.toHexString(keys));
                    }
                    runOnUiThread(() -> {
                        gboyRemoteKeys = keys;
                        // In 分开控制 mode the peer's mask must not reach the
                        // core at all, and re-publishing on every 83ms KEY frame
                        // would also wake the emulation thread at the peer's
                        // cadence, making the two consoles run at different speeds.
                        if (gboyRemoteKeysEnabled) {
                            publishRemoteKeys();
                        }
                    });
                }

                @Override
                public void onStatus(final String text) {
                    runOnUiThread(() -> {
                        if (linkStatusView != null) {
                            linkStatusView.setText(text);
                        }
                        // The room code and relay address only live inside the
                        // 联机 dialog; surface them even after it is dismissed.
                        if (text.contains("房号") || text.contains("超时")
                                || text.contains("失败") || text.contains("证书")) {
                            toast(text);
                        }
                    });
                }

                @Override
                public void onConnected(boolean asHost, String note) {
                    // Switch to the official layout: a hidden second console on
                    // loopback SIO, with only key masks crossing the network.
                    // gboy_official_link=false restores the legacy SIO bridge.
                    runOnUiThread(() -> {
                        if (cloudLink == null || !cloudLink.officialMode()) {
                            return;
                        }
                        String path = getPreferences(MODE_PRIVATE)
                                .getString("lastRom", null);
                        if (path == null || core == null || !core.isLoaded()) {
                            return;
                        }
                        File save = defaultSaveDir != null
                                ? defaultSaveDir : getFilesDir();
                        File state = defaultStateDir != null
                                ? defaultStateDir : new File(getFilesDir(), "state");
                        /* 先锁住帧循环再建 2 核：镜像核与可见核必须都在第 0 帧
                         * 入房，否则协调器会卡在一场补不齐的 SIO 回合上（核被
                         * park、模拟线程停摆、画面白掉）。 */
                        linkArmHold = true;
                        /* 两边都从电池存档冷启动：可见核若读即时存档、镜像核
                         * 冷链，两核的游戏上下文一开局就错位，联机永远 pc=0。 */
                        suppressAutoState = true;
                        if (!startGBoyLink(new File(path), save, state, 18781)) {
                            linkArmHold = false;
                            suppressAutoState = false;
                            toast("多核心联机启动失败：" + gboyLinkFailure());
                            return;
                        }
                        /* 关键：可见核此刻已经在跑，直接把锁步房间挂上去会死锁——
                         * 实测可见核停在 mgbaLockstepRunFrame 的 cond_wait、镜像核
                         * 停在 mirrorLoop 的 Object.wait，两边互等（FRM 从此不再
                         * 输出）。本机 busgame 路径能跑通是因为它随后重载了 ROM：
                         * 复位把可见核的锁步驱动卸掉，再从帧边界按原槽位重挂回去。
                         * 云端这里照同一套做，只是不武装 busgame 脚本。 */
                        pendingCloudRearm = true;
                        pendingPath.set(path);
                    });
                }

                @Override
                public void onDisconnected() {
                    runOnUiThread(() -> stopGBoyLink());
                }

                @Override
                public void onRemoteState(final byte[] state) {
                    runOnUiThread(() -> {
                        GBoyConsoleSet set = consoleSet;
                        if (set == null || !set.applyRemoteState(state)) {
                            Log.w(TAG, "TYPE_STATE not applied (no mirror console)");
                        }
                    });
                }

                @Override
                public void onRemoteReset() {
                    runOnUiThread(() -> {
                        if (core != null && core.isLoaded()) {
                            core.reset();
                            core.clearAudio();
                            toast(getString(R.string.reset_done));
                        }
                    });
                }
            });
            cloudLink.setOfficialMode(getPreferences(MODE_PRIVATE)
                    .getBoolean("gboy_official_link", true));
        }
        return cloudLink;
    }

    /**
     * Mails a registration/login code to the address, the same
     * {@code send_verification_code} call the official client makes. The
     * server allows one mail per address every five minutes; the button
     * counts down for a minute and any server-side rate limit surfaces in the
     * status line verbatim.
     */
    private void sendCloudCode(EditText emailBox, Button button, TextView status) {
        final String email = emailBox.getText().toString().trim();
        if (!Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
            status.setText(R.string.link_cloud_need_email);
            return;
        }
        getPreferences(MODE_PRIVATE).edit().putString("cloud_email", email).apply();
        button.setEnabled(false);
        button.setText(R.string.link_cloud_sending);
        new Thread(() -> {
            String failure = null;
            try {
                GbCloud.sendVerificationCode(email);
            } catch (Exception e) {
                failure = GbCloud.lobby(e.getMessage());
            }
            final String error = failure == null || failure.isEmpty() ? null : failure;
            runOnUiThread(() -> {
                if (error != null) {
                    status.setText(error);
                    button.setEnabled(true);
                    button.setText(R.string.link_cloud_get_code);
                    return;
                }
                status.setText(getString(R.string.link_cloud_sent)
                        + "\n" + getString(R.string.link_cloud_mail_note));
                startCodeCooldown(button);
            });
        }, "cloud-code").start();
    }

    /** One-minute re-send countdown so the button cannot spam the mailer. */
    private void startCodeCooldown(Button button) {
        final int[] seconds = {60};
        final Runnable[] tick = new Runnable[1];
        tick[0] = new Runnable() {
            @Override
            public void run() {
                seconds[0]--;
                if (seconds[0] > 0) {
                    button.setText(getString(R.string.link_cloud_resend_in, seconds[0]));
                    inputHandler.postDelayed(tick[0], 1000);
                } else {
                    button.setEnabled(true);
                    button.setText(R.string.link_cloud_get_code);
                }
            }
        };
        button.setText(getString(R.string.link_cloud_resend_in, seconds[0]));
        inputHandler.postDelayed(tick[0], 1000);
    }

    /**
     * Signs into gboy.top with the email+code scheme and then opens the room.
     *
     * The server has no code-only login (its register action doubles as the
     * first login; its login action needs a password), so the flow is: a fresh
     * address registers with the mailed code — username/password are generated
     * and stored so later sessions can log in on their own — and an address
     * that already has an account falls back to password login, either the one
     * typed into the optional password box or the stored one.
     */
    private void cloudEnter(boolean asHost, EditText emailBox, EditText codeBox,
                            EditText passBox, EditText roomBox, TextView status) {
        if (core == null || !core.isLoaded()) {
            status.setText(R.string.link_lobby_no_rom);
            return;
        }
        final String email = emailBox.getText().toString().trim();
        final String code = codeBox.getText().toString().trim();
        final String manualPass = passBox.getText().toString();
        final String room = roomBox.getText().toString().trim();
        if (!Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
            status.setText(R.string.link_cloud_need_email);
            return;
        }
        if (!asHost && room.isEmpty()) {
            status.setText(R.string.link_cloud_need_room);
            return;
        }
        SharedPreferences prefs = getPreferences(MODE_PRIVATE);
        boolean sameAccount = email.equalsIgnoreCase(prefs.getString("cloud_email", ""));
        String savedUser = sameAccount ? prefs.getString("cloud_user", "") : "";
        String savedPass = sameAccount ? prefs.getString("cloud_pass", "") : "";
        if (code.isEmpty() && manualPass.isEmpty() && savedPass.isEmpty()) {
            status.setText(R.string.link_cloud_need_code);
            return;
        }
        status.setText(R.string.link_cloud_auth);
        prefs.edit().putString("cloud_email", email).apply();
        final String password = !manualPass.isEmpty() ? manualPass : savedPass;
        new Thread(() -> {
            try {
                final String[] creds = cloudAuth(email, code, password, savedUser);
                runOnUiThread(() -> ensureCloud().start(creds[0], creds[1], room));
            } catch (Exception e) {
                final String text = GbCloud.lobby(e.getMessage());
                runOnUiThread(() -> status.setText(
                        text == null || text.isEmpty() ? "登录失败" : text));
            }
        }, "cloud-auth").start();
    }

    /** Runs the register-or-login dance; returns {email_or_username, password}. */
    private String[] cloudAuth(String email, String code, String password, String savedUser)
            throws IOException {
        SharedPreferences prefs = getPreferences(MODE_PRIVATE);
        if (!code.isEmpty()) {
            String username = savedUser.isEmpty() ? deriveUsername(email) : savedUser;
            String generated = password.isEmpty() ? randomCloudPassword() : password;
            try {
                username = registerCloudUser(username, email, generated, code);
                prefs.edit()
                        .putString("cloud_user", username)
                        .putString("cloud_pass", generated)
                        .apply();
                return new String[]{email, generated};
            } catch (IOException first) {
                String text = String.valueOf(first.getMessage());
                if (!looksAlreadyRegistered(text) || password.isEmpty()) {
                    throw first;
                }
                // The address already has an account: fall through to password login.
            }
        }
        if (password.isEmpty()) {
            throw new IOException("该邮箱已注册过，请在密码框输入原密码");
        }
        prefs.edit().putString("cloud_pass", password).apply();
        return new String[]{email, password};
    }

    /** Registers with one retry under a throwaway username; returns the name used. */
    private static String registerCloudUser(String username, String email, String password,
                                            String code) throws IOException {
        try {
            GbCloud.register(username, email, password, code);
            return username;
        } catch (IOException e) {
            String text = String.valueOf(e.getMessage());
            if (!text.contains("用户名")) {
                throw e;
            }
            // Username taken: codes stay valid, so retry under a fresh name.
            String fallback = "u" + (100000 + new Random().nextInt(900000));
            GbCloud.register(fallback, email, password, code);
            return fallback;
        }
    }

    /** Server phrasing for "this address already has an account". */
    private static boolean looksAlreadyRegistered(String message) {
        return message.contains("已注册") || message.contains("已被注册")
                || message.contains("已存在") || message.contains("已使用")
                || message.contains("已绑定");
    }

    /** Builds a 2-10 char username candidate out of the mailbox name. */
    private static String deriveUsername(String email) {
        String prefix = email;
        int at = prefix.indexOf('@');
        if (at > 0) {
            prefix = prefix.substring(0, at);
        }
        StringBuilder out = new StringBuilder();
        // The upstream brand name must never end up in the account name: the
        // server echoes it back in places (lobby lists, mails).
        String clean = prefix.replaceAll("(?i)gboy", "lobby");
        for (char c : clean.toCharArray()) {
            if (Character.isLetterOrDigit(c) || c == '_') {
                out.append(c);
            }
            if (out.length() >= 10) {
                break;
            }
        }
        if (out.length() < 2) {
            out.append('u').append(100000 + new Random().nextInt(900000));
        }
        return out.substring(0, Math.min(out.length(), 10));
    }

    private static String randomCloudPassword() {
        // No lookalike characters (l/1, O/0): the generated password is shown
        // nowhere, but it is stored and re-used for logins, so keep it typable.
        String alphabet = "abcdefghjkmnpqrstuvwxyzABCDEFGHJKMNPQRSTUVWXYZ23456789";
        StringBuilder out = new StringBuilder(12);
        Random random = new Random();
        for (int i = 0; i < 12; i++) {
            out.append(alphabet.charAt(random.nextInt(alphabet.length())));
        }
        return out.toString();
    }


    private Button linkButton(String text, View.OnClickListener listener) {
        Button button = new Button(this);
        button.setText(text);
        button.setAllCaps(false);
        button.setTextSize(12);
        button.setOnClickListener(listener);
        return button;
    }

    private LinearLayout buttonRow(View left, View right) {
        LinearLayout row = new LinearLayout(this);
        row.setOrientation(LinearLayout.HORIZONTAL);
        LinearLayout.LayoutParams lp = new LinearLayout.LayoutParams(0, LinearLayout.LayoutParams.WRAP_CONTENT, 1f);
        row.addView(left, lp);
        row.addView(right, lp);
        return row;
    }



    /** Android 13+ 的通知权限只为前台服务那张常驻通知，拒绝也不影响联机本身。 */
    private void requestNotificationPermission() {
        if (Build.VERSION.SDK_INT < 33) {
            return;
        }
        if (checkSelfPermission("android.permission.POST_NOTIFICATIONS") == PackageManager.PERMISSION_GRANTED) {
            return;
        }
        try {
            requestPermissions(new String[] {"android.permission.POST_NOTIFICATIONS"}, 0x4D48);
        } catch (RuntimeException ignored) {
        }
    }



    private int parsePort(String text) {
        try {
            int port = Integer.parseInt(text.trim());
            if (port >= 1 && port <= 65535) {
                return port;
            }
        } catch (NumberFormatException ignored) {
        }
        return -1;
    }

    private String localIpv4() {
        List<String> all = localIpv4List();
        return all.isEmpty() ? "0.0.0.0" : all.get(0);
    }

    /**
     * 本机所有可用的 IPv4。异地联机时对方要走虚拟局域网或公网地址，
     * 所以不能只报第一个（那通常是 192.168.x.x，外网不可达）。
     */
    private List<String> localIpv4List() {
        ArrayList<String> out = new ArrayList<>();
        try {
            ArrayList<NetworkInterface> ifaces = Collections.list(NetworkInterface.getNetworkInterfaces());
            for (NetworkInterface iface : ifaces) {
                if (!iface.isUp() || iface.isLoopback()) {
                    continue;
                }
                for (InetAddress address : Collections.list(iface.getInetAddresses())) {
                    if (!(address instanceof Inet4Address) || address.isLoopbackAddress()) {
                        continue;
                    }
                    String ip = address.getHostAddress();
                    if (ip == null || ip.startsWith("169.254.")) {
                        continue;   // 链路本地地址，对端一定连不上
                    }
                    if (!out.contains(ip)) {
                        out.add(ip);
                    }
                }
            }
        } catch (Exception ignored) {
        }
        Collections.sort(out, Comparator.comparingInt(EmulatorActivity::ipv4Rank));
        return out;
    }

    /** 家用局域网排前面，虚拟网卡（Tailscale 100.64/10、ZeroTier 等）排后面。 */
    private static int ipv4Rank(String ip) {
        if (ip.startsWith("192.168.")) {
            return 0;
        }
        if (ip.startsWith("10.")) {
            return 1;
        }
        if (ip.startsWith("172.")) {
            return 2;
        }
        if (ip.startsWith("100.")) {
            return 3;   // Tailscale / CGNAT 段
        }
        return 4;
    }

    /** 把所有本机地址和端口拼成多行提示，创建方直接照着报给对面。 */
    private String localIpv4Hint(int port) {
        List<String> all = localIpv4List();
        if (all.isEmpty()) {
            return "0.0.0.0:" + port;
        }
        StringBuilder sb = new StringBuilder();
        for (String ip : all) {
            if (sb.length() > 0) {
                sb.append('\n');
            }
            sb.append(ip).append(':').append(port);
        }
        return sb.toString();
    }

    private int dp(int value) {
        return Math.round(value * getResources().getDisplayMetrics().density);
    }

    private void buildSpeedBar() {
        speedBar = findViewById(R.id.speed_bar);
        LinearLayout row = findViewById(R.id.speed_row);
        LinearLayout audioRow = findViewById(R.id.audio_row);
        TextView label = new TextView(this);
        label.setText(R.string.speed_pick);
        label.setTextColor(Color.WHITE);
        label.setPadding(dp(8), 0, dp(4), 0);
        row.addView(label);
        for (int i = 0; i < SPEED_TIERS.length; i++) {
            Button button = new Button(this);
            float value = SPEED_TIERS[i];
            button.setText(value == (long) value ? String.valueOf((long) value) : String.format(Locale.US, "%.2g", value));
            button.setAllCaps(false);
            button.setMinWidth(dp(44));
            button.setMinHeight(dp(36));
            button.setMinimumWidth(dp(44));
            button.setMinimumHeight(dp(36));
            button.setTextSize(14);
            button.setPadding(dp(8), 0, dp(8), 0);
            button.setOnClickListener(v -> setSpeed(value));
            speedButtons[i] = button;
            row.addView(button);
        }
        speedCustom = new Button(this);
        speedCustom.setText(R.string.speed_custom);
        speedCustom.setAllCaps(false);
        speedCustom.setMinWidth(dp(52));
        speedCustom.setMinHeight(dp(36));
        speedCustom.setMinimumWidth(dp(52));
        speedCustom.setMinimumHeight(dp(36));
        speedCustom.setTextSize(14);
        speedCustom.setPadding(dp(8), 0, dp(8), 0);
        speedCustom.setOnClickListener(v -> showCustomSpeedDialog());
        row.addView(speedCustom);
        SharedPreferences prefs = getPreferences(MODE_PRIVATE);
        CheckBox sound = new CheckBox(this);
        sound.setText(R.string.speed_sound);
        sound.setTextColor(Color.WHITE);
        sound.setTextSize(13);
        boolean soundOn = prefs.getBoolean("fast_audio", true);
        sound.setChecked(soundOn);
        audioRow.addView(sound);

        CheckBox constSpeed = new CheckBox(this);
        constSpeed.setText(R.string.speed_sound_const);
        constSpeed.setTextColor(Color.WHITE);
        constSpeed.setTextSize(13);
        boolean constOn = prefs.getBoolean("fast_audio_native", true);
        constSpeed.setChecked(constOn);
        constSpeed.setEnabled(soundOn);
        constSpeed.setAlpha(soundOn ? 1.0f : 0.45f);
        audioRow.addView(constSpeed);

        sound.setOnCheckedChangeListener((v, checked) -> {
            prefs.edit().putBoolean("fast_audio", checked).apply();
            // 不变速 only makes sense when sound is on during fast-forward.
            constSpeed.setEnabled(checked);
            constSpeed.setAlpha(checked ? 1.0f : 0.45f);
            syncFastAudio(currentGameSpeed());
        });
        constSpeed.setOnCheckedChangeListener((v, checked) -> {
            prefs.edit().putBoolean("fast_audio_native", checked).apply();
            syncFastAudio(currentGameSpeed());
        });
        refreshSpeedButtons();
    }

    /** Speed used while the fast-forward key is held (TAB, controller, on-screen 倍速 key). */
    private float fastHoldSpeed() {
        try {
            return Math.max(2f, Math.min(16f, getPreferences(MODE_PRIVATE).getInt("fast_hold", 16)));
        } catch (ClassCastException e) {
            return 16f;
        }
    }

    private void showCustomSpeedDialog() {
        EditText input = new EditText(this);
        input.setInputType(InputType.TYPE_CLASS_NUMBER | InputType.TYPE_NUMBER_FLAG_DECIMAL);
        input.setHint(R.string.speed_custom_hint);
        float current = speed;
        input.setText(current == (long) current ? String.valueOf((long) current) : String.format(Locale.US, "%.2f", current));
        LinearLayout box = new LinearLayout(this);
        box.setOrientation(LinearLayout.VERTICAL);
        int pad = dp(16);
        box.setPadding(pad, pad, pad, 0);
        box.addView(input);
        new AlertDialog.Builder(this)
                .setTitle(R.string.speed_custom)
                .setView(box)
                .setPositiveButton(android.R.string.ok, (d, w) -> {
                    try {
                        float value = Float.parseFloat(input.getText().toString().trim().replace(',', '.'));
                        if (value < 0.05f) {
                            value = 0.05f;
                        }
                        if (value > 16f) {
                            value = 16f;
                        }
                        setSpeed(value);
                    } catch (NumberFormatException ignored) {
                        toast(getString(R.string.speed_bad_value));
                    }
                })
                .setNegativeButton(android.R.string.cancel, null)
                .show();
    }

    private void setSpeed(float value) {
        if (value < 0.05f) {
            value = 0.05f;
        }
        if (value > 16f) {
            value = 16f;
        }
        speed = value;
        refreshSpeedButtons();
    }

    private void refreshSpeedButtons() {
        float shown = fastHold ? Math.max(speed, fastHoldSpeed()) : speed;
        fastButton.setText(getString(R.string.speed_value, speedLabel(shown)));
        boolean tierMatched = false;
        for (int i = 0; i < SPEED_TIERS.length; i++) {
            boolean on = !tierMatched && Math.abs(SPEED_TIERS[i] - speed) < 0.001f;
            if (on) {
                tierMatched = true;
            }
            speedButtons[i].setTextColor(on ? 0xFF102010 : Color.WHITE);
            speedButtons[i].setBackgroundColor(on ? 0xFF3DDC84 : Color.TRANSPARENT);
        }
        speedCustom.setTextColor(!tierMatched ? 0xFF102010 : Color.WHITE);
        speedCustom.setBackgroundColor(!tierMatched ? 0xFF3DDC84 : Color.TRANSPARENT);
    }

    private static String speedLabel(float value) {
        return value == (long) value ? String.valueOf((long) value) : String.format(Locale.US, "%.2f", value);
    }

    /** Settings hub: emulation, input, saves and hardware extras live in sub-dialogs. */
    private void showSettingsDialog() {
        final int IDX_ORIENTATION = 0;
        final int IDX_SOUND = 1;
        final int IDX_INPUT = 2;
        final int IDX_SAVE = 3;
        final int IDX_ADVANCED = 4;
        final int IDX_ROM_DIRS = 5;
        final int IDX_SCAN = 6;
        final int IDX_HELP = 7;
        String[] items = {
                getString(R.string.orientation_title),
                getString(R.string.settings_sound),
                getString(R.string.settings_input),
                getString(R.string.settings_save),
                getString(R.string.settings_advanced),
                getString(R.string.rom_dirs_menu),
                getString(R.string.scan_button),
                getString(R.string.settings_help),
        };
        new AlertDialog.Builder(this)
                .setTitle(R.string.settings)
                .setItems(items, (dialog, which) -> {
                    if (which == IDX_ORIENTATION) {
                        showOrientationDialog();
                    } else if (which == IDX_SOUND) {
                        showSoundDialog();
                    } else if (which == IDX_INPUT) {
                        showInputDialog();
                    } else if (which == IDX_SAVE) {
                        showSaveSettingsDialog();
                    } else if (which == IDX_ADVANCED) {
                        showAdvancedDialog();
                    } else if (which == IDX_ROM_DIRS) {
                        showRomDirsDialog();
                    } else if (which == IDX_SCAN) {
                        showRomScan();
                    } else if (which == IDX_HELP) {
                        showHelpDialog();
                    }
                })
                .show();
    }

    private void showOrientationDialog() {
        String mode = getPreferences(MODE_PRIVATE).getString("orientation", "landscape");
        int checked = "portrait".equals(mode) ? 2
                : "portrait_rev".equals(mode) ? 3
                : "landscape_rev".equals(mode) ? 1
                : "auto".equals(mode) ? 4
                : "system".equals(mode) ? 5 : 0;
        new AlertDialog.Builder(this)
                .setTitle(R.string.orientation_title)
                .setSingleChoiceItems(new CharSequence[] {
                        getString(R.string.orientation_landscape),
                        getString(R.string.orientation_landscape_rev),
                        getString(R.string.orientation_portrait),
                        getString(R.string.orientation_portrait_rev),
                        getString(R.string.orientation_auto),
                        getString(R.string.orientation_system),
                }, checked, (dialog, which) -> {
                    String next = which == 2 ? "portrait"
                            : which == 3 ? "portrait_rev"
                            : which == 1 ? "landscape_rev"
                            : which == 4 ? "auto"
                            : which == 5 ? "system" : "landscape";
                    getPreferences(MODE_PRIVATE).edit()
                            .putString("orientation", next)
                            .apply();
                    applyOrientation(next);
                    dialog.dismiss();
                })
                .show();
    }

    private void showSoundDialog() {
        ScrollView scroll = new ScrollView(this);
        LinearLayout box = new LinearLayout(this);
        box.setOrientation(LinearLayout.VERTICAL);
        int pad = dp(16);
        box.setPadding(pad, pad, pad, pad);
        scroll.addView(box);
        int volumeNow = getPreferences(MODE_PRIVATE).getInt("volume", 100);
        TextView volumeLabel = new TextView(this);
        volumeLabel.setText(getString(R.string.sound_volume, volumeNow));
        volumeLabel.setTextColor(0xFF222222);
        SeekBar volumeBar = new SeekBar(this);
        volumeBar.setMax(150);
        volumeBar.setProgress(volumeNow);
        CheckBox lowLatency = check(R.string.sound_low_latency, getPreferences(MODE_PRIVATE).getBoolean("low_latency", false));
        CheckBox immersive = check(R.string.settings_immersive, getPreferences(MODE_PRIVATE).getBoolean("immersive", true));
        box.addView(volumeLabel);
        box.addView(volumeBar);
        box.addView(lowLatency);
        box.addView(immersive);
        volumeBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                volumeLabel.setText(getString(R.string.sound_volume, progress));
                volumePercent = progress;
                if (fromUser) {
                    getPreferences(MODE_PRIVATE).edit().putInt("volume", progress).apply();
                }
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
            }
        });
        lowLatency.setOnCheckedChangeListener((v, checked) -> {
            getPreferences(MODE_PRIVATE).edit().putBoolean("low_latency", checked).apply();
            setupAudio();
        });
        immersive.setOnCheckedChangeListener((v, checked) -> {
            getPreferences(MODE_PRIVATE).edit().putBoolean("immersive", checked).apply();
            if (checked) {
                hideSystemUi();
            }
        });
        // Per-channel gains (Pizza Boy's 通道音量): 0-100 percent each.
        String[] channelPrefs = {"vol_ch1", "vol_ch2", "vol_ch3", "vol_ch4", "vol_cha", "vol_chb"};
        String[] channelLabels = {
                getString(R.string.channel_1), getString(R.string.channel_2),
                getString(R.string.channel_3), getString(R.string.channel_4),
                getString(R.string.channel_a), getString(R.string.channel_b),
        };
        TextView[] channelViews = new TextView[channelPrefs.length];
        for (int i = 0; i < channelPrefs.length; i++) {
            int value = getPreferences(MODE_PRIVATE).getInt(channelPrefs[i], 100);
            TextView label = new TextView(this);
            label.setText(channelLabels[i] + " " + value + "%");
            label.setTextColor(0xFF222222);
            SeekBar bar = new SeekBar(this);
            bar.setMax(150);
            bar.setProgress(value);
            final int index = i;
            bar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
                @Override
                public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                    label.setText(channelLabels[index] + " " + progress + "%");
                    if (fromUser) {
                        getPreferences(MODE_PRIVATE).edit().putInt(channelPrefs[index], progress).apply();
                        applyChannelVolumes();
                    }
                }

                @Override
                public void onStartTrackingTouch(SeekBar seekBar) {
                }

                @Override
                public void onStopTrackingTouch(SeekBar seekBar) {
                }
            });
            channelViews[i] = label;
            box.addView(label);
            box.addView(bar);
        }
        TextView channelHint = new TextView(this);
        channelHint.setText(R.string.channel_volume);
        channelHint.setTextColor(0xFF888888);
        channelHint.setTextSize(11);
        box.addView(channelHint);
        new AlertDialog.Builder(this)
                .setTitle(R.string.settings_sound)
                .setView(scroll)
                .setPositiveButton(android.R.string.ok, null)
                .show();
    }

    private void showInputDialog() {
        ScrollView scroll = new ScrollView(this);
        LinearLayout box = new LinearLayout(this);
        box.setOrientation(LinearLayout.VERTICAL);
        int pad = dp(16);
        box.setPadding(pad, pad, pad, pad);
        scroll.addView(box);
        final Button vibe = new Button(this);
        vibe.setAllCaps(false);
        vibe.setText(getString(R.string.input_vibe, vibeName(getPreferences(MODE_PRIVATE).getInt("touch_vibe", 0))));
        vibe.setOnClickListener(v -> new AlertDialog.Builder(this)
                .setTitle(R.string.input_vibe_title)
                .setSingleChoiceItems(new CharSequence[] {
                        getString(R.string.vibe_off), getString(R.string.vibe_light),
                        getString(R.string.vibe_medium), getString(R.string.vibe_strong)
                }, getPreferences(MODE_PRIVATE).getInt("touch_vibe", 0), (dialog, which) -> {
                    getPreferences(MODE_PRIVATE).edit().putInt("touch_vibe", which).apply();
                    vibe.setText(getString(R.string.input_vibe, vibeName(which)));
                    dialog.dismiss();
                })
                .show());
        final Button turboMode = new Button(this);
        turboMode.setAllCaps(false);
        turboMode.setText(getString(R.string.input_turbo_mode, turboModeName(turboModePref())));
        turboMode.setOnClickListener(v -> new AlertDialog.Builder(this)
                .setTitle(R.string.input_turbo_mode_title)
                .setSingleChoiceItems(new CharSequence[] {
                        getString(R.string.turbo_hold_b), getString(R.string.turbo_keys), getString(R.string.turbo_off)
                }, turboModePref(), (dialog, which) -> {
                    getPreferences(MODE_PRIVATE).edit().putInt("turbo_mode", which).apply();
                    turboMode.setText(getString(R.string.input_turbo_mode, turboModeName(which)));
                    dialog.dismiss();
                })
                .show());
        int rateNow = getPreferences(MODE_PRIVATE).getInt("turbo_rate", 25);
        TextView rateLabel = new TextView(this);
        rateLabel.setText(getString(R.string.input_turbo_rate, rateNow));
        rateLabel.setTextColor(0xFF222222);
        SeekBar rateBar = new SeekBar(this);
        rateBar.setMax(28);
        rateBar.setProgress(Math.max(0, Math.min(28, rateNow - 2)));
        CheckBox diagonal = check(R.string.input_no_diagonal, getPreferences(MODE_PRIVATE).getBoolean("no_diagonal", false));
        int opacityNow = getPreferences(MODE_PRIVATE).getInt("controls_opacity", 100);
        TextView opacityLabel = new TextView(this);
        opacityLabel.setText(getString(R.string.input_opacity, opacityNow));
        opacityLabel.setTextColor(0xFF222222);
        SeekBar opacityBar = new SeekBar(this);
        opacityBar.setMax(120);
        opacityBar.setProgress(opacityNow - 30);
        final Button extras = new Button(this);
        extras.setAllCaps(false);
        extras.setText(R.string.input_extras);
        extras.setOnClickListener(v -> showExtraKeysDialog());
        final Button rewindTap = new Button(this);
        rewindTap.setAllCaps(false);
        rewindTap.setText(getString(R.string.rewind_tap, rewindTapSeconds()));
        rewindTap.setOnClickListener(v -> {
            CharSequence[] labels = new CharSequence[10];
            for (int i = 0; i < labels.length; i++) {
                labels[i] = rewindLabel(i + 1);
            }
            new AlertDialog.Builder(this)
                    .setTitle(R.string.rewind_tap_title)
                    .setSingleChoiceItems(labels, rewindTapSeconds() - 1, (dialog, which) -> {
                        int seconds = which + 1;
                        getPreferences(MODE_PRIVATE).edit().putInt("rewind_tap_seconds", seconds).apply();
                        rewindTap.setText(getString(R.string.rewind_tap, seconds));
                        if (controls != null) {
                            controls.setQuickRewindSeconds(seconds);
                        }
                        dialog.dismiss();
                    })
                    .show();
        });
        final Button cKey = new Button(this);
        cKey.setAllCaps(false);
        cKey.setText(R.string.c_button);
        cKey.setOnClickListener(v -> showMacroDialog(0));
        final Button c2Key = new Button(this);
        c2Key.setAllCaps(false);
        c2Key.setText(R.string.c2_button);
        c2Key.setOnClickListener(v -> showMacroDialog(1));
        final Button shotFormat = new Button(this);
        shotFormat.setAllCaps(false);
        String fmt = getPreferences(MODE_PRIVATE).getString("shot_format", "png");
        shotFormat.setText(getString(R.string.shot_format) + ": " + fmt.toUpperCase(Locale.US));
        shotFormat.setOnClickListener(v -> new AlertDialog.Builder(this)
                .setTitle(R.string.shot_format)
                .setSingleChoiceItems(new CharSequence[]{"PNG", "JPG"},
                        "jpg".equals(getPreferences(MODE_PRIVATE).getString("shot_format", "png")) ? 1 : 0,
                        (dialog, which) -> {
                            getPreferences(MODE_PRIVATE).edit().putString("shot_format", which == 1 ? "jpg" : "png").apply();
                            shotFormat.setText(getString(R.string.shot_format) + ": " + (which == 1 ? "JPG" : "PNG"));
                            dialog.dismiss();
                        })
                .show());
        CheckBox doubleShot = check(R.string.double_click_shot, getPreferences(MODE_PRIVATE).getBoolean("double_click_shot", false));
        doubleShot.setOnCheckedChangeListener((v, checked) ->
                getPreferences(MODE_PRIVATE).edit().putBoolean("double_click_shot", checked).apply());
        CheckBox keypadDetect = check(R.string.keypad_detect, getPreferences(MODE_PRIVATE).getBoolean("keypad_detect", false));
        keypadDetect.setOnCheckedChangeListener((v, checked) -> {
            getPreferences(MODE_PRIVATE).edit().putBoolean("keypad_detect", checked).apply();
            if (checked) {
                hwKeyPromptShown = false;
            }
        });
        CheckBox vkeypadVisible = check(R.string.vkeypad_visible,
                !getPreferences(MODE_PRIVATE).getBoolean("vkeypad_hidden", false));
        vkeypadVisible.setOnCheckedChangeListener((v, checked) -> {
            getPreferences(MODE_PRIVATE).edit().putBoolean("vkeypad_hidden", !checked).apply();
            applyInputSettings();
        });
        box.addView(vibe);
        box.addView(turboMode);
        box.addView(rateLabel);
        box.addView(rateBar);
        box.addView(diagonal);
        box.addView(opacityLabel);
        box.addView(opacityBar);
        box.addView(extras);
        box.addView(rewindTap);
        box.addView(cKey);
        box.addView(c2Key);
        box.addView(shotFormat);
        box.addView(doubleShot);
        box.addView(keypadDetect);
        box.addView(vkeypadVisible);
        rateBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                int rate = progress + 2;
                rateLabel.setText(getString(R.string.input_turbo_rate, rate));
                if (fromUser) {
                    getPreferences(MODE_PRIVATE).edit().putInt("turbo_rate", rate).apply();
                    applyInputSettings();
                }
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
            }
        });
        diagonal.setOnCheckedChangeListener((v, checked) -> {
            getPreferences(MODE_PRIVATE).edit().putBoolean("no_diagonal", checked).apply();
            applyInputSettings();
        });
        opacityBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                int percent = progress + 30;
                opacityLabel.setText(getString(R.string.input_opacity, percent));
                if (fromUser) {
                    getPreferences(MODE_PRIVATE).edit().putInt("controls_opacity", percent).apply();
                    applyInputSettings();
                }
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
            }
        });
        new AlertDialog.Builder(this)
                .setTitle(R.string.settings_input)
                .setView(scroll)
                .setPositiveButton(android.R.string.ok, null)
                .show();
    }

    /** Names of the optional on-screen keys, shown and stored in this order. */
    private static final String[][] EXTRA_KEY_CHOICES = {
            {"ta", "A键（连发）"}, {"tb", "B键（连发）"}, {"lr", "L+R键"},
            {"c", "C键（组合宏）"}, {"c2", "C2键（组合宏）"},
            {"save", "快速存档"}, {"load", "快速读档"}, {"ff", "倍速（按住快进）"}, {"shot", "截图"},
            {"rewind", "倒带快捷键（点一次 2 秒）"},
    };

    private void showExtraKeysDialog() {
        Set<String> enabled = extraKeys();
        boolean[] checked = new boolean[EXTRA_KEY_CHOICES.length];
        CharSequence[] labels = new CharSequence[EXTRA_KEY_CHOICES.length];
        for (int i = 0; i < EXTRA_KEY_CHOICES.length; i++) {
            labels[i] = EXTRA_KEY_CHOICES[i][1];
            checked[i] = enabled.contains(EXTRA_KEY_CHOICES[i][0]);
        }
        new AlertDialog.Builder(this)
                .setTitle(R.string.input_extras)
                .setMultiChoiceItems(labels, checked, (dialog, which, isChecked) -> {
                    Set<String> next = extraKeys();
                    if (isChecked) {
                        next.add(EXTRA_KEY_CHOICES[which][0]);
                    } else {
                        next.remove(EXTRA_KEY_CHOICES[which][0]);
                    }
                    saveExtraKeys(next);
                    applyInputSettings();
                })
                .setPositiveButton(android.R.string.ok, null)
                .show();
    }

    private void saveExtraKeys(Set<String> keys) {
        StringBuilder csv = new StringBuilder();
        for (String key : keys) {
            if (csv.length() > 0) {
                csv.append(',');
            }
            csv.append(key);
        }
        getPreferences(MODE_PRIVATE).edit().putString("extra_keys", csv.toString()).apply();
    }

    private Set<String> extraKeys() {
        Set<String> out = new HashSet<>();
        String csv;
        try {
            csv = getPreferences(MODE_PRIVATE).getString("extra_keys", null);
        } catch (ClassCastException e) {
            csv = null;
        }
        if (csv == null) {
            // First launch: put the one-tap rewind key on screen by default.
            out.add("rewind");
            return out;
        }
        if (!csv.isEmpty()) {
            for (String key : csv.split(",")) {
                for (String[] choice : EXTRA_KEY_CHOICES) {
                    if (choice[0].equals(key)) {
                        out.add(key);
                    }
                }
            }
        }
        return out;
    }

    private void showSaveSettingsDialog() {
        ScrollView scroll = new ScrollView(this);
        LinearLayout box = new LinearLayout(this);
        box.setOrientation(LinearLayout.VERTICAL);
        int pad = dp(16);
        box.setPadding(pad, pad, pad, pad);
        scroll.addView(box);
        final Button saveType = new Button(this);
        saveType.setAllCaps(false);
        saveType.setText(getString(R.string.save_type, saveTypeName(saveTypePref())));
        saveType.setOnClickListener(v -> new AlertDialog.Builder(this)
                .setTitle(R.string.save_type_title)
                .setSingleChoiceItems(new CharSequence[] {
                        saveTypeName(3), saveTypeName(-1), saveTypeName(4), saveTypeName(5),
                        saveTypeName(2), saveTypeName(1), saveTypeName(6), saveTypeName(0)
                }, saveTypeChoiceIndex(), (dialog, which) -> {
                    int[] values = {3, -1, 4, 5, 2, 1, 6, 0};
                    getPreferences(MODE_PRIVATE).edit().putInt("save_type", values[which]).apply();
                    applyCoreOptions();
                    saveType.setText(getString(R.string.save_type, saveTypeName(values[which])));
                    dialog.dismiss();
                })
                .show());
        CheckBox autoLoad = check(R.string.save_auto_load, getPreferences(MODE_PRIVATE).getBoolean("auto_load_state", false));
        CheckBox autoSave = check(R.string.save_auto_write, getPreferences(MODE_PRIVATE).getBoolean("auto_save_state", false));
        CheckBox confirmClose = check(R.string.save_confirm, getPreferences(MODE_PRIVATE).getBoolean("confirm_close", false));
        CheckBox patches = check(R.string.save_patches, getPreferences(MODE_PRIVATE).getBoolean("patches", true));
        CheckBox quickRotate = check(R.string.quick_rotate, getPreferences(MODE_PRIVATE).getBoolean("quick_rotate", false));
        CheckBox confirmQuick = check(R.string.confirm_quick, getPreferences(MODE_PRIVATE).getBoolean("confirm_quick", false));
        CheckBox besideRom = check(R.string.save_beside_rom,
                getPreferences(MODE_PRIVATE).getBoolean("saves_beside_rom", false));
        final Button timedSave = new Button(this);
        timedSave.setAllCaps(false);
        int timedNow = 0;
        try {
            timedNow = getPreferences(MODE_PRIVATE).getInt("timed_save_min", 0);
        } catch (ClassCastException ignored) {
        }
        timedSave.setText(getString(R.string.timed_save) + ": " +
                (timedNow <= 0 ? getString(R.string.timed_save_off) : getString(R.string.timed_save_min, timedNow)));
        timedSave.setOnClickListener(v -> {
            CharSequence[] options = {
                    getString(R.string.timed_save_off),
                    getString(R.string.timed_save_min, 5),
                    getString(R.string.timed_save_min, 10),
                    getString(R.string.timed_save_min, 30),
            };
            int[] minutes = {0, 5, 10, 30};
            new AlertDialog.Builder(this)
                    .setTitle(R.string.timed_save)
                    .setSingleChoiceItems(options, -1, (dialog, which) -> {
                        getPreferences(MODE_PRIVATE).edit().putInt("timed_save_min", minutes[which]).apply();
                        timedSave.setText(getString(R.string.timed_save) + ": " + options[which]);
                        if (core != null && core.isLoaded()) {
                            startTimedSave();
                        }
                        dialog.dismiss();
                    })
                    .show();
        });
        Button deleteSav = new Button(this);
        deleteSav.setAllCaps(false);
        deleteSav.setText(R.string.save_delete_battery);
        deleteSav.setOnClickListener(v -> confirmDeleteBattery());
        Button importSav = new Button(this);
        importSav.setAllCaps(false);
        importSav.setText(R.string.save_import_myboy);
        importSav.setOnClickListener(v -> {
            try {
                Intent intent = new Intent(Intent.ACTION_OPEN_DOCUMENT_TREE);
                startActivityForResult(intent, REQ_SAVDIR);
            } catch (Exception e) {
                toast(getString(R.string.load_failed));
            }
        });
        Button sync = new Button(this);
        sync.setAllCaps(false);
        sync.setText(R.string.sync_title);
        sync.setOnClickListener(v -> showSyncDialog());
        box.addView(saveType);
        box.addView(autoLoad);
        box.addView(autoSave);
        box.addView(confirmClose);
        box.addView(patches);
        box.addView(quickRotate);
        box.addView(confirmQuick);
        box.addView(besideRom);
        box.addView(timedSave);
        box.addView(deleteSav);
        box.addView(importSav);
        box.addView(sync);
        autoLoad.setOnCheckedChangeListener((v, checked) -> getPreferences(MODE_PRIVATE).edit().putBoolean("auto_load_state", checked).apply());
        autoSave.setOnCheckedChangeListener((v, checked) -> getPreferences(MODE_PRIVATE).edit().putBoolean("auto_save_state", checked).apply());
        confirmClose.setOnCheckedChangeListener((v, checked) -> getPreferences(MODE_PRIVATE).edit().putBoolean("confirm_close", checked).apply());
        quickRotate.setOnCheckedChangeListener((v, checked) -> getPreferences(MODE_PRIVATE).edit().putBoolean("quick_rotate", checked).apply());
        confirmQuick.setOnCheckedChangeListener((v, checked) -> getPreferences(MODE_PRIVATE).edit().putBoolean("confirm_quick", checked).apply());
        besideRom.setOnCheckedChangeListener((v, checked) ->
                getPreferences(MODE_PRIVATE).edit().putBoolean("saves_beside_rom", checked).apply());
        patches.setOnCheckedChangeListener((v, checked) -> {
            getPreferences(MODE_PRIVATE).edit().putBoolean("patches", checked).apply();
            applyCoreOptions();
        });
        new AlertDialog.Builder(this)
                .setTitle(R.string.settings_save)
                .setView(scroll)
                .setPositiveButton(android.R.string.ok, null)
                .show();
    }

    private void showAdvancedDialog() {
        ScrollView scroll = new ScrollView(this);
        LinearLayout box = new LinearLayout(this);
        box.setOrientation(LinearLayout.VERTICAL);
        int pad = dp(16);
        box.setPadding(pad, pad, pad, pad);
        scroll.addView(box);
        CheckBox useBios = check(R.string.adv_use_bios, getPreferences(MODE_PRIVATE).getBoolean("use_bios", true));
        CheckBox skipBios = check(R.string.adv_skip_bios, getPreferences(MODE_PRIVATE).getBoolean("skip_bios", true));
        final Button clock = new Button(this);
        clock.setAllCaps(false);
        clock.setText(getString(R.string.adv_clock, clockName(rtcModePref())));
        clock.setOnClickListener(v -> pickRtcMode(clock));
        CheckBox rumblePak = check(R.string.adv_rumble, getPreferences(MODE_PRIVATE).getBoolean("cart_rumble", false));
        CheckBox solar = check(R.string.adv_solar, getPreferences(MODE_PRIVATE).getBoolean("solar_on", false));
        int solarNow = getPreferences(MODE_PRIVATE).getInt("solar_level", 5);
        TextView solarLabel = new TextView(this);
        solarLabel.setText(getString(R.string.adv_solar_level, solarNow));
        solarLabel.setTextColor(0xFF222222);
        SeekBar solarBar = new SeekBar(this);
        solarBar.setMax(10);
        solarBar.setProgress(solarNow);
        CheckBox solarKeys = check(R.string.adv_solar_keys, getPreferences(MODE_PRIVATE).getBoolean("solar_volkeys", false));
        final Button solarSource = new Button(this);
        solarSource.setAllCaps(false);
        solarSource.setText(getString(R.string.solar_source, solarSourceName()));
        solarSource.setOnClickListener(v -> new AlertDialog.Builder(this)
                .setTitle(R.string.solar_source)
                .setSingleChoiceItems(new CharSequence[]{
                        getString(R.string.solar_source_keys),
                        getString(R.string.solar_source_sensor)
                }, "sensor".equals(getPreferences(MODE_PRIVATE).getString("solar_source", "keys")) ? 1 : 0,
                        (dialog, which) -> {
                            getPreferences(MODE_PRIVATE).edit()
                                    .putString("solar_source", which == 1 ? "sensor" : "keys").apply();
                            solarSource.setText(getString(R.string.solar_source, solarSourceName()));
                            updateSolarSource();
                            dialog.dismiss();
                        })
                .show());
        CheckBox sgbBorders = check(R.string.adv_sgb_border, getPreferences(MODE_PRIVATE).getBoolean("sgb_borders", false));
        CheckBox tiltSensor = check(R.string.adv_tilt, getPreferences(MODE_PRIVATE).getBoolean("tilt_sensor", false));
        CheckBox gifBallCheck = check(R.string.adv_gif_ball, getPreferences(MODE_PRIVATE).getBoolean("gif_ball", false));
        CheckBox noticeCheck = check(R.string.adv_notice, getPreferences(MODE_PRIVATE).getBoolean("keep_notice", true));
        final Button palette = new Button(this);
        palette.setAllCaps(false);
        palette.setText(getString(R.string.adv_palette, paletteName(palettePref())));
        palette.setOnClickListener(v -> new AlertDialog.Builder(this)
                .setTitle(R.string.adv_palette_title)
                .setSingleChoiceItems(paletteNames(), palettePref(), (dialog, which) -> {
                    getPreferences(MODE_PRIVATE).edit().putInt("gb_palette", which).apply();
                    palette.setText(getString(R.string.adv_palette, paletteName(which)));
                    applyCoreOptions();
                    dialog.dismiss();
                })
                .show());
        TextView fastLabel = new TextView(this);
        int fastNow = (int) fastHoldSpeed();
        fastLabel.setText(getString(R.string.adv_fast_hold, fastNow));
        fastLabel.setTextColor(0xFF222222);
        SeekBar fastBar = new SeekBar(this);
        fastBar.setMax(14);
        fastBar.setProgress(Math.max(0, Math.min(14, fastNow - 2)));
        box.addView(useBios);
        box.addView(skipBios);
        box.addView(clock);
        box.addView(rumblePak);
        box.addView(solar);
        box.addView(solarLabel);
        box.addView(solarBar);
        box.addView(solarKeys);
        box.addView(solarSource);
        box.addView(sgbBorders);
        box.addView(tiltSensor);
        box.addView(gifBallCheck);
        box.addView(noticeCheck);
        box.addView(palette);
        box.addView(fastLabel);
        box.addView(fastBar);
        useBios.setOnCheckedChangeListener((v, checked) -> {
            getPreferences(MODE_PRIVATE).edit().putBoolean("use_bios", checked).apply();
            applyCoreOptions();
        });
        skipBios.setOnCheckedChangeListener((v, checked) -> {
            getPreferences(MODE_PRIVATE).edit().putBoolean("skip_bios", checked).apply();
            applyCoreOptions();
        });
        rumblePak.setOnCheckedChangeListener((v, checked) -> {
            getPreferences(MODE_PRIVATE).edit().putBoolean("cart_rumble", checked).apply();
            applyCoreOptions();
        });
        solar.setOnCheckedChangeListener((v, checked) -> {
            getPreferences(MODE_PRIVATE).edit().putBoolean("solar_on", checked).apply();
            applyCoreOptions();
        });
        solarBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                solarLabel.setText(getString(R.string.adv_solar_level, progress));
                if (fromUser) {
                    getPreferences(MODE_PRIVATE).edit().putInt("solar_level", progress).apply();
                    applyCoreOptions();
                }
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
            }
        });
        solarKeys.setOnCheckedChangeListener((v, checked) -> getPreferences(MODE_PRIVATE).edit().putBoolean("solar_volkeys", checked).apply());
        gifBallCheck.setOnCheckedChangeListener((v, checked) -> {
            getPreferences(MODE_PRIVATE).edit().putBoolean("gif_ball", checked).apply();
            setupGifBall();
            refreshGifBall();
        });
        noticeCheck.setOnCheckedChangeListener((v, checked) -> {
            getPreferences(MODE_PRIVATE).edit().putBoolean("keep_notice", checked).apply();
            if (!checked) {
                NoticeService.stop(this);
            } else if (core != null && core.isLoaded()) {
                startNoticeIfWanted(core.title());
            }
        });
        sgbBorders.setOnCheckedChangeListener((v, checked) -> {
            getPreferences(MODE_PRIVATE).edit().putBoolean("sgb_borders", checked).apply();
            applyCoreOptions();
        });
        tiltSensor.setOnCheckedChangeListener((v, checked) -> {
            getPreferences(MODE_PRIVATE).edit().putBoolean("tilt_sensor", checked).apply();
            updateTiltSensor();
            if (!checked && core != null) {
                // Neutral tilt so a held cartridge stops reacting.
                core.setRotation(0f, 0f, 0f);
            }
        });
        fastBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                fastLabel.setText(getString(R.string.adv_fast_hold, progress + 2));
                if (fromUser) {
                    getPreferences(MODE_PRIVATE).edit().putInt("fast_hold", progress + 2).apply();
                    refreshSpeedButtons();
                }
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
            }
        });
        new AlertDialog.Builder(this)
                .setTitle(R.string.settings_advanced)
                .setView(scroll)
                .setPositiveButton(android.R.string.ok, null)
                .show();
    }

    /** Game clock: wall clock, a fixed moment, or wall clock shifted by minutes. */
    private void pickRtcMode(Button label) {
        new AlertDialog.Builder(this)
                .setTitle(R.string.adv_clock_title)
                .setItems(new CharSequence[] {
                        getString(R.string.clock_real), getString(R.string.clock_fixed), getString(R.string.clock_offset)
                }, (dialog, which) -> {
                    getPreferences(MODE_PRIVATE).edit().putInt("rtc_mode", which).apply();
                    if (which == 1) {
                        pickRtcDate(label);
                    } else if (which == 2) {
                        pickRtcOffset(label);
                    } else {
                        applyCoreOptions();
                        label.setText(getString(R.string.adv_clock, clockName(which)));
                    }
                })
                .show();
    }

    private void pickRtcDate(Button label) {
        Calendar base = Calendar.getInstance();
        long epoch = getPreferences(MODE_PRIVATE).getLong("rtc_epoch", base.getTimeInMillis() / 1000L);
        Calendar current = Calendar.getInstance();
        current.setTimeInMillis(epoch * 1000L);
        new DatePickerDialog(this, (view, year, month, day) -> {
            Calendar picked = Calendar.getInstance();
            picked.set(year, month, day, current.get(Calendar.HOUR_OF_DAY), current.get(Calendar.MINUTE));
            pickRtcTime(label, picked);
        }, current.get(Calendar.YEAR), current.get(Calendar.MONTH), current.get(Calendar.DAY_OF_MONTH)).show();
    }

    private void pickRtcTime(Button label, Calendar picked) {
        new TimePickerDialog(this, (view, hour, minute) -> {
            Calendar done = Calendar.getInstance();
            done.set(picked.get(Calendar.YEAR), picked.get(Calendar.MONTH), picked.get(Calendar.DAY_OF_MONTH), hour, minute, 0);
            getPreferences(MODE_PRIVATE).edit()
                    .putLong("rtc_epoch", done.getTimeInMillis() / 1000L)
                    .apply();
            applyCoreOptions();
            label.setText(getString(R.string.adv_clock, clockName(1)));
        }, picked.get(Calendar.HOUR_OF_DAY), picked.get(Calendar.MINUTE), true).show();
    }

    private void pickRtcOffset(Button label) {
        EditText input = new EditText(this);
        input.setInputType(InputType.TYPE_CLASS_NUMBER | InputType.TYPE_NUMBER_FLAG_SIGNED);
        input.setText(String.valueOf(getPreferences(MODE_PRIVATE).getInt("rtc_offset_min", 0)));
        LinearLayout box = new LinearLayout(this);
        box.setOrientation(LinearLayout.VERTICAL);
        int pad = dp(16);
        box.setPadding(pad, pad, pad, 0);
        box.addView(input);
        new AlertDialog.Builder(this)
                .setTitle(R.string.clock_offset)
                .setView(box)
                .setPositiveButton(android.R.string.ok, (d, w) -> {
                    int minutes = 0;
                    try {
                        minutes = Integer.parseInt(input.getText().toString().trim());
                    } catch (NumberFormatException ignored) {
                    }
                    getPreferences(MODE_PRIVATE).edit().putInt("rtc_offset_min", minutes).apply();
                    applyCoreOptions();
                    label.setText(getString(R.string.adv_clock, clockName(2)));
                })
                .setNegativeButton(android.R.string.cancel, null)
                .show();
    }

    private void showHelpDialog() {
        TextView text = new TextView(this);
        int pad = dp(20);
        text.setPadding(pad, pad, pad, pad);
        text.setText(R.string.settings_help_text);
        new AlertDialog.Builder(this)
                .setTitle(R.string.settings_help)
                .setView(new ScrollView(this) {{
                    addView(text);
                }})
                .setPositiveButton(android.R.string.ok, null)
                .show();
    }

    // == Settings plumbing ==

    private int turboModePref() {
        return getPreferences(MODE_PRIVATE).getInt("turbo_mode", 0);
    }

    private static String turboModeName(int mode) {
        switch (mode) {
            case 1:
                return "连发键";
            case 2:
                return "关闭";
            default:
                return "长按B键";
        }
    }

    private static String vibeName(int strength) {
        switch (strength) {
            case 1:
                return "轻";
            case 2:
                return "中";
            case 3:
                return "强";
            default:
                return "关";
        }
    }

    private int saveTypePref() {
        try {
            return getPreferences(MODE_PRIVATE).getInt("save_type", 3);
        } catch (ClassCastException e) {
            return 3;
        }
    }

    private int saveTypeChoiceIndex() {
        switch (saveTypePref()) {
            case -1:
                return 1;
            case 4:
                return 2;
            case 5:
                return 3;
            case 2:
                return 4;
            case 1:
                return 5;
            case 6:
                return 6;
            case 0:
                return 7;
            default:
                return 0;
        }
    }

    private static String saveTypeName(int type) {
        switch (type) {
            case -1:
                return "自动检测";
            case 0:
                return "不保存";
            case 1:
                return "SRAM 32KB";
            case 2:
                return "FLASH 64KB";
            case 4:
                return "EEPROM 8KB";
            case 5:
                return "EEPROM 512B";
            case 6:
                return "SRAM 64KB";
            default:
                return "FLASH 128KB";
        }
    }

    private int rtcModePref() {
        return getPreferences(MODE_PRIVATE).getInt("rtc_mode", 0);
    }

    private static String clockName(int mode) {
        switch (mode) {
            case 1:
                return "固定时间";
            case 2:
                return "偏移时间";
            default:
                return "实时时钟";
        }
    }

    /** Sends the six per-channel gains to the core; 100% = 256 fixed point. */
    private void applyChannelVolumes() {
        if (core == null) {
            return;
        }
        int[] gains = new int[6];
        String[] channelPrefs = {"vol_ch1", "vol_ch2", "vol_ch3", "vol_ch4", "vol_cha", "vol_chb"};
        for (int i = 0; i < channelPrefs.length; i++) {
            int percent = getPreferences(MODE_PRIVATE).getInt(channelPrefs[i], 100);
            gains[i] = Math.max(0, Math.min(384, percent * 256 / 100));
        }
        core.setChannelVolumes(gains);
    }

    /** Pushes the emulation-related preferences into the core. */
    private void applyCoreOptions() {
        if (core == null) {
            return;
        }
        core.setSaveType(saveTypePref());
        core.setPatches(getPreferences(MODE_PRIVATE).getBoolean("patches", true));
        core.setBiosOptions(getPreferences(MODE_PRIVATE).getBoolean("use_bios", true),
                getPreferences(MODE_PRIVATE).getBoolean("skip_bios", true));
        int mode = rtcModePref();
        long epoch = getPreferences(MODE_PRIVATE).getLong("rtc_epoch", System.currentTimeMillis() / 1000L);
        long offset = getPreferences(MODE_PRIVATE).getInt("rtc_offset_min", 0) * 60L;
        core.setRtc(mode, epoch, offset);
        core.setSolar(getPreferences(MODE_PRIVATE).getBoolean("solar_on", false)
                ? getPreferences(MODE_PRIVATE).getInt("solar_level", 5) : -1);
        updateSolarSource();
        core.setCartRumble(getPreferences(MODE_PRIVATE).getBoolean("cart_rumble", false));
        int[] palette = gbPaletteColors();
        core.setGbPalette(palette);
        core.setSgbBorders(getPreferences(MODE_PRIVATE).getBoolean("sgb_borders", false));
        applyChannelVolumes();
        updateTiltSensor();
        // Neutral until a reading arrives; keeps held cartridges from drifting.
        core.setRotation(0f, 0f, 0f);
    }

    private CharSequence[] paletteNames() {
        CharSequence[] names = new CharSequence[GB_PALETTES.length];
        for (int i = 0; i < GB_PALETTES.length; i++) {
            names[i] = paletteName(i);
        }
        return names;
    }

    /** Starts or stops the device posture listener for tilt cartridges. */
    private void updateTiltSensor() {
        boolean wanted = getPreferences(MODE_PRIVATE).getBoolean("tilt_sensor", false);
        if (wanted && !tiltListening) {
            if (sensorManager == null) {
                sensorManager = (SensorManager) getSystemService(SENSOR_SERVICE);
            }
            Sensor accel = sensorManager == null ? null : sensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);
            if (accel != null) {
                sensorManager.registerListener(tiltListener, accel, SensorManager.SENSOR_DELAY_GAME);
                tiltListening = true;
            }
        } else if (!wanted && tiltListening) {
            sensorManager.unregisterListener(tiltListener);
            tiltListening = false;
        }
    }

    private final SensorEventListener tiltListener = new SensorEventListener() {
        @Override
        public void onSensorChanged(SensorEvent event) {
            if (core == null || !core.isLoaded()) {
                return;
            }
            // Gravity along the device's x/y axes, normalized to roughly one
            // gravity at full deflection; re-axed for landscape so tilting the
            // phone tilts the cartridge the way the screen moves.
            float x = event.values[0] / 9.81f;
            float y = event.values[1] / 9.81f;
            if (getResources().getConfiguration().orientation == Configuration.ORIENTATION_LANDSCAPE) {
                float swap = x;
                x = y;
                y = -swap;
            }
            core.setRotation(clampTilt(x), clampTilt(y), 0f);
        }

        @Override
        public void onAccuracyChanged(Sensor sensor, int accuracy) {
        }
    };

    private static float clampTilt(float value) {
        return Math.max(-1f, Math.min(1f, value * 1.4f));
    }

    /** Pushes the input-related preferences into the on-screen controls. */
    private void applyInputSettings() {
        SharedPreferences prefs = getPreferences(MODE_PRIVATE);
        if (!prefs.getBoolean("rewind_key_seen", false)) {
            // One-time upgrade: show the new one-tap rewind key even for
            // players who had already saved an extras list before it existed.
            Set<String> extras = extraKeys();
            if (extras.add("rewind")) {
                saveExtraKeys(extras);
            }
            prefs.edit().putBoolean("rewind_key_seen", true).apply();
        }
        if (controls != null) {
            controls.setVisibility(getPreferences(MODE_PRIVATE).getBoolean("vkeypad_hidden", false)
                    ? View.GONE : View.VISIBLE);
            controls.setDiagonalLock(getPreferences(MODE_PRIVATE).getBoolean("no_diagonal", false));
            controls.setTurboRate(getPreferences(MODE_PRIVATE).getInt("turbo_rate", 25));
            controls.setVisibleExtras(extraKeys());
            controls.setQuickRewindSeconds(rewindTapSeconds());
            controls.setOpacity(getPreferences(MODE_PRIVATE).getInt("controls_opacity", 100));
            controls.setMacro(0, getPreferences(MODE_PRIVATE).getInt("c_macro", ControlsView.A | ControlsView.B));
            controls.setMacro(1, getPreferences(MODE_PRIVATE).getInt("c2_macro", ControlsView.L | ControlsView.R));
        }
        volumePercent = getPreferences(MODE_PRIVATE).getInt("volume", 100);
    }

    /** Vibration strength for on-screen key presses, 0-3. */
    private void vibrateOnKey(int risingBits) {
        if (vibrator == null || risingBits == 0) {
            return;
        }
        int strength = getPreferences(MODE_PRIVATE).getInt("touch_vibe", 0);
        if (strength <= 0 || !vibrator.hasVibrator()) {
            return;
        }
        int amplitude = strength == 1 ? 60 : strength == 2 ? 140 : 255;
        if (Build.VERSION.SDK_INT >= 26) {
            vibrator.vibrate(VibrationEffect.createOneShot(20, amplitude));
        } else {
            vibrator.vibrate(20);
        }
    }

    /** Cartridge rumble pulses, drained once per emulation slice. */
    private void pollRumble() {
        if (core == null) {
            return;
        }
        int hits = core.takeRumbles();
        if (hits <= 0) {
            return;
        }
        long now = System.nanoTime();
        if (now - lastRumbleAt < 200_000_000L) {
            return;
        }
        lastRumbleAt = now;
        if (vibrator != null && vibrator.hasVibrator()) {
            if (Build.VERSION.SDK_INT >= 26) {
                vibrator.vibrate(VibrationEffect.createOneShot(40, 180));
            } else {
                vibrator.vibrate(40);
            }
        }
    }

    private void confirmReset() {
        if (core == null || !core.isLoaded() || !getPreferences(MODE_PRIVATE).getBoolean("confirm_close", false)) {
            command.set(CMD_RESET);
            return;
        }
        new AlertDialog.Builder(this)
                .setTitle(R.string.reset)
                .setMessage(R.string.confirm_reset_message)
                .setPositiveButton(android.R.string.ok, (d, w) -> command.set(CMD_RESET))
                .setNegativeButton(android.R.string.cancel, null)
                .show();
    }

    /** Quick save/load used by the optional on-screen utility keys. */
    private void quickState(boolean save) {
        if (core == null || !core.isLoaded()) {
            toast(getString(R.string.no_rom));
            return;
        }
        Runnable go = () -> {
            if (save && getPreferences(MODE_PRIVATE).getBoolean("quick_rotate", false)) {
                slot = slot % 9 + 1;
                refreshSlotButton();
            }
            if (save) {
                recyclePendingPreview();
                pendingPreview.set(gameView.copyLast());
                command.set(CMD_SAVE);
            } else {
                command.set(CMD_LOAD);
            }
        };
        if (getPreferences(MODE_PRIVATE).getBoolean("confirm_quick", false)) {
            new AlertDialog.Builder(this)
                    .setTitle(save ? R.string.state_pick_save : R.string.state_pick_load)
                    .setMessage(getString(save ? R.string.state_pick_save : R.string.state_pick_load)
                            + (save ? " 槽位 " + slot : ""))
                    .setPositiveButton(android.R.string.ok, (d, w) -> go.run())
                    .setNegativeButton(android.R.string.cancel, null)
                    .show();
        } else {
            go.run();
        }
    }

    /**
     * Test hook: writes the current GBA frame under the app's external files
     * dir (no MediaStore round-trip, safe from adb). This is what the
     * SCREENSHOT broadcast and the {@code shot} launch extra use.
     */
    private void saveDebugShot() {
        Bitmap shot = gameView.copyLast();
        if (shot == null) {
            Log.i(TAG, "debug shot: no frame yet");
            return;
        }
        new Thread(() -> {
            File dir = new File(getExternalFilesDir(null), "shots");
            if (!dir.isDirectory() && !dir.mkdirs()) {
                Log.w(TAG, "debug shot: cannot create " + dir);
                shot.recycle();
                return;
            }
            File file = new File(dir, System.currentTimeMillis() + ".png");
            try (OutputStream out = new FileOutputStream(file)) {
                shot.compress(Bitmap.CompressFormat.PNG, 100, out);
                Log.i(TAG, "debug shot saved " + file);
            } catch (Exception e) {
                Log.w(TAG, "debug shot failed", e);
            } finally {
                shot.recycle();
            }
        }, "debug-shot").start();
    }

    /** Saves the current frame as a PNG into the system Pictures folder. */
    private void takeScreenshot() {
        Log.i(TAG, "takeScreenshot core=" + (core != null && core.isLoaded()) + " last=" + (gameView.copyLast() != null));
        if (core == null || !core.isLoaded()) {
            toast(getString(R.string.no_rom));
            return;
        }
        // With a filter on screen, capture the rendered output so the saved
        // file matches the display; the raw core frame is otherwise crisper.
        if (gameView.screenFiltered() && Build.VERSION.SDK_INT >= 26) {
            copyScreenAsBitmap(bitmap -> {
                if (bitmap == null) {
                    bitmap = gameView.copyLast();
                }
                saveScreenshot(bitmap);
            });
            return;
        }
        saveScreenshot(gameView.copyLast());
    }

    private void saveScreenshot(@Nullable Bitmap shot) {
        if (shot == null) {
            toast(getString(R.string.no_rom));
            return;
        }
        boolean jpg = "jpg".equals(getPreferences(MODE_PRIVATE).getString("shot_format", "png"));
        String stamp = DateFormat.format("yyyyMMdd-HHmmss", System.currentTimeMillis()).toString();
        String ext = jpg ? "jpg" : "png";
        String title = "mGBAx-" + stamp + "." + ext;
        Bitmap.CompressFormat format = jpg ? Bitmap.CompressFormat.JPEG : Bitmap.CompressFormat.PNG;
        try {
            if (Build.VERSION.SDK_INT >= 29) {
                ContentValues values = new ContentValues();
                values.put(MediaStore.Images.Media.DISPLAY_NAME, title);
                values.put(MediaStore.Images.Media.MIME_TYPE, jpg ? "image/jpeg" : "image/png");
                values.put(MediaStore.Images.Media.RELATIVE_PATH, Environment.DIRECTORY_PICTURES + "/mGBAx");
                Uri uri = getContentResolver().insert(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, values);
                if (uri != null) {
                    try (OutputStream out = getContentResolver().openOutputStream(uri)) {
                        shot.compress(format, 95, out);
                    }
                }
            } else {
                File dir = new File(Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_PICTURES), "mGBAx");
                dir.mkdirs();
                try (OutputStream out = new FileOutputStream(new File(dir, title))) {
                    shot.compress(format, 95, out);
                }
            }
            toast(getString(R.string.screenshot_saved, "Pictures/mGBAx/" + title));
        } catch (Exception e) {
            toast(getString(R.string.screenshot_failed));
        } finally {
            shot.recycle();
        }
    }

    private interface BitmapCallback {
        void onBitmap(@Nullable Bitmap bitmap);
    }

    /** Captures what the game view actually renders, filters included. */
    private void copyScreenAsBitmap(BitmapCallback done) {
        int w = gameView.getWidth();
        int h = gameView.getHeight();
        if (w <= 0 || h <= 0) {
            done.onBitmap(null);
            return;
        }
        Bitmap out = Bitmap.createBitmap(w, h, Bitmap.Config.ARGB_8888);
        try {
            PixelCopy.request(gameView, out, result -> {
                if (result == PixelCopy.SUCCESS) {
                    done.onBitmap(out);
                } else {
                    out.recycle();
                    done.onBitmap(null);
                }
            }, new Handler(Looper.getMainLooper()));
        } catch (Exception e) {
            out.recycle();
            done.onBitmap(null);
        }
    }

    /** Hands the presented frame to the encoder at the GIF capture rate. */
    private void captureGifFrame() {
        if (!gifRecording || gifQueue == null) {
            return;
        }
        long now = System.nanoTime() / 1_000_000L;
        if (now - lastGifAt < GIF_FRAME_MS) {
            return;
        }
        lastGifAt = now;
        Bitmap copy = frame.copy(Bitmap.Config.ARGB_8888, false);
        if (copy == null) {
            return;
        }
        // With a filter on screen the raw core frame would not match the
        // display; capture the rendered view instead, scaled back to the
        // game's size. The raw frame is otherwise the crisper source.
        if (gameView.screenFiltered() && Build.VERSION.SDK_INT >= 26) {
            captureFilteredGifFrame(copy);
            return;
        }
        offerGifFrame(copy);
    }

    /** Hops to the UI thread and PixelCopies the rendered game view. */
    private void captureFilteredGifFrame(Bitmap raw) {
        if (!gifCopyBusy.compareAndSet(false, true)) {
            raw.recycle();
            return;
        }
        gameView.post(() -> {
            int w = gameView.getWidth();
            int h = gameView.getHeight();
            if (w <= 0 || h <= 0) {
                gifCopyBusy.set(false);
                offerGifFrame(raw);
                return;
            }
            Bitmap out = Bitmap.createBitmap(w, h, Bitmap.Config.ARGB_8888);
            try {
                PixelCopy.request(gameView, out, result -> {
                    gifCopyBusy.set(false);
                    if (result == PixelCopy.SUCCESS) {
                        Bitmap scaled = Bitmap.createScaledBitmap(out, gifWidth, gifHeight, true);
                        out.recycle();
                        raw.recycle();
                        offerGifFrame(scaled);
                    } else {
                        out.recycle();
                        offerGifFrame(raw);
                    }
                }, new Handler(Looper.getMainLooper()));
            } catch (Exception e) {
                gifCopyBusy.set(false);
                out.recycle();
                offerGifFrame(raw);
            }
        });
    }

    private void offerGifFrame(Bitmap bitmap) {
        java.util.concurrent.ArrayBlockingQueue<Bitmap> queue = gifQueue;
        if (queue == null) {
            bitmap.recycle();
            return;
        }
        if (!queue.offer(bitmap)) {
            bitmap.recycle();
        }
    }

    /** Starts recording the presented frames into a GIF in Pictures/mGBA. */
    private void startGif() {
        if (core == null || !core.isLoaded()) {
            toast(getString(R.string.no_rom));
            return;
        }
        if (gifRecording || (gifThread != null && gifThread.isAlive())) {
            return;
        }
        int w = core.width();
        int h = core.height();
        if (w <= 0 || h <= 0) {
            toast(getString(R.string.no_rom));
            return;
        }
        String stamp = DateFormat.format("yyyyMMdd-HHmmss", System.currentTimeMillis()).toString();
        String name = "mGBAx-" + stamp + ".gif";
        File temp = new File(getCacheDir(), "gif-recording.gif");
        temp.delete();
        gifQueue = new java.util.concurrent.ArrayBlockingQueue<>(24);
        gifWidth = w;
        gifHeight = h;
        lastGifAt = 0;
        gifFrames = 0;
        gifRecording = true;
        gifThread = new Thread(() -> runGifRecording(temp, w, h, name), "gif-record");
        gifThread.start();
        if (gifButton != null) {
            gifButton.setText(R.string.gif_stop);
        }
        if (gifBall != null) {
            gifBall.setRecording(true);
        }
        toast(getString(R.string.gif_started));
    }

    private void stopGif() {
        gifRecording = false;
        if (gifBall != null) {
            gifBall.setRecording(false);
        }
    }

    /** Encoder loop: drains the queue into the GIF file, then publishes it. */
    private void runGifRecording(File temp, int w, int h, String name) {
        java.util.concurrent.ArrayBlockingQueue<Bitmap> queue = gifQueue;
        boolean ok;
        try (FileOutputStream stream = new FileOutputStream(temp)) {
            GifEncoder encoder = new GifEncoder(stream, w, h);
            while (true) {
                Bitmap bmp;
                try {
                    bmp = queue.poll(1, java.util.concurrent.TimeUnit.SECONDS);
                } catch (InterruptedException e) {
                    bmp = null;
                    gifRecording = false;
                }
                if (bmp == null) {
                    if (!gifRecording) {
                        break;
                    }
                    continue;
                }
                encoder.addFrame(bmp, GIF_FRAME_MS / 10);
                bmp.recycle();
                if (++gifFrames >= GIF_MAX_FRAMES) {
                    // Reached the length cap: stop as if the user had.
                    gifRecording = false;
                }
            }
            encoder.finish();
            ok = true;
            Log.i(TAG, "gif encoded " + gifFrames + " frames -> " + temp);
        } catch (Exception e) {
            ok = false;
            Log.e(TAG, "gif encoding failed", e);
        }
        final boolean done = ok;
        runOnUiThread(() -> {
            gifQueue = null;
            gifThread = null;
            if (gifButton != null) {
                gifButton.setText(R.string.gif_record);
            }
            if (isFinishing() || isDestroyed()) {
                return;
            }
            String path = done && gifFrames > 0 ? publishGif(temp, name) : null;
            if (path != null) {
                toast(getString(R.string.gif_saved, path));
            } else {
                temp.delete();
                toast(getString(R.string.gif_failed));
            }
        });
    }

    /** Moves the finished recording into Pictures/mGBAx; returns the shown path. */
    @Nullable
    private String publishGif(File temp, String name) {
        try {
            if (Build.VERSION.SDK_INT >= 29) {
                ContentValues values = new ContentValues();
                values.put(MediaStore.Images.Media.DISPLAY_NAME, name);
                values.put(MediaStore.Images.Media.MIME_TYPE, "image/gif");
                values.put(MediaStore.Images.Media.RELATIVE_PATH, Environment.DIRECTORY_PICTURES + "/mGBAx");
                Uri uri = getContentResolver().insert(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, values);
                if (uri == null) {
                    return null;
                }
                try (InputStream in = new java.io.FileInputStream(temp);
                     OutputStream out = getContentResolver().openOutputStream(uri)) {
                    copyStreams(in, out);
                }
            } else {
                File dir = new File(Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_PICTURES), "mGBAx");
                if (!dir.isDirectory() && !dir.mkdirs()) {
                    throw new java.io.IOException("mkdirs failed");
                }
                try (InputStream in = new java.io.FileInputStream(temp);
                     OutputStream out = new FileOutputStream(new File(dir, name))) {
                    copyStreams(in, out);
                }
            }
            temp.delete();
            return "Pictures/mGBAx/" + name;
        } catch (Exception e) {
            try {
                File dir = new File(getExternalFilesDir(null), "Pictures");
                dir.mkdirs();
                File dest = new File(dir, name);
                try (InputStream in = new java.io.FileInputStream(temp);
                     OutputStream out = new FileOutputStream(dest)) {
                    copyStreams(in, out);
                }
                temp.delete();
                return dest.getAbsolutePath();
            } catch (Exception ignored) {
                return null;
            }
        }
    }

    private static void copyStreams(@Nullable InputStream in, @Nullable OutputStream out) throws java.io.IOException {
        if (in == null || out == null) {
            throw new java.io.IOException("stream unavailable");
        }
        byte[] buffer = new byte[65536];
        int n;
        while ((n = in.read(buffer)) > 0) {
            out.write(buffer, 0, n);
        }
    }

    private void confirmDeleteBattery() {        if (core == null || !core.isLoaded()) {
            toast(getString(R.string.no_rom));
            return;
        }
        String path = core.saveFile();
        if (path == null || path.isEmpty() || !new File(path).isFile()) {
            toast(getString(R.string.battery_missing));
            return;
        }
        new AlertDialog.Builder(this)
                .setTitle(R.string.save_delete_battery)
                .setMessage(getString(R.string.delete_battery_message, new File(path).getName()))
                .setPositiveButton(android.R.string.ok, (d, w) -> {
                    File backup = new File(path + ".bak");
                    backup.delete();
                    if (new File(path).renameTo(backup)) {
                        toast(getString(R.string.battery_deleted));
                        String last = getPreferences(MODE_PRIVATE).getString("lastRom", null);
                        if (last != null) {
                            pendingPath.set(last);
                        }
                    } else {
                        toast(getString(R.string.battery_delete_failed));
                    }
                })
                .setNegativeButton(android.R.string.cancel, null)
                .show();
    }

    /** Cheats list: toggle with the checkbox, long-press to delete, 新增 to add. */
    private void showCheatsDialog() {
        if (core == null || !core.isLoaded()) {
            toast(getString(R.string.no_rom));
            return;
        }
        int count = core.cheatCount();
        LinearLayout list = new LinearLayout(this);
        list.setOrientation(LinearLayout.VERTICAL);
        int pad = dp(8);
        list.setPadding(pad, pad, pad, pad);
        ScrollView scroll = new ScrollView(this);
        scroll.addView(list);
        if (count == 0) {
            TextView empty = new TextView(this);
            empty.setText(R.string.cheats_empty);
            empty.setPadding(0, pad, 0, pad);
            list.addView(empty);
        }
        AlertDialog[] holder = new AlertDialog[1];
        for (int i = 0; i < count; i++) {
            final int index = i;
            LinearLayout row = new LinearLayout(this);
            row.setOrientation(LinearLayout.HORIZONTAL);
            row.setGravity(Gravity.CENTER_VERTICAL);
            CheckBox box = new CheckBox(this);
            box.setText(core.cheatName(index));
            box.setTextColor(0xFF222222);
            box.setTextSize(15);
            box.setChecked(core.cheatEnabled(index));
            box.setOnCheckedChangeListener((v, checked) -> core.cheatSetEnabled(index, checked));
            row.addView(box, new LinearLayout.LayoutParams(0, LinearLayout.LayoutParams.WRAP_CONTENT, 1f));
            row.setOnLongClickListener(v -> {
                new AlertDialog.Builder(EmulatorActivity.this)
                        .setTitle(R.string.cheat_delete)
                        .setMessage(getString(R.string.cheat_delete_message, core.cheatName(index)))
                        .setPositiveButton(android.R.string.ok, (d, w) -> {
                            core.cheatRemove(index);
                            if (holder[0] != null) {
                                holder[0].dismiss();
                            }
                            showCheatsDialog();
                        })
                        .setNegativeButton(android.R.string.cancel, null)
                        .show();
                return true;
            });
            list.addView(row);
        }
        AlertDialog dialog = new AlertDialog.Builder(this)
                .setTitle(R.string.cheats_title)
                .setView(scroll)
                .setPositiveButton(R.string.cheat_add, (d, w) -> showCheatEditDialog())
                .setNegativeButton(android.R.string.cancel, null)
                .create();
        holder[0] = dialog;
        dialog.show();
    }

    private void showCheatEditDialog() {
        ScrollView scroll = new ScrollView(this);
        LinearLayout box = new LinearLayout(this);
        box.setOrientation(LinearLayout.VERTICAL);
        int pad = dp(16);
        box.setPadding(pad, pad, pad, pad);
        scroll.addView(box);
        final EditText name = new EditText(this);
        name.setHint(R.string.cheat_name_hint);
        name.setSingleLine(true);
        final Button format = new Button(this);
        format.setAllCaps(false);
        final int[] type = {0};
        format.setText(getString(R.string.cheat_format, cheatFormatName(0)));
        format.setOnClickListener(v -> new AlertDialog.Builder(this)
                .setTitle(R.string.cheat_format_title)
                .setSingleChoiceItems(new CharSequence[] {
                        cheatFormatName(0), cheatFormatName(1), cheatFormatName(2),
                        cheatFormatName(3), cheatFormatName(4)
                }, type[0], (dialog, which) -> {
                    type[0] = which;
                    format.setText(getString(R.string.cheat_format, cheatFormatName(which)));
                    dialog.dismiss();
                })
                .show());
        final EditText lines = new EditText(this);
        lines.setHint(R.string.cheat_codes_hint);
        lines.setInputType(InputType.TYPE_CLASS_TEXT | InputType.TYPE_TEXT_FLAG_MULTI_LINE);
        lines.setMinLines(4);
        lines.setGravity(Gravity.TOP | Gravity.START);
        box.addView(name);
        box.addView(format);
        box.addView(lines);
        new AlertDialog.Builder(this)
                .setTitle(R.string.cheat_add)
                .setView(scroll)
                .setPositiveButton(android.R.string.ok, (d, w) -> {
                    String codeName = name.getText().toString().trim();
                    String codeLines = lines.getText().toString().trim();
                    if (codeName.isEmpty()) {
                        codeName = getString(R.string.cheat_default_name);
                    }
                    if (codeLines.isEmpty() || !core.cheatAdd(codeName, codeLines, type[0])) {
                        toast(getString(R.string.cheat_bad_code));
                        return;
                    }
                    toast(getString(R.string.cheat_added, codeName));
                })
                .setNegativeButton(android.R.string.cancel, null)
                .show();
    }

    private static String cheatFormatName(int type) {
        switch (type) {
            case 1:
                return "代码断路器 CodeBreaker";
            case 2:
                return "金手指 v1/v2 GameShark";
            case 3:
                return "动作回放 Action Replay";
            case 4:
                return "VBA 码";
            default:
                return "自动识别";
        }
    }

    /** Copies My Boy .sav files from a picked folder next to the matching ROM saves. */
    private void importMyBoySaves(Uri tree) {
        File destDir = SaveLocation.prepare(this);
        toast(getString(R.string.myboy_scanning));
        new Thread(() -> {
            int ok = 0;
            int fail = 0;
            try {
                Uri children = DocumentsContract.buildChildDocumentsUriUsingTree(tree,
                        DocumentsContract.getTreeDocumentId(tree));
                List<String[]> found = new ArrayList<>();
                Cursor cursor = getContentResolver().query(children,
                        new String[]{DocumentsContract.Document.COLUMN_DOCUMENT_ID,
                                DocumentsContract.Document.COLUMN_DISPLAY_NAME}, null, null, null);
                if (cursor != null) {
                    while (cursor.moveToNext()) {
                        String id = cursor.getString(0);
                        String display = cursor.getString(1);
                        if (id != null && display != null && display.toLowerCase(Locale.ROOT).endsWith(".sav")) {
                            found.add(new String[]{id, display});
                        }
                    }
                    cursor.close();
                }
                for (String[] entry : found) {
                    Uri file = DocumentsContract.buildDocumentUriUsingTree(tree, entry[0]);
                    String base = entry[1];
                    // "Rom.gba.sav" -> "Rom", plain "Rom.sav" -> "Rom"
                    if (base.toLowerCase(Locale.ROOT).endsWith(".sav")) {
                        base = base.substring(0, base.length() - 4);
                    }
                    String lower = base.toLowerCase(Locale.ROOT);
                    if (lower.endsWith(".gba") || lower.endsWith(".gbc") || lower.endsWith(".gb") || lower.endsWith(".sgb")) {
                        base = base.substring(0, base.lastIndexOf('.'));
                    }
                    if (base.isEmpty()) {
                        fail++;
                        continue;
                    }
                    File target = new File(destDir, base + ".sav");
                    try (InputStream in = getContentResolver().openInputStream(file);
                         OutputStream out = new FileOutputStream(target)) {
                        if (in == null) {
                            fail++;
                            continue;
                        }
                        byte[] buffer = new byte[65536];
                        int n;
                        while ((n = in.read(buffer)) > 0) {
                            out.write(buffer, 0, n);
                        }
                        ok++;
                    } catch (Exception e) {
                        fail++;
                    }
                }
            } catch (Exception e) {
                fail++;
            }
            final int good = ok;
            final int bad = fail;
            runOnUiThread(() -> toast(getString(R.string.myboy_done, good, bad)));
        }, "sav-import").start();
    }

    // == Features ported from Pizza Boy ==

    private static final int REQ_BACKUP_EXPORT = 5;
    private static final int REQ_BACKUP_IMPORT = 6;
    private static final int REQ_SKIN_IMPORT = 7;
    private static final int REQ_STICKER = 8;

    private int skinStylePref() {
        return getPreferences(MODE_PRIVATE).getInt("skin_style", ControlsView.STYLE_CLASSIC);
    }

    private int skinColorPref() {
        return getPreferences(MODE_PRIVATE).getInt("skin_color", 0);
    }

    /** Pushes the skin prefs into the controls and the stage around the game. */
    private void applySkin() {
        int style = skinStylePref();
        SkinTheme theme = SkinTheme.byIndex(skinColorPref());
        if (controls != null) {
            controls.setSkin(style, theme);
        }
        if (screenArea != null) {
            screenArea.setSkin(style == ControlsView.STYLE_HANDHELD, theme);
        }
        positionMenuButton();
        applyFullSkin();
    }

    /** Skin picker: shell style plus body color. */
    private void showSkinDialog() {
        ScrollView scroll = new ScrollView(this);
        LinearLayout box = new LinearLayout(this);
        box.setOrientation(LinearLayout.VERTICAL);
        int pad = dp(16);
        box.setPadding(pad, pad, pad, pad);
        scroll.addView(box);
        AlertDialog[] holder = new AlertDialog[1];
        TextView styleLabel = new TextView(this);
        styleLabel.setText(R.string.skin_style);
        styleLabel.setTextColor(0xFF222222);
        box.addView(styleLabel);
        final int[] stylePick = {skinStylePref()};
        RadioGroup styleGroup = new RadioGroup(this);
        RadioButton classic = new RadioButton(this);
        classic.setId(View.generateViewId());
        classic.setText(R.string.skin_style_classic);
        RadioButton handheld = new RadioButton(this);
        handheld.setId(View.generateViewId());
        handheld.setText(R.string.skin_style_handheld);
        classic.setTag(ControlsView.STYLE_CLASSIC);
        handheld.setTag(ControlsView.STYLE_HANDHELD);
        styleGroup.addView(classic);
        styleGroup.addView(handheld);
        styleGroup.setOnCheckedChangeListener((group, id) -> {
            RadioButton pick = group.findViewById(id);
            if (pick != null && pick.getTag() instanceof Integer) {
                stylePick[0] = (Integer) pick.getTag();
            }
        });
        // Select through the group so it owns the exclusive state and clears the
        // previously checked dot, instead of leaving two dots lit at once.
        styleGroup.check(stylePick[0] == ControlsView.STYLE_CLASSIC ? classic.getId() : handheld.getId());
        box.addView(styleGroup);
        TextView colorLabel = new TextView(this);
        colorLabel.setText(R.string.skin_color);
        colorLabel.setTextColor(0xFF222222);
        colorLabel.setPadding(0, dp(12), 0, 0);
        box.addView(colorLabel);
        final int[] colorPick = {skinColorPref()};
        RadioGroup colorGroup = new RadioGroup(this);
        int defaultColorId = View.NO_ID;
        for (int i = 0; i < SkinTheme.ALL.length; i++) {
            RadioButton choice = new RadioButton(this);
            choice.setId(View.generateViewId());
            choice.setText(SkinTheme.ALL[i].name);
            choice.setTag(i);
            colorGroup.addView(choice);
            if (i == colorPick[0]) {
                defaultColorId = choice.getId();
            }
        }
        colorGroup.setOnCheckedChangeListener((group, id) -> {
            RadioButton pick = group.findViewById(id);
            if (pick != null && pick.getTag() instanceof Integer) {
                colorPick[0] = (Integer) pick.getTag();
            }
        });
        // Select through the group so the old selection dot is cleared.
        if (defaultColorId != View.NO_ID) {
            colorGroup.check(defaultColorId);
        }
        box.addView(colorGroup);

        // == Full PNG skin pack ==
        TextView skinPackLabel = new TextView(this);
        skinPackLabel.setText(R.string.full_skin);
        skinPackLabel.setTextColor(0xFF222222);
        skinPackLabel.setPadding(0, dp(12), 0, 0);
        box.addView(skinPackLabel);
        List<String> packs = skinStore.list();
        String currentPack = getPreferences(MODE_PRIVATE).getString("full_skin", null);
        RadioGroup packGroup = new RadioGroup(this);
        final String[] packPick = {currentPack};
        int defaultPackId = View.NO_ID;
        RadioButton none = new RadioButton(this);
        none.setId(View.generateViewId());
        none.setText(R.string.full_skin_none);
        none.setTag(null);
        packGroup.addView(none);
        if (currentPack == null) {
            defaultPackId = none.getId();
        }
        for (String pack : packs) {
            RadioButton choice = new RadioButton(this);
            choice.setId(View.generateViewId());
            choice.setText(pack);
            choice.setTag(pack);
            packGroup.addView(choice);
            if (pack.equals(currentPack)) {
                defaultPackId = choice.getId();
            }
        }
        packGroup.setOnCheckedChangeListener((group, id) -> {
            RadioButton pick = group.findViewById(id);
            packPick[0] = pick == null ? null : (String) pick.getTag();
        });
        // Select through the group so the old selection dot is cleared.
        if (defaultPackId != View.NO_ID) {
            packGroup.check(defaultPackId);
        }
        box.addView(packGroup);
        Button importPack = new Button(this);
        importPack.setAllCaps(false);
        importPack.setText(R.string.full_skin_import);
        importPack.setOnClickListener(v -> {
            Intent intent = new Intent(Intent.ACTION_OPEN_DOCUMENT);
            intent.addCategory(Intent.CATEGORY_OPENABLE);
            intent.setType("application/zip");
            launchPicker(intent, REQ_SKIN_IMPORT);
        });
        box.addView(importPack);
        Button scanPack = new Button(this);
        scanPack.setAllCaps(false);
        scanPack.setText(R.string.full_skin_scan);
        scanPack.setOnClickListener(v -> {
            scanSkinsFromFolder(holder);
        });
        box.addView(scanPack);
        Button deletePack = new Button(this);
        deletePack.setAllCaps(false);
        deletePack.setText(R.string.full_skin_delete);
        deletePack.setOnClickListener(v -> {
            if (packPick[0] == null) {
                return;
            }
            skinStore.delete(packPick[0]);
            if (packPick[0].equals(getPreferences(MODE_PRIVATE).getString("full_skin", null))) {
                getPreferences(MODE_PRIVATE).edit().remove("full_skin").apply();
                applyFullSkin();
            }
            toast(getString(R.string.full_skin_deleted));
            packGroup.removeView(packGroup.findViewWithTag(packPick[0]));
            packPick[0] = null;
            none.setChecked(true);
        });
        box.addView(deletePack);
        TextView packHelp = new TextView(this);
        packHelp.setText(R.string.full_skin_help);
        packHelp.setTextColor(0xFF888888);
        packHelp.setTextSize(11);
        box.addView(packHelp);

        // == Stickers ==
        TextView stickerLabel = new TextView(this);
        stickerLabel.setText(R.string.sticker_add);
        stickerLabel.setTextColor(0xFF222222);
        stickerLabel.setPadding(0, dp(12), 0, 0);
        box.addView(stickerLabel);
        CheckBox stickerEdit = check(R.string.sticker_edit, stickerOverlay.isEditing());
        stickerEdit.setOnCheckedChangeListener((v, checked) -> stickerOverlay.setEditing(checked));
        Button addSticker = new Button(this);
        addSticker.setAllCaps(false);
        addSticker.setText(R.string.sticker_add);
        addSticker.setOnClickListener(v -> {
            Intent intent = new Intent(Intent.ACTION_OPEN_DOCUMENT);
            intent.addCategory(Intent.CATEGORY_OPENABLE);
            intent.setType("image/*");
            launchPicker(intent, REQ_STICKER);
        });
        Button folderSticker = new Button(this);
        folderSticker.setAllCaps(false);
        folderSticker.setText(R.string.sticker_from_folder);
        folderSticker.setOnClickListener(v -> showFolderStickerPicker());
        Button clearStickers = new Button(this);
        clearStickers.setAllCaps(false);
        clearStickers.setText(R.string.sticker_clear);
        clearStickers.setOnClickListener(v -> {
            stickerOverlay.clear();
            persistStickers();
            toast(getString(R.string.sticker_cleared));
        });
        box.addView(stickerEdit);
        box.addView(addSticker);
        box.addView(folderSticker);
        box.addView(clearStickers);

        AlertDialog dialog = new AlertDialog.Builder(this)
                .setTitle(R.string.skin_title)
                .setView(scroll)
                .setPositiveButton(android.R.string.ok, (d, w) -> {
                    getPreferences(MODE_PRIVATE).edit()
                            .putInt("skin_style", stylePick[0])
                            .putInt("skin_color", colorPick[0])
                            .putString("full_skin", packPick[0])
                            .apply();
                    applySkin();
                    applyFullSkin();
                    toast(getString(R.string.skin_done, SkinTheme.byIndex(colorPick[0]).name));
                })
                .setNegativeButton(android.R.string.cancel, null)
                .create();
        holder[0] = dialog;
        dialog.show();
    }

    /** "1 分钟" for the 60-second step, "N 秒" otherwise. */
    private String rewindLabel(int seconds) {
        if (seconds == 60) {
            return getString(R.string.rewind_minute);
        }
        return getString(R.string.rewind_seconds, seconds);
    }

    /** Seconds the one-tap rewind key jumps back (1..10, default 2). */
    private int rewindTapSeconds() {
        int seconds = 2;
        try {
            seconds = getPreferences(MODE_PRIVATE).getInt("rewind_tap_seconds", 2);
        } catch (ClassCastException ignored) {
            // A restored backup may have stored a different type under the key.
        }
        return Math.max(1, Math.min(10, seconds));
    }

    /** Only the extra "quick rewind" key lands here: one tap jumps back
     * without opening the menu. The original rewind button/bar are untouched. */
    private void quickRewind() {
        if (core == null || !core.isLoaded()) {
            toast(getString(R.string.no_rom));
            return;
        }
        rewindSeconds = rewindTapSeconds();
        command.set(CMD_REWIND);
        wakeInput();
    }

    /** Retro-style rewind bar: jump back 1min/45/30/15/12/9/6/3 seconds, or
     * hold to keep rewinding. Uses the differential-state history the core
     * records. */
    private void buildRewindBar() {
        rewindBar = findViewById(R.id.rewind_bar);
        if (rewindBar == null) {
            return;
        }
        LinearLayout row = findViewById(R.id.rewind_row);
        row.removeAllViews();
        TextView label = new TextView(this);
        label.setText(R.string.rewind_pick);
        label.setTextColor(Color.WHITE);
        label.setPadding(dp(8), 0, dp(4), 0);
        row.addView(label);
        int[] steps = {60, 45, 30, 15, 12, 9, 6, 3};
        for (int seconds : steps) {
            Button button = new Button(this);
            button.setAllCaps(false);
            button.setMinWidth(dp(44));
            button.setMinHeight(dp(36));
            button.setMinimumWidth(dp(44));
            button.setMinimumHeight(dp(36));
            button.setTextSize(14);
            button.setText(rewindLabel(seconds));
            button.setOnClickListener(v -> {
                rewindSeconds = seconds;
                command.set(CMD_REWIND);
                wakeInput();
            });
            row.addView(button);
        }
        HoldRewindButton hold = new HoldRewindButton(this);
        hold.setMinWidth(dp(64));
        hold.setMinHeight(dp(36));
        hold.setMinimumWidth(dp(64));
        hold.setMinimumHeight(dp(36));
        hold.setTextSize(14);
        hold.setText(R.string.rewind_hold);
        row.addView(hold);
    }

    /** 持续倒带(按住) button: sets rewindHold for as long as the touch is
     * down. Touch handling lives in onTouchEvent because watchMenuTouches()
     * overwrites OnTouchListeners under menu_bar after the bar is built. */
    private final class HoldRewindButton extends android.widget.Button {
        HoldRewindButton(android.content.Context context) {
            super(context);
            setAllCaps(false);
        }

        @Override
        public boolean onTouchEvent(MotionEvent event) {
            switch (event.getActionMasked()) {
                case MotionEvent.ACTION_DOWN:
                    rewindHold = true;
                    wakeInput();
                    setPressed(true);
                    return true;
                case MotionEvent.ACTION_MOVE:
                    // A long hold outlives MENU_HIDE_MS; keep the bar up while
                    // the finger stays down.
                    autoHideMenu();
                    return true;
                case MotionEvent.ACTION_UP:
                case MotionEvent.ACTION_CANCEL:
                    rewindHold = false;
                    setPressed(false);
                    return true;
                default:
                    return super.onTouchEvent(event);
            }
        }
    }

    /** The shell switch: fast-forward stays on until switched off. */
    private void toggleFastForward() {
        ffOn = !ffOn;
        controls.setFastForwardOn(ffOn);
        refreshSpeedButtons();
        toast(ffOn ? getString(R.string.ff_on, speedLabel(fastHoldSpeed()))
                : getString(R.string.ff_off));
    }

    private void toggleMute() {
        muted = !muted;
        getPreferences(MODE_PRIVATE).edit().putBoolean("muted", muted).apply();
        controls.setMuted(muted);
        toast(muted ? getString(R.string.muted_on) : getString(R.string.muted_off));
    }

    /** Rom library: scan results with favorites pinned on top. */
    private void showRomLibrary() {
        toast(getString(R.string.scan_scanning));
        new Thread(() -> {
            List<File> found = scanRoms();
            runOnUiThread(() -> showRomLibraryList(found));
        }, "rom-library").start();
    }

    private Set<String> favoriteRoms() {
        Set<String> out = new HashSet<>();
        String csv = getPreferences(MODE_PRIVATE).getString("rom_favs", "");
        if (csv != null && !csv.isEmpty()) {
            Collections.addAll(out, csv.split("\n"));
        }
        return out;
    }

    private void showRomLibraryList(List<File> found) {
        if (isFinishing()) {
            return;
        }
        LinearLayout list = new LinearLayout(this);
        list.setOrientation(LinearLayout.VERTICAL);
        int pad = dp(8);
        list.setPadding(pad, pad, pad, pad);
        ScrollView scroll = new ScrollView(this);
        scroll.addView(list);
        AlertDialog[] holder = new AlertDialog[1];
        if (found.isEmpty()) {
            TextView empty = new TextView(this);
            empty.setText(R.string.library_empty);
            empty.setPadding(0, pad, 0, pad);
            list.addView(empty);
        }
        Set<String> favs = favoriteRoms();
        String last = getPreferences(MODE_PRIVATE).getString("lastRom", null);
        // Favorites first, then the rest; the last played game tops the list.
        List<File> ordered = new ArrayList<>();
        if (last != null && new File(last).isFile()) {
            ordered.add(new File(last));
        }
        for (File file : found) {
            if (favs.contains(file.getAbsolutePath())) {
                ordered.add(file);
            }
        }
        for (File file : found) {
            if (!ordered.contains(file)) {
                ordered.add(file);
            }
        }
        for (File file : ordered) {
            list.addView(libraryRow(holder, file, favs.contains(file.getAbsolutePath()),
                    file.getAbsolutePath().equals(last)));
        }
        AlertDialog dialog = new AlertDialog.Builder(this)
                .setTitle(R.string.library_title)
                .setView(scroll)
                .setPositiveButton(R.string.library_scan, (d, w) -> showRomScan())
                .setNeutralButton(R.string.rom_dirs_menu, (d, w) -> showRomDirsDialog())
                .setNegativeButton(R.string.library_open, (d, w) -> openDocument(REQ_ROM))
                .create();
        holder[0] = dialog;
        dialog.show();
    }

    private View libraryRow(AlertDialog[] holder, File file, boolean favorite, boolean isLast) {
        LinearLayout row = new LinearLayout(this);
        row.setOrientation(LinearLayout.HORIZONTAL);
        row.setGravity(Gravity.CENTER_VERTICAL);
        int pad = dp(6);
        row.setPadding(pad, pad, pad, pad);
        LinearLayout column = new LinearLayout(this);
        column.setOrientation(LinearLayout.VERTICAL);
        TextView name = new TextView(this);
        String label = file.getName() + (isLast ? "　" + getString(R.string.library_last) : "")
                + (hasBesideSaves(file) ? getString(R.string.scan_has_save) : "");
        name.setText((favorite ? "★ " : "○ ") + label);
        name.setTextColor(0xFF222222);
        name.setTextSize(15);
        name.setSingleLine(true);
        TextView path = new TextView(this);
        path.setText(file.getParent());
        path.setTextColor(0xFF888888);
        path.setTextSize(11);
        path.setSingleLine(true);
        column.addView(name);
        column.addView(path);
        row.addView(column, new LinearLayout.LayoutParams(0, LinearLayout.LayoutParams.WRAP_CONTENT, 1f));
        row.setOnClickListener(v -> {
            openFoundRom(file);
            if (holder[0] != null) {
                holder[0].dismiss();
            }
        });
        row.setOnLongClickListener(v -> {
            Set<String> favs = favoriteRoms();
            String key = file.getAbsolutePath();
            if (favs.contains(key)) {
                favs.remove(key);
                toast(getString(R.string.library_fav_off));
            } else {
                favs.add(key);
                toast(getString(R.string.library_fav_on));
            }
            StringBuilder csv = new StringBuilder();
            for (String fav : favs) {
                if (csv.length() > 0) {
                    csv.append('\n');
                }
                csv.append(fav);
            }
            getPreferences(MODE_PRIVATE).edit().putString("rom_favs", csv.toString()).apply();
            return true;
        });
        return row;
    }

    /** Per-game overrides, keyed by the ROM's CRC32. */
    private void showPerRomDialog() {
        if (core == null || !core.isLoaded() || romCrc < 0) {
            toast(getString(R.string.no_rom));
            return;
        }
        ScrollView scroll = new ScrollView(this);
        LinearLayout box = new LinearLayout(this);
        box.setOrientation(LinearLayout.VERTICAL);
        int pad = dp(16);
        box.setPadding(pad, pad, pad, pad);
        scroll.addView(box);
        final long crc = romCrc;
        final Button filter = new Button(this);
        filter.setAllCaps(false);
        String filterValue = romDb.get(crc, "filter", RomSettingsDb.DEFAULT);
        filter.setText(getString(R.string.per_rom_filter) + ": " +
                (RomSettingsDb.DEFAULT.equals(filterValue) ? getString(R.string.per_rom_none) : filterName(Integer.parseInt(filterValue))));
        filter.setOnClickListener(v -> {
            CharSequence[] names = filterNames();
            new AlertDialog.Builder(this)
                    .setTitle(R.string.per_rom_filter)
                    .setSingleChoiceItems(names, -1, (dialog, which) -> {
                        romDb.put(crc, "filter", String.valueOf(which));
                        filter.setText(getString(R.string.per_rom_filter) + ": " + names[which]);
                        applyPerRomSettings();
                        dialog.dismiss();
                    })
                    .setNegativeButton(android.R.string.cancel, null)
                    .show();
        });
        final Button speed = new Button(this);
        speed.setAllCaps(false);
        String speedValue = romDb.get(crc, "speed", RomSettingsDb.DEFAULT);
        speed.setText(getString(R.string.per_rom_speed) + ": " +
                (RomSettingsDb.DEFAULT.equals(speedValue) ? getString(R.string.per_rom_none) : speedValue + "×"));
        speed.setOnClickListener(v -> {
            EditText input = new EditText(this);
            input.setInputType(InputType.TYPE_CLASS_NUMBER | InputType.TYPE_NUMBER_FLAG_DECIMAL);
            input.setHint(R.string.speed_custom_hint);
            LinearLayout inner = new LinearLayout(this);
            inner.setOrientation(LinearLayout.VERTICAL);
            inner.setPadding(pad, pad, pad, 0);
            inner.addView(input);
            new AlertDialog.Builder(this)
                    .setTitle(R.string.per_rom_speed)
                    .setView(inner)
                    .setPositiveButton(android.R.string.ok, (d, w) -> {
                        try {
                            float value = Float.parseFloat(input.getText().toString().trim());
                            value = Math.max(0.05f, Math.min(16f, value));
                            romDb.put(crc, "speed", String.valueOf(value));
                            speed.setText(getString(R.string.per_rom_speed) + ": " + speedLabel(value) + "×");
                            applyPerRomSettings();
                        } catch (NumberFormatException ignored) {
                            toast(getString(R.string.speed_bad_value));
                        }
                    })
                    .setNeutralButton(R.string.per_rom_none, (d, w) -> {
                        romDb.put(crc, "speed", RomSettingsDb.DEFAULT);
                        speed.setText(getString(R.string.per_rom_speed) + ": " + getString(R.string.per_rom_none));
                        applyPerRomSettings();
                    })
                    .setNegativeButton(android.R.string.cancel, null)
                    .show();
        });
        final Button saveType = new Button(this);
        saveType.setAllCaps(false);
        String saveValue = romDb.get(crc, "save_type", RomSettingsDb.DEFAULT);
        saveType.setText(getString(R.string.per_rom_save_type) + ": " +
                (RomSettingsDb.DEFAULT.equals(saveValue) ? getString(R.string.per_rom_none) : saveTypeName(Integer.parseInt(saveValue))));
        saveType.setOnClickListener(v -> new AlertDialog.Builder(this)
                .setTitle(R.string.per_rom_save_type)
                .setSingleChoiceItems(new CharSequence[] {
                        saveTypeName(-1), saveTypeName(0), saveTypeName(1), saveTypeName(2),
                        saveTypeName(3), saveTypeName(4), saveTypeName(5), saveTypeName(6)
                }, -1, (dialog, which) -> {
                    int[] values = {-1, 0, 1, 2, 3, 4, 5, 6};
                    romDb.put(crc, "save_type", String.valueOf(values[which]));
                    saveType.setText(getString(R.string.per_rom_save_type) + ": " + saveTypeName(values[which]));
                    applyPerRomSettings();
                    dialog.dismiss();
                })
                .setNegativeButton(android.R.string.cancel, null)
                .show());
        final Button palette = new Button(this);
        palette.setAllCaps(false);
        String palValue = romDb.get(crc, "gb_palette", RomSettingsDb.DEFAULT);
        palette.setText(getString(R.string.per_rom_palette) + ": " +
                (RomSettingsDb.DEFAULT.equals(palValue) ? getString(R.string.per_rom_none) : paletteName(Integer.parseInt(palValue))));
        palette.setOnClickListener(v -> new AlertDialog.Builder(this)
                .setTitle(R.string.per_rom_palette)
                .setSingleChoiceItems(paletteNames(), -1, (dialog, which) -> {
                    romDb.put(crc, "gb_palette", String.valueOf(which));
                    palette.setText(getString(R.string.per_rom_palette) + ": " + paletteNames()[which]);
                    applyPerRomSettings();
                    dialog.dismiss();
                })
                .setNegativeButton(android.R.string.cancel, null)
                .show());
        Button reset = new Button(this);
        reset.setAllCaps(false);
        reset.setText(R.string.per_rom_reset);
        reset.setOnClickListener(v -> {
            romDb.clear(crc);
            applyPerRomSettings();
            toast(getString(R.string.per_rom_saved));
        });
        box.addView(filter);
        box.addView(speed);
        box.addView(saveType);
        box.addView(palette);
        box.addView(reset);
        new AlertDialog.Builder(this)
                .setTitle(R.string.per_rom_title)
                .setView(scroll)
                .setPositiveButton(android.R.string.ok, (d, w) -> toast(getString(R.string.per_rom_saved)))
                .show();
    }

    /** Backup hub: export everything to a zip, restore from one. */
    private void showBackupDialog() {
        new AlertDialog.Builder(this)
                .setTitle(R.string.backup_title)
                .setItems(new CharSequence[]{
                        getString(R.string.backup_export),
                        getString(R.string.backup_import),
                }, (dialog, which) -> {
                    if (which == 0) {
                        Intent intent = new Intent(Intent.ACTION_CREATE_DOCUMENT);
                        intent.addCategory(Intent.CATEGORY_OPENABLE);
                        intent.setType("application/zip");
                        intent.putExtra(Intent.EXTRA_TITLE, "mGBAx-backup-"
                                + DateFormat.format("yyyyMMdd-HHmm", System.currentTimeMillis()) + ".zip");
                        launchPicker(intent, REQ_BACKUP_EXPORT);
                    } else {
                        Intent intent = new Intent(Intent.ACTION_OPEN_DOCUMENT);
                        intent.addCategory(Intent.CATEGORY_OPENABLE);
                        intent.setType("*/*");
                        launchPicker(intent, REQ_BACKUP_IMPORT);
                    }
                })
                .show();
    }

    /** Periodic silent save into the auto slot while a game runs. */
    private void startTimedSave() {
        stopTimedSave();
        int minutes = 0;
        try {
            minutes = getPreferences(MODE_PRIVATE).getInt("timed_save_min", 0);
        } catch (ClassCastException ignored) {
        }
        if (minutes <= 0) {
            return;
        }
        timedSavePool = Executors.newSingleThreadScheduledExecutor();
        timedSavePool.scheduleWithFixedDelay(() -> {
            if (running && core != null && core.isLoaded() && !paused) {
                recyclePendingPreview();
                pendingPreview.set(gameView.copyLast());
                command.set(CMD_AUTOSAVE);
            }
        }, minutes, minutes, TimeUnit.MINUTES);
    }

    private void stopTimedSave() {
        if (timedSavePool != null) {
            timedSavePool.shutdownNow();
            timedSavePool = null;
        }
    }

    /** C/C2 macro configuration: the combination held while the key is down. */
    private void showMacroDialog(int which) {
        Set<String> current = new HashSet<>();
        int mask = controls.getMacro(which);
        if ((mask & ControlsView.A) != 0) {
            current.add("A");
        }
        if ((mask & ControlsView.B) != 0) {
            current.add("B");
        }
        if ((mask & ControlsView.L) != 0) {
            current.add("L");
        }
        if ((mask & ControlsView.R) != 0) {
            current.add("R");
        }
        if ((mask & ControlsView.SELECT) != 0) {
            current.add("SELECT");
        }
        if ((mask & ControlsView.START) != 0) {
            current.add("START");
        }
        if ((mask & ControlsView.UP) != 0) {
            current.add("UP");
        }
        if ((mask & ControlsView.DOWN) != 0) {
            current.add("DOWN");
        }
        if ((mask & ControlsView.LEFT) != 0) {
            current.add("LEFT");
        }
        if ((mask & ControlsView.RIGHT) != 0) {
            current.add("RIGHT");
        }
        String[] names = {"A", "B", "L", "R", "SELECT", "START", "UP", "DOWN", "LEFT", "RIGHT"};
        int[] bits = {ControlsView.A, ControlsView.B, ControlsView.L, ControlsView.R,
                ControlsView.SELECT, ControlsView.START, ControlsView.UP, ControlsView.DOWN,
                ControlsView.LEFT, ControlsView.RIGHT};
        boolean[] checked = new boolean[names.length];
        for (int i = 0; i < names.length; i++) {
            checked[i] = current.contains(names[i]);
        }
        new AlertDialog.Builder(this)
                .setTitle(which == 0 ? R.string.c_button : R.string.c2_button)
                .setMessage(R.string.macro_hint)
                .setMultiChoiceItems(names, checked, (dialog, index, isChecked) -> {
                    if (isChecked) {
                        current.add(names[index]);
                    } else {
                        current.remove(names[index]);
                    }
                    int next = 0;
                    for (int i = 0; i < names.length; i++) {
                        if (current.contains(names[i])) {
                            next |= bits[i];
                        }
                    }
                    controls.setMacro(which, next);
                })
                .setPositiveButton(android.R.string.ok, (d, w) -> {
                    String key = which == 0 ? "c_macro" : "c2_macro";
                    getPreferences(MODE_PRIVATE).edit().putInt(key, controls.getMacro(which)).apply();
                })
                .show();
    }

    /** A ROM inside a zip: extracts the first game entry to a temp file. */
    @Nullable
    private String extractRomZip(File zip) {        File destDir = new File(getFilesDir(), "roms/unpacked");
        destDir.mkdirs();
        try (java.util.zip.ZipInputStream stream = new java.util.zip.ZipInputStream(
                new java.io.FileInputStream(zip))) {
            java.util.zip.ZipEntry entry;
            byte[] buffer = new byte[65536];
            while ((entry = stream.getNextEntry()) != null) {
                if (entry.isDirectory()) {
                    continue;
                }
                String name = new File(entry.getName()).getName();
                if (!isRomFile(name)) {
                    continue;
                }
                File dest = new File(destDir, name);
                try (OutputStream out = new FileOutputStream(dest)) {
                    int n;
                    while ((n = stream.read(buffer)) > 0) {
                        out.write(buffer, 0, n);
                    }
                }
                return dest.getAbsolutePath();
            }
        } catch (Exception e) {
            Log.w(TAG, "zip rom extract failed", e);
        }
        return null;
    }

    // == Stickers ==

    private void bindStickerOverlay() {
        stickerOverlay.setListener(new StickerOverlay.Listener() {
            @Override
            public void onStickersChanged(List<StickerOverlay.Sticker> stickers) {
                persistStickers();
            }
        });
        loadStickers();
    }

    private String orientationPrefix() {
        return getResources().getConfiguration().orientation == Configuration.ORIENTATION_PORTRAIT
                ? "ver_" : "hor_";
    }

    /** Loads this orientation's stickers from the preferences. */
    private void loadStickers() {
        stickerPrefix = orientationPrefix();
        List<StickerOverlay.Sticker> list = new ArrayList<>();
        for (int i = 0; i < StickerOverlay.MAX_STICKERS; i++) {
            String path = getPreferences(MODE_PRIVATE).getString(stickerPrefix + "sticker" + i + "_path", null);
            if (path == null || !new File(path).isFile()) {
                continue;
            }
            StickerOverlay.Sticker sticker = new StickerOverlay.Sticker();
            sticker.path = path;
            sticker.x = getPreferences(MODE_PRIVATE).getFloat(stickerPrefix + "sticker" + i + "_x", 0.5f);
            sticker.y = getPreferences(MODE_PRIVATE).getFloat(stickerPrefix + "sticker" + i + "_y", 0.4f);
            sticker.w = getPreferences(MODE_PRIVATE).getFloat(stickerPrefix + "sticker" + i + "_w", 0.3f);
            sticker.alpha = getPreferences(MODE_PRIVATE).getInt(stickerPrefix + "sticker" + i + "_alpha", 255);
            list.add(sticker);
        }
        stickerOverlay.setStickers(list);
    }

    /** Writes this orientation's stickers back to the preferences. */
    private void persistStickers() {
        String prefix = orientationPrefix();
        SharedPreferences.Editor editor = getPreferences(MODE_PRIVATE).edit();
        for (int i = 0; i < StickerOverlay.MAX_STICKERS; i++) {
            String base = prefix + "sticker" + i + "_";
            editor.remove(base + "path");
            editor.remove(base + "x");
            editor.remove(base + "y");
            editor.remove(base + "w");
            editor.remove(base + "alpha");
        }
        for (int i = 0; i < stickerOverlay.stickers().size() && i < StickerOverlay.MAX_STICKERS; i++) {
            StickerOverlay.Sticker sticker = stickerOverlay.stickers().get(i);
            String base = prefix + "sticker" + i + "_";
            editor.putString(base + "path", sticker.path);
            editor.putFloat(base + "x", sticker.x);
            editor.putFloat(base + "y", sticker.y);
            editor.putFloat(base + "w", sticker.w);
            editor.putInt(base + "alpha", sticker.alpha);
        }
        editor.apply();
    }

    // == Full PNG skin ==

    /** Pushes the active full skin pack into the controls and the stage. */
    private void applyFullSkin() {
        activeSkinName = getPreferences(MODE_PRIVATE).getString("full_skin", null);
        if (activeSkinName != null && !skinStore.list().contains(activeSkinName)) {
            activeSkinName = null;
            getPreferences(MODE_PRIVATE).edit().remove("full_skin").apply();
        }
        Map<String, Bitmap> bitmaps = activeSkinName == null ? null : skinStore.load(activeSkinName);
        if (controls != null) {
            controls.setFullSkin(bitmaps);
        }
        if (screenArea != null) {
            Bitmap bg = null;
            if (bitmaps != null) {
                boolean portrait = getResources().getConfiguration().orientation
                        == Configuration.ORIENTATION_PORTRAIT;
                bg = bitmaps.get(portrait ? "bg_portrait" : "bg_landscape");
            }
            screenArea.setSkinBackground(bg);
        }
    }

    // == AI translate ==

    private void showTranslateDialog() {
        String key = getPreferences(MODE_PRIVATE).getString("ai_key", "");
        if (key == null || key.trim().isEmpty()) {
            LinearLayout box = new LinearLayout(this);
            box.setOrientation(LinearLayout.VERTICAL);
            int pad = dp(16);
            box.setPadding(pad, pad, pad, 0);
            TextView hint = new TextView(this);
            hint.setText(R.string.ai_key_hint);
            hint.setTextColor(0xFF222222);
            hint.setTextSize(12);
            EditText input = new EditText(this);
            input.setHint(R.string.ai_key);
            input.setSingleLine(true);
            box.addView(hint);
            box.addView(input);
            new AlertDialog.Builder(this)
                    .setTitle(R.string.translate)
                    .setView(box)
                    .setPositiveButton(android.R.string.ok, (d, w) ->
                            getPreferences(MODE_PRIVATE).edit()
                                    .putString("ai_key", input.getText().toString().trim())
                                    .apply())
                    .setNegativeButton(android.R.string.cancel, null)
                    .show();
            return;
        }
        if (core == null || !core.isLoaded()) {
            toast(getString(R.string.no_rom));
            return;
        }
        toast(getString(R.string.ai_working));
        Bitmap frame = gameView.copyLast();
        if (frame == null) {
            frame = aiFrame;
        }
        final Bitmap send = frame == null ? null : AiTranslate.snapshot(frame, 960);
        if (send == null) {
            toast(getString(R.string.ai_failed, "no frame"));
            return;
        }
        aiFrame = send;
        AiTranslate.translate(send, key, getPreferences(MODE_PRIVATE).getString("ai_lang", "简体中文"),
                (blocks, error) -> runOnUiThread(() -> {
                    if (error != null) {
                        toast(getString(R.string.ai_failed, error));
                        return;
                    }
                    if (blocks == null || blocks.isEmpty()) {
                        toast(getString(R.string.ai_no_text));
                        return;
                    }
                    aiOverlay.show(blocks, aiFrame);
                    toast(getString(R.string.ai_ok, blocks.size()));
                }));
    }

    private void applyOrientation() {
        applyOrientation(getPreferences(MODE_PRIVATE).getString("orientation", "landscape"));
    }

    private void applyOrientation(String mode) {
        switch (mode) {
            case "portrait":
                setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_SENSOR_PORTRAIT);
                break;
            case "portrait_rev":
                setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_REVERSE_PORTRAIT);
                break;
            case "landscape_rev":
                setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_REVERSE_LANDSCAPE);
                break;
            case "auto":
                setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_FULL_SENSOR);
                break;
            case "system":
                setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_UNSPECIFIED);
                break;
            default:
                setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_SENSOR_LANDSCAPE);
                break;
        }
    }

    /** Orientation changes are handled in place, so rearrange the chrome here. */
    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        applyScreenMode();
        // The picture rect is re-measured for the new orientation; re-apply
        // the scene transform once the view has its new size.
        gameView.post(this::applyVideoScene);
    }

    /**
     * Portrait becomes a DS-like pair of screens: the game on the upper screen,
     * the keys and the menu below. Landscape keeps the classic full-screen
     * overlay with the menu bar on top.
     *
     * <p>The menu bar and the key editor float over the stage instead of
     * taking part in its layout, so showing either one never rescales the
     * game. That keeps the keys in the same place relative to the picture
     * while they are being adjusted.
     */
    private void applyScreenMode() {
        if (screenArea == null) {
            return;
        }
        boolean portrait = getResources().getConfiguration().orientation
                == Configuration.ORIENTATION_PORTRAIT;
        boolean switched = screenArea.isPortraitMode() != portrait;
        screenArea.setPortraitMode(portrait);
        if (controls != null) {
            controls.setPortrait(portrait);
        }
        if (switched && keyLayout != null) {
            // Each orientation keeps its own stored key layout.
            keyLayout = KeyLayout.decode(profileLayout(layoutProfile));
            controls.setCenters(keyLayout.resolved());
            controls.setScales(keyLayout.resolvedScales());
        }
        if (switched) {
            // Stickers and skin backgrounds are stored per orientation too.
            loadStickers();
            applyFullSkin();
        }
        if (menuBar == null) {
            return;
        }
        ViewGroup.LayoutParams params = menuBar.getLayoutParams();
        if (params instanceof FrameLayout.LayoutParams) {
            FrameLayout.LayoutParams lp = (FrameLayout.LayoutParams) params;
            int gravity = portrait
                    ? (Gravity.BOTTOM | Gravity.START)
                    : (Gravity.TOP | Gravity.START);
            if (lp.gravity != gravity) {
                lp.gravity = gravity;
                menuBar.setLayoutParams(lp);
            }
        }
        // In landscape the shoulder keys sit in the top corners. Inset the
        // floating key editor so it no longer covers L/R while they are being
        // dragged. The margin also follows an in-place rotation.
        View editor = findViewById(R.id.layout_editor);
        if (editor != null && editor.getLayoutParams() instanceof FrameLayout.LayoutParams) {
            FrameLayout.LayoutParams lp = (FrameLayout.LayoutParams) editor.getLayoutParams();
            int side = getResources().getDimensionPixelSize(R.dimen.layout_editor_side_margin);
            if (lp.leftMargin != side || lp.rightMargin != side) {
                lp.leftMargin = side;
                lp.rightMargin = side;
                editor.setLayoutParams(lp);
            }
        }
        positionMenuButton();
    }

    private void setPaused(boolean value) {
        paused = value;
        pauseButton.setText(value ? R.string.resume : R.string.pause);
        // Resuming is left to the audio pump, which restarts playback once the
        // buffer has been refilled.
        if (value && audio != null) {
            audio.pause();
            audioStarted = false;
        }
    }

    private void toast(String message) {
        runOnUiThread(() -> Toast.makeText(this, message, Toast.LENGTH_SHORT).show());
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        // While the solar sensor is on, the volume keys become sunlight
        // controls (Boktai), the way cartridge sensors were adjusted on real
        // hardware accessories.
        if (event.getRepeatCount() == 0 && nudgeSolar(keyCode == KeyEvent.KEYCODE_VOLUME_UP ? 1 : keyCode == KeyEvent.KEYCODE_VOLUME_DOWN ? -1 : 0)) {
            return true;
        }
        if (keyCode == KeyEvent.KEYCODE_TAB || keyCode == KeyEvent.KEYCODE_SPACE || keyCode == KeyEvent.KEYCODE_BUTTON_THUMBR) {
            fastHold = true;
            return true;
        }
        int bit = mapKey(keyCode);
        if (bit == 0) {
            return super.onKeyDown(keyCode, event);
        }
        int prev = hwKeys;
        hwKeys |= bit;
        noteUserKeys(touchKeys, prev);
        if ((bit & ~prev) != 0) {
            wakeInput();
            maybeOfferKeypadHide();
        }
        return true;
    }

    @Override
    public boolean onKeyUp(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_VOLUME_UP || keyCode == KeyEvent.KEYCODE_VOLUME_DOWN) {
            if (solarEnabled()) {
                return true;
            }
            return super.onKeyUp(keyCode, event);
        }
        if (keyCode == KeyEvent.KEYCODE_TAB || keyCode == KeyEvent.KEYCODE_SPACE || keyCode == KeyEvent.KEYCODE_BUTTON_THUMBR) {
            fastHold = false;
            return true;
        }
        int bit = mapKey(keyCode);
        if (bit == 0) {
            return super.onKeyUp(keyCode, event);
        }
        int prev = hwKeys;
        hwKeys &= ~bit;
        noteUserKeys(touchKeys, prev);
        return true;
    }

    private static int mapKey(int keyCode) {
        switch (keyCode) {
            case KeyEvent.KEYCODE_DPAD_UP:
            case KeyEvent.KEYCODE_W:
                return ControlsView.UP;
            case KeyEvent.KEYCODE_DPAD_DOWN:
                return ControlsView.DOWN;
            case KeyEvent.KEYCODE_DPAD_LEFT:
            case KeyEvent.KEYCODE_A:
                return keyCode == KeyEvent.KEYCODE_A ? ControlsView.L : ControlsView.LEFT;
            case KeyEvent.KEYCODE_DPAD_RIGHT:
                return ControlsView.RIGHT;
            case KeyEvent.KEYCODE_BUTTON_A:
            case KeyEvent.KEYCODE_X:
                return ControlsView.A;
            case KeyEvent.KEYCODE_BUTTON_B:
            case KeyEvent.KEYCODE_Z:
                return ControlsView.B;
            case KeyEvent.KEYCODE_BUTTON_L1:
            case KeyEvent.KEYCODE_BUTTON_L2:
                return ControlsView.L;
            case KeyEvent.KEYCODE_BUTTON_R1:
            case KeyEvent.KEYCODE_S:
            case KeyEvent.KEYCODE_BUTTON_R2:
                return ControlsView.R;
            case KeyEvent.KEYCODE_BUTTON_START:
            case KeyEvent.KEYCODE_ENTER:
                return ControlsView.START;
            case KeyEvent.KEYCODE_BUTTON_SELECT:
            case KeyEvent.KEYCODE_DEL:
            case KeyEvent.KEYCODE_SHIFT_LEFT:
            case KeyEvent.KEYCODE_SHIFT_RIGHT:
                return ControlsView.SELECT;
            default:
                return 0;
        }
    }

    @Override
    public void onWindowFocusChanged(boolean hasFocus) {
        super.onWindowFocusChanged(hasFocus);
        if (hasFocus) {
            hideSystemUi();
        } else {
            // A key-up for a held touch or the fast-forward hold can get lost
            // (window switched, gamepad disconnected); drop the holds so the
            // game cannot come back stuck with A down or at 16x speed.
            releaseInput();
        }
    }

    private void hideSystemUi() {
        if (!getPreferences(MODE_PRIVATE).getBoolean("immersive", true)) {
            View decor = getWindow().getDecorView();
            decor.setSystemUiVisibility(View.SYSTEM_UI_FLAG_LAYOUT_STABLE);
            return;
        }
        View decor = getWindow().getDecorView();
        decor.setSystemUiVisibility(View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY
                | View.SYSTEM_UI_FLAG_FULLSCREEN
                | View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
                | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                | View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
                | View.SYSTEM_UI_FLAG_LAYOUT_STABLE);
    }

    private boolean solarEnabled() {
        return core != null && core.isLoaded()
                && getPreferences(MODE_PRIVATE).getBoolean("solar_on", false);
    }

    /** Adjusts the Boktai sun level with the volume keys; false if not active. */
    private boolean nudgeSolar(int delta) {
        if (delta == 0 || !solarEnabled() || !getPreferences(MODE_PRIVATE).getBoolean("solar_volkeys", false)) {
            return false;
        }
        int level = Math.max(0, Math.min(10, getPreferences(MODE_PRIVATE).getInt("solar_level", 5) + delta));
        getPreferences(MODE_PRIVATE).edit().putInt("solar_level", level).apply();
        core.setSolar(level);
        toast(getString(R.string.adv_solar_level, level));
        return true;
    }

    @Override
    public void onBackPressed() {
        if (core != null && core.isLoaded() && getPreferences(MODE_PRIVATE).getBoolean("confirm_close", false)) {
            new AlertDialog.Builder(this)
                    .setTitle(R.string.app_name)
                    .setMessage(R.string.confirm_exit_message)
                    .setPositiveButton(android.R.string.ok, (d, w) -> super.onBackPressed())
                    .setNegativeButton(android.R.string.cancel, null)
                    .show();
            return;
        }
        super.onBackPressed();
    }

    @Override
    protected void onPause() {
        super.onPause();
        if (awaitingStorage) {
            leftForStorage = true;
        }
        paused = true;
        if (tiltListening) {
            sensorManager.unregisterListener(tiltListener);
            tiltListening = false;
        }
        if (solarListening) {
            sensorManager.unregisterListener(solarListener);
            solarListening = false;
        }
        // Do not stay held at 16x (raised pitch) or with A/B latched when the
        // key-up never arrives because the app went to the background under
        // a held key.
        releaseInput();
        if (audio != null) {
            audio.pause();
            audioStarted = false;
        }
        if (core != null && core.isLoaded()
                && getPreferences(MODE_PRIVATE).getBoolean("auto_save_state", false)) {
            // The emulator loop still drains commands while paused, so the
            // save happens on the emulation thread a moment later.
            recyclePendingPreview();
            pendingPreview.set(gameView.copyLast());
            command.set(CMD_AUTOSAVE);
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, String[] permissions, int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if (requestCode == REQ_STORAGE) {
            startEmulator();
        }
    }

    @Override
    protected void onResume() {
        super.onResume();
        if (awaitingStorage && (SaveLocation.hasAccess(this) || (leftForStorage && Build.VERSION.SDK_INT >= 30))) {
            startEmulator();
        }
        if (pauseButton.getText().toString().contentEquals(getString(R.string.pause))) {
            paused = false;
        }
        updateTiltSensor();
        updateSolarSource();
        hideSystemUi();
        autoHideMenu();
    }

    @Override
    protected void onDestroy() {
        running = false;
        stopGBoyLink();
        NoticeService.stop(this);
        if (solarListening && sensorManager != null) {
            sensorManager.unregisterListener(solarListener);
            solarListening = false;
        }
        try {
            unregisterReceiver(screenshotReceiver);
        } catch (Exception ignored) {
        }
        try {
            unregisterReceiver(keysReceiver);
        } catch (Exception ignored) {
        }
        try {
            unregisterReceiver(remoteKeysReceiver);
        } catch (Exception ignored) {
        }
        try {
            unregisterReceiver(localLinkReceiver);
        } catch (Exception ignored) {
        }
        try {
            unregisterReceiver(cloudReceiver);
        } catch (Exception ignored) {
        }
        try {
            unregisterReceiver(stateReceiver);
        } catch (Exception ignored) {
        }
        stopTimedSave();
        if (cloudLink != null) {
            cloudLink.close();
            cloudLink = null;
        }
        gboyRemoteKeys = 0;
        inputHandler.removeCallbacksAndMessages(null);
        releaseAudio();
        // Let the GIF encoder drain its queue and publish before the core and
        // the activity go away; the file is already on disk, so this is quick.
        gifRecording = false;
        if (gifThread != null) {
            try {
                gifThread.join(2500);
            } catch (InterruptedException ignored) {
            }
        }
        if (emuThread != null) {
            emuThread.interrupt();
            try {
                emuThread.join(8000);
            } catch (InterruptedException ignored) {
            }
        }
        if (emuThread == null || !emuThread.isAlive()) {
            if (core != null) {
                core.destroy();
                core = null;
            }
            if (frame != null) {
                frame.recycle();
                frame = null;
            }
        }
        super.onDestroy();
    }
}
