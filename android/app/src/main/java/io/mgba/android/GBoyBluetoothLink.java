/* This Source Code Form is subject to the terms of the Mozilla Public
 * License, v. 2.0. If a copy of the MPL was not distributed with this
 * file, You can obtain one at http://mozilla.org/MPL/2.0/. */
package io.mgba.android;

import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothServerSocket;
import android.bluetooth.BluetoothSocket;
import android.os.Process;
import android.util.Log;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayDeque;
import java.util.UUID;
import java.util.concurrent.atomic.AtomicBoolean;

/**
 * 官方客户端的蓝牙通道，逐行对应 {@code KpHwm4.A2egSU} / {@code KpHwm4.A4TApA}：
 *
 * <pre>
 *   服务端  adapter.listenUsingRfcommWithServiceRecord("GBoy", UUID).accept()
 *   客户端  adapter.getRemoteDevice(mac)
 *                  .createRfcommSocketToServiceRecord(UUID).connect()
 *   两端    socket.getInputStream() / getOutputStream() 直接进同一条会话循环
 * </pre>
 *
 * <p>关键点：蓝牙在本作里**只是另一条字节流**，不是另一套协议。RFCOMM 上跑的
 * 仍然是 {@code 4B 大端长度 + u16 type + payload} 的 GBoy 帧，所以上层
 * （{@link GBoyLinkSession} / {@code serve()}）一个字都不用改。</p>
 *
 * <p>UUID 与服务名与官方一致（{@code B25kr6.f4349AcNBzu}、
 * {@code "GBoy"}），因此和原版客户端互连也能对上。</p>
 *
 * <p>线程优先级：官方在连接线程里 {@code Process.setThreadPriority(-19)}
 * （URGENT_AUDIO），这里照抄 —— 蓝牙栈的调度抖动会直接变成联机线的丢轮次。</p>
 */
final class GBoyBluetoothLink implements GBoyCloudLink.Link {

    private static final String TAG = "GBoyBluetooth";
    /** 官方 {@code B25kr6.f4349AcNBzu}。 */
    static final UUID SERVICE_UUID = UUID.fromString("3a1f7b2e-8d45-4c92-bf60-5e3c21a98d47");
    /** 官方注册的服务名，对端按名字找服务时用。 */
    static final String SERVICE_NAME = "GBoy";

    private static final int READ_BUFFER = 4096;

    private final BluetoothSocket socket;
    private final InputStream input;
    private final OutputStream output;
    private final Object writeLock = new Object();
    private final AtomicBoolean closed = new AtomicBoolean();
    private final ArrayDeque<byte[]> inbox = new ArrayDeque<>();
    private final Object inboxLock = new Object();
    private Thread reader;

    private GBoyBluetoothLink(BluetoothSocket socket) throws IOException {
        this.socket = socket;
        input = socket.getInputStream();
        output = socket.getOutputStream();
        reader = new Thread(this::readLoop, "gboy-bt-in");
        reader.start();
    }

    /** 服务端：注册 SDP 记录并等一个对端连进来（阻塞，调用方放到工作线程）。 */
    static GBoyBluetoothLink host(BluetoothAdapter adapter) throws IOException {
        if (adapter == null) {
            throw new IOException("设备没有蓝牙适配器");
        }
        BluetoothServerSocket server =
                adapter.listenUsingRfcommWithServiceRecord(SERVICE_NAME, SERVICE_UUID);
        try {
            BluetoothSocket peer = server.accept();
            return new GBoyBluetoothLink(peer);
        } finally {
            try {
                server.close();
            } catch (IOException ignored) {
            }
        }
    }

    /** 客户端：连指定 MAC（阻塞）。官方在连接前会 cancelDiscovery，否则连接极慢。 */
    static GBoyBluetoothLink join(BluetoothAdapter adapter, String mac) throws IOException {
        if (adapter == null) {
            throw new IOException("设备没有蓝牙适配器");
        }
        if (mac == null || mac.isEmpty()) {
            throw new IOException("没有指定蓝牙地址");
        }
        adapter.cancelDiscovery();
        BluetoothDevice device = adapter.getRemoteDevice(mac);
        BluetoothSocket peer = device.createRfcommSocketToServiceRecord(SERVICE_UUID);
        Process.setThreadPriority(Process.THREAD_PRIORITY_URGENT_AUDIO);
        peer.connect();
        return new GBoyBluetoothLink(peer);
    }

    private void readLoop() {
        Process.setThreadPriority(Process.THREAD_PRIORITY_URGENT_AUDIO);
        byte[] buffer = new byte[READ_BUFFER];
        while (!closed.get()) {
            int n;
            try {
                n = input.read(buffer);
            } catch (IOException e) {
                break;
            }
            if (n <= 0) {
                break;
            }
            byte[] chunk = new byte[n];
            System.arraycopy(buffer, 0, chunk, 0, n);
            synchronized (inboxLock) {
                inbox.addLast(chunk);
                inboxLock.notifyAll();
            }
        }
        closed.set(true);
        Log.i(TAG, "bluetooth link closed");
    }

    @Override
    public void send(byte[] frame) {
        if (frame == null || frame.length == 0 || closed.get()) {
            return;
        }
        // 整帧写出去：流上本来就是「4B 长度 + type + payload」，对端按同一格式切。
        synchronized (writeLock) {
            try {
                output.write(frame);
                output.flush();
            } catch (IOException e) {
                closed.set(true);
            }
        }
    }

    @Override
    public byte[] recv(long timeoutMs) {
        long deadline = System.currentTimeMillis() + Math.max(0, timeoutMs);
        synchronized (inboxLock) {
            while (inbox.isEmpty()) {
                long remaining = deadline - System.currentTimeMillis();
                if (remaining <= 0 || closed.get()) {
                    return null;
                }
                try {
                    inboxLock.wait(Math.min(remaining, 50));
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                    return null;
                }
            }
            return inbox.pollFirst();
        }
    }

    @Override
    public boolean isClosed() {
        return closed.get();
    }

    @Override
    public void close() {
        closed.set(true);
        try {
            socket.close();
        } catch (IOException ignored) {
        }
        synchronized (inboxLock) {
            inboxLock.notifyAll();
        }
    }
}
