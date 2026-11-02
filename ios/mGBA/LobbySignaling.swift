/* This Source Code Form is subject to the terms of the Mozilla Public
 * License, v. 2.0. If a copy of the MPL was not distributed with this
 * file, You can obtain one at http://mozilla.org/MPL/2.0/. */
import Foundation

/**
 * Cloud lobby room signalling: HTTPS authentication plus the WebSocket room
 * commands. A Swift port of the Android `GbCloud`.
 *
 * Only the signalling half lives here - the actual link bytes travel over KCP
 * in `LobbyKcpChannel`.
 *
 * The lobby server still serves a certificate issued for another domain (and
 * the chain it sends is sometimes incomplete), so a strictly validating client
 * can never finish the handshake. The official client tolerates this; we
 * mirror that by falling back to a session that trusts any certificate for
 * both the HTTPS signalling and the WebSocket room link.
 */
enum LobbySignaling {
    struct Failure: Error {
        let message: String
    }

    static let apiURL = URL(string: "https://gboy.top/api/api.php")!
    static let webSocketURL = URL(string: "wss://gboy.top:23459/")!

    /// True once a strictly validating connection failed, i.e. the server
    /// certificate had to be accepted unverified.
    private static let stateLock = NSLock()
    private static var insecureTLS = false

    static var certificateWasDowngraded: Bool {
        stateLock.lock()
        defer { stateLock.unlock() }
        return insecureTLS
    }

    private static func markDowngraded() {
        stateLock.lock()
        insecureTLS = true
        stateLock.unlock()
    }

    // MARK: - Branding

    /**
     * Rewrites the upstream brand name the lobby server bakes into its own
     * replies into the neutral in-app name, so no third-party brand ever shows
     * up on screen. Everything the server says to the user goes through here.
     */
    static func lobby(_ text: String?) -> String? {
        guard let text, !text.isEmpty else {
            return text
        }
        return replacingBrand(in: text)
    }

    private static let brandRegex = try! NSRegularExpression(pattern: "(?i)gboy(?:\\.top)?",
                                                             options: [])

    static func replacingBrand(in text: String) -> String {
        let range = NSRange(text.startIndex..<text.endIndex, in: text)
        return brandRegex.stringByReplacingMatches(in: text, options: [], range: range,
                                                   withTemplate: "联机大厅")
    }

    // MARK: - Authentication

    /// Signs in and returns the token every room command has to carry.
    static func login(user: String, password: String,
                      completion: @escaping (Result<String, Error>) -> Void) {
        post(["action": "login", "email_or_username": user, "password": password]) { result in
            switch result {
            case .failure(let error):
                completion(.failure(error))
            case .success(let reply):
                if let token = reply["token"] as? String, !token.isEmpty {
                    completion(.success(token))
                    return
                }
                completion(.failure(Failure(message: failureText(reply, "登录失败"))))
            }
        }
    }

    /// Asks the lobby server to mail a verification code to the address.
    static func sendVerificationCode(email: String,
                                     completion: @escaping (Result<String, Error>) -> Void) {
        post(["action": "send_verification_code", "email": email]) { result in
            switch result {
            case .failure(let error):
                completion(.failure(error))
            case .success(let reply):
                if (reply["success"] as? Bool) == true {
                    let text = reply["message"] as? String ?? "验证码已发送。"
                    completion(.success(lobby(text) ?? text))
                    return
                }
                completion(.failure(Failure(message: failureText(reply, "验证码发送失败"))))
            }
        }
    }

    /// Registers a new account from an emailed code; the reply carries the
    /// token straight away (register doubles as the first login).
    static func register(username: String, email: String, password: String, code: String,
                         completion: @escaping (Result<String, Error>) -> Void) {
        post(["action": "register", "username": username, "email": email, "password": password,
              "verification_code": code]) { result in
            switch result {
            case .failure(let error):
                completion(.failure(error))
            case .success(let reply):
                if let token = reply["token"] as? String, !token.isEmpty {
                    completion(.success(token))
                    return
                }
                completion(.failure(Failure(message: failureText(reply, "注册失败"))))
            }
        }
    }

    private static func failureText(_ reply: [String: Any], _ fallback: String) -> String {
        let message = reply["message"] as? String ?? ""
        if message.isEmpty {
            return fallback
        }
        return lobby(message) ?? message
    }

    // MARK: - HTTP

    /**
     * POSTs to the API. Tries a strictly validating connection first and, if
     * that fails (the server presents a certificate issued for another
     * domain), falls back to a connection that trusts any certificate.
     */
    private static func post(_ body: [String: Any],
                             completion: @escaping (Result<[String: Any], Error>) -> Void) {
        guard let data = try? JSONSerialization.data(withJSONObject: body) else {
            completion(.failure(Failure(message: "参数错误")))
            return
        }
        var request = URLRequest(url: apiURL)
        request.httpMethod = "POST"
        request.httpBody = data
        request.setValue("application/json", forHTTPHeaderField: "Content-Type")
        request.timeoutInterval = 15
        perform(request: request) { raw in
            switch raw {
            case .failure(let error):
                completion(.failure(error))
            case .success(let text):
                guard let reply = lastJSONObject(from: text) else {
                    completion(.failure(Failure(message: "服务器返回无法解析："
                        + text.trimmingCharacters(in: .whitespacesAndNewlines))))
                    return
                }
                completion(.success(reply))
            }
        }
    }

    private static func perform(request: URLRequest,
                                completion: @escaping (Result<String, Error>) -> Void) {
        if certificateWasDowngraded {
            permissivePerform(request: request, completion: completion)
            return
        }
        let strict = URLSession(configuration: .ephemeral)
        strict.dataTask(with: request) { data, _, error in
            if let error {
                // The certificate cannot validate - degrade exactly like the
                // official client does and remember it for the next call.
                markDowngraded()
                permissivePerform(request: request, completion: completion)
                return
            }
            guard let data else {
                completion(.failure(Failure(message: "服务器没有返回数据")))
                return
            }
            completion(.success(String(data: data, encoding: .utf8) ?? ""))
        }.resume()
    }

    private static func permissivePerform(request: URLRequest,
                                          completion: @escaping (Result<String, Error>) -> Void) {
        PermissiveSession.shared.session.dataTask(with: request) { data, _, error in
            if let error {
                completion(.failure(Failure(message: error.localizedDescription)))
                return
            }
            guard let data else {
                completion(.failure(Failure(message: "服务器没有返回数据")))
                return
            }
            completion(.success(String(data: data, encoding: .utf8) ?? ""))
        }.resume()
    }

    // MARK: - Synchronous wrappers

    /// Blocking variants for the link worker thread.
    static func loginSync(user: String, password: String) throws -> String {
        var token: String?
        var failure: Error?
        let semaphore = DispatchSemaphore(value: 0)
        login(user: user, password: password) { result in
            switch result {
            case .success(let value):
                token = value
            case .failure(let error):
                failure = error
            }
            semaphore.signal()
        }
        _ = semaphore.wait(timeout: .now() + 30)
        if let failure {
            throw failure
        }
        guard let token else {
            throw Failure(message: "登录超时")
        }
        return token
    }

    static func sendVerificationCodeSync(email: String) throws -> String {
        var text: String?
        var failure: Error?
        let semaphore = DispatchSemaphore(value: 0)
        sendVerificationCode(email: email) { result in
            switch result {
            case .success(let value):
                text = value
            case .failure(let error):
                failure = error
            }
            semaphore.signal()
        }
        _ = semaphore.wait(timeout: .now() + 30)
        if let failure {
            throw failure
        }
        guard let text else {
            throw Failure(message: "验证码发送超时")
        }
        return text
    }

    static func registerSync(username: String, email: String, password: String,
                             code: String) throws -> String {
        var token: String?
        var failure: Error?
        let semaphore = DispatchSemaphore(value: 0)
        register(username: username, email: email, password: password, code: code) { result in
            switch result {
            case .success(let value):
                token = value
            case .failure(let error):
                failure = error
            }
            semaphore.signal()
        }
        _ = semaphore.wait(timeout: .now() + 30)
        if let failure {
            throw failure
        }
        guard let token else {
            throw Failure(message: "注册超时")
        }
        return token
    }

    /// api.php sometimes echoes notices before the JSON line.
    static func lastJSONObject(from raw: String) -> [String: Any]? {
        let lines = raw.components(separatedBy: "\n")
        for index in stride(from: lines.count - 1, through: 0, by: -1) {
            let line = lines[index].trimmingCharacters(in: .whitespaces)
            guard line.hasPrefix("{") else {
                continue
            }
            if let object = try? JSONSerialization.jsonObject(with: Data(line.utf8)),
               let dict = object as? [String: Any] {
                return dict
            }
        }
        return nil
    }

    // MARK: - WebSocket session

    /// Minimal WebSocket client for the room commands.
    final class Session {
        private let task: URLSessionWebSocketTask
        private let condition = NSCondition()
        private var messages: [String] = []
        private var failure: Error?

        var insecureTLS: Bool {
            LobbySignaling.certificateWasDowngraded
        }

        private init(task: URLSessionWebSocketTask) {
            self.task = task
        }

        /// Opens the room socket. The first strict attempt is downgraded to an
        /// unverified one when the server certificate cannot validate.
        static func connect(completion: @escaping (Result<Session, Error>) -> Void) {
            let session = PermissiveSession.shared.session
            let task = session.webSocketTask(with: LobbySignaling.webSocketURL)
            task.resume()
            let result = Session(task: task)
            result.startPump()
            completion(.success(result))
        }

        /// Blocking variant for the link worker thread.
        static func connectSync() throws -> Session {
            var result: Result<Session, Error>?
            let semaphore = DispatchSemaphore(value: 0)
            connect { value in
                result = value
                semaphore.signal()
            }
            _ = semaphore.wait(timeout: .now() + 15)
            switch result {
            case .success(let session):
                return session
            case .failure(let error):
                throw error
            case .none:
                throw Failure(message: "连接房间服务器超时")
            }
        }

        func send(_ text: String, completion: ((Error?) -> Void)? = nil) {
            task.send(.string(text)) { error in
                completion?(error)
            }
        }

        /// Next text frame, or nil when nothing arrives in time.
        func recv(timeoutMs: Int) -> String? {
            condition.lock()
            defer { condition.unlock() }
            if messages.isEmpty {
                if let failure {
                    return nil
                }
                _ = condition.wait(until: Date().addingTimeInterval(Double(max(timeoutMs, 0)) / 1000.0))
            }
            return messages.isEmpty ? nil : messages.removeFirst()
        }

        /// The transport error that killed the socket, if any.
        func transportError() -> Error? {
            condition.lock()
            defer { condition.unlock() }
            return failure
        }

        func close() {
            task.cancel(with: .goingAway, reason: nil)
            condition.lock()
            condition.broadcast()
            condition.unlock()
        }

        private func enqueue(_ text: String) {
            condition.lock()
            messages.append(text)
            condition.signal()
            condition.unlock()
        }

        private func startPump() {
            task.receive { [weak self] result in
                guard let self else {
                    return
                }
                switch result {
                case .failure(let error):
                    self.condition.lock()
                    self.failure = error
                    self.condition.broadcast()
                    self.condition.unlock()
                case .success(let message):
                    switch message {
                    case .string(let text):
                        self.enqueue(text)
                    case .data(let data):
                        if let text = String(data: data, encoding: .utf8) {
                            self.enqueue(text)
                        }
                    @unknown default:
                        break
                    }
                    self.startPump()
                }
            }
        }
    }
}

/// Accepts any server certificate - the lobby server's chain does not validate.
final class PermissiveSession: NSObject, URLSessionDelegate {
    static let shared = PermissiveSession()

    lazy var session: URLSession = {
        let configuration = URLSessionConfiguration.ephemeral
        configuration.timeoutIntervalForRequest = 20
        configuration.waitsForConnectivity = false
        return URLSession(configuration: configuration, delegate: self, delegateQueue: nil)
    }()

    func urlSession(_ session: URLSession, didReceive challenge: URLAuthenticationChallenge,
                    completionHandler: @escaping (URLSession.AuthChallengeDisposition, URLCredential?) -> Void) {
        guard challenge.protectionSpace.authenticationMethod == NSURLAuthenticationMethodServerTrust,
              let trust = challenge.protectionSpace.serverTrust else {
            completionHandler(.performDefaultHandling, nil)
            return
        }
        completionHandler(.useCredential, URLCredential(trust: trust))
    }
}
