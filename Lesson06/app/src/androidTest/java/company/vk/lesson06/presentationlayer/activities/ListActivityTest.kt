package company.vk.lesson06.presentationlayer.activities

import androidx.recyclerview.widget.RecyclerView.ViewHolder
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.IdlingRegistry
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.assertion.ViewAssertions
import androidx.test.espresso.contrib.RecyclerViewActions
import androidx.test.espresso.matcher.ViewMatchers
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.ext.junit.rules.activityScenarioRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import company.vk.lesson06.R
import company.vk.lesson06.misc.WaitIdlingResource
import company.vk.lesson06.misc.RecyclerPositionMatcher
import company.vk.lesson06.misc.RecyclerWaitDataAction
import org.junit.After
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class ListActivityTest { @get:Rule
    var activityScenarioRule = activityScenarioRule<ListActivity>()

//    protected val currentIdlingResource = WaitIdlingResource()

    @Before
    fun setUp() {
//        currentIdlingResource.reset()
//        IdlingRegistry.getInstance().register(currentIdlingResource)
    }

    @After
    fun tearDown() {
//        IdlingRegistry.getInstance().unregister(currentIdlingResource)
    }


    @Test
    fun check_data() {
        onView(withId(R.id.recycler)).perform(RecyclerWaitDataAction())
        onView(withId(R.id.recycler)).perform(RecyclerViewActions.actionOnItemAtPosition<ViewHolder>(0, click()))
    }

    @Test
    fun check_abradolf_clincler() {
        onView(withId(R.id.recycler)).perform(RecyclerWaitDataAction())
        onView(withId(R.id.recycler)).perform(RecyclerViewActions.scrollToPosition<ViewHolder>(6))
        onView(withId(R.id.recycler)).check(ViewAssertions.matches(RecyclerPositionMatcher(6, ViewMatchers.hasDescendant(ViewMatchers.withText("Abradolf Lincler")))))
        onView(withId(R.id.recycler)).check(ViewAssertions.matches(RecyclerPositionMatcher(6, ViewMatchers.hasDescendant(ViewMatchers.withText("Human")))))
    }
}