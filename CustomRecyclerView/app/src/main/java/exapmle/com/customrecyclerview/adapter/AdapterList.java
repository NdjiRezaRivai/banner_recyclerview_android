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
import exapmle.com.customrecyclerview.model.ModelList;

/**
 * Created by GITAcerV3 on 5/5/2018.
 */

public class AdapterList extends RecyclerView.Adapter<HolderList> {
    private final List<ModelList> ListData;
    private final Context context;
    private final RecyclerView list;

    public AdapterList(Context context, List<ModelList> ListData, RecyclerView list) {
        this.ListData   = ListData;
        this.context    = context;
        this.list       = list;
    }

    @Override
    public HolderList onCreateViewHolder(final ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());

        // declare view item list
        View list = layoutInflater.inflate(R.layout.item_list, parent, false);

        return new HolderList(list);
    }

    @Override
    public void onBindViewHolder(final HolderList holder, final int position) {
        final ModelList model = ListData.get(position);
        holder.bind(model);


        if(position > 0 ){
            holder.dummySpace.setVisibility(View.GONE);
        }

        // -------------------------------------------------------------------------- uncomment here ----------------------------------------------//

        /*int lastPosition = getItemCount();

        Animation itemAnimation     = AnimationUtils.loadAnimation(context,(position > lastPosition) ? R.anim.fade_in_item : R.anim.fade_out_item);
        holder.itemView.startAnimation(itemAnimation);

        lastPosition = position;*/

        // -------------------------------------------------------------------------- uncomment here ----------------------------------------------//

    }

    @Override
    public int getItemCount() {
        return ListData != null ? ListData.size() : 0;
    }

    @Override
    public void onViewDetachedFromWindow(HolderList holder) {
        super.onViewDetachedFromWindow(holder);
        holder.itemView.clearAnimation();
    }


}