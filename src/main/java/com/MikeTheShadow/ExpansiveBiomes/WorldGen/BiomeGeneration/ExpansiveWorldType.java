package com.MikeTheShadow.ExpansiveBiomes.WorldGen.BiomeGeneration;

import com.MikeTheShadow.ExpansiveBiomes.WorldGen.BiomeGeneration.ExpansiveOverworldProvider;
import com.MikeTheShadow.ExpansiveBiomes.WorldGen.BiomeGeneration.ExpansiveChunkGenerator;
import net.minecraft.world.World;
import net.minecraft.world.WorldType;
import net.minecraft.world.biome.provider.OverworldBiomeProviderSettings;
import net.minecraft.world.dimension.DimensionType;
import net.minecraft.world.gen.ChunkGenerator;
import net.minecraft.world.gen.OverworldChunkGenerator;
import net.minecraft.world.gen.OverworldGenSettings;

public class ExpansiveWorldType extends WorldType {
    public ExpansiveWorldType()
    {
        super("expansivebiomes");
    }

    @Override
    public ChunkGenerator<?> createChunkGenerator(World world)
    {
        if(world.getDimension().getType() == DimensionType.OVERWORLD)
        {
            OverworldGenSettings overworldGenSettings = new OverworldGenSettings();
            OverworldBiomeProviderSettings overworldBiomeProviderSettings = new OverworldBiomeProviderSettings();
            overworldBiomeProviderSettings.setWorldInfo(world.getWorldInfo());
            overworldBiomeProviderSettings.setGeneratorSettings(overworldGenSettings);
            return new ExpansiveChunkGenerator(world, new ExpansiveOverworldProvider(overworldBiomeProviderSettings), overworldGenSettings);
        }
        return super.createChunkGenerator(world);
    }
}
