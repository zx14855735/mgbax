/* This Source Code Form is subject to the terms of the Mozilla Public
 * License, v. 2.0. If a copy of the MPL was not distributed with this
 * file, You can obtain one at http://mozilla.org/MPL/2.0/. */
package io.mgba.android;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicLong;

/**
 * The official local TCP link, ported from {@code LKpHwm4/B25kr6}.
 *
 * <p>The official client wraps a {@code java.net.Socket} in an
 * {@code InputStream}/{@code OutputStream} pair, registers the endpoints in
 * {@code CopyOnWriteArrayList}s and exchanges length-prefixed frames. A host
 * and a guest greet each other with a {@code type 1} frame carrying {@code int 6}
 * ({@code ARc23Z((short) 1, 4)} plus {@code putInt(6)}); after that the reader
 * loop pulls a frame off the peer queue and dispatches it by message type.</p>
 *
 * <p>Frames are exactly {@link GBoyFrames}: {@code u32 length + u16 type +
 * payload}, split incrementally by {@link GBoyFrames.Reader}. Incoming bodies go
 * to {@link GBoyLinkSession#onFrameBody(byte[])}, which handles slot dispatch,
 * state/reset/counter/fps and the 12 Hz key cadence. Outgoing frames are queued
 * so the emulation thread never blocks on a socket write; when the queue is
 * full the oldest frame is dropped, matching the official back-pressure.</p>
 *
 * <p>Runs on plain JDK sockets with no Android dependency, so the whole
 * handshake and key exchange can be exercised on loopback in a JVM test.</p>
 */
public final class GBoySocketLink implements GBoyLinkSession.Transport {

    /** Frames queued before back-pressure starts dropping the oldest. */
    public static final int OUTBOX_CAPACITY = 256;
    private static final int CONNECT_TIMEOUT_MS = 3000;
    private static final int READ_BUFFER = 2048;

    private final GBoyLinkSession session;
    private final GBoyFrames.Reader reader = new GBoyFrames.Reader();
    private final BlockingQueue<byte[]> outbox = new ArrayBlockingQueue<>(OUTBOX_CAPACITY);
    private final AtomicBoolean running = new AtomicBoolean();
    private final AtomicBoolean handshakeDone = new AtomicBoolean();
    private final AtomicLong received = new AtomicLong();

    private volatile Socket socket;
    private volatile ServerSocket server;
    private volatile Thread acceptThread;
    private volatile Thread readThread;
    private volatile Thread writeThread;
    private volatile String lastError = "";

    public GBoySocketLink(int localSlot, int playerCount, GBoyLinkSession.Events events) {
        session = new GBoyLinkSession(this, events, localSlot, playerCount);
    }

    public GBoyLinkSession session() {
        return session;
    }

    /**
     * Listens on {@code port} and accepts one peer. Pass 0 to let the OS pick a
     * free port; {@link #port()} reports the actual one. Non-blocking.
     */
    public int startHost(int port) throws IOException {
        ServerSocket listener = new ServerSocket(port);
        server = listener;
        running.set(true);
        Thread accept = new Thread(() -> {
            try {
                Socket peer = listener.accept();
                peer.setTcpNoDelay(true);
                if (running.get()) {
                    open(peer);
                } else {
                    peer.close();
                }
            } catch (IOException e) {
                if (running.get()) {
                    lastError = String.valueOf(e.getMessage());
                }
            }
        }, "gboy-socket-accept");
        accept.setDaemon(true);
        acceptThread = accept;
        accept.start();
        return listener.getLocalPort();
    }

    /**
     * Connects to the peer and sends the official registration frame.
     * Android forbids socket I/O on the main thread and broadcast receivers run
     * there, so the connect happens on a worker; this method still waits for the
     * outcome and keeps its synchronous contract for callers and tests.
     */
    public void startJoin(String host, int port) throws IOException {
        running.set(true);
        final Socket[] connected = new Socket[1];
        final IOException[] failure = new IOException[1];
        Thread connector = new Thread(() -> {
            Socket peer = new Socket();
            try {
                peer.connect(new InetSocketAddress(host, port), CONNECT_TIMEOUT_MS);
                peer.setTcpNoDelay(true);
                connected[0] = peer;
            } catch (IOException e) {
                failure[0] = e;
                try {
                    peer.close();
                } catch (IOException ignored) {
                }
            }
        }, "gboy-socket-connect");
        connector.setDaemon(true);
        connector.start();
        try {
            connector.join(CONNECT_TIMEOUT_MS + 1000L);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            running.set(false);
            throw new IOException("interrupted while connecting", e);
        }
        Socket peer = connected[0];
        if (peer == null) {
            running.set(false);
            throw failure[0] != null ? failure[0] : new IOException("connect timed out");
        }
        open(peer);
        session.sendSocketHandshake();
    }

    private void open(Socket peer) {
        socket = peer;
        Thread read = new Thread(() -> pumpInput(peer), "gboy-socket-read");
        Thread write = new Thread(() -> pumpOutput(peer), "gboy-socket-write");
        read.setDaemon(true);
        write.setDaemon(true);
        readThread = read;
        writeThread = write;
        read.start();
        write.start();
    }

    private void pumpInput(Socket peer) {
        byte[] buffer = new byte[READ_BUFFER];
        try {
            InputStream in = peer.getInputStream();
            int n;
            while (running.get() && (n = in.read(buffer)) > 0) {
                reader.append(buffer, n);
                byte[] body;
                while ((body = reader.next()) != null) {
                    received.incrementAndGet();
                    session.onFrameBody(body);
                    if (GBoyFrames.typeOf(body) == GBoyFrames.TYPE_REGISTER) {
                        boolean wasHost = server != null;
                        boolean first = handshakeDone.compareAndSet(false, true);
                        // Only the listening side answers; the joining side
                        // started the exchange. Both then consider it ready.
                        if (wasHost && first) {
                            session.sendSocketHandshake();
                        }
                    }
                }
            }
        } catch (IOException e) {
            if (running.get()) {
                lastError = String.valueOf(e.getMessage());
            }
        }
    }

    private void pumpOutput(Socket peer) {
        try {
            OutputStream out = peer.getOutputStream();
            while (running.get()) {
                byte[] frame = outbox.poll(200, TimeUnit.MILLISECONDS);
                if (frame != null) {
                    out.write(frame);
                    out.flush();
                }
            }
        } catch (IOException e) {
            if (running.get()) {
                lastError = String.valueOf(e.getMessage());
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }

    /** Queues one complete wire frame. Never blocks the emulation thread. */
    @Override
    public void send(byte[] frame) {
        if (!running.get() || frame == null) {
            return;
        }
        if (!outbox.offer(frame)) {
            outbox.poll();
            outbox.offer(frame);
        }
    }

    public boolean isReady() {
        Socket s = socket;
        return handshakeDone.get() && s != null && s.isConnected() && !s.isClosed();
    }

    public boolean isConnected() {
        Socket s = socket;
        return s != null && s.isConnected() && !s.isClosed();
    }

    public int port() {
        ServerSocket s = server;
        return s == null ? -1 : s.getLocalPort();
    }

    public String lastError() {
        return lastError;
    }

    public int queuedFrames() {
        return outbox.size();
    }

    /** Complete frame bodies received from the peer, for link diagnostics. */
    public long receivedFrames() {
        return received.get();
    }

    public void close() {
        running.set(false);
        ServerSocket listener = server;
        server = null;
        if (listener != null) {
            try {
                listener.close();
            } catch (IOException ignored) {
            }
        }
        Socket s = socket;
        socket = null;
        if (s != null) {
            try {
                s.close();
            } catch (IOException ignored) {
            }
        }
        outbox.clear();
        interrupt(acceptThread);
        interrupt(readThread);
        interrupt(writeThread);
    }

    private static void interrupt(Thread t) {
        if (t != null) {
            t.interrupt();
        }
    }
}
