package com.MikeTheShadow.ExpansiveBiomes.WorldGen;

import com.MikeTheShadow.ExpansiveBiomes.WorldGen.BiomeGeneration.ExpansiveChunkGenerator;
import net.minecraft.world.World;
import net.minecraft.world.WorldType;
import net.minecraft.world.gen.ChunkGenerator;

public class ExpansiveWorldType extends WorldType {
    public ExpansiveWorldType() {
        super("expansivebiomes");
    }

    @Override
    public ChunkGenerator<?> createChunkGenerator(World world) {
        if (world.getDimension().isSurfaceWorld()) {
            return new ExpansiveChunkGenerator(world);
        } else {
            return super.createChunkGenerator(world);
        }
    }
}
