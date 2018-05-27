package exapmle.com.customrecyclerview.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;

import java.util.List;

import exapmle.com.customrecyclerview.R;
import exapmle.com.customrecyclerview.holder.HolderList;
import exapmle.com.customrecyclerview.holder.HolderList2;
import exapmle.com.customrecyclerview.model.ModelList;

/**
 * Created by GITAcerV3 on 5/5/2018.
 */

public class AdapterList2 extends RecyclerView.Adapter<HolderList2> {
    private final List<ModelList> ListData;
    private final Context context;
    private final RecyclerView list;

    public AdapterList2(Context context, List<ModelList> ListData, RecyclerView list) {
        this.ListData   = ListData;
        this.context    = context;
        this.list       = list;
    }

    @Override
    public HolderList2 onCreateViewHolder(final ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());

        // declare view item list
        View list = layoutInflater.inflate(R.layout.item_list2, parent, false);

        return new HolderList2(list);
    }

    @Override
    public void onBindViewHolder(final HolderList2 holder, final int position) {
        final ModelList model = ListData.get(position);
        holder.bind(model);

    }

    @Override
    public int getItemCount() {
        return ListData != null ? ListData.size() : 0;
    }


}