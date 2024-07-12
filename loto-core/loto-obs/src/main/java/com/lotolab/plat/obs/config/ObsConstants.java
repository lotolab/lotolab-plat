package com.lotolab.plat.obs.config;

public class ObsConstants {

    public static final String OBS_AVATAR_PREFIX = "avatars";

    public static String buildAvatarSubPath(final String path) {
        return path.startsWith("/") ? OBS_AVATAR_PREFIX  +path:  OBS_AVATAR_PREFIX + "/" +path;
    }
}
