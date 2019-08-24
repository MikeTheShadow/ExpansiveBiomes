package com.MikeTheShadow.ExpansiveBiomes.WorldGen.BiomeGeneration;

import com.MikeTheShadow.ExpansiveBiomes.ExpansiveBiomes;
import com.MikeTheShadow.ExpansiveBiomes.WorldGen.Biome.CustomBiomes.ShieldBiome;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.gen.area.IAreaFactory;
import net.minecraft.world.gen.area.LazyArea;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class ExpansiveLayer
{
    private static final Logger LOGGER = LogManager.getLogger();
    private final LazyArea lazyArea;

    public ExpansiveLayer(IAreaFactory<LazyArea> lazyAreaFactoryIn) {
        this.lazyArea = lazyAreaFactoryIn.make();
    }

    public Biome[] generateBiomes(int startX, int startZ, int xSize, int zSize)
    {
        Biome[] abiome = new Biome[xSize * zSize];
        for(int i = 0; i < zSize; ++i)
        {
            for(int j = 0; j < xSize; ++j)
            {
                int k = this.lazyArea.getValue(startX + j, startZ + i);
                Biome biome = this.getBiomeFromInteger(k);
                //LOGGER.info("Value of Biome: " + k);
                abiome[j + i * xSize] = biome;
            }
        }
        return abiome;
    }

    private Biome getBiomeFromInteger(int biomeNum)
    {
        if(biomeNum < ExpansiveBiomes.biomeListAll.length - 1)
        {
            return ExpansiveBiomes.biomeListAll[biomeNum];
        }
        else
        {
            return ShieldBiome.BIOME;
        }
    }

    public Biome func_215738_a(int p_215738_1_, int p_215738_2_)
    {
        return this.getBiomeFromInteger(this.lazyArea.getValue(p_215738_1_, p_215738_2_));
    }
}
