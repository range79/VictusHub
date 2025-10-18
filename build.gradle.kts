
version = "1.0"

tasks.register<Copy>("victusBuild") {
    dependsOn(
        ":Victushub-gui:nativeBuild",
        ":VictusService:nativeBuild"
    )


    from("Victushub-gui/build/gluonfx/x86_64-linux/Victushub-gui") {
        into("")
    }


    from("VictusService/build/native/nativeCompile/VictusService") {
        into("/")
    }


    destinationDir = file("Installer")
    includeEmptyDirs = false
}
