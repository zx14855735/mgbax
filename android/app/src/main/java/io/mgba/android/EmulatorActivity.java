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
import android.content.pm.ActivityInfo;
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
import android.text.InputType;
import android.text.format.DateFormat;
import android.view.Gravity;
import android.view.KeyEvent;
import android.view.MotionEvent;
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
import android.widget.ScrollView;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import java.io.File;
import java.io.FileOutputStream;
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
import java.util.HashSet;
import java.util.List;
import java.util.Locale;
import java.util.Set;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

public class EmulatorActivity extends AppCompatActivity {
    private static final int REQ_ROM = 1;
    private static final int REQ_BIOS = 2;
    private static final int REQ_STORAGE = 3;
    private static final int REQ_SAVDIR = 4;
    private static final int CMD_SAVE = 1;
    private static final int CMD_LOAD = 2;
    private static final int CMD_RESET = 3;
    private static final int CMD_AUTOSAVE = 4;
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
    private static final int ROM_SCAN_LIMIT = 60;
    /** How long the menu stays open after it was last used. */
    private static final int MENU_HIDE_MS = 4000;

    private MgbaCore core;
    private GameView gameView;
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
    private HorizontalScrollView speedBar;
    private final Button[] speedButtons = new Button[SPEED_TIERS.length];
    private Button speedCustom;

    private final AtomicReference<String> pendingPath = new AtomicReference<>();
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
    /** GIF recording state; the queue hands frames to the encoder thread. */
    private volatile boolean gifRecording;
    private Button gifButton;
    private java.util.concurrent.ArrayBlockingQueue<Bitmap> gifQueue;
    private Thread gifThread;
    private long lastGifAt;
    private int gifFrames;
    /** GIF capture pacing and length cap (GIF_MAX_FRAMES at ~20 fps). */
    private static final int GIF_FRAME_MS = 50;
    private static final int GIF_MAX_FRAMES = 900;

    private AudioTrack audio;
    private boolean audioMuted;
    private volatile boolean audioStarted;
    private double appliedSpeed = -1;
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
    private final short[] audioRead = new short[AUDIO_READ_FRAMES * 2];
    private final short[] audioCarry = new short[AUDIO_CARRY_FRAMES * 2];
    private int carryFrames;
    private long framesWritten;
    private int trackFrames;
    private int targetFrames;
    private AudioRateControl rateControl;
    private Bitmap frame;
    private final AtomicBoolean presentQueued = new AtomicBoolean();
    private final AtomicReference<Bitmap> pendingPreview = new AtomicReference<>();
    private int lastLinkState = -1;
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
    private EditText linkRoomView;
    private RemoteLink remoteLink;
    /** GBoy/My Boy Wi-Fi link session and the key mask it delivers. */
    private GBoyLink gboyLink;
    private volatile int gboyRemoteKeys;
    /** Tilt cartridge input: device posture fed to the core when enabled. */
    private SensorManager sensorManager;
    private boolean tiltListening;
    /** Auto frameskip state on the emulation thread. */
    private volatile boolean skipAuto;
    private int autoSkipLevel;
    private int lateStreak;

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
        setContentView(R.layout.activity_emulator);
        gameView = findViewById(R.id.game);
        hint = findViewById(R.id.hint);
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
        File saves = SaveLocation.prepare(this);
        core = new MgbaCore(saves, new File(getFilesDir(), "states"));
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
        int mask = touchKeys | hwKeys | gboyRemoteKeys;
        if (turboB) {
            mask &= ~ControlsView.B;
        }
        core.setKeys(mask);
    }

    /** Keys applied this frame: local input plus the GBoy peer's mask. */
    private int userKeys() {
        return touchKeys | hwKeys | gboyRemoteKeys;
    }

    private void noteUserKeys(int prevTouch, int prevHw) {
        boolean wasB = ((prevTouch | prevHw) & ControlsView.B) != 0;
        boolean nowB = ((touchKeys | hwKeys) & ControlsView.B) != 0;
        if (nowB && !wasB) {
            inputHandler.removeCallbacks(armTurbo);
            // Holding B only auto-turboes in the classic mode; the dedicated
            // 连发 keys have their own pulsing in ControlsView.
            if (turboModePref() == 0) {
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

    private void wakeInput() {
        if (emuThread != null) {
            emuThread.interrupt();
        }
    }

    private void openDocument(int request) {
        Intent intent = new Intent(Intent.ACTION_OPEN_DOCUMENT);
        intent.addCategory(Intent.CATEGORY_OPENABLE);
        intent.setType("*/*");
        startActivityForResult(intent, request);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        if (requestCode == REQ_STORAGE) {
            startEmulator();
            return;
        }
        if (requestCode == REQ_SAVDIR) {
            if (resultCode == RESULT_OK && data != null && data.getData() != null) {
                importMyBoySaves(data.getData());
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
        }
    }

    @Override
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        setIntent(intent);
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
            return local;
        }
        return copyTo(uri, new File(getFilesDir(), "roms"), null);
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
            labels[i] = getString(R.string.scan_entry, file.getName(), path, size);
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
        Collections.sort(found, (a, b) -> Long.compare(b.lastModified(), a.lastModified()));
        return found.size() > ROM_SCAN_LIMIT ? new ArrayList<>(found.subList(0, ROM_SCAN_LIMIT)) : found;
    }

    private static void collectRoms(File dir, int depth, List<File> out, Set<String> seen) {
        if (depth > 2 || out.size() >= ROM_SCAN_LIMIT) {
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
                    loadRom(path);
                    // Loading blocks for a while; start the pacing schedule
                    // and the feedback window fresh so the stall is not
                    // measured as this front end being slow.
                    nextSlice = System.nanoTime();
                    slices = 0;
                    fpsStamp = nextSlice;
                }
                int cmd = command.getAndSet(0);
                if (cmd != 0) {
                    runCommand(cmd);
                    nextSlice = System.nanoTime();
                    slices = 0;
                    fpsStamp = nextSlice;
                }
                if (!surfaceReady || paused || !core.isLoaded()) {
                    // Do not carry stale pacing across a paused stretch: a
                    // resumed game would otherwise be reported as a slow front
                    // end for one window.
                    slices = 0;
                    fpsStamp = System.nanoTime();
                    Thread.sleep(16);
                    continue;
                }
                float factor = fastHold ? Math.max(speed, fastHoldSpeed()) : speed;
                syncFastAudio(factor);
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
                        core.runFrames(userKeys(), n);
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
                nextSlice += sliceNanos;
                if (System.nanoTime() - nextSlice > 2 * sliceNanos) {
                    nextSlice = System.nanoTime();
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
                    float shownSpeed = fastHold ? Math.max(speed, fastHoldSpeed()) : speed;
                    frames = 0;
                    slices = 0;
                    fpsStamp = now;
                    // How many pacing cycles the loop really completed this
                    // window: the audio resampler follows this rate so heavy
                    // games that cannot hold the console's frame time do not
                    // starve it.
                    core.setAudioPaceFps(elapsed > 0 ? cycles * 1_000_000_000f / elapsed : 0f);
                    // Rounded so the console's own 59.73 fps still shows as the
                    // 60 the counter has always displayed.
                    long shownFps = elapsed > 0 ? Math.round(shown * 1_000_000_000.0 / elapsed) : 0;
                    String speedText = shownSpeed == (long) shownSpeed
                            ? String.valueOf((long) shownSpeed)
                            : String.format(Locale.US, "%.2f", shownSpeed);
                    runOnUiThread(() -> fpsView.setText(speedText + "倍 " + shownFps + "fps"));
                }
            } catch (InterruptedException e) {
                if (!running) {
                    break;
                }
            } catch (Exception e) {
                toast(e.getMessage() == null ? getString(R.string.load_failed) : e.getMessage());
                try {
                    Thread.sleep(200);
                } catch (InterruptedException ignored) {
                    break;
                }
            }
        }
    }

    private void loadRom(String path) {
        releaseAudio();
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
        long frameNanos = core.frameNanos();
        sliceNanos = frameNanos > 0 ? frameNanos : 1_000_000_000L / 60L;
        frameDebt = 0f;
        nextFastPresent = 0L;
        setupAudio();
        paused = false;
        if (getPreferences(MODE_PRIVATE).getBoolean("auto_load_state", false)
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
        });
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
            if (gboyLink != null) {
                gboyLink.sendReset();
            }
            toast(getString(R.string.reset_done));
        } else if (cmd == CMD_AUTOSAVE) {
            // Silent save into the reserved slot on the way to the background.
            if (core.saveState(AUTO_SLOT)) {
                writeStatePreview(AUTO_SLOT);
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
        if (!presentQueued.compareAndSet(false, true)) {
            return;
        }
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
     * a change only needs the audio pipeline restarted.
     */
    private void syncFastAudio(double mult) {
        boolean mute = mult > 1.01 && !getPreferences(MODE_PRIVATE).getBoolean("fast_audio", true);
        if (mute != audioMuted) {
            audioMuted = mute;
            resetAudio();
        }
        if (audioMuted) {
            core.clearAudio();
            return;
        }
        if (mult != appliedSpeed) {
            appliedSpeed = mult;
            core.clearAudio();
            resetAudio();
        }
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
    }

    private void pumpAudio() {
        if (core == null) {
            return;
        }
        if (audio == null || audioMuted || paused || audio.getState() != AudioTrack.STATE_INITIALIZED) {
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
            if (volumePercent != 100) {
                float gain = volumePercent / 100f;
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
        String path = getPreferences(MODE_PRIVATE).getString("lastRom", null);
        String name = path == null ? "game" : new File(path).getName();
        int dot = name.lastIndexOf('.');
        if (dot > 0) {
            name = name.substring(0, dot);
        }
        return new File(new File(getFilesDir(), "states"), name + ".ss" + index);
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
        controls.setScales(keyLayout.resolvedScales());
        selectedKey = null;
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
        getPreferences(MODE_PRIVATE).edit()
                .putString(PROFILE_PREFIX + layoutProfile, keyLayout.encode())
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
        String data = getPreferences(MODE_PRIVATE).getString(PROFILE_PREFIX + name, null);
        if (data != null) {
            return data;
        }
        if (DEFAULT_PROFILE.equals(name)) {
            String legacy = getPreferences(MODE_PRIVATE).getString("key_layout", "");
            getPreferences(MODE_PRIVATE).edit()
                    .putString(PROFILE_PREFIX + name, legacy == null ? "" : legacy)
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
        final Button filter = new Button(this);
        filter.setAllCaps(false);
        filter.setText(getString(R.string.video_filter_value, filterName(filterPref())));
        filter.setOnClickListener(v -> new AlertDialog.Builder(this)
                .setTitle(R.string.video_filter)
                .setSingleChoiceItems(filterNames(), filterPref(), (dialog, which) -> {
                    getPreferences(MODE_PRIVATE).edit().putInt("vf_filter", which).apply();
                    filter.setText(getString(R.string.video_filter_value, filterName(which)));
                    applyVideo();
                    dialog.dismiss();
                })
                .show());
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
        box.addView(blend);
        box.addView(linear);
        box.addView(aspect);
        box.addView(integer);
        box.addView(scan);
        box.addView(filter);
        box.addView(skipAuto);
        box.addView(skipLabel);
        box.addView(skipBar);
        box.addView(brightLabel);
        box.addView(brightBar);
        Runnable persist = () -> {
            getPreferences(MODE_PRIVATE).edit()
                    .putBoolean("vf_blend", blend.isChecked())
                    .putBoolean("vf_linear", linear.isChecked())
                    .putBoolean("vf_aspect", aspect.isChecked())
                    .putBoolean("vf_integer", integer.isChecked())
                    .putBoolean("vf_scan", scan.isChecked())
                    .putInt("vf_skip", skipBar.getProgress())
                    .putInt("vf_bright", brightBar.getProgress() + 50)
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
            default: return getString(R.string.filter_none);
        }
    }

    private CharSequence[] filterNames() {
        CharSequence[] names = new CharSequence[Shaders.FILTER_COUNT];
        for (int i = 0; i < Shaders.FILTER_COUNT; i++) {
            names[i] = filterName(i);
        }
        return names;
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
        LinearLayout box = new LinearLayout(this);
        box.setOrientation(LinearLayout.VERTICAL);
        int pad = dp(16);
        box.setPadding(pad, pad, pad, pad);
        TextView help = new TextView(this);
        help.setText(R.string.link_help);
        help.setTextColor(0xFF222222);
        EditText host = new EditText(this);
        host.setHint(R.string.link_ip_hint);
        host.setSingleLine(true);
        host.setText(getPreferences(MODE_PRIVATE).getString("link_host", ""));
        EditText port = new EditText(this);
        port.setInputType(InputType.TYPE_CLASS_NUMBER);
        port.setSingleLine(true);
        port.setText(String.valueOf(getPreferences(MODE_PRIVATE).getInt("link_port", 8765)));
        EditText relay = new EditText(this);
        relay.setHint(R.string.link_relay_hint);
        relay.setSingleLine(true);
        relay.setText(getPreferences(MODE_PRIVATE).getString("link_relay", ""));
        EditText room = new EditText(this);
        room.setHint(R.string.link_room_hint);
        room.setSingleLine(true);
        room.setText(getPreferences(MODE_PRIVATE).getString("link_room", ""));
        linkRoomView = room;
        TextView status = new TextView(this);
        status.setTextColor(0xFF1B5E20);
        status.setPadding(0, pad, 0, 0);
        status.setText(linkMessage());
        linkStatusView = status;
        box.addView(help);
        box.addView(host);
        box.addView(port);
        box.addView(buttonRow(
                linkButton(getString(R.string.link_host), v -> {
                    int p = parsePort(port.getText().toString());
                    if (p < 0) {
                        status.setText(R.string.link_bad_port);
                        return;
                    }
                    if (remoteLink != null) {
                        remoteLink.close();
                    }
                    if (core.linkHost(p)) {
                        getPreferences(MODE_PRIVATE).edit().putInt("link_port", p).apply();
                        status.setText(getString(R.string.link_waiting, localIpv4(), p));
                        startLinkWatch();
                    } else {
                        status.setText(linkMessage());
                    }
                }),
                linkButton(getString(R.string.link_join), v -> {
                    String ip = host.getText().toString().trim();
                    int p = parsePort(port.getText().toString());
                    if (ip.isEmpty() || p < 0) {
                        status.setText(R.string.link_bad_port);
                        return;
                    }
                    if (remoteLink != null) {
                        remoteLink.close();
                    }
                    getPreferences(MODE_PRIVATE).edit().putString("link_host", ip).putInt("link_port", p).apply();
                    if (core.linkJoin(ip, p)) {
                        status.setText(linkMessage());
                        startLinkWatch();
                    } else {
                        status.setText(linkMessage());
                    }
                })));
        box.addView(relay);
        box.addView(room);
        box.addView(buttonRow(
                linkButton(getString(R.string.link_remote_create), v -> {
                    String relayText = relay.getText().toString().trim();
                    getPreferences(MODE_PRIVATE).edit().putString("link_relay", relayText).apply();
                    ensureRemote().create(relayText, localIpv4());
                    startLinkWatch();
                }),
                linkButton(getString(R.string.link_remote_join), v -> {
                    String relayText = relay.getText().toString().trim();
                    String code = room.getText().toString().trim();
                    getPreferences(MODE_PRIVATE).edit().putString("link_relay", relayText).putString("link_room", code).apply();
                    ensureRemote().join(relayText, code);
                    startLinkWatch();
                })));
        // ---- GBoy (My Boy) Wi-Fi link ----
        TextView gboyHelp = new TextView(this);
        gboyHelp.setText(R.string.link_gboy_help);
        gboyHelp.setTextColor(0xFF222222);
        box.addView(gboyHelp);
        EditText gboyIp = new EditText(this);
        gboyIp.setHint(R.string.link_gboy_ip_hint);
        gboyIp.setSingleLine(true);
        gboyIp.setText(getPreferences(MODE_PRIVATE).getString("gboy_ip", ""));
        EditText gboyPort = new EditText(this);
        gboyPort.setInputType(InputType.TYPE_CLASS_NUMBER);
        gboyPort.setSingleLine(true);
        gboyPort.setText(String.valueOf(getPreferences(MODE_PRIVATE).getInt("gboy_port", GBoyLink.DEFAULT_PORT)));
        box.addView(gboyIp);
        box.addView(gboyPort);
        box.addView(buttonRow(
                linkButton(getString(R.string.link_gboy_host), v -> {
                    int p = parsePort(gboyPort.getText().toString());
                    if (p < 0) {
                        status.setText(R.string.link_bad_port);
                        return;
                    }
                    if (core == null || !core.isLoaded()) {
                        status.setText(R.string.link_gboy_no_rom);
                        return;
                    }
                    getPreferences(MODE_PRIVATE).edit().putInt("gboy_port", p).apply();
                    ensureGboy().host(p);
                }),
                linkButton(getString(R.string.link_gboy_join), v -> {
                    String ip = gboyIp.getText().toString().trim();
                    int p = parsePort(gboyPort.getText().toString());
                    if (ip.isEmpty() || p < 0) {
                        status.setText(R.string.link_bad_port);
                        return;
                    }
                    if (core == null || !core.isLoaded()) {
                        status.setText(R.string.link_gboy_no_rom);
                        return;
                    }
                    getPreferences(MODE_PRIVATE).edit().putString("gboy_ip", ip).putInt("gboy_port", p).apply();
                    ensureGboy().join(ip, p);
                })));
        box.addView(linkButton(getString(R.string.link_close), v -> {
            if (remoteLink != null) {
                remoteLink.close();
            } else if (core != null) {
                core.linkClose();
            }
            if (gboyLink != null) {
                gboyLink.close();
            }
            gboyRemoteKeys = 0;
            inputHandler.removeCallbacks(linkWatch);
            lastLinkState = 0;
            status.setText(R.string.link_close);
        }));
        box.addView(status);
        ScrollView scroll = new ScrollView(this);
        scroll.addView(box);
        new AlertDialog.Builder(this)
                .setTitle(R.string.link_title)
                .setView(scroll)
                .setNegativeButton(android.R.string.cancel, null)
                .show();
    }

    private GBoyLink ensureGboy() {
        if (gboyLink == null) {
            gboyLink = new GBoyLink(new GBoyLink.Hooks() {
                @Override
                public String romPath() {
                    return getPreferences(MODE_PRIVATE).getString("lastRom", null);
                }

                @Override
                public int localKeys() {
                    return touchKeys | hwKeys;
                }

                @Override
                public void onRemoteKeys(final int keys) {
                    runOnUiThread(() -> gboyRemoteKeys = keys);
                }

                @Override
                public void onStatus(final String text) {
                    runOnUiThread(() -> {
                        if (linkStatusView != null) {
                            linkStatusView.setText(text);
                        }
                    });
                }

                @Override
                public void onConnected(boolean asHost, String note) {
                    // The session status lands through onStatus right after.
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
        }
        return gboyLink;
    }

    private RemoteLink ensureRemote() {
        if (remoteLink == null) {
            remoteLink = new RemoteLink(new RemoteLink.Hooks() {
                @Override
                public void onStatus(String text) {
                    inputHandler.post(() -> {
                        if (linkStatusView != null) {
                            linkStatusView.setText(text);
                        }
                    });
                }

                @Override
                public void onRoom(String code, String relayForPeer) {
                    inputHandler.post(() -> {
                        if (isFinishing() || isDestroyed()) {
                            return;
                        }
                        if (linkRoomView != null) {
                            linkRoomView.setText(code);
                        }
                        getPreferences(MODE_PRIVATE).edit().putString("link_room", code).apply();
                        ClipboardManager clipboard = (ClipboardManager) getSystemService(CLIPBOARD_SERVICE);
                        if (clipboard != null) {
                            clipboard.setPrimaryClip(ClipData.newPlainText("room", code));
                        }
                        toast(getString(R.string.link_room_copied, code, relayForPeer));
                    });
                }

                @Override
                public boolean hostLink(int port) {
                    return core != null && core.linkHost(port);
                }

                @Override
                public boolean joinLink(String host, int port) {
                    return core != null && core.linkJoin(host, port);
                }

                @Override
                public void closeLink() {
                    if (core != null) {
                        core.linkClose();
                    }
                }
            });
        }
        return remoteLink;
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

    private final Runnable linkWatch = new Runnable() {
        @Override
        public void run() {
            String status = core == null ? "" : core.linkStatus();
            int state = linkState(status);
            if (state != lastLinkState && state == 3) {
                toast(linkMessage());
            }
            lastLinkState = state;
            if (state == 1 || state == 2) {
                inputHandler.postDelayed(this, 700);
            }
        }
    };

    private void startLinkWatch() {
        inputHandler.removeCallbacks(linkWatch);
        inputHandler.post(linkWatch);
    }

    private static int linkState(String status) {
        if (status == null || status.isEmpty()) {
            return 0;
        }
        int space = status.indexOf(' ');
        try {
            return Integer.parseInt(space < 0 ? status : status.substring(0, space));
        } catch (NumberFormatException e) {
            return 0;
        }
    }

    private String linkMessage() {
        String status = core == null ? "" : core.linkStatus();
        if (status == null) {
            return "";
        }
        int first = status.indexOf(' ');
        int second = first < 0 ? -1 : status.indexOf(' ', first + 1);
        if (second < 0 || second + 1 >= status.length()) {
            return status;
        }
        return status.substring(second + 1);
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
        try {
            ArrayList<NetworkInterface> ifaces = Collections.list(NetworkInterface.getNetworkInterfaces());
            for (NetworkInterface iface : ifaces) {
                if (!iface.isUp() || iface.isLoopback()) {
                    continue;
                }
                for (InetAddress address : Collections.list(iface.getInetAddresses())) {
                    if (address instanceof Inet4Address && !address.isLoopbackAddress()) {
                        return address.getHostAddress();
                    }
                }
            }
        } catch (Exception ignored) {
        }
        return "0.0.0.0";
    }

    private int dp(int value) {
        return Math.round(value * getResources().getDisplayMetrics().density);
    }

    private void buildSpeedBar() {
        speedBar = findViewById(R.id.speed_bar);
        LinearLayout row = findViewById(R.id.speed_row);
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
        CheckBox sound = new CheckBox(this);
        sound.setText(R.string.speed_sound);
        sound.setTextColor(Color.WHITE);
        sound.setChecked(getPreferences(MODE_PRIVATE).getBoolean("fast_audio", true));
        sound.setOnCheckedChangeListener((v, checked) -> getPreferences(MODE_PRIVATE).edit().putBoolean("fast_audio", checked).apply());
        row.addView(sound);
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
        final int IDX_SCAN = 5;
        final int IDX_HELP = 6;
        String[] items = {
                getString(R.string.orientation_title),
                getString(R.string.settings_sound),
                getString(R.string.settings_input),
                getString(R.string.settings_save),
                getString(R.string.settings_advanced),
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
                : "landscape_rev".equals(mode) ? 1 : 0;
        new AlertDialog.Builder(this)
                .setTitle(R.string.orientation_title)
                .setSingleChoiceItems(new CharSequence[] {
                        getString(R.string.orientation_landscape),
                        getString(R.string.orientation_landscape_rev),
                        getString(R.string.orientation_portrait),
                        getString(R.string.orientation_portrait_rev),
                }, checked, (dialog, which) -> {
                    String next = which == 2 ? "portrait"
                            : which == 3 ? "portrait_rev"
                            : which == 1 ? "landscape_rev" : "landscape";
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
        box.addView(vibe);
        box.addView(turboMode);
        box.addView(rateLabel);
        box.addView(rateBar);
        box.addView(diagonal);
        box.addView(opacityLabel);
        box.addView(opacityBar);
        box.addView(extras);
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
            {"save", "快速存档"}, {"load", "快速读档"}, {"ff", "倍速（按住快进）"}, {"shot", "截图"},
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
                    StringBuilder csv = new StringBuilder();
                    for (String key : next) {
                        if (csv.length() > 0) {
                            csv.append(',');
                        }
                        csv.append(key);
                    }
                    getPreferences(MODE_PRIVATE).edit().putString("extra_keys", csv.toString()).apply();
                    applyInputSettings();
                })
                .setPositiveButton(android.R.string.ok, null)
                .show();
    }

    private Set<String> extraKeys() {
        Set<String> out = new HashSet<>();
        String csv = getPreferences(MODE_PRIVATE).getString("extra_keys", "");
        if (csv != null && !csv.isEmpty()) {
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
        box.addView(saveType);
        box.addView(autoLoad);
        box.addView(autoSave);
        box.addView(confirmClose);
        box.addView(patches);
        box.addView(deleteSav);
        box.addView(importSav);
        autoLoad.setOnCheckedChangeListener((v, checked) -> getPreferences(MODE_PRIVATE).edit().putBoolean("auto_load_state", checked).apply());
        autoSave.setOnCheckedChangeListener((v, checked) -> getPreferences(MODE_PRIVATE).edit().putBoolean("auto_save_state", checked).apply());
        confirmClose.setOnCheckedChangeListener((v, checked) -> getPreferences(MODE_PRIVATE).edit().putBoolean("confirm_close", checked).apply());
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
        CheckBox sgbBorders = check(R.string.adv_sgb_border, getPreferences(MODE_PRIVATE).getBoolean("sgb_borders", false));
        CheckBox tiltSensor = check(R.string.adv_tilt, getPreferences(MODE_PRIVATE).getBoolean("tilt_sensor", false));
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
        box.addView(sgbBorders);
        box.addView(tiltSensor);
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
        core.setCartRumble(getPreferences(MODE_PRIVATE).getBoolean("cart_rumble", false));
        int[] palette = gbPaletteColors();
        core.setGbPalette(palette);
        core.setSgbBorders(getPreferences(MODE_PRIVATE).getBoolean("sgb_borders", false));
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
        if (controls != null) {
            controls.setDiagonalLock(getPreferences(MODE_PRIVATE).getBoolean("no_diagonal", false));
            controls.setTurboRate(getPreferences(MODE_PRIVATE).getInt("turbo_rate", 25));
            controls.setVisibleExtras(extraKeys());
            controls.setOpacity(getPreferences(MODE_PRIVATE).getInt("controls_opacity", 100));
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
        if (save) {
            recyclePendingPreview();
            pendingPreview.set(gameView.copyLast());
            command.set(CMD_SAVE);
        } else {
            command.set(CMD_LOAD);
        }
    }

    /** Saves the current frame as a PNG into the system Pictures folder. */
    private void takeScreenshot() {
        if (core == null || !core.isLoaded()) {
            toast(getString(R.string.no_rom));
            return;
        }
        Bitmap shot = gameView.copyLast();
        if (shot == null) {
            toast(getString(R.string.no_rom));
            return;
        }
        String stamp = DateFormat.format("yyyyMMdd-HHmmss", System.currentTimeMillis()).toString();
        String title = "mGBAx-" + stamp + ".png";
        try {
            if (Build.VERSION.SDK_INT >= 29) {
                ContentValues values = new ContentValues();
                values.put(MediaStore.Images.Media.DISPLAY_NAME, title);
                values.put(MediaStore.Images.Media.MIME_TYPE, "image/png");
                values.put(MediaStore.Images.Media.RELATIVE_PATH, Environment.DIRECTORY_PICTURES + "/mGBAx");
                Uri uri = getContentResolver().insert(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, values);
                if (uri != null) {
                    try (OutputStream out = getContentResolver().openOutputStream(uri)) {
                        shot.compress(Bitmap.CompressFormat.PNG, 100, out);
                    }
                }
            } else {
                File dir = new File(Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_PICTURES), "mGBAx");
                dir.mkdirs();
                try (OutputStream out = new FileOutputStream(new File(dir, title))) {
                    shot.compress(Bitmap.CompressFormat.PNG, 100, out);
                }
            }
            toast(getString(R.string.screenshot_saved, "Pictures/mGBAx/" + title));
        } catch (Exception e) {
            toast(getString(R.string.screenshot_failed));
        } finally {
            shot.recycle();
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
        if (!gifQueue.offer(copy)) {
            copy.recycle();
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
        lastGifAt = 0;
        gifFrames = 0;
        gifRecording = true;
        gifThread = new Thread(() -> runGifRecording(temp, w, h, name), "gif-record");
        gifThread.start();
        if (gifButton != null) {
            gifButton.setText(R.string.gif_stop);
        }
        toast(getString(R.string.gif_started));
    }

    private void stopGif() {
        gifRecording = false;
    }

    /** Encoder loop: drains the queue into the GIF file, then publishes it. */
    private void runGifRecording(File temp, int w, int h, String name) {
        boolean ok;
        try (FileOutputStream stream = new FileOutputStream(temp)) {
            GifEncoder encoder = new GifEncoder(stream, w, h);
            while (true) {
                Bitmap bmp;
                try {
                    bmp = gifQueue.poll(1, java.util.concurrent.TimeUnit.SECONDS);
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
        } catch (Exception e) {
            ok = false;
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
        screenArea.setPortraitMode(portrait);
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
            // A key-up for the fast-forward hold can get lost (window switched,
            // gamepad disconnected); drop the hold so the game cannot come back
            // stuck at 16x speed with raised audio.
            fastHold = false;
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
        // Do not stay held at 16x (raised pitch) when the key-up never arrives
        // because the app went to the background under a held key.
        fastHold = false;
        inputHandler.removeCallbacks(armTurbo);
        stopTurbo();
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
        hideSystemUi();
        autoHideMenu();
    }

    @Override
    protected void onDestroy() {
        running = false;
        if (remoteLink != null) {
            remoteLink.close();
        }
        if (gboyLink != null) {
            gboyLink.close();
            gboyLink = null;
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
