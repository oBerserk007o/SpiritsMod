package com.berserk007.spiritsmod.entity.client;

import com.berserk007.spiritsmod.entity.custom.WispEntity;
import com.berserk007.spiritsmod.entity.animations.ModAnimationDefinitions;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.minecraft.client.model.HierarchicalModel;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.*;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.Mth;

public class WispModel<T extends WispEntity> extends HierarchicalModel<T> {
    private final ModelPart wisp;

    public WispModel(ModelPart root) {
        this.wisp = root.getChild("wisp");
    }

    public static LayerDefinition createBodyLayer() {
        MeshDefinition meshdefinition = new MeshDefinition();
        PartDefinition partdefinition = meshdefinition.getRoot();

        // PartDefinition wisp = partdefinition.addOrReplaceChild("wisp", CubeListBuilder.create().texOffs(0, 0).addBox(-2.0F, -6.0F, -2.0F, 4.0F, 4.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 20.0F, 0.0F));
        PartDefinition wisp = partdefinition.addOrReplaceChild("wisp", CubeListBuilder.create().texOffs(0, 0).addBox(-2.0F, 0F, -2.0F, 4.0F, 4.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 20.0F, 0.0F));

        return LayerDefinition.create(meshdefinition, 16, 16);
    }

    @Override
    public void setupAnim(T entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
        this.root().getAllParts().forEach(ModelPart::resetPose);
        this.applyHeadRotation(entity, netHeadYaw, 0);

        this.animate(entity.idleAnimationState, ModAnimationDefinitions.IDLE, ageInTicks, 1f);
        this.animateWalk(ModAnimationDefinitions.IDLE, limbSwing, limbSwingAmount, 2f, 2.5f);
    }

    private void applyHeadRotation(WispEntity pEntity, float pNetHeadYaw, float pHeadPitch) {
        pNetHeadYaw = Mth.clamp(pNetHeadYaw, -30.0F, 30.0F);
        pHeadPitch = Mth.clamp(pHeadPitch, -25.0F, 45.0F);

        this.wisp.yRot = pNetHeadYaw * ((float)Math.PI / 180F);
        this.wisp.xRot = pHeadPitch * ((float)Math.PI / 180F);
    }

    @Override
    public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
        wisp.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
    }

    @Override
    public ModelPart root() {
        return wisp;
    }
}