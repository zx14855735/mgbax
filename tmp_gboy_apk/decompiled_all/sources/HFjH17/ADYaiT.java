package HFjH17;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.media.MediaMetadataRetriever;
import android.media.MediaPlayer;
import android.os.Build;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.SeekBar;
import android.widget.TextView;
import java.io.IOException;
import java.util.HashMap;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public final class ADYaiT {

    /* renamed from: A2egSU, reason: collision with root package name */
    public final Context f3288A2egSU;

    /* renamed from: A4TApA, reason: collision with root package name */
    public final String f3289A4TApA;

    /* renamed from: A5SV6n, reason: collision with root package name */
    public final boolean f3290A5SV6n;
    public A2egSU AMqCpz;

    /* renamed from: ARc23Z, reason: collision with root package name */
    public AZkASS f3292ARc23Z;

    /* renamed from: ASJ6gh, reason: collision with root package name */
    public final H0qugq.AZOQYO f3293ASJ6gh;

    /* renamed from: AYUAbz, reason: collision with root package name */
    public A4TApA f3294AYUAbz;

    /* renamed from: AZOQYO, reason: collision with root package name */
    public Handler f3295AZOQYO;

    /* renamed from: AZkASS, reason: collision with root package name */
    public HandlerThread f3296AZkASS;

    /* renamed from: AmA8tU, reason: collision with root package name */
    public final ARc23Z f3300AmA8tU;

    /* renamed from: AzWtSf, reason: collision with root package name */
    public final View f3301AzWtSf;

    /* renamed from: B25kr6, reason: collision with root package name */
    public final FrameLayout f3302B25kr6;

    /* renamed from: B2KMhB, reason: collision with root package name */
    public final SurfaceView f3303B2KMhB;

    /* renamed from: B3GDIM, reason: collision with root package name */
    public SurfaceHolder f3304B3GDIM;

    /* renamed from: B4ZgIw, reason: collision with root package name */
    public MediaPlayer f3305B4ZgIw;

    /* renamed from: B7CMnp, reason: collision with root package name */
    public SeekBar f3306B7CMnp;

    /* renamed from: BJ7GGh, reason: collision with root package name */
    public boolean f3311BJ7GGh;

    /* renamed from: BTvldC, reason: collision with root package name */
    public A4TApA f3314BTvldC;

    /* renamed from: BV3sI0, reason: collision with root package name */
    public ImageView f3315BV3sI0;

    /* renamed from: BniPrB, reason: collision with root package name */
    public int f3317BniPrB;
    public int BpkvW3 = 7;

    /* renamed from: ADYaiT, reason: collision with root package name */
    public boolean f3291ADYaiT = true;

    /* renamed from: AaHO0E, reason: collision with root package name */
    public boolean f3297AaHO0E = false;

    /* renamed from: AcNBzu, reason: collision with root package name */
    public boolean f3298AcNBzu = false;

    /* renamed from: AlLFFp, reason: collision with root package name */
    public boolean f3299AlLFFp = false;

    /* renamed from: B9tovu, reason: collision with root package name */
    public final int[] f3307B9tovu = new int[2];

    /* renamed from: BChYOn, reason: collision with root package name */
    public final int[] f3308BChYOn = new int[2];

    /* renamed from: BI9f7h, reason: collision with root package name */
    public final Object f3309BI9f7h = new Object();

    /* renamed from: BIYEnU, reason: collision with root package name */
    public float f3310BIYEnU = 0.0f;

    /* renamed from: BNL6CD, reason: collision with root package name */
    public boolean f3312BNL6CD = false;

    /* renamed from: BPw6Q8, reason: collision with root package name */
    public boolean f3313BPw6Q8 = false;

    /* renamed from: BmvVmW, reason: collision with root package name */
    public final A4TApA f3316BmvVmW = new A4TApA(this, Looper.getMainLooper(), 2);

    /* JADX WARN: Multi-variable type inference failed */
    public ADYaiT(Context context, String str, View view, boolean z, ASJ6gh aSJ6gh) {
        int i = 3;
        this.f3317BniPrB = 7;
        int i2 = 1;
        this.f3290A5SV6n = true;
        this.f3301AzWtSf = null;
        this.f3311BJ7GGh = false;
        this.f3314BTvldC = new A4TApA(this, Looper.getMainLooper(), i2);
        this.f3288A2egSU = context;
        this.f3289A4TApA = str;
        this.f3301AzWtSf = view;
        this.f3290A5SV6n = z;
        this.f3293ASJ6gh = (H0qugq.AZOQYO) aSJ6gh;
        int i3 = GJee0v.AZOQYO.f3039AcNBzu;
        this.f3302B25kr6 = new FrameLayout(context);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
        layoutParams.gravity = 17;
        SurfaceView surfaceView = new SurfaceView(context);
        this.f3303B2KMhB = surfaceView;
        this.f3302B25kr6.addView(surfaceView, layoutParams);
        this.f3304B3GDIM = this.f3303B2KMhB.getHolder();
        if (view != null) {
            view.getViewTreeObserver().addOnWindowFocusChangeListener(new FdMWEC.ARc23Z(i2, this));
        }
        if (this.f3304B3GDIM == null || str == null || str.isEmpty() || this.f3297AaHO0E) {
            return;
        }
        try {
            MediaPlayer mediaPlayer = new MediaPlayer();
            this.f3305B4ZgIw = mediaPlayer;
            this.f3317BniPrB = 1;
            mediaPlayer.setDataSource(str);
            this.f3317BniPrB = 2;
            if (this.AMqCpz == null) {
                this.AMqCpz = new A2egSU(this);
            }
            this.f3304B3GDIM.addCallback(this.AMqCpz);
            if (this.f3296AZkASS == null) {
                this.f3296AZkASS = new HandlerThread("videoControllerThread");
            }
            if (!this.f3311BJ7GGh) {
                this.f3296AZkASS.start();
                this.f3311BJ7GGh = true;
            }
            A4TApA a4TApA = new A4TApA(this, this.f3296AZkASS.getLooper(), i);
            this.f3294AYUAbz = a4TApA;
            AZkASS aZkASS = new AZkASS(aSJ6gh, this, a4TApA);
            this.f3292ARc23Z = aZkASS;
            aZkASS.A5SV6n();
            this.f3305B4ZgIw.prepareAsync();
            this.f3317BniPrB = 3;
            if (this.f3300AmA8tU == null) {
                MediaPlayer mediaPlayer2 = this.f3305B4ZgIw;
                ARc23Z aRc23Z = new ARc23Z();
                aRc23Z.f3319A2egSU = 0;
                aRc23Z.f3325AYUAbz = null;
                aRc23Z.f3320A4TApA = context;
                aRc23Z.f3321A5SV6n = mediaPlayer2;
                this.f3300AmA8tU = aRc23Z;
            }
        } catch (IOException e) {
            switch (this.f3317BniPrB) {
                case 1:
                case 2:
                case 3:
                case 4:
                case 5:
                case 6:
                case 7:
                case 8:
                case 9:
                case 10:
                    e.getMessage();
                    int i4 = GJee0v.AZOQYO.f3039AcNBzu;
                    this.f3317BniPrB = 8;
                    return;
                default:
                    throw null;
            }
        }
    }

    public static boolean ARc23Z(int[] iArr) {
        return (iArr[0] == 0 || iArr[1] == 0) ? false : true;
    }

    public final Bitmap A2egSU(long j) {
        MediaMetadataRetriever mediaMetadataRetriever = new MediaMetadataRetriever();
        try {
            mediaMetadataRetriever.setDataSource(this.f3289A4TApA, new HashMap());
            Bitmap frameAtTime = Build.VERSION.SDK_INT >= 27 ? mediaMetadataRetriever.getFrameAtTime(j * 1000, 2) : mediaMetadataRetriever.getFrameAtTime(j * 1000);
            mediaMetadataRetriever.release();
            return frameAtTime;
        } catch (Exception unused) {
            mediaMetadataRetriever.release();
            return null;
        } catch (Throwable th) {
            mediaMetadataRetriever.release();
            throw th;
        }
    }

    public final FrameLayout A4TApA(float f) {
        ARc23Z aRc23Z = this.f3300AmA8tU;
        if (((Context) aRc23Z.f3320A4TApA) == null || ((MediaPlayer) aRc23Z.f3321A5SV6n) == null) {
            int i = GJee0v.AZOQYO.f3039AcNBzu;
            return null;
        }
        Context context = (Context) aRc23Z.f3320A4TApA;
        FrameLayout frameLayout = new FrameLayout(context);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
        layoutParams.gravity = 17;
        frameLayout.setLayoutParams(layoutParams);
        aRc23Z.ADYaiT(frameLayout, "#BB7C7C7C", 7.0f, 7.0f, 7.0f, 7.0f);
        aRc23Z.AMqCpz = new TextView(context);
        FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(-2, -2);
        layoutParams2.gravity = 17;
        ((TextView) aRc23Z.AMqCpz).setText("00:00");
        ((TextView) aRc23Z.AMqCpz).setTextSize(f);
        ((TextView) aRc23Z.AMqCpz).setTextColor(Color.parseColor("#FFFFFFFF"));
        ((TextView) aRc23Z.AMqCpz).setGravity(17);
        frameLayout.addView((TextView) aRc23Z.AMqCpz, layoutParams2);
        DG07BK.A2egSU a2egSU = new DG07BK.A2egSU(aRc23Z, Looper.getMainLooper(), 4);
        aRc23Z.f3322ADYaiT = a2egSU;
        a2egSU.sendEmptyMessage(0);
        return frameLayout;
    }

    public final FrameLayout A5SV6n(FOAO9d.A2egSU a2egSU) {
        ARc23Z aRc23Z = this.f3300AmA8tU;
        K1Z3yj.A2egSU a2egSU2 = new K1Z3yj.A2egSU(this, a2egSU, 26, false);
        if (((Context) aRc23Z.f3320A4TApA) == null) {
            int i = GJee0v.AZOQYO.f3039AcNBzu;
            return null;
        }
        Context context = (Context) aRc23Z.f3320A4TApA;
        FrameLayout frameLayout = new FrameLayout(context);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(aRc23Z.A2egSU(47.0f), aRc23Z.A2egSU(18.0f));
        layoutParams.gravity = 17;
        frameLayout.setLayoutParams(layoutParams);
        LinearLayout linearLayout = new LinearLayout(context);
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-1, -1);
        layoutParams2.gravity = 17;
        linearLayout.setGravity(16);
        linearLayout.setOrientation(0);
        linearLayout.setLayoutParams(layoutParams2);
        aRc23Z.ADYaiT(linearLayout, "#80000000", 4.0f, 4.0f, 4.0f, 4.0f);
        ImageView imageView = new ImageView(context);
        LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(0, aRc23Z.A2egSU(12.0f), 14.0f);
        layoutParams3.gravity = 17;
        imageView.setImageBitmap(BitmapFactory.decodeResource(context.getResources(), 2131231423));
        TextView textView = new TextView(context);
        LinearLayout.LayoutParams layoutParams4 = new LinearLayout.LayoutParams(0, -2, 22.0f);
        textView.setText("重播");
        textView.setTextSize(10.0f);
        textView.setTextColor(Color.parseColor("#FFFFFFFF"));
        linearLayout.addView(imageView, layoutParams3);
        linearLayout.addView(textView, layoutParams4);
        frameLayout.addView(linearLayout);
        frameLayout.setOnClickListener(new ADYaiT.A5SV6n(5, a2egSU2));
        return frameLayout;
    }

    public final void ADYaiT(int i) {
        Handler handler = this.f3295AZOQYO;
        if (handler != null) {
            Message obtainMessage = handler.obtainMessage();
            obtainMessage.what = i;
            this.f3295AZOQYO.sendMessage(obtainMessage);
        }
    }

    public final void AMqCpz(int i, int i2) {
        int[] iArr = this.f3308BChYOn;
        iArr[0] = i;
        iArr[1] = i2;
        int[] iArr2 = this.f3307B9tovu;
        int i3 = iArr2[0];
        int i4 = iArr2[1];
        int i5 = GJee0v.AZOQYO.f3039AcNBzu;
        if (ARc23Z(iArr) && ARc23Z(iArr2)) {
            ASJ6gh();
        }
    }

    public final void ASJ6gh() {
        int i = GJee0v.AZOQYO.f3039AcNBzu;
        new A4TApA(this, Looper.getMainLooper(), 0).sendEmptyMessage(0);
    }

    public final void AYUAbz(boolean z) {
        ImageView imageView;
        A4TApA a4TApA = this.f3314BTvldC;
        if (a4TApA != null && z) {
            a4TApA.sendEmptyMessageDelayed(0, 20L);
            return;
        }
        this.f3303B2KMhB.setBackgroundColor(Color.parseColor("#00000000"));
        if (this.f3313BPw6Q8 && (imageView = this.f3315BV3sI0) != null) {
            this.f3302B25kr6.removeView(imageView);
        }
        this.f3298AcNBzu = false;
    }

    public final MediaPlayer AZOQYO() {
        MediaPlayer mediaPlayer = this.f3305B4ZgIw;
        if (mediaPlayer != null) {
            return mediaPlayer;
        }
        int i = GJee0v.AZOQYO.f3039AcNBzu;
        return null;
    }

    public final void AZkASS() {
        ARc23Z aRc23Z = this.f3300AmA8tU;
        if (aRc23Z != null) {
            if (this.f3290A5SV6n) {
                aRc23Z.A5SV6n(0);
            } else {
                aRc23Z.A5SV6n(1);
            }
        }
    }

    public final boolean AaHO0E() {
        int i;
        return (this.f3305B4ZgIw == null || (i = this.f3317BniPrB) == 1 || i == 2 || i == 3 || i == 7 || i == 8 || i == 9) ? false : true;
    }

    public final boolean AcNBzu() {
        int i;
        MediaPlayer mediaPlayer;
        if (!AaHO0E() || (i = this.f3317BniPrB) == 10 || i == 6 || i == 4 || (mediaPlayer = this.f3305B4ZgIw) == null) {
            return false;
        }
        int i2 = GJee0v.AZOQYO.f3039AcNBzu;
        try {
            mediaPlayer.pause();
            this.f3317BniPrB = 10;
            ADYaiT(65540);
            return true;
        } catch (Exception unused) {
            return false;
        }
    }

    public final void AlLFFp() {
        int i = GJee0v.AZOQYO.f3039AcNBzu;
        try {
            MediaPlayer mediaPlayer = this.f3305B4ZgIw;
            if (mediaPlayer != null) {
                mediaPlayer.reset();
                this.f3305B4ZgIw.release();
                this.f3305B4ZgIw = null;
            }
            if (this.f3314BTvldC != null) {
                this.f3314BTvldC = null;
            }
            AZkASS aZkASS = this.f3292ARc23Z;
            if (aZkASS != null) {
                aZkASS.A2egSU();
                this.f3292ARc23Z = null;
            }
            if (this.f3295AZOQYO != null) {
                this.f3295AZOQYO = null;
            }
            if (this.f3294AYUAbz != null) {
                this.f3294AYUAbz = null;
            }
            if (this.f3296AZkASS != null) {
                this.f3296AZkASS = null;
                this.f3311BJ7GGh = false;
            }
            SurfaceHolder surfaceHolder = this.f3304B3GDIM;
            if (surfaceHolder != null) {
                surfaceHolder.removeCallback(this.AMqCpz);
                this.AMqCpz = null;
                this.f3304B3GDIM = null;
            }
            this.f3317BniPrB = 7;
            this.BpkvW3 = 7;
            this.f3297AaHO0E = true;
        } catch (Exception unused) {
        }
    }

    public final boolean AmA8tU() {
        int i;
        if (this.f3305B4ZgIw != null) {
            if (!this.f3299AlLFFp) {
                View view = this.f3301AzWtSf;
                int[] iArr = this.f3308BChYOn;
                if (view != null) {
                    iArr[0] = view.getWidth();
                    iArr[1] = view.getHeight();
                }
                int[] iArr2 = this.f3307B9tovu;
                int i2 = iArr2[0];
                int i3 = iArr2[1];
                int i4 = iArr[0];
                int i5 = iArr[1];
                int i6 = GJee0v.AZOQYO.f3039AcNBzu;
                if (ARc23Z(iArr) && ARc23Z(iArr2)) {
                    ASJ6gh();
                }
            }
            if (!AaHO0E() || (i = this.f3317BniPrB) == 5 || i == 6 || this.f3305B4ZgIw == null) {
                this.BpkvW3 = 5;
                return false;
            }
            int i7 = GJee0v.AZOQYO.f3039AcNBzu;
            if (this.f3298AcNBzu && i != 6) {
                AYUAbz(true);
            }
            try {
                this.f3305B4ZgIw.start();
                this.f3317BniPrB = 5;
                ADYaiT(65539);
                return true;
            } catch (Exception unused) {
            }
        }
        return false;
    }
}
