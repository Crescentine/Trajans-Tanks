package com.crescentine.trajanstanks.block.platingpress;

import com.crescentine.trajanstanks.block.crafter.CrafterBlockEntity;
import com.crescentine.trajanstanks.container.CrafterContainer;
import com.crescentine.trajanstanks.container.PlatingPressContainer;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.network.chat.TranslatableComponent;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.MenuProvider;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.EntityBlock;
import net.minecraft.world.level.block.HorizontalDirectionalBlock;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityTicker;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraftforge.network.NetworkHooks;
import org.jetbrains.annotations.Nullable;

public class PlatingPressBlock extends HorizontalDirectionalBlock implements EntityBlock {
    public PlatingPressBlock(Properties properties) {
        super(properties);
        registerDefaultState(defaultBlockState().setValue(FACING, Direction.NORTH));
    }
    @Override
    public BlockState getStateForPlacement(BlockPlaceContext context) {
        return defaultBlockState().setValue(FACING, context.getHorizontalDirection().getOpposite());
    }


    @Override
    public BlockEntity newBlockEntity(BlockPos pos, BlockState state) {
        return new PlatingPressBlockEntity(pos, state);
    }

    @Override
    public InteractionResult use(BlockState state, Level level, BlockPos pos, Player player, InteractionHand hand,
                                 BlockHitResult result) {
        if (!level.isClientSide && level.getBlockEntity(pos) instanceof final PlatingPressBlockEntity crafter) {
            MenuProvider containerProvider = createContainerProvider(level, pos);
            NetworkHooks.openGui((ServerPlayer) player, containerProvider, pos);
        }

        return InteractionResult.SUCCESS;
    }

    private MenuProvider createContainerProvider(Level worldIn, BlockPos pos) {
        return new MenuProvider() {
            @Override
            public TranslatableComponent getDisplayName() {
                return new TranslatableComponent("Plating Press");
            }

            @Override
            public AbstractContainerMenu createMenu(int i, Inventory playerInventory, Player playerEntity) {
                return new PlatingPressContainer(i, worldIn, pos, playerInventory, playerEntity);
            }
        };
    }

    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
        super.createBlockStateDefinition(builder);
        builder.add(FACING);
    }
    @Nullable
    @Override
    public <T extends BlockEntity> BlockEntityTicker<T> getTicker(Level world, BlockState state, BlockEntityType<T> type) {
        return ((tickerWorld, pos, tickerState, blockEntity) -> PlatingPressBlockEntity.tick(tickerWorld, (PlatingPressBlockEntity) blockEntity));
    }
}
