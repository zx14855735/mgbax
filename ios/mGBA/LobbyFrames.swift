/* This Source Code Form is subject to the terms of the Mozilla Public
 * License, v. 2.0. If a copy of the MPL was not distributed with this
 * file, You can obtain one at http://mozilla.org/MPL/2.0/. */
import Foundation

/**
 * The cloud lobby frame layer, byte for byte as the lobby server's official
 * client speaks it. A Swift port of the Android `GBoyFrames`.
 *
 * <pre>
 *   +----------------+----------------+--------------------+
 *   | u32 length (BE)| u16 type (BE)  | payload ...        |
 *   +----------------+----------------+--------------------+
 * </pre>
 *
 * `length` counts the two type bytes *and* the payload, so a bare frame is
 * `length = 2` and occupies six bytes on the wire. The frame body - type
 * followed by payload - is what the queue carries, so that is what
 * `type(of:)` and `intValue(of:)` operate on.
 */
enum LobbyFrames {
    /// Largest frame body accepted on a lobby stream.
    ///
    /// This is the same 16 MiB ceiling the Android `GBoyFrames` uses. The
    /// original 65535 here was wrong: a GBA save state is roughly 790 KiB
    /// (the Android log measured 790663 bytes), so every `typeState` frame was
    /// rejected as "not a frame we understand" and the reader dropped the whole
    /// stream. Everything after it - key frames included - was then parsed from
    /// a corrupted offset, which is why the cloud link showed phantom inputs and
    /// never received a state.
    static let maxFrameLength = 16 * 1024 * 1024

    /*
     * 类型号按官方**字节码**逐条核对（tmp_gboy_apk/NETPLAY_AUDIT.md §0、
     * .workbuddy/gboy/dd/p1/p2.txt）：
     *   0 按键 / 1 握手 / 2 名字 / 3 就绪+RTT / 5 复位 / 6 状态 / 9 倍速 /
     *   10 断开通知。
     *
     * 关键更正（曾经的错表把 0 当帧率、9 当按键、5 当 ready-ack）：
     *   - `KpHwm4/B25kr6.AYUAbz` 的 packed-switch：case 0 → `peer.BI9f7h.setKeys(getInt())`
     *     （p2.txt:379f24-379f36，0x0138 目标），所以 **0 = 按键掩码**；
     *     模拟线程 `ADYaiT/D8MqeW.run` 里 `const/4 v11,#0` + `ARc23Z(v11,4)` +
     *     `putInt(keys)` 就是它的发送点（p1.txt:34821a / 348364）。
     *   - case 9 → 写 `AaHO0E.AZkASS` 速度倍率并重算帧闸（p2.txt:379d5a），
     *     唯一发送点 `B25kr6.AZOQYO` 的四个调用者紧挨着 "0.5x"/"2x"/"4x" 菜单
     *     （p2.txt:63c94e-63c9de），所以 **9 = 倍速**（值 1/-1/2/4）。
     *   - case 5 → 可见核 + 全部镜像核 `reset(false)`（p2.txt:379e76），发送点
     *     `EmulatorActivity.BmvVmW:1333` 的 "重置游戏" 菜单，所以 **5 = 复位**。
     *
     * 官方没有 fps/pacing 帧，也没有 ready-ack。自家扩展（多槽位按键、计数器）
     * 一律 11 起；13 保留为旧版复位号，收到同样执行复位。
     * 这份表与 PC `GBoyFrames.h` / Android `GBoyFrames.java` 必须逐项相同。
     */

    /// 官方 0：本帧按键掩码（int32）。稳态每帧/每对端一条；握手阶段中继也用它
    /// 下发节奏值（见 LobbyLink.handle 的 steady 参数，两个阶段语义不同）。
    static let typeKeys = 0
    /// 官方 1：握手（int32 playerCount；长度 0 的 1 = 断开/结束）。
    static let typeRegister = 1
    /// 官方 2：名字（32 字节定长 + int16 长度 + 描述串）。
    static let typeName = 2
    /// 官方 3：就绪 + RTT（int32）。云端注册阶段中继也用 3 回玩家数。
    static let typeReady = 3
    /// 官方 5：复位全部核（int32 0）。以前当成 ready-ack 吃掉。
    static let typeReset = 5
    /// 官方 6：整份 savestate（int32 长度 + blob）。
    static let typeState = 6
    /// 官方 9：模拟速度倍率（int32：1 = 1x、-1 = 0.5x、2 = 2x、4 = 4x）。
    static let typeSpeed = 9
    /// 官方 10：断开通知（无 payload；`AYUAbz` case 10 → UI msg 2）。
    static let typeDisconnect = 10

    // ---- 以下是我们自己的扩展，从 11 起，不与官方撞号 ----

    /// 槽位 2 的按键掩码（官方没有「带槽位的按键」，两人会话用 0 即可）。
    static let typeInput2 = 11
    /// 槽位 4 的按键掩码。
    static let typeInput4 = 12
    /// 旧版复位号（自家扩展）。新版发官方 5，收到 13 也当复位处理。
    static let typeResetLegacy = 13
    /// 本机可见核自己的按键掩码（兼容旧对端）。
    static let typeKeysLocal = 14
    /// 自由计数器。
    static let typeCounter = 15
    /// 带外事件。
    static let typeEvent = 16
    /// 槽位 3 的按键掩码（以前借官方 3 夹带，与「3 = RTT」冲突）。
    static let typeInput3 = 17

    /// Bare frame: `length = 2`, no payload.
    static func frame(_ type: Int) -> Data {
        var out = [UInt8](repeating: 0, count: 6)
        putInt(&out, 0, 2)
        putShort(&out, 4, type)
        return Data(out)
    }

    /// Frame carrying a single big endian int.
    static func frame(_ type: Int, _ value: Int32) -> Data {
        var out = [UInt8](repeating: 0, count: 10)
        putInt(&out, 0, 6)
        putShort(&out, 4, type)
        putInt(&out, 6, value)
        return Data(out)
    }

    /// Frame carrying a raw payload (the length counts the two type bytes).
    static func frame(_ type: Int, _ payload: Data) -> Data {
        let bytes = [UInt8](payload)
        var out = [UInt8](repeating: 0, count: 6 + bytes.count)
        putInt(&out, 0, Int32(2 + bytes.count))
        putShort(&out, 4, type)
        for i in 0..<bytes.count {
            out[6 + i] = bytes[i]
        }
        return Data(out)
    }

    /// TYPE_STATE = int length followed by the save-state blob. The host sends
    /// one once the link is up so both cores start from the same point.
    static func stateFrame(_ state: Data) -> Data {
        let bytes = [UInt8](state)
        var body = [UInt8](repeating: 0, count: 4 + bytes.count)
        putInt(&body, 0, Int32(bytes.count))
        for i in 0..<bytes.count {
            body[4 + i] = bytes[i]
        }
        return frame(typeState, Data(body))
    }

    /// Extracts the save-state blob; nil when the length header does not fit.
    /// The SIO relay bridge also uses type 6, but with a raw packet and no
    /// length prefix, so those frames must not be loaded as save states.
    static func state(of body: Data) -> Data? {
        let payload = [UInt8](LobbyFrames.payload(of: body))
        guard payload.count >= 4 else { return nil }
        let length = Int(getInt(payload, 0))
        guard length >= 0, length <= payload.count - 4 else { return nil }
        return Data(payload[4..<(4 + length)])
    }

    /// The registration frame the official client sends right after the KCP
    /// handshake completes:
    ///
    ///     type 1, body: int playerCount [, short 0, int baseStateCount]
    ///
    /// **线上恒 16 字节、长度字段恒 12**：官方 `B25kr6.ARc23Z(1, 10)` 分配的是
    /// `10 + 6 = 16` 字节并把长度写成 12，发送线程 `A5SV6n` 调的是
    /// `outputStream.write(byteBuffer.array())` —— 写整个 backing array，与
    /// position/limit 无关。`AmA8tU:173-178` 的 `if (playerCount == 1)` 只决定
    /// 尾部那 6 字节**填不填**（填 `short 0 + int listSize`，不填就是 0），
    /// **不决定发不发**。所以 pc≠1 是「16 字节、尾部 6 个 0」，不是 10 字节的帧。
    /// 与 PC `GBoyFrames::registerFrame` / Android `GBoyFrames.registerFrame`
    /// 逐字节一致（AUDIT C6 / B 表第 19 行）。
    static func registerFrame(playerCount: Int32, baseStateCount: Int32) -> Data {
        var out = [UInt8](repeating: 0, count: 16)
        putInt(&out, 0, 12)
        putShort(&out, 4, typeRegister)
        putInt(&out, 6, playerCount)
        if playerCount == 1 {
            putShort(&out, 10, 0)
            putInt(&out, 12, baseStateCount)
        }
        return Data(out)
    }

    /// The message type of a frame body, -1 when the body is too short.
    static func type(of body: Data) -> Int {
        let bytes = [UInt8](body)
        if bytes.count < 2 {
            return -1
        }
        return Int(bytes[0]) << 8 | Int(bytes[1])
    }

    /// The int that follows the message type, 0 when the body is short.
    static func intValue(of body: Data) -> Int32 {
        let bytes = [UInt8](body)
        if bytes.count < 6 {
            return 0
        }
        return getInt(bytes, 2)
    }

    /// The payload of a frame body, i.e. everything behind the type.
    static func payload(of body: Data) -> Data {
        let bytes = [UInt8](body)
        if bytes.count <= 2 {
            return Data()
        }
        return Data(bytes[2...])
    }

    static func putInt(_ out: inout [UInt8], _ offset: Int, _ value: Int32) {
        let v = UInt32(bitPattern: value)
        out[offset] = UInt8((v >> 24) & 0xFF)
        out[offset + 1] = UInt8((v >> 16) & 0xFF)
        out[offset + 2] = UInt8((v >> 8) & 0xFF)
        out[offset + 3] = UInt8(v & 0xFF)
    }

    static func putShort(_ out: inout [UInt8], _ offset: Int, _ value: Int) {
        out[offset] = UInt8((value >> 8) & 0xFF)
        out[offset + 1] = UInt8(value & 0xFF)
    }

    static func getInt(_ bytes: [UInt8], _ offset: Int) -> Int32 {
        let a = UInt32(bytes[offset])
        let b = UInt32(bytes[offset + 1])
        let c = UInt32(bytes[offset + 2])
        let d = UInt32(bytes[offset + 3])
        return Int32(bitPattern: (a << 24) | (b << 16) | (c << 8) | d)
    }

    static func getShort(_ bytes: [UInt8], _ offset: Int) -> Int {
        return Int(bytes[offset]) << 8 | Int(bytes[offset + 1])
    }

    /**
     * Incremental splitter for the KCP byte stream: read the big endian
     * length, wait until that many bytes are available, then hand the body
     * (type + payload) to the caller.
     */
    final class Reader {
        private var buffer: [UInt8] = []
        private var position = 0

        func append(_ data: Data) {
            append([UInt8](data))
        }

        func append(_ bytes: [UInt8]) {
            if bytes.isEmpty {
                return
            }
            buffer.append(contentsOf: bytes)
        }

        /// Next complete frame body, or nil while the frame is incomplete.
        func next() -> Data? {
            let available = buffer.count - position
            if available < 4 {
                return nil
            }
            let length = Int(getInt(buffer, position))
            if length < 2 || length > maxFrameLength {
                // Not a frame we understand; drop the stream rather than spin.
                position = buffer.count
                return nil
            }
            if available < 4 + length {
                return nil
            }
            let body = Data(buffer[(position + 4)..<(position + 4 + length)])
            position += 4 + length
            if position >= buffer.count {
                buffer.removeAll(keepingCapacity: true)
                position = 0
            } else if position > 1 << 20 {
                // 1 MiB before compacting rather than 64 KiB: a state frame can
                // be a megabyte on its own, and compacting after every small
                // frame memmoves the whole buffer for nothing.
                buffer.removeFirst(position)
                position = 0
            }
            return body
        }
    }
}

/**
 * 官方倍速（type 9）的纯函数表 —— 三端对齐用。
 *
 * 线上值域只有 `{1, -1, 2, 4}`（`KpHwm4/B25kr6.AZOQYO` 的四个调用点，
 * 分别对应菜单里的 1x / 0.5x / 2x / 4x），接收侧 `AYUAbz` case 9 直接写
 * `AaHO0E.AZkASS` 并重算帧闸。**`-1` 是 0.5x，不是 1x**；其它值/没收到
 * 一律按 1x（官方只在 `i > 0` 时取 `i`，`i <= 0` 落 0.5f，但线上不会出现
 * 0，所以这里把非法值当 1x 更安全）。
 *
 * 放在这个文件里而不是新建文件：它属于帧协议层，且 Xcode 工程是逐文件登记
 * 的，新增 .swift 还要改 project.pbxproj，没必要。
 */
enum GBoySpeed {
    /// 线上合法值，发送侧做白名单用。
    static let wireValues: [Int32] = [1, -1, 2, 4]

    /// 线上值 → 本地倍率。非法值回落 1.0。
    static func rate(_ wire: Int32) -> Double {
        switch wire {
        case -1: return 0.5
        case 2: return 2
        case 4: return 4
        default: return 1
        }
    }

    /// 本地倍率 → 线上值；不在 {0.5, 1, 2, 4} 里返回 nil（本机自定义倍速不广播，
    /// 免得把对端拖进 0.05x/16x 这种官方帧闸表达不了的节奏）。
    static func wireValue(forRate rate: Double) -> Int32? {
        if abs(rate - 0.5) < 0.001 { return -1 }
        if abs(rate - 1) < 0.001 { return 1 }
        if abs(rate - 2) < 0.001 { return 2 }
        if abs(rate - 4) < 0.001 { return 4 }
        return nil
    }

    /// 官方帧闸 `1e9 / (speed * 60)`。这里以核心自己的帧长为基准除以倍率：
    /// GBA/GB 的帧长不是刚好 1e9/60（约 16.74ms），用基准值能把「倍速 = 帧
    /// 间隔 ÷ 倍率」保持住，不被 60fps 取整污染。
    static func sliceNanos(base: Int64, rate: Double) -> Int64 {
        guard base > 0, rate > 0 else { return base }
        return max(1, Int64(Double(base) / rate))
    }
}
