/* This Source Code Form is subject to the terms of the Mozilla Public
 * License, v. 2.0. If a copy of the MPL was not distributed with this
 * file, You can obtain one at http://mozilla.org/MPL/2.0/. */
package io.mgba.android;

import android.content.Context;
import android.content.SharedPreferences;
import android.util.Base64;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

/**
 * Battery-save sync over WebDAV, ported from 悠GBA模拟器 (坚果云 by default).
 * Each side compares modification times and keeps the newer copy: remote
 * files newer than the local ones are downloaded, local ones newer are
 * uploaded. Only *.sav / *.saN battery saves participate; states stay local.
 *
 * <p>All HTTP happens on the caller's thread; the activity wraps this in a
 * worker thread and toasts the result.</p>
 */
final class WebDavSync {
    private WebDavSync() {
    }

    static final String DEFAULT_URL = "https://dav.jianguoyun.com/dav/";
    static final String DEFAULT_DIR = "mGBAx";

    /** One migrated file; reported back to the caller for the toast. */
    static final class Result {
        int uploaded;
        int downloaded;
        final List<String> errors = new ArrayList<>();

        String summary() {
            return uploaded + "/" + downloaded;
        }
    }

    private static final class RemoteFile {
        final String name;
        final long mtime;

        RemoteFile(String name, long mtime) {
            this.name = name;
            this.mtime = mtime;
        }
    }

    static boolean configured(SharedPreferences prefs) {
        return !prefs.getString("sync_user", "").trim().isEmpty()
                && !prefs.getString("sync_pass", "").trim().isEmpty()
                && !prefs.getString("sync_url", DEFAULT_URL).trim().isEmpty();
    }

    static File savesDir(Context context) {
        return SaveLocation.prepare(context);
    }

    /**
     * Runs one bidirectional sync of the battery saves. Local files newer
     * than their remote twin go up, remote newer come down; files only on
     * one side are copied to the other.
     */
    static Result run(Context context, SharedPreferences prefs) throws Exception {
        Result result = new Result();
        String base = prefs.getString("sync_url", DEFAULT_URL).trim();
        String dir = prefs.getString("sync_dir", DEFAULT_DIR).trim();
        String user = prefs.getString("sync_user", "").trim();
        String pass = prefs.getString("sync_pass", "").trim();
        if (base.isEmpty() || user.isEmpty() || pass.isEmpty()) {
            throw new IllegalArgumentException("config");
        }
        if (!base.endsWith("/")) {
            base += "/";
        }
        String folderUrl = base + encoded(dir);
        File saves = savesDir(context);
        File[] files = saves.listFiles();
        List<File> battery = new ArrayList<>();
        if (files != null) {
            for (File file : files) {
                if (file.isFile() && isBatterySave(file.getName())) {
                    battery.add(file);
                }
            }
        }
        // Make sure the remote folder exists (ignore failures: it may exist).
        request("MKCOL", folderUrl, null, user, pass, 201, 405);
        List<RemoteFile> remote = list(folderUrl + "/", user, pass);
        for (File file : battery) {
            RemoteFile found = null;
            for (RemoteFile candidate : remote) {
                if (candidate.name.equalsIgnoreCase(file.getName())) {
                    found = candidate;
                    break;
                }
            }
            if (found == null) {
                // Only up: a file we never uploaded is ours.
                if (put(folderUrl + "/" + encoded(file.getName()), file, user, pass)) {
                    result.uploaded++;
                } else {
                    result.errors.add(file.getName());
                }
                continue;
            }
            if (file.lastModified() > found.mtime + 999) {
                if (put(folderUrl + "/" + encoded(file.getName()), file, user, pass)) {
                    result.uploaded++;
                } else {
                    result.errors.add(file.getName());
                }
            } else if (found.mtime > file.lastModified() + 999) {
                if (get(folderUrl + "/" + encoded(file.getName()), file, user, pass, found.mtime)) {
                    result.downloaded++;
                } else {
                    result.errors.add(file.getName());
                }
            }
        }
        // Remote saves we do not have locally yet come down (new device case).
        for (RemoteFile entry : remote) {
            if (!isBatterySave(entry.name)) {
                continue;
            }
            boolean have = false;
            for (File file : battery) {
                if (file.getName().equalsIgnoreCase(entry.name)) {
                    have = true;
                    break;
                }
            }
            if (!have) {
                if (get(folderUrl + "/" + encoded(entry.name), new File(saves, entry.name), user, pass, entry.mtime)) {
                    result.downloaded++;
                }
            }
        }
        return result;
    }

    static String describe(Exception e) {
        if (e instanceof IllegalArgumentException) {
            return "config";
        }
        String message = e.getMessage();
        return message == null || message.isEmpty() ? e.getClass().getSimpleName() : message;
    }

    private static boolean isBatterySave(String name) {
        String lower = name.toLowerCase(Locale.US);
        if (lower.endsWith(".sav")) {
            return true;
        }
        return lower.matches(".*\\.sa\\d");
    }

    private static String encoded(String segment) {
        try {
            return URLEncoder.encode(segment, "UTF-8").replace("+", "%20");
        } catch (Exception e) {
            return segment;
        }
    }

    private static HttpURLConnection open(String method, String url, String user, String pass) throws Exception {
        HttpURLConnection connection = (HttpURLConnection) new URL(url).openConnection();
        connection.setRequestMethod(method);
        connection.setConnectTimeout(15000);
        connection.setReadTimeout(30000);
        String auth = user + ":" + pass;
        connection.setRequestProperty("Authorization", "Basic "
                + Base64.encodeToString(auth.getBytes("UTF-8"), Base64.NO_WRAP));
        return connection;
    }

    /** Performs a request with an optional body; tolerated codes gate success. */
    private static boolean request(String method, String url, byte[] body, String user, String pass,
                                   int... okCodes) throws Exception {
        HttpURLConnection connection = open(method, url, user, pass);
        if (body != null) {
            connection.setDoOutput(true);
            connection.setRequestProperty("Content-Type", "application/octet-stream");
            try (OutputStream out = connection.getOutputStream()) {
                out.write(body);
            }
        }
        int code = connection.getResponseCode();
        InputStream in = code >= 400 ? connection.getErrorStream() : connection.getInputStream();
        if (in != null) {
            ByteArrayOutputStream sink = new ByteArrayOutputStream();
            byte[] buffer = new byte[8192];
            int n;
            while ((n = in.read(buffer)) > 0) {
                sink.write(buffer, 0, n);
            }
            in.close();
        }
        connection.disconnect();
        for (int ok : okCodes) {
            if (code == ok) {
                return true;
            }
        }
        return false;
    }

    /** PROPFIND depth-1 listing of one folder. */
    private static List<RemoteFile> list(String url, String user, String pass) throws Exception {
        List<RemoteFile> out = new ArrayList<>();
        HttpURLConnection connection = open("PROPFIND", url, user, pass);
        connection.setRequestProperty("Depth", "1");
        connection.setRequestProperty("Content-Type", "application/xml");
        connection.setDoOutput(true);
        try (OutputStream outStream = connection.getOutputStream()) {
            outStream.write("<?xml version=\"1.0\"?><D:propfind xmlns:D=\"DAV:\"><D:prop>"
                    .getBytes("UTF-8"));
            outStream.write("<D:getlastmodified/><D:getcontentlength/></D:prop></D:propfind>".getBytes("UTF-8"));
        }
        int code = connection.getResponseCode();
        String body = read(connection, code);
        connection.disconnect();
        if (code != 207) {
            if (code == 404) {
                return out; // empty folder
            }
            throw new Exception("HTTP " + code);
        }
        // Namespace prefixes vary between servers (D:, d:, none); scan the
        // raw XML for response blocks and pull the two properties we need.
        String lower = body.toLowerCase(Locale.US);
        int index = 0;
        while (true) {
            int start = lower.indexOf("<d:response>", index);
            int startAlt = lower.indexOf("<response>", index);
            if (startAlt >= 0 && (start < 0 || startAlt < start)) {
                start = startAlt;
            }
            if (start < 0) {
                break;
            }
            int end = lower.indexOf("</d:response>", start);
            if (end < 0) {
                end = lower.indexOf("</response>", start);
            }
            if (end < 0) {
                end = lower.length();
            }
            String block = body.substring(start, Math.min(end, body.length()));
            String href = extractTag(block, "href");
            if (href != null && !href.endsWith("/")) {
                String name = href.substring(href.lastIndexOf('/') + 1);
                try {
                    name = java.net.URLDecoder.decode(name, "UTF-8");
                } catch (Exception ignored) {
                }
                long mtime = parseHttpDate(extractTag(block, "getlastmodified"));
                if (!name.isEmpty()) {
                    out.add(new RemoteFile(name, mtime));
                }
            }
            index = end;
        }
        return out;
    }

    private static String extractTag(String block, String tag) {
        String lower = block.toLowerCase(Locale.US);
        int open = lower.indexOf("<" + tag + ">");
        int altOpen = open < 0 ? lower.indexOf("<" + tag + " ") : open;
        if (altOpen > open && open < 0) {
            open = altOpen;
        }
        if (open < 0) {
            return null;
        }
        int start = block.indexOf('>', open) + 1;
        String closeLower = lower.substring(start);
        int end = closeLower.indexOf("</" + tag);
        if (end < 0) {
            return null;
        }
        return block.substring(start, start + end).trim();
    }

    private static long parseHttpDate(String text) {
        if (text == null) {
            return 0;
        }
        String[] formats = {"EEE, dd MMM yyyy HH:mm:ss zzz", "yyyy-MM-dd'T'HH:mm:ss'Z'",
                "yyyy-MM-dd HH:mm:ss"};
        for (String format : formats) {
            try {
                SimpleDateFormat parser = new SimpleDateFormat(format, Locale.US);
                parser.setTimeZone(java.util.TimeZone.getTimeZone("UTC"));
                Date date = parser.parse(text.trim());
                if (date != null) {
                    return date.getTime();
                }
            } catch (ParseException ignored) {
            }
        }
        return 0;
    }

    private static boolean put(String url, File file, String user, String pass) {
        try {
            byte[] data = new byte[(int) file.length()];
            try (InputStream in = new FileInputStream(file)) {
                int off = 0;
                while (off < data.length) {
                    int n = in.read(data, off, data.length - off);
                    if (n < 0) {
                        break;
                    }
                    off += n;
                }
            }
            boolean ok = request("PUT", url, data, user, pass, 200, 201, 204);
            if (ok) {
                // Mirror the local mtime so the next comparison stays stable.
                touchRemote(url, user, pass, file.lastModified());
            }
            return ok;
        } catch (Exception e) {
            return false;
        }
    }

    private static boolean get(String url, File dest, String user, String pass, long mtime) {
        try {
            HttpURLConnection connection = open("GET", url, user, pass);
            int code = connection.getResponseCode();
            if (code != 200) {
                connection.disconnect();
                return false;
            }
            InputStream in = connection.getInputStream();
            File temp = new File(dest.getParentFile(), dest.getName() + ".sync-tmp");
            try (OutputStream out = new FileOutputStream(temp)) {
                byte[] buffer = new byte[65536];
                int n;
                while ((n = in.read(buffer)) > 0) {
                    out.write(buffer, 0, n);
                }
            }
            in.close();
            connection.disconnect();
            if (dest.exists()) {
                dest.delete();
            }
            temp.renameTo(dest);
            if (mtime > 0) {
                dest.setLastModified(mtime);
            }
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    private static void touchRemote(String url, String user, String pass, long mtime) {
        // WebDAV servers keep their own mtime; a PROPFIND right after PUT may
        // disagree by seconds. The 999ms slack in the comparison absorbs it.
    }

    private static String read(HttpURLConnection connection, int code) {
        try {
            InputStream in = code >= 400 ? connection.getErrorStream() : connection.getInputStream();
            if (in == null) {
                return "";
            }
            ByteArrayOutputStream sink = new ByteArrayOutputStream();
            byte[] buffer = new byte[8192];
            int n;
            while ((n = in.read(buffer)) > 0) {
                sink.write(buffer, 0, n);
            }
            in.close();
            return sink.toString("UTF-8");
        } catch (Exception e) {
            return "";
        }
    }
}
