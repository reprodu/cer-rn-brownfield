pluginManagement {
    repositories {
        gradlePluginPortal()
        google()
        mavenCentral()
    }
    includeBuild("../node_modules/@react-native/gradle-plugin")
}

dependencyResolutionManagement {
    repositories {
        google()
        mavenCentral()
    }
}

plugins { 
  id("com.facebook.react.settings") 
}
extensions.configure<com.facebook.react.ReactSettingsExtension> { autolinkLibrariesFromCommand() }
includeBuild("../node_modules/@react-native/gradle-plugin")

rootProject.name = ("kotlin-android-template")

enableFeaturePreview("TYPESAFE_PROJECT_ACCESSORS")

include(
    "app",
    "library-android",
    "library-compose",
    "library-kotlin"
)

includeBuild("../node_modules/react-native") {
    dependencySubstitution {
        substitute(module("com.facebook.react:react-android")).using(project(":packages:react-native:ReactAndroid"))
        substitute(module("com.facebook.react:react-native")).using(project(":packages:react-native:ReactAndroid"))
        substitute(module("com.facebook.react:hermes-android")).using(project(":packages:react-native:ReactAndroid:hermes-engine"))
        substitute(module("com.facebook.react:hermes-engine")).using(project(":packages:react-native:ReactAndroid:hermes-engine"))
    }
}