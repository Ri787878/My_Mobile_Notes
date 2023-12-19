package pt.iade.ricardodias.my_mobile_notes.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import pt.iade.ricardodias.my_mobile_notes.R;
import pt.iade.ricardodias.my_mobile_notes.models.NoteItem;

public class NoteItemRowAdapter extends RecyclerView.Adapter<NoteItemRowAdapter.ViewHolder> {
    private ArrayList<NoteItem> notes;
    private LayoutInflater inflater;
    private OnNoteItemClickListener clickListener;
    public NoteItemRowAdapter(Context context, ArrayList<NoteItem> notes){
        inflater = LayoutInflater.from(context);
        this.notes = notes;
        clickListener = null;
    }
    //Sets the click listener for when a user clicks on a note
    public void setClickListener(OnNoteItemClickListener listener){
        clickListener = listener;
    }
    //Inflates the layout for each row
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.row_note_item, parent, false);
        return new ViewHolder(view);
    }
    //Binds the data to the TextViews in each row
    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        NoteItem note = notes.get(position);

        holder.title_label.setText(note.getTitle());
        holder.description_label.setText(note.getContent());
    }
    //Gets the number of rows
    @Override
    public int getItemCount() {
        return notes.size();
    }
    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        public TextView title_label;
        public TextView description_label;
        public ViewHolder(View itemView) {
            super(itemView);

            //Get components from the layout
            title_label = itemView.findViewById(R.id.title_label);
            description_label = itemView.findViewById(R.id.description_label);

            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            if(clickListener != null){
                clickListener.onNoteItemClick(v, getAdapterPosition());
            }

        }
    }
    //Defines what to do when an item is clicked
    public interface OnNoteItemClickListener{
        void onNoteItemClick(View view, int position);

        void onItemClick(View view, int position);
    }
}
