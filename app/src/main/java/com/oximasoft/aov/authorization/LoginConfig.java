package com.oximasoft.aov.authorization;

public class LoginConfig {

    public static final String URL_PATH = "https://oauth.vk.com/authorize?";
    public static final String CLIENT_ID = "client_id=6003080";
    public static final String REDIRECT_URI = "&redirect_uri=https://oauth.vk.com/blank.html";
    public static final String SCOPE = "&scope=";
    public static final String RESPONSE_TYPE = "&response_type=token";
    public static final String VERSION = "&v=5.63";

    public static final String TOKEN_FILTER = "access_token";

    public static final class Scope {
        public static final String NOTIFY = "notify";
        public static final String FRIENDS = "friends";
        public static final String PHOTOS = "photos";
        public static final String AUDIO = "audio";
        public static final String PAGES = "pages";
        public static final String STATUS = "status";
        public static final String NOTES = "notes";
        public static final String MESSAGES = "messages";
        public static final String ADS = "ads";
        public static final String OFFLINE = "offline";
        public static final String DOCS = "docs";
        public static final String NOTIFICATIONS = "notifications";
        public static final String STATS = "stats";
        public static final String EMAIL = "email";
        public static final String MASRKET = "market";
    }

    public static String configureLoginUrl(String... scopes) {
        String url = URL_PATH + CLIENT_ID + REDIRECT_URI + SCOPE;
        for (String scope : scopes) url = url.concat(scope);
        return url + RESPONSE_TYPE + VERSION;
    }
}
