package com.MikeTheShadow.ExpansiveBiomes.WorldGen.Carvers;

import net.minecraft.util.registry.Registry;
import net.minecraft.world.chunk.IChunk;
import net.minecraft.world.gen.carver.CaveWorldCarver;
import net.minecraft.world.gen.carver.ICarverConfig;
import net.minecraft.world.gen.carver.WorldCarver;
import net.minecraft.world.gen.feature.ProbabilityConfig;
import net.minecraftforge.registries.ForgeRegistryEntry;

import java.util.BitSet;
import java.util.Random;
import java.util.function.Function;

public class ExpansiveCarver <C extends ICarverConfig> extends ForgeRegistryEntry<WorldCarver<?>>
{
    public static final WorldCarver<ProbabilityConfig> CAVE = register("cave", new ExpansiveCaveCarver(ProbabilityConfig::deserialize, 256));
    private static <C extends ICarverConfig, F extends WorldCarver<C>> F register(String carver_name, F p_222699_1_)
    {
        return (F) Registry.register(Registry.CARVER, carver_name, p_222699_1_);
    }
}
