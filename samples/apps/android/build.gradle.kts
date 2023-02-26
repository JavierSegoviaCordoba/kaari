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
        android {
            application {
                features {
                    compose()
                    molecule()
                }

                applicationId.set("com.javiersc.kaari.sample")

                main {
                    dependencies {
                        implementation(projects.kaariViewmodel)
                        implementation(projects.samples.features)
                        implementation(projects.samples.strategies)

                        implementation(androidxComposeMaterial3())
                        implementation(androidxComposeUi())
                        implementation(androidxComposeUiToolingPreview())
                        implementation(androidxComposeUi())
                        implementation(androidxCoreKtx())
                        implementation(androidxNavigationCompose())
                        implementation(insertKoinKoinAndroid())
                        implementation(insertKoinKoinAndroidxCompose())
                        implementation(insertKoinKoinCore())
                    }
                }

                test {
                    dependencies {
                        implementation(insertKoinKoinTest())
                        implementation(insertKoinKoinTestJunit4())
                    }
                }

                sourceSet("debug") {
                    dependencies {
                        implementation(androidxComposeUiTooling())
                    }
                }
            }
        }
    }
}
