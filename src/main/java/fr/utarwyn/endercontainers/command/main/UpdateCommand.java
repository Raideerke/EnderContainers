package fr.utarwyn.endercontainers.command.main;

import fr.utarwyn.endercontainers.EnderContainers;
import fr.utarwyn.endercontainers.command.AbstractCommand;
import fr.utarwyn.endercontainers.configuration.Files;
import fr.utarwyn.endercontainers.util.Updater;
import org.bukkit.command.CommandSender;

public class UpdateCommand extends AbstractCommand {

    public UpdateCommand() {
        super("update");

        this.setPermission("update");
    }

    @Override
    public void perform(CommandSender sender) {
        if (!Updater.getInstance().isUpToDate()) {
            sender.sendMessage(EnderContainers.PREFIX + "§aThere is a newer version available: §2§l" + Updater.getInstance().getNewestVersion() + "§a.");
            sender.sendMessage(EnderContainers.PREFIX + "&7Click here to download it: " + EnderContainers.DOWNLOAD_LINK);
        } else {
            sender.sendMessage(EnderContainers.PREFIX + "§7" + Files.getLocale().getNoUpdate());
        }
    }

}
