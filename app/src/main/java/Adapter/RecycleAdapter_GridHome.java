package Adapter;

import android.content.Context;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.wolfsoft1.instasample.R;

import java.util.List;

import ModelClass.HomeGridModelClass;
//import design.ws.com.appstores.R;


/**
 * Created by Rp on 6/14/2016.
 */
public class RecycleAdapter_GridHome extends RecyclerView.Adapter<RecycleAdapter_GridHome.MyViewHolder> {
    Context context;


    private List<HomeGridModelClass> moviesList;


    public class MyViewHolder extends RecyclerView.ViewHolder {


        ImageView image;


        public MyViewHolder(View view) {
            super(view);

            image = (ImageView) view.findViewById(R.id.image);
            //name = (TextView) view.findViewById(R.id.name);


        }

    }


    public RecycleAdapter_GridHome(Context mainActivityContacts, List<HomeGridModelClass> moviesList) {
        this.moviesList = moviesList;
        this.context = mainActivityContacts;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_home_grid_list, parent, false);


        return new MyViewHolder(itemView);


    }


    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
    @Override
    public void onBindViewHolder(final MyViewHolder holder, int position) {
        HomeGridModelClass movie = moviesList.get(position);
        holder.image.setImageResource(movie.getImage());


    }

    @Override
    public int getItemCount() {
        return moviesList.size();
    }


}


