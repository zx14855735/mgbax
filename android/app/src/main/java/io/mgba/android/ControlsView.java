/* This Source Code Form is subject to the terms of the Mozilla Public
 * License, v. 2.0. If a copy of the MPL was not distributed with this
 * file, You can obtain one at http://mozilla.org/MPL/2.0/. */
package io.mgba.android;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Shader;
import android.os.Build;
import android.util.AttributeSet;
import android.util.SparseIntArray;
import android.view.MotionEvent;
import android.view.View;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ControlsView extends View {
    public static final int A = 1 << 0;
    public static final int B = 1 << 1;
    public static final int SELECT = 1 << 2;
    public static final int START = 1 << 3;
    public static final int RIGHT = 1 << 4;
    public static final int LEFT = 1 << 5;
    public static final int UP = 1 << 6;
    public static final int DOWN = 1 << 7;
    public static final int R = 1 << 8;
    public static final int L = 1 << 9;

    /** Optional utility keys handled through {@link Listener#onAction}. */
    public static final int ACTION_SAVE = 1;
    public static final int ACTION_LOAD = 2;
    public static final int ACTION_SHOT = 3;
    public static final int ACTION_FF = 4;
    /** Toggle fast-forward on/off (the shell switch). */
    public static final int ACTION_FF_TOGGLE = 5;
    public static final int ACTION_MENU = 6;
    public static final int ACTION_MUTE = 7;
    /** The original rewind control: opens the seconds bar. */
    public static final int ACTION_REWIND = 8;
    /** Extra shortcut key: one tap rewinds a few seconds, no menu needed. */
    public static final int ACTION_REWIND_QUICK = 9;

    /** Seconds shown on the extra one-tap rewind key. */
    private int quickRewindSeconds = 2;

    /** Keeps the shortcut key's label in sync with the configured jump. */
    public void setQuickRewindSeconds(int seconds) {
        quickRewindSeconds = Math.max(1, Math.min(10, seconds));
        invalidate();
    }

    public interface Listener {
        void onKeysChanged(int mask);

        /** Fired after the on-screen keys were placed again (size or layout change). */
        default void onControlsLayout() {
        }

        /** A tap on one of the optional utility keys. */
        default void onAction(int action) {
        }

        /** The optional fast-forward key was pressed or released. */
        default void onFastHold(boolean down) {
        }
    }

    public interface EditListener {
        void onCursorMoved(String key, float nx, float ny);

        void onCursorStopped(String key, float nx, float ny);

        default void onScaleChanged(String key, float scale) {
        }

        default void onSelected(String key) {
        }
    }

    /** Button styles: the classic translucent outlines or the handheld shell. */
    public static final int STYLE_CLASSIC = 0;
    public static final int STYLE_HANDHELD = 1;

    private final Paint fill = new Paint(Paint.ANTI_ALIAS_FLAG);
    private final Paint stroke = new Paint(Paint.ANTI_ALIAS_FLAG);
    private final Paint text = new Paint(Paint.ANTI_ALIAS_FLAG);
    /** Opacity of the drawn keys in percent (100 = the stock translucency). */
    private int opacity = 100;
    private final Path arrow = new Path();
    private final RectF dpad = new RectF();
    private final RectF dpadUp = new RectF();
    private final RectF dpadDown = new RectF();
    private final RectF dpadLeft = new RectF();
    private final RectF dpadRight = new RectF();
    private final RectF buttonL = new RectF();
    private final RectF buttonR = new RectF();
    private final RectF buttonA = new RectF();
    private final RectF buttonB = new RectF();
    private final RectF buttonSelect = new RectF();
    private final RectF buttonStart = new RectF();
    private final RectF dpadDefault = new RectF();
    private final RectF buttonLDefault = new RectF();
    private final RectF buttonRDefault = new RectF();
    private final RectF buttonADefault = new RectF();
    private final RectF buttonBDefault = new RectF();
    private final RectF buttonSelectDefault = new RectF();
    private final RectF buttonStartDefault = new RectF();
    /* Optional utility keys: turbo A/B, L+R, C/C2 macros, quick save/load,
     * fast-forward, screenshot and one-tap rewind. Hidden until enabled,
     * except the rewind key which is on by default. */
    private final RectF keyTurboA = new RectF();
    private final RectF keyTurboB = new RectF();
    private final RectF keyLR = new RectF();
    private final RectF keyC = new RectF();
    private final RectF keyC2 = new RectF();
    private final RectF keySave = new RectF();
    private final RectF keyLoad = new RectF();
    private final RectF keyFast = new RectF();
    private final RectF keyShot = new RectF();
    private final RectF keyRewind = new RectF();
    private final RectF keyTurboADefault = new RectF();
    private final RectF keyTurboBDefault = new RectF();
    private final RectF keyLRDefault = new RectF();
    private final RectF keyCDefault = new RectF();
    private final RectF keyC2Default = new RectF();
    private final RectF keySaveDefault = new RectF();
    private final RectF keyLoadDefault = new RectF();
    private final RectF keyFastDefault = new RectF();
    private final RectF keyShotDefault = new RectF();
    private final RectF keyRewindDefault = new RectF();
    private final java.util.HashSet<String> visibleExtras = new java.util.HashSet<>();
    private final Map<String, float[]> centers = new HashMap<>();
    private final Map<String, Float> scales = new HashMap<>();
    /** Full PNG skin overlays: button key → bitmap, "_p" suffix = pressed. */
    private final Map<String, android.graphics.Bitmap> skinBitmaps = new HashMap<>();
    public static final float MIN_SCALE = 0.4f;
    public static final float MAX_SCALE = 3.0f;
    private final SparseIntArray pointers = new SparseIntArray();
    private Listener listener;
    private EditListener editListener;
    private boolean editing;
    private float density = 1f;
    private int pressed;
    private boolean turboB;
    private boolean turboLit;
    private float slopA;
    private float slopFace;
    private static final int FACE = A | B | SELECT | START | L | R;
    /** When true the d-pad reports only its dominant direction, no diagonals. */
    private boolean diagonalLock;
    /* Dedicated turbo keys pulse their bit at this many repeats per second. */
    private int turboRate = 25;
    private int pulseMask;
    private boolean pulseOn;
    private final android.os.Handler turboHandler = new android.os.Handler(android.os.Looper.getMainLooper());
    private final Runnable turboTick = new Runnable() {
        @Override
        public void run() {
            if (pulseMask == 0) {
                return;
            }
            pulseOn = !pulseOn;
            publish(computeMask());
            turboHandler.postDelayed(this, Math.max(20, 1000 / Math.max(1, turboRate)));
        }
    };
    /** Utility-key taps per pointer, so ACTION_FF release can be matched. */
    private final SparseIntArray actionPointers = new SparseIntArray();
    /** Macro keys C and C2 press this combination of console keys while held. */
    private int macroMaskC = A | B;
    private int macroMaskC2 = L | R;

    // == Handheld shell skin ==
    private int skinStyle = STYLE_CLASSIC;
    private SkinTheme skin = SkinTheme.PURPLE;
    private boolean portrait;
    private boolean ffOn;
    private boolean muted;
    /** Fixed chrome of the portrait shell: the icon toolbar and its buttons. */
    private final RectF toolbar = new RectF();
    private final RectF toolbarMenu = new RectF();
    private final RectF toolbarSave = new RectF();
    private final RectF toolbarLoad = new RectF();
    private final RectF toolbarMute = new RectF();
    private final RectF toolbarRewind = new RectF();
    private final RectF toggle = new RectF();
    /** Decorative speaker holes, recomputed per size. */
    private final RectF[] speakerDots = new RectF[15];

    /* Console-red key caps: a near-black ring, a red face, maroon lettering.
     * Every colour goes through fade(), so the keys keep the opacity
     * setting's translucency instead of becoming opaque stickers. */
    private static final int KEY_RING = 0xFF14100F;
    private static final int KEY_FACE_TOP = 0xFFCF3A40;
    private static final int KEY_FACE_BOT = 0xFF9C1F24;
    private static final int KEY_FACE_DIM = 0xFFB02C31;
    private static final int KEY_FACE_DEEP = 0xFF7C171B;
    private static final int KEY_INK = 0xFF671115;
    /** Deeper print ink for the word under the SELECT / START caps. */
    private static final int KEY_INK_DEEP = 0xFF3C0A0C;
    private static final int KEY_HUB = 0xFF8B1C21;
    private static final int KEY_HILIGHT = 0xFFFFFFFF;
    private static final int KEY_SHADOW = 0xFF000000;
    /** Scratch boxes/paths for the caps, so drawing allocates nothing. */
    private final RectF faceBox = new RectF();
    private final RectF capBox = new RectF();
    private final RectF rimOval = new RectF();
    private final Path crossPath = new Path();
    private final Path crossEdge = new Path();
    private final Paint capStroke = new Paint(Paint.ANTI_ALIAS_FLAG);
    private final Map<Long, Shader> shadeCache = new HashMap<>();

    public ControlsView(Context context) {
        this(context, null);
    }

    public ControlsView(Context context, AttributeSet attrs) {
        super(context, attrs);
        fill.setStyle(Paint.Style.FILL);
        stroke.setStyle(Paint.Style.STROKE);
        stroke.setStrokeWidth(2f);
        text.setTextAlign(Paint.Align.CENTER);
        text.setFakeBoldText(true);
        setClickable(true);
        setFocusable(false);
        setFocusableInTouchMode(false);
    }

    public void setListener(Listener listener) {
        this.listener = listener;
    }

    public void setEditListener(EditListener editListener) {
        this.editListener = editListener;
    }

    /** Selects the button drawing style and shell colors. */
    public void setSkin(int style, SkinTheme theme) {
        skinStyle = style;
        skin = theme == null ? SkinTheme.PURPLE : theme;
        computeDefaults();
        applyCenters();
        invalidate();
    }

    /** Replaces shell drawing with an imported PNG skin pack. */
    public void setFullSkin(Map<String, android.graphics.Bitmap> bitmaps) {
        skinBitmaps.clear();
        if (bitmaps != null) {
            for (Map.Entry<String, android.graphics.Bitmap> entry : bitmaps.entrySet()) {
                if (entry.getValue() != null && !entry.getValue().isRecycled()) {
                    skinBitmaps.put(entry.getKey(), entry.getValue());
                }
            }
        }
        invalidate();
    }

    /** Re-lays the stock keys for the current screen orientation. */
    public void setPortrait(boolean on) {
        if (portrait == on) {
            return;
        }
        portrait = on;
        computeDefaults();
        applyCenters();
        invalidate();
    }

    /** Shell switch state (fast-forward), drawn in the portrait shell. */
    public void setFastForwardOn(boolean on) {
        if (ffOn == on) {
            return;
        }
        ffOn = on;
        invalidate();
    }

    public void setMuted(boolean muted) {
        if (this.muted == muted) {
            return;
        }
        this.muted = muted;
        invalidate();
    }

    /** Which console keys each macro key (0 = C, 1 = C2) holds down. */
    public void setMacro(int index, int mask) {
        if (index == 0) {
            macroMaskC = mask;
        } else {
            macroMaskC2 = mask;
        }
        invalidate();
    }

    public int getMacro(int index) {
        return index == 0 ? macroMaskC : macroMaskC2;
    }

    public void setCenters(Map<String, float[]> next) {
        centers.clear();
        if (next != null) {
            for (Map.Entry<String, float[]> entry : next.entrySet()) {
                float[] point = entry.getValue();
                if (point != null && point.length >= 2) {
                    centers.put(entry.getKey(), new float[] {point[0], point[1]});
                }
            }
        }
        if (getWidth() > 0 && getHeight() > 0) {
            applyCenters();
            invalidate();
        }
    }

    public void setScales(Map<String, Float> next) {
        scales.clear();
        if (next != null) {
            for (Map.Entry<String, Float> entry : next.entrySet()) {
                if (entry.getValue() != null) {
                    scales.put(entry.getKey(), clampScale(entry.getValue()));
                }
            }
        }
        if (getWidth() > 0 && getHeight() > 0) {
            applyCenters();
            invalidate();
        }
    }

    public void setKeyScale(String key, float scale) {
        if (key == null) {
            return;
        }
        float clamped = clampScale(scale);
        if (Math.abs(clamped - 1f) < 0.001f) {
            scales.remove(key);
        } else {
            scales.put(key, clamped);
        }
        if (getWidth() > 0 && getHeight() > 0) {
            applyCenters();
            invalidate();
        }
    }

    public float getKeyScale(String key) {
        Float scale = scales.get(key);
        return scale == null ? 1f : scale;
    }

    private static float clampScale(float scale) {
        if (scale < MIN_SCALE) {
            return MIN_SCALE;
        }
        if (scale > MAX_SCALE) {
            return MAX_SCALE;
        }
        return scale;
    }

    public void setEditing(boolean editing) {
        this.editing = editing;
        dragKey = null;
        dragPointer = -1;
        pinchPointer = -1;
        pinchActive = false;
        releaseAllKeys();
        invalidate();
    }

    /**
     * Drops every tracked pointer and reports all keys up. A new gesture, a
     * focus change or a pause can lose the matching UP/CANCEL (a system edge
     * swipe, a notification shade or a dialog taking the touch stream), which
     * used to leave a key such as A logically held: later taps then changed
     * nothing and looked like the button had stopped working.
     */
    public void releaseAllKeys() {
        boolean fastHeld = actionPointers.indexOfValue(ACTION_FF) >= 0;
        pointers.clear();
        actionPointers.clear();
        turboHandler.removeCallbacks(turboTick);
        pulseMask = 0;
        pulseOn = false;
        if (fastHeld && listener != null) {
            listener.onFastHold(false);
        }
        if (pressed != 0) {
            pressed = 0;
            if (listener != null) {
                listener.onKeysChanged(0);
            }
        }
        invalidate();
    }

    public void setBTurbo(boolean active, boolean lit) {
        if (turboB == active && turboLit == lit) {
            return;
        }
        turboB = active;
        turboLit = lit;
        invalidate();
    }

    /**
     * True while the dedicated turbo-B on-screen key is held (pulsing B on its
     * own cadence). The hold-B auto-turbo must not also arm for this press, or
     * the two systems stack and fight over the B bit (see EmulatorActivity).
     */
    public boolean turboBPressed() {
        return (pulseMask & B) != 0;
    }

    /** Shows the optional utility keys named like "ta", "tb", "lr", "save"... */
    public void setVisibleExtras(java.util.Collection<String> keys) {
        visibleExtras.clear();
        if (keys != null) {
            visibleExtras.addAll(keys);
        }
        applyCenters();
        invalidate();
    }

    public java.util.Set<String> visibleExtras() {
        return visibleExtras;
    }

    /** One direction at a time on the d-pad. */
    public void setDiagonalLock(boolean enabled) {
        diagonalLock = enabled;
    }

    /** Repeats per second for the dedicated A/B turbo keys. */
    public void setTurboRate(int rate) {
        turboRate = Math.max(2, Math.min(30, rate));
    }

    /** Overall opacity of the on-screen keys, 30-150 percent. */
    public void setOpacity(int percent) {
        opacity = Math.max(30, Math.min(150, percent));
        invalidate();
    }

    /** Alpha for {@link Color#argb} scaled by the opacity setting. */
    private int fade(int alpha) {
        return Math.min(255, alpha * opacity / 100);
    }

    /** Alpha over a full color value, scaled by the opacity setting. */
    private int fade(int alpha, int color) {
        return (Math.min(255, alpha * opacity / 100) << 24) | (color & 0xFFFFFF);
    }

    /**
     * Top-to-bottom gradient for a key face, cached by box size and colour
     * pair. The keys redraw every frame and the same sizes recur (A and B,
     * the two shoulders), so this keeps the draw path allocation free.
     */
    private Shader verticalShade(RectF box, int top, int bottom) {
        long key = ((long) Math.round(box.width()) << 40)
                ^ ((long) Math.round(box.height()) << 20)
                ^ ((long) (top & 0xFFFFFF) << 2)
                ^ (bottom & 0xFFFFFF);
        Shader cached = shadeCache.get(key);
        if (cached == null) {
            if (shadeCache.size() > 24) {
                shadeCache.clear();
            }
            cached = new LinearGradient(box.left, box.top, box.left, box.bottom, top, bottom, Shader.TileMode.CLAMP);
            shadeCache.put(key, cached);
        }
        return cached;
    }

    private boolean handheld() {
        return skinStyle == STYLE_HANDHELD;
    }

    private boolean bDown() {
        return turboB ? turboLit : (pressed & B) != 0;
    }

    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        density = getResources().getDisplayMetrics().density;
        text.setTextSize(14 * density);
        stroke.setStrokeWidth(Math.max(2f, 1.5f * density));
        slopA = 18 * density;
        slopFace = 10 * density;
        computeDefaults();
        applyCenters();
    }

    /**
     * Rebuilds the stock key boxes for the current style and orientation. The
     * stored (normalized) centers from the layout editor then move each key
     * around its default.
     */
    private void computeDefaults() {
        int w = getWidth();
        int h = getHeight();
        if (w <= 0 || h <= 0) {
            return;
        }
        if (skinStyle == STYLE_CLASSIC) {
            computeClassicDefaults(w, h);
        } else if (portrait) {
            computePortraitShellDefaults(w, h);
        } else {
            computeLandscapeShellDefaults(w, h);
        }
    }

    /** The original outline-style layout, used by both orientations. */
    private void computeClassicDefaults(int w, int h) {
        float d = density;
        float pad = 10 * d;
        float menuW = 64 * d;
        float menuH = 32 * d;
        float center = w / 2f;
        float dpadRoom = center - menuW - 8 * d - pad - 6 * d;
        float dpadSize = Math.min(240 * d, Math.min(w, h) * 0.62f);
        dpadSize = Math.min(dpadSize, Math.max(48 * d, dpadRoom));
        dpadDefault.set(pad, h - pad - dpadSize, pad + dpadSize, h - pad);

        float shoulderW = 72 * d;
        float shoulderH = 36 * d;
        float shoulderTop = pad + 40 * d;
        buttonLDefault.set(pad, shoulderTop, pad + shoulderW, shoulderTop + shoulderH);
        buttonRDefault.set(w - pad - shoulderW, shoulderTop, w - pad, shoulderTop + shoulderH);

        float face = 58 * d;
        float faceA = 76 * d;
        buttonADefault.set(w - pad - faceA, h - pad - faceA, w - pad, h - pad);
        buttonBDefault.set(buttonADefault.left - face - 14 * d, buttonADefault.top - 36 * d,
                buttonADefault.left - 14 * d, buttonADefault.top - 36 * d + face);

        float menuTop = h - pad - menuH;
        buttonSelectDefault.set(center - menuW - 8 * d, menuTop, center - 8 * d, menuTop + menuH);
        buttonStartDefault.set(center + 8 * d, menuTop, center + 8 * d + menuW, menuTop + menuH);

        float utilW = 56 * d;
        float utilH = 34 * d;
        float utilTop = menuTop - utilH - 8 * d;
        keySaveDefault.set(buttonSelectDefault.left, utilTop, buttonSelectDefault.left + utilW, utilTop + utilH);
        keyLoadDefault.set(buttonStartDefault.right - utilW, utilTop, buttonStartDefault.right, utilTop + utilH);
        keyFastDefault.set(center - utilW / 2f, utilTop, center + utilW / 2f, utilTop + utilH);
        float lrTop = shoulderTop + shoulderH + 8 * d;
        keyLRDefault.set(center - utilW, lrTop, center + utilW, lrTop + utilH);
        keyShotDefault.set(center - utilW / 2f, lrTop + utilH + 8 * d, center + utilW / 2f, lrTop + 2 * utilH + 8 * d);
        keyRewindDefault.set(keyShotDefault.right + 8 * d, keyShotDefault.top,
                keyShotDefault.right + 8 * d + utilW, keyShotDefault.bottom);
        float turbo = 46 * d;
        keyTurboADefault.set(buttonADefault.left - 4 * d, buttonADefault.top - turbo - 6 * d,
                buttonADefault.left - 4 * d + turbo, buttonADefault.top - 6 * d);
        keyTurboBDefault.set(keyTurboADefault.left - turbo - 8 * d, keyTurboADefault.top + 10 * d,
                keyTurboADefault.left - 8 * d, keyTurboADefault.top + 10 * d + turbo);
        float cSize = 44 * d;
        keyCDefault.set(buttonBDefault.left - cSize - 10 * d, buttonBDefault.top, buttonBDefault.left - 10 * d, buttonBDefault.top + cSize);
        keyC2Default.set(buttonADefault.left, buttonADefault.top - cSize - 10 * d,
                buttonADefault.left + cSize, buttonADefault.top - 10 * d);
    }

    /**
     * Portrait shell (Pizza Boy style): a black icon toolbar between the L/R
     * pills, the fast-forward switch in the top right, a big white cross
     * d-pad at the lower left, round A/B keys at the right and the pill
     * SELECT/START pair at the bottom center.
     */
    private void computePortraitShellDefaults(int w, int h) {
        float fw = w / 100f;
        float fh = h / 100f;

        // Toolbar row: L ... toolbar ... R all on one line.
        float rowTop = 10.5f * fh;
        float rowH = 13 * fh;
        float pillW = 15 * fw;
        buttonLDefault.set(3 * fw, rowTop, 3 * fw + pillW, rowTop + rowH);
        buttonRDefault.set(w - 3 * fw - pillW, rowTop, w - 3 * fw, rowTop + rowH);
        float barW = 40 * fw;
        toolbar.set(50 * fw - barW / 2f, rowTop, 50 * fw + barW / 2f, rowTop + rowH);
        layoutToolbar();

        // Fast-forward switch, above the row at the right edge.
        toggle.set(w - 22 * fw, 0.6f * fh, w - 3 * fw, 0.6f * fh + 7.5f * fh);

        // D-pad: big cross at the lower left.
        float dpadSize = 46 * fw;
        float dLeft = 3 * fw;
        float dTop = 62 * fh - dpadSize / 2f;
        dpadDefault.set(dLeft, dTop, dLeft + dpadSize, dTop + dpadSize);

        // A/B round keys: A upper right, B lower left of it.
        float faceR = 13 * fw;
        float ax = 82 * fw;
        float ay = 47 * fh;
        buttonADefault.set(ax - faceR, ay - faceR, ax + faceR, ay + faceR);
        float bx = 66 * fw;
        float by = 76 * fh;
        buttonBDefault.set(bx - faceR, by - faceR, bx + faceR, by + faceR);

        // SELECT / START pills at the bottom center.
        float pillH = 7.5f * fh;
        float pillW2 = 17 * fw;
        float pillTop = 91.5f * fh - pillH / 2f;
        buttonSelectDefault.set(28 * fw - pillW2 / 2f, pillTop, 28 * fw + pillW2 / 2f, pillTop + pillH);
        buttonStartDefault.set(52 * fw - pillW2 / 2f, pillTop, 52 * fw + pillW2 / 2f, pillTop + pillH);

        // Optional utility keys: a small row under the toolbar; turbo keys
        // ride next to A/B; the C macro keys sit beside the face cluster.
        float utilW = 11 * fw;
        float utilH = 7 * fh;
        float utilTop = rowTop + rowH + 3 * fh;
        keySaveDefault.set(18 * fw, utilTop, 18 * fw + utilW, utilTop + utilH);
        keyLoadDefault.set(31 * fw, utilTop, 31 * fw + utilW, utilTop + utilH);
        keyFastDefault.set(44 * fw, utilTop, 44 * fw + utilW, utilTop + utilH);
        keyShotDefault.set(57 * fw, utilTop, 57 * fw + utilW, utilTop + utilH);
        keyLRDefault.set(70 * fw, utilTop, 70 * fw + utilW, utilTop + utilH);
        keyRewindDefault.set(83 * fw, utilTop, 83 * fw + utilW, utilTop + utilH);
        float turbo = 9 * fw;
        keyTurboADefault.set(buttonADefault.left - turbo - 2 * fw, buttonADefault.top + 2 * fh,
                buttonADefault.left - 2 * fw, buttonADefault.top + 2 * fh + turbo);
        keyTurboBDefault.set(buttonBDefault.left - turbo - 2 * fw, buttonBDefault.top - 2 * fh,
                buttonBDefault.left - 2 * fw, buttonBDefault.top - 2 * fh + turbo);
        float cSize = 9.5f * fw;
        keyCDefault.set(buttonBDefault.left - cSize - 3 * fw, buttonBDefault.centerY() - cSize / 2f,
                buttonBDefault.left - 3 * fw, buttonBDefault.centerY() + cSize / 2f);
        keyC2Default.set(buttonADefault.centerX() - cSize / 2f, buttonADefault.top - cSize - 2 * fh,
                buttonADefault.centerX() + cSize / 2f, buttonADefault.top - 2 * fh);
        layoutSpeakerPortrait(w, h);
        // The portrait shell starts smaller so thumbs wrap the keys without
        // covering them; the layout editor can scale each one up again.
        shrink(dpadDefault, 0.8f);
        shrink(buttonLDefault, 0.85f);
        shrink(buttonRDefault, 0.85f);
        shrink(buttonADefault, 0.8f);
        shrink(buttonBDefault, 0.8f);
        shrink(buttonSelectDefault, 0.8f);
        shrink(buttonStartDefault, 0.8f);
        shrink(keyTurboADefault, 0.8f);
        shrink(keyTurboBDefault, 0.8f);
        shrink(keyLRDefault, 0.8f);
        shrink(keyCDefault, 0.8f);
        shrink(keyC2Default, 0.8f);
        shrink(keySaveDefault, 0.8f);
        shrink(keyLoadDefault, 0.8f);
        shrink(keyFastDefault, 0.8f);
        shrink(keyShotDefault, 0.8f);
        shrink(keyRewindDefault, 0.8f);
    }

    /** Landscape shell (GBA hardware style): d-pad left, A/B right, slanted
     * SELECT/START pills near the screen, speaker slots at the lower right. */
    private void computeLandscapeShellDefaults(int w, int h) {
        float fw = w / 100f;
        float fh = h / 100f;

        float dpadSize = 26 * fh;
        float dLeft = 5 * fw;
        float dTop = 56 * fh - dpadSize / 2f;
        dpadDefault.set(dLeft, dTop, dLeft + dpadSize, dTop + dpadSize);

        float faceR = 9.5f * fh;
        float ax = 88 * fw;
        float ay = 40 * fh;
        buttonADefault.set(ax - faceR, ay - faceR, ax + faceR, ay + faceR);
        float bx = 80 * fw;
        float by = 72 * fh;
        buttonBDefault.set(bx - faceR, by - faceR, bx + faceR, by + faceR);

        // START/SELECT: small pills angled like the real console, below the
        // screen between d-pad and A/B. The boxes stay axis-aligned; only
        // the drawing is rotated.
        float pillW = 11 * fw;
        float pillH = 6.5f * fh;
        buttonStartDefault.set(30 * fw - pillW / 2f, 76 * fh - pillH / 2f, 30 * fw + pillW / 2f, 76 * fh + pillH / 2f);
        buttonSelectDefault.set(30 * fw - pillW / 2f - 1 * fw, 87 * fh - pillH / 2f,
                30 * fw + pillW / 2f - 1 * fw, 87 * fh + pillH / 2f);

        // Shoulders sit below the floating menu bar's two rows (button row
        // plus the save-path strip), so opening the menu cannot cover them.
        float shoulderW = 72 * density;
        float shoulderH = 36 * density;
        float shoulderTop = 78 * density;
        buttonLDefault.set(2 * density, shoulderTop, 2 * density + shoulderW, shoulderTop + shoulderH);
        buttonRDefault.set(w - 2 * density - shoulderW, shoulderTop, w - 2 * density, shoulderTop + shoulderH);

        // Utility keys tuck into the free space below the shoulders.
        float utilW = 9 * fw;
        float utilH = 8.5f * fh;
        float utilTop = 12 * fh;
        keySaveDefault.set(40 * fw, utilTop, 40 * fw + utilW, utilTop + utilH);
        keyLoadDefault.set(50 * fw, utilTop, 50 * fw + utilW, utilTop + utilH);
        keyFastDefault.set(60 * fw, utilTop, 60 * fw + utilW, utilTop + utilH);
        keyShotDefault.set(70 * fw, utilTop, 70 * fw + utilW, utilTop + utilH);
        keyRewindDefault.set(81 * fw, utilTop, 81 * fw + utilW, utilTop + utilH);
        keyLRDefault.set(45 * fw, 82 * fh, 45 * fw + utilW + 6 * fw, 82 * fh + utilH);
        keyTurboADefault.set(buttonADefault.left - utilW - 1.5f * fw, buttonADefault.top,
                buttonADefault.left - 1.5f * fw, buttonADefault.top + utilH);
        keyTurboBDefault.set(buttonBDefault.left - utilW - 1.5f * fw, buttonBDefault.top,
                buttonBDefault.left - 1.5f * fw, buttonBDefault.top + utilH);
        float cSize = 7 * fh;
        keyCDefault.set(buttonBDefault.left - cSize - 2 * fw, buttonBDefault.centerY() - cSize / 2f,
                buttonBDefault.left - 2 * fw, buttonBDefault.centerY() + cSize / 2f);
        keyC2Default.set(buttonADefault.centerX() - cSize / 2f, buttonADefault.top - cSize - 2 * fh,
                buttonADefault.centerX() + cSize / 2f, buttonADefault.top - 2 * fh);
        // On-screen toolbar (menu/save/load/mute/rewind) is shell chrome in both
        // orientations; lay it out along the top center so the rewind (and the
        // other chrome buttons) are reachable without opening the menu.
        float tBarW = 52 * fw;
        float tRowTop = 1.5f * fh;
        float tRowH = 6 * fh;
        toolbar.set(50 * fw - tBarW / 2f, tRowTop, 50 * fw + tBarW / 2f, tRowTop + tRowH);
        layoutToolbar();
        layoutSpeakerLandscape(w, h);
    }

    /** Scales a default key box around its center. */
    private static void shrink(RectF rect, float factor) {
        float cx = rect.centerX();
        float cy = rect.centerY();
        rect.set(cx - rect.width() * factor / 2f, cy - rect.height() * factor / 2f,
                cx + rect.width() * factor / 2f, cy + rect.height() * factor / 2f);
    }

    private void layoutToolbar() {
        float pad = 2.5f * density;
        float inner = toolbar.width() - pad * 2;
        float cell = inner / 5f;
        toolbarMenu.set(toolbar.left + pad, toolbar.top + pad, toolbar.left + pad + cell, toolbar.bottom - pad);
        toolbarSave.set(toolbarMenu.right, toolbar.top + pad, toolbarMenu.right + cell, toolbar.bottom - pad);
        toolbarLoad.set(toolbarSave.right, toolbar.top + pad, toolbarSave.right + cell, toolbar.bottom - pad);
        toolbarMute.set(toolbarLoad.right, toolbar.top + pad, toolbarLoad.right + cell, toolbar.bottom - pad);
        toolbarRewind.set(toolbarMute.right, toolbar.top + pad, toolbar.right - pad, toolbar.bottom - pad);
    }

    private void layoutSpeakerPortrait(int w, int h) {
        int i = 0;
        float cols = 5;
        float rows = 3;
        float cell = 2.6f * density;
        float gap = 1.9f * density;
        float gridW = cols * cell + (cols - 1) * gap;
        float gridH = rows * cell + (rows - 1) * gap;
        float x0 = w - gridW - 4.5f * density;
        float y0 = h - gridH - 3.5f * density;
        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                float x = x0 + c * (cell + gap);
                float y = y0 + r * (cell + gap);
                speakerDots[i++] = new RectF(x, y, x + cell, y + cell);
            }
        }
    }

    private void layoutSpeakerLandscape(int w, int h) {
        int i = 0;
        float slots = 6;
        float len = 7 * density;
        float thick = 1.6f * density;
        float gap = 3.2f * density;
        float x0 = w - 9 * density - len;
        float y0 = h - (slots * gap + 4 * density);
        for (int s = 0; s < slots; s++) {
            float y = y0 + s * gap;
            speakerDots[i++] = new RectF(x0, y, x0 + len, y + thick);
        }
    }

    @Override
    protected void onDraw(Canvas canvas) {
        boolean shell = handheld();
        if (shell && !editing && toolbar.width() > 0) {
            drawToolbar(canvas);
        }
        if (shell && portrait && !editing && toggle.width() > 0) {
            drawToggle(canvas);
        }
        drawKey(canvas, buttonL, "L", (pressed & L) != 0, editing, false);
        drawKey(canvas, buttonR, "R", (pressed & R) != 0, editing, false);
        drawKey(canvas, buttonA, "A", (pressed & A) != 0, editing, true);
        drawKey(canvas, buttonB, "B", bDown(), editing, true);
        drawKey(canvas, buttonSelect, "SELECT", (pressed & SELECT) != 0, editing, false);
        drawKey(canvas, buttonStart, "START", (pressed & START) != 0, editing, false);
        drawDpad(canvas);
        if (shell && portrait) {
            drawSpeaker(canvas);
        } else if (shell) {
            drawSpeakerSlots(canvas);
        }
        if (visibleExtras.contains("ta")) {
            drawKey(canvas, keyTurboA, "A连", (pressed & A) != 0 && pulseOn, editing, true);
        }
        if (visibleExtras.contains("tb")) {
            drawKey(canvas, keyTurboB, "B连", (pressed & B) != 0 && pulseOn, editing, true);
        }
        if (visibleExtras.contains("lr")) {
            drawKey(canvas, keyLR, "L+R", (pressed & (L | R)) == (L | R), editing, false);
        }
        if (visibleExtras.contains("c")) {
            drawKey(canvas, keyC, "C", (pressed & macroMaskC) == macroMaskC && macroMaskC != 0, editing, true);
        }
        if (visibleExtras.contains("c2")) {
            drawKey(canvas, keyC2, "C2", (pressed & macroMaskC2) == macroMaskC2 && macroMaskC2 != 0, editing, true);
        }
        if (visibleExtras.contains("save")) {
            drawKey(canvas, keySave, "快存", actionPointers.indexOfValue(ACTION_SAVE) >= 0, editing, false);
        }
        if (visibleExtras.contains("load")) {
            drawKey(canvas, keyLoad, "快读", actionPointers.indexOfValue(ACTION_LOAD) >= 0, editing, false);
        }
        if (visibleExtras.contains("ff")) {
            drawKey(canvas, keyFast, "倍速", actionPointers.indexOfValue(ACTION_FF) >= 0, editing, false);
        }
        if (visibleExtras.contains("shot")) {
            drawKey(canvas, keyShot, "截图", actionPointers.indexOfValue(ACTION_SHOT) >= 0, editing, false);
        }
        if (visibleExtras.contains("rewind")) {
            drawKey(canvas, keyRewind, "倒带" + quickRewindSeconds + "s",
                    actionPointers.indexOfValue(ACTION_REWIND_QUICK) >= 0, editing, false);
        }
    }

    private void drawKey(Canvas canvas, RectF rect, String label, boolean down, boolean selected, boolean round) {
        if (handheld()) {
            drawShellKey(canvas, rect, label, down, selected, round);
            return;
        }
        drawClassicKey(canvas, rect, label, down, selected);
    }

    private void drawClassicKey(Canvas canvas, RectF rect, String label, boolean down, boolean selected) {
        if (down) {
            fill.setColor(Color.argb(fade(70), 80, 210, 130));
            canvas.drawRoundRect(rect, 12, 12, fill);
        }
        stroke.setColor(selected ? Color.argb(fade(230), 255, 214, 64) : down ? Color.argb(fade(210), 120, 230, 160) : Color.argb(fade(140), 255, 255, 255));
        canvas.drawRoundRect(rect, 12, 12, stroke);
        text.setColor(down || selected ? Color.argb(fade(230), 255, 255, 255) : Color.argb(fade(180), 255, 255, 255));
        canvas.drawText(label, rect.centerX(), rect.centerY() - (text.descent() + text.ascent()) / 2f, text);
        if (selected) {
            drawCursor(canvas, rect);
        }
    }

    /** Shell button: a red cap in a dark ring with maroon lettering. The cap
     * keeps the opacity control's translucency, so the shell shows through. */
    private void drawShellKey(Canvas canvas, RectF rect, String label, boolean down, boolean selected, boolean round) {
        String key = labelToKey(label);
        if (key != null && skinBitmaps.containsKey(down ? key + "_p" : key)) {
            drawBitmapKey(canvas, rect, skinBitmaps.get(down ? key + "_p" : key));
        } else if (key != null && skinBitmaps.containsKey(key)) {
            drawBitmapKey(canvas, rect, skinBitmaps.get(key));
            if (down) {
                fill.setColor(Color.argb(fade(110), skin.accentDeep >> 16 & 0xFF, skin.accentDeep >> 8 & 0xFF, skin.accentDeep & 0xFF));
                if (round) {
                    canvas.drawCircle(rect.centerX(), rect.centerY(), Math.min(rect.width(), rect.height()) / 2f, fill);
                } else {
                    canvas.drawRoundRect(rect, rect.height() / 2.4f, rect.height() / 2.4f, fill);
                }
            }
        } else {
            drawShellButton(canvas, rect, label, down, selected, round);
        }
        if (selected) {
            drawCursor(canvas, rect);
        }
    }

    /**
     * One key cap: a soft drop shadow, the dark ring, the red face with a top
     * highlight and an inner rim light, then the letter. Pressing darkens the
     * face and pulls it inside the ring, so the cap reads as sunk.
     */
    private void drawShellButton(Canvas canvas, RectF rect, String label, boolean down, boolean selected, boolean round) {
        // SELECT / START print their word under a small cap, as on the
        // reference faceplate. In landscape those two pills land on the black
        // screen plate, where a dark word would vanish, so they keep it inside.
        boolean underText = portrait && ("SELECT".equals(label) || "START".equals(label));
        faceBox.set(rect);
        if (underText) {
            faceBox.bottom = rect.top + rect.height() * 0.64f;
        }
        float shortSide = Math.min(faceBox.width(), faceBox.height());
        boolean circle = round;
        float radius = circle ? shortSide / 2f : Math.min(faceBox.height() / 2f, faceBox.width() / 2f);
        // L / R read as rounded tabs on the faceplate; the small SELECT /
        // START caps keep the full pill curve.
        if (!circle && ("L".equals(label) || "R".equals(label))) {
            radius = faceBox.height() * 0.34f;
        }
        float ring = Math.max(1.3f * density, shortSide * 0.055f);

        // Released caps sit a hair above the shell: a soft shadow below them.
        if (!down) {
            fill.setShader(null);
            fill.setColor(fade(55, KEY_SHADOW));
            if (circle) {
                canvas.drawCircle(faceBox.centerX(), faceBox.centerY() + ring * 0.8f, radius, fill);
            } else {
                canvas.save();
                canvas.translate(0, ring * 0.8f);
                canvas.drawRoundRect(faceBox, radius, radius, fill);
                canvas.restore();
            }
        }

        // Dark ring around the cap.
        fill.setShader(null);
        fill.setColor(fade(225, KEY_RING));
        if (circle) {
            canvas.drawCircle(faceBox.centerX(), faceBox.centerY(), radius, fill);
        } else {
            canvas.drawRoundRect(faceBox, radius, radius, fill);
        }

        // Red face; a pressed cap shrinks a little inside its ring.
        float inset = down ? ring * 1.7f : ring;
        capBox.set(faceBox.left + inset, faceBox.top + inset, faceBox.right - inset, faceBox.bottom - inset);
        float faceRadius = Math.max(1f, radius - inset);
        fill.setShader(verticalShade(capBox,
                fade(226, down ? KEY_FACE_DIM : KEY_FACE_TOP),
                fade(226, down ? KEY_FACE_DEEP : KEY_FACE_BOT)));
        if (circle) {
            canvas.drawCircle(capBox.centerX(), capBox.centerY(), faceRadius, fill);
        } else {
            canvas.drawRoundRect(capBox, faceRadius, faceRadius, fill);
        }
        fill.setShader(null);

        // Rim light along the top inner edge, shadow along the bottom; the
        // pair is what makes the flat fill read as a moulded cap.
        capStroke.setStyle(Paint.Style.STROKE);
        capStroke.setStrokeWidth(Math.max(1f, ring * 0.85f));
        rimOval.set(capBox);
        rimOval.inset(capStroke.getStrokeWidth() / 2f, capStroke.getStrokeWidth() / 2f);
        float rimRadius = Math.max(1f, faceRadius - capStroke.getStrokeWidth() / 2f);
        if (circle) {
            capStroke.setColor(fade(down ? 22 : 44, KEY_HILIGHT));
            canvas.drawArc(rimOval, 190, 160, false, capStroke);
            capStroke.setColor(fade(40, KEY_SHADOW));
            canvas.drawArc(rimOval, 20, 140, false, capStroke);
        } else {
            capStroke.setColor(fade(down ? 22 : 44, KEY_HILIGHT));
            canvas.drawRoundRect(rimOval, rimRadius, rimRadius, capStroke);
        }

        // Outline again while the player is dragging this key around.
        if (selected) {
            stroke.setColor(Color.argb(240, 255, 214, 64));
            stroke.setStrokeWidth(Math.max(2.5f, 2f * density));
            if (circle) {
                canvas.drawCircle(faceBox.centerX(), faceBox.centerY(), radius - stroke.getStrokeWidth() / 2f, stroke);
            } else {
                canvas.drawRoundRect(faceBox, radius, radius, stroke);
            }
            stroke.setStrokeWidth(Math.max(2f, 1.5f * density));
        }

        if (underText) {
            // Word under the cap, matched to the key's own box.
            float labelH = rect.bottom - faceBox.bottom;
            drawCapText(canvas, label, rect.centerX(), faceBox.bottom + labelH * 0.62f,
                    rect.width() * 0.96f, labelH * 1.0f, KEY_INK_DEEP, 250);
        } else {
            drawCapText(canvas, label, capBox.centerX(), capBox.centerY(),
                    capBox.width() * 0.66f, capBox.height() * 0.86f, KEY_INK, down ? 240 : 225);
        }
    }

    /** Draws a key label, shrunk until it fits the box it was given. */
    private void drawCapText(Canvas canvas, String label, float cx, float cy,
                             float maxW, float maxH, int ink, int alpha) {
        float size = maxH * 0.72f;
        text.setTextSize(size);
        float wide = text.measureText(label);
        if (wide > maxW && wide > 0f) {
            text.setTextSize(size * maxW / wide);
        }
        text.setColor(fade(alpha, ink));
        canvas.drawText(label, cx, cy - (text.descent() + text.ascent()) / 2f, text);
    }

    private void drawBitmapKey(Canvas canvas, RectF rect, android.graphics.Bitmap bitmap) {
        fill.setAlpha(255);
        canvas.drawBitmap(bitmap, null, rect, fill);
    }

    /** Maps a drawn label to its skin-pack key, or null for utility keys. */
    private static String labelToKey(String label) {
        if ("A".equals(label)) {
            return "a";
        }
        if ("B".equals(label)) {
            return "b";
        }
        if ("L".equals(label)) {
            return "l";
        }
        if ("R".equals(label)) {
            return "r";
        }
        if ("SELECT".equals(label)) {
            return "select";
        }
        if ("START".equals(label)) {
            return "start";
        }
        return null;
    }

    private void drawDpad(Canvas canvas) {
        if (dpad.width() <= 0f) {
            return;
        }
        if (handheld()) {
            drawShellDpad(canvas);
            return;
        }
        drawDirection(canvas, dpadUp, UP);
        drawDirection(canvas, dpadDown, DOWN);
        drawDirection(canvas, dpadLeft, LEFT);
        drawDirection(canvas, dpadRight, RIGHT);
        if (editing) {
            drawCursor(canvas, dpad);
        }
    }

    /**
     * Red cross in a dark ring, with a recessed hub and a maroon arrow in each
     * arm. The two bars go into one path so the translucent red is filled
     * once and the overlap at the centre never doubles up into a dark square.
     */
    private void drawShellDpad(Canvas canvas) {
        layoutDpadArms();
        android.graphics.Bitmap dpadBitmap = skinBitmaps.containsKey("dpad") ? skinBitmaps.get("dpad") : null;
        if (dpadBitmap != null && !dpadBitmap.isRecycled()) {
            drawBitmapKey(canvas, dpad, dpadBitmap);
            drawArmGlow(canvas, dpadUp, UP, 0);
            drawArmGlow(canvas, dpadDown, DOWN, 0);
            drawArmGlow(canvas, dpadLeft, LEFT, 0);
            drawArmGlow(canvas, dpadRight, RIGHT, 0);
            if (editing) {
                drawCursor(canvas, dpad);
            }
            return;
        }
        float thick = dpadUp.width();
        float r = thick * 0.34f;
        float ring = Math.max(1.4f * density, dpad.width() * 0.022f);
        RectF bar = new RectF(dpad.left, dpad.centerY() - thick / 2f,
                dpad.right, dpad.centerY() + thick / 2f);
        RectF barV = new RectF(dpad.centerX() - thick / 2f, dpad.top,
                dpad.centerX() + thick / 2f, dpad.bottom);

        // Soft shadow under the whole cross.
        fill.setShader(null);
        fill.setColor(fade(55, KEY_SHADOW));
        canvas.save();
        canvas.translate(0, ring * 0.9f);
        canvas.drawRoundRect(bar, r, r, fill);
        canvas.drawRoundRect(barV, r, r, fill);
        canvas.restore();

        // Dark ring: both bars grown by the ring width, filled as one path.
        crossEdge.reset();
        crossEdge.addRoundRect(new RectF(bar.left - ring, bar.top - ring, bar.right + ring, bar.bottom + ring),
                r + ring, r + ring, Path.Direction.CW);
        crossEdge.addRoundRect(new RectF(barV.left - ring, barV.top - ring, barV.right + ring, barV.bottom + ring),
                r + ring, r + ring, Path.Direction.CW);
        fill.setColor(fade(225, KEY_RING));
        canvas.drawPath(crossEdge, fill);

        // Red face.
        crossPath.reset();
        crossPath.addRoundRect(bar, r, r, Path.Direction.CW);
        crossPath.addRoundRect(barV, r, r, Path.Direction.CW);
        fill.setShader(verticalShade(dpad, fade(226, KEY_FACE_TOP), fade(226, KEY_FACE_BOT)));
        canvas.drawPath(crossPath, fill);
        fill.setShader(null);

        // A pressed arm darkens inside the face outline.
        if ((pressed & (UP | DOWN | LEFT | RIGHT)) != 0) {
            canvas.save();
            canvas.clipPath(crossPath);
            fill.setColor(fade(70, KEY_SHADOW));
            if ((pressed & UP) != 0) {
                canvas.drawRect(dpad.left, dpad.top, dpad.right, dpad.centerY(), fill);
            }
            if ((pressed & DOWN) != 0) {
                canvas.drawRect(dpad.left, dpad.centerY(), dpad.right, dpad.bottom, fill);
            }
            if ((pressed & LEFT) != 0) {
                canvas.drawRect(dpad.left, dpad.top, dpad.centerX(), dpad.bottom, fill);
            }
            if ((pressed & RIGHT) != 0) {
                canvas.drawRect(dpad.centerX(), dpad.top, dpad.right, dpad.bottom, fill);
            }
            canvas.restore();
        }

        // Recessed hub: one darker disc, with a faint shadow on its upper edge.
        fill.setColor(fade(205, KEY_HUB));
        canvas.drawCircle(dpad.centerX(), dpad.centerY(), thick * 0.44f, fill);
        capStroke.setStyle(Paint.Style.STROKE);
        capStroke.setStrokeWidth(Math.max(1f, thick * 0.05f));
        rimOval.set(dpad.centerX() - thick * 0.44f, dpad.centerY() - thick * 0.44f,
                dpad.centerX() + thick * 0.44f, dpad.centerY() + thick * 0.44f);
        rimOval.inset(capStroke.getStrokeWidth() / 2f, capStroke.getStrokeWidth() / 2f);
        capStroke.setColor(fade(50, KEY_SHADOW));
        canvas.drawArc(rimOval, 200, 140, false, capStroke);

        // Arrows: maroon triangles pointing out of each arm.
        drawCapArrow(canvas, dpadUp, UP, thick);
        drawCapArrow(canvas, dpadDown, DOWN, thick);
        drawCapArrow(canvas, dpadLeft, LEFT, thick);
        drawCapArrow(canvas, dpadRight, RIGHT, thick);
        if (editing) {
            drawCursor(canvas, dpad);
        }
    }

    /** Filled maroon triangle inside one d-pad arm. */
    private void drawCapArrow(Canvas canvas, RectF arm, int bit, float thick) {
        float cx = arm.centerX();
        float cy = arm.centerY();
        float half = thick * 0.25f;
        float tall = thick * 0.20f;
        arrow.reset();
        if (bit == UP) {
            arrow.moveTo(cx, cy - tall);
            arrow.lineTo(cx + half, cy + tall);
            arrow.lineTo(cx - half, cy + tall);
        } else if (bit == DOWN) {
            arrow.moveTo(cx, cy + tall);
            arrow.lineTo(cx + half, cy - tall);
            arrow.lineTo(cx - half, cy - tall);
        } else if (bit == LEFT) {
            arrow.moveTo(cx - tall, cy);
            arrow.lineTo(cx + tall, cy - half);
            arrow.lineTo(cx + tall, cy + half);
        } else {
            arrow.moveTo(cx + tall, cy);
            arrow.lineTo(cx - tall, cy - half);
            arrow.lineTo(cx - tall, cy + half);
        }
        arrow.close();
        fill.setShader(null);
        fill.setColor(fade((pressed & bit) != 0 ? 235 : 200, KEY_INK));
        canvas.drawPath(arrow, fill);
    }

    private void drawArmGlow(Canvas canvas, RectF arm, int bit, float r) {
        if ((pressed & bit) == 0) {
            return;
        }
        fill.setColor(Color.argb(fade(120), skin.accentDeep >> 16 & 0xFF, skin.accentDeep >> 8 & 0xFF, skin.accentDeep & 0xFF));
        canvas.drawRoundRect(arm, r * 0.8f, r * 0.8f, fill);
    }

    private void drawDirection(Canvas canvas, RectF rect, int bit) {
        if (rect.width() <= 0f) {
            return;
        }
        boolean down = (pressed & bit) != 0;
        float radius = 8f * density;
        if (down) {
            fill.setColor(Color.argb(fade(90), 80, 210, 130));
            canvas.drawRoundRect(rect, radius, radius, fill);
        }
        stroke.setColor(editing ? Color.argb(fade(230), 255, 214, 64) : down ? Color.argb(fade(220), 120, 230, 160) : Color.argb(fade(170), 255, 255, 255));
        canvas.drawRoundRect(rect, radius, radius, stroke);
        drawArrow(canvas, rect, bit, down);
    }

    private void drawArrow(Canvas canvas, RectF rect, int bit, boolean down) {
        float cx = rect.centerX();
        float cy = rect.centerY();
        float a = Math.min(rect.width(), rect.height()) * 0.36f;
        arrow.reset();
        if (bit == UP) {
            arrow.moveTo(cx, cy - a);
            arrow.lineTo(cx + a * 0.92f, cy + a * 0.7f);
            arrow.lineTo(cx - a * 0.92f, cy + a * 0.7f);
        } else if (bit == DOWN) {
            arrow.moveTo(cx, cy + a);
            arrow.lineTo(cx + a * 0.92f, cy - a * 0.7f);
            arrow.lineTo(cx - a * 0.92f, cy - a * 0.7f);
        } else if (bit == LEFT) {
            arrow.moveTo(cx - a, cy);
            arrow.lineTo(cx + a * 0.7f, cy - a * 0.92f);
            arrow.lineTo(cx + a * 0.7f, cy + a * 0.92f);
        } else {
            arrow.moveTo(cx + a, cy);
            arrow.lineTo(cx - a * 0.7f, cy - a * 0.92f);
            arrow.lineTo(cx - a * 0.7f, cy + a * 0.92f);
        }
        arrow.close();
        fill.setColor(down ? Color.argb(fade(245), 255, 255, 255) : Color.argb(fade(210), 255, 255, 255));
        canvas.drawPath(arrow, fill);
    }

    private void drawToolbar(Canvas canvas) {
        fill.setColor(Color.argb(fade(236), 12, 12, 14));
        canvas.drawRoundRect(toolbar, toolbar.height() / 2f, toolbar.height() / 2f, fill);
        drawToolbarButton(canvas, toolbarMenu, "☰", ACTION_MENU);
        drawToolbarButton(canvas, toolbarSave, "存", ACTION_SAVE);
        drawToolbarButton(canvas, toolbarLoad, "读", ACTION_LOAD);
        drawToolbarButton(canvas, toolbarMute, muted ? "🔇" : "♪", ACTION_MUTE);
        drawToolbarButton(canvas, toolbarRewind, "⏪", ACTION_REWIND);
    }

    private void drawToolbarButton(Canvas canvas, RectF cell, String icon, int action) {
        if (actionPointers.indexOfValue(action) >= 0) {
            fill.setColor(Color.argb(200, skin.accentDeep >> 16 & 0xFF, skin.accentDeep >> 8 & 0xFF, skin.accentDeep & 0xFF));
            canvas.drawCircle(cell.centerX(), cell.centerY(), Math.min(cell.width(), cell.height()) * 0.42f, fill);
        }
        text.setTextSize(13 * density);
        text.setColor(Color.argb(fade(235), 255, 255, 255));
        canvas.drawText(icon, cell.centerX(), cell.centerY() - (text.descent() + text.ascent()) / 2f, text);
    }

    /** Fast-forward switch: green when held on, gray when off. */
    private void drawToggle(Canvas canvas) {
        float r = toggle.height() / 2f;
        fill.setColor(ffOn ? Color.argb(fade(255), 61, 220, 132) : Color.argb(fade(210), 70, 70, 76));
        canvas.drawRoundRect(toggle, r, r, fill);
        float knob = toggle.height() * 0.86f;
        float kx = ffOn ? toggle.right - knob / 2f - 2 * density : toggle.left + knob / 2f + 2 * density;
        fill.setColor(Color.argb(250, 255, 255, 255));
        canvas.drawCircle(kx, toggle.centerY(), knob / 2f, fill);
        if (ffOn) {
            text.setTextSize(9 * density);
            text.setColor(Color.argb(230, 30, 90, 50));
            canvas.drawText("FF", toggle.centerX() - toggle.width() * 0.12f, toggle.centerY() - (text.descent() + text.ascent()) / 2f, text);
        }
    }

    private void drawSpeaker(Canvas canvas) {
        fill.setColor(fade(255, skin.speaker));
        for (RectF dot : speakerDots) {
            if (dot != null) {
                canvas.drawCircle(dot.centerX(), dot.centerY(), dot.width() / 2f, fill);
            }
        }
    }

    private void drawSpeakerSlots(Canvas canvas) {
        fill.setColor(fade(255, skin.speaker));
        for (RectF slot : speakerDots) {
            if (slot != null) {
                canvas.drawRoundRect(slot, slot.height() / 2f, slot.height() / 2f, fill);
            }
        }
    }

    /** Internal markers for the extra keys; not part of the key mask. */
    private static final int FLAG_TURBO_A = 1 << 20;
    private static final int FLAG_TURBO_B = 1 << 21;
    private static final int FLAG_LR = 1 << 22;
    private static final int FLAG_C = 1 << 23;
    private static final int FLAG_C2 = 1 << 24;

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        if (editing) {
            return editTouch(event);
        }
        int action = event.getActionMasked();
        // Ask for unbuffered dispatch on EVERY finger that lands, not just the
        // first. Without this, a second finger (e.g. the A button pressed while
        // the d-pad is already held) gets its down event batched/coalesced by
        // the system and is delayed or dropped - the key then feels like it
        // "sometimes doesn't respond".
        if (action == MotionEvent.ACTION_DOWN || action == MotionEvent.ACTION_POINTER_DOWN) {
            requestUnbufferedDispatch(event);
            // Keep a parent (menu hover, future overlay) from stealing the rest
            // of this gesture after the first key went down.
            if (getParent() != null) {
                getParent().requestDisallowInterceptTouchEvent(true);
            }
        }
        int index = event.getActionIndex();
        int id = event.getPointerId(index);
        switch (action) {
            case MotionEvent.ACTION_DOWN: {
                // ACTION_DOWN always starts a new gesture. Any pointer still
                // tracked here is left over from an UP/CANCEL that never
                // arrived; drop it first so a stuck A (or any other key) cannot
                // swallow the new press.
                releaseAllKeys();
                float x = event.getX(index);
                float y = event.getY(index);
                int utility = actionAt(x, y);
                if (utility != 0) {
                    actionPointers.put(id, utility);
                    if (utility == ACTION_FF && listener != null) {
                        listener.onFastHold(true);
                    } else if (listener != null) {
                        listener.onAction(utility);
                    }
                    invalidate();
                    break;
                }
                pointers.put(id, hitTest(x, y));
                break;
            }
            case MotionEvent.ACTION_POINTER_DOWN: {
                float x = event.getX(index);
                float y = event.getY(index);
                int utility = actionAt(x, y);
                if (utility != 0) {
                    actionPointers.put(id, utility);
                    if (utility == ACTION_FF && listener != null) {
                        listener.onFastHold(true);
                    } else if (listener != null) {
                        listener.onAction(utility);
                    }
                    invalidate();
                    break;
                }
                pointers.put(id, hitTest(x, y));
                break;
            }
            case MotionEvent.ACTION_MOVE:
                for (int i = 0; i < event.getPointerCount(); i++) {
                    int pointerId = event.getPointerId(i);
                    if (pointers.indexOfKey(pointerId) < 0
                            && actionPointers.indexOfKey(pointerId) < 0) {
                        // A POINTER_DOWN can be batched away by the system. If
                        // the pointer shows up in MOVE instead, adopt it now so
                        // a second finger (typically A while the d-pad is held)
                        // does not have to be lifted and pressed again.
                        pointers.put(pointerId, hitTest(event.getX(i), event.getY(i)));
                        continue;
                    }
                    if (pointers.indexOfKey(pointerId) < 0) {
                        continue;
                    }
                    int current = pointers.get(pointerId);
                    // Face buttons stick until release. A thumb sliding a few
                    // pixels used to drop A before the game ever sampled it.
                    if ((current & (FACE | FLAG_TURBO_A | FLAG_TURBO_B | FLAG_LR | FLAG_C | FLAG_C2)) != 0) {
                        continue;
                    }
                    pointers.put(pointerId, hitTest(event.getX(i), event.getY(i)));
                }
                break;
            case MotionEvent.ACTION_UP:
            case MotionEvent.ACTION_POINTER_UP: {
                int held = actionPointers.get(id, 0);
                if (held != 0) {
                    actionPointers.delete(id);
                    if (held == ACTION_FF && listener != null) {
                        listener.onFastHold(false);
                    }
                    invalidate();
                    break;
                }
                pointers.delete(id);
                break;
            }
            case MotionEvent.ACTION_CANCEL:
                // The touch stream was taken away (edge swipe, notification
                // shade, dialog). Release everything, including a pulsing
                // turbo key, or it would stay stuck on.
                releaseAllKeys();
                break;
            default:
                return true;
        }
        publish(computeMask());
        return true;
    }

    private void publish(int mask) {
        if (mask != pressed) {
            pressed = mask;
            if (listener != null) {
                listener.onKeysChanged(mask);
            }
            invalidate();
        }
    }

    /** Mask implied by the current pointers, including pulsing turbo keys. */
    private int computeMask() {
        int mask = 0;
        int turbo = 0;
        for (int i = 0; i < pointers.size(); i++) {
            int value = pointers.valueAt(i);
            if ((value & FLAG_TURBO_A) != 0) {
                turbo |= A;
            } else if ((value & FLAG_TURBO_B) != 0) {
                turbo |= B;
            } else if ((value & FLAG_LR) != 0) {
                mask |= L | R;
            } else if ((value & FLAG_C) != 0) {
                mask |= macroMaskC;
            } else if ((value & FLAG_C2) != 0) {
                mask |= macroMaskC2;
            } else {
                mask |= value;
            }
        }
        if (turbo != pulseMask) {
            pulseMask = turbo;
            turboHandler.removeCallbacks(turboTick);
            if (pulseMask == 0) {
                pulseOn = false;
            } else {
                pulseOn = true;
                turboHandler.postDelayed(turboTick, Math.max(20, 1000 / Math.max(1, turboRate)));
            }
        }
        return mask | (pulseOn ? pulseMask : 0);
    }

    /** Optional utility key under the point, or 0 (ACTION_* codes). */
    private int actionAt(float x, float y) {
        if (handheld()) {
            if (toggle.width() > 0 && toggle.contains(x, y)) {
                return ACTION_FF_TOGGLE;
            }
            if (toolbar.width() > 0) {
                if (toolbarMenu.contains(x, y)) {
                    return ACTION_MENU;
                }
                if (toolbarSave.contains(x, y)) {
                    return ACTION_SAVE;
                }
                if (toolbarLoad.contains(x, y)) {
                    return ACTION_LOAD;
                }
                if (toolbarMute.contains(x, y)) {
                    return ACTION_MUTE;
                }
                if (toolbarRewind.contains(x, y)) {
                    return ACTION_REWIND;
                }
            }
        }
        if (visibleExtras.contains("save") && keySave.contains(x, y)) {
            return ACTION_SAVE;
        }
        if (visibleExtras.contains("load") && keyLoad.contains(x, y)) {
            return ACTION_LOAD;
        }
        if (visibleExtras.contains("ff") && keyFast.contains(x, y)) {
            return ACTION_FF;
        }
        if (visibleExtras.contains("shot") && keyShot.contains(x, y)) {
            return ACTION_SHOT;
        }
        if (visibleExtras.contains("rewind") && keyRewind.contains(x, y)) {
            return ACTION_REWIND_QUICK;
        }
        return 0;
    }

    private int hitTest(float x, float y) {
        if (visibleExtras.contains("ta") && keyTurboA.contains(x, y)) {
            return FLAG_TURBO_A;
        }
        if (visibleExtras.contains("tb") && keyTurboB.contains(x, y)) {
            return FLAG_TURBO_B;
        }
        if (visibleExtras.contains("lr") && keyLR.contains(x, y)) {
            return FLAG_LR;
        }
        if (visibleExtras.contains("c") && keyC.contains(x, y)) {
            return FLAG_C;
        }
        if (visibleExtras.contains("c2") && keyC2.contains(x, y)) {
            return FLAG_C2;
        }
        int face = nearestFace(x, y);
        if (face != 0) {
            return face;
        }
        return hitDpad(x, y);
    }

    private int hitDpad(float x, float y) {
        if (dpad.width() <= 0f || !dpad.contains(x, y)) {
            return 0;
        }
        int bits = 0;
        if (hitArm(dpadUp, x, y)) {
            bits |= UP;
        }
        if (hitArm(dpadDown, x, y)) {
            bits |= DOWN;
        }
        if (hitArm(dpadLeft, x, y)) {
            bits |= LEFT;
        }
        if (hitArm(dpadRight, x, y)) {
            bits |= RIGHT;
        }
        if (bits != 0 && diagonalLock) {
            // Keep only the dominant direction so a diagonal press reads as
            // one clean input, the way some games expect.
            float dx = x - dpad.centerX();
            float dy = y - dpad.centerY();
            if (Math.abs(dx) > Math.abs(dy)) {
                return dx > 0 ? RIGHT : LEFT;
            }
            return dy > 0 ? DOWN : UP;
        }
        return bits;
    }

    private boolean hitArm(RectF rect, float x, float y) {
        float extra = dpad.width() * 0.05f;
        float left = rect.left;
        float top = rect.top;
        float right = rect.right;
        float bottom = rect.bottom;
        if (rect.centerX() < dpad.centerX()) {
            right += extra;
        } else if (rect.centerX() > dpad.centerX()) {
            left -= extra;
        }
        if (rect.centerY() < dpad.centerY()) {
            bottom += extra;
        } else if (rect.centerY() > dpad.centerY()) {
            top -= extra;
        }
        return x >= left && x < right && y >= top && y < bottom;
    }

    private int nearestFace(float x, float y) {
        int best = 0;
        float bestDist = Float.MAX_VALUE;
        float dist = consider(buttonL, x, y, slopFace, bestDist);
        if (dist < bestDist) {
            best = L;
            bestDist = dist;
        }
        dist = consider(buttonR, x, y, slopFace, bestDist);
        if (dist < bestDist) {
            best = R;
            bestDist = dist;
        }
        dist = consider(buttonA, x, y, slopA, bestDist);
        if (dist < bestDist) {
            best = A;
            bestDist = dist;
        }
        dist = consider(buttonB, x, y, slopFace, bestDist);
        if (dist < bestDist) {
            best = B;
            bestDist = dist;
        }
        dist = consider(buttonSelect, x, y, slopFace, bestDist);
        if (dist < bestDist) {
            best = SELECT;
            bestDist = dist;
        }
        dist = consider(buttonStart, x, y, slopFace, bestDist);
        if (dist < bestDist) {
            best = START;
        }
        return best;
    }

    private void snapDefaults() {
        dpadDefault.set(dpad);
        buttonLDefault.set(buttonL);
        buttonRDefault.set(buttonR);
        buttonADefault.set(buttonA);
        buttonBDefault.set(buttonB);
        buttonSelectDefault.set(buttonSelect);
        buttonStartDefault.set(buttonStart);
        keyTurboADefault.set(keyTurboA);
        keyTurboBDefault.set(keyTurboB);
        keyLRDefault.set(keyLR);
        keyCDefault.set(keyC);
        keyC2Default.set(keyC2);
        keySaveDefault.set(keySave);
        keyLoadDefault.set(keyLoad);
        keyFastDefault.set(keyFast);
        keyShotDefault.set(keyShot);
        keyRewindDefault.set(keyRewind);
    }

    private void applyCenters() {
        place(dpad, dpadDefault, "dpad");
        place(buttonL, buttonLDefault, "l");
        place(buttonR, buttonRDefault, "r");
        place(buttonA, buttonADefault, "a");
        place(buttonB, buttonBDefault, "b");
        place(buttonSelect, buttonSelectDefault, "select");
        place(buttonStart, buttonStartDefault, "start");
        if (visibleExtras.contains("ta")) {
            place(keyTurboA, keyTurboADefault, "ta");
        }
        if (visibleExtras.contains("tb")) {
            place(keyTurboB, keyTurboBDefault, "tb");
        }
        if (visibleExtras.contains("lr")) {
            place(keyLR, keyLRDefault, "lr");
        }
        if (visibleExtras.contains("c")) {
            place(keyC, keyCDefault, "c");
        }
        if (visibleExtras.contains("c2")) {
            place(keyC2, keyC2Default, "c2");
        }
        if (visibleExtras.contains("save")) {
            place(keySave, keySaveDefault, "save");
        }
        if (visibleExtras.contains("load")) {
            place(keyLoad, keyLoadDefault, "load");
        }
        if (visibleExtras.contains("ff")) {
            place(keyFast, keyFastDefault, "ff");
        }
        if (visibleExtras.contains("shot")) {
            place(keyShot, keyShotDefault, "shot");
        }
        if (visibleExtras.contains("rewind")) {
            place(keyRewind, keyRewindDefault, "rewind");
        }
        layoutDpadArms();
        updateGestureExclusion();
        if (listener != null) {
            listener.onControlsLayout();
        }
    }

    @Override
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        // Exclusion rects are cleared when a view is detached; restore them
        // without waiting for the next resize.
        updateGestureExclusion();
    }

    /**
     * Android 10's gesture navigation owns the left/right screen edges. The
     * classic skin parks A (and B) a few dp from the bottom-right corner, so a
     * thumb landing there made the system start a back gesture and cancel the
     * press - the key looked like it "sometimes does not respond". Excluding
     * the boxes of the edge-hugging keys keeps those touches inside the app.
     * The system allows at most 200dp per edge and silently trims the rest.
     */
    private void updateGestureExclusion() {
        if (Build.VERSION.SDK_INT < Build.VERSION_CODES.Q || getWidth() <= 0 || getHeight() <= 0) {
            return;
        }
        List<Rect> rects = new ArrayList<>();
        addGestureExclusion(rects, buttonA);
        addGestureExclusion(rects, buttonB);
        addGestureExclusion(rects, buttonL);
        addGestureExclusion(rects, buttonR);
        addGestureExclusion(rects, dpad);
        setSystemGestureExclusionRects(rects);
    }

    private void addGestureExclusion(List<Rect> rects, RectF box) {
        if (box.width() <= 0f || box.height() <= 0f) {
            return;
        }
        // Only keys that reach into the edge band can fight a back gesture.
        float edge = 32 * density;
        if (box.left > edge && getWidth() - box.right > edge) {
            return;
        }
        int left = Math.max(0, (int) Math.floor(box.left));
        int top = Math.max(0, (int) Math.floor(box.top));
        int right = Math.min(getWidth(), (int) Math.ceil(box.right));
        int bottom = Math.min(getHeight(), (int) Math.ceil(box.bottom));
        if (right <= left || bottom <= top) {
            return;
        }
        // Keep each rect inside the system's per-edge budget so a huge d-pad
        // cannot push the A exclusion past the limit.
        int budget = (int) (200 * density);
        if (right - left > budget) {
            if (box.left <= edge) {
                right = left + budget;
            } else {
                left = right - budget;
            }
        }
        rects.add(new Rect(left, top, right, bottom));
    }

    /** Current bounds of the START key, in this view's coordinates. */
    public void getStartRect(RectF out) {
        out.set(buttonStart);
    }

    private void layoutDpadArms() {
        if (dpad.width() <= 0f) {
            return;
        }
        float size = dpad.width();
        float gap = size * 0.06f;
        float thick = size * 0.34f;
        float arm = (size - thick - gap * 2f) / 2f;
        float cx = dpad.centerX();
        float cy = dpad.centerY();
        dpadUp.set(cx - thick / 2f, dpad.top, cx + thick / 2f, dpad.top + arm);
        dpadDown.set(cx - thick / 2f, dpad.bottom - arm, cx + thick / 2f, dpad.bottom);
        dpadLeft.set(dpad.left, cy - thick / 2f, dpad.left + arm, cy + thick / 2f);
        dpadRight.set(dpad.right - arm, cy - thick / 2f, dpad.right, cy + thick / 2f);
    }

    private void place(RectF rect, RectF base, String key) {
        if (base.width() <= 0f || base.height() <= 0f) {
            return;
        }
        Float scaleBox = scales.get(key);
        float s = scaleBox == null ? 1f : clampScale(scaleBox);
        float w = base.width() * s;
        float h = base.height() * s;
        if (getWidth() <= 0 || getHeight() <= 0) {
            rect.set(base);
            float cx0 = rect.centerX();
            float cy0 = rect.centerY();
            rect.set(cx0 - w / 2f, cy0 - h / 2f, cx0 + w / 2f, cy0 + h / 2f);
            return;
        }
        float[] center = centers.get(key);
        float baseCx = base.centerX();
        float baseCy = base.centerY();
        float nx = center != null && center.length >= 2 ? center[0] : baseCx / getWidth();
        float ny = center != null && center.length >= 2 ? center[1] : baseCy / getHeight();
        float cx = KeyLayout.clampCenter(nx * getWidth(), w / 2f, getWidth());
        float cy = KeyLayout.clampCenter(ny * getHeight(), h / 2f, getHeight());
        rect.set(cx - w / 2f, cy - h / 2f, cx + w / 2f, cy + h / 2f);
    }

    private void drawCursor(Canvas canvas, RectF rect) {
        float cx = rect.centerX();
        float cy = rect.centerY();
        float arm = Math.max(18f * density, Math.min(rect.width(), rect.height()) * 0.45f);
        float previous = stroke.getStrokeWidth();
        float mark = Math.max(2.5f, 1.5f * density);
        stroke.setColor(Color.argb(240, 255, 214, 64));
        stroke.setStrokeWidth(mark);
        canvas.drawLine(cx - arm, cy, cx + arm, cy, stroke);
        canvas.drawLine(cx, cy - arm, cx, cy + arm, stroke);
        canvas.drawCircle(cx, cy, 4f * density, stroke);
        stroke.setStrokeWidth(previous);
    }

    private String dragKey;
    private int dragPointer = -1;
    private int pinchPointer = -1;
    private float grabDx;
    private float grabDy;
    private float downX;
    private float downY;
    private float lastNx;
    private float lastNy;
    private boolean dragMoved;
    private float pinchStartDist;
    private float pinchStartScale = 1f;
    private boolean pinchActive;

    private boolean editTouch(MotionEvent event) {
        if (editListener == null || getWidth() <= 0 || getHeight() <= 0) {
            return true;
        }
        int action = event.getActionMasked();
        int index = event.getActionIndex();
        switch (action) {
            case MotionEvent.ACTION_DOWN:
                dragPointer = event.getPointerId(index);
                pinchPointer = -1;
                pinchActive = false;
                dragKey = keyAt(event.getX(index), event.getY(index));
                dragMoved = false;
                downX = event.getX(index);
                downY = event.getY(index);
                if (dragKey != null) {
                    RectF rect = rectFor(dragKey);
                    grabDx = downX - rect.centerX();
                    grabDy = downY - rect.centerY();
                    editListener.onSelected(dragKey);
                }
                break;
            case MotionEvent.ACTION_POINTER_DOWN:
                if (dragKey != null && dragPointer >= 0 && pinchPointer < 0 && event.getPointerCount() >= 2) {
                    int other = event.getPointerId(index);
                    if (other != dragPointer) {
                        pinchPointer = other;
                        pinchStartDist = fingerDist(event, dragPointer, pinchPointer);
                        if (pinchStartDist < 10f) {
                            pinchStartDist = 10f;
                        }
                        Float s = scales.get(dragKey);
                        pinchStartScale = s == null ? 1f : s;
                        pinchActive = true;
                    }
                } else if (dragKey == null && event.getPointerCount() >= 2) {
                    // Two fingers landed together: pick key under midpoint.
                    int p0 = event.getPointerId(0);
                    int p1 = event.getPointerId(1);
                    int i0 = event.findPointerIndex(p0);
                    int i1 = event.findPointerIndex(p1);
                    if (i0 >= 0 && i1 >= 0) {
                        float mx = (event.getX(i0) + event.getX(i1)) / 2f;
                        float my = (event.getY(i0) + event.getY(i1)) / 2f;
                        String mid = keyAt(mx, my);
                        if (mid != null) {
                            dragKey = mid;
                            dragPointer = p0;
                            pinchPointer = p1;
                            RectF rect = rectFor(dragKey);
                            downX = mx;
                            downY = my;
                            grabDx = mx - rect.centerX();
                            grabDy = my - rect.centerY();
                            pinchStartDist = fingerDist(event, dragPointer, pinchPointer);
                            if (pinchStartDist < 10f) {
                                pinchStartDist = 10f;
                            }
                            Float s = scales.get(dragKey);
                            pinchStartScale = s == null ? 1f : s;
                            pinchActive = true;
                            dragMoved = false;
                            editListener.onSelected(dragKey);
                        }
                    }
                }
                break;
            case MotionEvent.ACTION_MOVE:
                if (pinchActive) {
                    movePinch(event);
                    moveDrag(event);
                } else {
                    moveDrag(event);
                }
                break;
            case MotionEvent.ACTION_UP:
            case MotionEvent.ACTION_POINTER_UP: {
                int gone = event.getPointerId(index);
                if (gone == pinchPointer) {
                    pinchPointer = -1;
                    pinchActive = false;
                    // Persist scale when pinch ends.
                    if (dragKey != null) {
                        Float s = scales.get(dragKey);
                        editListener.onScaleChanged(dragKey, s == null ? 1f : s);
                    }
                    break;
                }
                if (gone != dragPointer) {
                    break;
                }
                moveDrag(event);
                if (dragKey != null && dragMoved) {
                    editListener.onCursorStopped(dragKey, lastNx, lastNy);
                }
                if (pinchActive) {
                    Float s = scales.get(dragKey);
                    if (dragKey != null) {
                        editListener.onScaleChanged(dragKey, s == null ? 1f : s);
                    }
                }
                dragKey = null;
                dragPointer = -1;
                pinchPointer = -1;
                pinchActive = false;
                break;
            }
            case MotionEvent.ACTION_CANCEL:
                dragKey = null;
                dragPointer = -1;
                pinchPointer = -1;
                pinchActive = false;
                break;
            default:
                break;
        }
        return true;
    }

    private float fingerDist(MotionEvent event, int idA, int idB) {
        int ia = event.findPointerIndex(idA);
        int ib = event.findPointerIndex(idB);
        if (ia < 0 || ib < 0) {
            return 10f;
        }
        float dx = event.getX(ia) - event.getX(ib);
        float dy = event.getY(ia) - event.getY(ib);
        float dist = (float) Math.sqrt(dx * dx + dy * dy);
        return dist < 10f ? 10f : dist;
    }

    private void movePinch(MotionEvent event) {
        if (dragKey == null || dragPointer < 0 || pinchPointer < 0) {
            return;
        }
        float dist = fingerDist(event, dragPointer, pinchPointer);
        float next = clampScale(pinchStartScale * dist / pinchStartDist);
        scales.put(dragKey, next);
        applyCenters();
        invalidate();
        editListener.onScaleChanged(dragKey, next);
    }

    private void moveDrag(MotionEvent event) {
        if (dragKey == null || dragPointer < 0) {
            return;
        }
        int index = event.findPointerIndex(dragPointer);
        if (index < 0) {
            return;
        }
        float x = event.getX(index);
        float y = event.getY(index);
        float dx = x - downX;
        float dy = y - downY;
        if (dx * dx + dy * dy > 36f * density * density) {
            dragMoved = true;
        }
        if (!dragMoved) {
            return;
        }
        lastNx = (x - grabDx) / getWidth();
        lastNy = (y - grabDy) / getHeight();
        editListener.onCursorMoved(dragKey, lastNx, lastNy);
    }

    private String keyAt(float x, float y) {
        if (visibleExtras.contains("ta") && keyTurboA.contains(x, y)) {
            return "ta";
        }
        if (visibleExtras.contains("tb") && keyTurboB.contains(x, y)) {
            return "tb";
        }
        if (visibleExtras.contains("lr") && keyLR.contains(x, y)) {
            return "lr";
        }
        if (visibleExtras.contains("c") && keyC.contains(x, y)) {
            return "c";
        }
        if (visibleExtras.contains("c2") && keyC2.contains(x, y)) {
            return "c2";
        }
        if (visibleExtras.contains("save") && keySave.contains(x, y)) {
            return "save";
        }
        if (visibleExtras.contains("load") && keyLoad.contains(x, y)) {
            return "load";
        }
        if (visibleExtras.contains("ff") && keyFast.contains(x, y)) {
            return "ff";
        }
        if (visibleExtras.contains("shot") && keyShot.contains(x, y)) {
            return "shot";
        }
        if (visibleExtras.contains("rewind") && keyRewind.contains(x, y)) {
            return "rewind";
        }
        int face = nearestFace(x, y);
        if (face == A) {
            return "a";
        }
        if (face == B) {
            return "b";
        }
        if (face == L) {
            return "l";
        }
        if (face == R) {
            return "r";
        }
        if (face == SELECT) {
            return "select";
        }
        if (face == START) {
            return "start";
        }
        if (dpad.contains(x, y)) {
            return "dpad";
        }
        return null;
    }

    private RectF rectFor(String key) {
        if ("dpad".equals(key)) {
            return dpad;
        }
        if ("a".equals(key)) {
            return buttonA;
        }
        if ("b".equals(key)) {
            return buttonB;
        }
        if ("l".equals(key)) {
            return buttonL;
        }
        if ("r".equals(key)) {
            return buttonR;
        }
        if ("select".equals(key)) {
            return buttonSelect;
        }
        if ("start".equals(key)) {
            return buttonStart;
        }
        if ("ta".equals(key)) {
            return keyTurboA;
        }
        if ("tb".equals(key)) {
            return keyTurboB;
        }
        if ("lr".equals(key)) {
            return keyLR;
        }
        if ("c".equals(key)) {
            return keyC;
        }
        if ("c2".equals(key)) {
            return keyC2;
        }
        if ("save".equals(key)) {
            return keySave;
        }
        if ("load".equals(key)) {
            return keyLoad;
        }
        if ("ff".equals(key)) {
            return keyFast;
        }
        if ("shot".equals(key)) {
            return keyShot;
        }
        if ("rewind".equals(key)) {
            return keyRewind;
        }
        return buttonStart;
    }

    private static float consider(RectF rect, float x, float y, float extra, float bestDist) {
        if (x < rect.left - extra || x >= rect.right + extra || y < rect.top - extra || y >= rect.bottom + extra) {
            return Float.MAX_VALUE;
        }
        float dx = x - rect.centerX();
        float dy = y - rect.centerY();
        float dist = dx * dx + dy * dy;
        return dist < bestDist ? dist : Float.MAX_VALUE;
    }
}
