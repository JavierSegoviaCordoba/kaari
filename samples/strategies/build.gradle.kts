plugins { alias(libs.plugins.javiersc.hubdle) }

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
                        implementation(cashSqldelightCoroutinesExtensions())
                        implementation(insertKoinKoinCore())
                        implementation(ktorClientCore())
                        implementation(ktorClientOkhttp())
                    }
                }
            }
            android {
                main {
                    dependencies {
                        implementation(cashSqldelightAndroidDriver())
                        implementation(cashSqldelightSqliteDriver())
                    }
                }
            }
            jvm {
                main {
                    dependencies {
                        implementation(cashSqldelightJdbcDriver())
                        implementation(cashSqldelightSqliteDriver())
                    }
                }
            }
        }
    }
}
