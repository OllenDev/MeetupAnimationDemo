package ninja.ollendev.transitiondemo;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.transition.AutoTransition;
import android.transition.ChangeBounds;
import android.transition.ChangeImageTransform;
import android.transition.ChangeTransform;
import android.transition.Slide;
import android.transition.Transition;
import android.transition.TransitionManager;
import android.transition.TransitionSet;
import android.view.Gravity;
import android.view.View;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * An example intro screen to show a simple transition.
 */
public class WelcomeActivity extends AppCompatActivity implements Transition.TransitionListener {
    @Bind(R.id.root) FrameLayout rootLayout;
    @Bind(R.id.snowflakeLayout) RelativeLayout snowflakeLayout;
    @Bind(R.id.triangle1) View triangle1;
    @Bind(R.id.triangle2) View triangle2;
    @Bind(R.id.triangle3) View triangle3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_welcome);

        ButterKnife.bind(this);

        snowflakeLayout.setVisibility(View.GONE);
        triangle1.setVisibility(View.GONE);
        triangle2.setVisibility(View.GONE);
        triangle3.setVisibility(View.GONE);
    }

    @Override
    protected void onResume() {
        super.onResume();
    }

    @OnClick(R.id.enter_button)
    public void enterClicked() {
        animateIntro();
    }

    private void animateIntro() {
        startTransition();
        snowflakeLayout.setVisibility(View.VISIBLE);
        triangle1.setVisibility(View.VISIBLE);
        triangle2.setVisibility(View.VISIBLE);
        triangle3.setVisibility(View.VISIBLE);
    }

    private void startTransition() {
        Slide slideTop = new Slide(Gravity.TOP);
        slideTop.addTarget(snowflakeLayout);
        Slide slideBottom = new Slide(Gravity.BOTTOM);
        slideBottom.addTarget(triangle1)
                .addTarget(triangle2)
                .addTarget(triangle3);
        TransitionSet transitionSet = new TransitionSet()
                .addTransition(slideTop)
                .addTransition(slideBottom)
                .setOrdering(TransitionSet.ORDERING_TOGETHER)
                .setDuration(1000)
                .setInterpolator(new AccelerateDecelerateInterpolator());
        transitionSet.addListener(this);
        TransitionManager.beginDelayedTransition(rootLayout, transitionSet);
    }

    @Override
    public void onTransitionStart(Transition transition) {

    }

    @Override
    public void onTransitionEnd(Transition transition) {
        Intent intent = new Intent(this, SnowReportActivity.class);
        startActivity(intent);
    }

    @Override
    public void onTransitionCancel(Transition transition) {

    }

    @Override
    public void onTransitionPause(Transition transition) {

    }

    @Override
    public void onTransitionResume(Transition transition) {

    }
}
