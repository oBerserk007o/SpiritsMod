package com.berserk007.spiritsmod.entity.animations;

import net.minecraft.client.animation.AnimationChannel;
import net.minecraft.client.animation.AnimationDefinition;
import net.minecraft.client.animation.Keyframe;
import net.minecraft.client.animation.KeyframeAnimations;

public class ModAnimationDefinitions {
    public static final AnimationDefinition IDLE = AnimationDefinition.Builder.withLength(8f).looping()
            .addAnimation("wisp",
                    new AnimationChannel(AnimationChannel.Targets.POSITION,
                            new Keyframe(0f, KeyframeAnimations.posVec(0f, 0f, 0f),
                                    AnimationChannel.Interpolations.LINEAR),
                            new Keyframe(0.5f, KeyframeAnimations.posVec(0f, 0.75f, 0f),
                                    AnimationChannel.Interpolations.LINEAR),
                            new Keyframe(1f, KeyframeAnimations.posVec(0f, 1.4f, 0f),
                                    AnimationChannel.Interpolations.LINEAR),
                            new Keyframe(1.5f, KeyframeAnimations.posVec(0f, 1.85f, 0f),
                                    AnimationChannel.Interpolations.LINEAR),
                            new Keyframe(2f, KeyframeAnimations.posVec(0f, 2f, 0f),
                                    AnimationChannel.Interpolations.LINEAR),
                            new Keyframe(2.5f, KeyframeAnimations.posVec(0f, 1.85f, 0f),
                                    AnimationChannel.Interpolations.LINEAR),
                            new Keyframe(3f, KeyframeAnimations.posVec(0f, 1.4f, 0f),
                                    AnimationChannel.Interpolations.LINEAR),
                            new Keyframe(3.5f, KeyframeAnimations.posVec(0f, 0.75f, 0f),
                                    AnimationChannel.Interpolations.LINEAR),
                            new Keyframe(4f, KeyframeAnimations.posVec(0f, 0f, 0f),
                                    AnimationChannel.Interpolations.LINEAR),
                            new Keyframe(4.5f, KeyframeAnimations.posVec(0f, -0.75f, 0f),
                                    AnimationChannel.Interpolations.LINEAR),
                            new Keyframe(5f, KeyframeAnimations.posVec(0f, -1.4f, 0f),
                                    AnimationChannel.Interpolations.LINEAR),
                            new Keyframe(5.5f, KeyframeAnimations.posVec(0f, -1.85f, 0f),
                                    AnimationChannel.Interpolations.LINEAR),
                            new Keyframe(6f, KeyframeAnimations.posVec(0f, -2f, 0f),
                                    AnimationChannel.Interpolations.LINEAR),
                            new Keyframe(6.5f, KeyframeAnimations.posVec(0f, -1.85f, 0f),
                                    AnimationChannel.Interpolations.LINEAR),
                            new Keyframe(7f, KeyframeAnimations.posVec(0f, -1.4f, 0f),
                                    AnimationChannel.Interpolations.LINEAR),
                            new Keyframe(7.5f, KeyframeAnimations.posVec(0f, -0.75f, 0f),
                                    AnimationChannel.Interpolations.LINEAR),
                            new Keyframe(8f, KeyframeAnimations.posVec(0f, 0f, 0f),
                                    AnimationChannel.Interpolations.LINEAR))).build();
}