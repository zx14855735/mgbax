package HFjH17;

import ADYaiT.D8MqeW;
import android.graphics.Color;
import android.media.MediaPlayer;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.SeekBar;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public final class A4TApA extends Handler {

    /* renamed from: A2egSU, reason: collision with root package name */
    public final /* synthetic */ int f3286A2egSU;

    /* renamed from: A4TApA, reason: collision with root package name */
    public final /* synthetic */ ADYaiT f3287A4TApA;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ A4TApA(ADYaiT aDYaiT, Looper looper, int i) {
        super(looper);
        this.f3286A2egSU = i;
        this.f3287A4TApA = aDYaiT;
    }

    /* JADX WARN: Type inference failed for: r9v57, types: [H0qugq.AZOQYO, HFjH17.ASJ6gh] */
    @Override // android.os.Handler
    public final void handleMessage(Message message) {
        ImageView imageView;
        MediaPlayer mediaPlayer;
        A4TApA a4TApA;
        MediaPlayer mediaPlayer2;
        switch (this.f3286A2egSU) {
            case 0:
                ADYaiT aDYaiT = this.f3287A4TApA;
                super.handleMessage(message);
                try {
                    int[] iArr = aDYaiT.f3307B9tovu;
                    int i = iArr[0];
                    int i2 = iArr[1];
                    int[] iArr2 = aDYaiT.f3308BChYOn;
                    float f = i / i2;
                    float f2 = iArr2[0];
                    float f3 = iArr2[1];
                    float f4 = f2 / f3;
                    ViewGroup.LayoutParams layoutParams = aDYaiT.f3303B2KMhB.getLayoutParams();
                    if (aDYaiT.f3312BNL6CD) {
                        if (f >= f4) {
                            float f5 = f3 * f;
                            if (f5 >= 0.0f) {
                                layoutParams.width = (int) f5;
                            }
                        } else {
                            float f6 = f2 / f;
                            if (f6 >= 0.0f) {
                                layoutParams.height = (int) f6;
                            }
                        }
                    } else if (f >= f4) {
                        float f7 = f2 / f;
                        if (f7 >= 0.0f) {
                            layoutParams.height = (int) f7;
                        }
                    } else {
                        float f8 = f3 * f;
                        if (f8 >= 0.0f) {
                            layoutParams.width = (int) f8;
                        }
                    }
                    aDYaiT.f3303B2KMhB.setLayoutParams(layoutParams);
                    aDYaiT.f3299AlLFFp = true;
                    return;
                } catch (Exception e) {
                    e.getMessage();
                    int i3 = GJee0v.AZOQYO.f3039AcNBzu;
                    return;
                }
            case 1:
                if (Looper.myLooper() == null) {
                    Looper.prepare();
                }
                super.handleMessage(message);
                int i4 = GJee0v.AZOQYO.f3039AcNBzu;
                ADYaiT aDYaiT2 = this.f3287A4TApA;
                aDYaiT2.f3303B2KMhB.setBackgroundColor(Color.parseColor("#00000000"));
                if (aDYaiT2.f3313BPw6Q8 && (imageView = aDYaiT2.f3315BV3sI0) != null) {
                    aDYaiT2.f3302B25kr6.removeView(imageView);
                }
                aDYaiT2.f3298AcNBzu = false;
                return;
            case 2:
                if (Looper.myLooper() == null) {
                    Looper.prepare();
                }
                super.handleMessage(message);
                if (this.f3287A4TApA.f3305B4ZgIw == null) {
                    return;
                }
                GJee0v.AZkASS.f3040ADYaiT.f3041A2egSU.execute(new D8MqeW(14, this));
                return;
            default:
                synchronized (this.f3287A4TApA.f3309BI9f7h) {
                    try {
                        try {
                            switch (message.what) {
                                case 65537:
                                    ADYaiT aDYaiT3 = this.f3287A4TApA;
                                    aDYaiT3.f3317BniPrB = 4;
                                    aDYaiT3.f3295AZOQYO = (Handler) message.obj;
                                    MediaPlayer mediaPlayer3 = aDYaiT3.f3305B4ZgIw;
                                    if (mediaPlayer3 != null) {
                                        mediaPlayer3.setLooping(false);
                                        ADYaiT aDYaiT4 = this.f3287A4TApA;
                                        if (aDYaiT4.f3290A5SV6n) {
                                            aDYaiT4.f3305B4ZgIw.setVolume(0.0f, 0.0f);
                                            this.f3287A4TApA.f3310BIYEnU = 0.0f;
                                        } else {
                                            aDYaiT4.f3305B4ZgIw.setVolume(1.0f, 1.0f);
                                            this.f3287A4TApA.f3310BIYEnU = 1.0f;
                                        }
                                        ADYaiT aDYaiT5 = this.f3287A4TApA;
                                        aDYaiT5.f3291ADYaiT = aDYaiT5.f3290A5SV6n;
                                        if (aDYaiT5.BpkvW3 == 5) {
                                            aDYaiT5.AmA8tU();
                                        }
                                        ADYaiT aDYaiT6 = this.f3287A4TApA;
                                        aDYaiT6.f3307B9tovu[0] = aDYaiT6.f3305B4ZgIw.getVideoWidth();
                                        ADYaiT aDYaiT7 = this.f3287A4TApA;
                                        aDYaiT7.f3307B9tovu[1] = aDYaiT7.f3305B4ZgIw.getVideoHeight();
                                        ADYaiT aDYaiT8 = this.f3287A4TApA;
                                        if (!aDYaiT8.f3299AlLFFp && ADYaiT.ARc23Z(aDYaiT8.f3308BChYOn) && ADYaiT.ARc23Z(this.f3287A4TApA.f3307B9tovu)) {
                                            this.f3287A4TApA.ASJ6gh();
                                            break;
                                        }
                                    }
                                    break;
                                case 65538:
                                    if (this.f3287A4TApA.AaHO0E()) {
                                        ADYaiT aDYaiT9 = this.f3287A4TApA;
                                        if (aDYaiT9.f3317BniPrB == 5 && (a4TApA = aDYaiT9.f3316BmvVmW) != null) {
                                            a4TApA.sendEmptyMessage(0);
                                        }
                                    }
                                    ADYaiT aDYaiT10 = this.f3287A4TApA;
                                    aDYaiT10.f3317BniPrB = 6;
                                    SeekBar seekBar = aDYaiT10.f3306B7CMnp;
                                    if (seekBar != null && (mediaPlayer = aDYaiT10.f3305B4ZgIw) != null) {
                                        seekBar.setProgress(mediaPlayer.getDuration());
                                        break;
                                    }
                                    break;
                                case 65542:
                                    int intValue = ((Integer) message.obj).intValue();
                                    SeekBar seekBar2 = this.f3287A4TApA.f3306B7CMnp;
                                    if (seekBar2 != null) {
                                        seekBar2.setProgress(intValue);
                                        break;
                                    }
                                    break;
                                case 65543:
                                    ADYaiT aDYaiT11 = this.f3287A4TApA;
                                    aDYaiT11.f3317BniPrB = 5;
                                    SeekBar seekBar3 = aDYaiT11.f3306B7CMnp;
                                    if (seekBar3 != null && (mediaPlayer2 = aDYaiT11.f3305B4ZgIw) != null) {
                                        try {
                                            seekBar3.setMax(mediaPlayer2.getDuration());
                                        } catch (Exception unused) {
                                        }
                                    }
                                    this.f3287A4TApA.f3293ASJ6gh.A2egSU();
                                    break;
                                case 65545:
                                    ADYaiT aDYaiT12 = this.f3287A4TApA;
                                    aDYaiT12.f3317BniPrB = 8;
                                    aDYaiT12.AlLFFp();
                                    break;
                            }
                        } catch (Exception unused2) {
                        }
                    } finally {
                    }
                }
                return;
        }
    }
}
