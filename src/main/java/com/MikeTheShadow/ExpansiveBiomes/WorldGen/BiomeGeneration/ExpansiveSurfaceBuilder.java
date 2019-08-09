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

public abstract class ExpansiveSurfaceBuilder<C extends ISurfaceBuilderConfig> extends net.minecraftforge.registries.ForgeRegistryEntry<net.minecraft.world.gen.surfacebuilders.SurfaceBuilder<?>> {
    public static final BlockState field_215409_f = Blocks.AIR.getDefaultState();
    public static final BlockState field_215410_g = Blocks.DIRT.getDefaultState();
    public static final BlockState field_215411_h = Blocks.GRASS_BLOCK.getDefaultState();
    public static final BlockState field_215412_i = Blocks.PODZOL.getDefaultState();
    public static final BlockState field_215413_j = Blocks.GRAVEL.getDefaultState();
    public static final BlockState field_215414_k = Blocks.STONE.getDefaultState();
    public static final BlockState field_215415_l = Blocks.COARSE_DIRT.getDefaultState();
    public static final BlockState field_215416_m = Blocks.SAND.getDefaultState();
    public static final BlockState field_215417_n = Blocks.RED_SAND.getDefaultState();
    public static final BlockState field_215418_o = Blocks.WHITE_TERRACOTTA.getDefaultState();
    public static final BlockState field_215419_p = Blocks.MYCELIUM.getDefaultState();
    public static final BlockState field_215420_q = Blocks.NETHERRACK.getDefaultState();
    public static final BlockState field_215421_r = Blocks.END_STONE.getDefaultState();
    public static final BlockState clay = Blocks.CLAY.getDefaultState();
    public static final SurfaceBuilderConfig shieldConfig = new SurfaceBuilderConfig(field_215414_k,field_215413_j,clay);
    public static final SurfaceBuilderConfig field_215422_s = new SurfaceBuilderConfig(field_215409_f, field_215409_f, field_215409_f);
    public static final SurfaceBuilderConfig field_215423_t = new SurfaceBuilderConfig(field_215412_i, field_215410_g, field_215413_j);
    public static final SurfaceBuilderConfig field_215424_u = new SurfaceBuilderConfig(field_215413_j, field_215413_j, field_215413_j);
    public static final SurfaceBuilderConfig field_215425_v = new SurfaceBuilderConfig(field_215411_h, field_215410_g, field_215413_j);
    public static final SurfaceBuilderConfig field_215426_w = new SurfaceBuilderConfig(field_215410_g, field_215410_g, field_215413_j);
    public static final SurfaceBuilderConfig field_215427_x = new SurfaceBuilderConfig(field_215414_k, field_215414_k, field_215413_j);
    public static final SurfaceBuilderConfig field_215428_y = new SurfaceBuilderConfig(field_215415_l, field_215410_g, field_215413_j);
    public static final SurfaceBuilderConfig field_215429_z = new SurfaceBuilderConfig(field_215416_m, field_215416_m, field_215413_j);
    public static final SurfaceBuilderConfig field_215390_A = new SurfaceBuilderConfig(field_215411_h, field_215410_g, field_215416_m);
    public static final SurfaceBuilderConfig field_215391_B = new SurfaceBuilderConfig(field_215416_m, field_215416_m, field_215416_m);
    public static final SurfaceBuilderConfig field_215392_C = new SurfaceBuilderConfig(field_215417_n, field_215418_o, field_215413_j);
    public static final SurfaceBuilderConfig field_215393_D = new SurfaceBuilderConfig(field_215419_p, field_215410_g, field_215413_j);
    public static final SurfaceBuilderConfig field_215394_E = new SurfaceBuilderConfig(field_215420_q, field_215420_q, field_215420_q);
    public static final SurfaceBuilderConfig field_215395_F = new SurfaceBuilderConfig(field_215421_r, field_215421_r, field_215421_r);
    private static <C extends ISurfaceBuilderConfig, F extends net.minecraft.world.gen.surfacebuilders.SurfaceBuilder<C>> F func_215389_a(String p_215389_0_, F p_215389_1_) {
        return (F)(Registry.<net.minecraft.world.gen.surfacebuilders.SurfaceBuilder<?>>register(Registry.field_218378_p, p_215389_0_, p_215389_1_));
    }
}
