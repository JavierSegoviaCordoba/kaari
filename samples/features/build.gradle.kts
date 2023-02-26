plugins {
    alias(libs.plugins.javiersc.hubdle)
}

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

                        implementation(cashSqldelightCoroutinesExtensions())
                        implementation(insertKoinKoinCore())
                    }
                }
            }

            android {
                main {
                    dependencies {
                        implementation(androidxCoreKtx())
                        implementation(androidxComposeMaterial3())
                        implementation(androidxComposeUi())
                        implementation(androidxComposeUiTooling())
                        implementation(androidxComposeUiToolingPreview())
                    }
                }
            }
            jvm()
        }
    }
}
