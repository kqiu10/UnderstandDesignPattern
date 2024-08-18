package org.behaviorPattern.chainOfResponsibility.impl.chainNode;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class AuthInfo {
    private static final Logger log = LogManager.getLogger();
    private String userId;
    private String userInfo;
    private EnumAuthLevel authLevel;

    public AuthInfo(final String userId, final String userInfo, final EnumAuthLevel authLevel) {
        this.userId = userId;
        this.userInfo = userInfo;
        this.authLevel = authLevel;
    }

    public EnumAuthLevel getAuthLevel() {
        return authLevel;
    }

    public void setAuthLevel(final EnumAuthLevel authLevel) {
        this.authLevel = authLevel;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(final String userId) {
        this.userId = userId;
    }

    public String getUserInfo() {
        return userInfo;
    }

    public void setUserInfo(final String userInfo) {
        this.userInfo = userInfo;
    }

    public void getAuthInfo() {
        log.info("Auth info, userId \t {}, userInfo \t {}, authLevel \t {}", userId, userInfo, authLevel.name());
    }
}
