package com.example.macintosh.calculator;

import android.content.Context;
import android.support.test.InstrumentationRegistry;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.action.ViewActions.longClick;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;
import static org.junit.Assert.assertEquals;

/**
 * Instrumentation test, which will execute on an Android device.
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
@RunWith(AndroidJUnit4.class)
public class MainActivityTest {

    Function function;
    FunctionSummaryProvider summaryProvider;
    @Rule
    public final ActivityTestRule<MainActivity> mRule = new ActivityTestRule<>(MainActivity.class);

    @Before
    public void setup(){
        function = new Function(new OperatorFactory());
        summaryProvider = new FunctionSummaryProvider();
    }
    @Test
    public void test_something() throws Exception {
        // Press some buttons
        onView(withId(R.id.btn1)).perform(click());
        onView(withId(R.id.btnPlus)).perform(click());
        onView(withId(R.id.btn1)).perform(click());
        onView(withId(R.id.btnEquals)).perform(click());

        // Check that the text was changed.
        onView(withId(R.id.TextField)).check(matches(withText("1+1")));
        onView(withId(R.id.TextFieldAnswer)).check(matches(withText("2")));

        onView(withId(R.id.btnClear)).perform(longClick());
        onView(withId(R.id.TextField)).check(matches(withText("")));
        onView(withId(R.id.TextFieldAnswer)).check(matches(withText("")));

        test_ten_minus_five();
        three_minus_five();


    }

    @Ignore
    public void test_ten_minus_five() throws Exception{
        onView(withId(R.id.btn1)).perform(click());
        onView(withId(R.id.btn0)).perform(click());
        onView(withId(R.id.btnSubtract)).perform(click());
        onView(withId(R.id.btn5)).perform(click());

        onView(withId(R.id.btnEquals)).perform(click());

        onView(withId(R.id.TextField)).check(matches(withText("10-5")));
        onView(withId(R.id.TextFieldAnswer)).check(matches(withText("5")));

        onView(withId(R.id.btnClear)).perform(click());

    }

    @Ignore
    public void three_minus_five () throws Exception{
        onView(withId(R.id.btn3)).perform(click());
        onView(withId(R.id.btnSubtract)).perform(click());
        onView(withId(R.id.btn5)).perform(click());
        onView(withId(R.id.btnEquals)).perform(click());

        onView(withId(R.id.TextField)).check(matches(withText("10-3-5")));
        onView(withId(R.id.TextFieldAnswer)).check(matches(withText("2")));

        //for(int i=0; i <function.getNumbersListSize())
    }
}
