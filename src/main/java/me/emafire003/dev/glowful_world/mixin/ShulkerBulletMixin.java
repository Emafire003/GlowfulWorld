package me.emafire003.dev.glowful_world.mixin;

import me.emafire003.dev.glowful_world.config.GWConfig;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.entity.projectile.ShulkerBulletEntity;
import net.minecraft.util.hit.EntityHitResult;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(ShulkerBulletEntity.class)
public abstract class ShulkerBulletMixin {

    @Inject(method = "onEntityHit", at = @At(value = "INVOKE", target = "Lnet/minecraft/entity/LivingEntity;addStatusEffect(Lnet/minecraft/entity/effect/StatusEffectInstance;Lnet/minecraft/entity/Entity;)Z"))
    protected void injectonEntityHit(EntityHitResult entityHitResult, CallbackInfo ci){
        if(GWConfig.SHULKER_GLOW){
            Entity entity = entityHitResult.getEntity();
            ((LivingEntity)entity).addStatusEffect(new StatusEffectInstance(StatusEffects.GLOWING, 200));
        }
    }

}
