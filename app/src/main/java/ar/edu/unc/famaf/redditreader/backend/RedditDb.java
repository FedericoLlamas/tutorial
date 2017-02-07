package ar.edu.unc.famaf.redditreader.backend;

import android.provider.BaseColumns;

/**
 * Created by federico on 06/02/17.
 */

public class RedditDb {
    public static abstract class RedditEntry implements BaseColumns {
        public static final String TABLE_NAME="postModel";
        public static final String ID="id";
        public static final String AUTHOR="mAuthor";
        public static final String TITLE="mTitle";
        public static final String SUBREDDIT="mSubreddit";
        public static final String COMMENTS="comments";
        public  static final String SCORE = "score";
        public static final String CREATED="mCreated";
        public static final String URL="url";
        public static final String THUMBNAIL="thumbnail";
        public static  final String ICON = "icon";
        public static  final String NAME= "name";
//        public static  final String CLICKUP ="clickup";
//        public static  final String CLICDOWN = "clickdown";
    }
}