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
                        implementation(hubdle.cash.sqldelight.coroutinesExtensions)
                        implementation(hubdle.insert.koin.core)
                        implementation(hubdle.ktor.ktorClientCore)
                        implementation(hubdle.ktor.ktorClientOkHttp)
                    }
                }
            }
            android {
                main {
                    dependencies {
                        implementation(hubdle.cash.sqldelight.androidDriver)
                        implementation(hubdle.cash.sqldelight.sqliteDriver)
                    }
                }
            }
            jvm {
                main {
                    dependencies {
                        implementation(hubdle.cash.sqldelight.jdbcDriver)
                        implementation(hubdle.cash.sqldelight.sqliteDriver)
                    }
                }
            }
        }
    }
}
