package com.berserk007.spiritsmod.entity;

import com.berserk007.spiritsmod.SpiritsMod;
import com.berserk007.spiritsmod.entity.custom.WispEntity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModEntities {
    public static final DeferredRegister<EntityType<?>> ENTITY_TYPES =
            DeferredRegister.create(ForgeRegistries.ENTITY_TYPES, SpiritsMod.MOD_ID);

    public static final RegistryObject<EntityType<WispEntity>> WISP =
            ENTITY_TYPES.register("wisp", () -> EntityType.Builder.of(WispEntity::new, MobCategory.CREATURE)
                    .sized(0.25f, 0.25f).build("wisp"));

    public static void register(IEventBus eventBus) {
        ENTITY_TYPES.register(eventBus);
    }
}
