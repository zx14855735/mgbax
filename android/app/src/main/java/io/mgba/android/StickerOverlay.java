/* This Source Code Form is subject to the terms of the Mozilla Public
 * License, v. 2.0. If a copy of the MPL was not distributed with this
 * file, You can obtain one at http://mozilla.org/MPL/2.0/. */
package io.mgba.android;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.util.SparseIntArray;
import android.view.MotionEvent;
import android.view.View;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Picture stickers laid over the game, Pizza Boy style. In edit mode each
 * sticker can be dragged and pinch-scaled; otherwise the view lets touches
 * pass through to the game below.
 */
public class StickerOverlay extends View {
    public static final int MAX_STICKERS = 10;

    public static class Sticker {
        public String path;
        /** Center position and width, normalized to the view; height follows the image. */
        public float x;
        public float y;
        public float w;
        /** 0-255. */
        public int alpha = 255;
    }

    public interface Listener {
        /** Fired after a drag or pinch settled, so the activity can persist. */
        void onStickersChanged(List<Sticker> stickers);
    }

    private final Paint paint = new Paint(Paint.ANTI_ALIAS_FLAG | Paint.FILTER_BITMAP_FLAG);
    private final Paint stroke = new Paint(Paint.ANTI_ALIAS_FLAG);
    private final Map<String, Bitmap> bitmaps = new HashMap<>();
    private final List<Sticker> stickers = new ArrayList<>();
    private final SparseIntArray pointers = new SparseIntArray();
    private final RectF touchBox = new RectF();
    private Listener listener;
    private boolean editing;
    private float density = 1f;
    private int dragIndex = -1;
    private int dragPointer = -1;
    private int pinchPointer = -1;
    private float grabDx;
    private float grabDy;
    private float pinchStartDist = 10f;
    private float pinchStartW = 0.2f;

    public StickerOverlay(Context context) {
        this(context, null);
    }

    public StickerOverlay(Context context, AttributeSet attrs) {
        super(context, attrs);
        stroke.setStyle(Paint.Style.STROKE);
        stroke.setColor(0xFFFFD640);
        stroke.setStrokeWidth(2f);
    }

    public void setListener(Listener listener) {
        this.listener = listener;
    }

    public void setEditing(boolean editing) {
        this.editing = editing;
        dragIndex = -1;
        dragPointer = -1;
        pinchPointer = -1;
        pointers.clear();
        invalidate();
    }

    public boolean isEditing() {
        return editing;
    }

    public List<Sticker> stickers() {
        return stickers;
    }

    public void setStickers(List<Sticker> next) {
        stickers.clear();
        if (next != null) {
            stickers.addAll(next);
        }
        preload();
        invalidate();
    }

    public boolean addSticker(String path) {
        if (stickers.size() >= MAX_STICKERS) {
            return false;
        }
        Sticker sticker = new Sticker();
        sticker.path = path;
        sticker.x = 0.5f;
        sticker.y = 0.4f;
        sticker.w = 0.3f;
        Bitmap bitmap = loadBitmap(path);
        if (bitmap == null) {
            return false;
        }
        sticker.w = Math.min(0.5f, bitmap.getWidth() / Math.max(1f, getWidth()) * 1.2f);
        stickers.add(sticker);
        preload();
        invalidate();
        if (listener != null) {
            listener.onStickersChanged(stickers);
        }
        return true;
    }

    public void clear() {
        stickers.clear();
        invalidate();
        if (listener != null) {
            listener.onStickersChanged(stickers);
        }
    }

    private Bitmap loadBitmap(String path) {
        Bitmap cached = bitmaps.get(path);
        if (cached != null) {
            return cached;
        }
        try {
            BitmapFactory.Options options = new BitmapFactory.Options();
            options.inScaled = false;
            Bitmap bitmap = BitmapFactory.decodeFile(path, options);
            if (bitmap != null) {
                bitmaps.put(path, bitmap);
            }
            return bitmap;
        } catch (Exception e) {
            return null;
        }
    }

    private void preload() {
        for (Sticker sticker : stickers) {
            loadBitmap(sticker.path);
        }
    }

    private RectF boxOf(Sticker sticker) {
        Bitmap bitmap = loadBitmap(sticker.path);
        if (bitmap == null || getWidth() <= 0) {
            touchBox.setEmpty();
            return touchBox;
        }
        float w = sticker.w * getWidth();
        float h = w * bitmap.getHeight() / bitmap.getWidth();
        float x = sticker.x * getWidth();
        float y = sticker.y * getHeight();
        touchBox.set(x - w / 2f, y - h / 2f, x + w / 2f, y + h / 2f);
        return touchBox;
    }

    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);
        density = getResources().getDisplayMetrics().density;
    }

    @Override
    protected void onDraw(Canvas canvas) {
        for (int i = 0; i < stickers.size(); i++) {
            Sticker sticker = stickers.get(i);
            Bitmap bitmap = loadBitmap(sticker.path);
            if (bitmap == null || bitmap.isRecycled()) {
                continue;
            }
            RectF box = boxOf(sticker);
            if (box.isEmpty()) {
                continue;
            }
            paint.setAlpha(sticker.alpha);
            canvas.drawBitmap(bitmap, null, box, paint);
            if (editing && i == dragIndex) {
                canvas.drawRect(box, stroke);
            }
        }
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        if (!editing || stickers.isEmpty()) {
            return false;
        }
        int action = event.getActionMasked();
        int index = event.getActionIndex();
        switch (action) {
            case MotionEvent.ACTION_DOWN: {
                int picked = -1;
                float x = event.getX(index);
                float y = event.getY(index);
                // Topmost first.
                for (int i = stickers.size() - 1; i >= 0; i--) {
                    if (boxOf(stickers.get(i)).contains(x, y)) {
                        picked = i;
                        break;
                    }
                }
                dragIndex = picked;
                dragPointer = picked >= 0 ? event.getPointerId(index) : -1;
                pinchPointer = -1;
                if (picked >= 0) {
                    RectF box = boxOf(stickers.get(picked));
                    grabDx = x - box.centerX();
                    grabDy = y - box.centerY();
                    pinchStartW = stickers.get(picked).w;
                    invalidate();
                }
                return true;
            }
            case MotionEvent.ACTION_POINTER_DOWN: {
                if (dragIndex >= 0 && dragPointer >= 0 && pinchPointer < 0 && event.getPointerCount() >= 2) {
                    int other = event.getPointerId(index);
                    if (other != dragPointer) {
                        pinchPointer = other;
                        pinchStartDist = dist(event);
                        if (pinchStartDist < 10f) {
                            pinchStartDist = 10f;
                        }
                        pinchStartW = stickers.get(dragIndex).w;
                    }
                }
                return true;
            }
            case MotionEvent.ACTION_MOVE: {
                if (dragIndex < 0 || dragPointer < 0) {
                    return true;
                }
                int di = event.findPointerIndex(dragPointer);
                if (di >= 0) {
                    Sticker sticker = stickers.get(dragIndex);
                    sticker.x = Math.max(0f, Math.min(1f, (event.getX(di) - grabDx) / getWidth()));
                    sticker.y = Math.max(0f, Math.min(1f, (event.getY(di) - grabDy) / getHeight()));
                }
                if (pinchPointer >= 0) {
                    float d = dist(event);
                    stickers.get(dragIndex).w = Math.max(0.05f, Math.min(1.5f, pinchStartW * d / pinchStartDist));
                }
                invalidate();
                return true;
            }
            case MotionEvent.ACTION_UP:
            case MotionEvent.ACTION_POINTER_UP: {
                int gone = event.getPointerId(index);
                if (gone == pinchPointer) {
                    pinchPointer = -1;
                    return true;
                }
                if (gone == dragPointer && dragIndex >= 0) {
                    if (listener != null) {
                        listener.onStickersChanged(stickers);
                    }
                    dragIndex = -1;
                    dragPointer = -1;
                    pinchPointer = -1;
                    invalidate();
                }
                return true;
            }
            case MotionEvent.ACTION_CANCEL:
                dragIndex = -1;
                dragPointer = -1;
                pinchPointer = -1;
                pointers.clear();
                invalidate();
                return true;
            default:
                return true;
        }
    }

    private float dist(MotionEvent event) {
        int a = event.findPointerIndex(dragPointer);
        int b = event.findPointerIndex(pinchPointer);
        if (a < 0 || b < 0) {
            return pinchStartDist;
        }
        float dx = event.getX(a) - event.getX(b);
        float dy = event.getY(a) - event.getY(b);
        return (float) Math.sqrt(dx * dx + dy * dy);
    }
}
