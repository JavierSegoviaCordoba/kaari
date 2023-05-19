hubdle {
    config {
        analysis()
        coverage()
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
                test {
                    dependencies {
                        implementation(hubdle.cash.turbine.turbine)
                        implementation(hubdle.russhwolf.multiplatformSettings)
                        implementation(hubdle.russhwolf.multiplatformSettingsCoroutines)
                        implementation(hubdle.russhwolf.multiplatformSettingsTest)
                    }
                }
            }
            android()
            jvm()
        }
    }
}
