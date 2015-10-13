package ninja.ollendev.transitiondemo;

import android.animation.Animator;
import android.animation.ObjectAnimator;
import android.transition.Transition;
import android.transition.TransitionValues;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by Chris Ollenburg on 10/13/15.
 *
 * Custom transition example
 */
public class BarGraphTransition extends Transition {
    private static final String PROPNAME_BAR_HEIGHT_SCALE = "ollendev.ninja.transitiondemo:BarGraphTransition:scale";

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
        Log.d("BarGraphTransition", "ID: " + view.getId() + " Top: " + view.getTop());
        transitionValues.values.put(PROPNAME_BAR_HEIGHT_SCALE, view.getScaleY());
    }

    @Override
    public Animator createAnimator(ViewGroup sceneRoot, TransitionValues startValues, TransitionValues endValues) {
        View view = startValues.view;
        ObjectAnimator scaleYAnimator = ObjectAnimator.ofFloat(view, "scaleY", (float)startValues.values.get(PROPNAME_BAR_HEIGHT_SCALE), (float)endValues.values.get(PROPNAME_BAR_HEIGHT_SCALE));
        return scaleYAnimator;
    }
}
