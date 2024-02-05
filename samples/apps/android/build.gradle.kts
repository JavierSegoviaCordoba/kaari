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

                        implementation(hubdle.androidx.compose.material3)
                        implementation(hubdle.androidx.compose.ui)
                        implementation(hubdle.androidx.compose.ui.tooling.preview)
                        implementation(hubdle.androidx.core.ktx)
                        implementation(hubdle.androidx.navigation.compose)
                        implementation(hubdle.insert.koin.android)
                        implementation(hubdle.insert.koin.androidx.compose)
                        implementation(hubdle.insert.koin.core)
                    }
                }

                test {
                    dependencies {
                        implementation(hubdle.insert.koin.test)
                        implementation(hubdle.insert.koin.test.junit4)
                    }
                }

                sourceSet("debug") {
                    dependencies {
                        implementation(hubdle.androidx.compose.ui.tooling)
                    }
                }
            }
        }
    }
}
