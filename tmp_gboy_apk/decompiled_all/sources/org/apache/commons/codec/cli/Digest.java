package org.apache.commons.codec.cli;

import ADYaiT.CtFAbx;
import java.io.File;
import java.io.PrintStream;
import java.nio.charset.Charset;
import java.security.MessageDigest;
import java.util.Arrays;
import java.util.Locale;
import org.apache.commons.codec.binary.Hex;
import org.apache.commons.codec.digest.DigestUtils;
import org.apache.commons.codec.digest.MessageDigestAlgorithms;
import org.apache.commons.codec.language.bm.Rule;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
public class Digest {
    private final String algorithm;
    private final String[] args;
    private final String[] inputs;

    private Digest(String[] strArr) {
        if (strArr == null) {
            throw new IllegalArgumentException("args");
        }
        if (strArr.length == 0) {
            throw new IllegalArgumentException(CtFAbx.BI9f7h("Usage: java ", Digest.class.getName(), " [algorithm] [FILE|DIRECTORY|string] ..."));
        }
        this.args = strArr;
        this.algorithm = strArr[0];
        if (strArr.length <= 1) {
            this.inputs = null;
            return;
        }
        String[] strArr2 = new String[strArr.length - 1];
        this.inputs = strArr2;
        System.arraycopy(strArr, 1, strArr2, 0, strArr2.length);
    }

    public static void main(String[] strArr) {
        new Digest(strArr).run();
    }

    private void println(String str, byte[] bArr) {
        println(str, bArr, null);
    }

    private void run() {
        if (this.algorithm.equalsIgnoreCase(Rule.ALL) || this.algorithm.equals("*")) {
            run(MessageDigestAlgorithms.values());
            return;
        }
        MessageDigest digest = DigestUtils.getDigest(this.algorithm, null);
        if (digest != null) {
            run("", digest);
        } else {
            run("", DigestUtils.getDigest(this.algorithm.toUpperCase(Locale.ROOT)));
        }
    }

    public String toString() {
        return CtFAbx.AlLFFp(super.toString(), " ", Arrays.toString(this.args));
    }

    private void println(String str, byte[] bArr, String str2) {
        PrintStream printStream = System.out;
        Hex.encodeHexString(bArr);
        if (str2 != null) {
            "  ".concat(str2);
        }
        printStream.getClass();
    }

    private void run(String[] strArr) {
        for (String str : strArr) {
            if (DigestUtils.isAvailable(str)) {
                run(CtFAbx.AcNBzu(str, " "), str);
            }
        }
    }

    private void run(String str, MessageDigest messageDigest) {
        String[] strArr = this.inputs;
        if (strArr == null) {
            println(str, DigestUtils.digest(messageDigest, System.in));
            return;
        }
        for (String str2 : strArr) {
            File file = new File(str2);
            if (file.isFile()) {
                println(str, DigestUtils.digest(messageDigest, file), str2);
            } else if (file.isDirectory()) {
                File[] listFiles = file.listFiles();
                if (listFiles != null) {
                    run(str, messageDigest, listFiles);
                }
            } else {
                println(str, DigestUtils.digest(messageDigest, str2.getBytes(Charset.defaultCharset())));
            }
        }
    }

    private void run(String str, MessageDigest messageDigest, File[] fileArr) {
        for (File file : fileArr) {
            if (file.isFile()) {
                println(str, DigestUtils.digest(messageDigest, file), file.getName());
            }
        }
    }

    private void run(String str, String str2) {
        run(str, DigestUtils.getDigest(str2));
    }
}
