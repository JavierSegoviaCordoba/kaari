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
                test {
                    dependencies {
                        implementation(cashTurbine())
                        implementation(russhwolfMultiplatformSettings())
                        implementation(russhwolfMultiplatformSettingsCoroutines())
                        implementation(russhwolfMultiplatformSettingsTest())
                    }
                }
            }
            android()
            jvm()
        }
    }
}
