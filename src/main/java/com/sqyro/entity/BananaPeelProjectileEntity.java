package com.sqyro.entity;

import com.sqyro.item.DrinksAndStuffItems;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.projectile.thrown.ThrownItemEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.hit.EntityHitResult;
import net.minecraft.util.hit.HitResult;
import net.minecraft.world.World;

public class BananaPeelProjectileEntity extends ThrownItemEntity {
    public static final int BANANA_PEEL_DAMAGE = 2;

    public BananaPeelProjectileEntity(EntityType<? extends ThrownItemEntity> entityType, World world) {
        super(entityType, world);
    }

    public BananaPeelProjectileEntity(LivingEntity livingEntity, World world, ItemStack stack) {
        super(DrinksAndStuffEntities.BANANA_PEEL_PROJECTILE, livingEntity, world, stack);
    }

    @Override
    protected Item getDefaultItem() {
        return DrinksAndStuffItems.BANANA_PEEL;
    }

    @Override
    protected void onEntityHit(EntityHitResult entityHitResult) {
        super.onEntityHit(entityHitResult);
        Entity entity = entityHitResult.getEntity();

        if (!this.getEntityWorld().isClient()) {
            entity.damage(((ServerWorld) this.getEntityWorld()), this.getDamageSources().thrown(this, this.getOwner()), BANANA_PEEL_DAMAGE);

            this.getEntityWorld().sendEntityStatus(this, (byte)3);
            this.discard();
        }
    }

    @Override
    protected void onCollision(HitResult hitResult) {
        super.onCollision(hitResult);
        if (!this.getEntityWorld().isClient()) {
            this.getEntityWorld().sendEntityStatus(this, (byte)3);
            this.discard();
        }
    }
}