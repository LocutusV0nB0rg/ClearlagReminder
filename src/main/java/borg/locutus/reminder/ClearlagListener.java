package borg.locutus.reminder;

import net.labymod.api.events.MessageReceiveEvent;
import net.minecraft.client.Minecraft;

public class ClearlagListener implements MessageReceiveEvent {

    @Override
    public boolean onReceive(String message, String unformattedMessage) {
        if(message.equals("§r§8[§r§6GrieferGames§r§8] §r§4Warnung! §r§cDie auf dem Boden liegenden Items werden in §r§420 §r§cSekunden entfernt!§r")) {
            if (ClearlagReminder.getInstance().isMidScreenReminder())
                showTextOnScreen();
        }

        return false;
    }

    private void showTextOnScreen() {
        Minecraft.getMinecraft().ingameGUI.displayTitle("Achtung! Clearlag! 20 Sekunden verbleiben!", "", 10, 10, 10);
    }
}