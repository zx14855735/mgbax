/* This Source Code Form is subject to the terms of the Mozilla Public
 * License, v. 2.0. If a copy of the MPL was not distributed with this
 * file, You can obtain one at http://mozilla.org/MPL/2.0/. */
package io.mgba.android;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.view.MotionEvent;
import android.view.View;

/**
 * The GIF recording float ball from 悠GBA模拟器: a small draggable dot that
 * floats over the game; a tap starts or stops the recording. Dragging snaps
 * it to the nearer screen edge, and its position survives restarts through
 * the activity's preferences. An in-window view, not a system overlay, so
 * no permission is needed.
 */
final class GifBall extends View {
    interface Listener {
        void onGifBallTapped();
    }

    private final Paint fill = new Paint(Paint.ANTI_ALIAS_FLAG);
    private final Paint ring = new Paint(Paint.ANTI_ALIAS_FLAG);
    private final Paint text = new Paint(Paint.ANTI_ALIAS_FLAG);
    private final Listener listener;
    private boolean recording;
    private float downX;
    private float downY;
    private boolean moved;

    GifBall(Context context, Listener listener) {
        super(context);
        this.listener = listener;
        fill.setColor(0xCC1B5E20);
        ring.setColor(0xE6FFFFFF);
        ring.setStyle(Paint.Style.STROKE);
        ring.setStrokeWidth(2);
        text.setColor(Color.WHITE);
        text.setTextAlign(Paint.Align.CENTER);
        text.setTextSize(11 * context.getResources().getDisplayMetrics().density);
    }

    void setRecording(boolean value) {
        recording = value;
        fill.setColor(value ? 0xCCB71C1C : 0xCC1B5E20);
        invalidate();
    }

    /** Remembers where it was parked; the activity persists it per session. */
    void restore(int x, int y) {
        post(() -> {
            View root = getRootView();
            int clampedX = Math.max(0, Math.min(x, Math.max(0, root.getWidth() - getWidth())));
            int clampedY = Math.max(0, Math.min(y, Math.max(0, root.getHeight() - getHeight())));
            setTranslationX(clampedX);
            setTranslationY(clampedY);
        });
    }

    int[] position() {
        return new int[]{(int) getTranslationX(), (int) getTranslationY()};
    }

    @Override
    protected void onMeasure(int widthSpec, int heightSpec) {
        int size = (int) (40 * getResources().getDisplayMetrics().density);
        setMeasuredDimension(size, size);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        float cx = getWidth() / 2f;
        float cy = getHeight() / 2f;
        float radius = getWidth() / 2f - 2;
        canvas.drawCircle(cx, cy, radius, fill);
        canvas.drawCircle(cx, cy, radius - 1, ring);
        canvas.drawText(recording ? "■" : "GIF", cx, cy + text.getTextSize() / 3f, text);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        switch (event.getActionMasked()) {
            case MotionEvent.ACTION_DOWN:
                downX = event.getRawX() - getTranslationX();
                downY = event.getRawY() - getTranslationY();
                moved = false;
                return true;
            case MotionEvent.ACTION_MOVE: {
                float x = event.getRawX() - downX;
                float y = event.getRawY() - downY;
                if (Math.abs(x - getTranslationX()) > 4 || Math.abs(y - getTranslationY()) > 4) {
                    moved = true;
                }
                setTranslationX(Math.max(0, Math.min(x, getRootView().getWidth() - getWidth())));
                setTranslationY(Math.max(0, Math.min(y, getRootView().getHeight() - getHeight())));
                return true;
            }
            case MotionEvent.ACTION_UP:
                if (moved) {
                    // Stick to the nearer horizontal edge; a drag never toggles.
                    View root = getRootView();
                    float x = getTranslationX();
                    float target = x + getWidth() / 2f < root.getWidth() / 2f ? 0
                            : root.getWidth() - getWidth();
                    animate().translationX(target).setDuration(150).start();
                    return true;
                }
                performClick();
                return true;
            default:
                return super.onTouchEvent(event);
        }
    }

    @Override
    public boolean performClick() {
        if (listener != null) {
            listener.onGifBallTapped();
        }
        return super.performClick();
    }
}
