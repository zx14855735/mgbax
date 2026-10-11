package io.mgba.android;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.util.SparseIntArray;
import android.view.MotionEvent;
import android.view.View;

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

    public interface Listener {
        void onKeysChanged(int mask);
    }

    private final Paint fill = new Paint(Paint.ANTI_ALIAS_FLAG);
    private final Paint stroke = new Paint(Paint.ANTI_ALIAS_FLAG);
    private final Paint text = new Paint(Paint.ANTI_ALIAS_FLAG);
    private final RectF dpad = new RectF();
    private final RectF buttonL = new RectF();
    private final RectF buttonR = new RectF();
    private final RectF buttonA = new RectF();
    private final RectF buttonB = new RectF();
    private final RectF buttonSelect = new RectF();
    private final RectF buttonStart = new RectF();
    private final SparseIntArray pointers = new SparseIntArray();
    private Listener listener;
    private int pressed;
    private boolean turboB;
    private boolean turboLit;
    private float slopA;
    private float slopFace;
    private static final int FACE = A | B | SELECT | START | L | R;

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

    public void setBTurbo(boolean active, boolean lit) {
        if (turboB == active && turboLit == lit) {
            return;
        }
        turboB = active;
        turboLit = lit;
        invalidate();
    }

    private boolean bDown() {
        return turboB ? turboLit : (pressed & B) != 0;
    }

    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        float d = getResources().getDisplayMetrics().density;
        float pad = 10 * d;
        float dpadSize = Math.min(150 * d, Math.min(w, h) * 0.42f);
        dpad.set(pad, h - pad - dpadSize, pad + dpadSize, h - pad);

        float shoulderW = 72 * d;
        float shoulderH = 36 * d;
        buttonL.set(pad, pad, pad + shoulderW, pad + shoulderH);
        buttonR.set(w - pad - shoulderW, pad, w - pad, pad + shoulderH);

        float face = 58 * d;
        float faceA = 76 * d;
        buttonA.set(w - pad - faceA, h - pad - faceA, w - pad, h - pad);
        buttonB.set(buttonA.left - face - 14 * d, buttonA.top - 36 * d, buttonA.left - 14 * d, buttonA.top - 36 * d + face);
        slopA = 18 * d;
        slopFace = 10 * d;

        float menuW = 64 * d;
        float menuH = 32 * d;
        float menuTop = h - pad - menuH;
        float center = w / 2f;
        buttonSelect.set(center - menuW - 8 * d, menuTop, center - 8 * d, menuTop + menuH);
        buttonStart.set(center + 8 * d, menuTop, center + 8 * d + menuW, menuTop + menuH);
        text.setTextSize(14 * d);
        stroke.setStrokeWidth(Math.max(2f, 1.5f * d));
    }

    @Override
    protected void onDraw(Canvas canvas) {
        drawButton(canvas, buttonL, "L", (pressed & L) != 0);
        drawButton(canvas, buttonR, "R", (pressed & R) != 0);
        drawButton(canvas, buttonA, "A", (pressed & A) != 0);
        drawButton(canvas, buttonB, "B", bDown());
        drawButton(canvas, buttonSelect, "SELECT", (pressed & SELECT) != 0);
        drawButton(canvas, buttonStart, "START", (pressed & START) != 0);
        drawDpad(canvas);
    }

    private void drawButton(Canvas canvas, RectF rect, String label, boolean down) {
        if (down) {
            fill.setColor(Color.argb(70, 80, 210, 130));
            canvas.drawRoundRect(rect, 12, 12, fill);
        }
        stroke.setColor(down ? Color.argb(210, 120, 230, 160) : Color.argb(140, 255, 255, 255));
        canvas.drawRoundRect(rect, 12, 12, stroke);
        text.setColor(down ? Color.argb(230, 255, 255, 255) : Color.argb(180, 255, 255, 255));
        canvas.drawText(label, rect.centerX(), rect.centerY() - (text.descent() + text.ascent()) / 2f, text);
    }

    private void drawDpad(Canvas canvas) {
        float cx = dpad.centerX();
        float cy = dpad.centerY();
        float arm = dpad.width() * 0.28f;
        float thick = dpad.width() * 0.22f;
        RectF vertical = new RectF(cx - thick, cy - arm * 1.6f, cx + thick, cy + arm * 1.6f);
        RectF horizontal = new RectF(cx - arm * 1.6f, cy - thick, cx + arm * 1.6f, cy + thick);
        stroke.setColor(Color.argb(140, 255, 255, 255));
        canvas.drawRoundRect(vertical, 10, 10, stroke);
        canvas.drawRoundRect(horizontal, 10, 10, stroke);
        fill.setColor(Color.argb(70, 80, 210, 130));
        if ((pressed & UP) != 0) {
            canvas.drawRoundRect(new RectF(cx - thick, cy - arm * 1.6f, cx + thick, cy), 10, 10, fill);
        }
        if ((pressed & DOWN) != 0) {
            canvas.drawRoundRect(new RectF(cx - thick, cy, cx + thick, cy + arm * 1.6f), 10, 10, fill);
        }
        if ((pressed & LEFT) != 0) {
            canvas.drawRoundRect(new RectF(cx - arm * 1.6f, cy - thick, cx, cy + thick), 10, 10, fill);
        }
        if ((pressed & RIGHT) != 0) {
            canvas.drawRoundRect(new RectF(cx, cy - thick, cx + arm * 1.6f, cy + thick), 10, 10, fill);
        }
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        int action = event.getActionMasked();
        if (action == MotionEvent.ACTION_DOWN) {
            requestUnbufferedDispatch(event);
        }
        int index = event.getActionIndex();
        int id = event.getPointerId(index);
        switch (action) {
            case MotionEvent.ACTION_DOWN:
            case MotionEvent.ACTION_POINTER_DOWN:
                pointers.put(id, hitTest(event.getX(index), event.getY(index)));
                break;
            case MotionEvent.ACTION_MOVE:
                for (int i = 0; i < event.getPointerCount(); i++) {
                    int pointerId = event.getPointerId(i);
                    if (pointers.indexOfKey(pointerId) < 0) {
                        continue;
                    }
                    int current = pointers.get(pointerId);
                    // Face buttons stick until release. A thumb sliding a few
                    // pixels used to drop A before the game ever sampled it.
                    if ((current & FACE) != 0) {
                        continue;
                    }
                    pointers.put(pointerId, hitTest(event.getX(i), event.getY(i)));
                }
                break;
            case MotionEvent.ACTION_UP:
            case MotionEvent.ACTION_POINTER_UP:
                pointers.delete(id);
                break;
            case MotionEvent.ACTION_CANCEL:
                pointers.clear();
                break;
            default:
                return true;
        }
        int mask = 0;
        for (int i = 0; i < pointers.size(); i++) {
            mask |= pointers.valueAt(i);
        }
        if (mask != pressed) {
            pressed = mask;
            if (listener != null) {
                listener.onKeysChanged(mask);
            }
            invalidate();
        }
        return true;
    }

    private int hitTest(float x, float y) {
        int face = nearestFace(x, y);
        if (face != 0) {
            return face;
        }
        if (!dpad.contains(x, y)) {
            return 0;
        }
        float dx = x - dpad.centerX();
        float dy = y - dpad.centerY();
        float radius = dpad.width() * 0.72f;
        if (dx * dx + dy * dy > radius * radius) {
            return 0;
        }
        int bits = 0;
        if (Math.abs(dx) > Math.abs(dy) * 0.35f) {
            bits |= dx > 0 ? RIGHT : LEFT;
        }
        if (Math.abs(dy) > Math.abs(dx) * 0.35f) {
            bits |= dy > 0 ? DOWN : UP;
        }
        return bits;
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
