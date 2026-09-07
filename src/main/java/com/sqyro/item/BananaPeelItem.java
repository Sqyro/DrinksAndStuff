package com.sqyro.item;

import com.sqyro.entity.BananaPeelProjectileEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.stat.Stats;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.world.World;

public class BananaPeelItem extends Item {
    public BananaPeelItem(Settings settings) {
        super(settings);
    }

    @Override
    public ActionResult use(World world, PlayerEntity player, Hand hand) {
        ItemStack itemStack = player.getStackInHand(hand);
        world.playSound(null, player.getX(), player.getY(), player.getZ(), SoundEvents.ENTITY_SNOWBALL_THROW, SoundCategory.NEUTRAL, 0.5f, 0.4f / (world.getRandom().nextFloat() * 0.4f + 0.8f));
        if (!world.isClient()) {
            BananaPeelProjectileEntity bananaPeel = new BananaPeelProjectileEntity( player, world, itemStack);
            bananaPeel.setVelocity(player, player.getPitch(), player.getYaw(), 0.0f, 0.8f, 0f);
            world.spawnEntity(bananaPeel);
        }

        player.incrementStat(Stats.USED.getOrCreateStat(this));
        itemStack.decrementUnlessCreative(1, player);

        return ActionResult.SUCCESS;
    }
}
