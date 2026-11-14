package Hdahpu;

import COJEAR.BNL6CD;
import COJEAR.F32kj0;
import COJEAR.FG7pZc;
import DRlcZ9.AmA8tU;
import I3HV03.B3GDIM;
import IQ76hF.AcNBzu;
import Oay4Bh.COJEAR;
import Oay4Bh.CQhlFr;
import android.graphics.Bitmap;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.TransitionDrawable;
import android.opengl.GLES10;
import android.opengl.GLES11;
import android.os.Build;
import android.os.ParcelFileDescriptor;
import android.util.Base64;
import android.view.View;
import android.widget.ImageView;
import androidx.preference.Preference;
import com.game.boy.MyApp;
import com.sigmob.sdk.archives.tar.d;
import io.dcloud.ads.core.v2.reward.DCRewardAdListener;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import org.apache.commons.codec.digest.MessageDigestAlgorithms;
import org.json.JSONObject;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public final class AZOQYO implements Ixu71n.A2egSU, B3GDIM, IQ76hF.ASJ6gh, IQ76hF.ARc23Z, AcNBzu, IsbtnO.A4TApA, BNL6CD, LqstKO.ADYaiT, DCRewardAdListener, AmA8tU, COJEAR {

    /* renamed from: AcNBzu, reason: collision with root package name */
    public final /* synthetic */ int f3699AcNBzu;

    public /* synthetic */ AZOQYO(int i) {
        this.f3699AcNBzu = i;
    }

    public static ByteArrayInputStream AZkASS(String str) {
        if (!str.startsWith("data:image")) {
            throw new IllegalArgumentException("Not a valid image data URL.");
        }
        int indexOf = str.indexOf(44);
        if (indexOf == -1) {
            throw new IllegalArgumentException("Missing comma in data URL.");
        }
        if (str.substring(0, indexOf).endsWith(";base64")) {
            return new ByteArrayInputStream(Base64.decode(str.substring(indexOf + 1), 0));
        }
        throw new IllegalArgumentException("Not a base64 image data URL.");
    }

    private final void AlLFFp(Object obj) {
    }

    @Override // LqstKO.ADYaiT
    public void A2egSU(LqstKO.ARc23Z aRc23Z) {
        GLES11.glVertexPointer(2, 5126, 16, 0);
        GLES11.glTexCoordPointer(2, 5126, 16, 8);
    }

    @Override // IQ76hF.ASJ6gh
    public void A4TApA(IQ76hF.AYUAbz aYUAbz) {
    }

    @Override // I3HV03.B3GDIM
    public void A5SV6n(HZUvgL.ADYaiT aDYaiT, Bitmap bitmap) {
    }

    @Override // I3HV03.B3GDIM
    public void ADYaiT() {
    }

    @Override // IsbtnO.A4TApA
    public boolean AMqCpz(Object obj, IlwJBd.A4TApA a4TApA) {
        Drawable drawable = (Drawable) obj;
        ImageView imageView = a4TApA.f4046AlLFFp;
        Drawable drawable2 = imageView.getDrawable();
        if (drawable2 == null) {
            drawable2 = new ColorDrawable(0);
        }
        TransitionDrawable transitionDrawable = new TransitionDrawable(new Drawable[]{drawable2, drawable});
        transitionDrawable.setCrossFadeEnabled(false);
        transitionDrawable.startTransition(300);
        imageView.setImageDrawable(transitionDrawable);
        return true;
    }

    @Override // Ixu71n.A2egSU
    public Object ARc23Z() {
        switch (this.f3699AcNBzu) {
            case 0:
                try {
                    return new AZkASS(MessageDigest.getInstance(MessageDigestAlgorithms.SHA_256));
                } catch (NoSuchAlgorithmException e) {
                    throw new RuntimeException(e);
                }
            default:
                return new ArrayList();
        }
    }

    @Override // IQ76hF.ASJ6gh
    public void ASJ6gh(IQ76hF.AYUAbz aYUAbz) {
        aYUAbz.onStart();
    }

    @Override // LqstKO.ADYaiT
    public void AYUAbz(LqstKO.AMqCpz aMqCpz) {
        GLES10.glBindTexture(3553, aMqCpz.f4933AcNBzu);
        GLES11.glTexParameteri(3553, 10241, aMqCpz.f4934AlLFFp);
        GLES11.glTexParameteri(3553, d.b, aMqCpz.f4934AlLFFp);
        GLES11.glTexParameteri(3553, 10242, 33071);
        GLES11.glTexParameteri(3553, 10243, 33071);
    }

    @Override // Oay4Bh.COJEAR
    public FG7pZc AZOQYO(View view, FG7pZc fG7pZc, CQhlFr cQhlFr) {
        cQhlFr.f6615ADYaiT = fG7pZc.A2egSU() + cQhlFr.f6615ADYaiT;
        boolean z = view.getLayoutDirection() == 1;
        int A4TApA2 = fG7pZc.A4TApA();
        int A5SV6n2 = fG7pZc.A5SV6n();
        int i = cQhlFr.f6612A2egSU + (z ? A5SV6n2 : A4TApA2);
        cQhlFr.f6612A2egSU = i;
        int i2 = cQhlFr.f6614A5SV6n;
        if (!z) {
            A4TApA2 = A5SV6n2;
        }
        int i3 = i2 + A4TApA2;
        cQhlFr.f6614A5SV6n = i3;
        view.setPaddingRelative(i, cQhlFr.f6613A4TApA, i3, cQhlFr.f6615ADYaiT);
        return fG7pZc;
    }

    @Override // DRlcZ9.AmA8tU
    public boolean AaHO0E(Preference preference) {
        MyApp.A2egSU("正在尝试拉取中...");
        MIEDxH.A2egSU.A5SV6n().AMqCpz(true, new AZOQYO(26));
        return true;
    }

    public Class AcNBzu() {
        switch (this.f3699AcNBzu) {
            case 1:
                return ByteBuffer.class;
            case 2:
                return InputStream.class;
            case 3:
            default:
                return InputStream.class;
            case 4:
                return ParcelFileDescriptor.class;
        }
    }

    @Override // COJEAR.BNL6CD
    public FG7pZc B3GDIM(View view, FG7pZc fG7pZc) {
        int i;
        int i2;
        int i3 = Build.VERSION.SDK_INT;
        F32kj0 f32kj0 = fG7pZc.f1747A2egSU;
        if (i3 >= 30) {
            i = f32kj0.ARc23Z(7).f1482A2egSU;
            i2 = f32kj0.ARc23Z(7).f1484A5SV6n;
        } else {
            i = f32kj0.AYUAbz().f1482A2egSU;
            i2 = f32kj0.AYUAbz().f1484A5SV6n;
        }
        view.setPadding(i, 0, i2, 0);
        return fG7pZc;
    }

    @Override // LqstKO.ADYaiT
    public void a() {
        GLES10.glEnableClientState(32884);
        GLES10.glEnableClientState(32888);
        GLES10.glEnable(3553);
    }

    @Override // io.dcloud.ads.core.v2.reward.DCRewardAdListener, io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aaa0aaaa.aaaaaaa0
    public void onClick() {
    }

    @Override // io.dcloud.ads.core.v2.reward.DCRewardAdListener, io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aaa0aaaa.aaaaaaa0
    public void onClose() {
    }

    @Override // io.dcloud.ads.core.v2.reward.DCRewardAdListener, io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aaa0aaaa.aaaaaaa0
    public void onReward(JSONObject jSONObject) {
        MyApp.A2egSU("奖励已发放");
    }

    @Override // io.dcloud.ads.core.v2.reward.DCRewardAdListener, io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aaa0aaaa.aaaaaaa0
    public void onShow() {
    }

    @Override // io.dcloud.ads.core.v2.reward.DCRewardAdListener, io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aaa0aaaa.aaaaaaa0
    public void onShowError(int i, String str) {
        MyApp.A2egSU("错误: " + str);
    }

    @Override // io.dcloud.ads.core.v2.reward.DCRewardAdListener, io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aaa0aaaa.aaaaaaa0
    public void onSkip() {
    }

    @Override // io.dcloud.ads.core.v2.reward.DCRewardAdListener, io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aaa0aaaa.aaaaaaa0
    public void onVideoPlayEnd() {
    }
}
