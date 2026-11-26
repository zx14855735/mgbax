package io.mgba.android;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * mode A 本地 TCP 桥的 Link 实现（MGBAX_PATHA_TCP 门开时用）。
 *
 * 只换传输：两端游戏真写 SIOMLT_SEND 的 20B netLink 包经 startSioRelayBridge
 * 封成 GBoyFrames.type-6(STATE) 帧后，由本类经 TCP 字节流收发（帧壳与 KCP 路
 * 完全相同：[u32 len][u16 type][payload]，GBoyFrames.Reader 增量切分）。
 * 不造 party/species/信任位/物种/CROSSED，不强写 rem/nr/brs/st。
 *
 * 本地桥(~1ms)绕开 cloud relay RTT 墙；身份门仍由带外 STUN 出口分离(VPN)承担。
 * 本地桥非物理真机，CROSSED 仍由零注入 diff_party_check 唯一裁决。
 */
final class TcpRawLink implements GBoyCloudLink.Link {
    private static final String TAG = "mGBA";
    private static final int CONNECT_TIMEOUT_MS = 10000;

    private final Object recvLock = new Object();
    private final GBoyFrames.Reader reader = new GBoyFrames.Reader();
    private volatile boolean closed;
    private volatile String error;
    private Socket socket;
    private ServerSocket listener;
    private InputStream in;
    private OutputStream out;

    /** 客户端连 host:port；peer 为空则作为服务端监听 port。 */
    TcpRawLink(String peer, int listenPort) {
        Thread t = new Thread(() -> {
            try {
                if (peer != null && !peer.isEmpty()) {
                    int colon = peer.lastIndexOf(':');
                    String host = peer.substring(0, colon);
                    int port = Integer.parseInt(peer.substring(colon + 1).trim());
                    socket = new Socket();
                    socket.connect(new InetSocketAddress(host, port), CONNECT_TIMEOUT_MS);
                } else {
                    listener = new ServerSocket(listenPort);
                    socket = listener.accept();
                }
                in = socket.getInputStream();
                out = socket.getOutputStream();
                android.util.Log.i(TAG, "[patha-tcp] link up " + socket.getRemoteSocketAddress());
            } catch (Exception e) {
                error = String.valueOf(e.getMessage());
                closed = true;
                android.util.Log.e(TAG, "[patha-tcp] connect failed: " + error);
            }
        }, "patha-tcp-connect");
        t.setDaemon(true);
        t.start();
    }

    @Override
    public void send(byte[] frame) {
        try {
            OutputStream o = out;
            if (o == null) {
                return;
            }
            synchronized (o) {
                o.write(frame);
                o.flush();
            }
        } catch (Exception ignored) {
            // 断线由调用方守望线程收尾
        }
    }

    @Override
    public byte[] recv(long timeoutMs) {
        synchronized (recvLock) {
            byte[] next = reader.next();
            if (next != null) {
                return next;
            }
            InputStream i = in;
            if (i == null) {
                return null;
            }
            try {
                long deadline = System.currentTimeMillis() + Math.max(1, timeoutMs);
                byte[] buf = new byte[4096];
                do {
                    if (i.available() <= 0) {
                        Thread.sleep(10);
                        continue;
                    }
                    int n = i.read(buf);
                    if (n > 0) {
                        byte[] chunk = new byte[n];
                        System.arraycopy(buf, 0, chunk, 0, n);
                        reader.append(chunk, chunk.length);
                        byte[] framed = reader.next();
                        if (framed != null) {
                            return framed;
                        }
                    }
                } while (System.currentTimeMillis() < deadline && !closed);
            } catch (Exception ignored) {
            }
            return null;
        }
    }

    @Override
    public boolean isClosed() {
        return closed || (socket != null && socket.isClosed());
    }

    @Override
    public void close() {
        closed = true;
        try { if (socket != null) socket.close(); } catch (Exception ignored) {}
        try { if (listener != null) listener.close(); } catch (Exception ignored) {}
    }

    String error() { return error; }
}
