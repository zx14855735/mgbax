package com.bykv.vk.openvk.component.video.xj.hf;

import ADYaiT.CtFAbx;
import android.net.Uri;
import android.text.TextUtils;
import com.kuaishou.weapon.p0.t;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public class d {
    public final List<hf> hf;
    public final xj w;
    public final w xj;

    public static final class hf {
        public final String hf;
        public final String xj;

        public hf(String str, String str2) {
            this.xj = str;
            this.hf = str2;
        }

        public static hf xj(String str) {
            int indexOf = str.indexOf(":");
            if (indexOf == -1) {
                throw new u("request header format error, header: ".concat(str));
            }
            String trim = str.substring(0, indexOf).trim();
            String trim2 = str.substring(indexOf + 1).trim();
            if (trim.length() == 0 || trim2.length() == 0) {
                throw new u("request header format error, header: ".concat(str));
            }
            return new hf(trim, trim2);
        }

        public String toString() {
            StringBuilder sb = new StringBuilder("Header{name='");
            sb.append(this.xj);
            sb.append("', value='");
            return CtFAbx.B25kr6(sb, this.hf, "'}");
        }
    }

    public static final class u extends Exception {
        public u(String str) {
            super(str);
        }
    }

    public static final class w {
        final String hf;
        final String w;
        final String xj;

        private w(String str, String str2, String str3) {
            this.xj = str;
            this.hf = str2;
            this.w = str3;
        }

        public static w xj(String str) {
            int indexOf = str.indexOf(32);
            if (indexOf == -1) {
                throw new u("request line format error, line: ".concat(str));
            }
            int lastIndexOf = str.lastIndexOf(32);
            if (lastIndexOf <= indexOf) {
                throw new u("request line format error, line: ".concat(str));
            }
            String trim = str.substring(0, indexOf).trim();
            String trim2 = str.substring(indexOf + 1, lastIndexOf).trim();
            String trim3 = str.substring(lastIndexOf + 1).trim();
            if (trim.length() == 0 || trim2.length() == 0 || trim3.length() == 0) {
                throw new u("request line format error, line: ".concat(str));
            }
            return new w(trim, trim2, trim3);
        }

        public String toString() {
            StringBuilder sb = new StringBuilder("RequestLine{method='");
            sb.append(this.xj);
            sb.append("', path='");
            sb.append(this.hf);
            sb.append("', version='");
            return CtFAbx.B25kr6(sb, this.w, "'}");
        }
    }

    public static final class xj {
        final List<String> c;
        final String hf;
        final int kd;
        final int u;
        final String w;
        final int xj;
        final String y;

        private xj(int i, String str, String str2, int i2, int i3, String str3, List<String> list) {
            this.xj = i;
            this.hf = str;
            this.w = str2;
            this.u = i2;
            this.kd = i3;
            this.y = str3;
            this.c = list;
        }

        public static xj xj(w wVar, List<hf> list) {
            String str;
            int i;
            int i2;
            int indexOf = wVar.hf.indexOf("?");
            if (indexOf == -1) {
                throw new u("path format error, path: " + wVar.hf);
            }
            ArrayList arrayList = new ArrayList();
            String str2 = null;
            String str3 = null;
            String str4 = null;
            int i3 = 0;
            for (String str5 : wVar.hf.substring(indexOf + 1).split("&")) {
                String[] split = str5.split("=");
                if (split.length == 2) {
                    if ("rk".equals(split[0])) {
                        str2 = Uri.decode(split[1]);
                    } else if (t.f12297a.equals(split[0])) {
                        str3 = Uri.decode(split[1]);
                    } else if (split[0].startsWith(t.i)) {
                        arrayList.add(Uri.decode(split[1]));
                    } else if ("f".equals(split[0]) && com.bykv.vk.openvk.component.video.xj.w.xj.hf(split[1]) == 1) {
                        i3 = 1;
                    }
                }
            }
            if (TextUtils.isEmpty(str2) || TextUtils.isEmpty(str3)) {
                throw new u("rawKey or key is empty, path: " + wVar.hf);
            }
            if (list != null) {
                int i4 = 0;
                int i5 = 0;
                for (hf hfVar : list) {
                    if (hfVar != null && com.sigmob.sdk.downloader.core.c.b.equalsIgnoreCase(hfVar.xj)) {
                        int indexOf2 = hfVar.hf.indexOf("=");
                        if (indexOf2 == -1) {
                            throw new u("Range format error, Range: " + hfVar.hf);
                        }
                        if (!"bytes".equalsIgnoreCase(hfVar.hf.substring(0, indexOf2).trim())) {
                            throw new u("Range format error, Range: " + hfVar.hf);
                        }
                        String substring = hfVar.hf.substring(indexOf2 + 1);
                        if (substring.contains(",")) {
                            throw new u("Range format error, Range: " + hfVar.hf);
                        }
                        int indexOf3 = substring.indexOf("-");
                        if (indexOf3 == -1) {
                            throw new u("Range format error, Range: " + hfVar.hf);
                        }
                        String trim = substring.substring(0, indexOf3).trim();
                        String trim2 = substring.substring(indexOf3 + 1).trim();
                        try {
                            if (trim.length() > 0) {
                                i4 = Integer.parseInt(trim);
                            }
                            if (trim2.length() > 0 && i4 > (i5 = Integer.parseInt(trim2))) {
                                throw new u("Range format error, Range: " + hfVar.hf);
                            }
                            str4 = hfVar.hf;
                        } catch (NumberFormatException unused) {
                            throw new u("Range format error, Range: " + hfVar.hf);
                        }
                    }
                }
                i = i4;
                str = str4;
                i2 = i5;
            } else {
                str = null;
                i = 0;
                i2 = 0;
            }
            if (!arrayList.isEmpty()) {
                return new xj(i3, str2, str3, i, i2, str, arrayList);
            }
            throw new u("no url found: path: " + wVar.hf);
        }

        public String toString() {
            return "Extra{flag=" + this.xj + ", rawKey='" + this.hf + "', key='" + this.w + "', from=" + this.u + ", to=" + this.kd + ", urls=" + this.c + '}';
        }
    }

    public d(w wVar, List<hf> list, xj xjVar) {
        this.xj = wVar;
        this.hf = list;
        this.w = xjVar;
    }

    public static d xj(InputStream inputStream) {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream, com.bykv.vk.openvk.component.video.xj.w.xj.xj));
        ArrayList arrayList = new ArrayList();
        w wVar = null;
        while (true) {
            String readLine = bufferedReader.readLine();
            if (TextUtils.isEmpty(readLine)) {
                break;
            }
            String trim = readLine.trim();
            if (wVar == null) {
                wVar = w.xj(trim);
            } else {
                arrayList.add(hf.xj(trim));
            }
        }
        if (wVar != null) {
            return new d(wVar, arrayList, xj.xj(wVar, arrayList));
        }
        throw new u("request line is null");
    }

    public String toString() {
        return "Request{requestLine=" + this.xj + ", headers=" + this.hf + ", extra=" + this.w + '}';
    }

    public static String xj(String str, String str2, List<String> list) {
        StringBuilder sb = new StringBuilder(512);
        String str3 = null;
        do {
            if (str3 != null) {
                if (list.size() == 1) {
                    return null;
                }
                list.remove(list.size() - 1);
            }
            str3 = xj(sb, str, str2, list);
        } while (str3.length() > 3072);
        return str3;
    }

    private static String xj(StringBuilder sb, String str, String str2, List<String> list) {
        sb.delete(0, sb.length());
        sb.append("rk=");
        sb.append(Uri.encode(str));
        sb.append("&k=");
        sb.append(Uri.encode(str2));
        int size = list.size();
        for (int i = 0; i < size; i++) {
            sb.append("&u");
            sb.append(i);
            sb.append("=");
            sb.append(Uri.encode(list.get(i)));
        }
        return sb.toString();
    }
}
