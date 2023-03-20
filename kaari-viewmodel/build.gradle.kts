hubdle {
    config {
        analysis()
        documentation {
            api()
        }
        explicitApi()
        languageSettings {
            experimentalCoroutinesApi()
        }
        publishing()
    }

    kotlin {
        multiplatform {
            features {
                compose()
                coroutines()
                molecule()
            }

            common {
                main {
                    dependencies {
                        api(projects.kaariPresentationCore)
                    }
                }
                test {
                    dependencies {
                        implementation(hubdle.cash.turbine.turbine)
                        implementation(hubdle.russhwolf.multiplatformSettings)
                        implementation(hubdle.russhwolf.multiplatformSettingsCoroutines)
                        implementation(hubdle.russhwolf.multiplatformSettingsTest)
                    }
                }
            }
            android {
                main {
                    dependencies {
                        api(hubdle.androidx.lifecycle.lifecycleViewmodelKtx)
                    }
                }
                testOptions {
                    unitTests.isReturnDefaultValues = true
                }
            }
            jvm()
        }
    }
}
