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
                        implementation(hubdle.cash.turbine)
                        implementation(hubdle.russhwolf.multiplatform.settings)
                        implementation(hubdle.russhwolf.multiplatform.settings.coroutines)
                        implementation(hubdle.russhwolf.multiplatform.settings.test)
                    }
                }
            }
            android()
            jvm()
        }
    }
}
