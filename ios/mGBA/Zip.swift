/* This Source Code Form is subject to the terms of the Mozilla Public
 * License, v. 2.0. If a copy of the MPL was not distributed with this
 * file, You can obtain one at http://mozilla.org/MPL/2.0/. */
import Compression
import Foundation

/**
 * Minimal ZIP reader/writer used by the skin importer and the backup export.
 *
 * The archives handled here only ever hold small binary blobs (PNG files),
 * so a hand rolled parser is enough and keeps the app free of third party
 * dependencies. Reading understands the two compression methods that matter:
 * 0 (stored) and 8 (deflate). Writing always uses the stored method, which
 * every zip reader understands.
 *
 * The CRC-32 matches java.util.zip.CRC32 exactly, so backups stay readable on
 * the Android build (and the other way around).
 */
enum Zip {
    struct Entry {
        let name: String
        let data: Data
    }

    /// Signatures of the three record types we care about.
    private enum Signature {
        static let local: UInt32 = 0x04034b50
        static let central: UInt32 = 0x02014b50
        static let endOfCentralDirectory: UInt32 = 0x06054b50
    }

    /// General purpose bit 11: the file name is UTF-8 instead of CP437.
    private static let utf8NameFlag: UInt16 = 0x0800

    /// DOS date for 1980-01-01, the zero point of the DOS time format.
    private static let dosEpochDate: UInt16 = 0x0021

    /// Reflected CRC-32 table for the 0xEDB88320 polynomial.
    private static let crcTable: [UInt32] = {
        var table = [UInt32](repeating: 0, count: 256)
        for index in 0..<256 {
            var value = UInt32(index)
            for _ in 0..<8 {
                value = (value & 1) != 0 ? (0xEDB88320 ^ (value >> 1)) : (value >> 1)
            }
            table[index] = value
        }
        return table
    }()

    /**
     * CRC-32 (IEEE 802.3), the same value java.util.zip.CRC32 produces.
     */
    static func crc32(_ data: Data) -> UInt32 {
        var crc: UInt32 = 0xFFFFFFFF
        data.withUnsafeBytes { (raw: UnsafeRawBufferPointer) in
            for byte in raw {
                crc = (crc >> 8) ^ crcTable[Int((crc ^ UInt32(byte)) & 0xFF)]
            }
        }
        return crc ^ 0xFFFFFFFF
    }

    /**
     * Reads every file entry out of a zip archive. Returns nil when the file
     * is not a readable zip.
     */
    static func read(_ url: URL) -> [Entry]? {
        guard let raw = try? Data(contentsOf: url) else { return nil }
        let bytes = [UInt8](raw)
        guard let eocd = findEndOfCentralDirectory(bytes) else { return nil }
        guard let count = uint16(bytes, eocd + 10), let directoryOffset = uint32(bytes, eocd + 16) else { return nil }
        var entries: [Entry] = []
        var offset = Int(directoryOffset)
        for _ in 0..<Int(count) {
            guard let record = parseCentralEntry(bytes, at: offset) else { break }
            offset = record.next
            // Directory markers carry no payload.
            if record.name.hasSuffix("/") { continue }
            guard let data = extract(bytes: bytes,
                                     localOffset: record.localOffset,
                                     method: record.method,
                                     compressedSize: record.compressedSize,
                                     uncompressedSize: record.uncompressedSize,
                                     checksum: record.checksum) else { continue }
            entries.append(Entry(name: record.name, data: data))
        }
        return entries
    }

    /**
     * Writes entries into a zip archive at `url`. Uses the stored method
     * (no compression), which every zip reader understands.
     */
    static func write(_ entries: [Entry], to url: URL) -> Bool {
        let manager = FileManager.default
        let parent = url.deletingLastPathComponent()
        if !parent.path.isEmpty {
            try? manager.createDirectory(at: parent, withIntermediateDirectories: true)
        }
        if manager.fileExists(atPath: url.path) {
            try? manager.removeItem(at: url)
        }
        var body = Data()
        var directory = Data()
        for entry in entries {
            let name = Array(entry.name.utf8)
            let checksum = crc32(entry.data)
            let size = UInt32(entry.data.count)
            let localOffset = UInt32(body.count)
            // Local file header: stored, UTF-8 name, fixed 1980-01-01 stamp.
            appendLE(Signature.local, to: &body)
            appendLE(UInt16(20), to: &body)
            appendLE(utf8NameFlag, to: &body)
            appendLE(UInt16(0), to: &body)
            appendLE(UInt16(0), to: &body)
            appendLE(dosEpochDate, to: &body)
            appendLE(checksum, to: &body)
            appendLE(size, to: &body)
            appendLE(size, to: &body)
            appendLE(UInt16(name.count), to: &body)
            appendLE(UInt16(0), to: &body)
            body.append(contentsOf: name)
            body.append(entry.data)
            // Matching central directory record.
            appendLE(Signature.central, to: &directory)
            appendLE(UInt16(20), to: &directory)
            appendLE(UInt16(20), to: &directory)
            appendLE(utf8NameFlag, to: &directory)
            appendLE(UInt16(0), to: &directory)
            appendLE(UInt16(0), to: &directory)
            appendLE(dosEpochDate, to: &directory)
            appendLE(checksum, to: &directory)
            appendLE(size, to: &directory)
            appendLE(size, to: &directory)
            appendLE(UInt16(name.count), to: &directory)
            appendLE(UInt16(0), to: &directory)
            appendLE(UInt16(0), to: &directory)
            appendLE(UInt16(0), to: &directory)
            appendLE(UInt16(0), to: &directory)
            appendLE(UInt32(0), to: &directory)
            appendLE(localOffset, to: &directory)
            directory.append(contentsOf: name)
        }
        let directoryOffset = UInt32(body.count)
        body.append(directory)
        // End of central directory record.
        appendLE(Signature.endOfCentralDirectory, to: &body)
        appendLE(UInt16(0), to: &body)
        appendLE(UInt16(0), to: &body)
        appendLE(UInt16(entries.count), to: &body)
        appendLE(UInt16(entries.count), to: &body)
        appendLE(UInt32(directory.count), to: &body)
        appendLE(directoryOffset, to: &body)
        appendLE(UInt16(0), to: &body)
        do {
            try body.write(to: url, options: .atomic)
            return true
        } catch {
            return false
        }
    }

    // MARK: - Reading helpers

    /// One parsed central directory record.
    private struct CentralEntry {
        let name: String
        let method: UInt16
        let compressedSize: Int
        let uncompressedSize: Int
        let checksum: UInt32
        let localOffset: Int
        /// Offset of the next central directory record.
        let next: Int
    }

    /// Scans backwards for the end of central directory record.
    private static func findEndOfCentralDirectory(_ bytes: [UInt8]) -> Int? {
        guard bytes.count >= 22 else { return nil }
        let lowest = max(0, bytes.count - 22 - 0xFFFF)
        var offset = bytes.count - 22
        while offset >= lowest {
            if uint32(bytes, offset) == Signature.endOfCentralDirectory, looksLikeDirectory(bytes, at: offset) {
                return offset
            }
            offset -= 1
        }
        return nil
    }

    /// Cheap sanity check so a stray signature inside a comment is not taken
    /// for the real end of central directory record.
    private static func looksLikeDirectory(_ bytes: [UInt8], at offset: Int) -> Bool {
        guard let size = uint32(bytes, offset + 12), let start = uint32(bytes, offset + 16) else { return false }
        return Int(start) <= bytes.count && Int(size) <= bytes.count
    }

    private static func parseCentralEntry(_ bytes: [UInt8], at offset: Int) -> CentralEntry? {
        guard offset >= 0, offset + 46 <= bytes.count else { return nil }
        guard uint32(bytes, offset) == Signature.central else { return nil }
        guard let flags = uint16(bytes, offset + 8), let method = uint16(bytes, offset + 10),
              let checksum = uint32(bytes, offset + 16),
              let compressed = uint32(bytes, offset + 20), let uncompressed = uint32(bytes, offset + 24),
              let nameLength = uint16(bytes, offset + 28), let extraLength = uint16(bytes, offset + 30),
              let commentLength = uint16(bytes, offset + 32), let local = uint32(bytes, offset + 42) else { return nil }
        let nameStart = offset + 46
        let nameEnd = nameStart + Int(nameLength)
        guard nameEnd <= bytes.count else { return nil }
        let name = decodeName(Array(bytes[nameStart..<nameEnd]), utf8: (flags & utf8NameFlag) != 0)
        let next = nameEnd + Int(extraLength) + Int(commentLength)
        return CentralEntry(name: name,
                            method: method,
                            compressedSize: Int(compressed),
                            uncompressedSize: Int(uncompressed),
                            checksum: checksum,
                            localOffset: Int(local),
                            next: next)
    }

    /// Reads the payload of one entry, following its local file header.
    private static func extract(bytes: [UInt8],
                                localOffset: Int,
                                method: UInt16,
                                compressedSize: Int,
                                uncompressedSize: Int,
                                checksum: UInt32) -> Data? {
        guard localOffset >= 0, localOffset + 30 <= bytes.count else { return nil }
        guard uint32(bytes, localOffset) == Signature.local else { return nil }
        guard let nameLength = uint16(bytes, localOffset + 26), let extraLength = uint16(bytes, localOffset + 28) else { return nil }
        let start = localOffset + 30 + Int(nameLength) + Int(extraLength)
        let end = start + compressedSize
        guard start >= 0, start <= end, end <= bytes.count else { return nil }
        let raw = Data(bytes[start..<end])
        switch method {
        case 0:
            return raw
        case 8:
            return inflate(raw,
                           compressedSize: compressedSize,
                           uncompressedSize: uncompressedSize,
                           checksum: checksum)
        default:
            return nil
        }
    }

    /**
     * Inflates a deflate entry. Apple's COMPRESSION_ZLIB is raw deflate (no
     * zlib header), which is what a zip entry holds; a few writers still wrap
     * the stream, so the two-byte header is tried as a fallback and the
     * recorded CRC-32 decides which decoding was the right one.
     */
    private static func inflate(_ source: Data, compressedSize: Int, uncompressedSize: Int, checksum: UInt32) -> Data? {
        guard !source.isEmpty else { return Data() }
        if let data = decodeDeflate(source, compressedSize: compressedSize, uncompressedSize: uncompressedSize, skip: 0),
           matches(data, checksum) {
            return data
        }
        if let data = decodeDeflate(source, compressedSize: compressedSize, uncompressedSize: uncompressedSize, skip: 2),
           matches(data, checksum) {
            return data
        }
        return nil
    }

    /// Runs the raw deflate decoder, growing the destination buffer as needed.
    private static func decodeDeflate(_ source: Data,
                                      compressedSize: Int,
                                      uncompressedSize: Int,
                                      skip: Int) -> Data? {
        guard source.count > skip else { return nil }
        // Start with the size the archive promised; the compressed size is
        // only a fallback for archives that lie about it.
        var capacity = max(uncompressedSize, compressedSize * 4) + 1024
        for _ in 0..<8 {
            var destination = Data(count: capacity)
            let written = destination.withUnsafeMutableBytes { (destinationRaw: UnsafeMutableRawBufferPointer) -> Int in
                source.withUnsafeBytes { (sourceRaw: UnsafeRawBufferPointer) -> Int in
                    guard let destinationBase = destinationRaw.baseAddress,
                          let sourceBase = sourceRaw.baseAddress else { return 0 }
                    return compression_decode_buffer(destinationBase.assumingMemoryBound(to: UInt8.self),
                                                     destinationRaw.count,
                                                     sourceBase.assumingMemoryBound(to: UInt8.self).advanced(by: skip),
                                                     sourceRaw.count - skip,
                                                     nil,
                                                     COMPRESSION_ZLIB)
                }
            }
            if written > 0 {
                return destination.prefix(written)
            }
            // The buffer was too small; grow it and try again.
            capacity *= 2
        }
        return nil
    }

    /// A checksum of zero means the archive did not record one.
    private static func matches(_ data: Data, _ checksum: UInt32) -> Bool {
        checksum == 0 || crc32(data) == checksum
    }

    /**
     * Decodes an entry name. UTF-8 is used whenever the archive says so (and
     * as a lucky guess otherwise); broken bytes are replaced instead of
     * failing the whole entry.
     */
    private static func decodeName(_ bytes: [UInt8], utf8: Bool) -> String {
        if utf8 {
            return String(decoding: bytes, as: UTF8.self)
        }
        if let decoded = String(bytes: bytes, encoding: .utf8) {
            return decoded
        }
        // CP437 differs from Latin-1 only in 0x80...0x9F; keep it simple and
        // fall back to a lossy decode for those rare archives.
        return String(decoding: bytes, as: UTF8.self)
    }

    // MARK: - Byte helpers

    private static func uint16(_ bytes: [UInt8], _ offset: Int) -> UInt16? {
        guard offset >= 0, offset + 2 <= bytes.count else { return nil }
        return UInt16(bytes[offset]) | (UInt16(bytes[offset + 1]) << 8)
    }

    private static func uint32(_ bytes: [UInt8], _ offset: Int) -> UInt32? {
        guard offset >= 0, offset + 4 <= bytes.count else { return nil }
        return UInt32(bytes[offset])
            | (UInt32(bytes[offset + 1]) << 8)
            | (UInt32(bytes[offset + 2]) << 16)
            | (UInt32(bytes[offset + 3]) << 24)
    }

    private static func appendLE(_ value: UInt16, to data: inout Data) {
        data.append(UInt8(value & 0xFF))
        data.append(UInt8((value >> 8) & 0xFF))
    }

    private static func appendLE(_ value: UInt32, to data: inout Data) {
        data.append(UInt8(value & 0xFF))
        data.append(UInt8((value >> 8) & 0xFF))
        data.append(UInt8((value >> 16) & 0xFF))
        data.append(UInt8((value >> 24) & 0xFF))
    }
}
