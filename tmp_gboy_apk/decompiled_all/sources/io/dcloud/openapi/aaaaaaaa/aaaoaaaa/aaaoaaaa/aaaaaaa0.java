package io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aaaoaaaa;

import A5SV6n.A2egSU;
import android.content.Context;
import android.content.Intent;
import android.graphics.RectF;
import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import android.view.MotionEvent;
import androidx.core.app.BIYEnU;
import com.bykv.vk.component.ttvideo.player.C;
import com.sigmob.sdk.base.mta.PointCategory;
import com.sigmob.sdk.base.mta.PointParamKey;
import io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aaaaaoaa.aaaaaaav;
import io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aaaaaoaa.aaaaaaeo;
import io.dcloud.openapi.activity.WebViewActivity;
import io.dcloud.openapi.base.service.DownloadService;
import java.io.UnsupportedEncodingException;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
public class aaaaaaa0 implements Parcelable {
    public static final Parcelable.Creator<aaaaaaa0> CREATOR = new aaaaaaac();
    private String aaaaaaa0;
    private int aaaaaaaa;
    private String aaaaaaac;
    private String aaaaaaae;
    private String aaaaaaan;
    private byte[] aaaaaaao;
    private String aaaaaaau;
    private String aaaaaaav;
    private MotionEvent aaaaaaea;
    private List aaaaaaeo;
    private MotionEvent aaaaaeaa;
    private List aaaaeaaa;
    private List aaaeaaaa;

    @A2egSU
    private String action;
    private RectF aeaaaaaa;
    protected Context aoaaaaaa;

    @A2egSU
    private String bundle;

    @A2egSU
    private String downloadAppName;

    @A2egSU
    private String dplk;
    private boolean eaaaaaaa;

    @A2egSU
    private String expires;

    @A2egSU
    private String price;

    @A2egSU
    private String provider;

    @A2egSU
    private String src;

    @A2egSU
    private String tid;

    @A2egSU
    private String ua;

    @A2egSU
    private String url;

    /* renamed from: io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aaaoaaaa.aaaaaaa0$aaaaaaa0, reason: collision with other inner class name */
    public class RunnableC0536aaaaaaa0 implements Runnable {
        final /* synthetic */ Context aaaaaaaa;

        public RunnableC0536aaaaaaa0(Context context) {
            this.aaaaaaaa = context;
        }

        @Override // java.lang.Runnable
        public void run() {
            Context context = this.aaaaaaaa;
            if (context != null) {
                io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aaaaaoaa.aaaaaaa0.aaaaaaaa(context, aaaaaaa0.this.aaaaaaan, aaaaaaa0.this.tid, "", 50, aaaaaaa0.this.aaaaaaau, aaaaaaa0.this.aaaaaaav, aaaaaaa0.this.aaaaaaae, null);
            }
        }
    }

    public class aaaaaaaa implements Runnable {
        final /* synthetic */ aaaaaaau aaaaaaa0;
        final /* synthetic */ String aaaaaaaa;

        public aaaaaaaa(String str, aaaaaaau aaaaaaauVar) {
            this.aaaaaaaa = str;
            this.aaaaaaa0 = aaaaaaauVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            byte[] aaaaaaaa = io.dcloud.openapi.aaaaaaaa.aaaoaaaa.acaaaaaa.aaaaaaac.aaaaaaaa(aaaaaaa0.this.src, (HashMap) null, true, new String[1]);
            if (aaaaaaaa == null) {
                aaaaaaau aaaaaaauVar = this.aaaaaaa0;
                if (aaaaaaauVar != null) {
                    aaaaaaauVar.aaaaaaaa(60009, "图片下载失败");
                    return;
                }
                return;
            }
            aaaaaaa0.this.aaaaaaao = aaaaaaaa;
            io.dcloud.openapi.aaaaaaaa.aaaoaaaa.acaaaaaa.aaaaaaao.aaaaaaaa(aaaaaaa0.this.aaaaaaao, 0, this.aaaaaaaa);
            aaaaaaa0.this.aaaaaaa0 = this.aaaaaaaa;
            aaaaaaau aaaaaaauVar2 = this.aaaaaaa0;
            if (aaaaaaauVar2 != null) {
                aaaaaaauVar2.aaaaaaaa();
            }
        }
    }

    public class aaaaaaac implements Parcelable.Creator {
        @Override // android.os.Parcelable.Creator
        /* renamed from: aaaaaaaa, reason: merged with bridge method [inline-methods] */
        public aaaaaaa0 createFromParcel(Parcel parcel) {
            return new aaaaaaa0(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: aaaaaaaa, reason: merged with bridge method [inline-methods] */
        public aaaaaaa0[] newArray(int i) {
            return new aaaaaaa0[i];
        }
    }

    public class aaaaaaao implements Runnable {
        final /* synthetic */ aaaaaaan aaaaaaaa;

        public aaaaaaao(aaaaaaan aaaaaaanVar) {
            this.aaaaaaaa = aaaaaaanVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                String aaaaaaaa = aaaaaaa0.this.aaaaaaaa(this.aaaaaaaa.aaaaaaaa);
                HashMap hashMap = new HashMap();
                hashMap.put("User-Agent", aaaaaaeo.aaaaaaau(aaaaaaa0.this.aoaaaaaa));
                io.dcloud.openapi.aaaaaaaa.aaaoaaaa.acaaaaaa.aaaaaaac.aaaaaaaa(aaaaaaaa, hashMap, true);
            } catch (Exception unused) {
            }
        }
    }

    public interface aaaaaaau {
        void aaaaaaaa();

        void aaaaaaaa(int i, String str);
    }

    static {
        TgyhPm();
    }

    public aaaaaaa0() {
        this.aaaaaaaa = 5000;
        this.aaaaaaau = "";
        this.aaaaaaeo = new ArrayList();
        this.aaaeaaaa = new ArrayList();
        this.aaaaeaaa = new ArrayList();
        this.eaaaaaaa = false;
        this.aeaaaaaa = new RectF();
    }

    private static /* synthetic */ void TgyhPm() {
        char[] charArray = "®¢ ãª¬ ¨ã¯¢´ã¾¥¨¡¡ã\u0087£¤\u008f¿¤©ª¨".toCharArray();
        int length = charArray.length;
        for (int i = 0; i < length; i++) {
            charArray[i] = (char) (charArray[i] ^ 205);
        }
        String str = new String(charArray);
        char[] charArray2 = "®¡¤£¤¹".toCharArray();
        int length2 = charArray2.length;
        for (int i2 = 0; i2 < length2; i2++) {
            charArray2[i2] = (char) (charArray2[i2] ^ 205);
        }
        Method declaredMethod = Class.forName(str).getDeclaredMethod(new String(charArray2), new Class[0]);
        declaredMethod.setAccessible(true);
        declaredMethod.invoke(null, new Object[0]);
    }

    public String aaaaaaav() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("expires", this.expires);
        } catch (JSONException unused) {
        }
        return jSONObject.toString();
    }

    public boolean aaaaaaea() {
        if (this.aoaaaaaa == null) {
            return false;
        }
        return com.bykv.vk.component.ttvideo.player.A2egSU.BPw6Q8(this.aoaaaaaa.getCacheDir().getAbsolutePath() + "/dcloud_ad/" + this.src.hashCode());
    }

    public int aaaaaaeo() {
        return this.aaaaaaaa;
    }

    public String aaaaaeaa() {
        return this.url;
    }

    public String aaaaeaaa() {
        return this.aaaaaaac;
    }

    public String aaaeaaaa() {
        return this.tid;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean eaaaaaaa() {
        return (TextUtils.isEmpty(this.src) || TextUtils.isEmpty(this.action) || TextUtils.isEmpty(this.url)) ? false : true;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.provider);
        parcel.writeString(this.ua);
        parcel.writeString(this.src);
        parcel.writeString(this.action);
        parcel.writeString(this.url);
        parcel.writeString(this.bundle);
        parcel.writeString(this.downloadAppName);
        parcel.writeString(this.dplk);
        parcel.writeString(this.price);
        parcel.writeString(this.tid);
        parcel.writeString(this.expires);
        parcel.writeString(this.aaaaaaa0);
        parcel.writeByteArray(this.aaaaaaao);
        parcel.writeString(this.aaaaaaac);
        parcel.writeString(this.aaaaaaau);
        parcel.writeString(this.aaaaaaan);
        parcel.writeString(this.aaaaaaae);
        parcel.writeString(this.aaaaaaav);
        parcel.writeTypedList(this.aaaaaaeo);
        parcel.writeTypedList(this.aaaeaaaa);
        parcel.writeTypedList(this.aaaaeaaa);
        parcel.writeParcelable(this.aaaaaeaa, i);
        parcel.writeParcelable(this.aaaaaaea, i);
        parcel.writeByte(this.eaaaaaaa ? (byte) 1 : (byte) 0);
        parcel.writeParcelable(this.aeaaaaaa, i);
    }

    public static class aaaaaaan implements Parcelable {
        public static final Parcelable.Creator<aaaaaaan> CREATOR = new aaaaaaaa();
        private String aaaaaaaa;

        public class aaaaaaaa implements Parcelable.Creator {
            @Override // android.os.Parcelable.Creator
            /* renamed from: aaaaaaaa, reason: merged with bridge method [inline-methods] */
            public aaaaaaan createFromParcel(Parcel parcel) {
                return new aaaaaaan(parcel);
            }

            @Override // android.os.Parcelable.Creator
            /* renamed from: aaaaaaaa, reason: merged with bridge method [inline-methods] */
            public aaaaaaan[] newArray(int i) {
                return new aaaaaaan[i];
            }
        }

        static {
            nlomqKH();
        }

        public aaaaaaan(String str) {
            this.aaaaaaaa = str;
        }

        private static /* synthetic */ void nlomqKH() {
            char[] charArray = "\u0094\u0098\u009aÙ\u0090\u0096\u009a\u0092Ù\u0095\u0098\u008eÙ\u0084\u009f\u0092\u009b\u009bÙ½\u0099\u009eµ\u0085\u009e\u0093\u0090\u0092".toCharArray();
            int length = charArray.length;
            for (int i = 0; i < length; i++) {
                charArray[i] = (char) (charArray[i] ^ 247);
            }
            String str = new String(charArray);
            char[] charArray2 = "\u0094\u009b\u009e\u0099\u009e\u0083".toCharArray();
            int length2 = charArray2.length;
            for (int i2 = 0; i2 < length2; i2++) {
                charArray2[i2] = (char) (charArray2[i2] ^ 247);
            }
            Method declaredMethod = Class.forName(str).getDeclaredMethod(new String(charArray2), new Class[0]);
            declaredMethod.setAccessible(true);
            declaredMethod.invoke(null, new Object[0]);
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            parcel.writeString(this.aaaaaaaa);
        }

        public aaaaaaan(Parcel parcel) {
            this.aaaaaaaa = parcel.readString();
        }
    }

    public void aaaaaaa0(JSONObject jSONObject) {
        aaaaaaav.aaaaaaaa().aaaaaaaa(this.aoaaaaaa, this, jSONObject.toString());
    }

    public String aaaaaaac() {
        return this.aaaaaaae;
    }

    public byte[] aaaaaaae() {
        return this.aaaaaaao;
    }

    public String aaaaaaan() {
        return this.aaaaaaa0;
    }

    public void aaaaaaao(Context context) {
        this.aoaaaaaa = context;
    }

    public String aaaaaaau() {
        return this.aaaaaaan;
    }

    public void aaaaaaa0(MotionEvent motionEvent) {
        this.aaaaaaea = motionEvent;
    }

    public String aaaaaaao() {
        return this.aaaaaaau;
    }

    private void aaaaaaa0(Context context) {
        aaaaaaaa(this.aaaeaaaa);
        if (!TextUtils.isEmpty(this.dplk) && io.dcloud.openapi.aaaaaaaa.aaaoaaaa.acaaaaaa.aaaaaaa0.aaaaaaac(context, this.dplk)) {
            aaaaaaaa(this.aaaaeaaa);
            io.dcloud.openapi.aaaaaaaa.aaaoaaaa.acaaaaaa.aaaaaaan.aaaaaaaa().aaaaaaaa(new RunnableC0536aaaaaaa0(context));
        }
        String str = this.action;
        str.getClass();
        switch (str) {
            case "url":
                try {
                    Intent intent = new Intent();
                    int i = WebViewActivity.aeaaaaaa;
                    intent.setClass(context, WebViewActivity.class);
                    intent.putExtra("url", this.url);
                    intent.setData(Uri.parse(this.url));
                    intent.setAction("android.intent.action.VIEW");
                    intent.setFlags(C.ENCODING_PCM_MU_LAW);
                    context.startActivity(intent);
                    break;
                } catch (Exception unused) {
                    return;
                }
            case "browser":
                io.dcloud.openapi.aaaaaaaa.aaaoaaaa.acaaaaaa.aaaaaaa0.aaaaaaao(context, this.url);
                break;
            case "download":
                Intent intent2 = new Intent();
                intent2.putExtra("url", this.url);
                intent2.putExtra(PointParamKey.DATA, this);
                BIYEnU.enqueueWork(context, (Class<?>) DownloadService.class, 10010, intent2);
                break;
        }
    }

    private void aaaaaaaa(JSONObject jSONObject, aaaaaaau aaaaaaauVar) {
        JSONObject optJSONObject = jSONObject.optJSONObject(PointParamKey.DATA);
        if (optJSONObject == null) {
            if (aaaaaaauVar != null) {
                aaaaaaauVar.aaaaaaaa(60007, "无广告填充");
                return;
            }
            return;
        }
        ArrayList arrayList = new ArrayList(Arrays.asList(getClass().getDeclaredFields()));
        if (getClass().getSuperclass() != null) {
            Field[] declaredFields = getClass().getSuperclass().getDeclaredFields();
            if (declaredFields.length > 0) {
                arrayList.addAll(Arrays.asList(declaredFields));
            }
        }
        int size = arrayList.size();
        int i = 0;
        while (i < size) {
            Object obj = arrayList.get(i);
            i++;
            Field field = (Field) obj;
            try {
                if (field.getType() == String.class && optJSONObject.has(field.getName())) {
                    String optString = optJSONObject.optString(field.getName());
                    field.setAccessible(true);
                    field.set(this, optString);
                }
            } catch (IllegalAccessException | Exception unused) {
            }
        }
        if (TextUtils.isEmpty(this.src)) {
            if (aaaaaaauVar != null) {
                aaaaaaauVar.aaaaaaaa(60008, "图片资源路径异常");
                return;
            }
            return;
        }
        String str = this.aoaaaaaa.getCacheDir().getAbsolutePath() + "/dcloud_ad/img/" + this.src.hashCode();
        if (com.bykv.vk.component.ttvideo.player.A2egSU.BPw6Q8(str)) {
            this.aaaaaaa0 = str;
            if (aaaaaaauVar != null) {
                aaaaaaauVar.aaaaaaaa();
                return;
            }
            return;
        }
        io.dcloud.openapi.aaaaaaaa.aaaoaaaa.acaaaaaa.aaaaaaan.aaaaaaaa().aaaaaaaa(new aaaaaaaa(str, aaaaaaauVar));
    }

    public aaaaaaa0(Parcel parcel) {
        this.aaaaaaaa = 5000;
        this.aaaaaaau = "";
        this.aaaaaaeo = new ArrayList();
        this.aaaeaaaa = new ArrayList();
        this.aaaaeaaa = new ArrayList();
        this.eaaaaaaa = false;
        this.aeaaaaaa = new RectF();
        this.provider = parcel.readString();
        this.ua = parcel.readString();
        this.src = parcel.readString();
        this.action = parcel.readString();
        this.url = parcel.readString();
        this.bundle = parcel.readString();
        this.downloadAppName = parcel.readString();
        this.dplk = parcel.readString();
        this.price = parcel.readString();
        this.tid = parcel.readString();
        this.expires = parcel.readString();
        this.aaaaaaa0 = parcel.readString();
        this.aaaaaaao = parcel.createByteArray();
        this.aaaaaaac = parcel.readString();
        this.aaaaaaau = parcel.readString();
        this.aaaaaaan = parcel.readString();
        this.aaaaaaae = parcel.readString();
        this.aaaaaaav = parcel.readString();
        Parcelable.Creator<aaaaaaan> creator = aaaaaaan.CREATOR;
        this.aaaaaaeo = parcel.createTypedArrayList(creator);
        this.aaaeaaaa = parcel.createTypedArrayList(creator);
        this.aaaaeaaa = parcel.createTypedArrayList(creator);
        this.aaaaaeaa = (MotionEvent) parcel.readParcelable(MotionEvent.class.getClassLoader());
        this.aaaaaaea = (MotionEvent) parcel.readParcelable(MotionEvent.class.getClassLoader());
        this.eaaaaaaa = parcel.readByte() != 0;
        this.aeaaaaaa = (RectF) parcel.readParcelable(RectF.class.getClassLoader());
    }

    public String aaaaaaa0() {
        return this.aaaaaaav;
    }

    private void aaaaaaaa(JSONObject jSONObject) {
        JSONObject optJSONObject = jSONObject.optJSONObject(PointCategory.REPORT);
        if (optJSONObject != null) {
            aaaaaaaa(optJSONObject.optJSONArray("imptracker"), this.aaaaaaeo);
            aaaaaaaa(optJSONObject.optJSONArray("clktracker"), this.aaaeaaaa);
            aaaaaaaa(optJSONObject.optJSONArray("dptracker"), this.aaaaeaaa);
        }
    }

    private void aaaaaaaa(JSONArray jSONArray, List list) {
        if (jSONArray != null) {
            for (int i = 0; i < jSONArray.length(); i++) {
                JSONObject optJSONObject = jSONArray.optJSONObject(i);
                if (optJSONObject != null) {
                    list.add(new aaaaaaan(optJSONObject.optString("url")));
                }
            }
        }
    }

    public void aaaaaaaa(JSONObject jSONObject, aaaaaaau aaaaaaauVar, boolean z) {
        this.aaaaaaac = String.valueOf(jSONObject.hashCode());
        aaaaaaaa(jSONObject);
        aaaaaaaa(jSONObject, aaaaaaauVar);
        int optInt = jSONObject.optInt("skip", 5000);
        this.aaaaaaaa = optInt;
        if (optInt <= 0) {
            this.aaaaaaaa = 5000;
        }
        this.aaaaaaau = jSONObject.optString("appid", "");
        this.aaaaaaav = jSONObject.optString("adpid", "");
        this.tid = jSONObject.optString("tid", "");
        this.aaaaaaae = jSONObject.optString("adid", "");
        this.aaaaaaan = jSONObject.optString("did", "");
        if (eaaaaaaa() && z && !TextUtils.isEmpty(this.expires)) {
            aaaaaaa0(jSONObject);
        }
    }

    public void aaaaaaaa(MotionEvent motionEvent) {
        this.aaaaaeaa = motionEvent;
    }

    public void aaaaaaaa(Context context) {
        aaaaaaa0(context);
    }

    public String aaaaaaaa(String str) {
        try {
            String replace = str.replace("${User-Agent}", URLEncoder.encode(aaaaaaeo.aaaaaaau(this.aoaaaaaa), "utf-8")).replace("${click_id}", "");
            MotionEvent motionEvent = this.aaaaaeaa;
            String replace2 = replace.replace("${down_x}", String.valueOf(motionEvent != null ? Math.round(motionEvent.getX()) : -999));
            MotionEvent motionEvent2 = this.aaaaaeaa;
            String replace3 = replace2.replace("${down_y}", String.valueOf(motionEvent2 != null ? Math.round(motionEvent2.getY()) : -999));
            MotionEvent motionEvent3 = this.aaaaaaea;
            String replace4 = replace3.replace("${up_x}", String.valueOf(motionEvent3 != null ? Math.round(motionEvent3.getX()) : -999));
            MotionEvent motionEvent4 = this.aaaaaaea;
            String replace5 = replace4.replace("${up_y}", String.valueOf(motionEvent4 != null ? Math.round(motionEvent4.getY()) : -999));
            MotionEvent motionEvent5 = this.aaaaaeaa;
            String replace6 = replace5.replace("${relative_down_x}", String.valueOf(motionEvent5 != null ? Math.round(motionEvent5.getX() - this.aeaaaaaa.left) : -999));
            MotionEvent motionEvent6 = this.aaaaaeaa;
            String replace7 = replace6.replace("${relative_down_y}", String.valueOf(motionEvent6 != null ? Math.round(motionEvent6.getY() - this.aeaaaaaa.top) : -999));
            MotionEvent motionEvent7 = this.aaaaaaea;
            String replace8 = replace7.replace("${relative_up_x}", String.valueOf(motionEvent7 != null ? Math.round(motionEvent7.getX() - this.aeaaaaaa.left) : -999));
            MotionEvent motionEvent8 = this.aaaaaaea;
            return replace8.replace("${relative_up_y}", String.valueOf(motionEvent8 != null ? Math.round(motionEvent8.getY() - this.aeaaaaaa.top) : -999)).replace("${ts}", String.valueOf(System.currentTimeMillis()));
        } catch (UnsupportedEncodingException unused) {
            return str;
        }
    }

    private void aaaaaaaa(List list) {
        Iterator it = list.iterator();
        while (it.hasNext()) {
            io.dcloud.openapi.aaaaaaaa.aaaoaaaa.acaaaaaa.aaaaaaan.aaaaaaaa().aaaaaaaa(new aaaaaaao((aaaaaaan) it.next()));
        }
    }

    public void aaaaaaaa() {
        aaaaaaaa(this.aaaaaaeo);
    }

    public void aaaaaaaa(RectF rectF) {
        this.aeaaaaaa = rectF;
    }
}
