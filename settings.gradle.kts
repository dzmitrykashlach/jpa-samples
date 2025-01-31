plugins {
    id("org.gradle.toolchains.foojay-resolver-convention") version "0.8.0"
}
rootProject.name = "jpa-samples"
include("transactions")
include("n-plus-1")
include("pagination")
include("long-jobs")
include("kafka-tx")
