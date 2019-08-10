package com.MikeTheShadow.ExpansiveBiomes.TreeFeature;

import com.MikeTheShadow.ExpansiveBiomes.ExpansiveBiomes;
import com.mojang.datafixers.Dynamic;
import net.minecraft.block.BlockState;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MutableBoundingBox;
import net.minecraft.world.gen.IWorldGenerationBaseReader;
import net.minecraft.world.gen.IWorldGenerationReader;
import net.minecraft.world.gen.feature.AbstractTreeFeature;
import net.minecraft.world.gen.feature.NoFeatureConfig;

import java.util.Random;
import java.util.Set;
import java.util.function.Function;

public class BeechTreeFeature extends AbstractTreeFeature<NoFeatureConfig>
{
    private static final BlockState field_214618_a = ExpansiveBiomes.blockListLog.get(2).getDefaultState();
    private static final BlockState field_214619_aS = ExpansiveBiomes.blockListLeaves.get(2).getDefaultState();

    public BeechTreeFeature(Function<Dynamic<?>, ? extends NoFeatureConfig> p_i49895_1_, boolean p_i49895_2_) {
        super(p_i49895_1_, p_i49895_2_);
        setSapling((net.minecraftforge.common.IPlantable) ExpansiveBiomes.blockListSapling.get(2));
    }
    @Override
    public boolean place(Set<BlockPos> changedBlocks, IWorldGenerationReader worldIn, Random rand, BlockPos position, MutableBoundingBox p_208519_5_) {
        int i = rand.nextInt(3) + 5;
        boolean flag = true;
        if (position.getY() >= 1 && position.getY() + i + 1 <= worldIn.getMaxHeight()) {
            for(int j = position.getY(); j <= position.getY() + 1 + i; ++j) {
                int k = 1;
                if (j == position.getY()) {
                    k = 0;
                }

                if (j >= position.getY() + 1 + i - 2) {
                    k = 2;
                }

                BlockPos.MutableBlockPos blockpos$mutableblockpos = new BlockPos.MutableBlockPos();

                for(int l = position.getX() - k; l <= position.getX() + k && flag; ++l) {
                    for(int i1 = position.getZ() - k; i1 <= position.getZ() + k && flag; ++i1) {
                        if (j >= 0 && j < worldIn.getMaxHeight()) {
                            if (!func_214587_a(worldIn, blockpos$mutableblockpos.setPos(l, j, i1))) {
                                flag = false;
                            }
                        } else {
                            flag = false;
                        }
                    }
                }
            }

            if (!flag) {
                return false;
            } else if ((isSoil(worldIn, position.down(), getSapling())) && position.getY() < worldIn.getMaxHeight() - i - 1) {
                this.setDirtAt(worldIn, position.down(), position);

                for(int l1 = position.getY() - 3 + i; l1 <= position.getY() + i; ++l1) {
                    int j2 = l1 - (position.getY() + i);
                    int k2 = 1 - j2 / 2;

                    for(int l2 = position.getX() - k2; l2 <= position.getX() + k2; ++l2) {
                        int i3 = l2 - position.getX();

                        for(int j1 = position.getZ() - k2; j1 <= position.getZ() + k2; ++j1) {
                            int k1 = j1 - position.getZ();
                            if (Math.abs(i3) != k2 || Math.abs(k1) != k2 || rand.nextInt(2) != 0 && j2 != 0) {
                                BlockPos blockpos = new BlockPos(l2, l1, j1);
                                if (isAirOrLeaves(worldIn, blockpos)) {
                                    this.setLogState(changedBlocks, worldIn, blockpos, field_214619_aS, p_208519_5_);
                                }
                            }
                        }
                    }
                }

                for(int i2 = 0; i2 < i; ++i2) {
                    if (isAirOrLeaves(worldIn, position.up(i2))) {
                        this.setLogState(changedBlocks, worldIn, position.up(i2), field_214618_a, p_208519_5_);
                    }
                }

                return true;
            } else {
                return false;
            }
        } else {
            return false;
        }
    }

    private boolean func_214615_a(IWorldGenerationBaseReader p_214615_1_, BlockPos p_214615_2_, int p_214615_3_) {
        int i = p_214615_2_.getX();
        int j = p_214615_2_.getY();
        int k = p_214615_2_.getZ();
        BlockPos.MutableBlockPos blockpos$mutableblockpos = new BlockPos.MutableBlockPos();

        for(int l = 0; l <= p_214615_3_ + 1; ++l) {
            int i1 = 1;
            if (l == 0) {
                i1 = 0;
            }

            if (l >= p_214615_3_ - 1) {
                i1 = 2;
            }

            for(int j1 = -i1; j1 <= i1; ++j1) {
                for(int k1 = -i1; k1 <= i1; ++k1) {
                    if (!func_214587_a(p_214615_1_, blockpos$mutableblockpos.setPos(i + j1, j + l, k + k1))) {
                        return false;
                    }
                }
            }
        }

        return true;
    }
}