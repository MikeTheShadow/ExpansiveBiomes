package com.MikeTheShadow.ExpansiveBiomes.CustomBlocks;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.stats.Stats;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;


public class CustomBlock extends Block
{
    public CustomBlock(Properties properties)
    {
        super(properties);
    }
    @Override
    public void harvestBlock(World worldIn, PlayerEntity player, BlockPos pos, BlockState state,TileEntity te, ItemStack stack) {
        player.addStat(Stats.BLOCK_MINED.get(this));
        player.addExhaustion(0.005F);
        spawnDrops(state, worldIn, pos, te, player, stack);
    }
}
