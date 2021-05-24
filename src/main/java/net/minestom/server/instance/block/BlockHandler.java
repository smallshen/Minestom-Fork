package net.minestom.server.instance.block;

import net.minestom.server.entity.Player;
import net.minestom.server.instance.Instance;
import net.minestom.server.utils.BlockPosition;
import net.minestom.server.utils.NamespaceID;
import org.jetbrains.annotations.NotNull;

public interface BlockHandler {

    /**
     * Called when a block has been placed.
     *
     * @param instance      the instance of the block
     * @param block         the block
     * @param blockPosition the position of the block
     */
    void onPlace(@NotNull Instance instance, @NotNull Block block, @NotNull BlockPosition blockPosition);

    /**
     * Called when a block has been destroyed or replaced.
     *
     * @param instance      the instance of the block
     * @param block         the block
     * @param blockPosition the position of the block
     */
    void onDestroy(@NotNull Instance instance, @NotNull Block block, @NotNull BlockPosition blockPosition);

    /**
     * Handles interactions with this block. Can also block normal item use (containers should block when opening the
     * menu, this prevents the player from placing a block when opening it for instance).
     *
     * @param player        the player interacting
     * @param hand          the hand used to interact
     * @param block         the block
     * @param blockPosition the position of this block
     * @return true if this block blocks normal item use, false otherwise
     */
    boolean onInteract(@NotNull Player player, @NotNull Player.Hand hand,
                       @NotNull Block block, @NotNull BlockPosition blockPosition);

    /**
     * Gets the drag of this block.
     * <p>
     * Has to be between 0 and 1.
     *
     * @param instance      the instance of the block
     * @param block         the block
     * @param blockPosition the block position
     * @return the drag to apply
     */
    default float getDrag(@NotNull Instance instance, @NotNull Block block, @NotNull BlockPosition blockPosition) {
        return 0.5f;
    }

    /**
     * Gets the id of this handler.
     * <p>
     * Used to write the block entity in the anvil world format.
     *
     * @return the namespace id of this handler
     */
    @NotNull NamespaceID getNamespaceId();
}
