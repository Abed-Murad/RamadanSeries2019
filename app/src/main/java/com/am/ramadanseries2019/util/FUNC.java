package com.am.ramadanseries2019.util;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;


import com.am.ramadanseries2019.BuildConfig;
import com.am.ramadanseries2019.R;
import com.heinrichreimersoftware.androidissuereporter.IssueReporterLauncher;
import com.mikepenz.aboutlibraries.Libs;
import com.mikepenz.aboutlibraries.LibsBuilder;


public class FUNC {
    private static final String GITHUB_ACCESS_TOKEN = BuildConfig.GITHUB_ACCESS_TOKEN;

    public static void shareArticle(Context context, String title, String body) {
        String shareBody = title + "\n\n" + body + "\n\n\nSubscribe to PewDiePie";
        Intent sharingIntent = new Intent(Intent.ACTION_SEND);
        sharingIntent.setType("text/plain");
        sharingIntent.putExtra(Intent.EXTRA_SUBJECT, title);
        sharingIntent.putExtra(Intent.EXTRA_TEXT, shareBody);
        context.startActivity(Intent.createChooser(sharingIntent, context.getResources().getString(R.string.share_using)));
    }

    public static void startRateUsActivity(Context context) {
        context.startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("market://details?id=" + context.getPackageName())));
    }
    public static void startAboutActivity(Context context) {
        new LibsBuilder()
                .withActivityStyle(Libs.ActivityStyle.LIGHT_DARK_TOOLBAR)
                .withAboutIconShown(true)
                .withAboutVersionShown(true)
                .withAboutDescription(context.getString(R.string.about_libraries_description))
                .withFields(R.string.class.getFields())
                .start(context);
    }

    public static void startBugReportActivity(Context context) {
        IssueReporterLauncher.forTarget("Abed-Murad", "PersonalityDevelopmentApp")
                .guestToken(GITHUB_ACCESS_TOKEN)
                .guestEmailRequired(false)
                .minDescriptionLength(20)
                .homeAsUpEnabled(true)
                .launch(context);
    }


}
