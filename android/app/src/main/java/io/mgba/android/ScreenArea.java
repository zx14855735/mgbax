/* This Source Code Form is subject to the terms of the Mozilla Public
 * License, v. 2.0. If a copy of the MPL was not distributed with this
 * file, You can obtain one at http://mozilla.org/MPL/2.0/. */
package io.mgba.android;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;

/**
 * Stage that hosts the game surface and the on-screen keys. In landscape it
 * behaves like a plain FrameLayout and the keys float over the game. In
 * portrait it turns into a DS-like pair of screens: the game centered on the
 * upper screen, the keys filling the lower one, split at the middle of the
 * stage.
 */
public class ScreenArea extends FrameLayout {
    private final Paint hingePaint = new Paint();
    private final Paint lowerPaint = new Paint();
    private boolean portraitMode;

    public ScreenArea(Context context) {
        this(context, null);
    }

    public ScreenArea(Context context, AttributeSet attrs) {
        super(context, attrs);
        hingePaint.setColor(0xFF2E2E2E);
        lowerPaint.setColor(0xFF0B0B0B);
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

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
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
            int[] box = new int[]{(w - cw) / 2, (h - ch) / 2, (w + cw) / 2, (h + ch) / 2};
            if (child.getId() == R.id.controls) {
                box = ScreenSplit.bottomHalf(w, h);
            } else if (child.getId() == R.id.btn_menu) {
                // Centred here rather than from the activity's marker so a
                // stale stage width can never push the handle aside.
                box = ScreenSplit.offsetFromSplit(w, h, (w - cw) / 2, lp.topMargin, cw, ch);
            } else if (child.getId() == R.id.game || child.getId() == R.id.hint) {
                box = ScreenSplit.centerInTopHalf(w, h, cw, ch);
            }
            child.layout(padLeft + box[0], padTop + box[1], padLeft + box[2], padTop + box[3]);
        }
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (!portraitMode || getWidth() <= 0 || getHeight() <= 0) {
            return;
        }
        float split = getPaddingTop()
                + ScreenSplit.half(getHeight() - getPaddingTop() - getPaddingBottom());
        int right = getWidth() - getPaddingRight();
        // The lower screen gets a slightly lighter backdrop and a "hinge" line,
        // so the portrait stage reads as a two-screen handheld.
        canvas.drawRect(getPaddingLeft(), split, right, getHeight() - getPaddingBottom(), lowerPaint);
        canvas.drawRect(getPaddingLeft(), split - 1, right, split + 1, hingePaint);
    }
}
