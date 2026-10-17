/* This Source Code Form is subject to the terms of the Mozilla Public
 * License, v. 2.0. If a copy of the MPL was not distributed with this
 * file, You can obtain one at http://mozilla.org/MPL/2.0/. */
package io.mgba.android;

import android.Manifest;
import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.graphics.RectF;
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
import android.provider.DocumentsContract;
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
import java.util.Collections;
import java.util.Comparator;
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
    private static final int CMD_SAVE = 1;
    private static final int CMD_LOAD = 2;
    private static final int CMD_RESET = 3;
    private static final int TURBO_ARM_MS = 200;
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
    private final Runnable hideMenu = this::hideMenuNow;
    private HorizontalScrollView speedBar;
    private final Button[] speedButtons = new Button[17];

    private final AtomicReference<String> pendingPath = new AtomicReference<>();
    /** True while a picked/opened ROM is being imported, so startEmulator() does not arm the old one. */
    private volatile boolean importingRom;
    /** Last "open with" URI already handled, so config changes do not load it twice. */
    private String handledRomUri;
    private final AtomicInteger command = new AtomicInteger();
    private volatile boolean running;
    private volatile boolean paused;
    private volatile boolean surfaceReady;
    private volatile int speed = 1;
    private volatile boolean fastHold;
    private volatile int touchKeys;
    private volatile int hwKeys;
    private final Handler inputHandler = new Handler(Looper.getMainLooper());
    private boolean turboB;
    private boolean turboDown;
    private volatile int slot = 1;
    private Thread emuThread;

    private AudioTrack audio;
    private boolean audioMuted;
    private volatile boolean audioStarted;
    private int appliedSpeed = -1;
    private long nextFastPresent;
    private int outputRate;
    private int sourceRate;
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

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        applyOrientation();
        setContentView(R.layout.activity_emulator);
        gameView = findViewById(R.id.game);
        hint = findViewById(R.id.hint);
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
                }
            }

            @Override
            public void onControlsLayout() {
                positionMenuButton();
            }
        });
        bindLayoutEditor();

        findViewById(R.id.btn_open).setOnClickListener(v -> openDocument(REQ_ROM));
        findViewById(R.id.btn_open).setOnLongClickListener(v -> {
            showRomScan();
            return true;
        });
        findViewById(R.id.btn_bios).setOnClickListener(v -> openDocument(REQ_BIOS));
        pauseButton.setOnClickListener(v -> setPaused(!paused));
        int savedSpeed = getPreferences(MODE_PRIVATE).getInt("speed", 1);
        speed = savedSpeed >= 1 && savedSpeed <= 16 ? savedSpeed : 1;
        buildSpeedBar();
        fastButton.setOnClickListener(v -> speedBar.setVisibility(speedBar.getVisibility() == View.VISIBLE ? View.GONE : View.VISIBLE));
        slotButton.setOnClickListener(v -> {
            slot = slot % 9 + 1;
            refreshSlotButton();
        });
        findViewById(R.id.btn_save).setOnClickListener(v -> chooseSlot(true));
        findViewById(R.id.btn_load).setOnClickListener(v -> chooseSlot(false));
        findViewById(R.id.btn_reset).setOnClickListener(v -> command.set(CMD_RESET));
        findViewById(R.id.btn_video).setOnClickListener(v -> showVideoDialog());
        findViewById(R.id.btn_link).setOnClickListener(v -> showLinkDialog());
        findViewById(R.id.btn_layout).setOnClickListener(v -> setLayoutEditing(!layoutEditing));
        findViewById(R.id.btn_settings).setOnClickListener(v -> showSettingsDialog());
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
        if (turboB) {
            mask &= ~ControlsView.B;
        }
        core.setKeys(mask);
    }

    private void noteUserKeys(int prevTouch, int prevHw) {
        boolean wasB = ((prevTouch | prevHw) & ControlsView.B) != 0;
        boolean nowB = ((touchKeys | hwKeys) & ControlsView.B) != 0;
        if (nowB && !wasB) {
            inputHandler.removeCallbacks(armTurbo);
            inputHandler.postDelayed(armTurbo, TURBO_ARM_MS);
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

    /** Keeps the menu handle a little to the right of the on-screen START key. */
    private void positionMenuButton() {
        if (menuButton == null || controls == null) {
            return;
        }
        ViewGroup.LayoutParams params = menuButton.getLayoutParams();
        if (!(params instanceof FrameLayout.LayoutParams)) {
            return;
        }
        RectF start = new RectF();
        controls.getStartRect(start);
        if (start.width() <= 0f) {
            return;
        }
        int height = menuButton.getHeight() > 0 ? menuButton.getHeight() : dp(24);
        FrameLayout.LayoutParams lp = (FrameLayout.LayoutParams) params;
        int left = (int) start.right + dp(4);
        int top = (int) start.centerY() - height / 2;
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
        long fpsStamp = System.nanoTime();
        while (running) {
            try {
                if (core != null) {
                    core.pumpLink();
                }
                String path = pendingPath.getAndSet(null);
                if (path != null) {
                    loadRom(path);
                }
                int cmd = command.getAndSet(0);
                if (cmd != 0) {
                    runCommand(cmd);
                }
                if (!surfaceReady || paused || !core.isLoaded()) {
                    Thread.sleep(16);
                    continue;
                }
                int mult = fastHold ? Math.max(speed, 16) : speed;
                syncFastAudio(mult);
                long sliceStart = System.nanoTime();
                // Run in a few steps, pumping audio in between: a fast-forward
                // burst produces several frames of audio at once and the core's
                // audio buffer only holds a little more than that, so leaving it
                // undrained drops samples and makes fast-forward sound garbled.
                int steps = (mult + AUDIO_STEP_FRAMES - 1) / AUDIO_STEP_FRAMES;
                int step = (mult + steps - 1) / steps;
                for (int done = 0; done < mult; ) {
                    int n = Math.min(step, mult - done);
                    core.runFrames(touchKeys | hwKeys, n);
                    // 倍速也有声音：重采样器按倍速变速输出（磁带式）。
                    // Keep in sync with MOBILE_AUDIO_PACE_FPS on the native side.
                    pumpAudio();
                    done += n;
                }
                if (mult == 1) {
                    presentFrame();
                } else {
                    long now = System.nanoTime();
                    if (now >= nextFastPresent) {
                        presentFrame();
                        nextFastPresent = now + 80_000_000L;
                    }
                }
                frames += mult;
                long remain = 1_000_000_000L / 60L - (System.nanoTime() - sliceStart);
                if (remain > 1_000_000L) {
                    Thread.sleep(remain / 1_000_000L, (int) (remain % 1_000_000L));
                }
                long now = System.nanoTime();
                if (now - fpsStamp >= 1000000000L) {
                    long shown = frames;
                    int shownSpeed = fastHold ? Math.max(speed, 16) : speed;
                    frames = 0;
                    fpsStamp = now;
                    runOnUiThread(() -> fpsView.setText(shownSpeed + "倍 " + shown + "fps"));
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
        setupAudio();
        paused = false;
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
                core.runFrames(touchKeys | hwKeys, 1);
                presentFrame();
            }
            toast(ok ? getString(R.string.state_loaded, current) : getString(R.string.state_missing, current));
            runOnUiThread(this::refreshSlotButton);
        } else if (cmd == CMD_RESET) {
            core.reset();
            core.clearAudio();
            toast(getString(R.string.reset_done));
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
            track = new AudioTrack.Builder()
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
                    .setBufferSizeInBytes(wantFrames * 4)
                    .build();
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
    private void syncFastAudio(int mult) {
        boolean mute = mult > 1 && !getPreferences(MODE_PRIVATE).getBoolean("fast_audio", true);
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
        // Fast-forward produces several frames worth of audio per pump; keep
        // draining so the core's buffer never backs up.
        for (int round = 0; round < 8; round++) {
            int frames = core.readAudioOut(audioRead, Math.max(appliedSpeed, 1), drift);
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
        keyLayout = KeyLayout.decode(getPreferences(MODE_PRIVATE).getString("key_layout", ""));
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
        getPreferences(MODE_PRIVATE).edit().putString("key_layout", keyLayout.encode()).apply();
    }

    private void setLayoutEditing(boolean on) {
        layoutEditing = on;
        findViewById(R.id.layout_editor).setVisibility(on ? View.VISIBLE : View.GONE);
        controls.setEditing(on);
        menuButton.setVisibility(on ? View.GONE : View.VISIBLE);
        if (on) {
            showMenu();
            inputHandler.removeCallbacks(hideMenu);
            refreshScaleBar();
        } else {
            autoHideMenu();
        }
    }

    private void resetLayout() {
        keyLayout.resetAll();
        selectedKey = null;
        getPreferences(MODE_PRIVATE).edit().putString("key_layout", keyLayout.encode()).apply();
        controls.setCenters(keyLayout.resolved());
        controls.setScales(keyLayout.resolvedScales());
        refreshScaleBar();
        toast(getString(R.string.layout_reset_done));
    }

    private void applyVideo() {
        if (core == null) {
            return;
        }
        boolean blend = getPreferences(MODE_PRIVATE).getBoolean("vf_blend", false);
        boolean linear = getPreferences(MODE_PRIVATE).getBoolean("vf_linear", true);
        boolean aspect = getPreferences(MODE_PRIVATE).getBoolean("vf_aspect", true);
        boolean integer = getPreferences(MODE_PRIVATE).getBoolean("vf_integer", false);
        boolean scan = getPreferences(MODE_PRIVATE).getBoolean("vf_scan", false);
        int skip = getPreferences(MODE_PRIVATE).getInt("vf_skip", 0);
        int bright = getPreferences(MODE_PRIVATE).getInt("vf_bright", 100);
        core.setInterframe(blend);
        core.setFrameskip(skip);
        gameView.setBilinear(linear);
        gameView.setLockAspect(aspect);
        gameView.setIntegerScale(integer);
        gameView.setScanlines(scan);
        gameView.setBrightness(bright);
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
        TextView skipLabel = new TextView(this);
        skipLabel.setText(getString(R.string.video_skip, skipNow));
        skipLabel.setTextColor(0xFF222222);
        SeekBar skipBar = new SeekBar(this);
        skipBar.setMax(5);
        skipBar.setProgress(skipNow);
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
        box.addView(linkButton(getString(R.string.link_close), v -> {
            if (remoteLink != null) {
                remoteLink.close();
            } else if (core != null) {
                core.linkClose();
            }
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
        for (int i = 1; i <= 16; i++) {
            Button button = new Button(this);
            button.setText(String.valueOf(i));
            button.setAllCaps(false);
            button.setMinWidth(dp(44));
            button.setMinHeight(dp(36));
            button.setMinimumWidth(dp(44));
            button.setMinimumHeight(dp(36));
            button.setTextSize(14);
            button.setPadding(dp(8), 0, dp(8), 0);
            int value = i;
            button.setOnClickListener(v -> setSpeed(value));
            speedButtons[i] = button;
            row.addView(button);
        }
        CheckBox sound = new CheckBox(this);
        sound.setText(R.string.speed_sound);
        sound.setTextColor(Color.WHITE);
        sound.setChecked(getPreferences(MODE_PRIVATE).getBoolean("fast_audio", true));
        sound.setOnCheckedChangeListener((v, checked) -> getPreferences(MODE_PRIVATE).edit().putBoolean("fast_audio", checked).apply());
        row.addView(sound);
        refreshSpeedButtons();
    }

    private void setSpeed(int value) {
        speed = Math.max(1, Math.min(16, value));
        getPreferences(MODE_PRIVATE).edit().putInt("speed", speed).apply();
        refreshSpeedButtons();
    }

    private void refreshSpeedButtons() {
        fastButton.setText(getString(R.string.speed_value, speed));
        for (int i = 1; i <= 16; i++) {
            boolean on = i == speed;
            speedButtons[i].setTextColor(on ? 0xFF102010 : Color.WHITE);
            speedButtons[i].setBackgroundColor(on ? 0xFF3DDC84 : Color.TRANSPARENT);
        }
    }

    private void showSettingsDialog() {
        boolean portrait = prefersPortrait();
        new AlertDialog.Builder(this)
                .setTitle(R.string.orientation_title)
                .setSingleChoiceItems(new CharSequence[] {
                        getString(R.string.orientation_landscape),
                        getString(R.string.orientation_portrait)
                }, portrait ? 1 : 0, (dialog, which) -> {
                    boolean nextPortrait = which == 1;
                    getPreferences(MODE_PRIVATE).edit()
                            .putString("orientation", nextPortrait ? "portrait" : "landscape")
                            .apply();
                    applyOrientation(nextPortrait);
                    dialog.dismiss();
                })
                .setNeutralButton(R.string.scan_button, (dialog, which) -> showRomScan())
                .show();
    }

    private boolean prefersPortrait() {
        return "portrait".equals(getPreferences(MODE_PRIVATE).getString("orientation", "landscape"));
    }

    private void applyOrientation() {
        applyOrientation(prefersPortrait());
    }

    private void applyOrientation(boolean portrait) {
        setRequestedOrientation(portrait
                ? ActivityInfo.SCREEN_ORIENTATION_SENSOR_PORTRAIT
                : ActivityInfo.SCREEN_ORIENTATION_SENSOR_LANDSCAPE);
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
        }
    }

    private void hideSystemUi() {
        View decor = getWindow().getDecorView();
        decor.setSystemUiVisibility(View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY
                | View.SYSTEM_UI_FLAG_FULLSCREEN
                | View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
                | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                | View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
                | View.SYSTEM_UI_FLAG_LAYOUT_STABLE);
    }

    @Override
    protected void onPause() {
        super.onPause();
        if (awaitingStorage) {
            leftForStorage = true;
        }
        paused = true;
        inputHandler.removeCallbacks(armTurbo);
        stopTurbo();
        if (audio != null) {
            audio.pause();
            audioStarted = false;
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
        hideSystemUi();
        autoHideMenu();
    }

    @Override
    protected void onDestroy() {
        running = false;
        if (remoteLink != null) {
            remoteLink.close();
        }
        inputHandler.removeCallbacksAndMessages(null);
        releaseAudio();
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
