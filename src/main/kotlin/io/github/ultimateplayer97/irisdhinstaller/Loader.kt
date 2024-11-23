package io.github.ultimateplayer97.irisdhinstaller

import io.github.z4kn4fein.semver.Version

enum class Loader(
    val dependencyName: String,
    val apiRoot: String,
    val addMods: (Version) -> Pair<String, String>
) {
    FABRIC("fabric-loader", "https://meta.fabricmc.net/v2", { Pair("fabric.addMods", "") }),
    NEOFORGE("neoforge", "https://maven.neoforged.net", { Pair("neoforge.addMods", "") }); // TODO: Add Neoforge support

    override fun toString() = name.lowercase()
}
