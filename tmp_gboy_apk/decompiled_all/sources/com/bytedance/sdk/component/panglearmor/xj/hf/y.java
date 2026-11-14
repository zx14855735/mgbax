package com.bytedance.sdk.component.panglearmor.xj.hf;

import com.fl.saas.common.util.FileTypeUtils;
import com.fl.saas.videocache.ProxyCacheUtils;
import com.kuaishou.weapon.p0.t;
import com.kwad.sdk.api.model.AdnName;
import java.io.File;
import java.io.InputStream;
import java.io.RandomAccessFile;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public class y {
    private static JSONObject hf(List<xj> list) {
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        JSONObject jSONObject = new JSONObject();
        for (xj xjVar : list) {
            if (xjVar != null) {
                arrayList.add(xj(xjVar.hf()));
                arrayList2.add(String.valueOf(xjVar.xj()));
            }
        }
        xj(jSONObject, "sign", arrayList, false);
        xj(jSONObject, "subject", arrayList2, false);
        return jSONObject;
    }

    private static String xj(byte[] bArr) {
        if (bArr == null) {
            return null;
        }
        try {
            byte[] digest = MessageDigest.getInstance("SHA1").digest(bArr);
            StringBuilder sb = new StringBuilder();
            for (byte b : digest) {
                sb.append(Integer.toHexString((b & 255) | 256).substring(1, 3).toUpperCase());
                sb.append(":");
            }
            return sb.substring(0, sb.length() - 1);
        } catch (NoSuchAlgorithmException unused) {
            return null;
        }
    }

    public static void xj(JSONObject jSONObject, String str, List<String> list, boolean z) {
        if (jSONObject == null || list == null || list.isEmpty()) {
            return;
        }
        if (z) {
            try {
                jSONObject.put(str + "Size", list.size());
            } catch (JSONException unused) {
                return;
            }
        }
        jSONObject.put(str, kd.xj(list));
    }

    private static JSONObject xj(List<String> list) {
        if (list == null || list.isEmpty()) {
            return null;
        }
        JSONObject jSONObject = new JSONObject();
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        ArrayList arrayList3 = new ArrayList();
        for (String str : list) {
            if (str.endsWith(".png")) {
                arrayList2.add(str.substring(0, str.lastIndexOf(".png")));
            } else if (str.endsWith(".xml")) {
                arrayList.add(str.substring(0, str.lastIndexOf(".xml")));
            } else {
                arrayList3.add(str);
            }
        }
        xj(jSONObject, "xml", arrayList, true);
        xj(jSONObject, FileTypeUtils.FILE_TYPE_PNG, arrayList2, true);
        xj(jSONObject, AdnName.OTHER, arrayList3, true);
        return jSONObject;
    }

    public static long xj(long j, InputStream inputStream) {
        if (j != -1) {
            return j;
        }
        byte[] bArr = new byte[ProxyCacheUtils.DEFAULT_BUFFER_SIZE];
        long j2 = 0;
        while (true) {
            int read = inputStream.read(bArr);
            if (read == -1) {
                return j2;
            }
            j2 += read;
        }
    }

    private static void xj(File file, List<xj> list) {
        try {
            RandomAccessFile randomAccessFile = new RandomAccessFile(file, t.k);
            try {
                hf xj = w.xj(randomAccessFile, 0L, randomAccessFile.length());
                list.addAll(com.bytedance.sdk.component.panglearmor.xj.xj.hf.xj.xj.xj.xj(xj, com.bytedance.sdk.component.panglearmor.xj.xj.xj.xj.xj(xj)));
                randomAccessFile.close();
            } finally {
            }
        } catch (Throwable unused) {
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:99:0x0271, code lost:
    
        if (r10 == null) goto L118;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static org.json.JSONObject xj(java.io.File r23) {
        /*
            Method dump skipped, instructions count: 629
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.sdk.component.panglearmor.xj.hf.y.xj(java.io.File):org.json.JSONObject");
    }
}
