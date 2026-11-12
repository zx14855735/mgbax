/* This Source Code Form is subject to the terms of the Mozilla Public
 * License, v. 2.0. If a copy of the MPL was not distributed with this
 * file, You can obtain one at http://mozilla.org/MPL/2.0/. */
package io.mgba.android;

import android.util.Log;

import org.json.JSONObject;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.Socket;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.Random;

import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;

/**
 * gboy.top room signalling: HTTPS authentication plus the WebSocket room
 * commands. Only the matching half lives here - the actual link bytes travel
 * over KCP in {@link KcpChannel}.
 *
 * Kept dependency free on purpose: the project builds with --offline, so no
 * new Gradle module can be pulled in. The WebSocket client is a minimal
 * RFC 6455 implementation over SSLSocket.
 */
final class GbCloud {
    private static final String TAG = "GBoyCloud";
    /**
     * Endpoints of the live service. Overridable at runtime so a local mock
     * lobby server can stand in during tests (see EmulatorActivity's CLOUD
     * action "ws"/"api" extras); the defaults are the real gboy.top.
     */
    private static volatile String api = "https://gboy.top/api/api.php";
    private static volatile String wsHost = "gboy.top";
    private static volatile int wsPort = 23459;

    static String api() {
        return api;
    }

    static String wsHost() {
        return wsHost;
    }

    static int wsPort() {
        return wsPort;
    }

    /** Redirects signalling for tests; pass null to keep a value. */
    static void overrideEndpoints(String apiBase, String host, Integer port) {
        if (apiBase != null && !apiBase.isEmpty()) {
            api = apiBase;
        }
        if (host != null && !host.isEmpty()) {
            wsHost = host;
        }
        if (port != null && port > 0) {
            wsPort = port;
        }
    }

    /**
     * Trust any certificate. gboy.top serves a certificate issued for
     * gameboyfrp.top (and the chain it sends is sometimes incomplete), so a
     * strictly-validating client can never finish the handshake. The official
     * client tolerates this; we mirror that by falling back to this manager for
     * both the HTTPS signalling and the WebSocket room link.
     */
    private static final javax.net.ssl.X509TrustManager TRUST_ANY =
            new javax.net.ssl.X509TrustManager() {
                @Override
                public void checkClientTrusted(java.security.cert.X509Certificate[] chain,
                                               String authType) {
                }

                @Override
                public void checkServerTrusted(java.security.cert.X509Certificate[] chain,
                                               String authType) {
                }

                @Override
                public java.security.cert.X509Certificate[] getAcceptedIssuers() {
                    return new java.security.cert.X509Certificate[0];
                }
            };

    private GbCloud() {
    }

    /** Relay node assigned to a room. */
    static final class Node {
        final String address;
        final int port;
        /** Room the node belongs to; only the host's reply carries it. */
        final String roomId;

        Node(String address, int port) {
            this(address, port, null);
        }

        Node(String address, int port, String roomId) {
            this.address = address;
            this.port = port;
            this.roomId = roomId;
        }

        @Override
        public String toString() {
            return address + ":" + port;
        }
    }

    /**
     * Rewrites the upstream brand name the lobby server bakes into its own
     * replies into the neutral in-app name, so no third-party brand ever shows
     * up on screen. Everything the server says to the user goes through here.
     */
    static String lobby(String text) {
        if (text == null || text.isEmpty()) {
            return text;
        }
        return text.replaceAll("(?i)gboy(?:\\.top)?", "联机大厅");
    }

    /** Signs in and returns the token every room command has to carry. */
    static String login(String user, String password) throws IOException {
        JSONObject body = new JSONObject();
        try {
            body.put("action", "login");
            body.put("email_or_username", user);
            body.put("password", password);
        } catch (Exception e) {
            throw new IOException("参数错误");
        }
        String raw = post(body.toString());
        JSONObject reply = lastJsonObject(raw);
        String token = reply.optString("token", null);
        if (token == null || token.isEmpty()) {
            String message = reply.optString("message", null);
            throw new IOException(lobby(message == null || message.isEmpty() ? "登录失败" : message));
        }
        return token;
    }

    /**
     * Asks gboy.top to mail a verification code to the address (the same
     * {@code send_verification_code} action the official client sends from its
     * register dialog). The server rate-limits one mail per address per five
     * minutes and says so in the message; the caller surfaces that text.
     */
    static String sendVerificationCode(String email) throws IOException {
        JSONObject body = new JSONObject();
        try {
            body.put("action", "send_verification_code");
            body.put("email", email);
        } catch (Exception e) {
            throw new IOException("参数错误");
        }
        JSONObject reply = lastJsonObject(post(body.toString()));
        if (!reply.optBoolean("success", false)) {
            String message = reply.optString("message", null);
            throw new IOException(lobby(message == null || message.isEmpty() ? "验证码发送失败" : message));
        }
        return lobby(reply.optString("message", "验证码已发送。"));
    }

    /**
     * Registers a new account from an emailed code and returns the token the
     * reply carries straight away (register doubles as the first login).
     */
    static String register(String username, String email, String password, String code) throws IOException {
        JSONObject body = new JSONObject();
        try {
            body.put("action", "register");
            body.put("username", username);
            body.put("email", email);
            body.put("password", password);
            body.put("verification_code", code);
        } catch (Exception e) {
            throw new IOException("参数错误");
        }
        JSONObject reply = lastJsonObject(post(body.toString()));
        String token = reply.optString("token", null);
        if (token == null || token.isEmpty()) {
            String message = reply.optString("message", null);
            throw new IOException(lobby(message == null || message.isEmpty() ? "注册失败" : message));
        }
        return token;
    }

    /**
     * POSTs to the API. Tries a strictly-validating TLS connection first and,
     * if that fails (gboy.top still presents a certificate issued for
     * gameboyfrp.top, so the handshake can never validate), falls back to a
     * connection that trusts any certificate - the same degradation the
     * WebSocket {@link Session} already applies.
     */
    private static String post(String body) throws IOException {
        IOException last = null;
        for (boolean strict : new boolean[]{true, false}) {
            HttpURLConnection conn = null;
            try {
                conn = openConnection(strict);
                conn.setRequestMethod("POST");
                conn.setDoInput(true);
                conn.setDoOutput(true);
                conn.setConnectTimeout(15000);
                conn.setReadTimeout(15000);
                conn.setRequestProperty("Content-Type", "application/json");
                OutputStream os = conn.getOutputStream();
                try {
                    os.write(body.getBytes(StandardCharsets.UTF_8));
                } finally {
                    os.close();
                }
                int code = conn.getResponseCode();
                if (code < 200 || code >= 300) {
                    throw new IOException("服务器返回 " + code);
                }
                return readAll(conn.getInputStream());
            } catch (IOException e) {
                last = e;
                if (strict) {
                    Log.w(TAG, "HTTPS 严格校验失败，回退到信任任意证书: " + e.getMessage());
                    continue;
                }
                throw e;
            } finally {
                if (conn != null) {
                    conn.disconnect();
                }
            }
        }
        throw last;
    }

    private static HttpURLConnection openConnection(boolean strict) throws IOException {
        HttpURLConnection conn = (HttpURLConnection) new URL(api()).openConnection();
        if (!strict && conn instanceof javax.net.ssl.HttpsURLConnection) {
            try {
                javax.net.ssl.SSLContext context = javax.net.ssl.SSLContext.getInstance("TLS");
                context.init(null, new javax.net.ssl.TrustManager[]{TRUST_ANY},
                        new java.security.SecureRandom());
                javax.net.ssl.HttpsURLConnection https = (javax.net.ssl.HttpsURLConnection) conn;
                https.setSSLSocketFactory(context.getSocketFactory());
                // TRUST_ANY covers the chain, but hostname verification is a
                // separate check (a mock server presenting CN=localhost for
                // 10.0.2.2 fails it); the official client verifies nothing.
                https.setHostnameVerifier((hostname, session) -> true);
            } catch (Exception e) {
                throw new IOException("无法建立加密连接");
            }
        }
        return conn;
    }

    /** api.php sometimes echoes notices before the JSON line. */
    static JSONObject lastJsonObject(String raw) throws IOException {
        String[] lines = raw == null ? new String[0] : raw.split("\n");
        for (int i = lines.length - 1; i >= 0; i--) {
            String line = lines[i].trim();
            if (line.startsWith("{")) {
                try {
                    return new JSONObject(line);
                } catch (Exception ignored) {
                }
            }
        }
        throw new IOException("服务器返回无法解析：" + (raw == null ? "" : raw.trim()));
    }

    /**
     * Same as {@link #lastJsonObject(String)} but returns null when the text
     * holds no JSON at all - the websocket pushes are inspected speculatively,
     * where a throw per non-JSON frame would be noise.
     */
    static JSONObject lastJsonObjectOrNull(String raw) {
        String[] lines = raw == null ? new String[0] : raw.split("\n");
        for (int i = lines.length - 1; i >= 0; i--) {
            String line = lines[i].trim();
            if (line.startsWith("{")) {
                try {
                    return new JSONObject(line);
                } catch (Exception ignored) {
                }
            }
        }
        return null;
    }

    private static String readAll(InputStream in) throws IOException {
        ByteArrayOutputStream buffer = new ByteArrayOutputStream();
        byte[] chunk = new byte[8192];
        int n;
        while ((n = in.read(chunk)) > 0) {
            buffer.write(chunk, 0, n);
        }
        return new String(buffer.toByteArray(), StandardCharsets.UTF_8);
    }

    /** Minimal WebSocket client over TLS for the room commands. */
    static final class Session {
        private final Socket socket;
        private final InputStream in;
        private final OutputStream out;
        private final byte[] buffer = new byte[65536];
        private int bufferLen;
        private int bufferPos;
        /** False when the server certificate had to be accepted unverified. */
        private final boolean strictTls;

        /** Accepts any certificate; aliases the shared {@link GbCloud#TRUST_ANY}. */
        private static final javax.net.ssl.X509TrustManager TRUST_ANY = GbCloud.TRUST_ANY;

        private static SSLSocket openTls(boolean strict) throws IOException {
            SSLSocketFactory factory;
            if (strict) {
                factory = (SSLSocketFactory) SSLSocketFactory.getDefault();
            } else {
                try {
                    javax.net.ssl.SSLContext context = javax.net.ssl.SSLContext.getInstance("TLS");
                    context.init(null, new javax.net.ssl.TrustManager[]{TRUST_ANY},
                            new java.security.SecureRandom());
                    factory = context.getSocketFactory();
                } catch (Exception e) {
                    throw new IOException("无法建立加密连接");
                }
            }
            SSLSocket ssl = (SSLSocket) factory.createSocket(wsHost(), wsPort());
            ssl.startHandshake();
            return ssl;
        }

        Session() throws IOException {
            SSLSocket ssl;
            boolean strict;
            try {
                ssl = openTls(true);
                strict = true;
            } catch (IOException e) {
                // gboy.top:23459 still presents an expired certificate issued
                // for gameboyfrp.top, so a validating client can never finish
                // the handshake. Fall back the way the official client does,
                // and let the callers warn about it.
                ssl = openTls(false);
                strict = false;
            }
            this.strictTls = strict;
            ssl.setSoTimeout(2000);
            this.socket = ssl;
            this.in = ssl.getInputStream();
            this.out = ssl.getOutputStream();
            byte[] key = new byte[16];
            new Random().nextBytes(key);
            String handshake = "GET / HTTP/1.1\r\n"
                    + "Host: " + wsHost() + ":" + wsPort() + "\r\n"
                    + "Upgrade: websocket\r\n"
                    + "Connection: Upgrade\r\n"
                    + "Sec-WebSocket-Key: " + android.util.Base64.encodeToString(key,
                    android.util.Base64.NO_WRAP) + "\r\n"
                    + "Sec-WebSocket-Version: 13\r\n\r\n";
            out.write(handshake.getBytes(StandardCharsets.US_ASCII));
            out.flush();
            StringBuilder head = new StringBuilder();
            while (!head.toString().endsWith("\r\n\r\n")) {
                int b = in.read();
                if (b < 0) {
                    throw new IOException("服务器关闭了连接");
                }
                head.append((char) b);
            }
            if (!head.toString().contains("101")) {
                throw new IOException("WebSocket 握手失败");
            }
        }

        boolean insecureTls() {
            return !strictTls;
        }

        /** True once the underlying socket is gone (closed locally or by the server). */
        boolean isClosed() {
            return socket.isClosed();
        }

        void send(String text) throws IOException {
            byte[] payload = text.getBytes(StandardCharsets.UTF_8);
            byte[] mask = new byte[4];
            new Random().nextBytes(mask);
            int len = payload.length;
            ByteArrayOutputStream frame = new ByteArrayOutputStream(len + 16);
            frame.write(0x81);
            if (len < 126) {
                frame.write(0x80 | len);
            } else if (len < 65536) {
                frame.write(0x80 | 126);
                frame.write((len >> 8) & 0xFF);
                frame.write(len & 0xFF);
            } else {
                frame.write(0x80 | 127);
                for (int i = 7; i >= 0; i--) {
                    frame.write((int) (((long) len) >> (8 * i)) & 0xFF);
                }
            }
            frame.write(mask);
            for (int i = 0; i < len; i++) {
                frame.write(payload[i] ^ mask[i % 4]);
            }
            synchronized (out) {
                out.write(frame.toByteArray());
                out.flush();
            }
        }

        /** Next text frame, or null when nothing arrives in time. */
        String recv(long timeoutMs) throws IOException {
            long deadline = System.currentTimeMillis() + Math.max(timeoutMs, 1);
            while (true) {
                int op = readFrame(deadline);
                if (op < 0) {
                    return null;
                }
                if (op == 0x1) {
                    return new String(buffer, bufferPos, bufferLen - bufferPos, StandardCharsets.UTF_8);
                }
                if (op == 0x8) {
                    throw new IOException("服务器关闭了房间连接");
                }
                if (op == 0x9) {
                    // ping: answer with a pong so the room stays alive
                    byte[] body = Arrays.copyOfRange(buffer, bufferPos, bufferLen);
                    synchronized (out) {
                        out.write(0x8A);
                        out.write(body.length);
                        out.write(body);
                        out.flush();
                    }
                }
            }
        }

        private int readFrame(long deadline) throws IOException {
            long remaining = deadline - System.currentTimeMillis();
            if (remaining <= 0) {
                return -1;
            }
            socket.setSoTimeout((int) Math.min(remaining, 2000));
            int first;
            try {
                first = in.read();
            } catch (java.net.SocketTimeoutException e) {
                return -1;
            }
            if (first < 0) {
                throw new IOException("服务器关闭了连接");
            }
            int second = in.read();
            if (second < 0) {
                throw new IOException("服务器关闭了连接");
            }
            boolean masked = (second & 0x80) != 0;
            long len = second & 0x7F;
            if (len == 126) {
                len = (long) readByte() << 8 | readByte();
            } else if (len == 127) {
                len = 0;
                for (int i = 0; i < 8; i++) {
                    len = (len << 8) | readByte();
                }
            }
            byte[] mask = null;
            if (masked) {
                mask = new byte[]{(byte) readByte(), (byte) readByte(), (byte) readByte(), (byte) readByte()};
            }
            if (len < 0 || len > buffer.length) {
                throw new IOException("数据异常");
            }
            readFully(buffer, 0, (int) len);
            if (mask != null) {
                for (int i = 0; i < len; i++) {
                    buffer[i] = (byte) (buffer[i] ^ mask[i % 4]);
                }
            }
            bufferPos = 0;
            bufferLen = (int) len;
            return first & 0x0F;
        }

        private int readByte() throws IOException {
            int b = in.read();
            if (b < 0) {
                throw new IOException("服务器关闭了连接");
            }
            return b & 0xFF;
        }

        private void readFully(byte[] dst, int off, int len) throws IOException {
            int got = 0;
            while (got < len) {
                int n = in.read(dst, off + got, len - got);
                if (n < 0) {
                    throw new IOException("服务器关闭了连接");
                }
                got += n;
            }
        }

        void close() {
            try {
                socket.close();
            } catch (IOException ignored) {
            }
        }
    }

    static void trace(String text) {
        Log.i(TAG, text);
    }
}
