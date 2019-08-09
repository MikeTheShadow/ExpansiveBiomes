package com.MikeTheShadow.ExpansiveBiomes.WorldGen.Biome;

import net.minecraft.entity.EntityClassification;
import net.minecraft.entity.EntityType;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.DefaultBiomeFeatures;
import net.minecraft.world.gen.PerlinNoiseGenerator;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.structure.*;
import net.minecraft.world.gen.surfacebuilders.SurfaceBuilder;

import java.util.Random;

/**
 * Based on {@link net.minecraft.world.biome.OceanBiome}. Changed depth to -0.3F and scale to 0.03F for shallower ocean.
 */

public class ShallowFrozenOceanBiome extends Biome {
    protected static final PerlinNoiseGenerator iceNoise = new PerlinNoiseGenerator(new Random(3456L), 3);
    public static final ShallowFrozenOceanBiome BIOME = new ShallowFrozenOceanBiome();
    public ShallowFrozenOceanBiome() {
        super((new Biome.Builder()).func_222351_a(SurfaceBuilder.field_215405_P, SurfaceBuilder.field_215425_v).precipitation(Biome.RainType.SNOW).category(Biome.Category.OCEAN).depth(-0.3F).scale(0.03F).temperature(0.0F).downfall(0.5F).waterColor(3750089).waterFogColor(329011).parent((String)null));
        this.addStructure(Feature.OCEAN_RUIN, new OceanRuinConfig(OceanRuinStructure.Type.COLD, 0.3F, 0.9F));
        this.addStructure(Feature.MINESHAFT, new MineshaftConfig(0.004D, net.minecraft.world.gen.feature.structure.MineshaftStructure.Type.NORMAL));
        this.addStructure(Feature.SHIPWRECK, new ShipwreckConfig(false));
        DefaultBiomeFeatures.addOceanCarvers(this);
        DefaultBiomeFeatures.addStructures(this);
        DefaultBiomeFeatures.addLakes(this);
        DefaultBiomeFeatures.addIcebergs(this);
        DefaultBiomeFeatures.addMonsterRooms(this);
        DefaultBiomeFeatures.addBlueIce(this);
        DefaultBiomeFeatures.addStoneVariants(this);
        DefaultBiomeFeatures.addOres(this);
        DefaultBiomeFeatures.addSedimentDisks(this);
        DefaultBiomeFeatures.func_222296_u(this);
        DefaultBiomeFeatures.addDefaultFlowers(this);
        DefaultBiomeFeatures.func_222348_W(this);
        DefaultBiomeFeatures.addMushrooms(this);
        DefaultBiomeFeatures.addReedsAndPumpkins(this);
        DefaultBiomeFeatures.addSprings(this);
        DefaultBiomeFeatures.addFreezeTopLayer(this);
        this.addSpawn(EntityClassification.WATER_CREATURE, new SpawnListEntry(EntityType.SQUID, 1, 1, 4));
        this.addSpawn(EntityClassification.WATER_CREATURE, new SpawnListEntry(EntityType.SALMON, 15, 1, 5));
        this.addSpawn(EntityClassification.CREATURE, new SpawnListEntry(EntityType.POLAR_BEAR, 1, 1, 2));
        this.addSpawn(EntityClassification.AMBIENT, new SpawnListEntry(EntityType.BAT, 10, 8, 8));
        this.addSpawn(EntityClassification.MONSTER, new SpawnListEntry(EntityType.SPIDER, 100, 4, 4));
        this.addSpawn(EntityClassification.MONSTER, new SpawnListEntry(EntityType.ZOMBIE, 95, 4, 4));
        this.addSpawn(EntityClassification.MONSTER, new SpawnListEntry(EntityType.DROWNED, 5, 1, 1));
        this.addSpawn(EntityClassification.MONSTER, new SpawnListEntry(EntityType.ZOMBIE_VILLAGER, 5, 1, 1));
        this.addSpawn(EntityClassification.MONSTER, new SpawnListEntry(EntityType.SKELETON, 100, 4, 4));
        this.addSpawn(EntityClassification.MONSTER, new SpawnListEntry(EntityType.CREEPER, 100, 4, 4));
        this.addSpawn(EntityClassification.MONSTER, new SpawnListEntry(EntityType.SLIME, 100, 4, 4));
        this.addSpawn(EntityClassification.MONSTER, new SpawnListEntry(EntityType.ENDERMAN, 10, 1, 4));
        this.addSpawn(EntityClassification.MONSTER, new SpawnListEntry(EntityType.WITCH, 5, 1, 1));
    }

    public float getTemperature(BlockPos p_180626_1_) {
        float lvt_2_1_ = this.getDefaultTemperature();
        double lvt_3_1_ = field_205163_aV.getValue((double)p_180626_1_.getX() * 0.05D, (double)p_180626_1_.getZ() * 0.05D);
        double lvt_5_1_ = INFO_NOISE.getValue((double)p_180626_1_.getX() * 0.2D, (double)p_180626_1_.getZ() * 0.2D);
        double lvt_7_1_ = lvt_3_1_ + lvt_5_1_;
        if (lvt_7_1_ < 0.3D) {
            double lvt_9_1_ = INFO_NOISE.getValue((double)p_180626_1_.getX() * 0.09D, (double)p_180626_1_.getZ() * 0.09D);
            if (lvt_9_1_ < 0.8D) {
                lvt_2_1_ = 0.2F;
            }
        }

        if (p_180626_1_.getY() > 64) {
            float lvt_9_2_ = (float)(TEMPERATURE_NOISE.getValue((double)((float)p_180626_1_.getX() / 8.0F), (double)((float)p_180626_1_.getZ() / 8.0F)) * 4.0D);
            return lvt_2_1_ - (lvt_9_2_ + (float)p_180626_1_.getY() - 64.0F) * 0.05F / 30.0F;
        } else {
            return lvt_2_1_;
        }
    }
}
