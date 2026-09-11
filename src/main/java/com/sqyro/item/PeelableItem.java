package com.sqyro.item;

import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvent;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.world.World;

public class PeelableItem extends Item {
    private final Item peeledItem;
    private final Item peel;

    private final SoundEvent peelingSound;

    public PeelableItem(Item peeledItem, Item peel, SoundEvent peelingSound, Settings settings) {
        super(settings);
        this.peeledItem = peeledItem;
        this.peel = peel;
        this.peelingSound = peelingSound;
    }

    @Override
    public ActionResult use(World world, PlayerEntity player, Hand hand) {
        ItemStack stack = player.getStackInHand(hand);

        if (world.isClient()) {
            return ActionResult.SUCCESS;
        }

        world.playSound(null, player.getX(), player.getY(), player.getZ(), peelingSound, SoundCategory.PLAYERS);

        if (stack.getCount() > 1) {
            player.giveOrDropStack(new ItemStack(peeledItem));
        } else {
            player.setStackInHand(hand, new ItemStack(peeledItem));
        }

        player.giveOrDropStack(new ItemStack(peel));

        if (!player.isCreative() && stack.getCount() > 1) {
            stack.decrement(1);
        }

        return ActionResult.SUCCESS;
    }
}
