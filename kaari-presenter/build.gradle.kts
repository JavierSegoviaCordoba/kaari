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
                        implementation(cashTurbine())
                        implementation(russhwolfMultiplatformSettings())
                        implementation(russhwolfMultiplatformSettingsCoroutines())
                        implementation(russhwolfMultiplatformSettingsTest())
                    }
                }
            }
            android {
                testOptions {
                    unitTests.isReturnDefaultValues = true
                }
            }
            jvm()
        }
    }
}
