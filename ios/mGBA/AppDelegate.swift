import UIKit

@main
final class AppDelegate: UIResponder, UIApplicationDelegate {
    func application(_ application: UIApplication, didFinishLaunchingWithOptions launchOptions: [UIApplication.LaunchOptionsKey: Any]?) -> Bool {
        let docs = FileManager.default.urls(for: .documentDirectory, in: .userDomainMask)[0]
        let config = docs.appendingPathComponent("config", isDirectory: true)
        for name in ["saves", "states", "roms", "config/mgba"] {
            try? FileManager.default.createDirectory(at: docs.appendingPathComponent(name, isDirectory: true), withIntermediateDirectories: true)
        }
        setenv("HOME", docs.path, 1)
        setenv("XDG_CONFIG_HOME", config.path, 1)
        return true
    }

    func application(_ application: UIApplication, configurationForConnecting connectingSceneSession: UISceneSession, options: UIScene.ConnectionOptions) -> UISceneConfiguration {
        let config = UISceneConfiguration(name: "Default", sessionRole: connectingSceneSession.role)
        config.delegateClass = SceneDelegate.self
        return config
    }
}

final class SceneDelegate: UIResponder, UIWindowSceneDelegate {
    var window: UIWindow?

    func scene(_ scene: UIScene, willConnectTo session: UISceneSession, options connectionOptions: UIScene.ConnectionOptions) {
        guard let windowScene = scene as? UIWindowScene else { return }
        let window = UIWindow(windowScene: windowScene)
        window.rootViewController = EmulatorViewController()
        window.makeKeyAndVisible()
        self.window = window
    }
}
