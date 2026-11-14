package com.game.boy.viewUi;

import ADYaiT.AmA8tU;
import ADYaiT.CtFAbx;
import I3HV03.A4TApA;
import Mm8v1u.A5SV6n;
import Mm8v1u.ADYaiT;
import Mm8v1u.AMqCpz;
import Mm8v1u.ASJ6gh;
import android.content.Context;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.PointF;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.SurfaceTexture;
import android.text.TextPaint;
import android.util.AttributeSet;
import android.util.SparseArray;
import android.util.TypedValue;
import android.view.Choreographer;
import android.view.TextureView;
import android.view.View;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import com.sigmob.sdk.base.blurkit.d;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Random;
import java.util.concurrent.ConcurrentHashMap;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public class GameSurfaceView extends TextureView implements TextureView.SurfaceTextureListener {

    /* renamed from: AcNBzu, reason: collision with root package name */
    public volatile boolean f11152AcNBzu;

    /* renamed from: AlLFFp, reason: collision with root package name */
    public int f11153AlLFFp;

    /* renamed from: AmA8tU, reason: collision with root package name */
    public RectF f11154AmA8tU;

    /* renamed from: AzWtSf, reason: collision with root package name */
    public Bitmap f11155AzWtSf;

    /* renamed from: B25kr6, reason: collision with root package name */
    public final Paint f11156B25kr6;

    /* renamed from: B2KMhB, reason: collision with root package name */
    public ASJ6gh f11157B2KMhB;

    /* renamed from: B3GDIM, reason: collision with root package name */
    public int f11158B3GDIM;

    /* renamed from: B4ZgIw, reason: collision with root package name */
    public final ConcurrentHashMap f11159B4ZgIw;

    /* renamed from: B7CMnp, reason: collision with root package name */
    public final SparseArray f11160B7CMnp;

    /* renamed from: B9tovu, reason: collision with root package name */
    public boolean f11161B9tovu;

    /* renamed from: BChYOn, reason: collision with root package name */
    public final Paint f11162BChYOn;

    /* renamed from: BI9f7h, reason: collision with root package name */
    public final A4TApA f11163BI9f7h;

    /* renamed from: BIYEnU, reason: collision with root package name */
    public AmA8tU f11164BIYEnU;

    /* renamed from: BJ7GGh, reason: collision with root package name */
    public boolean f11165BJ7GGh;

    /* renamed from: BNL6CD, reason: collision with root package name */
    public final ArrayList f11166BNL6CD;

    /* renamed from: BPw6Q8, reason: collision with root package name */
    public final Random f11167BPw6Q8;

    /* renamed from: BTvldC, reason: collision with root package name */
    public final TextPaint f11168BTvldC;

    /* renamed from: BV3sI0, reason: collision with root package name */
    public boolean f11169BV3sI0;

    /* renamed from: BmvVmW, reason: collision with root package name */
    public int f11170BmvVmW;

    /* renamed from: BniPrB, reason: collision with root package name */
    public int f11171BniPrB;
    public int BpkvW3;

    /* renamed from: C2rE4F, reason: collision with root package name */
    public Bitmap f11172C2rE4F;

    /* renamed from: C4FrIb, reason: collision with root package name */
    public Bitmap f11173C4FrIb;

    /* renamed from: CASmeH, reason: collision with root package name */
    public boolean f11174CASmeH;

    /* renamed from: CNPG0E, reason: collision with root package name */
    public boolean f11175CNPG0E;

    /* renamed from: COJEAR, reason: collision with root package name */
    public int f11176COJEAR;

    /* renamed from: CQhlFr, reason: collision with root package name */
    public int f11177CQhlFr;

    /* renamed from: CSDoyG, reason: collision with root package name */
    public final ArrayList f11178CSDoyG;

    /* renamed from: CTkVKb, reason: collision with root package name */
    public int f11179CTkVKb;

    /* renamed from: CcAIMM, reason: collision with root package name */
    public volatile boolean f11180CcAIMM;

    /* renamed from: Cd8JRx, reason: collision with root package name */
    public final A5SV6n f11181Cd8JRx;

    /* renamed from: CikNvS, reason: collision with root package name */
    public final Object f11182CikNvS;

    public GameSurfaceView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f11152AcNBzu = false;
        this.f11156B25kr6 = new Paint();
        this.f11157B2KMhB = ASJ6gh.f5488AcNBzu;
        this.f11158B3GDIM = -1;
        this.f11159B4ZgIw = new ConcurrentHashMap();
        this.f11160B7CMnp = new SparseArray();
        this.f11161B9tovu = false;
        this.f11166BNL6CD = new ArrayList();
        this.f11167BPw6Q8 = new Random();
        this.f11169BV3sI0 = false;
        this.f11170BmvVmW = 50;
        this.f11171BniPrB = 5;
        this.BpkvW3 = 20;
        this.f11174CASmeH = true;
        this.f11175CNPG0E = true;
        this.f11176COJEAR = 0;
        this.f11177CQhlFr = 0;
        this.f11179CTkVKb = 0;
        this.f11180CcAIMM = false;
        this.f11181Cd8JRx = new A5SV6n(this);
        this.f11182CikNvS = new Object();
        setSurfaceTextureListener(this);
        A4TApA a4TApA = new A4TApA(getContext(), (String) null);
        this.f11163BI9f7h = a4TApA;
        this.f11153AlLFFp = ((SharedPreferences) a4TApA.f3808AlLFFp).getInt("game_COLOR", -15108398);
        setScaleTypeFromString(((SharedPreferences) this.f11163BI9f7h.f3808AlLFFp).getString("display_style", "center_crop"));
        Paint paint = new Paint();
        this.f11162BChYOn = paint;
        paint.setColor(-16711936);
        this.f11162BChYOn.setStyle(Paint.Style.STROKE);
        this.f11162BChYOn.setStrokeWidth(2.0f);
        this.f11162BChYOn.setAntiAlias(true);
        TextPaint textPaint = new TextPaint();
        this.f11168BTvldC = textPaint;
        textPaint.setAntiAlias(true);
        this.f11168BTvldC.setTextSize(this.f11170BmvVmW);
        this.f11168BTvldC.setColor(-1);
        this.f11168BTvldC.setStyle(Paint.Style.FILL);
        this.f11168BTvldC.setShadowLayer(3.0f, 2.0f, 2.0f, d.f13043a);
        this.f11178CSDoyG = new ArrayList();
    }

    private int getRandomColor() {
        return new int[]{-1, -256, -16711681, -16711936, -65281, -65536, Color.rgb(255, MediaPlayer.MEDIA_PLAYER_OPTION_SUPER_RES_OPTION, 0)}[this.f11167BPw6Q8.nextInt(7)];
    }

    private void setScaleTypeFromString(String str) {
        ASJ6gh aSJ6gh;
        str.getClass();
        aSJ6gh = ASJ6gh.f5488AcNBzu;
        switch (str) {
            case "fit_xy":
                setBackgroundScaleType(ASJ6gh.f5490AmA8tU);
                break;
            case "center_inside":
                setBackgroundScaleType(ASJ6gh.f5489AlLFFp);
                break;
            case "original":
                setBackgroundScaleType(ASJ6gh.f5491AzWtSf);
                break;
            case "center_crop":
                setBackgroundScaleType(aSJ6gh);
                break;
            default:
                setBackgroundScaleType(aSJ6gh);
                break;
        }
    }

    public final void A2egSU(String str) {
        if (!this.f11169BV3sI0 || str == null || str.isEmpty()) {
            return;
        }
        float measureText = this.f11168BTvldC.measureText(str);
        int height = getHeight();
        if (height <= 0) {
            return;
        }
        int i = height / 3;
        int i2 = this.f11170BmvVmW;
        float f = i2;
        float f2 = i - i2;
        if (f2 <= f) {
            f = i / 2;
            f2 = f;
        }
        float A4TApA2 = CtFAbx.A4TApA(f2, f, this.f11167BPw6Q8.nextFloat(), f);
        AMqCpz aMqCpz = new AMqCpz();
        aMqCpz.f5475A2egSU = str;
        aMqCpz.f5476A4TApA = getWidth();
        aMqCpz.f5477A5SV6n = A4TApA2;
        aMqCpz.f5478ADYaiT = measureText;
        aMqCpz.AMqCpz = this.f11167BPw6Q8.nextInt(5) + this.f11171BniPrB;
        aMqCpz.f5479ARc23Z = getRandomColor();
        aMqCpz.A2egSU(this.f11168BTvldC);
        synchronized (this.f11166BNL6CD) {
            this.f11166BNL6CD.add(aMqCpz);
        }
    }

    public final void A4TApA() {
        synchronized (this.f11182CikNvS) {
            try {
                Bitmap bitmap = this.f11172C2rE4F;
                if (bitmap != null) {
                    try {
                        bitmap.recycle();
                    } catch (Throwable unused) {
                    }
                    this.f11172C2rE4F = null;
                }
                Bitmap bitmap2 = this.f11173C4FrIb;
                if (bitmap2 != null) {
                    try {
                        bitmap2.recycle();
                    } catch (Throwable unused2) {
                    }
                    this.f11173C4FrIb = null;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final void A5SV6n() {
        A4TApA();
        ConcurrentHashMap concurrentHashMap = this.f11159B4ZgIw;
        for (ADYaiT aDYaiT : concurrentHashMap.values()) {
            if (aDYaiT != null) {
                aDYaiT.f5472AZkASS.clear();
                aDYaiT.AMqCpz = null;
                aDYaiT.f5468ARc23Z = null;
                aDYaiT.f5469ASJ6gh = null;
            }
        }
        concurrentHashMap.clear();
        this.f11175CNPG0E = true;
        synchronized (this.f11166BNL6CD) {
            this.f11166BNL6CD.clear();
        }
    }

    public final void ADYaiT(Canvas canvas) {
        AlLFFp();
        synchronized (this.f11166BNL6CD) {
            try {
                Iterator it = this.f11166BNL6CD.iterator();
                while (it.hasNext()) {
                    AMqCpz(canvas, (AMqCpz) it.next());
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final void AMqCpz(Canvas canvas, AMqCpz aMqCpz) {
        this.f11168BTvldC.setColor(aMqCpz.f5479ARc23Z);
        this.f11168BTvldC.setTextAlign(Paint.Align.LEFT);
        if (!aMqCpz.f5482AZOQYO) {
            aMqCpz.A2egSU(this.f11168BTvldC);
        }
        canvas.drawText(aMqCpz.f5475A2egSU, aMqCpz.f5476A4TApA, aMqCpz.f5481AYUAbz, this.f11168BTvldC);
        if (!this.f11161B9tovu || aMqCpz.f5480ASJ6gh == null) {
            return;
        }
        Paint paint = new Paint();
        paint.setColor(-65536);
        paint.setStyle(Paint.Style.STROKE);
        paint.setStrokeWidth(1.0f);
        float f = aMqCpz.f5476A4TApA;
        float f2 = aMqCpz.f5481AYUAbz;
        Rect rect = aMqCpz.f5480ASJ6gh;
        canvas.drawRect(f, rect.top + f2, f + rect.width(), aMqCpz.f5481AYUAbz + aMqCpz.f5480ASJ6gh.bottom, paint);
    }

    public final void ARc23Z(Canvas canvas) {
        int width = getWidth();
        int height = getHeight();
        int width2 = this.f11155AzWtSf.getWidth();
        int height2 = this.f11155AzWtSf.getHeight();
        int ordinal = this.f11157B2KMhB.ordinal();
        Paint paint = this.f11156B25kr6;
        if (ordinal == 0) {
            float f = width;
            float f2 = width2;
            float f3 = height;
            float f4 = height2;
            float max = Math.max(f / f2, f3 / f4);
            float f5 = f2 * max;
            float f6 = f4 * max;
            float f7 = (f - f5) / 2.0f;
            float f8 = (f3 - f6) / 2.0f;
            canvas.drawBitmap(this.f11155AzWtSf, (Rect) null, new RectF(f7, f8, f5 + f7, f6 + f8), paint);
            return;
        }
        if (ordinal != 1) {
            if (ordinal == 2) {
                canvas.drawBitmap(this.f11155AzWtSf, (Rect) null, new RectF(0.0f, 0.0f, width, height), paint);
                return;
            } else {
                if (ordinal != 3) {
                    return;
                }
                canvas.drawBitmap(this.f11155AzWtSf, (width - width2) / 2.0f, (height - height2) / 2.0f, paint);
                return;
            }
        }
        float f9 = width;
        float f10 = width2;
        float f11 = height;
        float f12 = height2;
        float min = Math.min(f9 / f10, f11 / f12);
        float f13 = f10 * min;
        float f14 = f12 * min;
        float f15 = (f9 - f13) / 2.0f;
        float f16 = (f11 - f14) / 2.0f;
        canvas.drawBitmap(this.f11155AzWtSf, (Rect) null, new RectF(f15, f16, f13 + f15, f14 + f16), paint);
    }

    public final void ASJ6gh() {
        this.f11153AlLFFp = ((SharedPreferences) this.f11163BI9f7h.f3808AlLFFp).getInt("game_COLOR", -15108398);
        this.f11169BV3sI0 = ((SharedPreferences) this.f11163BI9f7h.f3808AlLFFp).getBoolean("danmaku_enabled", false);
        this.f11170BmvVmW = ((SharedPreferences) this.f11163BI9f7h.f3808AlLFFp).getInt("danmaku_text_size", 50);
        this.f11171BniPrB = ((SharedPreferences) this.f11163BI9f7h.f3808AlLFFp).getInt("danmaku_speed", 5);
        this.BpkvW3 = ((SharedPreferences) this.f11163BI9f7h.f3808AlLFFp).getInt("danmaku_max_count", 20);
        setDanmakuTextSizeSp(this.f11170BmvVmW);
        setDanmakuSpeed(this.f11171BniPrB);
        setDanmakuMaxCount(this.BpkvW3);
    }

    public final void AYUAbz(Canvas canvas) {
        RectF rectF;
        if (this.f11174CASmeH) {
            setScaleTypeFromString(((SharedPreferences) this.f11163BI9f7h.f3808AlLFFp).getString("display_style", "center_crop"));
        }
        int width = canvas.getWidth();
        int height = canvas.getHeight();
        if (width != this.f11176COJEAR || height != this.f11177CQhlFr) {
            this.f11174CASmeH = true;
            this.f11175CNPG0E = true;
            this.f11176COJEAR = width;
            this.f11177CQhlFr = height;
        }
        if (this.f11174CASmeH) {
            AaHO0E(canvas);
        }
        if (this.f11175CNPG0E) {
            AcNBzu(canvas);
        }
        int i = 0;
        canvas.drawColor(0, PorterDuff.Mode.CLEAR);
        synchronized (this.f11182CikNvS) {
            try {
                Bitmap bitmap = this.f11172C2rE4F;
                if ((bitmap == null || bitmap.isRecycled()) ? false : true) {
                    try {
                        canvas.drawBitmap(bitmap, 0.0f, 0.0f, (Paint) null);
                    } catch (Throwable unused) {
                        this.f11172C2rE4F = null;
                        this.f11174CASmeH = true;
                    }
                } else if (bitmap != null) {
                    this.f11172C2rE4F = null;
                    this.f11174CASmeH = true;
                }
                Bitmap bitmap2 = this.f11173C4FrIb;
                if ((bitmap2 == null || bitmap2.isRecycled()) ? false : true) {
                    try {
                        canvas.drawBitmap(bitmap2, 0.0f, 0.0f, (Paint) null);
                    } catch (Throwable unused2) {
                        this.f11173C4FrIb = null;
                        this.f11175CNPG0E = true;
                    }
                } else if (bitmap2 != null) {
                    this.f11173C4FrIb = null;
                    this.f11175CNPG0E = true;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        if (this.f11169BV3sI0 && !this.f11166BNL6CD.isEmpty()) {
            try {
                ADYaiT(canvas);
            } catch (Throwable unused3) {
            }
        }
        if (!this.f11161B9tovu) {
            return;
        }
        for (ADYaiT aDYaiT : this.f11159B4ZgIw.values()) {
            if (aDYaiT != null && (rectF = aDYaiT.f5465A4TApA) != null) {
                canvas.drawRect(rectF, this.f11162BChYOn);
            }
        }
        while (true) {
            SparseArray sparseArray = this.f11160B7CMnp;
            if (i >= sparseArray.size()) {
                return;
            }
            PointF pointF = (PointF) sparseArray.valueAt(i);
            if (pointF != null) {
                canvas.drawCircle(pointF.x, pointF.y, 15.0f, this.f11162BChYOn);
            }
            i++;
        }
    }

    public final void AZOQYO() {
        Canvas canvas;
        if (!isAvailable()) {
            return;
        }
        try {
            if (!this.f11152AcNBzu) {
                return;
            }
            try {
                canvas = lockCanvas();
                if (canvas != null) {
                    try {
                        synchronized (this.f11182CikNvS) {
                            try {
                                if (this.f11152AcNBzu) {
                                    AYUAbz(canvas);
                                }
                            } catch (Throwable th) {
                                throw th;
                            }
                        }
                    } catch (Throwable unused) {
                        if (canvas != null) {
                            unlockCanvasAndPost(canvas);
                            return;
                        }
                        return;
                    }
                } else if (canvas == null) {
                    return;
                }
                unlockCanvasAndPost(canvas);
            } catch (Throwable unused2) {
                canvas = null;
            }
        } catch (Throwable unused3) {
        }
    }

    public final void AZkASS(int i, String str) {
        boolean z;
        int max;
        ADYaiT aDYaiT = (ADYaiT) this.f11159B4ZgIw.get(str);
        if (aDYaiT == null || !(z = aDYaiT.f5467ADYaiT) || aDYaiT.f5470AYUAbz == i) {
            return;
        }
        if (z && aDYaiT.f5470AYUAbz != (max = Math.max(0, Math.min(8, i)))) {
            aDYaiT.f5470AYUAbz = max;
        }
        this.f11175CNPG0E = true;
    }

    public final void AaHO0E(Canvas canvas) {
        if (this.f11174CASmeH) {
            boolean z = false;
            this.f11174CASmeH = false;
            int width = canvas.getWidth();
            int height = canvas.getHeight();
            if (width <= 0 || height <= 0) {
                return;
            }
            int i = getResources().getConfiguration().orientation;
            boolean z2 = i == 2;
            if (this.f11165BJ7GGh) {
                return;
            }
            if (z2 && ((SharedPreferences) this.f11163BI9f7h.f3808AlLFFp).getBoolean("stretchToFit", false)) {
                return;
            }
            if (!((SharedPreferences) this.f11163BI9f7h.f3808AlLFFp).getBoolean("enable_background_effect", false)) {
                Bitmap bitmap = this.f11155AzWtSf;
                if (bitmap != null && !bitmap.isRecycled()) {
                    try {
                        this.f11155AzWtSf.recycle();
                    } catch (Throwable unused) {
                    }
                    this.f11155AzWtSf = null;
                }
            } else if (i != this.f11158B3GDIM || this.f11155AzWtSf == null) {
                String string = z2 ? ((SharedPreferences) this.f11163BI9f7h.f3808AlLFFp).getString("landscape_background_image", null) : ((SharedPreferences) this.f11163BI9f7h.f3808AlLFFp).getString("portrait_background_image", null);
                Bitmap bitmap2 = this.f11155AzWtSf;
                if (bitmap2 != null && !bitmap2.isRecycled()) {
                    try {
                        this.f11155AzWtSf.recycle();
                    } catch (Throwable unused2) {
                    }
                    this.f11155AzWtSf = null;
                }
                if (string != null && !string.isEmpty()) {
                    try {
                        this.f11155AzWtSf = BitmapFactory.decodeFile(string);
                    } catch (Throwable unused3) {
                        this.f11155AzWtSf = null;
                    }
                }
                this.f11158B3GDIM = i;
            }
            try {
                Bitmap bitmap3 = this.f11172C2rE4F;
                Bitmap createBitmap = (bitmap3 == null || bitmap3.getWidth() != width || this.f11172C2rE4F.getHeight() != height || this.f11172C2rE4F.isRecycled()) ? Bitmap.createBitmap(width, height, Bitmap.Config.ARGB_8888) : null;
                synchronized (this.f11182CikNvS) {
                    if (createBitmap != null) {
                        Bitmap bitmap4 = this.f11172C2rE4F;
                        if (bitmap4 != null && !bitmap4.isRecycled()) {
                            try {
                                this.f11172C2rE4F.recycle();
                            } catch (Throwable unused4) {
                            }
                        }
                        this.f11172C2rE4F = createBitmap;
                    }
                    Bitmap bitmap5 = this.f11172C2rE4F;
                    if (bitmap5 != null && !bitmap5.isRecycled()) {
                        try {
                            Canvas canvas2 = new Canvas(this.f11172C2rE4F);
                            PorterDuff.Mode mode = PorterDuff.Mode.CLEAR;
                            canvas2.drawColor(0, mode);
                            Bitmap bitmap6 = this.f11155AzWtSf;
                            if (bitmap6 != null && !bitmap6.isRecycled()) {
                                z = true;
                            }
                            if (z) {
                                ARc23Z(canvas2);
                            } else {
                                canvas2.drawColor(this.f11153AlLFFp);
                            }
                            if (this.f11154AmA8tU != null) {
                                Paint paint = new Paint();
                                paint.setXfermode(new PorterDuffXfermode(mode));
                                canvas2.drawRect(this.f11154AmA8tU, paint);
                                return;
                            }
                            return;
                        } catch (Throwable unused5) {
                            return;
                        }
                    }
                    this.f11174CASmeH = true;
                }
            } catch (Throwable unused6) {
                this.f11174CASmeH = true;
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:20:0x003e  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void AcNBzu(android.graphics.Canvas r5) {
        /*
            r4 = this;
            boolean r0 = r4.f11175CNPG0E
            if (r0 != 0) goto L6
            goto L94
        L6:
            r0 = 0
            r4.f11175CNPG0E = r0
            int r1 = r5.getWidth()
            int r5 = r5.getHeight()
            if (r1 <= 0) goto L94
            if (r5 > 0) goto L17
            goto L94
        L17:
            r2 = 1
            android.graphics.Bitmap r3 = r4.f11173C4FrIb     // Catch: java.lang.Throwable -> L92
            if (r3 == 0) goto L35
            int r3 = r3.getWidth()     // Catch: java.lang.Throwable -> L92
            if (r3 != r1) goto L35
            android.graphics.Bitmap r3 = r4.f11173C4FrIb     // Catch: java.lang.Throwable -> L92
            int r3 = r3.getHeight()     // Catch: java.lang.Throwable -> L92
            if (r3 != r5) goto L35
            android.graphics.Bitmap r3 = r4.f11173C4FrIb     // Catch: java.lang.Throwable -> L92
            boolean r3 = r3.isRecycled()     // Catch: java.lang.Throwable -> L92
            if (r3 == 0) goto L33
            goto L35
        L33:
            r5 = 0
            goto L3b
        L35:
            android.graphics.Bitmap$Config r3 = android.graphics.Bitmap.Config.ARGB_8888     // Catch: java.lang.Throwable -> L92
            android.graphics.Bitmap r5 = android.graphics.Bitmap.createBitmap(r1, r5, r3)     // Catch: java.lang.Throwable -> L92
        L3b:
            java.lang.Object r1 = r4.f11182CikNvS
            monitor-enter(r1)
            if (r5 == 0) goto L54
            android.graphics.Bitmap r3 = r4.f11173C4FrIb     // Catch: java.lang.Throwable -> L50
            if (r3 == 0) goto L52
            boolean r3 = r3.isRecycled()     // Catch: java.lang.Throwable -> L50
            if (r3 != 0) goto L52
            android.graphics.Bitmap r3 = r4.f11173C4FrIb     // Catch: java.lang.Throwable -> L52
            r3.recycle()     // Catch: java.lang.Throwable -> L52
            goto L52
        L50:
            r5 = move-exception
            goto L90
        L52:
            r4.f11173C4FrIb = r5     // Catch: java.lang.Throwable -> L50
        L54:
            android.graphics.Bitmap r5 = r4.f11173C4FrIb     // Catch: java.lang.Throwable -> L50
            if (r5 == 0) goto L8c
            boolean r5 = r5.isRecycled()     // Catch: java.lang.Throwable -> L50
            if (r5 == 0) goto L5f
            goto L8c
        L5f:
            monitor-exit(r1)     // Catch: java.lang.Throwable -> L50
            android.graphics.Canvas r5 = new android.graphics.Canvas     // Catch: java.lang.Throwable -> L94
            android.graphics.Bitmap r1 = r4.f11173C4FrIb     // Catch: java.lang.Throwable -> L94
            r5.<init>(r1)     // Catch: java.lang.Throwable -> L94
            android.graphics.PorterDuff$Mode r1 = android.graphics.PorterDuff.Mode.CLEAR     // Catch: java.lang.Throwable -> L94
            r5.drawColor(r0, r1)     // Catch: java.lang.Throwable -> L94
            boolean r0 = r4.f11165BJ7GGh     // Catch: java.lang.Throwable -> L94
            if (r0 != 0) goto L94
            java.util.concurrent.ConcurrentHashMap r0 = r4.f11159B4ZgIw     // Catch: java.lang.Throwable -> L94
            java.util.Collection r0 = r0.values()     // Catch: java.lang.Throwable -> L94
            java.util.Iterator r0 = r0.iterator()     // Catch: java.lang.Throwable -> L94
        L7a:
            boolean r1 = r0.hasNext()     // Catch: java.lang.Throwable -> L94
            if (r1 == 0) goto L94
            java.lang.Object r1 = r0.next()     // Catch: java.lang.Throwable -> L94
            Mm8v1u.ADYaiT r1 = (Mm8v1u.ADYaiT) r1     // Catch: java.lang.Throwable -> L94
            if (r1 == 0) goto L7a
            r1.A2egSU(r5)     // Catch: java.lang.Throwable -> L7a
            goto L7a
        L8c:
            r4.f11175CNPG0E = r2     // Catch: java.lang.Throwable -> L50
            monitor-exit(r1)     // Catch: java.lang.Throwable -> L50
            goto L94
        L90:
            monitor-exit(r1)     // Catch: java.lang.Throwable -> L50
            throw r5
        L92:
            r4.f11175CNPG0E = r2
        L94:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.game.boy.viewUi.GameSurfaceView.AcNBzu(android.graphics.Canvas):void");
    }

    public final void AlLFFp() {
        synchronized (this.f11166BNL6CD) {
            try {
                this.f11178CSDoyG.clear();
                Iterator it = this.f11166BNL6CD.iterator();
                while (it.hasNext()) {
                    AMqCpz aMqCpz = (AMqCpz) it.next();
                    float f = aMqCpz.f5476A4TApA - aMqCpz.AMqCpz;
                    aMqCpz.f5476A4TApA = f;
                    if (f + aMqCpz.f5478ADYaiT < 0.0f) {
                        this.f11178CSDoyG.add(aMqCpz);
                    }
                }
                if (!this.f11178CSDoyG.isEmpty()) {
                    this.f11166BNL6CD.removeAll(this.f11178CSDoyG);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public final void onSurfaceTextureAvailable(SurfaceTexture surfaceTexture, int i, int i2) {
        this.f11152AcNBzu = true;
        ASJ6gh();
        this.f11176COJEAR = i;
        this.f11177CQhlFr = i2;
        if (getVisibility() == 0) {
            Choreographer.getInstance().postFrameCallback(this.f11181Cd8JRx);
            AZOQYO();
        }
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public final boolean onSurfaceTextureDestroyed(SurfaceTexture surfaceTexture) {
        this.f11152AcNBzu = false;
        this.f11180CcAIMM = false;
        try {
            Choreographer.getInstance().removeFrameCallback(this.f11181Cd8JRx);
        } catch (Throwable unused) {
        }
        A4TApA();
        return true;
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public final void onSurfaceTextureSizeChanged(SurfaceTexture surfaceTexture, int i, int i2) {
        this.f11174CASmeH = true;
        this.f11175CNPG0E = true;
        this.f11176COJEAR = i;
        this.f11177CQhlFr = i2;
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public final void onSurfaceTextureUpdated(SurfaceTexture surfaceTexture) {
    }

    @Override // android.view.TextureView, android.view.View
    public final void onVisibilityChanged(View view, int i) {
        super.onVisibilityChanged(view, i);
        if (i == 0 && this.f11152AcNBzu) {
            ASJ6gh();
            AZOQYO();
        }
        if (this.f11180CcAIMM) {
            return;
        }
        this.f11180CcAIMM = true;
        Choreographer.getInstance().postFrameCallback(this.f11181Cd8JRx);
    }

    public void setBackgroundAlpha(int i) {
        this.f11156B25kr6.setAlpha(i);
        this.f11174CASmeH = true;
    }

    public void setBackgroundBitmap(Bitmap bitmap) {
        Bitmap bitmap2 = this.f11155AzWtSf;
        if (bitmap2 != null && !bitmap2.isRecycled()) {
            this.f11155AzWtSf.recycle();
        }
        this.f11155AzWtSf = bitmap;
        this.f11174CASmeH = true;
    }

    @Override // android.view.View
    public void setBackgroundResource(int i) {
        try {
            setBackgroundBitmap(BitmapFactory.decodeResource(getResources(), i));
        } catch (Exception unused) {
        }
    }

    public void setBackgroundScaleType(ASJ6gh aSJ6gh) {
        this.f11157B2KMhB = aSJ6gh;
        this.f11174CASmeH = true;
    }

    public void setControlsAlpha(int i) {
        for (ADYaiT aDYaiT : this.f11159B4ZgIw.values()) {
            if (aDYaiT != null) {
                aDYaiT.f5473AaHO0E.setAlpha((int) (((10 - i) / 10.0d) * 255.0d));
            }
        }
        this.f11175CNPG0E = true;
    }

    public void setDanmakuCreateInterval(int i) {
    }

    public void setDanmakuEnabled(boolean z) {
        this.f11169BV3sI0 = z;
        if (z) {
            return;
        }
        synchronized (this.f11166BNL6CD) {
            this.f11166BNL6CD.clear();
        }
    }

    public void setDanmakuMaxCount(int i) {
        this.BpkvW3 = i;
    }

    public void setDanmakuSpeed(int i) {
        this.f11171BniPrB = i;
        synchronized (this.f11166BNL6CD) {
            try {
                Iterator it = this.f11166BNL6CD.iterator();
                while (it.hasNext()) {
                    ((AMqCpz) it.next()).AMqCpz = this.f11167BPw6Q8.nextInt(5) + i;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public void setDanmakuTextSize(int i) {
        this.f11170BmvVmW = i;
        TextPaint textPaint = this.f11168BTvldC;
        if (textPaint != null) {
            textPaint.setTextSize(i);
        }
        synchronized (this.f11166BNL6CD) {
            try {
                Iterator it = this.f11166BNL6CD.iterator();
                while (it.hasNext()) {
                    AMqCpz aMqCpz = (AMqCpz) it.next();
                    aMqCpz.f5482AZOQYO = false;
                    aMqCpz.f5478ADYaiT = this.f11168BTvldC.measureText(aMqCpz.f5475A2egSU);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public void setDanmakuTextSizeSp(int i) {
        setDanmakuTextSize((int) TypedValue.applyDimension(2, i, getResources().getDisplayMetrics()));
    }

    public void setDebugMode(boolean z) {
        this.f11161B9tovu = z;
    }

    public void setDialog(AmA8tU amA8tU) {
        this.f11164BIYEnU = amA8tU;
    }

    public void setPip(boolean z) {
        if (this.f11163BI9f7h.AzWtSf("isPip") && z) {
            this.f11165BJ7GGh = true;
        } else {
            this.f11165BJ7GGh = false;
        }
        this.f11175CNPG0E = true;
    }

    public void setSkipRect(RectF rectF) {
        this.f11154AmA8tU = rectF;
        this.f11174CASmeH = true;
    }
}
