package us.syh.fragmenttest;

import android.os.Bundle;

import androidx.fragment.app.FragmentActivity;

public class StaticFragmentRun extends FragmentActivity {
    @Override
    protected void onCreate(Bundle saveInstanceState){
        super.onCreate(saveInstanceState);
        setContentView(R.layout.activity_static_fragment_run);
    }
}
