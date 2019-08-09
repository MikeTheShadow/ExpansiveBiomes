package com.MikeTheShadow.ExpansiveBiomes.WorldGen.BiomeGeneration;

import net.minecraft.world.IWorld;
import net.minecraft.world.chunk.IChunk;
import net.minecraft.world.gen.OverworldChunkGenerator;
import net.minecraft.world.gen.OverworldGenSettings;

public class ExpansiveChunkGenerator extends OverworldChunkGenerator
{
    public ExpansiveChunkGenerator(IWorld world)
    {
        super(world, new ExpansiveBiomeProvider(world.getSeed()), new OverworldGenSettings());
    }
    @Override
    public void generateSurface(IChunk chunk)
    {
        super.generateSurface(chunk);
    }
}
