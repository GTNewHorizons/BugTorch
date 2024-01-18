package jss.bugtorch.features.extraVanilla;

import cpw.mods.fml.common.eventhandler.EventPriority;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import jss.bugtorch.BugTorch;
import jss.bugtorch.util.StaticUtils;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.Potion;
import net.minecraftforge.event.entity.living.LivingAttackEvent;

import java.util.Random;

public class onPlayerHit {


    @SubscribeEvent (priority = EventPriority.LOWEST)
    public void onPlayerHit(LivingAttackEvent e){


        if(e.entity.worldObj.isRemote){
            return;
        }


        if(!e.source.isProjectile() && e.source.getEntity() instanceof EntityPlayer && e.entity!=null && e.entityLiving!=null){


            if(e.entityLiving.isEntityInvulnerable()){
                return;
            }

            if(e.entityLiving.hurtTime>0){
                return;
            }

            if(!e.entityLiving.isEntityAlive()){
                return;
            }
            if(e.entityLiving.getHealth()<=0){
                return;
            }




            EntityPlayer player = (EntityPlayer) e.source.getEntity();

            float rndF = player.worldObj.rand.nextFloat();


            JCDamageInfo damageInfo =  new JCDamageInfo(e.entity , player);


            if(damageInfo.isWeak){
                StaticUtils.playSoundAt(BugTorch.MODID + ":HitWea", e.entity, 0.7F, rndF * 0.1F + 0.9F);
                return;
            }


            if(damageInfo.isKnonk){
                StaticUtils.playSoundAt(BugTorch.MODID + ":HitKno", e.entity, 0.7F, rndF * 0.1F + 0.9F);

            }

            if(damageInfo.isCrit){
                StaticUtils.playSoundAt(BugTorch.MODID + ":HitCri", e.entity, 0.7F, rndF * 0.1F + 0.9F);

            }

            if(damageInfo.isStrong){
                StaticUtils.playSoundAt(BugTorch.MODID + ":HitStr", e.entity, 0.7F, rndF * 0.1F + 0.9F);

            }



        }else {
            return;
        }







    }





    public class JCDamageInfo {
        public boolean isWeak;
        public boolean isCrit;
        public boolean isKnonk;
        public boolean isStrong;
        public boolean isFire;
        public float damage;


        public JCDamageInfo(Entity target, EntityPlayer player) {

            ItemStack stack = player.getCurrentEquippedItem();


            if (target.canAttackWithItem()) {

                if (!target.hitByEntity(player)) {

                    damage = (float) player.getEntityAttribute(SharedMonsterAttributes.attackDamage).getAttributeValue();

                    int knockM = 0;
                    float damageMod = 0.0F;

                    if (target instanceof EntityLivingBase) {
                        damageMod = EnchantmentHelper.getEnchantmentModifierLiving(player, (EntityLivingBase) target);
                        knockM += EnchantmentHelper.getKnockbackModifier(player, (EntityLivingBase) target);
                    }

                    if (player.isSprinting()) {
                        ++knockM;
                    }

                    int fire = EnchantmentHelper.getFireAspectModifier(player);

                    if (damage > 0.0F || damageMod > 0.0F) {

                        isCrit = knockM > 0;
                        isKnonk = player.fallDistance > 0.0F && !player.onGround && !player.isOnLadder() && !player.isInWater() && !player.isPotionActive(Potion.blindness) && player.ridingEntity == null && target instanceof EntityLivingBase;
                        isStrong = damageMod > 0.0F;
                        isFire = fire > 0;

                        if (isKnonk) {
                            damage *= 1.5F;
                        }
                        damage += damageMod;


                        //Weak attack
                        isWeak = damage<=1f;

                    }

                }
            }


            //Not specified
            if(!isAnyDamage()){
                isStrong = true;
            }


        }


        public boolean isAnyDamage() {
            return isCrit || isKnonk || isStrong || isFire;

        }


    }
}
