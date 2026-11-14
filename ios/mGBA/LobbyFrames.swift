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
     * 类型号与官方客户端逐条对齐（KpHwm4.B25kr6 的 ARc23Z 调用、
     * KpHwm4/AmA8tU.java:167-221）：
     *   0 节奏 / 1 握手 / 2 名字 / 3 就绪+RTT / 5 就绪确认 / 6 状态 / 9 按键。
     * 官方没用到 4、7、8、10 之后的号，自家扩展（多槽位按键、复位、计数）
     * 一律放到 11 以上 —— 早先这里 0 当按键、9 当 FPS、5 当复位、3 兼作
     * 槽位 3 按键，全部与官方语义撞车（见 NETPLAY_SPEC.md 第 6 节第 3 行）。
     * 这份表与 Android `GBoyFrames` 逐项相同，三端必须同时改。
     */

    /// 官方 0：节奏 / 帧率上限（int32），接收方据此设本机帧率上限。
    static let typeFps = 0
    /// 官方 1：握手（int32 playerCount；长度 0 的 1 = 断开/结束）。
    static let typeRegister = 1
    /// 官方 2：名字（32 字节定长 + int16 长度 + 描述串）。
    static let typeName = 2
    /// 官方 3：就绪 + RTT（int32）。云端注册阶段中继也用 3 回玩家数。
    static let typeReady = 3
    /// 官方 5：就绪确认（空体，只有客户端路径发）。
    static let typeReadyAck = 5
    /// 官方 6：整份 savestate（int32 长度 + blob）。
    static let typeState = 6
    /// 官方 9：按键掩码（int32）。
    static let typeKeys = 9

    // ---- 以下是我们自己的扩展，从 11 起，不与官方撞号 ----

    /// 槽位 2 的按键掩码（官方没有「带槽位的按键」，两人会话用 9 即可）。
    static let typeInput2 = 11
    /// 槽位 4 的按键掩码。
    static let typeInput4 = 12
    /// 复位请求，body 是 int(0)。
    static let typeReset = 13
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
    ///     type 1, body: int playerCount, short 0, int baseStateCount
    ///
    /// The body is always ten bytes long.
    static func registerFrame(playerCount: Int32, baseStateCount: Int32) -> Data {
        var out = [UInt8](repeating: 0, count: 16)
        putInt(&out, 0, 12)
        putShort(&out, 4, typeRegister)
        putInt(&out, 6, playerCount)
        putShort(&out, 10, 0)
        putInt(&out, 12, baseStateCount)
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
