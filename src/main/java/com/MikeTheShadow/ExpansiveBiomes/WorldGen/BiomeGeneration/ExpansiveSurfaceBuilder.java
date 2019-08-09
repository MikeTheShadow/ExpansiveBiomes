package com.MikeTheShadow.ExpansiveBiomes.WorldGen.BiomeGeneration;

import com.mojang.datafixers.Dynamic;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.util.registry.Registry;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.chunk.IChunk;
import net.minecraft.world.gen.surfacebuilders.*;

import java.util.Random;
import java.util.function.Function;

public abstract class ExpansiveSurfaceBuilder<C extends ISurfaceBuilderConfig> extends net.minecraftforge.registries.ForgeRegistryEntry<SurfaceBuilder<?>> {
    public static final BlockState AIR = Blocks.AIR.getDefaultState();
    public static final BlockState DIRT = Blocks.DIRT.getDefaultState();
    public static final BlockState GRASS_BLOCK = Blocks.GRASS_BLOCK.getDefaultState();
    public static final BlockState PODZOL = Blocks.PODZOL.getDefaultState();
    public static final BlockState GRAVEL = Blocks.GRAVEL.getDefaultState();
    public static final BlockState STONE = Blocks.STONE.getDefaultState();
    public static final BlockState COARSE_DIRT = Blocks.COARSE_DIRT.getDefaultState();
    public static final BlockState SAND = Blocks.SAND.getDefaultState();
    public static final BlockState RED_SAND = Blocks.RED_SAND.getDefaultState();
    public static final BlockState WHITE_TERRACOTTA = Blocks.WHITE_TERRACOTTA.getDefaultState();
    public static final BlockState MYCELIUM = Blocks.MYCELIUM.getDefaultState();
    public static final BlockState NETHERRACK = Blocks.NETHERRACK.getDefaultState();
    public static final BlockState END_STONE = Blocks.END_STONE.getDefaultState();
    public static final BlockState CLAY = Blocks.CLAY.getDefaultState();

    //Create a config of what you want the surface to be comprimsed of it goes BlockState topMaterial, BlockState underMaterial, BlockState underWaterMaterial
    public static final SurfaceBuilderConfig shieldConfig = new SurfaceBuilderConfig(STONE, GRAVEL, CLAY);

    //You need to register the blocks here as a Config
    public static final SurfaceBuilder<SurfaceBuilderConfig> shieldBuilderConfig = register("shield_biome", new DefaultSurfaceBuilder(SurfaceBuilderConfig::deserialize));

    private static <C extends ISurfaceBuilderConfig, F extends SurfaceBuilder<C>> F register(String key, F builderIn) {
        return (F)(Registry.<SurfaceBuilder<?>>register(Registry.SURFACE_BUILDER, key, builderIn));
    }

    public ExpansiveSurfaceBuilder(Function<Dynamic<?>, ? extends C> p_i51305_1_)
    {
        Function<Dynamic<?>, ? extends C> field_215408_a = p_i51305_1_;
    }

    public abstract void buildSurface(Random random, IChunk chunkIn, Biome biomeIn, int x, int z, int startHeight, double noise, BlockState defaultBlock, BlockState defaultFluid, int seaLevel, long seed, C config);

    public void setSeed(long seed) {
    }
}
