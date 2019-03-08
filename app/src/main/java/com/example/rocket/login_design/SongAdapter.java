package com.example.rocket.login_design;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SearchView;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Locale;

/**
 * Created by Rocket on 7/11/2018.
 */

public class SongAdapter extends RecyclerView.Adapter<SongAdapter.SongHolder> implements Filterable{
  private ArrayList<SongInfo> _songs = new ArrayList<SongInfo>();
 private Context context;
  private OnItemClickListener mOnItemClickListener;




public SongAdapter(Context context,ArrayList<SongInfo> _songs)
{
    this.context = context;
    this._songs = _songs;


}


    public Filter getFilter() {
        return new Filter() {


            @Override
            protected FilterResults performFiltering(CharSequence constraint) {
                FilterResults results = new FilterResults();
                if (constraint == null || constraint.length() == 0) {

                    results.count = _songs.size();
                    results.values = _songs;
                } else {


                    ArrayList<SongInfo> _songs = new ArrayList<SongInfo>();
                    for (SongInfo s : _songs) {
if ( s.getSongName().toLowerCase().contains(constraint)){


}

                    }


                }
                return results;
            }


            @Override
            protected void publishResults(CharSequence constraint, FilterResults results) {

            }
        };
    }


    public  interface OnItemClickListener{
    void  onItemClick(Button b,View v,SongInfo obj,int postion );


}
public void  setOnItemClickListener(final OnItemClickListener mOnItemClickListener)
{
    this.mOnItemClickListener =mOnItemClickListener;


}



    @Override
    public SongHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
    View myview = LayoutInflater.from(context).inflate(R.layout.row_song,viewGroup,false);
    return new SongHolder(myview);

    }

    @Override
    public void onBindViewHolder(final SongHolder holder, final int i) {
    final SongInfo s = _songs.get(i);
        holder.songName.setText(_songs.get(i).getSongName());
        holder.artistName.setText(_songs.get(i).getArtistName());
    holder.btnAction.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            if(mOnItemClickListener!= null)
            {
mOnItemClickListener.onItemClick(holder.btnAction,v,s,i);


            }
        }
    });


    }

    @Override
    public int getItemCount() {
        return _songs.size();
    }
    public void setfilter(ArrayList<SongInfo> listitem)
    {
        _songs=new ArrayList<>();
        _songs.addAll(listitem);
        notifyDataSetChanged();
    }

    public class SongHolder extends RecyclerView.ViewHolder {
    TextView songName,artistName;
    Button btnAction;

        public SongHolder(View itemView) {
            super(itemView);
            songName = (TextView)itemView.findViewById(R.id.tvSongName);
            artistName =(TextView)itemView.findViewById(R.id.tvArtistName);
            btnAction = (Button)itemView.findViewById(R.id.btnAction);
        }
    }
        }







