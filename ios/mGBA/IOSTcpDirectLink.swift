// 架构 D（真机直连）三端对称：iOS TCP 直连的 ILink 式适配器。
// 复用现有 GBoyLink.swift 的裸 TCP + GBoyFrames 帧格式（u32 len + u16 type + payload，
// 与 PC TcpDirectLink.h:21-39 逐位一致），只做 send/recv/isClosed/close 适配，
// 不新增任何帧格式、不生成/不伪造任何游戏态（party/信任位/CROSSED）。
//
// 门状态不变量：FAIL / 对手真实性 0/9 / 零注入 CROSSED（APP 0006↔PC 00D5）从未产出。
// 本文件仅为代码级三端对称补齐；运行级/真机验证未做，不升门。

import Foundation

/// LobbyDataLink（PC ILink / Android ILink 的 iOS 最小等价物）的 TCP 直连实现。
/// 持有 GBoyLink，把它的 onWireFrame 钩子 + sendBody 包装成 send/recv 数据通道。
final class IOSTcpDirectLink: LobbyDataLink {
    private let gboy: GBoyLink
    private let lock = NSLock()
    private var inbox: [[UInt8]] = []

    init(gboy: GBoyLink) {
        self.gboy = gboy
        // 只读观测钩子：readFrame 后原样交出整条 wire frame，业务分发不受影响。
        gboy.onWireFrame = { [weak self] frame in
            guard let self = self else { return }
            self.lock.lock()
            self.inbox.append(frame)
            self.lock.unlock()
        }
    }

    /// 发一条 body（type+payload，不含长度头），交给 GBoyLink.sendBody 补头写出。
    func send(_ payload: Data) {
        try? gboy.sendBody([UInt8](payload))
    }

    /// 取一条到达的 wire frame；无帧返回 nil（非阻塞，timeoutMs 由上层轮询语义处理）。
    func recv(timeoutMs: Int) -> Data? {
        lock.lock()
        defer { lock.unlock() }
        guard !inbox.isEmpty else { return nil }
        return Data(inbox.removeFirst())
    }

    var isClosed: Bool {
        // GBoyLink 无公开 isClosed；用 userClosedFlag 的对外语义由 close() 管理，
        // 这里以最后一次 close() 调用的本地标志为准（最小实现，运行级待验证）。
        lock.lock()
        defer { lock.unlock() }
        return closedByUs
    }

    func close() {
        lock.lock()
        closedByUs = true
        lock.unlock()
        gboy.close()
    }

    private var closedByUs = false
}
