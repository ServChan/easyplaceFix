package org.uiop.easyplacefix.until;

import com.tick_ins.packet.Ping2Server;
import net.minecraft.block.BlockState;
import net.minecraft.util.math.BlockPos;

import static org.uiop.easyplacefix.EasyPlaceFix.LOGGER;

import java.util.Map;
import java.util.concurrent.*;

public class PlayerBlockAction {
    // Single-thread state holder

    public static class openScreenAction {
        public static volatile int count = 0;

        public static boolean run() {
            return count == 0;
        }
    }

    public static class openSignEditorAction {
        public static volatile int count = 0;

        public static boolean run() {
            return count == 0;

        }

    }

    public static class useItemOnAction {
        public static volatile float yawLock, pitchLock = 0;
        public static boolean modifyBoolean = false;
        // Thread-safe placement cooldown cache
        public static Map<BlockPos, Long> lastPlacementTimeMap = new ConcurrentHashMap<>();
        public static BlockState pistonBlockState = null;
        //   TODO Needs a better long-term design ^

        public static boolean isPlacementCooling(BlockPos pos) {
            long now = System.currentTimeMillis();

            if (lastPlacementTimeMap.containsKey(pos)) {
                long lastPlaceTime = lastPlacementTimeMap.get(pos);
                if (now - lastPlaceTime > Ping2Server.getRtt() + 100) {
                    lastPlacementTimeMap.put(pos, now);//Refresh cooldown entry after timeout
                    return false;
                } else {
                    if (LOGGER.isDebugEnabled()) {
                        LOGGER.debug("EasyPlace cooldown hit at {} (elapsed={}ms, threshold={}ms)",
                                pos, now - lastPlaceTime, Ping2Server.getRtt() + 100);
                    }
                    return true;
                }
            }
            lastPlacementTimeMap.put(pos, now);//Insert cooldown entry when missing
            return false;

        }
    }
}
