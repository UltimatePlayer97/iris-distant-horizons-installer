package io.github.ultimateplayer97.`iris-dhinstaller`

import io.github.z4kn4fein.semver.Version
import io.github.z4kn4fein.semver.toVersion

enum class Loader(
    val dependencyName: String,
    val apiRoot: String,
    val addMods: (Version) -> Pair<String, String>
) {
    FABRIC("fabric-loader", "https://meta.fabricmc.net/v2", { Pair("fabric.addMods", "") }),
    NEOFORGE("neoforge", "https://maven.neoforged.net", { Pair("neoforge.addMods", "") });

    override fun toString() = name.lowercase()
}
