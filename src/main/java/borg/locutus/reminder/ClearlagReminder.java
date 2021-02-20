package borg.locutus.reminder;

import net.labymod.api.LabyModAddon;
import net.labymod.settings.elements.BooleanElement;
import net.labymod.settings.elements.ControlElement;
import net.labymod.settings.elements.SettingsElement;
import net.labymod.utils.Material;

import java.util.List;

public class ClearlagReminder extends LabyModAddon {
    private static ClearlagReminder instance;

    private boolean midScreenReminder;

    @Override
    public void onEnable() {
        instance = this;

        getApi().getEventManager().register(new ClearlagListener());
    }

    @Override
    public void loadConfig() {
        this.midScreenReminder = getConfig().has( "midScreenReminder" ) ? getConfig().get( "midScreenReminder" ).getAsBoolean() : true;
    }

    @Override
    protected void fillSettings(List<SettingsElement> subSettings) {
        subSettings.add( new BooleanElement( "Text-Erinnerung", this, new ControlElement.IconData( Material.REDSTONE_LAMP_ON ), "midScreenReminder", this.midScreenReminder ) );
    }

    public static ClearlagReminder getInstance() {
        return instance;
    }

    public boolean isMidScreenReminder() {
        return midScreenReminder;
    }
}
