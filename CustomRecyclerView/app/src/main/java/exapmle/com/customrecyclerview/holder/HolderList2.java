package exapmle.com.customrecyclerview.holder;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import exapmle.com.customrecyclerview.R;
import exapmle.com.customrecyclerview.model.ModelList;

/**
 * Created by GITAcerV3 on 5/5/2018.
 */

public class HolderList2 extends RecyclerView.ViewHolder{
    public ImageView img;
    public TextView title;

    public HolderList2(View itemView) {
        super(itemView);

        img         = itemView.findViewById(R.id.img2);
        title       = itemView.findViewById(R.id.title2);
    }
    public void bind(final ModelList model){
        img.setImageResource(model.getImg());
        title.setText(model.getTitle());


    }

}