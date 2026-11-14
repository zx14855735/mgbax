package BTvldC;

import ADYaiT.CtFAbx;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Bitmap;
import android.graphics.Shader;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;
import java.net.SocketTimeoutException;
import java.nio.ByteBuffer;
import java.util.ArrayList;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public final class ADYaiT implements GnQT2j.AaHO0E {

    /* renamed from: AcNBzu, reason: collision with root package name */
    public int f1447AcNBzu;

    /* renamed from: AlLFFp, reason: collision with root package name */
    public final Object f1448AlLFFp;

    /* renamed from: AmA8tU, reason: collision with root package name */
    public final Object f1449AmA8tU;

    public ADYaiT(String... strArr) {
        String sb;
        if (strArr.length == 0) {
            sb = "";
        } else {
            StringBuilder sb2 = new StringBuilder();
            sb2.append('[');
            for (String str : strArr) {
                if (sb2.length() > 1) {
                    sb2.append(",");
                }
                sb2.append(str);
            }
            sb2.append(']');
            sb2.append(' ');
            sb = sb2.toString();
        }
        this.f1449AmA8tU = sb;
        this.f1448AlLFFp = "GoogleSignInCommon";
        int i = 2;
        while (7 >= i && !Log.isLoggable((String) this.f1448AlLFFp, i)) {
            i++;
        }
        this.f1447AcNBzu = i;
    }

    /* JADX WARN: Code restructure failed: missing block: B:122:0x01df, code lost:
    
        throw new org.xmlpull.v1.XmlPullParserException(r3.getPositionDescription() + ": <item> tag requires a 'color' attribute and a 'offset' attribute!");
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static BTvldC.ADYaiT A2egSU(android.content.res.Resources r29, int r30, android.content.res.Resources.Theme r31) {
        /*
            Method dump skipped, instructions count: 675
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: BTvldC.ADYaiT.A2egSU(android.content.res.Resources, int, android.content.res.Resources$Theme):BTvldC.ADYaiT");
    }

    public boolean A4TApA() {
        ColorStateList colorStateList;
        return ((Shader) this.f1448AlLFFp) == null && (colorStateList = (ColorStateList) this.f1449AmA8tU) != null && colorStateList.isStateful();
    }

    public void A5SV6n(byte[] bArr) {
        int read;
        int i = 0;
        while (i < bArr.length) {
            try {
                read = ((InputStream) this.f1448AlLFFp).read(bArr, i, bArr.length - i);
            } catch (SocketTimeoutException unused) {
                int i2 = this.f1447AcNBzu + 1;
                this.f1447AcNBzu = i2;
                if (i2 >= 8) {
                    this.f1447AcNBzu = 0;
                    throw new SocketTimeoutException("连续 8 次静默超时，判定对端不可达");
                }
            }
            if (read < 0) {
                throw new EOFException("对端已关闭连接 (EOF)");
            }
            if (read != 0) {
                i += read;
                this.f1447AcNBzu = 0;
            }
        }
    }

    public ByteBuffer ADYaiT() {
        byte[] bArr = (byte[]) this.f1449AmA8tU;
        A5SV6n(bArr);
        int i = (bArr[3] & 255) | ((bArr[0] & 255) << 24) | ((bArr[1] & 255) << 16) | ((bArr[2] & 255) << 8);
        if (i < 0 || i > 8388608) {
            throw new IOException(CtFAbx.ASJ6gh(i, "非法消息长度: ", "（流已错位或对端异常）"));
        }
        byte[] bArr2 = new byte[i];
        A5SV6n(bArr2);
        return ByteBuffer.wrap(bArr2);
    }

    @Override // GnQT2j.AaHO0E
    public void a(Bitmap bitmap) {
        int i = GJee0v.AZOQYO.f3039AcNBzu;
        FOAO9d.AcNBzu acNBzu = (FOAO9d.AcNBzu) this.f1449AmA8tU;
        ArrayList arrayList = acNBzu.f2631GhvxjZ;
        int i2 = this.f1447AcNBzu;
        if (arrayList.get(i2) != null) {
            if (acNBzu.GZqyMh != null) {
                acNBzu.GZqyMh.ADYaiT((View) acNBzu.f2631GhvxjZ.get(i2), bitmap.copy(bitmap.getConfig(), true));
            }
            ImageView imageView = new ImageView((Context) this.f1448AlLFFp);
            imageView.setImageBitmap(bitmap);
            ((ViewGroup) acNBzu.f2631GhvxjZ.get(i2)).addView(imageView);
        }
    }

    public ADYaiT(int i, FOAO9d.AcNBzu acNBzu, Context context) {
        this.f1449AmA8tU = acNBzu;
        this.f1447AcNBzu = i;
        this.f1448AlLFFp = context;
    }

    /* JADX WARN: Removed duplicated region for block: B:36:0x00ce  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x00e7  */
    /* JADX WARN: Removed duplicated region for block: B:43:0x00ec  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public ADYaiT(java.lang.String r9, int r10, java.util.HashMap r11, boolean r12) {
        /*
            Method dump skipped, instructions count: 355
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: BTvldC.ADYaiT.<init>(java.lang.String, int, java.util.HashMap, boolean):void");
    }

    @Override // GnQT2j.AaHO0E
    public void a(Exception exc) {
        int i = GJee0v.AZOQYO.f3039AcNBzu;
    }

    public ADYaiT(InputStream inputStream) {
        this.f1449AmA8tU = new byte[4];
        this.f1447AcNBzu = 0;
        this.f1448AlLFFp = inputStream;
    }

    public ADYaiT(Shader shader, ColorStateList colorStateList, int i) {
        this.f1448AlLFFp = shader;
        this.f1449AmA8tU = colorStateList;
        this.f1447AcNBzu = i;
    }

    public ADYaiT(HXc4pW.AmA8tU amA8tU) {
        this.f1449AmA8tU = Ixu71n.A5SV6n.A2egSU(MediaPlayer.MEDIA_PLAYER_OPTION_GET_VIDEO_OUTPUT_FPS, new AZkASS.ARc23Z(15, this));
        this.f1448AlLFFp = amA8tU;
    }
}
