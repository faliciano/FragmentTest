package us.syh.fragmenttest;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.fragment.app.Fragment;

public class DynamicFragment extends Fragment {
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
        //定义一个view对象，并返回
        //第一个参数为上面定义的布局文件，第二参数为传入的参数，第三个参数一般设为false
        View view=inflater.inflate(R.layout.dynamic_fragment,container,false);
        //在fragment中拿到Bundle对象
        Bundle bundle = getArguments();
        if (bundle != null) {
            final String message = bundle.getString("message");
            TextView textView = view.findViewById(R.id.textView);
            LinearLayout linearlayout = view.findViewById(R.id.linearlayout);
            Button but = new Button(view.getContext());
            but.setText("传递值到Acitivity");
            but.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Toast.makeText(getContext(), "已传值到activity", Toast.LENGTH_LONG).show();
                    getArguments().putString("message", "我来自Fragmernt哦！接收到的消息：(" + message + ")");
                }
            });
            linearlayout.addView(but);
            textView.setText(message);
        }
        return view;
    }
}
