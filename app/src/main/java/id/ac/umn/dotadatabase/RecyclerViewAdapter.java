package id.ac.umn.dotadatabase;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder> {

    public static class ViewHolder extends RecyclerView.ViewHolder {
        private ImageView recyclerViewViewListViewIv1;
        private TextView recyclerViewViewListViewTv1;

        public ViewHolder(View view) {
            super(view);
            this.recyclerViewViewListViewIv1 = view.findViewById(R.id.recyclerViewViewListViewIv1);
            this.recyclerViewViewListViewTv1 = view.findViewById(R.id.recyclerViewViewListViewTv1);
        }

        public ImageView getRecyclerViewViewListViewIv1() { return recyclerViewViewListViewIv1; }
        public TextView getRecyclerViewViewListViewTv1() { return recyclerViewViewListViewTv1; }
    }

    protected String[] texts;
    protected int[] imageResourceIds;

    public RecyclerViewAdapter(
            String[] texts,
            int[] imageResourceIds
    ){
        this.texts = texts;
        this.imageResourceIds = imageResourceIds;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.recycler_view_view_list_view, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerViewAdapter.ViewHolder holder, int position) {
        holder.getRecyclerViewViewListViewIv1().setImageResource(imageResourceIds[position]);
        holder.getRecyclerViewViewListViewTv1().setText(texts[position]);
    }

    @Override
    public int getItemCount() {
        return texts.length;
    }
}
