package org.uiop.easyplacefix.config;

import fi.dy.masa.malilib.config.IConfigBase;
import fi.dy.masa.malilib.config.options.ConfigBooleanHotkeyed;
import fi.dy.masa.malilib.config.options.ConfigInteger;

public final class easyPlacefixConfig {
    public static final ConfigBooleanHotkeyed LOOSEN_MODE =
            new ConfigBooleanHotkeyed("loosenMode", false, "","EasyPlaceFix.config.generic.comment.loosenMode");

    public static final ConfigBooleanHotkeyed IGNORE_NBT =
            new ConfigBooleanHotkeyed("nbtIgnore", false, "","EasyPlaceFix.config.generic.comment.nbtIgnore");
    public static final ConfigBooleanHotkeyed Allow_Interaction =
            new ConfigBooleanHotkeyed("AllowInteraction", false, "","EasyPlaceFix.config.generic.comment.AllowInteraction");
    public static final ConfigBooleanHotkeyed OBSERVER_DETECT =
            new ConfigBooleanHotkeyed("observerDetect", false,"","EasyPlaceFix.config.generic.comment.observerDetect");
    public static final ConfigBooleanHotkeyed ENABLE_FIX =
            new ConfigBooleanHotkeyed("enableFix", false,"","EasyPlaceFix.config.generic.comment.enableFix");
    public static final ConfigBooleanHotkeyed CLIENT_ROTATION_REVERT =
            new ConfigBooleanHotkeyed("clientRotationRevert", false,"","EasyPlaceFix.config.generic.comment.clientRotationRevert","Rotation Revert","Client Rotation Revert");
    public static final ConfigInteger PLACEMENT_DELAY =
            new ConfigInteger("placementDelay", 0, 0, 20, "EasyPlaceFix.config.generic.comment.placementDelay");


    public static IConfigBase[] getExtraGenericConfigs() {
        return new IConfigBase[]{
                ENABLE_FIX,
                LOOSEN_MODE,
                IGNORE_NBT,
                Allow_Interaction,
                OBSERVER_DETECT,
                CLIENT_ROTATION_REVERT,
                PLACEMENT_DELAY,
        };
    }
}
