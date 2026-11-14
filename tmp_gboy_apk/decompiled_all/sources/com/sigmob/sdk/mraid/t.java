package com.sigmob.sdk.mraid;

import android.content.Context;
import android.net.Uri;
import android.text.TextUtils;
import android.view.View;
import android.widget.FrameLayout;
import com.baidu.mobads.sdk.api.IAdInterListener;
import com.czhj.sdk.common.Constants;
import com.czhj.sdk.common.utils.Dips;
import com.czhj.sdk.logger.SigmobLog;
import com.sigmob.sdk.mraid.n;
import java.io.File;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.json.JSONObject;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
public class t extends n implements n.a, com.sigmob.sdk.videocache.d {
    public static final int c = 0;
    public static final int d = 1;
    public static final int e = 2;
    public static final int f = 3;
    public static final int g = 4;
    public static final int h = 0;
    public static final int i = 1;
    public static final int j = 2;
    public static final int k = 4;
    public static final int l = 8;
    private r m;
    private String n;
    private u o;

    /* renamed from: com.sigmob.sdk.mraid.t$2, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass2 {

        /* renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f13499a;

        static {
            int[] iArr = new int[com.sigmob.sdk.videoplayer.d.values().length];
            f13499a = iArr;
            try {
                iArr[com.sigmob.sdk.videoplayer.d.STATE_PREPARED.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f13499a[com.sigmob.sdk.videoplayer.d.STATE_ERROR.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f13499a[com.sigmob.sdk.videoplayer.d.STATE_PAUSE.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f13499a[com.sigmob.sdk.videoplayer.d.STATE_PLAYING.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f13499a[com.sigmob.sdk.videoplayer.d.STATE_AUTO_COMPLETE.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f13499a[com.sigmob.sdk.videoplayer.d.STATE_PREPARING.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f13499a[com.sigmob.sdk.videoplayer.d.STATE_BUFFERING_START.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                f13499a[com.sigmob.sdk.videoplayer.d.STATE_BUFFERING_END.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                f13499a[com.sigmob.sdk.videoplayer.d.STATE_STOP.ordinal()] = 9;
            } catch (NoSuchFieldError unused9) {
            }
        }
    }

    public t(String str) {
        super(str);
    }

    @Override // com.sigmob.sdk.mraid.n
    public View a() {
        return this.m;
    }

    @Override // com.sigmob.sdk.mraid.n.a
    public void c(JSONObject jSONObject) {
        r rVar = this.m;
        if (rVar == null) {
            return;
        }
        rVar.a(0);
        this.m.d();
    }

    @Override // com.sigmob.sdk.mraid.n.a
    public void d(JSONObject jSONObject) {
        r rVar = this.m;
        if (rVar == null) {
            return;
        }
        rVar.j();
    }

    @Override // com.sigmob.sdk.mraid.n.a
    public void e(JSONObject jSONObject) {
        r rVar = this.m;
        if (rVar == null) {
            return;
        }
        rVar.i();
    }

    @Override // com.sigmob.sdk.mraid.n.a
    public void f(JSONObject jSONObject) {
        if (this.m == null) {
            return;
        }
        this.m.setMute(jSONObject.optBoolean("muted", false));
    }

    @Override // com.sigmob.sdk.mraid.n.a
    public void g(JSONObject jSONObject) {
        if (this.m == null) {
            return;
        }
        this.m.a(((int) jSONObject.optDouble("seekTime", 0.0d)) * 1000);
    }

    @Override // com.sigmob.sdk.mraid.n.a
    public void h(JSONObject jSONObject) {
        JSONObject optJSONObject;
        if (this.m == null || jSONObject == null || (optJSONObject = jSONObject.optJSONObject("frame")) == null) {
            return;
        }
        Context e2 = com.sigmob.sdk.b.e();
        int optDouble = (int) optJSONObject.optDouble("x", 0.0d);
        int optDouble2 = (int) optJSONObject.optDouble("y", 0.0d);
        int optDouble3 = (int) optJSONObject.optDouble(IAdInterListener.AdReqParam.WIDTH, -1.0d);
        int optDouble4 = (int) optJSONObject.optDouble("h", -1.0d);
        if (optDouble3 > 0) {
            optDouble3 = Dips.dipsToIntPixels(optDouble3, e2);
        }
        if (optDouble4 > 0) {
            optDouble4 = Dips.dipsToIntPixels(optDouble4, e2);
        }
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(optDouble3, optDouble4);
        this.m.setX(Dips.dipsToIntPixels(optDouble, e2));
        this.m.setY(Dips.dipsToIntPixels(optDouble2, e2));
        this.m.setLayoutParams(layoutParams);
        this.m.requestLayout();
    }

    @Override // com.sigmob.sdk.mraid.n
    public void b() {
        r rVar = this.m;
        if (rVar != null) {
            com.sigmob.sdk.base.utils.r.a(rVar);
            this.m.removeAllViews();
            this.m.r();
            this.m = null;
        }
        if (this.n != null) {
            com.sigmob.sdk.base.common.h.d().b(this, this.n);
        }
    }

    @Override // com.sigmob.sdk.mraid.n.a
    public void a(Context context, JSONObject jSONObject) {
        r rVar = new r(context);
        this.m = rVar;
        rVar.setVideoPlayerStatusListener(new com.sigmob.sdk.videoplayer.k() { // from class: com.sigmob.sdk.mraid.t.1
            @Override // com.sigmob.sdk.videoplayer.k
            public void a(long j2, long j3) {
                if (t.this.o == null) {
                    return;
                }
                t.this.o.a(t.this.f13481a, j2, j3);
            }

            @Override // com.sigmob.sdk.videoplayer.k
            public void a(com.sigmob.sdk.videoplayer.d dVar) {
                SigmobLog.d("VIDEO_PLAYER_STATE change: " + dVar);
                switch (AnonymousClass2.f13499a[dVar.ordinal()]) {
                    case 1:
                        if (t.this.o != null) {
                            t.this.o.a(t.this.f13481a, t.this.m.getDuration(), t.this.m.getVideoWidth(), t.this.m.getVideoHeight());
                        }
                        if (t.this.o != null) {
                            t.this.o.b(t.this.f13481a, 2);
                        }
                        if (t.this.o != null) {
                            t.this.o.b(t.this.f13481a, 4);
                            break;
                        }
                        break;
                    case 2:
                        if (t.this.o != null) {
                            t.this.o.a(t.this.f13481a, t.this.m.getErrorCode(), t.this.m.getErrorMessage());
                            break;
                        }
                        break;
                    case 3:
                        if (t.this.o != null) {
                            t.this.o.a(t.this.f13481a, 2);
                            break;
                        }
                        break;
                    case 4:
                        if (t.this.o != null) {
                            t.this.o.a(t.this.f13481a, 1);
                            break;
                        }
                        break;
                    case 5:
                        if (t.this.o != null) {
                            u uVar = t.this.o;
                            t tVar = t.this;
                            uVar.a(tVar.f13481a, tVar.m.getDuration(), t.this.m.getDuration());
                            u uVar2 = t.this.o;
                            t tVar2 = t.this;
                            uVar2.a(tVar2.f13481a, tVar2.m.getDuration());
                            break;
                        }
                        break;
                    case 6:
                        if (t.this.o != null) {
                            t.this.o.b(t.this.f13481a, 1);
                            break;
                        }
                        break;
                    case 7:
                        if (t.this.o != null) {
                            t.this.m.j();
                            t.this.o.b(t.this.f13481a, 8);
                            break;
                        }
                        break;
                    case 8:
                        if (t.this.o != null) {
                            t.this.m.d();
                            t.this.o.b(t.this.f13481a, 2);
                            break;
                        }
                        break;
                    case 9:
                        if (t.this.o != null) {
                            t.this.o.a(t.this.f13481a, 4);
                            break;
                        }
                        break;
                }
            }
        });
    }

    @Override // com.sigmob.sdk.mraid.n.a
    public void b(JSONObject jSONObject) {
        r rVar = this.m;
        if (rVar == null) {
            return;
        }
        rVar.d();
    }

    public void a(u uVar) {
        this.o = uVar;
    }

    @Override // com.sigmob.sdk.videocache.d
    public void a(File file, String str, int i2) {
    }

    private void a(String str, String str2) {
        Uri parse = Uri.parse(str2);
        if (parse != null && "127.0.0.1".equalsIgnoreCase(parse.getHost())) {
            Pattern compile = Pattern.compile("/(.*)");
            String path = parse.getPath();
            if (TextUtils.isEmpty(path)) {
                return;
            }
            Matcher matcher = compile.matcher(path);
            if (matcher.find()) {
                this.n = matcher.group(1);
                com.sigmob.sdk.base.common.h.d().a(this, this.n);
            }
        }
    }

    @Override // com.sigmob.sdk.videocache.d
    public void a(String str, Throwable th) {
        SigmobLog.e("url", th);
        u uVar = this.o;
        if (uVar == null) {
            return;
        }
        uVar.a(this.f13481a, 0, th.getMessage());
    }

    @Override // com.sigmob.sdk.mraid.n.a
    public void a(JSONObject jSONObject) {
        if (this.m == null) {
            return;
        }
        String optString = jSONObject.optString("URL");
        if (jSONObject.optBoolean("proxy", false) && !TextUtils.isEmpty(optString) && optString.startsWith(Constants.HTTP)) {
            Uri parse = Uri.parse(optString);
            if (parse != null && !"127.0.0.1".equalsIgnoreCase(parse.getHost())) {
                optString = com.sigmob.sdk.base.common.h.d().a(optString);
            }
            a(this.f13481a, optString);
        }
        this.m.setUp(optString);
        this.m.n();
    }
}
