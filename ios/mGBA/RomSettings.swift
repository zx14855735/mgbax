/* This Source Code Form is subject to the terms of the Mozilla Public
 * License, v. 2.0. If a copy of the MPL was not distributed with this
 * file, You can obtain one at http://mozilla.org/MPL/2.0/. */
import Foundation

/// Per-game overrides, keyed by the ROM's CRC32, in the spirit of Pizza Boy's
/// rom_settings database: one row per (game, setting). Values are strings; the
/// caller parses them. The special value `default` means "use the global
/// preference".
///
/// The Android build keeps these rows in a SQLite table; here they live in
/// `UserDefaults`, one key per (game, setting). The key format and the value
/// format are the ones the Android side expects, so both ends agree on what a
/// checksum and a value mean.
final class RomSettings {
    /// The value that means "follow the global preference".
    static let defaultValue: String = "default"

    /// Every override key starts with this, then the checksum, then the name.
    private static let keyPrefix = "rom_setting_"

    private let defaults: UserDefaults

    init(defaults: UserDefaults = .standard) {
        self.defaults = defaults
    }

    /// Stored value for one setting of one game, or `fallback`.
    func get(_ checksum: UInt32, _ name: String, fallback: String) -> String {
        defaults.string(forKey: key(checksum, name)) ?? fallback
    }

    /// Stores one setting of one game.
    func put(_ checksum: UInt32, _ name: String, _ value: String) {
        defaults.set(value, forKey: key(checksum, name))
    }

    /// Clears every override of one game.
    func clear(_ checksum: UInt32) {
        // The trailing underscore keeps checksum 12 from matching 123.
        let prefix = Self.keyPrefix + String(checksum) + "_"
        for key in defaults.dictionaryRepresentation().keys where key.hasPrefix(prefix) {
            defaults.removeObject(forKey: key)
        }
    }

    private func key(_ checksum: UInt32, _ name: String) -> String {
        Self.keyPrefix + String(checksum) + "_" + name
    }

    /// CRC-32 of a ROM file, the same value java.util.zip.CRC32 produces.
    /// Returns nil when the file cannot be read.
    static func crc32(ofFile url: URL) -> UInt32? {
        guard let handle = try? FileHandle(forReadingFrom: url) else { return nil }
        defer { try? handle.close() }
        var crc: UInt32 = 0xFFFF_FFFF
        while true {
            let chunk: Data?
            do {
                // A short read is normal; only a nil or empty chunk ends the loop.
                chunk = try handle.read(upToCount: 65536)
            } catch {
                return nil
            }
            guard let chunk, !chunk.isEmpty else { break }
            let next = chunk.withUnsafeBytes { (raw: UnsafeRawBufferPointer) in update(crc, raw) }
            crc = next
        }
        return crc ^ 0xFFFF_FFFF
    }

    /// Reflected CRC-32 table for the polynomial 0xEDB88320.
    private static let table: [UInt32] = {
        var table = [UInt32](repeating: 0, count: 256)
        for i in 0..<256 {
            var value = UInt32(i)
            for _ in 0..<8 {
                value = (value & 1) != 0 ? (0xEDB8_8320 ^ (value >> 1)) : (value >> 1)
            }
            table[i] = value
        }
        return table
    }()

    /// Feeds bytes into the running CRC; `crc` is the not-yet-finalised value.
    private static func update(_ crc: UInt32, _ bytes: UnsafeRawBufferPointer) -> UInt32 {
        var crc = crc
        for byte in bytes {
            crc = table[Int((crc ^ UInt32(byte)) & 0xFF)] ^ (crc >> 8)
        }
        return crc
    }
}
