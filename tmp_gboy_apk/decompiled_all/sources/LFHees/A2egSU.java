package LFHees;

import ADYaiT.CtFAbx;
import B4ZgIw.AYUAbz;
import Qo94AZ.AZOQYO;
import Qo94AZ.AZkASS;
import Qo94AZ.AcNBzu;
import Qo94AZ.AlLFFp;
import Qo94AZ.B25kr6;
import android.content.res.AssetManager;
import android.util.Base64;
import com.baidu.mobads.sdk.api.IAdInterListener;
import com.baidu.mobads.sdk.internal.an;
import com.fl.saas.common.crash.CrashHandler;
import com.fl.saas.videocache.ProxyCacheUtils;
import com.kuaishou.weapon.p0.d;
import com.kuaishou.weapon.p0.t;
import com.sigmob.sdk.base.n;
import com.sigmob.sdk.downloader.core.breakpoint.f;
import com.sigmob.sdk.downloader.core.c;
import com.ss.android.download.api.constant.BaseConstants;
import com.ss.android.downloadad.api.constant.AdBaseConstants;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Locale;
import java.util.Objects;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public final class A2egSU extends B25kr6 {

    /* renamed from: AaHO0E, reason: collision with root package name */
    public final File f4447AaHO0E;

    /* renamed from: AcNBzu, reason: collision with root package name */
    public final AssetManager f4448AcNBzu;

    public A2egSU(File file, AssetManager assetManager) {
        this.f4447AaHO0E = file;
        this.f4448AcNBzu = assetManager;
    }

    public static boolean AYUAbz(File file) {
        File[] listFiles;
        if (file.isDirectory() && (listFiles = file.listFiles()) != null) {
            for (File file2 : listFiles) {
                if (!AYUAbz(file2)) {
                    return false;
                }
            }
        }
        return file.delete();
    }

    public static String AZkASS(String str) {
        if (str == null) {
            return "";
        }
        try {
            return URLEncoder.encode(str, "UTF-8").replace("+", "%20");
        } catch (Exception unused) {
            return "";
        }
    }

    public static String AaHO0E(String str) {
        if (str == null) {
            return "";
        }
        return str.replace("&", "&amp;").replace("<", "&lt;").replace(">", "&gt;").replace("'", "&#39;").replace(String.valueOf('\"'), "&quot;");
    }

    public static String AcNBzu(String str) {
        String lowerCase = str.toLowerCase(Locale.US);
        return lowerCase.endsWith(".gba") ? "application/x-gba-rom" : lowerCase.endsWith(".gbc") ? "application/x-gbc-rom" : lowerCase.endsWith(".gb") ? "application/x-gb-rom" : lowerCase.endsWith(".nes") ? "application/x-nes-rom" : lowerCase.endsWith(".zip") ? "application/zip" : lowerCase.endsWith(".7z") ? "application/x-7z-compressed" : lowerCase.endsWith(".rar") ? "application/x-rar-compressed" : lowerCase.endsWith(d.b) ? "application/gzip" : lowerCase.endsWith(".png") ? "image/png" : (lowerCase.endsWith(".jpg") || lowerCase.endsWith(".jpeg")) ? "image/jpeg" : lowerCase.endsWith(".gif") ? "image/gif" : lowerCase.endsWith(".webp") ? "image/webp" : lowerCase.endsWith(".bmp") ? "image/bmp" : lowerCase.endsWith(".ico") ? "image/x-icon" : lowerCase.endsWith(".svg") ? "image/svg+xml" : lowerCase.endsWith(".pdf") ? "application/pdf" : lowerCase.endsWith(CrashHandler.FILE_NAME_SUFFIX) ? "text/plain; charset=utf-8" : lowerCase.endsWith(".json") ? an.d : lowerCase.endsWith(".xml") ? "application/xml" : lowerCase.endsWith(".mp3") ? "audio/mpeg" : lowerCase.endsWith(".wav") ? "audio/wav" : lowerCase.endsWith(".mp4") ? "video/mp4" : lowerCase.endsWith(".apk") ? AdBaseConstants.MIME_APK : "application/octet-stream";
    }

    public static boolean AmA8tU(String str) {
        if (str == null) {
            return false;
        }
        String lowerCase = str.toLowerCase(Locale.US);
        if (lowerCase.endsWith(".gba") || lowerCase.endsWith(".gbc") || lowerCase.endsWith(".gb") || lowerCase.endsWith(".nes") || lowerCase.endsWith(".rom") || lowerCase.endsWith(".iso") || lowerCase.endsWith(".sav") || lowerCase.endsWith(".srm") || lowerCase.endsWith(".state") || lowerCase.endsWith(".zip") || lowerCase.endsWith(".rar") || lowerCase.endsWith(".7z") || lowerCase.endsWith(d.b) || lowerCase.endsWith(".tar") || lowerCase.endsWith(".xz") || lowerCase.endsWith(".png") || lowerCase.endsWith(".jpg") || lowerCase.endsWith(".jpeg") || lowerCase.endsWith(".gif") || lowerCase.endsWith(".webp") || lowerCase.endsWith(".bmp") || lowerCase.endsWith(".mp3") || lowerCase.endsWith(".wav") || lowerCase.endsWith(".ogg") || lowerCase.endsWith(".flac") || lowerCase.endsWith(".mp4") || lowerCase.endsWith(".mkv") || lowerCase.endsWith(".avi") || lowerCase.endsWith(".apk")) {
            return false;
        }
        return lowerCase.endsWith(CrashHandler.FILE_NAME_SUFFIX) || lowerCase.endsWith(".md") || lowerCase.endsWith(".log") || lowerCase.endsWith(".json") || lowerCase.endsWith(".xml") || lowerCase.endsWith(".ini") || lowerCase.endsWith(".cfg") || lowerCase.endsWith(".conf") || lowerCase.endsWith(".prop") || lowerCase.endsWith(".properties") || lowerCase.endsWith(".shader") || lowerCase.endsWith(".glsl") || lowerCase.endsWith(".frag") || lowerCase.endsWith(".vert") || lowerCase.endsWith(".html") || lowerCase.endsWith(".htm") || lowerCase.endsWith(".css") || lowerCase.endsWith(".js") || lowerCase.endsWith(".java") || lowerCase.endsWith(".kt") || lowerCase.endsWith(".py") || lowerCase.endsWith(".sh") || lowerCase.endsWith(".bat") || lowerCase.endsWith(".yaml") || lowerCase.endsWith(".yml") || lowerCase.endsWith(".csv");
    }

    public static String B25kr6(String str) {
        int lastIndexOf = str.lastIndexOf(47);
        return lastIndexOf < 0 ? "" : str.substring(0, lastIndexOf);
    }

    public static AlLFFp B2KMhB(String str) {
        AlLFFp A5SV6n2 = B25kr6.A5SV6n(AcNBzu.REDIRECT, "text/plain; charset=utf-8", "redirect");
        A5SV6n2.f7808B25kr6.put("Location", str);
        return A5SV6n2;
    }

    @Override // Qo94AZ.B25kr6
    public final AlLFFp AMqCpz(AZOQYO azoqyo) {
        String str = azoqyo.f7785ARc23Z;
        HashMap hashMap = new HashMap();
        try {
            if (azoqyo.f7786ASJ6gh == 3) {
                azoqyo.AYUAbz(hashMap);
            }
            String str2 = (String) azoqyo.ASJ6gh().get(t.b);
            if (str2 == null) {
                str2 = "";
            }
            if (!str.equals("/") && !str.equals("/index.html")) {
                if (!str.equals("/download") && !str.startsWith("/download/")) {
                    return str.equals("/raw") ? BChYOn(str2) : str.equals("/edit") ? AZOQYO(str2) : str.equals("/save") ? BIYEnU(azoqyo, str2) : str.equals("/upload") ? BJ7GGh(azoqyo, str2, hashMap) : str.equals("/delete") ? B4ZgIw(str2) : str.equals("/rename") ? BI9f7h(azoqyo, str2) : str.equals("/mkdir") ? B9tovu(azoqyo, str2) : B25kr6.A5SV6n(AcNBzu.NOT_FOUND, "text/plain; charset=utf-8", "404 Not Found");
                }
                return B7CMnp(str2);
            }
            return AlLFFp(str2);
        } catch (Exception e) {
            return B25kr6.A5SV6n(AcNBzu.INTERNAL_ERROR, "text/plain; charset=utf-8", "Error: " + e);
        }
    }

    public final AlLFFp AZOQYO(String str) {
        File B3GDIM2 = B3GDIM(str);
        if (!B3GDIM2.isFile()) {
            return B25kr6.A5SV6n(AcNBzu.NOT_FOUND, "text/plain; charset=utf-8", "文件不存在");
        }
        boolean AmA8tU2 = AmA8tU(B3GDIM2.getName());
        AcNBzu acNBzu = AcNBzu.BAD_REQUEST;
        if (!AmA8tU2) {
            return B25kr6.A5SV6n(acNBzu, "text/plain; charset=utf-8", "该文件类型不支持在线编辑");
        }
        if (B3GDIM2.length() > BaseConstants.MB_VALUE) {
            return B25kr6.A5SV6n(acNBzu, "text/plain; charset=utf-8", "文件过大（>1MB），无法在线编辑");
        }
        String replace = AzWtSf("edit.html").replace("{{NAME}}", AaHO0E(B3GDIM2.getName()));
        FileInputStream fileInputStream = new FileInputStream(B3GDIM2);
        try {
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            byte[] bArr = new byte[ProxyCacheUtils.DEFAULT_BUFFER_SIZE];
            while (true) {
                int read = fileInputStream.read(bArr);
                if (read <= 0) {
                    break;
                }
                byteArrayOutputStream.write(bArr, 0, read);
            }
            String str2 = new String(byteArrayOutputStream.toByteArray(), "UTF-8");
            fileInputStream.close();
            String replace2 = replace.replace("{{CONTENT}}", AaHO0E(str2)).replace("{{SAVE_URL}}", "/save?p=" + AZkASS(str)).replace("{{PARENT}}", AZkASS(B25kr6(str)));
            String name = B3GDIM2.getName();
            String str3 = "plain";
            if (name != null) {
                String lowerCase = name.toLowerCase(Locale.US);
                if (lowerCase.endsWith(".xml") || lowerCase.endsWith(".cht") || lowerCase.endsWith(".html") || lowerCase.endsWith(".htm") || lowerCase.endsWith(".svg") || lowerCase.endsWith(".xhtml")) {
                    str3 = "xml";
                } else if (lowerCase.endsWith(".java") || lowerCase.endsWith(".kt") || lowerCase.endsWith(".kts") || lowerCase.endsWith(".js") || lowerCase.endsWith(".ts") || lowerCase.endsWith(".py") || lowerCase.endsWith(".sh") || lowerCase.endsWith(".bat") || lowerCase.endsWith(".c") || lowerCase.endsWith(".cpp") || lowerCase.endsWith(".cc") || lowerCase.endsWith(".h") || lowerCase.endsWith(".hpp")) {
                    str3 = "java";
                } else if (lowerCase.endsWith(".json")) {
                    str3 = "json";
                }
            }
            return B25kr6.A5SV6n(AcNBzu.OK, "text/html; charset=utf-8", replace2.replace("{{LANG}}", str3));
        } catch (Throwable th) {
            fileInputStream.close();
            throw th;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:166:0x0154  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x0148  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x017d  */
    /* JADX WARN: Removed duplicated region for block: B:52:0x0396  */
    /* JADX WARN: Removed duplicated region for block: B:55:0x03a3 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:56:0x018c  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final Qo94AZ.AlLFFp AlLFFp(java.lang.String r22) {
        /*
            Method dump skipped, instructions count: 1136
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: LFHees.A2egSU.AlLFFp(java.lang.String):Qo94AZ.AlLFFp");
    }

    public final String AzWtSf(String str) {
        InputStream open = this.f4448AcNBzu.open(str);
        try {
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            byte[] bArr = new byte[ProxyCacheUtils.DEFAULT_BUFFER_SIZE];
            while (true) {
                int read = open.read(bArr);
                if (read <= 0) {
                    String str2 = new String(byteArrayOutputStream.toByteArray(), "UTF-8");
                    open.close();
                    return str2;
                }
                byteArrayOutputStream.write(bArr, 0, read);
            }
        } catch (Throwable th) {
            open.close();
            throw th;
        }
    }

    public final File B3GDIM(String str) {
        File file = this.f4447AaHO0E;
        File file2 = new File(file, str);
        String canonicalPath = file.getCanonicalPath();
        String canonicalPath2 = file2.getCanonicalPath();
        if (!canonicalPath2.equals(canonicalPath)) {
            StringBuilder A4TApA2 = AYUAbz.A4TApA(canonicalPath);
            A4TApA2.append(File.separator);
            if (!canonicalPath2.startsWith(A4TApA2.toString())) {
                throw new IOException("非法路径");
            }
        }
        return file2;
    }

    public final AlLFFp B4ZgIw(String str) {
        AcNBzu acNBzu = AcNBzu.INTERNAL_ERROR;
        if (str.trim().isEmpty()) {
            return B25kr6.A5SV6n(AcNBzu.BAD_REQUEST, "text/plain; charset=utf-8", "缺少路径");
        }
        File B3GDIM2 = B3GDIM(str);
        if (!B3GDIM2.exists()) {
            return B25kr6.A5SV6n(AcNBzu.NOT_FOUND, "text/plain; charset=utf-8", "文件不存在");
        }
        try {
            if (B3GDIM2.getCanonicalPath().equals(this.f4447AaHO0E.getCanonicalPath())) {
                return B25kr6.A5SV6n(AcNBzu.FORBIDDEN, "text/plain; charset=utf-8", "不能删除根目录");
            }
            boolean AYUAbz2 = AYUAbz(B3GDIM2);
            B3GDIM2.getAbsolutePath();
            if (!AYUAbz2) {
                return B25kr6.A5SV6n(acNBzu, "text/plain; charset=utf-8", "删除失败");
            }
            return B2KMhB("/?p=" + AZkASS(B25kr6(str)));
        } catch (IOException unused) {
            return B25kr6.A5SV6n(acNBzu, "text/plain; charset=utf-8", "路径异常");
        }
    }

    public final AlLFFp B7CMnp(String str) {
        String sb;
        File B3GDIM2 = B3GDIM(str);
        if (!B3GDIM2.isFile()) {
            return B25kr6.A5SV6n(AcNBzu.NOT_FOUND, "text/plain; charset=utf-8", "文件不存在");
        }
        AlLFFp alLFFp = new AlLFFp(AcNBzu.OK, AcNBzu(B3GDIM2.getName()), new FileInputStream(B3GDIM2), B3GDIM2.length());
        String name = B3GDIM2.getName();
        String valueOf = String.valueOf('\"');
        StringBuilder sb2 = new StringBuilder();
        for (int i = 0; i < name.length(); i++) {
            char charAt = name.charAt(i);
            if (charAt >= 128 || charAt == '\"' || charAt == '\\') {
                sb2.append('_');
            } else {
                sb2.append(charAt);
            }
        }
        try {
            sb = URLEncoder.encode(name, "UTF-8").replace("+", "%20");
        } catch (Exception unused) {
            sb = sb2.toString();
        }
        alLFFp.f7808B25kr6.put(c.j, "attachment; filename=" + valueOf + ((Object) sb2) + valueOf + "; filename*=UTF-8''" + sb);
        return alLFFp;
    }

    public final AlLFFp B9tovu(AZOQYO azoqyo, String str) {
        String str2 = (String) azoqyo.ASJ6gh().get("name");
        AcNBzu acNBzu = AcNBzu.BAD_REQUEST;
        if (str2 == null) {
            return B25kr6.A5SV6n(acNBzu, "text/plain; charset=utf-8", "缺少名称");
        }
        String trim = str2.trim();
        if (trim.isEmpty() || trim.contains("/")) {
            return B25kr6.A5SV6n(acNBzu, "text/plain; charset=utf-8", "名称无效");
        }
        new File(B3GDIM(str), trim).mkdirs();
        return B2KMhB("/?p=" + AZkASS(str));
    }

    public final AlLFFp BChYOn(String str) {
        File B3GDIM2 = B3GDIM(str);
        if (!B3GDIM2.isFile()) {
            return B25kr6.A5SV6n(AcNBzu.NOT_FOUND, "text/plain; charset=utf-8", "文件不存在");
        }
        AlLFFp alLFFp = new AlLFFp(AcNBzu.OK, AcNBzu(B3GDIM2.getName()), new FileInputStream(B3GDIM2), B3GDIM2.length());
        AZkASS aZkASS = alLFFp.f7808B25kr6;
        aZkASS.put(c.j, "inline");
        aZkASS.put("Cache-Control", "public, max-age=3600");
        return alLFFp;
    }

    public final AlLFFp BI9f7h(AZOQYO azoqyo, String str) {
        String str2 = (String) azoqyo.ASJ6gh().get("old");
        String str3 = (String) azoqyo.ASJ6gh().get("new");
        AcNBzu acNBzu = AcNBzu.BAD_REQUEST;
        if (str2 == null || str3 == null) {
            return B25kr6.A5SV6n(acNBzu, "text/plain; charset=utf-8", "参数缺失");
        }
        String trim = str3.trim();
        if (trim.isEmpty() || trim.contains("/")) {
            return B25kr6.A5SV6n(acNBzu, "text/plain; charset=utf-8", "名称无效");
        }
        File B3GDIM2 = B3GDIM(str);
        File file = new File(B3GDIM2, str2);
        File file2 = new File(B3GDIM2, trim);
        if (!file.exists()) {
            return B25kr6.A5SV6n(AcNBzu.NOT_FOUND, "text/plain; charset=utf-8", "文件不存在");
        }
        if (file2.exists()) {
            return B25kr6.A5SV6n(AcNBzu.CONFLICT, "text/plain; charset=utf-8", "目标名称已存在");
        }
        if (!file.renameTo(file2)) {
            return B25kr6.A5SV6n(AcNBzu.INTERNAL_ERROR, "text/plain; charset=utf-8", "重命名失败");
        }
        return B2KMhB("/?p=" + AZkASS(str));
    }

    public final AlLFFp BIYEnU(AZOQYO azoqyo, String str) {
        File B3GDIM2 = B3GDIM(str);
        if (!B3GDIM2.isFile()) {
            return B25kr6.A5SV6n(AcNBzu.NOT_FOUND, "text/plain; charset=utf-8", "文件不存在");
        }
        if (!AmA8tU(B3GDIM2.getName())) {
            return B25kr6.A5SV6n(AcNBzu.BAD_REQUEST, "text/plain; charset=utf-8", "该文件类型不支持在线编辑");
        }
        String str2 = (String) azoqyo.ASJ6gh().get(IAdInterListener.AdProdType.PRODUCT_CONTENT);
        if (str2 == null) {
            str2 = "";
        }
        FileOutputStream fileOutputStream = new FileOutputStream(B3GDIM2);
        try {
            fileOutputStream.write(str2.getBytes("UTF-8"));
            fileOutputStream.close();
            return B2KMhB("/?p=" + AZkASS(B25kr6(str)));
        } catch (Throwable th) {
            fileOutputStream.close();
            throw th;
        }
    }

    public final AlLFFp BJ7GGh(AZOQYO azoqyo, String str, HashMap hashMap) {
        int i;
        String str2;
        String str3 = (String) hashMap.get(n.z);
        AcNBzu acNBzu = AcNBzu.BAD_REQUEST;
        if (str3 == null) {
            Objects.toString(hashMap.keySet());
            return B25kr6.A5SV6n(acNBzu, "text/plain; charset=utf-8", "未选择文件");
        }
        String str4 = (String) azoqyo.ASJ6gh().get("filename_b64");
        String str5 = (String) azoqyo.ASJ6gh().get(f.e);
        String str6 = null;
        if (str4 != null && !str4.trim().isEmpty()) {
            try {
                String str7 = new String(Base64.decode(str4, 0), "UTF-8");
                if (str7.indexOf(65533) < 0) {
                    if (!str7.trim().isEmpty()) {
                        str6 = str7;
                    }
                }
            } catch (Exception unused) {
            }
        }
        if (str6 != null || str5 == null || str5.trim().isEmpty() || str5.indexOf(65533) >= 0) {
            str5 = str6;
        }
        String str8 = "upload.bin";
        if (str5 == null || str5.trim().isEmpty()) {
            str5 = "upload.bin";
        }
        String replace = str5.replace('\\', '/');
        while (true) {
            i = 1;
            if (!replace.startsWith("/")) {
                break;
            }
            replace = replace.substring(1);
        }
        while (replace.endsWith("/")) {
            replace = CtFAbx.AMqCpz(1, 0, replace);
        }
        if (!replace.isEmpty() && replace.indexOf(65533) < 0) {
            str8 = replace;
        }
        if (str8.contains("..")) {
            return B25kr6.A5SV6n(acNBzu, "text/plain; charset=utf-8", "非法路径");
        }
        File B3GDIM2 = B3GDIM(str);
        if (!B3GDIM2.isDirectory()) {
            B3GDIM2.getAbsolutePath();
            return B25kr6.A5SV6n(acNBzu, "text/plain; charset=utf-8", "目标目录不存在");
        }
        File file = new File(B3GDIM2, str8);
        String canonicalPath = this.f4447AaHO0E.getCanonicalPath();
        String canonicalPath2 = file.getCanonicalPath();
        if (!canonicalPath2.equals(canonicalPath)) {
            StringBuilder A4TApA2 = AYUAbz.A4TApA(canonicalPath);
            A4TApA2.append(File.separator);
            if (!canonicalPath2.startsWith(A4TApA2.toString())) {
                return B25kr6.A5SV6n(acNBzu, "text/plain; charset=utf-8", "非法路径");
            }
        }
        File parentFile = file.getParentFile();
        if (parentFile != null && !parentFile.exists()) {
            parentFile.mkdirs();
        }
        File parentFile2 = file.getParentFile();
        String name = file.getName();
        File file2 = new File(parentFile2, name);
        if (file2.exists()) {
            int lastIndexOf = name.lastIndexOf(46);
            if (lastIndexOf > 0) {
                String substring = name.substring(0, lastIndexOf);
                str2 = name.substring(lastIndexOf);
                name = substring;
            } else {
                str2 = "";
            }
            while (true) {
                if (i >= 10000) {
                    break;
                }
                File file3 = new File(parentFile2, name + "(" + i + ")" + str2);
                if (!file3.exists()) {
                    file2 = file3;
                    break;
                }
                i++;
            }
        }
        file2.getAbsolutePath();
        FileInputStream fileInputStream = new FileInputStream(new File(str3));
        FileOutputStream fileOutputStream = new FileOutputStream(file2);
        try {
            byte[] bArr = new byte[ProxyCacheUtils.DEFAULT_BUFFER_SIZE];
            while (true) {
                int read = fileInputStream.read(bArr);
                if (read <= 0) {
                    fileInputStream.close();
                    fileOutputStream.close();
                    return B2KMhB("/?p=" + AZkASS(str));
                }
                fileOutputStream.write(bArr, 0, read);
            }
        } catch (Throwable th) {
            fileInputStream.close();
            fileOutputStream.close();
            throw th;
        }
    }
}
