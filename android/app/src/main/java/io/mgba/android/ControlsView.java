/* This Source Code Form is subject to the terms of the Mozilla Public
 * License, v. 2.0. If a copy of the MPL was not distributed with this
 * file, You can obtain one at http://mozilla.org/MPL/2.0/. */
package io.mgba.android;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.util.SparseIntArray;
import android.view.MotionEvent;
import android.view.View;

import java.util.HashMap;
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

    private final Paint fill = new Paint(Paint.ANTI_ALIAS_FLAG);
    private final Paint stroke = new Paint(Paint.ANTI_ALIAS_FLAG);
    private final Paint text = new Paint(Paint.ANTI_ALIAS_FLAG);
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
    /* Optional utility keys: turbo A/B, L+R, quick save/load, fast-forward,
     * screenshot. Hidden until the player turns them on in the settings. */
    private final RectF keyTurboA = new RectF();
    private final RectF keyTurboB = new RectF();
    private final RectF keyLR = new RectF();
    private final RectF keySave = new RectF();
    private final RectF keyLoad = new RectF();
    private final RectF keyFast = new RectF();
    private final RectF keyShot = new RectF();
    private final RectF keyTurboADefault = new RectF();
    private final RectF keyTurboBDefault = new RectF();
    private final RectF keyLRDefault = new RectF();
    private final RectF keySaveDefault = new RectF();
    private final RectF keyLoadDefault = new RectF();
    private final RectF keyFastDefault = new RectF();
    private final RectF keyShotDefault = new RectF();
    private final java.util.HashSet<String> visibleExtras = new java.util.HashSet<>();
    private final Map<String, float[]> centers = new HashMap<>();
    private final Map<String, Float> scales = new HashMap<>();
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
        pointers.clear();
        actionPointers.clear();
        turboHandler.removeCallbacks(turboTick);
        pulseMask = 0;
        pulseOn = false;
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

    private boolean bDown() {
        return turboB ? turboLit : (pressed & B) != 0;
    }

    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        float d = getResources().getDisplayMetrics().density;
        float pad = 10 * d;
        float menuW = 64 * d;
        float menuH = 32 * d;
        float center = w / 2f;
        // Keep the d-pad clear of SELECT: on the narrow portrait screen a
        // full sized d-pad would otherwise sit on top of it.
        float dpadRoom = center - menuW - 8 * d - pad - 6 * d;
        float dpadSize = Math.min(240 * d, Math.min(w, h) * 0.62f);
        dpadSize = Math.min(dpadSize, Math.max(48 * d, dpadRoom));
        dpad.set(pad, h - pad - dpadSize, pad + dpadSize, h - pad);

        float shoulderW = 72 * d;
        float shoulderH = 36 * d;
        float shoulderTop = pad + 40 * d;
        buttonL.set(pad, shoulderTop, pad + shoulderW, shoulderTop + shoulderH);
        buttonR.set(w - pad - shoulderW, shoulderTop, w - pad, shoulderTop + shoulderH);

        float face = 58 * d;
        float faceA = 76 * d;
        buttonA.set(w - pad - faceA, h - pad - faceA, w - pad, h - pad);
        buttonB.set(buttonA.left - face - 14 * d, buttonA.top - 36 * d, buttonA.left - 14 * d, buttonA.top - 36 * d + face);
        slopA = 18 * d;
        slopFace = 10 * d;

        float menuTop = h - pad - menuH;
        buttonSelect.set(center - menuW - 8 * d, menuTop, center - 8 * d, menuTop + menuH);
        buttonStart.set(center + 8 * d, menuTop, center + 8 * d + menuW, menuTop + menuH);

        // Optional utility keys: defaults sit clear of the stock clusters; the
        // layout editor can drag each of them anywhere.
        float utilW = 56 * d;
        float utilH = 34 * d;
        float utilTop = menuTop - utilH - 8 * d;
        keySave.set(buttonSelect.left, utilTop, buttonSelect.left + utilW, utilTop + utilH);
        keyLoad.set(buttonStart.right - utilW, utilTop, buttonStart.right, utilTop + utilH);
        keyFast.set(center - utilW / 2f, utilTop, center + utilW / 2f, utilTop + utilH);
        float lrTop = shoulderTop + shoulderH + 8 * d;
        keyLR.set(center - utilW, lrTop, center + utilW, lrTop + utilH);
        keyShot.set(center - utilW / 2f, lrTop + utilH + 8 * d, center + utilW / 2f, lrTop + 2 * utilH + 8 * d);
        float turbo = 46 * d;
        keyTurboA.set(buttonA.left - 4 * d, buttonA.top - turbo - 6 * d, buttonA.left - 4 * d + turbo, buttonA.top - 6 * d);
        keyTurboB.set(keyTurboA.left - turbo - 8 * d, keyTurboA.top + 10 * d, keyTurboA.left - 8 * d, keyTurboA.top + 10 * d + turbo);
        density = d;
        text.setTextSize(14 * d);
        stroke.setStrokeWidth(Math.max(2f, 1.5f * d));
        snapDefaults();
        applyCenters();
    }

    @Override
    protected void onDraw(Canvas canvas) {
        drawButton(canvas, buttonL, "L", (pressed & L) != 0, editing);
        drawButton(canvas, buttonR, "R", (pressed & R) != 0, editing);
        drawButton(canvas, buttonA, "A", (pressed & A) != 0, editing);
        drawButton(canvas, buttonB, "B", bDown(), editing);
        drawButton(canvas, buttonSelect, "SELECT", (pressed & SELECT) != 0, editing);
        drawButton(canvas, buttonStart, "START", (pressed & START) != 0, editing);
        drawDpad(canvas);
        if (visibleExtras.contains("ta")) {
            drawButton(canvas, keyTurboA, "A连", (pressed & A) != 0 && pulseOn, editing);
        }
        if (visibleExtras.contains("tb")) {
            drawButton(canvas, keyTurboB, "B连", (pressed & B) != 0 && pulseOn, editing);
        }
        if (visibleExtras.contains("lr")) {
            drawButton(canvas, keyLR, "L+R", (pressed & (L | R)) == (L | R), editing);
        }
        if (visibleExtras.contains("save")) {
            drawButton(canvas, keySave, "快存", actionPointers.indexOfValue(ACTION_SAVE) >= 0, editing);
        }
        if (visibleExtras.contains("load")) {
            drawButton(canvas, keyLoad, "快读", actionPointers.indexOfValue(ACTION_LOAD) >= 0, editing);
        }
        if (visibleExtras.contains("ff")) {
            drawButton(canvas, keyFast, "倍速", actionPointers.indexOfValue(ACTION_FF) >= 0, editing);
        }
        if (visibleExtras.contains("shot")) {
            drawButton(canvas, keyShot, "截图", actionPointers.indexOfValue(ACTION_SHOT) >= 0, editing);
        }
    }

    private void drawButton(Canvas canvas, RectF rect, String label, boolean down, boolean selected) {
        if (down) {
            fill.setColor(Color.argb(70, 80, 210, 130));
            canvas.drawRoundRect(rect, 12, 12, fill);
        }
        stroke.setColor(selected ? Color.argb(230, 255, 214, 64) : down ? Color.argb(210, 120, 230, 160) : Color.argb(140, 255, 255, 255));
        canvas.drawRoundRect(rect, 12, 12, stroke);
        text.setColor(down || selected ? Color.argb(230, 255, 255, 255) : Color.argb(180, 255, 255, 255));
        canvas.drawText(label, rect.centerX(), rect.centerY() - (text.descent() + text.ascent()) / 2f, text);
        if (selected) {
            drawCursor(canvas, rect);
        }
    }

    private void drawDpad(Canvas canvas) {
        drawDirection(canvas, dpadUp, UP);
        drawDirection(canvas, dpadDown, DOWN);
        drawDirection(canvas, dpadLeft, LEFT);
        drawDirection(canvas, dpadRight, RIGHT);
        if (editing) {
            drawCursor(canvas, dpad);
        }
    }

    private void drawDirection(Canvas canvas, RectF rect, int bit) {
        if (rect.width() <= 0f) {
            return;
        }
        boolean down = (pressed & bit) != 0;
        float radius = 8f * density;
        if (down) {
            fill.setColor(Color.argb(90, 80, 210, 130));
            canvas.drawRoundRect(rect, radius, radius, fill);
        }
        stroke.setColor(editing ? Color.argb(230, 255, 214, 64) : down ? Color.argb(220, 120, 230, 160) : Color.argb(170, 255, 255, 255));
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
        fill.setColor(down ? Color.argb(245, 255, 255, 255) : Color.argb(210, 255, 255, 255));
        canvas.drawPath(arrow, fill);
    }

    /** Internal markers for the extra keys; not part of the key mask. */
    private static final int FLAG_TURBO_A = 1 << 20;
    private static final int FLAG_TURBO_B = 1 << 21;
    private static final int FLAG_LR = 1 << 22;

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        if (editing) {
            return editTouch(event);
        }
        int action = event.getActionMasked();
        if (action == MotionEvent.ACTION_DOWN) {
            requestUnbufferedDispatch(event);
        }
        int index = event.getActionIndex();
        int id = event.getPointerId(index);
        switch (action) {
            case MotionEvent.ACTION_DOWN:
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
                    break;
                }
                pointers.put(id, hitTest(x, y));
                break;
            }
            case MotionEvent.ACTION_MOVE:
                for (int i = 0; i < event.getPointerCount(); i++) {
                    int pointerId = event.getPointerId(i);
                    if (pointers.indexOfKey(pointerId) < 0) {
                        continue;
                    }
                    int current = pointers.get(pointerId);
                    // Face buttons stick until release. A thumb sliding a few
                    // pixels used to drop A before the game ever sampled it.
                    if ((current & (FACE | FLAG_TURBO_A | FLAG_TURBO_B | FLAG_LR)) != 0) {
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
                    break;
                }
                pointers.delete(id);
                break;
            }
            case MotionEvent.ACTION_CANCEL:
                pointers.clear();
                actionPointers.clear();
                if (listener != null) {
                    listener.onFastHold(false);
                }
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
        keySaveDefault.set(keySave);
        keyLoadDefault.set(keyLoad);
        keyFastDefault.set(keyFast);
        keyShotDefault.set(keyShot);
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
        layoutDpadArms();
        if (listener != null) {
            listener.onControlsLayout();
        }
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
