package com.czhj.volley.toolbox;

import android.text.TextUtils;
import com.czhj.volley.Cache;
import com.czhj.volley.Header;
import com.czhj.volley.NetworkResponse;
import com.czhj.volley.VolleyLog;
import com.sigmob.sdk.downloader.core.c;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.TimeZone;
import java.util.TreeMap;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public class HttpHeaderParser {

    /* renamed from: a, reason: collision with root package name */
    static final String f10644a = "Content-Type";
    private static final String b = "ISO-8859-1";
    private static final String c = "EEE, dd MMM yyyy HH:mm:ss zzz";

    public static String a(long j) {
        return a().format(new Date(j));
    }

    public static String getHeader(Map<String, String> map, String str) {
        return map.get(str);
    }

    public static boolean isGzipContent(Map<String, String> map) {
        return TextUtils.equals(getHeader(map, "Content-Encoding"), "gzip");
    }

    public static boolean isSupportRange(Map<String, String> map) {
        if (TextUtils.equals(getHeader(map, c.i), "bytes")) {
            return true;
        }
        String header = getHeader(map, c.f);
        return header != null && header.startsWith("bytes");
    }

    public static Cache.Entry parseCacheHeaders(NetworkResponse networkResponse) {
        long j;
        long j2;
        long j3;
        boolean z;
        long j4;
        long j5;
        long j6;
        long j7;
        long currentTimeMillis = System.currentTimeMillis();
        Map<String, String> map = networkResponse.headers;
        String str = map.get("Date");
        long parseDateAsEpoch = str != null ? parseDateAsEpoch(str) : 0L;
        String str2 = map.get("Cache-Control");
        int i = 0;
        if (str2 != null) {
            String[] split = str2.split(",", 0);
            z = false;
            j2 = 0;
            j3 = 0;
            while (i < split.length) {
                String trim = split[i].trim();
                if (trim.equals("no-cache") || trim.equals("no-store")) {
                    return null;
                }
                if (trim.startsWith("max-age=")) {
                    try {
                        j2 = Long.parseLong(trim.substring(8));
                    } catch (Throwable unused) {
                    }
                } else if (trim.startsWith("stale-while-revalidate=")) {
                    j3 = Long.parseLong(trim.substring(23));
                } else if (trim.equals("must-revalidate") || trim.equals("proxy-revalidate")) {
                    z = true;
                }
                i++;
            }
            j = 0;
            i = 1;
        } else {
            j = 0;
            j2 = 0;
            j3 = 0;
            z = false;
        }
        String str3 = map.get("Expires");
        long parseDateAsEpoch2 = str3 != null ? parseDateAsEpoch(str3) : j;
        String str4 = map.get("Last-Modified");
        if (str4 != null) {
            j4 = currentTimeMillis;
            j5 = parseDateAsEpoch(str4);
        } else {
            j4 = currentTimeMillis;
            j5 = j;
        }
        String str5 = map.get("ETag");
        if (i != 0) {
            long j8 = (j2 * 1000) + j4;
            if (z) {
                j7 = j8;
            } else {
                Long.signum(j3);
                j7 = (j3 * 1000) + j8;
            }
            j6 = j8;
        } else {
            j6 = (parseDateAsEpoch <= j || parseDateAsEpoch2 < parseDateAsEpoch) ? j : (parseDateAsEpoch2 - parseDateAsEpoch) + j4;
            j7 = j6;
        }
        Cache.Entry entry = new Cache.Entry();
        entry.data = networkResponse.data;
        entry.etag = str5;
        entry.softTtl = j6;
        entry.ttl = j7;
        entry.serverDate = parseDateAsEpoch;
        entry.lastModified = j5;
        entry.responseHeaders = map;
        entry.allResponseHeaders = networkResponse.allHeaders;
        return entry;
    }

    public static String parseCharset(Map<String, String> map) {
        return parseCharset(map, "ISO-8859-1");
    }

    public static long parseDateAsEpoch(String str) {
        try {
            return a().parse(str).getTime();
        } catch (ParseException e) {
            VolleyLog.e(e, "Unable to parse dateStr: %s, falling back to 0", str);
            return 0L;
        }
    }

    private static SimpleDateFormat a() {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(c, Locale.US);
        simpleDateFormat.setTimeZone(TimeZone.getTimeZone("GMT"));
        return simpleDateFormat;
    }

    public static String parseCharset(Map<String, String> map, String str) {
        String str2 = map.get(f10644a);
        if (str2 != null) {
            String[] split = str2.split(";", 0);
            for (int i = 1; i < split.length; i++) {
                String[] split2 = split[i].trim().split("=", 0);
                if (split2.length == 2 && split2[0].equals("charset")) {
                    return split2[1];
                }
            }
        }
        return str;
    }

    public static List<Header> a(Map<String, String> map) {
        ArrayList arrayList = new ArrayList(map.size());
        for (Map.Entry<String, String> entry : map.entrySet()) {
            arrayList.add(new Header(entry.getKey(), entry.getValue()));
        }
        return arrayList;
    }

    public static Map<String, String> a(List<Header> list) {
        TreeMap treeMap = new TreeMap(String.CASE_INSENSITIVE_ORDER);
        for (Header header : list) {
            treeMap.put(header.getName(), header.getValue());
        }
        return treeMap;
    }
}
