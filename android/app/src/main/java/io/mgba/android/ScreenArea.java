/* This Source Code Form is subject to the terms of the Mozilla Public
 * License, v. 2.0. If a copy of the MPL was not distributed with this
 * file, You can obtain one at http://mozilla.org/MPL/2.0/. */
package io.mgba.android;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.RectF;
import android.graphics.Shader;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;

/**
 * Stage that hosts the game surface and the on-screen keys. In landscape it
 * behaves like a plain FrameLayout and the keys float over the game. In
 * portrait the game sits in the upper half and the keys fill the lower one.
 *
 * <p>With the handheld shell skin the stage draws the console body around the
 * game: portrait gets the black bezel with the model strip above a colored
 * shell, landscape becomes a full-width handheld body with the screen in the
 * middle, the model name below it and a power LED at the top right.
 */
public class ScreenArea extends FrameLayout {
    private final Paint hingePaint = new Paint();
    private final Paint lowerPaint = new Paint();
    private final Paint bodyPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
    private final Paint bezelPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
    private final Paint bezelEdge = new Paint(Paint.ANTI_ALIAS_FLAG);
    private final Paint titlePaint = new Paint(Paint.ANTI_ALIAS_FLAG);
    private final Paint ledPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
    private final Paint bitmapPaint = new Paint(Paint.ANTI_ALIAS_FLAG | Paint.FILTER_BITMAP_FLAG);
    private final RectF box = new RectF();
    private boolean portraitMode;
    private boolean handheld;
    private SkinTheme skin = SkinTheme.PURPLE;
    private android.graphics.Bitmap skinBackground;
    private float density = 1f;

    public ScreenArea(Context context) {
        this(context, null);
    }

    public ScreenArea(Context context, AttributeSet attrs) {
        super(context, attrs);
        hingePaint.setColor(0xFF2E2E2E);
        lowerPaint.setColor(0xFF0B0B0B);
        bezelEdge.setStyle(Paint.Style.STROKE);
        setWillNotDraw(false);
    }

    /** Portrait stacks game above keys; landscape keeps the full-screen overlay. */
    public void setPortraitMode(boolean on) {
        if (portraitMode == on) {
            return;
        }
        portraitMode = on;
        requestLayout();
        invalidate();
    }

    public boolean isPortraitMode() {
        return portraitMode;
    }

    /** Selects the handheld shell look and its colors. */
    public void setSkin(boolean shell, SkinTheme theme) {
        handheld = shell;
        skin = theme == null ? SkinTheme.PURPLE : theme;
        bezelPaint.setColor(skin.bezel);
        bezelEdge.setColor(0x33FFFFFF);
        titlePaint.setColor(skin.titleText);
        titlePaint.setFakeBoldText(true);
        titlePaint.setTextSkewX(-0.22f);
        bodyPaint.setShader(null);
        skinBackground = null;
        requestLayout();
        invalidate();
    }

    /** Optional imported skin background for the current orientation. */
    public void setSkinBackground(android.graphics.Bitmap background) {
        skinBackground = background;
        invalidate();
    }

    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);
        density = getResources().getDisplayMetrics().density;
    }

    private Shader bodyShader(int w, int h, float y0, float y1) {
        return new LinearGradient(0, y0, 0, y1, skin.bodyTop, skin.bodyBottom, Shader.TileMode.CLAMP);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        if (!portraitMode && handheld) {
            // Landscape shell: the game shrinks to leave a visible body around
            // it, everything else keeps filling the stage.
            int width = MeasureSpec.getSize(widthMeasureSpec);
            int height = MeasureSpec.getSize(heightMeasureSpec);
            for (int i = 0; i < getChildCount(); i++) {
                View child = getChildAt(i);
                if (child.getVisibility() == GONE) {
                    continue;
                }
                MarginLayoutParams lp = (MarginLayoutParams) child.getLayoutParams();
                int childWidth = getChildMeasureSpec(widthMeasureSpec,
                        getPaddingLeft() + getPaddingRight(), lp.width);
                int childHeight = getChildMeasureSpec(heightMeasureSpec,
                        getPaddingTop() + getPaddingBottom(), lp.height);
                if (child.getId() == R.id.game || child.getId() == R.id.hint) {
                    // Center on the body, sized like a GBA screen with its bezel.
                    int boxW = Math.round(width * 0.58f);
                    int boxH = Math.round(height * 0.74f);
                    childWidth = MeasureSpec.makeMeasureSpec(Math.max(1, boxW), MeasureSpec.AT_MOST);
                    childHeight = MeasureSpec.makeMeasureSpec(Math.max(1, boxH), MeasureSpec.AT_MOST);
                }
                child.measure(childWidth, childHeight);
            }
            setMeasuredDimension(resolveSize(width, widthMeasureSpec), resolveSize(height, heightMeasureSpec));
            return;
        }
        if (!portraitMode) {
            super.onMeasure(widthMeasureSpec, heightMeasureSpec);
            return;
        }
        int width = MeasureSpec.getSize(widthMeasureSpec);
        int height = MeasureSpec.getSize(heightMeasureSpec);
        int vertical = getPaddingTop() + getPaddingBottom();
        int half = ScreenSplit.half(Math.max(0, height - vertical));
        for (int i = 0; i < getChildCount(); i++) {
            View child = getChildAt(i);
            if (child.getVisibility() == GONE) {
                continue;
            }
            MarginLayoutParams lp = (MarginLayoutParams) child.getLayoutParams();
            // onLayout() places every child itself (the handle's margins are
            // just an offset marker), so margins must not shrink the space the
            // child is measured against: a margin left over from the other
            // orientation would otherwise collapse it to zero width.
            int childWidth = getChildMeasureSpec(widthMeasureSpec,
                    getPaddingLeft() + getPaddingRight(), lp.width);
            int childHeight;
            if (child.getId() == R.id.game) {
                // The game scales against the upper screen, not the whole stage.
                childHeight = MeasureSpec.makeMeasureSpec(
                        Math.max(0, half - lp.topMargin - lp.bottomMargin), MeasureSpec.AT_MOST);
            } else {
                childHeight = getChildMeasureSpec(heightMeasureSpec, vertical, lp.height);
            }
            child.measure(childWidth, childHeight);
        }
        setMeasuredDimension(resolveSize(width, widthMeasureSpec), resolveSize(height, heightMeasureSpec));
    }

    @Override
    protected void onLayout(boolean changed, int left, int top, int right, int bottom) {
        if (!portraitMode) {
            super.onLayout(changed, left, top, right, bottom);
            return;
        }
        int padLeft = getPaddingLeft();
        int padTop = getPaddingTop();
        int w = right - left - padLeft - getPaddingRight();
        int h = bottom - top - padTop - getPaddingBottom();
        for (int i = 0; i < getChildCount(); i++) {
            View child = getChildAt(i);
            if (child.getVisibility() == GONE) {
                continue;
            }
            MarginLayoutParams lp = (MarginLayoutParams) child.getLayoutParams();
            int cw = child.getMeasuredWidth();
            int ch = child.getMeasuredHeight();
            int[] b = new int[]{(w - cw) / 2, (h - ch) / 2, (w + cw) / 2, (h + ch) / 2};
            if (child.getId() == R.id.controls) {
                b = ScreenSplit.bottomHalf(w, h);
            } else if (child.getId() == R.id.btn_menu) {
                // Centred here rather than from the activity's marker so a
                // stale stage width can never push the handle aside.
                b = ScreenSplit.offsetFromSplit(w, h, (w - cw) / 2, lp.topMargin, cw, ch);
            } else if (child.getId() == R.id.game || child.getId() == R.id.hint) {
                b = ScreenSplit.centerInTopHalf(w, h, cw, ch);
            }
            child.layout(padLeft + b[0], padTop + b[1], padLeft + b[2], padTop + b[3]);
        }
    }

    /** The laid-out bounds of the game surface, or null before the first layout. */
    private RectF gameBounds() {
        for (int i = 0; i < getChildCount(); i++) {
            View child = getChildAt(i);
            if (child.getId() == R.id.game && child.getWidth() > 0) {
                box.set(child.getLeft(), child.getTop(), child.getRight(), child.getBottom());
                return box;
            }
        }
        return null;
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        int w = getWidth();
        int h = getHeight();
        if (w <= 0 || h <= 0) {
            return;
        }
        float split = getPaddingTop()
                + ScreenSplit.half(h - getPaddingTop() - getPaddingBottom());
        if (portraitMode) {
            if (handheld) {
                // Shell fills the lower half; the bezel frames the game with a
                // model strip below it, like a pocket console's face plate.
                if (skinBackground != null && !skinBackground.isRecycled()) {
                    canvas.drawBitmap(skinBackground, null,
                            new RectF(getPaddingLeft(), split, w - getPaddingRight(), h - getPaddingBottom()),
                            bitmapPaint);
                } else {
                    if (bodyPaint.getShader() == null) {
                        bodyPaint.setShader(bodyShader(w, h, split, h));
                    }
                    canvas.drawRect(getPaddingLeft(), split, w - getPaddingRight(), h - getPaddingBottom(), bodyPaint);
                }
                drawScreenPlate(canvas, 26 * density);
            } else {
                int right = w - getPaddingRight();
                // The lower screen gets a slightly lighter backdrop and a
                // "hinge" line, so the portrait stage reads as a two-screen
                // handheld.
                canvas.drawRect(getPaddingLeft(), split, right, h - getPaddingBottom(), lowerPaint);
                canvas.drawRect(getPaddingLeft(), split - 1, right, split + 1, hingePaint);
            }
        } else if (handheld) {
            if (skinBackground != null && !skinBackground.isRecycled()) {
                canvas.drawBitmap(skinBackground, null,
                        new RectF(getPaddingLeft(), getPaddingTop(), w - getPaddingRight(), h - getPaddingBottom()),
                        bitmapPaint);
            } else {
                if (bodyPaint.getShader() == null) {
                    bodyPaint.setShader(bodyShader(w, h, 0, h));
                }
                canvas.drawRect(getPaddingLeft(), getPaddingTop(), w - getPaddingRight(), h - getPaddingBottom(), bodyPaint);
            }
            drawScreenPlate(canvas, 34 * density);
        }
    }

    /**
     * Draws the black screen plate around the game surface: a rounded bezel
     * extending into a model strip that reads "mGBAx". In landscape a green
     * power LED sits at the strip's right end.
     */
    private void drawScreenPlate(Canvas canvas, float strip) {
        RectF game = gameBounds();
        if (game == null) {
            return;
        }
        float pad = 5 * density;
        bezelPaint.setStyle(Paint.Style.FILL);
        float left = game.left - pad;
        float top = game.top - pad;
        float right = game.right + pad;
        float bottom = game.bottom + strip;
        float radius = 12 * density;
        canvas.drawRoundRect(left, top, right, bottom, radius, radius, bezelPaint);
        bezelEdge.setStrokeWidth(Math.max(1f, density));
        canvas.drawRoundRect(left, top, right, bottom, radius, radius, bezelEdge);
        // The screen itself gets a soft inner edge so the picture does not
        // touch the bezel directly.
        canvas.drawRect(game.left, game.top, game.right, game.bottom, bezelEdge);
        if (portraitMode) {
            // Strip holds the model name, centred between screen and shell.
            float ty = game.bottom + strip * 0.72f;
            titlePaint.setTextSize(strip * 0.42f);
            titlePaint.setTextAlign(Paint.Align.CENTER);
            titlePaint.setColor(0xFFE7B23A);
            canvas.drawText("mGBAx", game.centerX(), ty, titlePaint);
            titlePaint.setColor(skin.titleText);
        } else {
            float ty = game.bottom + strip * 0.78f;
            titlePaint.setTextSize(strip * 0.40f);
            titlePaint.setTextAlign(Paint.Align.CENTER);
            titlePaint.setColor(0xFFE7B23A);
            canvas.drawText("mGBAx", game.centerX(), ty, titlePaint);
            titlePaint.setColor(skin.titleText);
            // Power LED at the strip's right end.
            float led = 2.4f * density;
            ledPaint.setColor(0xFF7CFC00);
            canvas.drawCircle(right - pad - led * 2.2f, game.bottom + strip * 0.5f, led, ledPaint);
        }
    }
}
