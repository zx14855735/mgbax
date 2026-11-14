package com.bytedance.sdk.openadsdk.core.a;

import android.content.Context;
import android.content.res.XmlResourceParser;
import android.text.TextUtils;
import com.bytedance.sdk.openadsdk.mediation.init.MediationConfigUserInfoForSegment;
import java.util.ArrayList;
import java.util.List;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public class v {

    public static class xj {
        String hf;
        String w;
        String xj;

        public xj(String str, String str2, String str3) {
            this.xj = str;
            this.hf = str2;
            this.w = str3;
        }

        public boolean equals(Object obj) {
            String str;
            if (!(obj instanceof xj)) {
                return super.equals(obj);
            }
            xj xjVar = (xj) obj;
            String str2 = this.xj;
            return str2 != null && str2.equals(xjVar.xj) && (str = this.w) != null && str.equals(xjVar.w);
        }

        public String toString() {
            try {
                return "<" + this.xj + " name=\"" + this.hf + "\" path=\"" + this.w + "\" />";
            } catch (Throwable unused) {
                return super.toString();
            }
        }
    }

    private static List<String> hf() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(com.kuaishou.weapon.p0.g.f12282a);
        arrayList.add(com.kuaishou.weapon.p0.g.b);
        arrayList.add(com.kuaishou.weapon.p0.g.d);
        arrayList.add(com.kuaishou.weapon.p0.g.c);
        arrayList.add(com.kuaishou.weapon.p0.g.j);
        arrayList.add("android.permission.REQUEST_INSTALL_PACKAGES");
        arrayList.add(com.kuaishou.weapon.p0.g.h);
        arrayList.add(com.kuaishou.weapon.p0.g.g);
        return arrayList;
    }

    private static List<xj> u() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(new xj("external-path", "tt_external_root", "."));
        return arrayList;
    }

    private static List<xj> w() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(new xj("external-path", "tt_external_download", "Download"));
        arrayList.add(new xj("external-files-path", "tt_external_files_download", "Download"));
        arrayList.add(new xj("files-path", "tt_internal_file_download", "Download"));
        arrayList.add(new xj("cache-path", "tt_internal_cache_download", "Download"));
        return arrayList;
    }

    /* JADX WARN: Removed duplicated region for block: B:111:0x026a  */
    /* JADX WARN: Removed duplicated region for block: B:113:0x0271  */
    /* JADX WARN: Removed duplicated region for block: B:116:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static void xj() {
        /*
            Method dump skipped, instructions count: 631
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.sdk.openadsdk.core.a.v.xj():void");
    }

    private static String xj(Context context) {
        try {
            return com.bytedance.sdk.component.utils.e.hf(context);
        } catch (Throwable unused) {
            return MediationConfigUserInfoForSegment.GENDER_UNKNOWN;
        }
    }

    private static List<xj> xj(Context context, int i) {
        XmlResourceParser xmlResourceParser;
        try {
            ArrayList arrayList = new ArrayList();
            xmlResourceParser = context.getResources().getXml(i);
            try {
                for (int eventType = xmlResourceParser.getEventType(); eventType != 1; eventType = xmlResourceParser.next()) {
                    if (eventType == 2) {
                        String name = xmlResourceParser.getName();
                        int attributeCount = xmlResourceParser.getAttributeCount();
                        String str = null;
                        String str2 = null;
                        for (int i2 = 0; i2 < attributeCount; i2++) {
                            String attributeName = xmlResourceParser.getAttributeName(i2);
                            if (attributeName.equals("name")) {
                                str = xmlResourceParser.getAttributeValue(i2);
                            } else if (attributeName.equals("path")) {
                                str2 = xmlResourceParser.getAttributeValue(i2);
                            }
                        }
                        if (!TextUtils.isEmpty(name) && !TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
                            arrayList.add(new xj(name, str, str2));
                        }
                    }
                }
                xmlResourceParser.close();
                return arrayList;
            } catch (Throwable unused) {
                if (xmlResourceParser != null) {
                    xmlResourceParser.close();
                }
                return null;
            }
        } catch (Throwable unused2) {
            xmlResourceParser = null;
        }
    }
}
