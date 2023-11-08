package com.berserk007.spiritsmod.block.custom;

import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.BlockHitResult;

import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

public class ChattyBlock extends Block {
    public static String[] text = {
            "Hey, that tickles!",
            "Stop that",
            "Ow!",
            "Oh, hi there",
            "Can you stop please?",
            "Hello!"
    };

    public ChattyBlock(Properties pProperties) {
        super(pProperties);
    }

    @Override
    public InteractionResult use(BlockState pState, Level pLevel, BlockPos pPos,
                                 Player pPlayer, InteractionHand pHand, BlockHitResult pHit) {
        pPlayer.sendSystemMessage(Component.literal(text[ThreadLocalRandom.current().nextInt(0, 5)]));

        return super.use(pState, pLevel, pPos, pPlayer, pHand, pHit);
    }

    @Override
    public void stepOn(Level pLevel, BlockPos pPos, BlockState pState, Entity pEntity) {
        if (pEntity instanceof Player player) {
            player.sendSystemMessage(Component.literal("Oi! Why are you disrespecting me like that?"));
        }
    }
    @Override
    public void appendHoverText(ItemStack pStack, BlockGetter pLevel, List<Component> pTooltip, TooltipFlag pFlag) {
        pTooltip.add(Component.literal("tooltip.spiritsmod.chatty_block"));
        super.appendHoverText(pStack, pLevel, pTooltip, pFlag);
    }
}
