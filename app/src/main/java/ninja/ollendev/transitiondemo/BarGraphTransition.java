package ninja.ollendev.transitiondemo;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.graphics.Color;
import android.transition.Transition;
import android.transition.TransitionValues;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by Chris Ollenburg on 10/13/15.
 * <p/>
 * Custom transition example
 */
public class BarGraphTransition extends Transition {
    private static final String PROPNAME_BAR_HEIGHT_SCALE = "ollendev.ninja.transitiondemo:BarGraphTransition:scaleY";

    @Override
    public void captureStartValues(TransitionValues transitionValues) {
        captureValues(transitionValues);
    }

    @Override
    public void captureEndValues(TransitionValues transitionValues) {
        captureValues(transitionValues);
    }

    private void captureValues(TransitionValues transitionValues) {
        View view = transitionValues.view;
        transitionValues.values.put(PROPNAME_BAR_HEIGHT_SCALE, view.getScaleY());
    }

    @Override
    public Animator createAnimator(ViewGroup sceneRoot, TransitionValues startValues, TransitionValues endValues) {
        View view = startValues.view;
        AnimatorSet animatorSet = new AnimatorSet();
        ObjectAnimator scaleYAnimator = ObjectAnimator.ofFloat(view, "scaleY", (float) startValues.values.get(PROPNAME_BAR_HEIGHT_SCALE), (float) endValues.values.get(PROPNAME_BAR_HEIGHT_SCALE));
        ObjectAnimator colorAnimator = ObjectAnimator.ofArgb(view, "backgroundColor", Color.BLUE, Color.GREEN);
        animatorSet.playTogether(scaleYAnimator, colorAnimator);
        return animatorSet;
    }
}
