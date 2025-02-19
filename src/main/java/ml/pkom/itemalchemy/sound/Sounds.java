package ml.pkom.itemalchemy.sound;

import ml.pkom.itemalchemy.ItemAlchemy;
import ml.pkom.mcpitanlibarch.api.event.registry.RegistryEvent;
import net.minecraft.sound.SoundEvent;

public class Sounds {
    public static final RegistryEvent<SoundEvent> EXCHANGE_SOUND = register("exchange");
    public static final RegistryEvent<SoundEvent> CHARGE_SOUND = register("charge");
    public static final RegistryEvent<SoundEvent> UNCHARGE_SOUND = register("uncharge");

    public static void init(){

    }
    private static RegistryEvent<SoundEvent> register(String id) {
        return ItemAlchemy.registry.registerSoundEvent(ItemAlchemy.id(id));
    }
}
