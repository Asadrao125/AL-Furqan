package com.example.asadrao.islamicapp;

import android.content.Context;
import android.media.MediaPlayer;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class CustonMusicAdpter extends BaseAdapter {
    private Context context;
    private int layout;
    private ArrayList<Music> arrayList;
    private MediaPlayer mediaPlayer;
    private boolean flag = true;

    public CustonMusicAdpter(Context context, int layout, ArrayList<Music> arrayList) {
        this.context = context;
        this.layout = layout;
        this.arrayList = arrayList;
    }

    @Override
    public int getCount() {
        return arrayList.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    private class ViewHolder
    {
        TextView txtName, txtSinger;
        ImageView ivPlay;
                //ivStop;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        final ViewHolder viewHolder;
        if (convertView == null)
        {
            viewHolder = new ViewHolder();
            LayoutInflater layoutInflater = (LayoutInflater) context.getSystemService(context.LAYOUT_INFLATER_SERVICE);

            convertView = layoutInflater.inflate(layout,null);
            viewHolder.txtName = (TextView) convertView.findViewById(R.id.txtName);
            viewHolder.txtSinger = (TextView) convertView.findViewById(R.id.txtSinger);
            viewHolder.ivPlay = (ImageView) convertView.findViewById(R.id.ivPlay);
            //viewHolder.ivStop = (ImageView) convertView.findViewById(R.id.ivStop);

            convertView.setTag(viewHolder);
        }
        else
        {
            viewHolder = (ViewHolder) convertView.getTag();
        }
        final Music music = arrayList.get(position);
        viewHolder.txtName.setText(music.getName());
        viewHolder.txtSinger.setText(music.getSinger());

        //play music
        viewHolder.ivPlay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (flag)
                {
                    mediaPlayer = MediaPlayer.create(context,music.getSong());
                    flag = false;
                }
                if (mediaPlayer.isPlaying())
                {
                   /* mediaPlayer.pause();
                    viewHolder.ivPlay.setImageResource(R.drawable.play);*/
                    mediaPlayer.stop();
                    mediaPlayer.release();
                    flag = true;
                    viewHolder.ivPlay.setImageResource(R.drawable.play);
                }
                else
                {
                    mediaPlayer.start();
                    viewHolder.ivPlay.setImageResource(R.drawable.pause);
                }
            }
        });
       /* viewHolder.ivStop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!flag)
                {
                    mediaPlayer.stop();
                    mediaPlayer.release();
                    flag = true;
                }
                viewHolder.ivPlay.setImageResource(R.drawable.play);
            }
        });*/

        return convertView;

    }
}
