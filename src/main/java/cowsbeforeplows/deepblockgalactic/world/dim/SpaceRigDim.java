package cowsbeforeplows.deepblockgalactic.world.dim;


import javax.annotation.Nullable;

import cowsbeforeplows.deepblockgalactic.init.BiomeInit;
import cowsbeforeplows.deepblockgalactic.init.BlockInit;
import cowsbeforeplows.deepblockgalactic.init.DimInit;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.ChunkPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;
import net.minecraft.world.biome.provider.BiomeProviderType;
import net.minecraft.world.dimension.Dimension;
import net.minecraft.world.dimension.DimensionType;
import net.minecraft.world.gen.ChunkGenerator;
import net.minecraft.world.gen.GenerationSettings;

public class SpaceRigDim extends Dimension {
	
	
	public SpaceRigDim(World world, DimensionType type) {
		super(world, type, 0);
	}
	
	@Override
	public ChunkGenerator<?> createChunkGenerator() {
		GenerationSettings genSettings = DimInit.RIG_CHUNK.get().createSettings();
		genSettings.setDefaultBlock(BlockInit.GOLD_ORE.get().getDefaultState());
		return DimInit.RIG_CHUNK.get().create(this.world, BiomeProviderType.FIXED.create(BiomeProviderType.FIXED.createSettings(this.world.getWorldInfo()).setBiome(BiomeInit.SPACE_RIG.get())), genSettings);
	}
	
	@Nullable
	@Override
	public BlockPos findSpawn(ChunkPos chunkPosIn, boolean checkValid) {
		return null;
		
	}
	
    @Nullable
    @Override
    public BlockPos findSpawn(int posX, int posZ, boolean checkValid) {
        return null;
    }

    @Override
    public float calculateCelestialAngle(long worldTime, float partialTicks) {
        return 0.5f;
    }

//    @Override
//    public boolean isDaytime() {
//        return false;
//    }
    
    @Override
    public float getCloudHeight() {
        return 8.0F;
     }

//    @Override
//    public long getWorldTime() {
//        return 18000;
//    }

    @Override
    public boolean isSurfaceWorld() {
        return true;
    }

    @Override
    public Vec3d getFogColor(float celestialAngle, float partialTicks) {
        int i = 10518688;
        float f = MathHelper.cos(celestialAngle * ((float)Math.PI * 2F)) * 2.0F + 0.5F;
        f = MathHelper.clamp(f, 0.0F, 1.0F);
        float f1 = 0.627451F;
        float f2 = 0.5019608F;
        float f3 = 0.627451F;
        f1 = f1 * (f * 0.0F + 0.15F);
        f2 = f2 * (f * 0.0F + 0.15F);
        f3 = f3 * (f * 0.0F + 0.15F);
        return new Vec3d((double)f1, (double)f2, (double)f3);
    }

    @Override
    public boolean canRespawnHere() {
        return false;
    }

    @Override
    public int getMoonPhase(long worldTime) {
        return 0;
    }

    @Override
    public boolean doesXZShowFog(int x, int z) {
        return false;
    }
    
    @Override
    public boolean isSkyColored() {
        return false;
     }

    @Override
    public boolean hasSkyLight() {
        return false;
    }
}
