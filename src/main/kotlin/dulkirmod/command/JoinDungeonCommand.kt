package dulkirmod.command

import dulkirmod.config.Config
import dulkirmod.utils.TextUtils
import net.minecraft.command.CommandException
import net.minecraft.command.ICommandSender

class JoinDungeonCommand : ClientCommandBase("joindungeon") {
    @Throws(CommandException::class)
    override fun processCommand(sender: ICommandSender, args: Array<String>) {
        var arguments = args.contentToString().replace("[", "").replace("]", "").replace(",", "")
        var type = ""
        var num = ""
        if (args[0] == "master_catacombs") {
            type = "M"
        } else if (args[0] == "catacombs") {
            type = "F"
        }

        // Try statement so message is consistent if user gives bad input
        try {
            if (args[1].toInt() in 1..7) {
                num = args[1]
            }
        } catch (_: NumberFormatException) {}

        if (Config.dungeonCommandConfirm) {
            TextUtils.info("§6Running command: $type$num")
        }
        TextUtils.sendMessage("/joindungeon $arguments")
    }
}