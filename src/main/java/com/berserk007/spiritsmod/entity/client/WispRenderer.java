package com.berserk007.spiritsmod.entity.client;

import com.berserk007.spiritsmod.SpiritsMod;
import com.berserk007.spiritsmod.entity.custom.WispEntity;
import com.berserk007.spiritsmod.entity.layers.ModModelLayers;
import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;

public class WispRenderer extends MobRenderer<WispEntity, WispModel<WispEntity>> {
    private static final ResourceLocation WISP_LOCATION = new ResourceLocation(SpiritsMod.MOD_ID,"textures/entity/wisp.png");

    public WispRenderer(EntityRendererProvider.Context pContext) {
        super(pContext, new WispModel<>(pContext.bakeLayer(ModModelLayers.WISP_LAYER)), 0.2f);
    }

    @Override
    public ResourceLocation getTextureLocation(WispEntity pEntity) {
        return WISP_LOCATION;
    }

    @Override
    public void render(WispEntity pEntity, float pEntityYaw, float pPartialTicks,
                       PoseStack pMatrixStack, MultiBufferSource pBuffer, int pPackedLight) {
        if(pEntity.isBaby()) {
            pMatrixStack.scale(0.45f, 0.45f, 0.45f);
        }

        super.render(pEntity, pEntityYaw, pPartialTicks, pMatrixStack, pBuffer, pPackedLight);
    }
}
