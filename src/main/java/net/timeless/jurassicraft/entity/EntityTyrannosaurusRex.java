package net.timeless.jurassicraft.entity;

import net.minecraft.entity.ai.EntityAIAttackOnCollide;
import net.minecraft.entity.ai.EntityAIHurtByTarget;
import net.minecraft.entity.ai.EntityAILookIdle;
import net.minecraft.entity.ai.EntityAINearestAttackableTarget;
import net.minecraft.entity.ai.EntityAIWander;
import net.minecraft.entity.ai.EntityAIWatchClosest;
import net.minecraft.entity.passive.EntityPig;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.world.World;
import net.timeless.jurassicraft.api.animation.IAnimatedEntity;
import net.timeless.jurassicraft.entity.base.EntityDinosaurAggressive;

public class EntityTyrannosaurusRex extends EntityDinosaurAggressive implements IAnimatedEntity
{
    private int animationId = -1;

    public EntityTyrannosaurusRex(World world)
    {
        super(world);

        // Placeholder AI
        if (!this.isChild())
        {
            this.tasks.addTask(0, new EntityAIAttackOnCollide(this, EntityPlayer.class, dinosaur.getAttackSpeed(), false));
            this.targetTasks.addTask(0, new EntityAINearestAttackableTarget(this, EntityPlayer.class, false));
            this.tasks.addTask(0, new EntityAIAttackOnCollide(this, EntityPig.class, dinosaur.getAttackSpeed(), false));
            this.targetTasks.addTask(0, new EntityAINearestAttackableTarget(this, EntityPig.class, false));

            this.targetTasks.addTask(1, new EntityAIHurtByTarget(this, true, EntityPlayer.class));

            this.tasks.addTask(6, new EntityAIWander(this, dinosaur.getAdultSpeed()));
            this.tasks.addTask(7, new EntityAIWatchClosest(this, EntityPlayer.class, 6.0F));
            this.tasks.addTask(8, new EntityAILookIdle(this));
        }
    }

    @Override
    public void setAnimID(int id)
    {
        this.animationId = id;
    }

    @Override
    public int getAnimID()
    {
        return animationId;
    }
}
