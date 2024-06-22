package com.github.cpjinan.plugin.akarilevel.internal

import com.github.cpjinan.plugin.akarilevel.AkariLevel.plugin
import com.github.cpjinan.plugin.akarilevel.common.listener.MythicMobsListener
import com.github.cpjinan.plugin.akarilevel.utils.ConfigUtil.saveDefaultResource
import com.github.cpjinan.plugin.akarilevel.utils.FileUtil
import com.github.cpjinan.plugin.akarilevel.utils.LoggerUtil
import com.github.cpjinan.plugin.akarilevel.utils.UpdateUtil
import taboolib.common.LifeCycle
import taboolib.common.platform.Awake
import taboolib.common.platform.Platform
import taboolib.common.platform.function.console
import taboolib.module.chat.colored
import taboolib.module.lang.asLangText
import taboolib.module.lang.sendLang
import taboolib.module.metrics.Metrics
import java.io.File

object PluginLoader {
    @Awake(LifeCycle.LOAD)
    fun load() {
        console().sendLang("Plugin-Loading", plugin.description.version)
        Metrics(18992, plugin.description.version, Platform.BUKKIT)
    }

    @Awake(LifeCycle.ENABLE)
    fun enable() {
        LoggerUtil.message(
            "",
            "&o     _    _              _ _                   _  ".colored(),
            "&o    / \\  | | ____ _ _ __(_) |    _____   _____| | ".colored(),
            "&o   / _ \\ | |/ / _` | '__| | |   / _ \\ \\ / / _ \\ | ".colored(),
            "&o  / ___ \\|   < (_| | |  | | |__|  __/\\ V /  __/ | ".colored(),
            "&o /_/   \\_\\_|\\_\\__,_|_|  |_|_____\\___| \\_/ \\___|_| ".colored(),
            ""
        )
        MythicMobsListener.registerMythicMobsListener()
        plugin.saveDefaultResource(
            "level/Example_${console().asLangText("Language")}.yml",
            File(FileUtil.dataFolder, "level/Example.yml")
        )
        console().sendLang("Plugin-Enabled")
        UpdateUtil.getPluginNotice()
        UpdateUtil.getPluginUpdate()
        UpdateUtil.getConfigUpdate()
    }

    @Awake(LifeCycle.DISABLE)
    fun disable() {
        console().sendLang("Plugin-Disable")
    }

}