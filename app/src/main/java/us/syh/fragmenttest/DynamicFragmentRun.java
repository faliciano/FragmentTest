package us.syh.fragmenttest;

import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

public class DynamicFragmentRun extends AppCompatActivity {
    private FragmentManager manager;
    private DynamicFragment myfragment;
    @Override
    protected void onCreate(Bundle saveInstanceState){
        super.onCreate(saveInstanceState);
        setContentView(R.layout.dynamic_fragment_run);
        manager=getSupportFragmentManager();
        findViewById(R.id.button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                myfragment=new DynamicFragment();
                //在activity中绑定数据到fragment:开始
                Bundle bundle=new Bundle();
                bundle.putString("message","Hello,I am from fragment A!");
                myfragment.setArguments(bundle);
                //在activity中绑定数据到fragment:结束
                FragmentTransaction transaction=manager.beginTransaction();
                transaction.add(R.id.fragments,myfragment);
                transaction.commit();
            }
        });
        findViewById(R.id.button_sent_message).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DynamicFragment fragment=myfragment.bundleStringToFragment("HHHHHHHH!!!!    ");
            }
        });
    }
}
