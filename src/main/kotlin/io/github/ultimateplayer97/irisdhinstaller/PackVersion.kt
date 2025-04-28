package io.github.ultimateplayer97.irisdhinstaller

import com.google.gson.JsonObject
import java.nio.file.Path

class PackVersion(val modpack: Modpack, val data: JsonObject) {
    val packVersion: String
    val gameVersion: String
    val loader: Loader

    init {
        val versionNumber = data["version_number"].asString
        loader = if ('-' in versionNumber && '+' !in versionNumber) {
            packVersion = versionNumber.substringBefore('-')
            gameVersion = versionNumber.substringAfterLast('-')
            if (versionNumber.count { it == '-' } > 1) {
                versionNumber.substringAfter('-').substringBeforeLast('-')
            } else {
                "FABRIC"
            }
        } else {
            packVersion = versionNumber.substringBefore('+')
            gameVersion = versionNumber.substringAfter('+').substringBeforeLast('.')
            versionNumber.substringAfterLast('.')
        }.uppercase().let(Loader::valueOf)
    }

    val launcherFolderPath = "${modpack.id}/$packVersion-$gameVersion-$loader"
    val launcherVersionId = "${modpack.id}-$packVersion-$gameVersion-$loader"
    val launcherProfileId = "${modpack.id}-$gameVersion-$loader"

    fun install(destination: Path, javaArgs: String, progressHandler: ProgressHandler) {
        PackInstaller(
            packVersion = this,
            destination = destination,
            progressHandler = progressHandler,
            javaArgs = javaArgs
        ).use(PackInstaller::install)
    }
}

