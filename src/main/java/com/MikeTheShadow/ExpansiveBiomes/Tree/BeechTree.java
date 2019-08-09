package com.MikeTheShadow.ExpansiveBiomes.Tree;

import com.MikeTheShadow.ExpansiveBiomes.TreeFeature.BeechTreeFeature;
import com.MikeTheShadow.ExpansiveBiomes.TreeFeature.MapleTreeFeature;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.block.trees.BigTree;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IWorld;
import net.minecraft.world.gen.feature.*;

import javax.annotation.Nullable;
import java.util.Random;

public class BeechTree extends BigTree
{
    public BeechTree()
    {

    }
    protected AbstractTreeFeature<NoFeatureConfig> getTreeFeature(Random p_196936_1_)
    {
        return new MapleTreeFeature(NoFeatureConfig::deserialize, true, false);
    }
    protected AbstractTreeFeature<NoFeatureConfig> getBigTreeFeature(Random p_196938_1_) {
        return new BeechTreeFeature(NoFeatureConfig::deserialize, true);
    }
    @Override
    public boolean spawn(IWorld p_196935_1_, BlockPos p_196935_2_, BlockState p_196935_3_, Random p_196935_4_)
    {
        //AbstractTreeFeature<NoFeatureConfig> lvt_5_1_ = this.getTreeFeature(p_196935_4_);
        BeechTreeFeature lvt_5_1_ = new BeechTreeFeature(NoFeatureConfig::deserialize, false);
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
