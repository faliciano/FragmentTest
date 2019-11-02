package us.syh.fragmenttest;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;

public class DynamicFragment extends Fragment {
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
        //在fragment中拿到Bundle对象
        Bundle bundle=getArguments();
        if(bundle!=null){
            String message=bundle.getString("message");
            
        }
        //定义一个view对象，并返回
        //第一个参数为上面定义的布局文件，第二参数为传入的参数，第三个参数一般设为false
        View view=inflater.inflate(R.layout.dynamic_fragment,container,false);
        return view;
    }
    //绑定字符串到fragment a
    public static DynamicFragment bundleStringToFragment(String message){
        DynamicFragment fragment=new DynamicFragment();
        Bundle bundle=new Bundle();
        bundle.putString("message",message);
        fragment.setArguments(bundle);
        return fragment;
    }
}
