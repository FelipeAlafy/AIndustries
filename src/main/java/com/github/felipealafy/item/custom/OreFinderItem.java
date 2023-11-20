package com.github.felipealafy.item.custom;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemUsageContext;
import net.minecraft.text.Text;
import net.minecraft.util.ActionResult;
import net.minecraft.util.math.BlockPos;

public class OreFinderItem extends Item {
    private Block[] ores = {Blocks.IRON_ORE, Blocks.COAL_ORE, Blocks.COPPER_ORE, Blocks.GOLD_ORE, Blocks.DIAMOND_ORE, Blocks.LAPIS_ORE, Blocks.DEEPSLATE_IRON_ORE, Blocks.DEEPSLATE_COAL_ORE, Blocks.DEEPSLATE_COPPER_ORE, Blocks.DEEPSLATE_GOLD_ORE, Blocks.DEEPSLATE_DIAMOND_ORE, Blocks.DEEPSLATE_LAPIS_ORE, Blocks.ANCIENT_DEBRIS, Blocks.NETHER_GOLD_ORE};
    private static class Result {
        private Block block;
        private boolean statement = false;

        public Result(Block Block, boolean Statement) {
            this.block = Block;
            this.statement = Statement;
        }

        public Block getBlock() {
            return block;
        }

        public void setBlock(Block block) {
            this.block = block;
        }

        public boolean isStatement() {
            return statement;
        }

        public void setStatement(boolean statement) {
            this.statement = statement;
        }
    }
    public OreFinderItem(Settings settings) {
        super(settings);
    }

    @Override
    public ActionResult useOnBlock(ItemUsageContext context) {
        if (!context.getWorld().isClient) {
            BlockPos positionClicked = context.getBlockPos();
            PlayerEntity pEntity = context.getPlayer();
            boolean foundBlock = false;

            for (int i = 0; i < positionClicked.getY() + 64; i++) {
                BlockState state = context.getWorld().getBlockState(positionClicked.down(i));
                if (isValuableBlock(state).isStatement()) {
                    outputValuableCoordinates(positionClicked.down(i), pEntity, state.getBlock());
                    foundBlock = true;
                }
            }
            if (!foundBlock && pEntity != null) {
                pEntity.sendMessage(Text.literal("Nothing had been founded."), true);
            }
        }

        context.getStack().damage(1, context.getPlayer(), playerEntity -> playerEntity.sendToolBreakStatus(playerEntity.getActiveHand()));

        return ActionResult.SUCCESS;
    }

    private void outputValuableCoordinates(BlockPos blockPos, PlayerEntity player, Block block) {
        player.sendMessage(Text.literal("Found " + block.asItem().getName().getString() + " at (X: " +
                blockPos.getX() + ", Y: " + blockPos.getY() + ", Z: " + blockPos.getZ() + ")"), false);
    }

    private Result isValuableBlock(BlockState state) {
        Result result = new Result(null, false);
        for (int i = 0; i < ores.length; i++) {
            if (state.isOf(ores[i])) {
                result.setStatement(true);
                result.setBlock(ores[i]);
                break;
            }
        }
        return result;
    }
}
