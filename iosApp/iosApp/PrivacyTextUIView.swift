//
//  PrivacyTextUIView.swift
//  iosApp
//
//  Created by Oleksandr on 01.07.2025.
//

import SwiftUI
import ComposeApp

class IOSNativeViewFactory: NativeViewFactory {
    static var shared = IOSNativeViewFactory()
    func createPrivacyTextUIView(text: String) -> UIViewController {
        let view = PrivacyTextUIView(label: text)
        
        return UIHostingController(rootView: view)
    }
}

struct PrivacyTextUIView: View {
    var label: String
    var body: some View {
            Text(label).privacySensitive()
    }
}

#Preview {
    PrivacyTextUIView(label: "String")
}
