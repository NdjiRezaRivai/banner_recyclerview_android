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

public class HolderList extends RecyclerView.ViewHolder{
    public ImageView img;
    public TextView title;
    public RelativeLayout dummySpace;

    public HolderList(View itemView) {
        super(itemView);

        img         = itemView.findViewById(R.id.icon);
        title       = itemView.findViewById(R.id.title);
        dummySpace  = itemView.findViewById(R.id.dummyFirstPosition);
    }
    public void bind(final ModelList model){
        img.setImageResource(model.getImg());
        title.setText(model.getTitle());


    }

}