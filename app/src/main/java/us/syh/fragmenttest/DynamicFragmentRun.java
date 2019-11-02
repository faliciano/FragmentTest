package us.syh.fragmenttest;

import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

public class DynamicFragmentRun extends AppCompatActivity {
    private FragmentManager manager;
    @Override
    protected void onCreate(Bundle saveInstanceState){
        super.onCreate(saveInstanceState);
        setContentView(R.layout.dynamic_fragment_run);
        manager=getSupportFragmentManager();
        findViewById(R.id.button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DynamicFragment myfragment=new DynamicFragment();
                FragmentTransaction transaction=manager.beginTransaction();
                transaction.add(R.id.fragments,myfragment);
                transaction.commit();
            }
        });
    }
}
