package com.berserk007.spiritsmod.event;

import com.berserk007.spiritsmod.SpiritsMod;
import com.berserk007.spiritsmod.entity.ModEntities;
import com.berserk007.spiritsmod.entity.client.WispModel;
import com.berserk007.spiritsmod.entity.custom.WispEntity;
import com.berserk007.spiritsmod.entity.layers.ModModelLayers;
import net.minecraftforge.client.event.EntityRenderersEvent;
import net.minecraftforge.event.entity.EntityAttributeCreationEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = SpiritsMod.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class ModEventBusEvents {
    @SubscribeEvent
    public static void registerLayers(EntityRenderersEvent.RegisterLayerDefinitions event) {
        event.registerLayerDefinition(ModModelLayers.WISP_LAYER, WispModel::createBodyLayer);
    }

    @SubscribeEvent
    public static void registerAttributes(EntityAttributeCreationEvent event) {
        event.put(ModEntities.WISP.get(), WispEntity.createAttributes().build());
    }
}
