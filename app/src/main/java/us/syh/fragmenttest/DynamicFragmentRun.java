package us.syh.fragmenttest;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import java.text.SimpleDateFormat;
import java.util.Date;

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
                //activity传值到fragment:开始
                Bundle bundle=new Bundle();
                bundle.putString("message","Hello,I am from fragment A!");
                myfragment.setArguments(bundle);
                //activity传值到fragment:结束
                FragmentTransaction transaction=manager.beginTransaction();
                transaction.add(R.id.fragments,myfragment);
                transaction.commit();
            }
        });
        findViewById(R.id.button_sent_message).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SimpleDateFormat sdf = new SimpleDateFormat();// 格式化时间
                sdf.applyPattern("yyyy-MM-dd HH:mm:ss a");// a为am/pm的标记
                Date date = new Date();// 获取当前时间
                //activity传值到fragment
                myfragment = new DynamicFragment();
                Bundle bundle = new Bundle();
                bundle.putString("message", "Hello,Fragment!\n时间:" + sdf.format(date));
                myfragment.setArguments(bundle);
                FragmentTransaction transaction = manager.beginTransaction();
                transaction.add(R.id.fragments, myfragment);
                transaction.commit();
            }
        });
        findViewById(R.id.button_receive_message).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Bundle bundle = myfragment.getArguments();
                String message = bundle.getString("message");
                Toast.makeText(DynamicFragmentRun.this, message, Toast.LENGTH_LONG).show();
            }
        });
    }
}
