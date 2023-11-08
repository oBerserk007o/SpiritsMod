package com.berserk007.spiritsmod.item;

import com.berserk007.spiritsmod.SpiritsMod;
import com.berserk007.spiritsmod.entity.ModEntities;
import com.berserk007.spiritsmod.item.custom.TimedEnderPearlItem;
import net.minecraft.world.item.Item;
import net.minecraftforge.common.ForgeSpawnEggItem;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModItems {
    public static final DeferredRegister<Item> ITEMS =
            DeferredRegister.create(ForgeRegistries.ITEMS, SpiritsMod.MOD_ID);

    public static final RegistryObject<Item> WISP_SPAWN_EGG = ITEMS.register("wisp_spawn_egg",
            () -> new ForgeSpawnEggItem(ModEntities.WISP, 0x7FDAFF, 0x63D2FF,
                    new Item.Properties()));

    public static final RegistryObject<Item> WISP_FOOD = ITEMS.register("wisp_food",
            () -> new Item(new Item.Properties()));

    public static final RegistryObject<Item> TIMED_ENDER_PEARL = ITEMS.register("timed_ender_pearl",
            () -> new TimedEnderPearlItem(new Item.Properties().stacksTo(16)));

    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}
