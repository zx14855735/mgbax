/* This Source Code Form is subject to the terms of the Mozilla Public
 * License, v. 2.0. If a copy of the MPL was not distributed with this
 * file, You can obtain one at http://mozilla.org/MPL/2.0/. */
package io.mgba.android;

import android.Manifest;
import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Intent;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.media.AudioAttributes;
import android.media.AudioFormat;
import android.media.AudioTrack;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.provider.OpenableColumns;
import android.provider.Settings;
import android.text.InputType;
import android.text.format.DateFormat;
import android.view.Gravity;
import android.view.KeyEvent;
import android.view.SurfaceHolder;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
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
import java.util.Collections;
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

    private MgbaCore core;
    private GameView gameView;
    private ControlsView controls;
    private TextView hint;
    private TextView fpsView;
    private Button pauseButton;
    private Button fastButton;
    private Button slotButton;

    private final AtomicReference<String> pendingPath = new AtomicReference<>();
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
    private boolean fastAudio;
    private long nextFastPresent;
    private int outputRate;
    private int sourceRate;
    private final short[] nativeAudio = new short[8192 * 2];
    private final short[] outputAudio = new short[8192 * 2];
    private double resamplePos;
    private Bitmap frame;
    private final AtomicBoolean presentQueued = new AtomicBoolean();
    private final AtomicReference<Bitmap> pendingPreview = new AtomicReference<>();
    private int lastLinkState = -1;
    private boolean emulatorStarted;
    private boolean awaitingStorage;
    private boolean leftForStorage;
    private TextView savePathView;
    private TextView linkStatusView;
    private EditText linkRoomView;
    private RemoteLink remoteLink;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_emulator);
        gameView = findViewById(R.id.game);
        hint = findViewById(R.id.hint);
        fpsView = findViewById(R.id.fps);
        pauseButton = findViewById(R.id.btn_pause);
        fastButton = findViewById(R.id.btn_fast);
        slotButton = findViewById(R.id.btn_slot);

        controls = findViewById(R.id.controls);
        controls.setListener(mask -> {
            int prev = touchKeys;
            touchKeys = mask;
            noteUserKeys(prev, hwKeys);
            if ((mask & ~prev) != 0) {
                wakeInput();
            }
        });

        findViewById(R.id.btn_open).setOnClickListener(v -> openDocument(REQ_ROM));
        findViewById(R.id.btn_bios).setOnClickListener(v -> openDocument(REQ_BIOS));
        pauseButton.setOnClickListener(v -> setPaused(!paused));
        fastButton.setOnClickListener(v -> {
            if (speed == 1) {
                speed = 4;
            } else if (speed == 4) {
                speed = 8;
            } else if (speed == 8) {
                speed = 16;
            } else {
                speed = 1;
            }
            fastButton.setText(speedText(speed));
            if (core != null) {
                core.clearAudio();
            }
        });
        slotButton.setOnClickListener(v -> {
            slot = slot % 9 + 1;
            refreshSlotButton();
        });
        findViewById(R.id.btn_save).setOnClickListener(v -> chooseSlot(true));
        findViewById(R.id.btn_load).setOnClickListener(v -> chooseSlot(false));
        findViewById(R.id.btn_reset).setOnClickListener(v -> command.set(CMD_RESET));
        findViewById(R.id.btn_video).setOnClickListener(v -> showVideoDialog());
        findViewById(R.id.btn_link).setOnClickListener(v -> showLinkDialog());
        savePathView = findViewById(R.id.save_path);
        savePathView.setOnClickListener(v -> copySavePath());

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

        ensureSaveAccess();
        hideSystemUi();
    }

    private void ensureSaveAccess() {
        if (SaveLocation.hasAccess(this) || getPreferences(MODE_PRIVATE).getBoolean("save_access_declined", false)) {
            startEmulator();
            return;
        }
        int message = Build.VERSION.SDK_INT >= 30 ? R.string.save_access_message : R.string.save_access_message_legacy;
        new AlertDialog.Builder(this)
                .setTitle(R.string.save_access_title)
                .setMessage(message)
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
        if (pendingPath.get() == null) {
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
            hint.setText(R.string.loading);
            hint.setVisibility(View.VISIBLE);
            new Thread(() -> {
                String path = copyTo(uri, new File(getFilesDir(), "roms"), null);
                if (path == null) {
                    toast(getString(R.string.load_failed));
                    return;
                }
                getPreferences(MODE_PRIVATE).edit().putString("lastRom", path).apply();
                pendingPath.set(path);
            }, "rom-copy").start();
        } else if (requestCode == REQ_BIOS) {
            new Thread(() -> importBios(uri), "bios-copy").start();
        }
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
                core.runFrames(touchKeys | hwKeys, mult);
                if (mult == 1) {
                    pumpAudio();
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
        resamplePos = 0;
        boolean ok = core.load(path);
        if (!ok) {
            runOnUiThread(() -> {
                hint.setText(R.string.load_failed);
                hint.setVisibility(View.VISIBLE);
                setTitle(R.string.app_name);
            });
            toast(getString(R.string.load_failed));
            return;
        }
        setupAudio();
        fastAudio = false;
        paused = false;
        String title = core.title();
        runOnUiThread(() -> {
            hint.setVisibility(View.GONE);
            pauseButton.setText(R.string.pause);
            showSaveLocation();
            setTitle(title == null || title.trim().isEmpty() ? getString(R.string.app_name) : title.trim());
            if (audio != null && audio.getState() == AudioTrack.STATE_INITIALIZED && audio.getPlayState() != AudioTrack.PLAYSTATE_PLAYING) {
                audio.play();
            }
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
        outputRate = sourceRate;
        int min = AudioTrack.getMinBufferSize(outputRate, AudioFormat.CHANNEL_OUT_STEREO, AudioFormat.ENCODING_PCM_16BIT);
        if (min <= 0) {
            outputRate = 48000;
            min = AudioTrack.getMinBufferSize(outputRate, AudioFormat.CHANNEL_OUT_STEREO, AudioFormat.ENCODING_PCM_16BIT);
        }
        if (min <= 0) {
            return;
        }
        int bufferBytes = Math.max(min * 2, outputRate / 5 * 4);
        try {
            audio = new AudioTrack.Builder()
                    .setAudioAttributes(new AudioAttributes.Builder()
                            .setUsage(AudioAttributes.USAGE_GAME)
                            .setContentType(AudioAttributes.CONTENT_TYPE_MUSIC)
                            .build())
                    .setAudioFormat(new AudioFormat.Builder()
                            .setSampleRate(outputRate)
                            .setEncoding(AudioFormat.ENCODING_PCM_16BIT)
                            .setChannelMask(AudioFormat.CHANNEL_OUT_STEREO)
                            .build())
                    .setTransferMode(AudioTrack.MODE_STREAM)
                    .setBufferSizeInBytes(bufferBytes)
                    .build();
            if (!paused) {
                audio.play();
            }
        } catch (Exception e) {
            releaseAudio();
        }
    }

    private void syncFastAudio(int mult) {
        boolean fast = mult > 1;
        if (fast == fastAudio) {
            return;
        }
        fastAudio = fast;
        core.clearAudio();
        if (audio == null || audio.getState() != AudioTrack.STATE_INITIALIZED) {
            return;
        }
        if (fast) {
            audio.pause();
            audio.flush();
        } else if (!paused) {
            audio.play();
        }
    }

    private void pumpAudio() {
        if (audio == null) {
            core.readAudio(nativeAudio);
            return;
        }
        int frames = core.readAudio(nativeAudio);
        if (frames <= 0) {
            return;
        }
        short[] data = nativeAudio;
        int shorts = frames * 2;
        if (outputRate != sourceRate) {
            frames = resample(nativeAudio, frames, sourceRate, outputRate, outputAudio);
            data = outputAudio;
            shorts = frames * 2;
        }
        // One non-blocking write. Waiting on a full AudioTrack used to stall
        // the next frame for tens of milliseconds, so short taps never landed.
        audio.write(data, 0, shorts, AudioTrack.WRITE_NON_BLOCKING);
    }

    private int resample(short[] in, int inFrames, int inRate, int outRate, short[] out) {
        double step = (double) inRate / (double) outRate;
        int outFrames = 0;
        int max = out.length / 2;
        while (resamplePos < inFrames && outFrames < max) {
            int i0 = (int) resamplePos;
            if (i0 < 0) {
                i0 = 0;
            }
            int i1 = Math.min(i0 + 1, inFrames - 1);
            double frac = resamplePos - i0;
            int l0 = in[i0 * 2];
            int r0 = in[i0 * 2 + 1];
            int l1 = in[i1 * 2];
            int r1 = in[i1 * 2 + 1];
            out[outFrames * 2] = (short) (l0 + (l1 - l0) * frac);
            out[outFrames * 2 + 1] = (short) (r0 + (r1 - r0) * frac);
            outFrames++;
            resamplePos += step;
        }
        resamplePos -= inFrames;
        if (resamplePos < 0) {
            resamplePos = 0;
        }
        return outFrames;
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
        String path = core.saveFile();
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

    private int speedText(int value) {
        if (value == 4) {
            return R.string.speed_4;
        }
        if (value == 8) {
            return R.string.speed_8;
        }
        if (value == 16) {
            return R.string.speed_16;
        }
        return R.string.speed_1;
    }

    private void setPaused(boolean value) {
        paused = value;
        pauseButton.setText(value ? R.string.resume : R.string.pause);
        if (audio != null) {
            if (value) {
                audio.pause();
            } else if (audio.getState() == AudioTrack.STATE_INITIALIZED) {
                audio.play();
            }
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
            if (audio != null && audio.getState() == AudioTrack.STATE_INITIALIZED) {
                audio.play();
            }
        }
        hideSystemUi();
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
