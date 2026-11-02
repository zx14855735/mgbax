/* This Source Code Form is subject to the terms of the Mozilla Public
 * License, v. 2.0. If a copy of the MPL was not distributed with this
 * file, You can obtain one at http://mozilla.org/MPL/2.0/. */
import Foundation

/// Battery-save sync over WebDAV, ported from the Android `WebDavSync`
/// (which itself came from 悠GBA模拟器, 坚果云 by default).
///
/// Each side compares modification times and keeps the newer copy: remote
/// files newer than the local ones are downloaded, local ones newer are
/// uploaded. Only `*.sav` / `*.saN` battery saves participate; save states
/// stay local.
///
/// All HTTP happens on the caller's thread; the caller runs this in the
/// background and shows the result.
enum WebDavSync {
    static let defaultURL = "https://dav.jianguoyun.com/dav/"
    static let defaultDir = "mGBAx"

    /// Connection details, stored in the app's defaults.
    struct Config {
        var url = defaultURL
        var dir = defaultDir
        var user = ""
        var pass = ""

        var isComplete: Bool {
            !url.trimmingCharacters(in: .whitespaces).isEmpty
                && !user.trimmingCharacters(in: .whitespaces).isEmpty
                && !pass.trimmingCharacters(in: .whitespaces).isEmpty
        }

        static func load(_ defaults: UserDefaults) -> Config {
            var config = Config()
            config.url = (defaults.string(forKey: "sync_url") ?? defaultURL)
                .trimmingCharacters(in: .whitespaces)
            config.dir = (defaults.string(forKey: "sync_dir") ?? defaultDir)
                .trimmingCharacters(in: .whitespaces)
            config.user = (defaults.string(forKey: "sync_user") ?? "")
                .trimmingCharacters(in: .whitespaces)
            config.pass = defaults.string(forKey: "sync_pass") ?? ""
            return config
        }

        func store(_ defaults: UserDefaults) {
            defaults.set(url, forKey: "sync_url")
            defaults.set(dir, forKey: "sync_dir")
            defaults.set(user, forKey: "sync_user")
            defaults.set(pass, forKey: "sync_pass")
        }
    }

    /// What one sync run did.
    struct Summary {
        var uploaded = 0
        var downloaded = 0
        var errors: [String] = []

        var text: String {
            var parts = ["上传 \(uploaded) 个", "下载 \(downloaded) 个"]
            if !errors.isEmpty {
                parts.append("失败 \(errors.count) 个")
            }
            return parts.joined(separator: "，")
        }
    }

    enum Failure: LocalizedError {
        case notConfigured
        case http(Int)

        var errorDescription: String? {
            switch self {
            case .notConfigured:
                return "请先填写同步地址、账号和密码"
            case .http(let code):
                return "服务器返回 \(code)"
            }
        }
    }

    /// Runs one bidirectional sync of the battery saves.
    static func run(saves: URL, config: Config) throws -> Summary {
        guard config.isComplete else {
            throw Failure.notConfigured
        }
        var base = config.url
        if !base.hasSuffix("/") {
            base += "/"
        }
        let folderUrl = base + encoded(config.dir)
        var summary = Summary()

        // 远端没有这个目录就建一个（已经存在时忽略）
        _ = perform("MKCOL", folderUrl, nil, config)

        let remote = list(folderUrl + "/", config)
        let names = (try? FileManager.default.contentsOfDirectory(at: saves,
                                                                 includingPropertiesForKeys: [.contentModificationDateKey])) ?? []
        let battery = names.filter { isBatterySave($0.lastPathComponent) }

        for file in battery {
            let name = file.lastPathComponent
            let found = remote.first { $0.name.caseInsensitiveCompare(name) == .orderedSame }
            let local = modificationDate(file)
            if found == nil {
                // 只在本地有：上传
                if put(folderUrl + "/" + encoded(name), file, config) {
                    summary.uploaded += 1
                } else {
                    summary.errors.append(name)
                }
                continue
            }
            let remoteTime = found!.mtime
            if local > remoteTime.addingTimeInterval(0.999) {
                if put(folderUrl + "/" + encoded(name), file, config) {
                    summary.uploaded += 1
                } else {
                    summary.errors.append(name)
                }
            } else if remoteTime > local.addingTimeInterval(0.999) {
                if get(folderUrl + "/" + encoded(name), file, config, remoteTime) {
                    summary.downloaded += 1
                } else {
                    summary.errors.append(name)
                }
            }
        }

        // 远端有、本地还没有的存档下来（换设备的情况）
        for entry in remote where isBatterySave(entry.name) {
            let exists = battery.contains { $0.lastPathComponent.caseInsensitiveCompare(entry.name) == .orderedSame }
            if !exists {
                let destination = saves.appendingPathComponent(entry.name)
                if get(folderUrl + "/" + encoded(entry.name), destination, config, entry.mtime) {
                    summary.downloaded += 1
                }
            }
        }
        return summary
    }

    // MARK: - HTTP

    private struct RemoteFile {
        let name: String
        let mtime: Date
    }

    private static func perform(_ method: String, _ url: String, _ body: Data?,
                                _ config: Config) -> (Int, Data)? {
        guard let target = URL(string: url) else {
            return nil
        }
        var request = URLRequest(url: target)
        request.httpMethod = method
        request.timeoutInterval = 30
        request.setValue("Basic " + Data("\(config.user):\(config.pass)".utf8).base64EncodedString(),
                         forHTTPHeaderField: "Authorization")
        if let body {
            request.httpBody = body
            request.setValue("application/octet-stream", forHTTPHeaderField: "Content-Type")
        }
        var result: (Int, Data)?
        let semaphore = DispatchSemaphore(value: 0)
        URLSession.shared.dataTask(with: request) { data, response, _ in
            let code = (response as? HTTPURLResponse)?.statusCode ?? 0
            result = (code, data ?? Data())
            semaphore.signal()
        }.resume()
        _ = semaphore.wait(timeout: .now() + 60)
        return result
    }

    /// PROPFIND depth-1 listing of one folder.
    private static func list(_ url: String, _ config: Config) -> [RemoteFile] {
        guard let target = URL(string: url) else {
            return []
        }
        var request = URLRequest(url: target)
        request.httpMethod = "PROPFIND"
        request.timeoutInterval = 30
        request.setValue("Basic " + Data("\(config.user):\(config.pass)".utf8).base64EncodedString(),
                         forHTTPHeaderField: "Authorization")
        request.setValue("1", forHTTPHeaderField: "Depth")
        request.setValue("application/xml", forHTTPHeaderField: "Content-Type")
        request.httpBody = Data("<?xml version=\"1.0\"?><D:propfind xmlns:D=\"DAV:\"><D:prop>"
            .utf8) + Data("<D:getlastmodified/><D:getcontentlength/></D:prop></D:propfind>".utf8)
        var body = Data()
        var code = 0
        let semaphore = DispatchSemaphore(value: 0)
        URLSession.shared.dataTask(with: request) { data, response, _ in
            code = (response as? HTTPURLResponse)?.statusCode ?? 0
            body = data ?? Data()
            semaphore.signal()
        }.resume()
        _ = semaphore.wait(timeout: .now() + 60)
        if code == 404 {
            return []   // 空目录
        }
        guard code == 207, let text = String(data: body, encoding: .utf8) else {
            return []
        }
        let parser = PropfindParser()
        parser.parse(text)
        return parser.files
    }

    private static func put(_ url: String, _ file: URL, _ config: Config) -> Bool {
        guard let data = try? Data(contentsOf: file) else {
            return false
        }
        guard let (code, _) = perform("PUT", url, data, config) else {
            return false
        }
        return code == 200 || code == 201 || code == 204
    }

    private static func get(_ url: String, _ destination: URL, _ config: Config, _ mtime: Date) -> Bool {
        guard let target = URL(string: url) else {
            return false
        }
        var request = URLRequest(url: target)
        request.httpMethod = "GET"
        request.timeoutInterval = 60
        request.setValue("Basic " + Data("\(config.user):\(config.pass)".utf8).base64EncodedString(),
                         forHTTPHeaderField: "Authorization")
        var payload = Data()
        var code = 0
        let semaphore = DispatchSemaphore(value: 0)
        URLSession.shared.dataTask(with: request) { data, response, _ in
            code = (response as? HTTPURLResponse)?.statusCode ?? 0
            payload = data ?? Data()
            semaphore.signal()
        }.resume()
        _ = semaphore.wait(timeout: .now() + 90)
        guard code == 200 else {
            return false
        }
        let temporary = destination.deletingLastPathComponent()
            .appendingPathComponent(destination.lastPathComponent + ".sync-tmp")
        do {
            try payload.write(to: temporary, options: .atomic)
            let manager = FileManager.default
            if manager.fileExists(atPath: destination.path) {
                try? manager.removeItem(at: destination)
            }
            try manager.moveItem(at: temporary, to: destination)
            try? manager.setAttributes([.modificationDate: mtime], ofItemAtPath: destination.path)
            return true
        } catch {
            try? FileManager.default.removeItem(at: temporary)
            return false
        }
    }

    // MARK: - Helpers

    private static func isBatterySave(_ name: String) -> Bool {
        let lower = name.lowercased()
        if lower.hasSuffix(".sav") {
            return true
        }
        return lower.range(of: #"\.sa\d$"#, options: .regularExpression) != nil
    }

    private static func encoded(_ segment: String) -> String {
        var allowed = CharacterSet.urlPathAllowed
        allowed.remove(charactersIn: "/?#[]@!$&'()*+,;=")
        return segment.addingPercentEncoding(withAllowedCharacters: allowed) ?? segment
    }

    private static func modificationDate(_ url: URL) -> Date {
        let values = try? url.resourceValues(forKeys: [.contentModificationDateKey])
        return values?.contentModificationDate ?? Date.distantPast
    }

    /// Reads the two properties we need out of a multistatus body. Namespace
    /// prefixes differ between servers, so the element names are matched on
    /// their local part.
    private final class PropfindParser: NSObject, XMLParserDelegate {
        var files: [RemoteFile] = []

        private var insideResponse = false
        private var currentElement = ""
        private var href = ""
        private var modified = ""
        private var pending: [String: String] = [:]

        func parse(_ text: String) {
            let parser = XMLParser(data: Data(text.utf8))
            parser.delegate = self
            parser.shouldProcessNamespaces = false
            parser.parse()
        }

        func parser(_ parser: XMLParser, didStartElement elementName: String,
                    namespaceURI: String?, qualifiedName qName: String?,
                    attributes attributeDict: [String: String] = [:]) {
            let name = elementName.lowercased()
            currentElement = name
            if name == "response" {
                insideResponse = true
                href = ""
                modified = ""
            }
        }

        func parser(_ parser: XMLParser, foundCharacters string: String) {
            guard insideResponse else {
                return
            }
            if currentElement == "href" {
                href += string
            } else if currentElement == "getlastmodified" {
                modified += string
            }
        }

        func parser(_ parser: XMLParser, didEndElement elementName: String,
                    namespaceURI: String?, qualifiedName qName: String?) {
            let name = elementName.lowercased()
            if name == "response" {
                insideResponse = false
                add()
            }
            currentElement = ""
        }

        private func add() {
            let trimmed = href.trimmingCharacters(in: .whitespacesAndNewlines)
            guard !trimmed.isEmpty, !trimmed.hasSuffix("/") else {
                return
            }
            let rawName = trimmed.split(separator: "/").last.map(String.init) ?? ""
            let name = rawName.removingPercentEncoding ?? rawName
            guard !name.isEmpty else {
                return
            }
            let formatter = DateFormatter()
            formatter.locale = Locale(identifier: "en_US_POSIX")
            formatter.timeZone = TimeZone(identifier: "GMT")
            formatter.dateFormat = "EEE, dd MMM yyyy HH:mm:ss 'GMT'"
            let date = formatter.date(from: modified.trimmingCharacters(in: .whitespacesAndNewlines))
                ?? Date.distantPast
            files.append(RemoteFile(name: name, mtime: date))
        }
    }
}
