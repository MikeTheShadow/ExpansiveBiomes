package com.MikeTheShadow.ExpansiveBiomes.Tree;

import com.MikeTheShadow.ExpansiveBiomes.TreeFeature.MapleTreeFeature;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.block.trees.Tree;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IWorld;
import net.minecraft.world.gen.feature.AbstractTreeFeature;
import net.minecraft.world.gen.feature.IFeatureConfig;
import net.minecraft.world.gen.feature.NoFeatureConfig;

import java.util.Random;

public class MapleTree extends Tree
{
    public MapleTree()
    {

    }
    protected AbstractTreeFeature<NoFeatureConfig> getTreeFeature(Random p_196936_1_)
    {
        return (AbstractTreeFeature)(p_196936_1_.nextInt(10) == 0 ? new MapleTreeFeature(NoFeatureConfig::func_214639_a, false,false) : new MapleTreeFeature(NoFeatureConfig::func_214639_a, false,false));
    }
    @Override
    public boolean spawn(IWorld p_196935_1_, BlockPos p_196935_2_, BlockState p_196935_3_, Random p_196935_4_)
    {
        //AbstractTreeFeature<NoFeatureConfig> lvt_5_1_ = this.getTreeFeature(p_196935_4_);
        MapleTreeFeature lvt_5_1_ = new MapleTreeFeature(NoFeatureConfig::func_214639_a, false,false);
        if (lvt_5_1_ == null) {
            return false;
        } else {
            p_196935_1_.setBlockState(p_196935_2_, Blocks.AIR.getDefaultState(), 4);
            if (lvt_5_1_.place(p_196935_1_, p_196935_1_.getChunkProvider().getChunkGenerator(), p_196935_4_, p_196935_2_, IFeatureConfig.NO_FEATURE_CONFIG)) {
                return true;
            } else {
                p_196935_1_.setBlockState(p_196935_2_, p_196935_3_, 4);
                return false;
            }
        }
    }

}
