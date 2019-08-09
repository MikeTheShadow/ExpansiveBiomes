package com.MikeTheShadow.ExpansiveBiomes.WorldGen.Biome;

import com.MikeTheShadow.ExpansiveBiomes.ExpansiveBiomes;
import com.MikeTheShadow.ExpansiveBiomes.WorldGen.BiomeGeneration.ExpansiveSurfaceBuilder;
import com.MikeTheShadow.ExpansiveBiomes.WorldGen.BiomeFeatures.ExpansiveBiomeFeatures;
import net.minecraft.entity.EntityClassification;
import net.minecraft.entity.EntityType;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.DefaultBiomeFeatures;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.IFeatureConfig;
import net.minecraft.world.gen.feature.structure.MineshaftConfig;
import net.minecraft.world.gen.feature.structure.MineshaftStructure;
import net.minecraft.world.gen.feature.structure.PillagerOutpostConfig;
import net.minecraft.world.gen.feature.structure.VillageConfig;
import net.minecraft.world.gen.surfacebuilders.SurfaceBuilder;

public class ShieldBiome extends Biome
{
    public static final ShieldBiome BIOME = new ShieldBiome();
    public ShieldBiome() {
        super((new Biome.Builder()).func_222351_a(SurfaceBuilder.field_215396_G, ExpansiveSurfaceBuilder.shieldConfig).precipitation(RainType.SNOW).category(Category.TAIGA).depth(0.125F).scale(0.05F).temperature(2.0F).downfall(0.8F).waterColor(4159204).waterFogColor(329011).parent((String)null));
        this.addStructure(Feature.field_214550_p, new VillageConfig("village/taiga/town_centers", 6));
        this.addStructure(Feature.field_214536_b, new PillagerOutpostConfig(0.004D));
        this.addStructure(Feature.MINESHAFT, new MineshaftConfig(0.004D, MineshaftStructure.Type.NORMAL));
        this.addStructure(Feature.STRONGHOLD, IFeatureConfig.NO_FEATURE_CONFIG);
        DefaultBiomeFeatures.func_222300_a(this);
        DefaultBiomeFeatures.func_222295_c(this);
        DefaultBiomeFeatures.func_222301_e(this);
        DefaultBiomeFeatures.func_222335_f(this);
        //DefaultBiomeFeatures.func_222326_g(this);
        ExpansiveBiomeFeatures.generateDirtAndGravelUnderground(this);
        DefaultBiomeFeatures.func_222288_h(this);
        DefaultBiomeFeatures.func_222282_l(this);
        DefaultBiomeFeatures.func_222342_U(this);
        DefaultBiomeFeatures.func_222348_W(this);
        DefaultBiomeFeatures.func_222334_S(this);
        DefaultBiomeFeatures.func_222315_Z(this);
        ExpansiveBiomeFeatures.water_puddle_2(this);
        DefaultBiomeFeatures.func_222281_af(this);
        DefaultBiomeFeatures.func_222297_ap(this);
        this.addSpawn(EntityClassification.CREATURE, new SpawnListEntry(EntityType.RABBIT, 4, 2, 3));
        this.addSpawn(EntityClassification.AMBIENT, new SpawnListEntry(EntityType.BAT, 10, 8, 8));
        this.addSpawn(EntityClassification.MONSTER, new SpawnListEntry(EntityType.SPIDER, 100, 4, 4));
        this.addSpawn(EntityClassification.MONSTER, new SpawnListEntry(EntityType.SKELETON, 100, 4, 4));
        this.addSpawn(EntityClassification.MONSTER, new SpawnListEntry(EntityType.CREEPER, 100, 4, 4));
        this.addSpawn(EntityClassification.MONSTER, new SpawnListEntry(EntityType.SLIME, 100, 4, 4));
        this.addSpawn(EntityClassification.MONSTER, new SpawnListEntry(EntityType.ENDERMAN, 10, 1, 4));
        this.addSpawn(EntityClassification.MONSTER, new SpawnListEntry(EntityType.ZOMBIE, 19, 4, 4));
        this.addSpawn(EntityClassification.MONSTER, new SpawnListEntry(EntityType.ZOMBIE_VILLAGER, 1, 1, 1));
        this.addSpawn(EntityClassification.AMBIENT, new SpawnListEntry(EntityType.POLAR_BEAR,2, 1, 1));
    }
}
