//
//  PrivacyBoxUIView.swift
//  iosApp
//
//  Created by Oleksandr on 01.07.2025.
//

import SwiftUI
import ComposeApp

class IOSNativeViewFactory: NativeViewFactory {
    static var shared = IOSNativeViewFactory()
    func createPrivacyBoxUIView(text: String) -> UIViewController {
        let view = PrivacyBoxUIView(label: text)
        
        return UIHostingController(rootView: view)
    }
}

struct PrivacyBoxUIView: View {
    var label: String
    var body: some View {
            Text(label).privacySensitive()
    }
}

#Preview {
    PrivacyBoxUIView(label: "String")
}
