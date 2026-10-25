/* This Source Code Form is subject to the terms of the Mozilla Public
 * License, v. 2.0. If a copy of the MPL was not distributed with this
 * file, You can obtain one at http://mozilla.org/MPL/2.0/. */
package io.mgba.android;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;

import java.util.ArrayList;
import java.util.List;

/**
 * Draws the translated text blocks over the game. A tap anywhere dismisses
 * the overlay; each block picks black or white text by its backdrop's
 * brightness, like Pizza Boy's translation overlay.
 */
public class AiOverlayView extends View {
    private final Paint panel = new Paint(Paint.ANTI_ALIAS_FLAG);
    private final Paint text = new Paint(Paint.ANTI_ALIAS_FLAG);
    private final RectF box = new RectF();
    private final List<AiTranslate.Block> blocks = new ArrayList<>();
    private Bitmap frame;

    public AiOverlayView(Context context) {
        this(context, null);
    }

    public AiOverlayView(Context context, AttributeSet attrs) {
        super(context, attrs);
        text.setTextAlign(Paint.Align.CENTER);
        panel.setColor(0xB0000000);
    }

    public void show(List<AiTranslate.Block> result, Bitmap sourceFrame) {
        blocks.clear();
        if (result != null) {
            blocks.addAll(result);
        }
        frame = sourceFrame;
        setVisibility(blocks.isEmpty() ? GONE : VISIBLE);
        invalidate();
    }

    public void hide() {
        blocks.clear();
        frame = null;
        setVisibility(GONE);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        if (blocks.isEmpty() || getWidth() <= 0 || getHeight() <= 0) {
            return;
        }
        int w = getWidth();
        int h = getHeight();
        float density = getResources().getDisplayMetrics().density;
        for (AiTranslate.Block block : blocks) {
            float left = block.x * w;
            float top = block.y * h;
            float right = left + block.w * w;
            float bottom = top + block.h * h;
            box.set(left - 3 * density, top - 3 * density,
                    right + 3 * density, bottom + 3 * density);
            float brightness = frame != null ? AiTranslate.blockBrightness(frame, block) : 0f;
            boolean darkBackdrop = brightness < 128f;
            panel.setColor(darkBackdrop ? 0x99000000 : 0x99FFFFFF);
            canvas.drawRoundRect(box, 4 * density, 4 * density, panel);
            text.setColor(darkBackdrop ? 0xFFFFFFFF : 0xFF111111);
            text.setTextSize(Math.max(11 * density, box.height() * 0.62f));
            canvas.save();
            canvas.clipRect(box);
            drawWrapped(canvas, block.text, box);
            canvas.restore();
        }
    }

    private void drawWrapped(Canvas canvas, String message, RectF box) {
        float lineHeight = text.getTextSize() * 1.25f;
        Paint.FontMetrics metrics = text.getFontMetrics();
        float total = (metrics.descent - metrics.ascent) * Math.max(1, lineCount(message, box.width()));
        float y = box.centerY() - total / 2f - metrics.ascent;
        StringBuilder line = new StringBuilder();
        for (int i = 0; i < message.length(); i++) {
            char c = message.charAt(i);
            line.append(c);
            if (text.measureText(line.toString()) > box.width() - 4f || c == '\n') {
                canvas.drawText(line.toString().replace("\n", ""), box.centerX(), y, text);
                y += lineHeight;
                line.setLength(0);
            }
        }
        if (line.length() > 0) {
            canvas.drawText(line.toString(), box.centerX(), y, text);
        }
    }

    private int lineCount(String message, float width) {
        int lines = 1;
        float used = 0;
        for (int i = 0; i < message.length(); i++) {
            used += text.measureText(String.valueOf(message.charAt(i)));
            if (used > width - 4f) {
                lines++;
                used = 0;
            }
        }
        return lines;
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        if (event.getActionMasked() == MotionEvent.ACTION_DOWN) {
            hide();
            return true;
        }
        return true;
    }
}
