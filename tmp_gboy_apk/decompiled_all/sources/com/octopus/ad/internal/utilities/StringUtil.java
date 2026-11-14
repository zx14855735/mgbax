package com.octopus.ad.internal.utilities;

import ADYaiT.CtFAbx;
import android.content.res.Resources;
import android.graphics.Rect;
import android.text.TextUtils;
import android.util.Base64;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.mobads.sdk.api.IAdInterListener;
import com.czhj.sdk.common.Constants;
import com.kwad.components.core.s.t;
import com.octopus.ad.internal.q;
import com.octopus.ad.model.g;
import com.octopus.ad.utils.b.a;
import com.octopus.ad.utils.b.e;
import com.octopus.ad.utils.b.f;
import com.octopus.ad.utils.b.i;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Formatter;
import java.util.Scanner;
import java.util.UUID;
import java.util.zip.GZIPInputStream;
import java.util.zip.GZIPOutputStream;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
public class StringUtil {
    public static boolean appendLocalStr(StringBuilder sb, String str) {
        String b = a.b(e.a(), str);
        if (b == null) {
            return false;
        }
        sb.append(b);
        return true;
    }

    public static boolean appendRes(StringBuilder sb, Resources resources, int i) {
        Scanner useDelimiter = new Scanner(resources.openRawResource(i), "UTF-8").useDelimiter("\\A");
        if (!useDelimiter.hasNext()) {
            useDelimiter.close();
            return false;
        }
        sb.append(useDelimiter.next());
        useDelimiter.close();
        return true;
    }

    private static String byteToHex(byte[] bArr) {
        Formatter formatter = new Formatter();
        for (byte b : bArr) {
            formatter.format("%02x", Byte.valueOf(b));
        }
        String formatter2 = formatter.toString();
        formatter.close();
        return formatter2;
    }

    private static String compressForGzip(String str) {
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        try {
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            GZIPOutputStream gZIPOutputStream = new GZIPOutputStream(byteArrayOutputStream);
            gZIPOutputStream.write(str.getBytes());
            gZIPOutputStream.close();
            byte[] byteArray = byteArrayOutputStream.toByteArray();
            byteArrayOutputStream.flush();
            byteArrayOutputStream.close();
            return Base64.encodeToString(byteArray, 2);
        } catch (Exception e) {
            f.a("OctopusAd", "An Exception Caught", e);
            return "";
        }
    }

    public static String createRequestId() {
        String md5 = md5(UUID.randomUUID().toString());
        f.a("OctopusAd", "createRequestId:" + md5);
        return md5;
    }

    public static String decompressForGzip(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            byte[] decode = Base64.decode(str, 0);
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(decode);
            GZIPInputStream gZIPInputStream = new GZIPInputStream(byteArrayInputStream);
            byte[] bArr = new byte[1024];
            while (true) {
                int read = gZIPInputStream.read(bArr, 0, 1024);
                if (read <= 0) {
                    gZIPInputStream.close();
                    byteArrayInputStream.close();
                    byteArrayOutputStream.close();
                    return byteArrayOutputStream.toString();
                }
                byteArrayOutputStream.write(bArr, 0, read);
            }
        } catch (Exception e) {
            f.a("OctopusAd", "An Exception Caught", e);
            return null;
        }
    }

    private static int indexOfViewInParent(View view, ViewGroup viewGroup) {
        int i = 0;
        while (i < viewGroup.getChildCount() && viewGroup.getChildAt(i) != view) {
            i++;
        }
        return i;
    }

    public static boolean isEmpty(String str) {
        return str == null || str.length() == 0;
    }

    private static boolean isViewCovered(View view) {
        if (view != null && view.getParent() != null) {
            try {
                Rect rect = new Rect();
                boolean globalVisibleRect = view.getGlobalVisibleRect(rect);
                boolean z = rect.bottom - rect.top >= view.getMeasuredHeight();
                boolean z2 = rect.right - rect.left >= view.getMeasuredWidth();
                if (!globalVisibleRect || !z || !z2) {
                    return true;
                }
                View view2 = view;
                while (view2.getParent() instanceof ViewGroup) {
                    ViewGroup viewGroup = (ViewGroup) view2.getParent();
                    if (viewGroup.getVisibility() != 0) {
                        return true;
                    }
                    for (int indexOfViewInParent = indexOfViewInParent(view2, viewGroup) + 1; indexOfViewInParent < viewGroup.getChildCount(); indexOfViewInParent++) {
                        Rect rect2 = new Rect();
                        view.getGlobalVisibleRect(rect2);
                        View childAt = viewGroup.getChildAt(indexOfViewInParent);
                        Rect rect3 = new Rect();
                        childAt.getGlobalVisibleRect(rect3);
                        if (Rect.intersects(rect2, rect3)) {
                            return true;
                        }
                    }
                    view2 = viewGroup;
                }
                return false;
            } catch (Exception e) {
                f.a("OctopusAd", "An Exception Caught", e);
            }
        }
        return false;
    }

    public static boolean isVisible(View view) {
        if (view != null && view.getVisibility() == 0 && view.getParent() != null) {
            try {
                Rect rect = new Rect();
                if (!view.getGlobalVisibleRect(rect)) {
                    return false;
                }
                int height = rect.height() * rect.width();
                int height2 = view.getHeight() * view.getWidth();
                return height2 > 0 && height * 100 >= height2 * 50;
            } catch (Exception e) {
                f.a("OctopusAd", "An Exception Caught", e);
            }
        }
        return false;
    }

    public static String md5(String str) {
        try {
            byte[] digest = MessageDigest.getInstance("MD5").digest(str.getBytes("UTF-8"));
            StringBuilder sb = new StringBuilder(digest.length * 2);
            for (byte b : digest) {
                int i = b & 255;
                if (i < 16) {
                    sb.append(Constants.FAIL);
                }
                sb.append(Integer.toHexString(i));
            }
            return sb.toString();
        } catch (UnsupportedEncodingException e) {
            throw new RuntimeException("UnsupportedEncodingException", e);
        } catch (NoSuchAlgorithmException e2) {
            throw new RuntimeException("NoSuchAlgorithmException", e2);
        }
    }

    public static String replaceClick(View view, String str) {
        if (!TextUtils.isEmpty(str) && view != null) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("viewSecond", String.valueOf(0));
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put(t.TAG, String.valueOf(view.getTop()));
                jSONObject2.put("l", String.valueOf(view.getLeft()));
                jSONObject2.put(IAdInterListener.AdReqParam.WIDTH, String.valueOf(view.getWidth()));
                jSONObject2.put("h", String.valueOf(view.getHeight()));
                jSONObject2.put(com.kuaishou.weapon.p0.t.f, String.valueOf(view.getAlpha()));
                jSONObject2.put(com.kuaishou.weapon.p0.t.c, String.valueOf(isVisible(view)));
                jSONObject2.put("s", String.valueOf(isViewCovered(view)));
                jSONObject.put("pos", jSONObject2);
                JSONObject jSONObject3 = new JSONObject();
                jSONObject3.put(IAdInterListener.AdReqParam.WIDTH, i.i(view.getContext()));
                jSONObject3.put("h", i.j(view.getContext()));
                jSONObject3.put("o", i.k(view.getContext()));
                jSONObject.put("screen", jSONObject3);
                jSONObject.put("spaces", new JSONArray());
                f.a("OctopusAd", "webView:" + jSONObject.toString());
                return str.replace(".UTC_TS.", String.valueOf(System.currentTimeMillis())).replace("__VT__", compressForGzip(jSONObject.toString()).replace("+", "-").replace("/", "_").replace("=", "."));
            } catch (JSONException e) {
                f.a("OctopusAd", "An Exception Caught", e);
            }
        }
        return str;
    }

    public static String replaceM(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, String str10) {
        int indexOf = str.indexOf("?") + 1;
        String substring = str.substring(0, indexOf);
        String substring2 = str.substring(indexOf);
        try {
            DeviceInfo deviceInfo = DeviceInfo.getInstance();
            UserEnvInfo userEnvInfo = UserEnvInfo.getInstance();
            if (!TextUtils.isEmpty(str2)) {
                substring2 = substring2.replace("__REQUESTUUID__", str2);
            }
            if (!TextUtils.isEmpty(str3)) {
                substring2 = substring2.replace("__EVENTTYPE__", str3);
            }
            if (!TextUtils.isEmpty(str4)) {
                substring2 = substring2.replace("__APPID__", str4);
            }
            if (!TextUtils.isEmpty(str5)) {
                substring2 = substring2.replace("__SPACEID__", str5);
            }
            if (!TextUtils.isEmpty(str6)) {
                substring2 = substring2.replace("__CHANNELID__", str6);
            }
            if (!TextUtils.isEmpty(str7)) {
                substring2 = substring2.replace("__CHANNELAPPID__", str7);
            }
            if (!TextUtils.isEmpty(str8)) {
                substring2 = substring2.replace("__CHANNELSPACEID__", str8);
            }
            if (!TextUtils.isEmpty(str9)) {
                substring2 = substring2.replace("__ERRINFO__", str9);
            }
            if (!TextUtils.isEmpty("2.5.10.5")) {
                substring2 = substring2.replace("__SDKVERSION__", "2.5.10.5");
            }
            if (!TextUtils.isEmpty(str10)) {
                substring2 = substring2.replace("__APPVERSION__", str10);
            }
            if (!TextUtils.isEmpty(String.valueOf(System.currentTimeMillis()))) {
                substring2 = substring2.replace("__TS__", String.valueOf(System.currentTimeMillis()));
            }
            if (!TextUtils.isEmpty(userEnvInfo.ip)) {
                substring2 = substring2.replace("__IP__", userEnvInfo.ip);
            }
            g.c cVar = userEnvInfo.isp;
            if (cVar != null && !TextUtils.isEmpty(String.valueOf(cVar.a()))) {
                substring2 = substring2.replace("__CARRIER__", String.valueOf(userEnvInfo.isp.a()));
            }
            g.d dVar = userEnvInfo.net;
            if (dVar != null && !TextUtils.isEmpty(String.valueOf(dVar.a()))) {
                substring2 = substring2.replace("__NETTYPE__", String.valueOf(userEnvInfo.net.a()));
            }
            if (!TextUtils.isEmpty(deviceInfo.sdkUID)) {
                substring2 = substring2.replace("__UID__", deviceInfo.sdkUID);
            }
            if (!TextUtils.isEmpty(q.a().k())) {
                substring2 = substring2.replace("__UA__", q.a().k());
            }
        } catch (Exception e) {
            f.a("OctopusAd", "An Exception Caught", e);
        } catch (Throwable th) {
            f.a("OctopusAd", "A Throwable Caught", th);
        }
        String encodeToString = Base64.encodeToString(substring2.getBytes(), 2);
        String md5 = md5(encodeToString);
        StringBuilder sb = new StringBuilder(encodeToString);
        sb.insert(13, md5.substring(0, 5));
        return CtFAbx.AlLFFp(substring, "info=", sb.toString());
    }

    public static String replaceR(String str) {
        try {
            return str.replace("__UID__", DeviceInfo.getInstance().sdkUID).replace("__TS__", String.valueOf(System.currentTimeMillis() / 1000)).replace("__PLATFORM__", "android").replace("__DEVICE__", "phone").replace("__IP__", UserEnvInfo.getInstance().ip).replace("__UA__", q.a().k());
        } catch (Exception e) {
            f.a("OctopusAd", "An Exception Caught", e);
            return str;
        }
    }

    public static String replaceView(int i, View view, String str) {
        if (!TextUtils.isEmpty(str)) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("viewSecond", String.valueOf(i));
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put(t.TAG, String.valueOf(view.getTop()));
                jSONObject2.put("l", String.valueOf(view.getLeft()));
                jSONObject2.put(IAdInterListener.AdReqParam.WIDTH, String.valueOf(view.getWidth()));
                jSONObject2.put("h", String.valueOf(view.getHeight()));
                jSONObject2.put(com.kuaishou.weapon.p0.t.f, String.valueOf(view.getAlpha()));
                jSONObject2.put(com.kuaishou.weapon.p0.t.c, String.valueOf(isVisible(view)));
                jSONObject2.put("s", String.valueOf(isViewCovered(view)));
                jSONObject.put("pos", jSONObject2);
                JSONObject jSONObject3 = new JSONObject();
                jSONObject3.put(IAdInterListener.AdReqParam.WIDTH, i.i(view.getContext()));
                jSONObject3.put("h", i.j(view.getContext()));
                jSONObject3.put("o", i.k(view.getContext()));
                jSONObject.put("screen", jSONObject3);
                jSONObject.put("spaces", new JSONArray());
                f.a("OctopusAd", "webView:" + jSONObject.toString());
                return str.replace(".UTC_TS.", String.valueOf(System.currentTimeMillis())).replace("__VT__", compressForGzip(jSONObject.toString()).replace("+", "-").replace("/", "_").replace("=", "."));
            } catch (JSONException e) {
                f.a("OctopusAd", "An Exception Caught", e);
            }
        }
        return str;
    }

    public static String toMD5(String str) {
        try {
            MessageDigest messageDigest = MessageDigest.getInstance("MD5");
            messageDigest.reset();
            messageDigest.update(str.getBytes("UTF-8"));
            return byteToHex(messageDigest.digest());
        } catch (Exception unused) {
            return null;
        }
    }
}
