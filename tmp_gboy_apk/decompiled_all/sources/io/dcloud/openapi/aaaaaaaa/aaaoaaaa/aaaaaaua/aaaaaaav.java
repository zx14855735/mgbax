package io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aaaaaaua;

import android.content.Context;
import android.text.TextUtils;
import io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aoaaaaaa.aaaaaaeo;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.UUID;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
public abstract class aaaaaaav {
    private static String aaaaaaa0 = null;
    private static String aaaaaaaa = "";
    private static String aaaaaaao;

    private static StringBuilder aaaaaaa0(InputStream inputStream) {
        if (inputStream == null) {
            return null;
        }
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
        StringBuilder sb = new StringBuilder();
        while (true) {
            String readLine = bufferedReader.readLine();
            if (readLine == null) {
                inputStream.close();
                return sb;
            }
            sb.append(readLine);
            sb.append("\n");
        }
    }

    private static boolean aaaaaaaa(String str) {
        return TextUtils.isEmpty(str) || str.contains("Unknown") || str.contains("00000000");
    }

    /* JADX WARN: Code restructure failed: missing block: B:58:0x00c3, code lost:
    
        if (android.text.TextUtils.isEmpty(r5) != false) goto L84;
     */
    /* JADX WARN: Code restructure failed: missing block: B:59:0x00d2, code lost:
    
        r3 = r5.replace("\n", "");
     */
    /* JADX WARN: Code restructure failed: missing block: B:60:0x00d6, code lost:
    
        r1.append(r3);
        r1.append("|");
     */
    /* JADX WARN: Code restructure failed: missing block: B:70:0x00cf, code lost:
    
        if (android.text.TextUtils.isEmpty(r5) != false) goto L84;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static java.lang.String aaaaaaaa(android.content.Context r6, boolean r7, boolean r8) {
        /*
            Method dump skipped, instructions count: 289
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aaaaaaua.aaaaaaav.aaaaaaaa(android.content.Context, boolean, boolean):java.lang.String");
    }

    public static String aaaaaaaa(Context context) {
        try {
            io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aauaaaaa.aaaaaaao.aaaaaaaa(context);
            StringBuilder sb = new StringBuilder();
            sb.append(context.getFilesDir());
            String str = File.separator;
            sb.append(str);
            sb.append(".imei.txt");
            String sb2 = sb.toString();
            File file = new File(sb2);
            if (!file.exists()) {
                sb2 = context.getFilesDir() + str + ".DC4278477faeb9.txt";
                file = new File(sb2);
            }
            if (file.isDirectory()) {
                file.delete();
            }
            return aaaaaaaa(file, null, sb2, null, context);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    private static String aaaaaaaa(File file, File file2, String str, String str2, Context context) {
        String str3;
        if (file.exists() && file.length() > 0) {
            try {
                str3 = aaaaaaaa(new FileInputStream(file));
                if (file2 != null) {
                    try {
                        if (!io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aauaaaaa.aaaaaaao.aaaaaaaa(context)) {
                            if (!file2.getParentFile().exists()) {
                                file2.getParentFile().mkdirs();
                                file2.createNewFile();
                            }
                            aaaaaaeo.aaaaaaaa(str, str2);
                        }
                    } catch (Exception unused) {
                        return str3 == null ? aaaaaaaa(context, file, file2, ".DC4278477faeb9.txt") : str3;
                    }
                }
                return str3;
            } catch (Exception unused2) {
                str3 = null;
            }
        } else {
            return aaaaaaaa(context, file, file2, ".DC4278477faeb9.txt");
        }
    }

    private static String aaaaaaaa(Context context, File file, File file2, String str) {
        if (!file.getParentFile().exists()) {
            file.getParentFile().mkdirs();
            file.createNewFile();
        }
        String replace = UUID.randomUUID().toString().replaceAll("-", "").replace("\n", "");
        byte[] bytes = replace.getBytes();
        try {
            FileOutputStream fileOutputStream = new FileOutputStream(file);
            fileOutputStream.write(bytes);
            fileOutputStream.flush();
            fileOutputStream.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e2) {
            e2.printStackTrace();
        }
        if (io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aauaaaaa.aaaaaaao.aaaaaaaa(context)) {
            return replace;
        }
        aaaaaaeo.aaaaaaaa(file.getPath(), file2.getPath());
        return replace;
    }

    public static String aaaaaaaa(InputStream inputStream) {
        if (inputStream == null) {
            return "";
        }
        return aaaaaaa0(inputStream).toString();
    }
}
