hubdle {
    config {
        languageSettings { experimentalSerializationApi() }
        versioning { isEnabled.set(false) }
    }
    kotlin {
        multiplatform {
            features {
                coroutines()
                serialization()
                sqldelight {
                    databases {
                        register("KaariDatabase") {
                            packageName.set("com.javiersc.kaari.samples.strategies.internal")
                        }
                    }
                }
            }
            common {
                main {
                    dependencies {
                        implementation(hubdle.cash.sqldelight.coroutines.extensions)
                        implementation(hubdle.insert.koin.core)
                        implementation(hubdle.ktor.client.core)
                        implementation(hubdle.ktor.client.okhttp)
                    }
                }
            }
            android {
                main {
                    dependencies {
                        implementation(hubdle.cash.sqldelight.android.driver)
                        implementation(hubdle.cash.sqldelight.sqlite.driver)
                    }
                }
            }
            jvm {
                main {
                    dependencies {
                        implementation(hubdle.cash.sqldelight.jdbc.driver)
                        implementation(hubdle.cash.sqldelight.sqlite.driver)
                    }
                }
            }
        }
    }
}
