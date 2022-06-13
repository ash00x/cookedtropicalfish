package net.fabricmc.ctf;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.HoneyBlock;
import net.minecraft.block.ShapeContext;
import net.minecraft.entity.Entity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Vec3d;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.world.BlockView;
import net.minecraft.world.World;

public class JamBlock extends HoneyBlock {
    // slightly smaller... LOL !!!!
    protected static final VoxelShape SHAPE = Block.createCuboidShape(0.0, 0.0, 0.0, 0.0, 0.0, 0.0);

    public JamBlock(Settings settings) {
        super(settings);
    }

    @Override
    public VoxelShape getCollisionShape(BlockState state, BlockView world, BlockPos pos, ShapeContext context) {
        return SHAPE;
    }

    @Override
    public void onEntityCollision(BlockState state, World world, BlockPos pos, Entity entity) {
        entity.slowMovement(state, new Vec3d(1, 0.8, 1));
        super.onEntityCollision(state, world, pos, entity);
    }
    
}
