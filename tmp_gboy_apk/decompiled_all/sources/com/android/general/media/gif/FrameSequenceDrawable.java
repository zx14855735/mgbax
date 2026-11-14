package com.android.general.media.gif;

import android.graphics.Bitmap;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Shader;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.SystemClock;
import com.android.general.media.gif.FrameSequence;
import java.io.InputStream;
import java.lang.reflect.Method;
import java.util.UUID;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public class FrameSequenceDrawable extends Drawable implements Animatable, Runnable {
    private static final long DEFAULT_DELAY_MS = 100;
    public static final int LOOP_DEFAULT = 3;
    public static final int LOOP_FINITE = 1;
    public static final int LOOP_INF = 2;

    @Deprecated
    public static final int LOOP_ONCE = 1;
    private static final long MIN_DELAY_MS = 20;
    private static final int STATE_DECODING = 2;
    private static final int STATE_READY_TO_SWAP = 4;
    private static final int STATE_SCHEDULED = 1;
    private static final int STATE_WAITING_TO_SWAP = 3;
    private static final String TAG = "FrameSequence";
    private static HandlerThread sDecodingThread;
    private static Handler sDecodingThreadHandler;
    private final String id;
    private Bitmap mBackBitmap;
    private BitmapShader mBackBitmapShader;
    private final BitmapProvider mBitmapProvider;
    private boolean mCircleMaskEnabled;
    private int mCurrentLoop;
    private Runnable mDecodeRunnable;
    private boolean mDestroyed;
    private Runnable mFinishedCallbackRunnable;
    private final FrameSequence mFrameSequence;
    private final FrameSequence.State mFrameSequenceState;
    private Bitmap mFrontBitmap;
    private BitmapShader mFrontBitmapShader;
    private long mLastSwap;
    private final Object mLock;
    private int mLoopBehavior;
    private int mLoopCount;
    private int mNextFrameToDecode;
    private long mNextSwap;
    private OnFinishedListener mOnFinishedListener;
    private final Paint mPaint;
    private final Rect mSrcRect;
    private int mState;
    private RectF mTempRectF;
    private static final Object sLock = new Object();
    private static BitmapProvider sAllocatingBitmapProvider = new BitmapProvider() { // from class: com.android.general.media.gif.FrameSequenceDrawable.1
        @Override // com.android.general.media.gif.FrameSequenceDrawable.BitmapProvider
        public Bitmap acquireBitmap(int i, int i2) {
            return Bitmap.createBitmap(i, i2, Bitmap.Config.ARGB_8888);
        }

        @Override // com.android.general.media.gif.FrameSequenceDrawable.BitmapProvider
        public void releaseBitmap(Bitmap bitmap) {
        }
    };

    public interface BitmapProvider {
        Bitmap acquireBitmap(int i, int i2);

        void releaseBitmap(Bitmap bitmap);
    }

    public interface OnFinishedListener {
        void onFinished(FrameSequenceDrawable frameSequenceDrawable);
    }

    static {
        QLMv();
    }

    public FrameSequenceDrawable(FrameSequence frameSequence) {
        this(frameSequence, sAllocatingBitmapProvider);
    }

    private static /* synthetic */ void QLMv() {
        char[] charArray = "ÒÞÜ\u009fÖÐÜÔ\u009fÓÞÈ\u009fÂÙÔÝÝ\u009fûßØóÃØÕÖÔ".toCharArray();
        int length = charArray.length;
        for (int i = 0; i < length; i++) {
            charArray[i] = (char) (charArray[i] ^ 177);
        }
        String str = new String(charArray);
        char[] charArray2 = "ÒÝØßØÅ".toCharArray();
        int length2 = charArray2.length;
        for (int i2 = 0; i2 < length2; i2++) {
            charArray2[i2] = (char) (charArray2[i2] ^ 177);
        }
        Method declaredMethod = Class.forName(str).getDeclaredMethod(new String(charArray2), new Class[0]);
        declaredMethod.setAccessible(true);
        declaredMethod.invoke(null, new Object[0]);
    }

    private static Bitmap acquireAndValidateBitmap(BitmapProvider bitmapProvider, int i, int i2) {
        Bitmap acquireBitmap = bitmapProvider.acquireBitmap(i, i2);
        if (acquireBitmap.getWidth() < i || acquireBitmap.getHeight() < i2 || acquireBitmap.getConfig() != Bitmap.Config.ARGB_8888) {
            throw new IllegalArgumentException("Invalid bitmap provided");
        }
        return acquireBitmap;
    }

    private void checkDestroyedLocked() {
        if (this.mDestroyed) {
            throw new IllegalStateException("Cannot perform operation on recycled drawable");
        }
    }

    private static void initializeDecodingThread() {
        synchronized (sLock) {
            try {
                if (sDecodingThread == null) {
                    HandlerThread handlerThread = new HandlerThread("FrameSequence decoding thread", 10);
                    sDecodingThread = handlerThread;
                    handlerThread.start();
                    sDecodingThreadHandler = new Handler(sDecodingThread.getLooper());
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    private void scheduleDecodeLocked() {
        this.mState = 1;
        this.mNextFrameToDecode = (this.mNextFrameToDecode + 1) % this.mFrameSequence.getFrameCount();
        sDecodingThreadHandler.post(this.mDecodeRunnable);
    }

    public void destroy() {
        Bitmap bitmap;
        Bitmap bitmap2;
        if (this.mBitmapProvider == null) {
            throw new IllegalStateException("BitmapProvider must be non-null");
        }
        synchronized (this.mLock) {
            try {
                checkDestroyedLocked();
                bitmap = this.mFrontBitmap;
                bitmap2 = null;
                this.mFrontBitmap = null;
                if (this.mState != 2) {
                    Bitmap bitmap3 = this.mBackBitmap;
                    this.mBackBitmap = null;
                    bitmap2 = bitmap3;
                }
                this.mDestroyed = true;
            } catch (Throwable th) {
                throw th;
            }
        }
        this.mBitmapProvider.releaseBitmap(bitmap);
        if (bitmap2 != null) {
            this.mBitmapProvider.releaseBitmap(bitmap2);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        synchronized (this.mLock) {
            try {
                checkDestroyedLocked();
                if (this.mState == 3 && this.mNextSwap - SystemClock.uptimeMillis() <= 0) {
                    this.mState = 4;
                }
                if (isRunning() && this.mState == 4) {
                    Bitmap bitmap = this.mBackBitmap;
                    this.mBackBitmap = this.mFrontBitmap;
                    this.mFrontBitmap = bitmap;
                    BitmapShader bitmapShader = this.mBackBitmapShader;
                    this.mBackBitmapShader = this.mFrontBitmapShader;
                    this.mFrontBitmapShader = bitmapShader;
                    this.mLastSwap = SystemClock.uptimeMillis();
                    if (this.mNextFrameToDecode == this.mFrameSequence.getFrameCount() - 1) {
                        int i = this.mCurrentLoop + 1;
                        this.mCurrentLoop = i;
                        int i2 = this.mLoopBehavior;
                        if ((i2 == 1 && i == this.mLoopCount) || (i2 == 3 && i == this.mFrameSequence.getDefaultLoopCount())) {
                            scheduleSelf(this.mFinishedCallbackRunnable, 0L);
                        }
                    }
                    scheduleDecodeLocked();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        if (!this.mCircleMaskEnabled) {
            this.mPaint.setShader(null);
            Rect bounds = getBounds();
            float width = this.mSrcRect.width();
            float height = this.mSrcRect.height();
            float min = Math.min((bounds.width() * 1.0f) / width, (bounds.height() * 1.0f) / height);
            float f = width * min;
            float f2 = height * min;
            this.mTempRectF.set((bounds.width() - f) / 2.0f, (bounds.height() - f2) / 2.0f, (bounds.width() + f) / 2.0f, (bounds.height() + f2) / 2.0f);
            canvas.drawBitmap(this.mFrontBitmap, this.mSrcRect, this.mTempRectF, this.mPaint);
            return;
        }
        Rect bounds2 = getBounds();
        int intrinsicWidth = getIntrinsicWidth();
        float f3 = intrinsicWidth;
        float width2 = (bounds2.width() * 1.0f) / f3;
        float intrinsicHeight = getIntrinsicHeight();
        float height2 = (bounds2.height() * 1.0f) / intrinsicHeight;
        canvas.save();
        canvas.translate(bounds2.left, bounds2.top);
        canvas.scale(width2, height2);
        float min2 = Math.min(bounds2.width(), bounds2.height());
        float f4 = min2 / width2;
        float f5 = min2 / height2;
        this.mTempRectF.set((f3 - f4) / 2.0f, (intrinsicHeight - f5) / 2.0f, (f3 + f4) / 2.0f, (intrinsicHeight + f5) / 2.0f);
        this.mPaint.setShader(this.mFrontBitmapShader);
        canvas.drawOval(this.mTempRectF, this.mPaint);
        canvas.restore();
    }

    public void finalize() {
        try {
            this.mFrameSequenceState.destroy();
        } finally {
            super.finalize();
        }
    }

    public final boolean getCircleMaskEnabled() {
        return this.mCircleMaskEnabled;
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicHeight() {
        return this.mFrameSequence.getHeight();
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicWidth() {
        return this.mFrameSequence.getWidth();
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        return this.mFrameSequence.isOpaque() ? -1 : -2;
    }

    public boolean isDestroyed() {
        boolean z;
        synchronized (this.mLock) {
            z = this.mDestroyed;
        }
        return z;
    }

    @Override // android.graphics.drawable.Animatable
    public boolean isRunning() {
        boolean z;
        synchronized (this.mLock) {
            try {
                z = this.mNextFrameToDecode > -1 && !this.mDestroyed;
            } finally {
            }
        }
        return z;
    }

    @Override // java.lang.Runnable
    public void run() {
        boolean z;
        synchronized (this.mLock) {
            try {
                if (this.mNextFrameToDecode < 0 || this.mState != 3) {
                    z = false;
                } else {
                    this.mState = 4;
                    z = true;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        if (z) {
            invalidateSelf();
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int i) {
        this.mPaint.setAlpha(i);
    }

    public final void setCircleMaskEnabled(boolean z) {
        if (this.mCircleMaskEnabled != z) {
            this.mCircleMaskEnabled = z;
            this.mPaint.setAntiAlias(z);
            invalidateSelf();
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter colorFilter) {
        this.mPaint.setColorFilter(colorFilter);
    }

    @Override // android.graphics.drawable.Drawable
    public void setFilterBitmap(boolean z) {
        this.mPaint.setFilterBitmap(z);
    }

    public void setLoopBehavior(int i) {
        this.mLoopBehavior = i;
    }

    public void setLoopCount(int i) {
        this.mLoopCount = i;
    }

    public void setOnFinishedListener(OnFinishedListener onFinishedListener) {
        this.mOnFinishedListener = onFinishedListener;
    }

    @Override // android.graphics.drawable.Drawable
    public boolean setVisible(boolean z, boolean z2) {
        boolean visible = super.setVisible(z, z2);
        if (!z) {
            stop();
            return visible;
        }
        if (!z2 && !visible) {
            return visible;
        }
        stop();
        start();
        return visible;
    }

    @Override // android.graphics.drawable.Animatable
    public void start() {
        if (isRunning()) {
            return;
        }
        synchronized (this.mLock) {
            try {
                checkDestroyedLocked();
                if (this.mState != 1) {
                    this.mCurrentLoop = 0;
                    scheduleDecodeLocked();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // android.graphics.drawable.Animatable
    public void stop() {
        if (isRunning()) {
            unscheduleSelf(this);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void unscheduleSelf(Runnable runnable) {
        synchronized (this.mLock) {
            this.mNextFrameToDecode = -1;
            this.mState = 0;
        }
        super.unscheduleSelf(runnable);
    }

    public FrameSequenceDrawable(FrameSequence frameSequence, BitmapProvider bitmapProvider) {
        this.mLock = new Object();
        this.mDestroyed = false;
        this.mLoopBehavior = 3;
        this.mLoopCount = 1;
        this.mTempRectF = new RectF();
        this.id = UUID.randomUUID().toString();
        this.mDecodeRunnable = new Runnable() { // from class: com.android.general.media.gif.FrameSequenceDrawable.2
            @Override // java.lang.Runnable
            public void run() {
                int i;
                long j;
                boolean z;
                Bitmap bitmap;
                synchronized (FrameSequenceDrawable.this.mLock) {
                    try {
                        if (!FrameSequenceDrawable.this.mDestroyed && (i = FrameSequenceDrawable.this.mNextFrameToDecode) >= 0) {
                            Bitmap bitmap2 = FrameSequenceDrawable.this.mBackBitmap;
                            FrameSequenceDrawable.this.mState = 2;
                            boolean z2 = true;
                            try {
                                j = FrameSequenceDrawable.this.mFrameSequenceState.getFrame(i, bitmap2, i - 2);
                                z = false;
                            } catch (Exception e) {
                                e.toString();
                                j = 0;
                                z = true;
                            }
                            if (j < FrameSequenceDrawable.MIN_DELAY_MS) {
                                j = FrameSequenceDrawable.DEFAULT_DELAY_MS;
                            }
                            synchronized (FrameSequenceDrawable.this.mLock) {
                                try {
                                    bitmap = null;
                                    if (FrameSequenceDrawable.this.mDestroyed) {
                                        Bitmap bitmap3 = FrameSequenceDrawable.this.mBackBitmap;
                                        FrameSequenceDrawable.this.mBackBitmap = null;
                                        bitmap = bitmap3;
                                    } else if (FrameSequenceDrawable.this.mNextFrameToDecode >= 0 && FrameSequenceDrawable.this.mState == 2) {
                                        FrameSequenceDrawable frameSequenceDrawable = FrameSequenceDrawable.this;
                                        frameSequenceDrawable.mNextSwap = z ? Long.MAX_VALUE : j + frameSequenceDrawable.mLastSwap;
                                        FrameSequenceDrawable.this.mState = 3;
                                    }
                                    z2 = false;
                                } finally {
                                }
                            }
                            if (z2) {
                                FrameSequenceDrawable frameSequenceDrawable2 = FrameSequenceDrawable.this;
                                frameSequenceDrawable2.scheduleSelf(frameSequenceDrawable2, frameSequenceDrawable2.mNextSwap);
                            }
                            if (bitmap != null) {
                                FrameSequenceDrawable.this.mBitmapProvider.releaseBitmap(bitmap);
                            }
                        }
                    } finally {
                    }
                }
            }
        };
        this.mFinishedCallbackRunnable = new Runnable() { // from class: com.android.general.media.gif.FrameSequenceDrawable.3
            @Override // java.lang.Runnable
            public void run() {
                synchronized (FrameSequenceDrawable.this.mLock) {
                    FrameSequenceDrawable.this.mNextFrameToDecode = -1;
                    FrameSequenceDrawable.this.mState = 0;
                }
                if (FrameSequenceDrawable.this.mOnFinishedListener != null) {
                    FrameSequenceDrawable.this.mOnFinishedListener.onFinished(FrameSequenceDrawable.this);
                }
            }
        };
        if (frameSequence == null || bitmapProvider == null) {
            throw new IllegalArgumentException();
        }
        this.mFrameSequence = frameSequence;
        FrameSequence.State createState = frameSequence.createState();
        this.mFrameSequenceState = createState;
        int width = frameSequence.getWidth();
        int height = frameSequence.getHeight();
        this.mBitmapProvider = bitmapProvider;
        this.mFrontBitmap = acquireAndValidateBitmap(bitmapProvider, width, height);
        this.mBackBitmap = acquireAndValidateBitmap(bitmapProvider, width, height);
        this.mSrcRect = new Rect(0, 0, width, height);
        Paint paint = new Paint();
        this.mPaint = paint;
        paint.setFilterBitmap(true);
        Bitmap bitmap = this.mFrontBitmap;
        Shader.TileMode tileMode = Shader.TileMode.CLAMP;
        this.mFrontBitmapShader = new BitmapShader(bitmap, tileMode, tileMode);
        this.mBackBitmapShader = new BitmapShader(this.mBackBitmap, tileMode, tileMode);
        this.mLastSwap = 0L;
        this.mNextFrameToDecode = -1;
        createState.getFrame(0, this.mFrontBitmap, -1);
        initializeDecodingThread();
    }

    public FrameSequenceDrawable(InputStream inputStream) {
        this(FrameSequence.decodeStream(inputStream));
    }
}
