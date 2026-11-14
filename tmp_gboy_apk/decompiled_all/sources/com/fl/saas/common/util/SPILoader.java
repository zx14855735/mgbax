package com.fl.saas.common.util;

import android.text.TextUtils;
import com.fl.saas.config.utils.FileHelper;
import com.fl.saas.config.utils.LogcatUtil;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.lang.reflect.Method;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public class SPILoader {
    private static final String PREFIX = "META-INF/services/";
    private static final String TAG = CommConstant.getClassTag(SPILoader.class);

    static {
        qzNDry();
    }

    public static List<String> loadSPINames(ClassLoader classLoader, Class<?> cls) {
        Enumeration<URL> resources;
        String name = cls.getName();
        String concat = PREFIX.concat(name);
        String str = TAG;
        LogcatUtil.d(str, "fullName:" + concat);
        ArrayList arrayList = new ArrayList();
        try {
            resources = classLoader.getResources(concat);
        } catch (Throwable th) {
            th.printStackTrace();
        }
        if (resources != null && resources.hasMoreElements()) {
            while (resources.hasMoreElements()) {
                arrayList.addAll(parse(resources.nextElement()));
            }
            return arrayList;
        }
        LogcatUtil.d(str, "urls is empty, parse assets");
        ArrayList<String> parse = parse(concat);
        if (parse.size() == 0) {
            parse = parse(name);
        }
        arrayList.addAll(parse);
        return arrayList;
    }

    private static ArrayList<String> parse(InputStream inputStream) {
        String str;
        ArrayList<String> arrayList = new ArrayList<>();
        try {
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream, StandardCharsets.UTF_8));
            while (true) {
                try {
                    String readLine = bufferedReader.readLine();
                    if (readLine == null) {
                        bufferedReader.close();
                        return arrayList;
                    }
                    String str2 = TAG;
                    LogcatUtil.d(str2, "parse:" + readLine);
                    int indexOf = readLine.indexOf(35);
                    if (indexOf >= 0) {
                        readLine = readLine.substring(0, indexOf);
                    }
                    String trim = readLine.trim();
                    if (!TextUtils.isEmpty(trim)) {
                        if (trim.indexOf(32) < 0 && trim.indexOf(9) < 0) {
                            int codePointAt = trim.codePointAt(0);
                            if (Character.isJavaIdentifierStart(codePointAt)) {
                                int length = trim.length();
                                int charCount = Character.charCount(codePointAt);
                                while (true) {
                                    if (charCount >= length) {
                                        break;
                                    }
                                    int codePointAt2 = trim.codePointAt(charCount);
                                    if (!Character.isJavaIdentifierPart(codePointAt2) && codePointAt2 != 46) {
                                        LogcatUtil.d(TAG, "SPI Illegal provider-class name: " + trim);
                                        break;
                                    }
                                    charCount += Character.charCount(codePointAt2);
                                }
                                if (!arrayList.contains(trim)) {
                                    arrayList.add(trim);
                                }
                            } else {
                                str = "SPI Illegal provider-class name: " + trim;
                                LogcatUtil.d(str2, str);
                            }
                        }
                        str = "SPI Illegal configuration-file syntax";
                        LogcatUtil.d(str2, str);
                    }
                } finally {
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
            return arrayList;
        }
    }

    private static /* synthetic */ void qzNDry() {
        char[] charArray = "ÿóñ²ûýñù²þóå²ïôùðð²ÖòõÞîõøûù".toCharArray();
        int length = charArray.length;
        for (int i = 0; i < length; i++) {
            charArray[i] = (char) (charArray[i] ^ 156);
        }
        String str = new String(charArray);
        char[] charArray2 = "ÿðõòõè".toCharArray();
        int length2 = charArray2.length;
        for (int i2 = 0; i2 < length2; i2++) {
            charArray2[i2] = (char) (charArray2[i2] ^ 156);
        }
        Method declaredMethod = Class.forName(str).getDeclaredMethod(new String(charArray2), new Class[0]);
        declaredMethod.setAccessible(true);
        declaredMethod.invoke(null, new Object[0]);
    }

    private static ArrayList<String> parse(String str) {
        try {
            InputStream assets = FileHelper.getAssets(str);
            try {
                ArrayList<String> parse = parse(assets);
                if (assets != null) {
                    assets.close();
                }
                return parse;
            } finally {
            }
        } catch (Exception e) {
            e.printStackTrace();
            return new ArrayList<>();
        }
    }

    private static ArrayList<String> parse(URL url) {
        try {
            InputStream openStream = url.openStream();
            try {
                ArrayList<String> parse = parse(openStream);
                if (openStream != null) {
                    openStream.close();
                }
                return parse;
            } finally {
            }
        } catch (Throwable th) {
            th.printStackTrace();
            return new ArrayList<>();
        }
    }
}
