
package com.MikeTheShadow.ExpansiveBiomes.WorldGen.BiomeGeneration;

import com.MikeTheShadow.ExpansiveBiomes.ExpansiveBiomes;
import net.minecraft.block.BlockState;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.Biomes;
import net.minecraft.world.biome.provider.BiomeProvider;
import net.minecraft.world.gen.*;
import net.minecraft.world.gen.feature.structure.Structure;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.Set;

import static java.lang.Math.abs;
import static java.lang.Math.sqrt;

public class ExpansiveBiomeProvider extends BiomeProvider
{
    private final double TEMPERATURE_SCALE = 700;
    private final double DEPTH_SCALE = 100;

    private final double NOISE_SCALE = 700;
    private final double NOISE_VALUE = 0.25;
    private enum Temperature {
        FROZEN,
        COLD,
        NORMAL,
        LUKEWARM,
        WARM,
    }
    private final PerlinNoiseGenerator noise;
    private final SimplexNoiseGenerator noiseTemp;

    public ExpansiveBiomeProvider(long seed)
    {
        boolean seedNeg = false;
        if (seed<0){
            seedNeg = true;
        }
        noise = new PerlinNoiseGenerator(new Random(seed),5);
        if (seedNeg == true){
            noiseTemp = new SimplexNoiseGenerator(new Random((long)-(sqrt(abs(seed/2)))));
        } else {
            noiseTemp = new SimplexNoiseGenerator(new Random((long)sqrt(seed/2)));
        }
    }
    @Override
    public Biome getBiome(int x, int y)
    {
        double deepOceanDepth = 0.0000000005;
        double shallowOceanMin = 0.70; //Minimum d-value for shallow ocean generation.
        double t = abs(noiseTemp.getValue((double) x /TEMPERATURE_SCALE, (double) y/TEMPERATURE_SCALE ));
        double d = (1.0 + noise.getValue((double) x / DEPTH_SCALE, (double) y / DEPTH_SCALE))*0.4;
        double rand = abs(noiseTemp.getValue((double) x / NOISE_SCALE, (double) y / NOISE_SCALE)); //Rand for TEMPERATURE, Makes "Splotches"
        rand = 1.0 + (rand * NOISE_VALUE);
        Temperature temp;
        if ((t * rand) < 0.3) {
            temp = Temperature.FROZEN;
        } else if ((t * rand) < 0.4) {
            temp = Temperature.COLD;
        } else if ((t * rand) < 0.5) {
            temp = Temperature.NORMAL;
        } else if ((t * rand) < 0.65) {
            temp = Temperature.LUKEWARM;
        } else {
            temp = Temperature.WARM;
        }
        if (d < 0.852) //Ocean
        {
            switch (temp) {
                case WARM:
                    if (d < deepOceanDepth) {
                        return Biomes.DEEP_WARM_OCEAN;
                    } else if (d > shallowOceanMin) {
                        return ExpansiveBiomes.biomeListShallow.get(0);
                    } else {
                        return Biomes.WARM_OCEAN;
                    }
                case LUKEWARM:
                    if (d < deepOceanDepth) {
                        return Biomes.DEEP_LUKEWARM_OCEAN;
                    } else if (d > shallowOceanMin) {
                        return ExpansiveBiomes.biomeListShallow.get(1);
                    } else {
                        return Biomes.LUKEWARM_OCEAN;
                    }
                case NORMAL:
                    if (d < deepOceanDepth) {
                        return Biomes.DEEP_OCEAN;
                    } else if (d > shallowOceanMin) {
                        return ExpansiveBiomes.biomeListShallow.get(2);
                    } else {
                        return Biomes.OCEAN;
                    }
                case COLD:
                    if (d < deepOceanDepth) {
                        return Biomes.DEEP_COLD_OCEAN;
                    } else if (d > shallowOceanMin) {
                        return ExpansiveBiomes.biomeListShallow.get(3);
                    } else {
                        return Biomes.COLD_OCEAN;
                    }
                case FROZEN:
                    if (d < deepOceanDepth) {
                        return Biomes.DEEP_FROZEN_OCEAN;
                    } else if (d > shallowOceanMin) {
                        return ExpansiveBiomes.biomeListShallow.get(4);
                    } else {
                        return Biomes.FROZEN_OCEAN;
                    }
            }
        }
        else { //Not Ocean, aka land
            switch(temp)
            {
                case WARM:
                    return ExpansiveBiomes.biomeListWarm.get(0);
                case LUKEWARM:
                    return ExpansiveBiomes.biomeListLukeWarm.get(0);
                case NORMAL:
                    return ExpansiveBiomes.biomeListNormal.get(0);
                case COLD:
                    return ExpansiveBiomes.biomeListCold.get(0);
                case FROZEN:
                    return ExpansiveBiomes.biomeListFrozen.get(0);
            }
        }
        return ExpansiveBiomes.biomeListCold.get(1);
    }
    private final Biome[] allBiomes = new Biome[]{ //To depricate when structures are reworked
            Biomes.OCEAN, Biomes.FROZEN_OCEAN, Biomes.BEACH, Biomes.DEEP_OCEAN, Biomes.SNOWY_BEACH, Biomes.WARM_OCEAN,
            Biomes.LUKEWARM_OCEAN, Biomes.COLD_OCEAN, Biomes.DEEP_WARM_OCEAN, Biomes.DEEP_LUKEWARM_OCEAN,
            Biomes.DEEP_COLD_OCEAN, Biomes.DEEP_FROZEN_OCEAN
    };
    @Override
    public Biome[] getBiomes(int x, int z, int width, int length, boolean cacheFlag) {
        Biome[] biomes = new Biome[width * length];
        for (int dx = 0; dx < width; dx++) {
            for (int dy = 0; dy < length; dy++) {
                biomes[dy * width + dx] = getBiome(x + dx, z+dy);
            }
        }
        return biomes;
    }

    public Set<Biome> getBiomesInSquare(int i, int i1, int i2)
    {
        return null;
    }

    @Override
    public BlockPos findBiomePosition(int x, int z, int range, List<Biome> biomes, Random random) {
        int i = x - range >> 2;
        int j = z - range >> 2;
        int k = x + range >> 2;
        int l = z + range >> 2;
        int i1 = k - i + 1;
        int j1 = l - j + 1;
        Biome[] abiome = getBiomes(i, j, i1, j1, true);
        BlockPos blockpos = null;
        int k1 = 0;

        for(int l1 = 0; l1 < i1 * j1; ++l1) {
            int i2 = i + l1 % i1 << 2;
            int j2 = j + l1 / i1 << 2;
            if (biomes.contains(abiome[l1])) {
                if (blockpos == null || random.nextInt(k1 + 1) == 0) {
                    blockpos = new BlockPos(i2, 0, j2);
                }

                ++k1;
            }
        }

        return blockpos;
    }

    @Override
    public boolean hasStructure(Structure<?> structure) {
        return this.hasStructureCache.computeIfAbsent(structure, (s) -> {
            for(Biome biome : allBiomes) {
                if (biome.hasStructure(s)) {
                    return true;
                }
            }

            return false;
        });
    }

    public Set<BlockState> getSurfaceBlocks()
    {
        return null;
    }
}