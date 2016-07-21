package ninja.ollendev.transitiondemo;

import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.support.v7.app.AppCompatActivity;
import android.transition.TransitionManager;
import android.view.View;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.widget.LinearLayout;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class SnowReportActivity extends AppCompatActivity {
    @Bind(R.id.graphContainer) LinearLayout graphContainer;
    @Bind(R.id.sunBar) View sunBar;
    @Bind(R.id.monBar) View monBar;
    @Bind(R.id.tueBar) View tueBar;
    @Bind(R.id.wedBar) View wedBar;
    @Bind(R.id.thuBar) View thuBar;
    @Bind(R.id.friBar) View friBar;
    @Bind(R.id.satBar) View satBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_snow_report);
        ButterKnife.bind(this);
    }

    @Override
    protected void onResume() {
        super.onResume();

        Handler handler = new Handler(Looper.getMainLooper());
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                animateGraph();
            }
        };
        handler.postDelayed(runnable, 500);
//        animateGraph();
    }

    @OnClick(R.id.animate)
    void onAnimateClicked() {
        animateGraph();
    }

    private void animateGraph() {
        startTransition();
        sunBar.setScaleY(0.5f);
        monBar.setScaleY(0.25f);
        tueBar.setScaleY(0.45f);
        wedBar.setScaleY(0.75f);
        thuBar.setScaleY(0.10f);
        friBar.setScaleY(0.30f);
        satBar.setScaleY(0.45f);
    }

    private void startTransition() {
        BarGraphTransition transition = new BarGraphTransition();
                transition.setDuration(500l)
                .setInterpolator(new AccelerateDecelerateInterpolator());
        TransitionManager.beginDelayedTransition(graphContainer, transition);
    }
}
