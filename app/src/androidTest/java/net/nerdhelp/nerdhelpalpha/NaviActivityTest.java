package net.nerdhelp.nerdhelpalpha;

import android.support.test.espresso.ViewAction;
import android.support.test.espresso.ViewAssertion;
import android.support.test.espresso.assertion.ViewAssertions;
import android.support.test.runner.AndroidJUnit4;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.Espresso.pressBack;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.action.ViewActions.swipeUp;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withText;

/**
 * Created by joseph.mcenery on 5/23/16.
 */
@RunWith(AndroidJUnit4.class)

public class NaviActivityTest {
    @Rule
    public final ActivityRule<NaviActivity> example = new ActivityRule<>(NaviActivity.class);

    @Test
    public void threeMainButtonsExist() {
        onView(withText("Create a new service request")).perform(click());
        pressBack();
        swipeUp();
        onView(withText("Welcome!")).check(matches(isDisplayed()));
        pressBack();

    }
}

