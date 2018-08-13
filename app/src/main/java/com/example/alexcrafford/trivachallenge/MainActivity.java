package com.example.alexcrafford.trivachallenge;

import com.example.alexcrafford.trivachallenge.ui.question.ViewKey;
import com.zhuinden.simplestack.HistoryBuilder;
import com.zhuinden.simplestack.navigator.DefaultStateChanger;
import com.zhuinden.simplestack.navigator.Navigator;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.FrameLayout;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = MainActivity.class.getSimpleName();

    @BindView(R.id.views_container)
    FrameLayout container;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        Navigator.configure().setStateChanger(DefaultStateChanger.create(this, container))
                .install(this, container, HistoryBuilder.single(ViewKey.create()));
    }

    @Override
    public void onBackPressed() {
        if (!Navigator.onBackPressed(this)) {
            super.onBackPressed();
        }
    }
}
