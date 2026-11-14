package com.bytedance.sdk.component.c.w;

import android.util.Xml;
import com.baidu.mobads.sdk.api.IAdInterListener;
import com.bytedance.sdk.component.utils.pl;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlSerializer;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public class y implements com.bytedance.sdk.component.c.hf, com.bytedance.sdk.component.c.xj {
    private final boolean hf;
    private final com.bytedance.sdk.component.u.hf.xj xj;

    public y(com.bytedance.sdk.component.u.hf.xj xjVar) {
        this.xj = xjVar;
        this.hf = false;
    }

    @Override // com.bytedance.sdk.component.c.xj
    public Map<String, Object> xj(File file) {
        FileInputStream fileInputStream;
        HashMap hashMap = new HashMap();
        if (!file.exists()) {
            return hashMap;
        }
        if (!file.canRead()) {
            pl.hf("XmlSimpleReader", "can't read file " + file);
            return hashMap;
        }
        FileInputStream fileInputStream2 = null;
        try {
            try {
                fileInputStream = new FileInputStream(file);
            } catch (IOException unused) {
            }
            try {
                XmlPullParser newPullParser = Xml.newPullParser();
                newPullParser.setInput(fileInputStream, null);
                for (int eventType = newPullParser.getEventType(); eventType != 1; eventType = newPullParser.next()) {
                    if (eventType == 2) {
                        String name = newPullParser.getName();
                        if (!"string".equals(name) && !IAdInterListener.AdProdType.PRODUCT_INTERSTITIAL.equals(name) && !"long".equals(name) && !"float".equals(name) && !"boolean".equals(name) && !"set".equals(name)) {
                        }
                        String attributeValue = newPullParser.getAttributeValue(null, "name");
                        Object xj = xj(newPullParser, name);
                        if (attributeValue != null && xj != null) {
                            hashMap.put(attributeValue, xj);
                        }
                    }
                }
                fileInputStream.close();
            } catch (Exception unused2) {
                fileInputStream2 = fileInputStream;
                if (fileInputStream2 != null) {
                    fileInputStream2.close();
                }
                return new com.bytedance.sdk.component.c.xj.hf().xj(hashMap, this.xj, this.hf);
            } catch (Throwable th) {
                th = th;
                fileInputStream2 = fileInputStream;
                if (fileInputStream2 != null) {
                    try {
                        fileInputStream2.close();
                    } catch (IOException unused3) {
                    }
                }
                throw th;
            }
        } catch (Exception unused4) {
        } catch (Throwable th2) {
            th = th2;
        }
        return new com.bytedance.sdk.component.c.xj.hf().xj(hashMap, this.xj, this.hf);
    }

    public y(com.bytedance.sdk.component.u.hf.xj xjVar, boolean z) {
        this.xj = xjVar;
        this.hf = z;
    }

    private Object xj(XmlPullParser xmlPullParser, String str) {
        str.getClass();
        switch (str) {
            case "string":
                return xmlPullParser.nextText();
            case "int":
                return Integer.valueOf(Integer.parseInt(xmlPullParser.getAttributeValue(null, "value")));
            case "set":
                return xj(xmlPullParser);
            case "long":
                return Long.valueOf(Long.parseLong(xmlPullParser.getAttributeValue(null, "value")));
            case "boolean":
                return Boolean.valueOf(Boolean.parseBoolean(xmlPullParser.getAttributeValue(null, "value")));
            case "float":
                return Float.valueOf(Float.parseFloat(xmlPullParser.getAttributeValue(null, "value")));
            default:
                return null;
        }
    }

    private Set<String> xj(XmlPullParser xmlPullParser) {
        HashSet hashSet = new HashSet();
        int eventType = xmlPullParser.getEventType();
        while (true) {
            if (eventType == 3 && "set".equals(xmlPullParser.getName())) {
                return hashSet;
            }
            if (eventType == 2 && "string".equals(xmlPullParser.getName())) {
                hashSet.add(xmlPullParser.nextText());
            }
            eventType = xmlPullParser.next();
        }
    }

    private void xj(String str, Object obj, XmlSerializer xmlSerializer) {
        if (obj instanceof String) {
            xmlSerializer.startTag(null, "string");
            xmlSerializer.attribute(null, "name", str);
            xmlSerializer.text(xj((String) obj));
            xmlSerializer.endTag(null, "string");
            return;
        }
        if (obj instanceof Integer) {
            xj(str, (Integer) obj, xmlSerializer);
            return;
        }
        if (obj instanceof Long) {
            xj(str, (Long) obj, xmlSerializer);
            return;
        }
        if (obj instanceof Float) {
            xj(str, (Float) obj, xmlSerializer);
            return;
        }
        if (obj instanceof Double) {
            xj(str, (Double) obj, xmlSerializer);
        } else if (obj instanceof Boolean) {
            xj(str, (Boolean) obj, xmlSerializer);
        } else if (obj instanceof Set) {
            xj(str, (Set<String>) obj, xmlSerializer);
        }
    }

    private void xj(String str, Integer num, XmlSerializer xmlSerializer) {
        xmlSerializer.startTag(null, IAdInterListener.AdProdType.PRODUCT_INTERSTITIAL);
        xmlSerializer.attribute(null, "name", str);
        xmlSerializer.attribute(null, "value", Integer.toString(num.intValue()));
        xmlSerializer.endTag(null, IAdInterListener.AdProdType.PRODUCT_INTERSTITIAL);
    }

    private void xj(String str, Long l, XmlSerializer xmlSerializer) {
        xmlSerializer.startTag(null, "long");
        xmlSerializer.attribute(null, "name", str);
        xmlSerializer.attribute(null, "value", Long.toString(l.longValue()));
        xmlSerializer.endTag(null, "long");
    }

    private void xj(String str, Float f, XmlSerializer xmlSerializer) {
        xmlSerializer.startTag(null, "float");
        xmlSerializer.attribute(null, "name", str);
        xmlSerializer.attribute(null, "value", Float.toString(f.floatValue()));
        xmlSerializer.endTag(null, "float");
    }

    private void xj(String str, Double d, XmlSerializer xmlSerializer) {
        xmlSerializer.startTag(null, "double");
        xmlSerializer.attribute(null, "name", str);
        xmlSerializer.attribute(null, "value", Double.toString(d.doubleValue()));
        xmlSerializer.endTag(null, "double");
    }

    private void xj(String str, Boolean bool, XmlSerializer xmlSerializer) {
        xmlSerializer.startTag(null, "boolean");
        xmlSerializer.attribute(null, "name", str);
        xmlSerializer.attribute(null, "value", Boolean.toString(bool.booleanValue()));
        xmlSerializer.endTag(null, "boolean");
    }

    private void xj(String str, Set<String> set, XmlSerializer xmlSerializer) {
        xmlSerializer.startTag(null, "set");
        xmlSerializer.attribute(null, "name", str);
        for (String str2 : set) {
            xmlSerializer.startTag(null, "string");
            xmlSerializer.text(xj(str2));
            xmlSerializer.endTag(null, "string");
        }
        xmlSerializer.endTag(null, "set");
    }

    @Override // com.bytedance.sdk.component.c.hf
    public void xj(Map<String, Object> map, File file) {
        FileOutputStream fileOutputStream;
        if (file == null) {
            return;
        }
        if (map == null) {
            map = new HashMap<>();
        }
        file.getParentFile().mkdirs();
        try {
            file.createNewFile();
        } catch (IOException unused) {
        }
        Map<String, Object> hf = new com.bytedance.sdk.component.c.xj.hf().hf(map, this.xj, this.hf);
        FileOutputStream fileOutputStream2 = null;
        try {
            try {
                try {
                    fileOutputStream = new FileOutputStream(file);
                } catch (Exception unused2) {
                    return;
                }
            } catch (Exception e) {
                e = e;
            }
        } catch (Throwable th) {
            th = th;
        }
        try {
            XmlSerializer newSerializer = Xml.newSerializer();
            newSerializer.setOutput(fileOutputStream, "utf-8");
            newSerializer.startDocument(null, Boolean.TRUE);
            newSerializer.setFeature("http://xmlpull.org/v1/doc/features.html#indent-output", true);
            newSerializer.startTag(null, "map");
            for (String str : hf.keySet()) {
                if (str != null) {
                    xj(str, hf.get(str), newSerializer);
                }
            }
            newSerializer.endTag(null, "map");
            newSerializer.endDocument();
            fileOutputStream.close();
        } catch (Exception e2) {
            e = e2;
            fileOutputStream2 = fileOutputStream;
            pl.hf("XmlSimpleReader", "write file exception ", e);
            if (fileOutputStream2 != null) {
                fileOutputStream2.close();
            }
        } catch (Throwable th2) {
            th = th2;
            fileOutputStream2 = fileOutputStream;
            if (fileOutputStream2 != null) {
                try {
                    fileOutputStream2.close();
                } catch (Exception unused3) {
                }
            }
            throw th;
        }
    }

    private String xj(String str) {
        int i;
        StringBuilder sb = null;
        if (str == null) {
            return null;
        }
        int length = str.length();
        int i2 = 0;
        while (i2 < length) {
            char charAt = str.charAt(i2);
            if ((charAt < ' ' || charAt > 55295) && !((charAt >= 57344 && charAt <= 65533) || charAt == '\t' || charAt == '\n' || charAt == '\r')) {
                if (sb == null) {
                    sb = new StringBuilder();
                    if (i2 > 0) {
                        sb.append(str.substring(0, i2));
                    }
                }
                if (charAt == '\"') {
                    sb.append("&quot;");
                } else if (charAt == '<') {
                    sb.append("&lt;");
                } else if (charAt == '>') {
                    sb.append("&gt;");
                } else if (charAt == '&') {
                    sb.append("&amp;");
                } else if (charAt != '\'') {
                    if (Character.isHighSurrogate(charAt) && (i = i2 + 1) < length) {
                        char charAt2 = str.charAt(i);
                        if (Character.isLowSurrogate(charAt2)) {
                            sb.append(charAt);
                            sb.append(charAt2);
                            i2 = i;
                        }
                    } else {
                        sb.append("&#");
                        sb.append((int) charAt);
                        sb.append(";");
                    }
                } else {
                    sb.append("&apos;");
                }
            } else if (sb != null) {
                sb.append(charAt);
            }
            i2++;
        }
        return sb != null ? sb.toString() : str;
    }
}
