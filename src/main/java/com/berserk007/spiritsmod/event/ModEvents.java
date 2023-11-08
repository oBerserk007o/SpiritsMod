package com.berserk007.spiritsmod.event;

import com.berserk007.spiritsmod.SpiritsMod;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.projectile.ThrownEnderpearl;
import net.minecraft.world.phys.Vec3;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.event.entity.ProjectileImpactEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = SpiritsMod.MOD_ID, bus = Mod.EventBusSubscriber.Bus.FORGE)
public class ModEvents {
    private static int ticks =  0;
    public static boolean startCounter = false;
    public static Entity player;
    public static Double[] pos = {0D, 0D, 0D};

    @SubscribeEvent
    public static void onTick(TickEvent event) {
        if (startCounter) {
            ticks++;
            if (ticks >= 1000) {
                player.teleportTo(pos[0], pos[1], pos[2]);
                startCounter = false;
                ticks = 0;
                System.out.println("Teleported!");
            }
        }

    }

    @SubscribeEvent
    public static void onProjectileImpact (ProjectileImpactEvent event) {
        if (event.getProjectile() instanceof ThrownEnderpearl enderpearl) {
            if (enderpearl.getTags().contains("timedenderpearl")) {
                player = enderpearl.getOwner();
                enderpearl.removeTag("timedenderpearl");
                String[] unconvertedPos = enderpearl.getTags().iterator().next().split(" ");
                pos[0] = Double.parseDouble(unconvertedPos[0]);
                pos[1] = Double.parseDouble(unconvertedPos[1]);
                pos[2] = Double.parseDouble(unconvertedPos[2]);
                startCounter = true;
                System.out.println("WOOOO");
            }
        }
    }
}
