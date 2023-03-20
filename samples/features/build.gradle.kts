hubdle {
    config {
        languageSettings {
            optIn("androidx.compose.material3.ExperimentalMaterial3Api")
        }
        versioning {
            isEnabled.set(false)
        }
    }
    kotlin {
        multiplatform {
            features {
                coroutines()
                compose()
                molecule()
            }

            common {
                main {
                    dependencies {

                        implementation(projects.kaariViewmodel)
                        implementation(projects.samples.strategies)

                        @OptIn(org.jetbrains.compose.ExperimentalComposeLibrary::class)
                        implementation(compose.material3)
                        implementation(compose.preview)
                        implementation(compose.ui)
                        implementation(compose.uiTooling)

                        implementation(hubdle.cash.sqldelight.coroutinesExtensions)
                        implementation(hubdle.insert.koin.core)
                    }
                }
            }

            android {
                main {
                    dependencies {
                        implementation(hubdle.androidx.core.coreKtx)
                        implementation(hubdle.androidx.compose.material3.material3)
                        implementation(hubdle.androidx.compose.ui.ui)
                        implementation(hubdle.androidx.compose.ui.uiTooling)
                        implementation(hubdle.androidx.compose.ui.uiToolingPreview)
                    }
                }
            }
            jvm()
        }
    }
}
