/* This Source Code Form is subject to the terms of the Mozilla Public
 * License, v. 2.0. If a copy of the MPL was not distributed with this
 * file, You can obtain one at http://mozilla.org/MPL/2.0/. */
import Foundation

/**
 * Minimal GIF89a encoder for gameplay clips, a port of the Android GifEncoder.
 * Frames are quantized against a fixed web-safe palette (cheap: no per-clip
 * color analysis, and game frames repeat colors heavily so the nearest-color
 * cache absorbs almost every pixel) and LZW-encoded with the standard
 * variable-width code table. The file loops forever via the Netscape extension.
 */
final class GifEncoder {
    /** Web-safe 6x6x6 cube extended to 256 entries with a grey ramp. */
    private static let palette: [UInt32] = {
        var table = [UInt32](repeating: 0, count: 256)
        var n = 0
        for r in 0..<6 {
            for g in 0..<6 {
                for b in 0..<6 {
                    table[n] = 0xFF000000 | UInt32(r * 51) << 16 | UInt32(g * 51) << 8 | UInt32(b * 51)
                    n += 1
                }
            }
        }
        var i = 0
        while n < 256 {
            let v = UInt32((i + 1) * 255 / 40)
            table[n] = 0xFF000000 | v << 16 | v << 8 | v
            i += 1
            n += 1
        }
        return table
    }()

    private var data = Data()
    private let width: Int
    private let height: Int
    private var cache: [UInt32: UInt8] = [:]
    private var started = false

    init(width: Int, height: Int) {
        self.width = max(1, width)
        self.height = max(1, height)
    }

    /**
     * Appends one frame; `delayCs` is the frame time in 1/100 s units. `pixels`
     * holds RGBA8 rows of exactly `width` pixels (as copied from the core's
     * frame buffer).
     */
    func addFrame(pixels: UnsafePointer<UInt8>, delayCs: Int) {
        if !started {
            writeHeader()
            started = true
        }
        let count = width * height
        var indices = [UInt8](repeating: 0, count: count)
        for i in 0..<count {
            // Core frames are RGBA in memory; pack to the cache's 0xRRGGBB key.
            let base = i * 4
            let argb = 0xFF000000 | UInt32(pixels[base]) << 16 | UInt32(pixels[base + 1]) << 8 | UInt32(pixels[base + 2])
            indices[i] = nearest(argb)
        }
        // Graphic Control Extension: delay, no transparency.
        data.append(0x21)
        data.append(0xF9)
        data.append(4)
        data.append(0x04)
        data.append(UInt8(delayCs & 0xFF))
        data.append(UInt8((delayCs >> 8) & 0xFF))
        data.append(0)
        data.append(0)
        // Image Descriptor covering the whole canvas, global palette.
        data.append(0x2C)
        writeLe(0)
        writeLe(0)
        writeLe(width)
        writeLe(height)
        data.append(0)
        lzw(indices)
    }

    /** Returns the finished GIF file; the encoder is done after this. */
    func finish() -> Data {
        if !started {
            writeHeader()
        }
        data.append(0x3B)
        return data
    }

    private func writeHeader() {
        data.append(Data("GIF89a".utf8))
        writeLe(width)
        writeLe(height)
        data.append(0xF7) // global color table, 8-bit color resolution, 256 entries
        data.append(0)
        data.append(0)
        for p in Self.palette {
            data.append(UInt8((p >> 16) & 0xFF))
            data.append(UInt8((p >> 8) & 0xFF))
            data.append(UInt8(p & 0xFF))
        }
        data.append(0x21)
        data.append(0xFF)
        data.append(0x0B)
        data.append(Data("NETSCAPE2.0".utf8))
        data.append(3)
        data.append(1)
        data.append(0)
        data.append(0)
        data.append(0)
    }

    private func nearest(_ argb: UInt32) -> UInt8 {
        if let hit = cache[argb] {
            return hit
        }
        let r = Int((argb >> 16) & 0xFF)
        let g = Int((argb >> 8) & 0xFF)
        let b = Int(argb & 0xFF)
        var best = 0
        var bestDist = Int.max
        for i in 0..<256 {
            let p = Self.palette[i]
            let dr = r - Int((p >> 16) & 0xFF)
            let dg = g - Int((p >> 8) & 0xFF)
            let db = b - Int(p & 0xFF)
            let dist = dr * dr + dg * dg + db * db
            if dist < bestDist {
                bestDist = dist
                best = i
            }
        }
        if cache.count > 16384 {
            cache.removeAll(keepingCapacity: true)
        }
        let index = UInt8(best)
        cache[argb] = index
        return index
    }

    /** Standard GIF LZW with 8-bit symbols and 255-byte sub-block chunking. */
    private func lzw(_ indices: [UInt8]) {
        var packed = [UInt8]()
        packed.reserveCapacity(indices.count / 2 + 64)
        let clear = 256
        let eoi = 257
        var next = 258
        var bits = 9
        var dict = [UInt32: Int](minimumCapacity: 1 << 15)
        var sink = BitSink()
        sink.write(clear, width: bits)
        var prefix = Int(indices[0])
        if indices.count > 1 {
            for i in 1..<indices.count {
                let b = Int(indices[i])
                let key = UInt32(prefix << 8) | UInt32(b)
                if let code = dict[key] {
                    prefix = code
                    continue
                }
                sink.write(prefix, width: bits)
                if next == 4096 {
                    // Table full: flush the pending code, emit CLEAR, start
                    // over. The entry for this iteration is skipped — the
                    // decoder does not add one for the first code after a
                    // CLEAR either, so both sides stay in lockstep.
                    sink.write(clear, width: bits)
                    dict.removeAll(keepingCapacity: true)
                    next = 258
                    bits = 9
                } else {
                    dict[key] = next
                    next += 1
                    if next > (1 << bits) && bits < 12 {
                        bits += 1
                    }
                }
                prefix = b
            }
        }
        sink.write(prefix, width: bits)
        sink.write(eoi, width: bits)
        packed = sink.finish()
        data.append(8) // LZW minimum code size
        var pos = 0
        while pos < packed.count {
            let chunk = min(255, packed.count - pos)
            data.append(UInt8(chunk))
            data.append(contentsOf: packed[pos..<(pos + chunk)])
            pos += chunk
        }
    }

    private func writeLe(_ value: Int) {
        data.append(UInt8(value & 0xFF))
        data.append(UInt8((value >> 8) & 0xFF))
    }

    /** Packs variable-width LZW codes LSB-first into a byte stream. */
    private struct BitSink {
        private var bytes = [UInt8]()
        private var bits = 0
        private var count = 0

        mutating func write(_ code: Int, width: Int) {
            bits |= code << count
            count += width
            while count >= 8 {
                bytes.append(UInt8(bits & 0xFF))
                bits >>= 8
                count -= 8
            }
        }

        mutating func finish() -> [UInt8] {
            if count > 0 {
                bytes.append(UInt8(bits & 0xFF))
            }
            return bytes
        }
    }
}

/// Bounded FIFO with a timed poll, the Swift equivalent of the Android
/// ArrayBlockingQueue the GIF recorder hands frames through.
final class GifFrameQueue {
    private let condition = NSCondition()
    private var items: [[UInt8]] = []
    private let limit: Int
    private var closed = false

    init(limit: Int) {
        self.limit = max(1, limit)
    }

    func offer(_ item: [UInt8]) {
        condition.lock()
        if items.count < limit {
            items.append(item)
            condition.signal()
        }
        condition.unlock()
    }

    /// Waits up to `seconds` for an item; nil when the wait timed out.
    func poll(seconds: Double) -> [UInt8]? {
        condition.lock()
        defer { condition.unlock() }
        let deadline = Date().addingTimeInterval(seconds)
        while items.isEmpty {
            if !condition.wait(until: deadline) {
                return nil
            }
        }
        return items.removeFirst()
    }

    var isEmpty: Bool {
        condition.lock()
        defer { condition.unlock() }
        return items.isEmpty
    }
}
